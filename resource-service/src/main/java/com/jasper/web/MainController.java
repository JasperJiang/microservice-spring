package com.jasper.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jjiang153 on 2017/4/27.
 */

@RestController
public class MainController {
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(){
        return "SUCCESS!!!";
    }
}
