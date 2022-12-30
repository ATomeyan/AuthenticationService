package com.authentication.service.repository;

import com.authentication.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Artur Tomeyan
 * @date 18/11/2022
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}