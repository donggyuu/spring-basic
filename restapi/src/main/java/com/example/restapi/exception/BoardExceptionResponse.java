package com.example.restapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


//@AllArgsConstructor
//@NoArgsConstructor
@Getter
public class BoardExceptionResponse {

    // response의 body에 담길 값들
    private int code;
    private String message;
    private List<String> errorDetails;
    private String responseTime;

    public BoardExceptionResponse(HttpStatus httpStatus, String message, List<String > errorDetails) {
        this.code = httpStatus.value();
        this.message = message;
        this.errorDetails = errorDetails;
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }

}
