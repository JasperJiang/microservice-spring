package com.jasper.web;

import com.jasper.client.ResourceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jjiang153 on 2017/4/25.
 */

@RestController
public class MainController {

    @Autowired
    ResourceClient resourceClient;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return resourceClient.index();
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String test2(){
        return "22222";
    }


}
