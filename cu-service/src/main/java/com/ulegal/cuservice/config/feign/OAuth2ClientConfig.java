package com.ulegal.cuservice.config.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

/**
 * @author secdn
 * @create 2018-08-22
 */
@Configuration
@EnableConfigurationProperties(OAuth2ClientProperties.class)
public class OAuth2ClientConfig {
    @Autowired
    private OAuth2ClientProperties oAuth2ClientProperties;

    @Bean("secdnClientCredentialsResourceDetails")
    public ClientCredentialsResourceDetails resourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setId(oAuth2ClientProperties.getId());
        details.setAccessTokenUri(oAuth2ClientProperties.getAccessTokenUrl());
        details.setClientId(oAuth2ClientProperties.getClientId());
        details.setClientSecret(oAuth2ClientProperties.getClientSecret());
        details.setAuthenticationScheme(AuthenticationScheme.valueOf(oAuth2ClientProperties.getClientAuthenticationScheme()));
        return details;
    }

    @Bean("secdnOAuth2RestTemplate")
    public OAuth2RestTemplate oAuth2RestTemplate() {
        final OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(resourceDetails(), new DefaultOAuth2ClientContext());
        oAuth2RestTemplate.setRequestFactory(new Netty4ClientHttpRequestFactory());
        return oAuth2RestTemplate;

    }
}
