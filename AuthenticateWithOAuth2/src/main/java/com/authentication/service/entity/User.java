package com.authentication.service.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author Artur Tomeyan
 * @date 15/11/2022
 */
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 2)
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min = 8, max = 12)
    @Column(name = "password")
    private String password;

    @Column
    private Boolean isEnabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserRoles> userRoles;
}