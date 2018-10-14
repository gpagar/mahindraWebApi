package com.ganesh.mahindra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages={"com.ganesh.mahindra"})
@EnableScheduling
public class MahindraWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MahindraWebApiApplication.class, args);
	}
}
