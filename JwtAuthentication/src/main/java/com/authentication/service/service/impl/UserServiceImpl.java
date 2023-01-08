package com.authentication.service.service.impl;

import com.authentication.service.config.jwt.JwtProvider;
import com.authentication.service.dto.AuthenticationRequest;
import com.authentication.service.dto.AuthenticationResponse;
import com.authentication.service.dto.RegistrationRequest;
import com.authentication.service.entity.Role;
import com.authentication.service.entity.User;
import com.authentication.service.repository.RoleRepository;
import com.authentication.service.repository.UserRepository;
import com.authentication.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

/**
 * @author Artur Tomeyan
 * @date 03/11/2022
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider provider;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtProvider provider) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.provider = provider;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void save(RegistrationRequest request) {

        User user = new User();

        Role role = roleRepository.findByName("ROLE_USER");

        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.getUserRoles().stream().iterator().next().setRole(role);

        userRepository.save(user);
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        User user = userRepository.findByUsername(request.getUsername()).orElse(null);
        String token = provider.tokenGenerator(request.getUsername());


        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthenticationResponse(token);
        }

        return null;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.isAuthenticated()) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
    }
}