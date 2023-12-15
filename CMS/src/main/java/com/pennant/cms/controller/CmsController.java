package com.pennant.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pennant.cms.dao.CMSSeatsDAO;
import com.pennant.cms.dao.impl.CMSDaoImpl;
import com.pennant.cms.dao.impl.CMSUserDaoImpl;
import com.pennant.cms.models.Seat;
import com.pennant.cms.models.SeatAvailability;
import com.pennant.cms.models.User;
import com.pennant.cms.scheduler.SchedulerSeats;

@RestController
public class CmsController {

	private CMSUserDaoImpl cMSUserDaoImpl;
	private CMSDaoImpl cMSDaoImpl;
	private CMSSeatsDAO cMSSeatsDAO;


	@Autowired
	public CmsController(CMSUserDaoImpl cMSUserDaoImpl, CMSDaoImpl cMSDaoImpl, CMSSeatsDAO cMSSeatsDAO) {
		this.cMSUserDaoImpl = cMSUserDaoImpl;
		this.cMSDaoImpl = cMSDaoImpl;
		this.cMSSeatsDAO = cMSSeatsDAO;
		SchedulerSeats seatsSchedule = new SchedulerSeats();
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public User admin(@RequestBody User user) {

		User user1 = cMSUserDaoImpl.getUser(user.getUsername(), user.getPassword());

		System.out.println(user1.getName());

		return user1;
	}

	@RequestMapping(value = "/empty", method = RequestMethod.POST)
	public String empty(@RequestBody Seat seat) {

		boolean result = cMSDaoImpl.updateSeatsEmpty(seat.getSeatno());

		return result + " ";

	}

	@RequestMapping(value = "/reserved", method = RequestMethod.POST)
	public String reserved(@RequestBody Seat seat) {

		boolean result = cMSDaoImpl.updateSeatsReserved(seat.getUserid(), seat.getSeatno());

		return result + " ";

	}

	@RequestMapping(value = "/blocked", method = RequestMethod.POST)
	public String blocked(@RequestBody Seat seat) {

		boolean result = cMSDaoImpl.updateSeatsBlocked(seat.getUserid(), seat.getSeatno());

		return result + " ";
	}

	@RequestMapping(value = "/getAllSeats", method = RequestMethod.GET)
	public List<Seat> getAllSeats() {

		List<Seat> result = cMSDaoImpl.getAllSeats();
		
		return result;
		
	}
	
	@RequestMapping(value = "/updateSeatsEmptyOnTimeOver", method = RequestMethod.GET)
	public String updateSeatsEmptyOnTimeOver() {

		boolean result = cMSDaoImpl.updateSeatsEmptyOnTimeOver();

		return result + " ";
	}

	@RequestMapping(value = "/seatAvailability", method = RequestMethod.GET)
	public SeatAvailability status() {
		SeatAvailability seatAvail = cMSSeatsDAO.getavailability();
		return seatAvail;

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void seats() {

	}

}
