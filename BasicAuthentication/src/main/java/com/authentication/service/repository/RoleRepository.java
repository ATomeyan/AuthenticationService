package com.authentication.service.repository;

import com.authentication.service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Artur Tomeyan
 * @date 01/11/2022
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}