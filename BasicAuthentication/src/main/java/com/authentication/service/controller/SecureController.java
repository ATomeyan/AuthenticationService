package com.authentication.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Artur Tomeyan
 * @date 31/10/2022
 */
@RestController
public class SecureController {

    @GetMapping("/secure")
    public String secure(){
        return "Accessing";
    }

    @GetMapping("/login")
    public String login(){
        return "logged in";
    }
}