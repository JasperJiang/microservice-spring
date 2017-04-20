package com.jasper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		System.setProperty("ENCRYPT_KEY", "sljdIWD21WIokkns23S9fosSDcm3aDdf");
		System.setProperty("encrypt.key", "sljdIWD21WIokkns23S9fosSDcm3aDdf");
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ConfigServerApplication.class);
	}
}
