package com.pennant.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pennant.cms.dao.CMSDao;
import com.pennant.cms.dao.CMSSeatsDAO;
import com.pennant.cms.dao.CMSUserDao;
import com.pennant.cms.models.AuthUser;
import com.pennant.cms.models.Seat;
import com.pennant.cms.models.SeatAvailability;
import com.pennant.cms.models.User;

@RestController
public class CmsController {

	private CMSUserDao cMSUserDao;
	private CMSDao cMSDao;
	private CMSSeatsDAO cMSSeatsDAO;

	@Autowired
	public CmsController(CMSUserDao cMSUserDaoImpl, CMSDao cMSDao, CMSSeatsDAO cMSSeatsDAO) {
		this.cMSUserDao = cMSUserDaoImpl;
		this.cMSDao = cMSDao;
		this.cMSSeatsDAO = cMSSeatsDAO;
	}

	@CrossOrigin
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User admin(@RequestBody AuthUser user) {

		User user1 = cMSUserDao.getUser(user.getUsername(), user.getPassword());

		if (user1 != null) {
			System.out.println(user1.toString());
			return user1;
		}
		return new User();
	}

	@CrossOrigin
	@RequestMapping(value = "/empty", method = RequestMethod.POST)
	public String empty(@RequestBody Seat seat) {

		boolean result1 = cMSDao.updateSeatsEmpty(seat.getUserid());
		boolean result2 = false;
		if (result1)
			result2 = cMSDao.emptyUserUpdate(seat.getUserid());
		return (result1 && result2) + " ";

	}

	@CrossOrigin
	@RequestMapping(value = "/reserved", method = RequestMethod.POST)
	public String reserved(@RequestBody Seat seat) {
		System.out.println(seat.getUserid());
		boolean result1 = cMSDao.updateSeatsReserved(seat.getUserid());
		boolean result2 = false;
		if (result1)
			result2 = cMSDao.reservedUserUpdate(seat.getUserid());
		System.out.println(result1 && result2);
		return (result1 && result2) + " ";

	}

	@CrossOrigin
	@RequestMapping(value = "/blocked", method = RequestMethod.POST)
	public String blocked(@RequestBody Seat seat) {

		boolean result1 = cMSDao.updateSeatsBlocked(seat.getUserid(), seat.getSeatno());
		boolean result2 = false;
		if (result1)
			result2 = cMSDao.blockedUserUpdate(seat.getUserid(), seat.getSeatno());
		return (result1 && result2) + " ";
	}

	@CrossOrigin
	@RequestMapping(value = "/getAllSeats", method = RequestMethod.GET)
	public List<Seat> getAllSeats() {

		List<Seat> result = cMSDao.getAllSeats();

		return result;

	}

	@CrossOrigin
	@RequestMapping(value = "/updateSeatsEmptyOnTimeOver", method = RequestMethod.GET)
	public String updateSeatsEmptyOnTimeOver() {

		boolean result = cMSDao.updateSeatsEmptyOnTimeOver();

		return result + " ";
	}

	@CrossOrigin
	@RequestMapping(value = "/seatAvailability", method = RequestMethod.GET)
	public SeatAvailability status() {
		SeatAvailability seatAvail = cMSSeatsDAO.getavailability();
		return seatAvail;

	}
}
