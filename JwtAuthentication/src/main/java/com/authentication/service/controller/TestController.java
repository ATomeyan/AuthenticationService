package com.authentication.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Artur Tomeyan
 * @date 03/11/2022
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/user")
    public String user() {
        return "User accessed";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin accessed";
    }
}