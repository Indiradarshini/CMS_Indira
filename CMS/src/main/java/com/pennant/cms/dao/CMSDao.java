package com.pennant.cms.dao;

import java.util.List;

import com.pennant.cms.models.Seat;

public interface CMSDao {

	boolean updateSeatsReserved(long userid);

	public boolean blockedUserUpdate(long userid, int seatno);

	boolean reservedUserUpdate(long userid);

	boolean updateSeatsEmpty(long userid);

	boolean emptyUserUpdate(long userid);

	boolean updateSeatsEmptyOnTimeOver();

	boolean emptyUserUpdateOnTimeOver();

	List<Seat> getAllSeats();

	boolean updateSeatsBlocked(long userid, int seatno);

}
