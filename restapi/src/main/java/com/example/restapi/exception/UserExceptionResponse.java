package com.example.restapi.exception;

import lombok.Getter;

import java.util.Date;

@Getter
public class UserExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;

    public UserExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

}
