package com.authentication.service.config;

import com.authentication.service.service.impl.DefaultOAuth2UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Artur Tomeyan
 * @date 08/11/2022
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final DefaultOAuth2UserServiceImpl defaultOAuth2UserService;

    public SecurityConfig(DefaultOAuth2UserServiceImpl defaultOAuth2UserService) {
        this.defaultOAuth2UserService = defaultOAuth2UserService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/login", "/oauth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}