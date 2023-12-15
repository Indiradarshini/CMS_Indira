package com.pennant.cms.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pennant.cms.dao.CMSUserDao;
import com.pennant.cms.models.User;

@Repository
public class CMSUserDaoImpl implements CMSUserDao {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public CMSUserDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User getUser(String username, String password) {

		String query = "SELECT * FROM cmsusers WHERE username = :username AND password = :password";

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("username", username);
		parameters.addValue("password", password);

		RowMapper<User> rowMapper = (resultSet, rowNum) -> {
			User user = new User();

			user.setId(resultSet.getLong("id"));
			user.setUserid(resultSet.getLong("userid"));
			user.setUsername(resultSet.getString("username"));
			user.setName(resultSet.getString("name"));
			user.setPassword(resultSet.getString("password"));

			return user;
		};

		List<User> users = jdbcTemplate.query(query, parameters, rowMapper);

		if (!users.isEmpty()) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean isExisting(String username) {
		String query = "SELECT count(*) FROM cmsusers WHERE username = :username";

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("username", username);

		int count = jdbcTemplate.queryForObject(query, parameters, Integer.class);

		return count > 0;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	

//	public void saveOTP(long userid, long otp) {
//		
//		String query = "insert into cmsuser set otp = :otp where userid = :userid";
//	}

	

//    @Override
//    public void saveOTP(long userid, long otp) {
//        String query = "UPDATE cmsuser SET otp = :otp WHERE userid = :userid";
//
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//        parameters.addValue("otp", otp);
//        parameters.addValue("userid", userid);
//
//        jdbcTemplate.update(query, parameters);
//    }
    
}
