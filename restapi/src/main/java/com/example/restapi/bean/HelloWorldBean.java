package com.example.restapi.bean;

import lombok.Data;

/*
객체를 return하면 Jackson에 의해 Json형태로 get됨을 보기 위한 Bean
HelloWorldController와 연관
 */
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
