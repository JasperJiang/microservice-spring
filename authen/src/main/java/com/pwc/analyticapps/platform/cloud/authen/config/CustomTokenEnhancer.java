package com.pwc.analyticapps.platform.cloud.authen.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component("customTokenEnhancer")
@Log
public class CustomTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> additionalInfo = new HashMap<>();
		additionalInfo.put("verified", true);
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		log.info("====================   "+ accessToken.getValue());
		return accessToken;
	}

}