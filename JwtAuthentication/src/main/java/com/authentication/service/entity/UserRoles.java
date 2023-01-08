package com.authentication.service.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Artur Tomeyan
 * @date 02.01.2023
 */
@Data
@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;
}