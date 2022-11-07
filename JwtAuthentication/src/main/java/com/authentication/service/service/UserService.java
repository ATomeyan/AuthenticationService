package com.authentication.service.service;

import com.authentication.service.dto.AuthenticationRequest;
import com.authentication.service.dto.AuthenticationResponse;
import com.authentication.service.dto.RegistrationRequest;
import com.authentication.service.entity.User;

/**
 * @author Artur Tomeyan
 * @date 02/11/2022
 */
public interface UserService {

    User findByUsername(String username);

    void save(RegistrationRequest request);

    AuthenticationResponse login(AuthenticationRequest request);
}