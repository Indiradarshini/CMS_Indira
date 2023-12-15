package com.pennant.cms.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pennant.cms.dao.CMSSeatsDAO;
import com.pennant.cms.models.SeatAvailability;

@Component
public class CMSSeatsDAOImpl implements CMSSeatsDAO {

	private final JdbcTemplate jdbcTemplate;
	private SeatAvailability seatAvailability;

	@Autowired
	public CMSSeatsDAOImpl(JdbcTemplate jdbcTemplate, SeatAvailability seatAvailability) {
		this.jdbcTemplate = jdbcTemplate;
		this.seatAvailability = seatAvailability;
	}

	public SeatAvailability getavailability() {
		String query1 = "SELECT COUNT(status) FROM cmsseats WHERE status = 'empty'";
		String query2 = "SELECT COUNT(status) FROM cmsseats WHERE status = 'blocked'";
		String query3 = "SELECT COUNT(status) FROM cmsseats WHERE status = 'reserved'";
		String query4 = "SELECT COUNT(*) FROM cmsseats";

		int countEmpty = jdbcTemplate.queryForObject(query1, Integer.class);
		int countBlocked = jdbcTemplate.queryForObject(query2, Integer.class);
		int countReserved = jdbcTemplate.queryForObject(query3, Integer.class);
		int totalNoOfSeats = jdbcTemplate.queryForObject(query4, Integer.class);

		seatAvailability.setBlocked(countBlocked);
		seatAvailability.setEmpty(countEmpty);
		seatAvailability.setReserved(countReserved);
		seatAvailability.setTotalSeats(totalNoOfSeats);

		return seatAvailability;
	}

}
