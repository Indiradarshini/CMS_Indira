package com.pennant.cms.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pennant.cms.dao.CMSDao;

@Component
@EnableScheduling
public class SchedulerSeats {

	private CMSDao cMSDao;

	public SchedulerSeats(CMSDao cMSDao) {
		this.cMSDao = cMSDao;
		myTask();
	}

	@Scheduled(fixedRate = 120000) // Run every 2 minutes (in milliseconds)
	public void myTask() {
		// Your task logic goes here
		System.out.println("Executing task every 2 minutes");
		boolean result1 = cMSDao.updateSeatsEmptyOnTimeOver();
		boolean result2 = false;
		if (result1)
			result2 = cMSDao.emptyUserUpdateOnTimeOver();
		System.out.println(result1 && result2);
	}
}