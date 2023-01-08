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
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserRoles> userRoles;
}