package com.authentication.service.entity;

/**
 * @author Artur Tomeyan
 * @date 04/11/2022
 */
public enum Roles {

    ADMIN("ROLE_ADMIN", 1),
    USER("ROLE_USER", 2);

    private final Integer code;
    private final String role;

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

    public static String fromCode(Integer code) {
        if (code.equals(ADMIN.code)) {
            return ADMIN.role;
        } else if (code.equals(USER.code)) {
            return USER.role;
        } else {
            return null;
        }
    }

    public String fromRole(String role) {
        if (role.equalsIgnoreCase(ADMIN.role)) {
            return ADMIN.role;
        } else if (role.equalsIgnoreCase(USER.role)) {
            return USER.role;
        } else {
            return null;
        }
    }
}