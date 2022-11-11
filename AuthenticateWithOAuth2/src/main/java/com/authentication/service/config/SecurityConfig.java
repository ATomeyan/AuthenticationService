package com.authentication.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Artur Tomeyan
 * @date 08/11/2022
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                    .authorizeRequests()
                        .antMatchers(HttpMethod.GET, "/test/admin/**").hasRole("ADMIN")
                    .anyRequest()
                        .authenticated()
                .and()
                    .oauth2ResourceServer()
                        .jwt();

        return http.build();
    }
}