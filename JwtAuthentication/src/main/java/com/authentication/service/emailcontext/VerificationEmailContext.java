package com.authentication.service.emailcontext;

import com.authentication.service.entity.User;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Artur Tomeyan
 * @date 02.01.2023
 */
public class VerificationEmailContext extends EmailContext {

    private String token;

    @Override
    public <T> void init(T context) {
        User user = (User) context;
        put("firstName", user.getFirstName());
        setTemplateLocation("emails/email-verification");
        setSubject("Complete your registration");
        setFrom("auth.service@dev.com");
        setTo(user.getEmail());
    }

    public void setToken(String token) {
        this.token = token;
        put("token", token);
    }

    public void buildVerificationUrl(String baseUrl, String token) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .path("/register/verify").queryParam("token", token).toUriString();

        put("verificationURL", url);
    }
}