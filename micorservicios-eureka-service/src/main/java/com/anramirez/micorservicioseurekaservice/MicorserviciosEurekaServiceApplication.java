package com.anramirez.micorservicioseurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicorserviciosEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicorserviciosEurekaServiceApplication.class, args);
	}

}
