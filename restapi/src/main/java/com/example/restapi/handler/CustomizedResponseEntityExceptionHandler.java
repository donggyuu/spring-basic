package com.example.restapi.handler;

import com.example.restapi.exception.UserExceptionResponse;
import com.example.restapi.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// @RestController에서 발생한 예외를 한 곳에서 관리&처리할 수 있도록 함
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /*
    ResponseEntityExceptionHandler에서 기본적인 예외 처리는 다 해준다.
    아래는 추가적으로 custom exception을 추가한 것임.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleNotExceptions(Exception ex, WebRequest request) {

        UserExceptionResponse userExceptionResponse = new UserExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(userExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

        UserExceptionResponse userExceptionResponse = new UserExceptionResponse(
                new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(userExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
    User Class의 Validation에 걸리는 정보를 뽑기 위해, 기본 제공되는 argumentNotValid를 오버라이딩해서 작성
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        UserExceptionResponse userExceptionResponse = new UserExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString());

        return new ResponseEntity<>(userExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
