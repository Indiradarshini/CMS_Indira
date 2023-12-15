package com.pennant.cms.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class CMSDaoImpl {
	
	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public CMSDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
