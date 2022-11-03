package com.authentication.service.dto;

import java.io.Serializable;

/**
 * @author Artur Tomeyan
 * @date 03/11/2022
 */
public class AuthenticationResponse implements Serializable {

    private String token;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}