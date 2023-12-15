package com.pennant.cms.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulerSeats {

	public SchedulerSeats() {
		myTask();
	}

	@Scheduled(fixedRate = 120000) // Run every 2 minutes (in milliseconds)
	public void myTask() {
		// Your task logic goes here
		System.out.println("Executing task every 2 minutes");
	}
}