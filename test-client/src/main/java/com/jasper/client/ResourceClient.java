package com.jasper.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jjiang153 on 2017/4/27.
 */
@FeignClient(value = "resource-service", url = "http://localhost:7070")
public interface ResourceClient {
    @RequestMapping(value = "index",method = RequestMethod.GET)
    String index();
}
