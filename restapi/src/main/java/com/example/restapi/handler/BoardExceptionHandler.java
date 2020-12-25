package com.example.restapi.handler;

import com.example.restapi.exception.BoardExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

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


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class) // error log로부터 해당 exception이 발생한 것을 알아서 처리.
    public BoardExceptionResponse handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException e, HttpServletRequest request) {

        // console에 출력
        log.error("===================== Handler MethodArgumentNotValidException =====================");
        e.printStackTrace();

        return getExceptionResponseFromBindingResult(e.getBindingResult(), HttpStatus.BAD_REQUEST, "입력값이 유효하지 않습니다.");

    }


    // Create/EditBoardParam의 @Length, @NotEmpty를 response body로 응답하기 위한 method
    private BoardExceptionResponse getExceptionResponseFromBindingResult(
            BindingResult bindingResult, HttpStatus httpStatus, String message) {

        List<String> errorDetails = bindingResult.getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)// TODO : 뭐에 쓰는 거지??
                .collect(Collectors.toList());

        return new BoardExceptionResponse(httpStatus, message, errorDetails);
    }


}
