package com.example.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice // 모든 에러를 모으는 클래스이다 선언
@RestController // Client 에러 상태를 반환하니까 RestController임
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /*
    ResponseEntityExceptionHandler에서 기본적인 예외 처리는 다 해준다.
    아래는 추가적으로 custom exception을 추가한 것임.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleNotExceptions(Exception ex, WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /*
    상위 exception에도 걸리지 않았을 경우 여기서 받아서 처리
     */
    @ExceptionHandler({Exception.class}) // Test니까 일단 에러 걸리면 여기서 받는 것으로 설정.
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
