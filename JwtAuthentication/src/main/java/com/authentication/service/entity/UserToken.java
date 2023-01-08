package com.authentication.service.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Artur Tomeyan
 * @date 02.01.2023
 */
@Data
@Entity
@Table(name = "user_token")
public class UserToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "token_id", referencedColumnName = "id")
    private ConfirmationToken confirmationToken;
}