package com.batch.updater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BatchUpdaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchUpdaterApplication.class, args);
	}

}
