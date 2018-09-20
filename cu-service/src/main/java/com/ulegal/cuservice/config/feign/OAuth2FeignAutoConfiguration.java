package com.ulegal.cuservice.config.feign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

/**
 * @author secdn
 * @create 2018-08-22
 */
@Configuration
public class OAuth2FeignAutoConfiguration {

    //   作为个Client读Properties获取Token 用
//    @Bean
//    public RequestInterceptor oauth2FeignRequestInterceptor(@Qualifier("secdnOAuth2RestTemplate") OAuth2RestTemplate oAuth2RestTemplate) {
//        return new OAuth2FeignRequestInterceptor(oAuth2RestTemplate);
//    }

    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor();
    }
}
