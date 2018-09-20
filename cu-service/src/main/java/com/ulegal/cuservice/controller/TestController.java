package com.ulegal.cuservice.controller;

import com.ulegal.cuservice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author secdn
 * @create 2018-08-23
 */
@RestController
public class TestController {


    @Autowired
    TestService testService;


    @RequestMapping("/getUserName")
    public String getUserName (){
        String userName = testService.getUserName();
        return userName;
    }

    @RequestMapping("/getUser")
    public Object getUserObject (){
        Object user = testService.getUser();
        return user;
    }
}
