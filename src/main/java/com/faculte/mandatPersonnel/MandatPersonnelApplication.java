package com.faculte.mandatPersonnel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MandatPersonnelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MandatPersonnelApplication.class, args);
	}

}
