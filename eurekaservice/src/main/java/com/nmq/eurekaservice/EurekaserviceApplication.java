package com.nmq.eurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.nmq.*")
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserviceApplication.class, args);
	}
}
