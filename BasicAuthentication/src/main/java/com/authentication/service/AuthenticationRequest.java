package com.authentication.service;

import java.io.Serializable;

/**
 * @author Artur Tomeyan
 * @date 01/11/2022
 */
public class AuthenticationRequest implements Serializable {

    private String userName;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
