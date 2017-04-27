package com.jasper.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import java.util.Collections;

/**
 * Created by jjiang153 on 2017/4/27.
 */
@Configuration
public class OAuthClientConfig {

    @Autowired
    private Properties properties;

    public OAuth2ProtectedResourceDetails oauth2RemoteResource() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setAccessTokenUri(properties.getOauth2url());
        details.setClientId(properties.getClientId());
        details.setClientSecret(properties.getSecret());
        details.setScope(Collections.singletonList(properties.getScope()));
        return details;
    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), oauth2RemoteResource());
    }
}
