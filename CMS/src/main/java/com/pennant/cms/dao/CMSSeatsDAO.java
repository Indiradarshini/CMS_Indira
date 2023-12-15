package com.pennant.cms.dao;

import org.springframework.stereotype.Component;

import com.pennant.cms.models.SeatAvailability;

@Component
public interface CMSSeatsDAO {

	public SeatAvailability getavailability();

}
