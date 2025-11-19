package com.gicwhorkshop.day9_24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Day924Application {

	public static void main(String[] args) {
		SpringApplication.run(Day924Application.class, args);
	}

}
