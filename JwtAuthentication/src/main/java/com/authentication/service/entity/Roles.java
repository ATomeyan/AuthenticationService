package com.authentication.service.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Artur Tomeyan
 * @date 04/11/2022
 */
public enum Roles implements GrantedAuthority {

    ADMIN(Code.ADMIN),
    USER(Code.USER);

    private final String authority;

    Roles(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public static class Code{
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String USER = "ROLE_USER";

        private Code(){}
    }
}