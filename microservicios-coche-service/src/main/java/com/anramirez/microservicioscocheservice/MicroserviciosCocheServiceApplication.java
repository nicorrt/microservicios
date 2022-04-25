package com.anramirez.microservicioscocheservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviciosCocheServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCocheServiceApplication.class, args);
	}

}
