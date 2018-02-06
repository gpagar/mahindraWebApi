package com.ganesh.mahindra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.ganesh.mahindra"})
public class MahindraWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MahindraWebApiApplication.class, args);
	}
}
