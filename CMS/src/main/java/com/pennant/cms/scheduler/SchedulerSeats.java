package com.pennant.cms.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pennant.cms.dao.impl.CMSDaoImpl;

@Component
@EnableScheduling
public class SchedulerSeats {

	
	private CMSDaoImpl cMSDaoImpl;

	public SchedulerSeats(CMSDaoImpl cMSDaoImpl) {
		this.cMSDaoImpl = cMSDaoImpl;
		myTask();
	}

	@Scheduled(fixedRate = 120000) // Run every 2 minutes (in milliseconds)
	public void myTask() {
		// Your task logic goes here
		System.out.println("Executing task every 2 minutes");
		boolean result = cMSDaoImpl.updateSeatsEmptyOnTimeOver();
		System.out.println(result);
	}
}