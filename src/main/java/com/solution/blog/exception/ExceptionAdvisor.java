package com.solution.blog.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvisor {

    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e) {
        // todo 내용 추가 필요
    }
}
