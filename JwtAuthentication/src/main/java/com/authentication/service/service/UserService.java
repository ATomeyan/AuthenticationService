package com.authentication.service.service;

import com.authentication.service.entity.User;

/**
 * @author Artur Tomeyan
 * @date 02/11/2022
 */
public interface UserService {

    User findByUsername(String username);

    void save(User user);

    User findByUsernameAndPassword(String username, String password);
}