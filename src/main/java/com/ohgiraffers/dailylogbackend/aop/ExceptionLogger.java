package com.ohgiraffers.dailylogbackend.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionLogger {

    @ExceptionHandler(Throwable.class)
    public Object handleException(Throwable exception) throws Throwable {
        log.error("Exception: {}", exception.getMessage());
        throw exception;
    }
}