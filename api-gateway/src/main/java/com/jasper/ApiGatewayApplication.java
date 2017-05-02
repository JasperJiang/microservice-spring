package com.jasper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ApiGatewayApplication {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@PostConstruct
	public void terminateApplication() {
		System.out.println("=================  " + this.discoveryClient.getServices());
		if (this.discoveryClient.getServices().isEmpty()
				|| !this.discoveryClient.getServices().contains("config-service")) {
			initiateShutdown(-1);
		}
	}

	private void initiateShutdown(int returnCode) {
		SpringApplication.exit(appContext, () -> returnCode);
	}
}
