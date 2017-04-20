package com.pwc.analyticapps.platform.cloud.authen.config;

import java.security.KeyPair;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
@EnableAuthorizationServer
public class AuthConfig extends AuthorizationServerConfigurerAdapter {

	// @Autowired
	// private AuthenticationManager authenticationManager;

	@Autowired
	private KeyStoreInfo keyStoreInfo;

	@Autowired
	private ClientProperty appProps;

	@Autowired
	@Qualifier("customTokenEnhancer")
	private TokenEnhancer tokenEnhancer;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		final InMemoryClientDetailsServiceBuilder clientDetailsBuilder = clients.inMemory();

		appProps.getOauth2Clients().forEach(oauth2Client -> {
			try {
				clientDetailsBuilder.withClient(oauth2Client.getId()).resourceIds(oauth2Client.getResourceIds())
						.secret(oauth2Client.getSecret()).autoApprove(oauth2Client.isAutoApprove())
						.authorizedGrantTypes(oauth2Client.getAuthorizedGrantTypes()).scopes(oauth2Client.getScopes())
						.accessTokenValiditySeconds(oauth2Client.getTokenValidatePeriod());

			} catch (Exception e) {
				throw new IllegalArgumentException("Error building the clients ", e);
			}
		});
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		KeyPair keyPair = new KeyStoreKeyFactory(new ClassPathResource(keyStoreInfo.getKeystoreName()),
				keyStoreInfo.getKeystorePincode().toCharArray()).getKeyPair(keyStoreInfo.getKeyEntryName());
		converter.setKeyPair(keyPair);
		return converter;
	}

	@Bean
	@Primary
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("permitAll()");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(this.tokenEnhancer, jwtAccessTokenConverter()));

		endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain);
	}
	
	@Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

}
