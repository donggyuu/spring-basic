package com.example.restapi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*
TODO : UserExceptionResponse.class와 비교
TODO : ~~ArgsContructor는 필요한가?
 */

@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class BoardExceptionResponse {

    /*
    response의 body에 담길 값들
     */
    private int code;
    private String message;
    private List<String> errorDetails;
    private String responseTime;

    public BoardExceptionResponse(HttpStatus httpStatus, String message, List<String > errorDetails) {
        this.code = httpStatus.value();
        this.message = message;
        this.errorDetails = errorDetails;
        // TODO : 이런 . 으로 연결되는 형식 -> 구글링없이 코드만 보고 파악하도록 하기
        this.responseTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }

}
