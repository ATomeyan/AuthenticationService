package com.authentication.service.service;

import com.authentication.service.emailcontext.EmailContext;

import javax.mail.MessagingException;

/**
 * @author Artur Tomeyan
 * @date 02.01.2023
 */
public interface EmailService {
    void sendEmail(EmailContext emailContext) throws MessagingException;
}