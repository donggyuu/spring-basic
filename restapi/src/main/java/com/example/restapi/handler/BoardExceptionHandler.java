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
CustomizedResponseEntityExceptionHandler : 기존의 예외처리 handler 클래스를 확장하여 작성
BoardExceptionHandler : handler를 직접 작성, 하지만 exception-class는 기존의 것을 사용
    board class관련 exception은 여기서 모아서 handling 한다

본래는, User, Board 등에서 공통적으로 발생한 exception을 처리하는 하나의 handler class를 만드는 것이 이상적
 */

@Slf4j
@RestControllerAdvice // @RestController에서 발생한 예외를 한 곳에서 관리&처리할 수 있도록 함
public class BoardExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public BoardExceptionResponse handlerRuntimeException(EntityNotFoundException e, HttpServletRequest request) {

        log.error("===================== Handler RuntimeException =====================");
        e.printStackTrace();

        /*
        response-body에 class의 정보가 Json형태로 표시됨
        response-entity를 return해도 되고, 이렇게 객체를 그냥 리턴해도 Jackson에 의해 Json형태로 표시됨
         */
        return new BoardExceptionResponse(HttpStatus.NOT_FOUND, e.getMessage(), null);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    /*
    spring-class인 ResponseEntityExceptionHandlerd에서 알아서 에러 핸들링을 해서 exception을 뱉어냄.
    어떤 에러를 뱉어내는지 헷갈리면 그냥 log에서 어떤 exception이 발생했는지 봐라
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BoardExceptionResponse handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException e, HttpServletRequest request) {

        log.error("===================== Handler MethodArgumentNotValidException =====================");
        e.printStackTrace();

        return getExceptionResponseFromBindingResult(e.getBindingResult(), HttpStatus.BAD_REQUEST, "this param is not valid");
    }

    // param에러 내용을 response-body에 넣어 반환하기 위한 method
    private BoardExceptionResponse getExceptionResponseFromBindingResult(
            BindingResult bindingResult, HttpStatus httpStatus, String message) {

        List<String> errorDetails = bindingResult.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return new BoardExceptionResponse(httpStatus, message, errorDetails);
    }

}
