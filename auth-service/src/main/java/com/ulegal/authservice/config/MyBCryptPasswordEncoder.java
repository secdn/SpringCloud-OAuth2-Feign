package com.ulegal.authservice.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author secdn
 * @create 2018-08-23
 */
public class MyBCryptPasswordEncoder extends BCryptPasswordEncoder {
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String presentedPassword =passwordEncoder.encode(encodedPassword);
        return passwordEncoder.matches(rawPassword, presentedPassword);
    }
}

