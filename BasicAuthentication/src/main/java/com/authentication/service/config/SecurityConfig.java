package com.authentication.service.config;

import com.authentication.service.handler.AuthFailureHandler;
import com.authentication.service.handler.LogoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author Artur Tomeyan
 * @date 31/10/2022
 */
@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder().encode("userPass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/secure/**")
                .hasRole("USER")
                .antMatchers("/anonymous*")
                .anonymous()
                .antMatchers("/login/*")
                .permitAll()
                .anyRequest()
                .authenticated();
//                .and()
//                .formLogin()
//                .loginPage("login.html")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/homepage.html", true)
//                .failureForwardUrl("/login.html?error=true")
//                .failureHandler(failHandler())
//                .and()
//                .logout()
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSSESIONID")
//                .logoutSuccessHandler(logOutHandler());

        return http.build();
    }

    @Bean
    public AuthenticationFailureHandler failHandler() {
        return new AuthFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler logOutHandler() {
        return new LogoutHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}