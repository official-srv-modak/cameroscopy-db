package com.modakdev.cameroscopy.cameroscopydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CameroscopyDbApplication {

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RoughApplication.class);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(CameroscopyDbApplication.class, args);
	}

}
