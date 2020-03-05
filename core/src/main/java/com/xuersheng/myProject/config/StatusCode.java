package com.xuersheng.myProject.config;

public enum  StatusCode {

    OK("OK"),

    ERROR("ERROR");

    StatusCode(String code) {
        this.code = code;
    }
    private String code;

    @Override
    public String toString() {
        return code;
    }
}
