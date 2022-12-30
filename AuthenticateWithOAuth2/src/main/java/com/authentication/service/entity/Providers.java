package com.authentication.service.entity;

/**
 * @author Artur Tomeyan
 * @date 15/11/2022
 */
public enum Providers {
    GOOGLE(1, "GOOGLE"),
    LOCAL(2, "LOCAL");

    private final Integer code;
    private final String name;

    Providers(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}