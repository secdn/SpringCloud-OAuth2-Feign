package com.ulegal.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author secdn
 * @create 2018-08-22
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public Object user(Principal user){
        return user;
    }
    @GetMapping("/userDetail")
    public String userDetail(Principal user){
        return user.getName();
    }
}
