package com.ulegal.cuservice.service;

//import com.ulegal.cuservice.config.feign.OAuth2FeignAutoConfiguration;
import com.ulegal.cuservice.config.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * @author secdn
 * @create 2018-08-23
 */

@FeignClient(name = "auth-service",configuration = {OAuth2FeignAutoConfiguration.class})
public interface TestService {
    @RequestMapping(value = "/userDetail",method = RequestMethod.GET)
    String getUserName();

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    String getUser();
}
