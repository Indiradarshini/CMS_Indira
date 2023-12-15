package com.pennant.cms.dao.impl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pennant.cms.dao.CMSDao;
import com.pennant.cms.models.Seat;
import com.pennant.cms.models.User;

@Repository
public class CMSDaoImpl implements CMSDao {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public CMSDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean updateSeatsBlocked(long userid, int seatno) {
		String sql = "Update cmsseats set userid= :userid, blockedtime = :blockedtime, status = :status where seatno = :seatno";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userid", userid);
		params.addValue("blockedtime", java.sql.Timestamp.from(java.time.Instant.now()));
		params.addValue("status", "blocked");
		params.addValue("seatno", seatno);
		int count = jdbcTemplate.update(sql, params);
		if (count == 1) {
			return true;
		}
		return false;
	}

	public boolean updateSeatsReserved(long userid, int seatno) {
		String sql = "Update cmsseats set userid= :userid, blockedtime = :blockedtime, status = :status where seatno = :seatno";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userid", userid);
		params.addValue("blockedtime", java.sql.Timestamp.from(java.time.Instant.now()));
		params.addValue("status", "reserved");
		params.addValue("seatno", seatno);
		int count = jdbcTemplate.update(sql, params);
		if (count == 1) {
			return true;
		}
		return false;

	}

	public boolean updateSeatsEmpty(int seatno) {
		String sql = "Update cmsseats set userid= :userid, blockedtime = :blockedtime, status = :status where seatno = :seatno";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userid", null, Types.INTEGER);
		params.addValue("blockedtime", null, Types.TIMESTAMP);
		params.addValue("status", "empty");
		params.addValue("seatno", seatno);
		int count = jdbcTemplate.update(sql, params);
		if (count == 1) {
			return true;
		}
		return false;

	}

	public boolean updateSeatsEmptyOnTimeOver() {
		String sql = "UPDATE cmsseats SET userid = :userid, blockedtime = :blockedtime, status = :status WHERE status = 'blocked' and (blockedtime IS NULL OR (CURRENT_TIMESTAMP - blockedtime) > INTERVAL '5 minutes')";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userid", null, Types.INTEGER);
		params.addValue("blockedtime", null, Types.TIMESTAMP);
		params.addValue("status", "empty");

		int count = jdbcTemplate.update(sql, params);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getBlockedCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFreeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean bookSeat() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Seat> getAllSeats() {
		String sql = "Select * from cmsseats order by status";

		RowMapper<Seat> rowMapper = (resultSet, rowNum) -> {
			Seat seat = new Seat();

			seat.setId(resultSet.getLong("id"));
			seat.setSeatno(resultSet.getInt("seatno"));
			seat.setUserid(resultSet.getLong("userid"));
			seat.setStatus(resultSet.getString("status"));
			seat.setBlockedtime(resultSet.getDate("blockedtime"));

			return seat;
		};

		List<Seat> seat = jdbcTemplate.query(sql, rowMapper);

		if (!seat.isEmpty()) {
			return seat;
		}

		return null;
	}

}
