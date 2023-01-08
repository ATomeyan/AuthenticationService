package com.authentication.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Artur Tomeyan
 * @date 02.01.2023
 */
@Data
@Entity
@Table(name = "confirmation_token")
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "token")
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToOne(mappedBy = "confirmationToken")
    private UserToken userToken;
}