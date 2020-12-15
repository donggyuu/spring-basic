package com.example.restapi.bean;

import lombok.Data;

@Data
public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("hello world bean [message=%s]", message);
    }

}
