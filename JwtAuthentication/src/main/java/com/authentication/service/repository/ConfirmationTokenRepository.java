package com.authentication.service.repository;

import com.authentication.service.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Artur Tomeyan
 * @date 02.01.2023
 */
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Integer> {

    Optional<ConfirmationToken> findConfirmationToken(String confirmationToken);
}