package com.jasper.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by jjiang153 on 2017/4/25.
 */
@Configuration
@EnableWebSecurity
public class AuthWebConfig extends WebSecurityConfigurerAdapter {

    private static final String[] NON_SECURED_URLS = { "/swagger-resources/**", "/v2/api-docs", "/webjars/**",
            "/swagger-ui.html", "/index.html" };

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(NON_SECURED_URLS);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable()
                .anonymous().disable();
        http.authorizeRequests()
                .antMatchers(NON_SECURED_URLS).permitAll();
    }

}
