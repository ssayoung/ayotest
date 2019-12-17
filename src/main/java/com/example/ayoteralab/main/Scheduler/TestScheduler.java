package com.example.ayoteralab.main.Scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {
	
	final Logger L = LoggerFactory.getLogger(this.getClass());
	
	@Scheduled(cron = "1 * * * * ?")
	public void testCron1() {
		L.info("[START] testCron1 - System");
		
		long a = 0L;
		for(long i=0; i<10000000000L; i++) {
			a += i;
		}
		
		L.info("[END] testCron1 - System");
	}
	
	@Scheduled(cron = "1 * * * * ?")
	public void testCron2() {
		L.info("[START] testCron2 - System");
		
		long a = 0L;
		for(long i=0; i<10000000000L; i++) {
			a += i;
		}
		
		L.info("[END] testCron2 - System");
	}

}
