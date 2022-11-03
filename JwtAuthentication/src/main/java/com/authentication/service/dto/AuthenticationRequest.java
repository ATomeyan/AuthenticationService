package com.authentication.service.dto;

import java.io.Serializable;

/**
 * @author Artur Tomeyan
 * @date 03/11/2022
 */
public class AuthenticationRequest implements Serializable {

    private String username;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}