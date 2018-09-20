package com.ulegal.cuservice.config.feign;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author secdn
 * @create 2018-08-22
 */
@Data
@ConfigurationProperties(prefix = "ulegal.oauth2.client")
public class OAuth2ClientProperties {
    private String id;
    private String accessTokenUrl;
    private String clientId;
    private String clientSecret;
    private String clientAuthenticationScheme;
}

