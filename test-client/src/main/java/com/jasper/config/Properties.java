package com.jasper.config;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by jjiang153 on 2017/4/27.
 */
@Getter
@Setter
@Slf4j
@Component
@ToString
public class Properties {
    @Value("${app.oauth2.accesstokenUrl}")
    private String oauth2url;

    @Value("${app.oauth2.common.clientId}")
    private String clientId;

    @Value("${app.oauth2.common.secret}")
    private String secret;

    @Value("${app.oauth2.common.scope}")
    private String scope;

    @PostConstruct
    private void init() {
        log.info("**************************************************\n" +
                "App. Props \n" + this +
                "**************************************************\n");
    }
}
