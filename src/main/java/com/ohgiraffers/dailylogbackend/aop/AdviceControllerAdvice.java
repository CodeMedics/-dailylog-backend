package com.ohgiraffers.dailylogbackend.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class AdviceControllerAdvice {

    @ExceptionHandler(Throwable.class)
    public Object handleAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.error("Advice Error = {}.{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());

        Object result = proceedingJoinPoint.proceed();

        return result;
    }

}
