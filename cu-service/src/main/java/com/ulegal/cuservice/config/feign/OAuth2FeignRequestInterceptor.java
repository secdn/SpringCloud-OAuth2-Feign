package com.ulegal.cuservice.config.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.Assert;

/**
 * @author secdn
 * @create 2018-08-22
 */
public class OAuth2FeignRequestInterceptor implements RequestInterceptor {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String BEARER_TOKEN_TYPE = "Bearer";

//    private final OAuth2RestTemplate oAuth2RestTemplate;


//    public OAuth2FeignRequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
//        Assert.notNull(oAuth2RestTemplate, "Context can not be null");
//        this.oAuth2RestTemplate = oAuth2RestTemplate;
//    }

//    @Override
//    public void apply(RequestTemplate template) {

//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        String token = null;
//        if( securityContext != null ){
//
//            Authentication auth = (Authentication) securityContext.getAuthentication();
//            token = ( (OAuth2AuthenticationDetails) auth.getDetails()).getTokenValue() ;
//
//        }
    //   作为个Client读Properties获取Token 用
//        LOGGER.debug("Constructing Header {} for Token {}", AUTHORIZATION_HEADER, BEARER_TOKEN_TYPE);
//        template.header(AUTHORIZATION_HEADER,
//                String.format("%s %s",
//                        BEARER_TOKEN_TYPE,
//                        oAuth2RestTemplate.getAccessToken().toString()));
//        template.header(AUTHORIZATION_HEADER,
//                String.format("%s %s",
//                        BEARER_TOKEN_TYPE,
//                        token));
//
//    }
    //resource服务器获取当前Token，互相调用时使用
    @Override
    public void apply(RequestTemplate template) {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        String token = null;
        if( securityContext != null ){

            Authentication auth =  securityContext.getAuthentication();
            token = ( (OAuth2AuthenticationDetails) auth.getDetails()).getTokenValue() ;

        }
        template.header(AUTHORIZATION_HEADER,
                String.format("%s %s",
                        BEARER_TOKEN_TYPE,
                        token));

    }
}
