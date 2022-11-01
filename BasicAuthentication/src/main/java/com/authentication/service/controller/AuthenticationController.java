package com.authentication.service.controller;

import com.authentication.service.AuthenticationRequest;
import com.authentication.service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Artur Tomeyan
 * @date 31/10/2022
 */
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest request) {

        String login = userService.login(request);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }
}