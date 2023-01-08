package com.authentication.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Artur Tomeyan
 * @date 02/11/2022
 */
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column
    private boolean isEnabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserRoles> userRoles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserToken userToken;
}