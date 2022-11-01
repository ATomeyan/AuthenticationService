package com.authentication.service.service.impl;

import com.authentication.service.AuthenticationRequest;
import com.authentication.service.entity.Role;
import com.authentication.service.entity.User;
import com.authentication.service.repository.RoleRepository;
import com.authentication.service.repository.UserRepository;
import com.authentication.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Artur Tomeyan
 * @date 01/11/2022
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String login(AuthenticationRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();


        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }
}