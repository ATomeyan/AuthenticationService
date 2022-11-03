package com.authentication.service.controller;

import com.authentication.service.config.jwt.JwtProvider;
import com.authentication.service.dto.AuthenticationRequest;
import com.authentication.service.dto.AuthenticationResponse;
import com.authentication.service.dto.RegistrationRequest;
import com.authentication.service.entity.User;
import com.authentication.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Artur Tomeyan
 * @date 03/11/2022
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;
    private final JwtProvider provider;

    @Autowired
    public AuthenticationController(UserService userService, JwtProvider provider) {
        this.userService = userService;
        this.provider = provider;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerRequest(@RequestBody RegistrationRequest registrationRequest) {
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(registrationRequest.getPassword());

        userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) {
        User user = userService.findByUsernameAndPassword(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        String token = provider.tokenGenerator(user.getUsername());

        return new ResponseEntity<>(new AuthenticationResponse(token), HttpStatus.OK);
    }
}