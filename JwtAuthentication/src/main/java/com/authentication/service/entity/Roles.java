package com.authentication.service.entity;

/**
 * @author Artur Tomeyan
 * @date 04/11/2022
 */
public enum Roles {

    ADMIN("ROLE_ADMIN", 1),
    USER("ROLE_USER", 2);

    private final String role;
    private final Integer code;

    Roles(String role, Integer code) {
        this.role = role;
        this.code = code;
    }

    public String getRole() {
        return role;
    }

    public Integer getCode() {
        return code;
    }

    public String fromCode(Integer code) {
        if (code.equals(ADMIN.code)) {
            return ADMIN.role;
        } else if (code.equals(USER.code)) {
            return USER.role;
        } else {
            return null;
        }
    }

    public String fromRole(String role) {
        if (role.equals(ADMIN.role)) {
            return ADMIN.role;
        } else if (role.equals(USER.role)) {
            return USER.role;
        } else {
            return null;
        }
    }
}