package com.pennant.cms.dao;

import java.util.List;

import com.pennant.cms.models.Seat;

public interface CMSDao {

	boolean updateSeatsReserved(long userid, int seatno);

	boolean updateSeatsEmpty(int seatno);

	boolean updateSeatsEmptyOnTimeOver();

	List<Seat> getAllSeats();

	boolean updateSeatsBlocked(long userid, int seatno);

}
