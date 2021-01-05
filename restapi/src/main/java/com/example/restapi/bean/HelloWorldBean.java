package com.example.restapi.bean;

import lombok.Data;

/*
HelloWorldController에서 return할 객체를 정의하는 class
- 직접 bean을 설정하는 방법에 대한 읽을거리:https://cbw1030.tistory.com/54
 */
@Data
public class HelloWorldBean {

    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("return message : [message=%s]", message);
    }

}
