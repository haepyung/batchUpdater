package com.batch.updater.schedule;

import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SelectSchedule {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Scheduled(cron = "*/30 * * * * ?")
	public void run()
	{
		logger.info("BATCH UPDATE START::" + LocalTime.now());
		System.out.println("BATCH UPDATE START::");
		logger.info("BATCH UPDATE END::" + LocalTime.now());
		System.out.println("BATCH UPDATE END::");
	}
}
