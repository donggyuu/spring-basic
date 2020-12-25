package com.example.restapi.handler;

import com.example.restapi.exception.BoardExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

/*
CustomizedResponseEntityExceptionHandler 처럼 extends 해서 작성할 수도 있다.

의도 : board class관련 exception은 여기서 모아서 handling하고싶다.
TODO : (샘플이니까 걍 넘어갈까?) 원래는 User, Board의 공통의 Exception을 한 클래스에서 전부 handling하는것이 이상적.
 */

@Slf4j
@RestControllerAdvice
public class BoardExceptionHandler {

    /*
    HttpServletRequest request 는 어디서 param을 받지?
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public BoardExceptionResponse handlerRuntimeException(EntityNotFoundException e, HttpServletRequest request) {

        log.error("===================== Handler RuntimeException =====================");
        e.printStackTrace();

        // response body에 class의 정보가 Json형태로 들어감
        return new BoardExceptionResponse(HttpStatus.NOT_FOUND, e.getMessage(), null);

    }




}
