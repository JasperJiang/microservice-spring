package com.pwc.analyticapps.platform.cloud.authen.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "app")
@Setter
@Getter
public class ClientProperty {

	private List<Oauth2Clients> oauth2Clients = new ArrayList<>();

	@Getter
	@Setter
	public static class Oauth2Clients {

		private String id;

		private String[] resourceIds;

		private String secret;

		private boolean autoApprove;

		private String[] authorizedGrantTypes;

		private String[] scopes;
		
		private int tokenValidatePeriod;
	}
}