package com.authentication.service.service;

import com.authentication.service.AuthenticationRequest;
import com.authentication.service.entity.User;

/**
 * @author Artur Tomeyan
 * @date 01/11/2022
 */
public interface UserService {

    String login(AuthenticationRequest request);

    User findByUserName(String userName);
}