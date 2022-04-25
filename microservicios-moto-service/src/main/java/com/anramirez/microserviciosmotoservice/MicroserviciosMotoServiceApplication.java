package com.anramirez.microserviciosmotoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviciosMotoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosMotoServiceApplication.class, args);
	}

}
