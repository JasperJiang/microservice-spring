package com.pwc.analyticapps.platform.cloud.authen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenApplication {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(AuthenApplication.class, args);
	}
}
