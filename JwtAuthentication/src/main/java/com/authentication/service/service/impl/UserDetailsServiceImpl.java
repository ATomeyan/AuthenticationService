package com.authentication.service.service.impl;

import com.authentication.service.config.UserDetailsImpl;
import com.authentication.service.entity.User;
import com.authentication.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Artur Tomeyan
 * @date 03/11/2022
 */
@Component
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        Set<SimpleGrantedAuthority> role = new HashSet<>(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), role);
//        return new UserDetailsImpl(user);
    }
}