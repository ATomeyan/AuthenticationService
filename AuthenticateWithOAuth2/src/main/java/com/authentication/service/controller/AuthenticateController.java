package com.authentication.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Artur Tomeyan
 * @date 18/11/2022
 */
@RestController
public class AuthenticateController {

    @GetMapping("/")
    public String testHello(){
        return "Hello";
    }

    @GetMapping("/authenticated")
    public String testAuth(){
        return "Authenticated";
    }
}