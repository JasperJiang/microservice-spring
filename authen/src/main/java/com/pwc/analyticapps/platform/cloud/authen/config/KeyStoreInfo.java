package com.pwc.analyticapps.platform.cloud.authen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "keystore")
@Setter
@Getter
public class KeyStoreInfo {

	private String keystoreName;

	private String keystorePincode;

	private String keyEntryName;
}
