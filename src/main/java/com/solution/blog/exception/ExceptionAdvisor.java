package com.solution.blog.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ValidationException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvisor {

    // @valid 체크
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(ValidationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        createBody("ValidationException", e.getMessage())
                );
    }

    // 타입이 안맞을 경우
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        createBody("MethodArgumentTypeMismatchException", e.getMessage())
                );
    }

    // 전체 예외
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleException(RuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        createBody("RuntimeException", e.getMessage())
                );
    }

    private ErrorResponse createBody(String simpleName, String message) {
        return ErrorResponse.builder()
                .code(simpleName)
                .message(message)
                .build();
    }
}
