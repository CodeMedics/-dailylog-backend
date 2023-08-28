package com.ohgiraffers.dailylogbackend.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LogAspect {

    // 타겟의 메소드가 호출되기 이전 시점과 이후 시점에 모두 처리해야 할 필요가 있는 부가기능
    @Around("execution(* com.ohgiraffers.dailylogbackend.login.controller.*.*(..))")
    public Object ControllerLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        log.info("start = {} / {}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
        Object result = proceedingJoinPoint.proceed();
        log.info("end = {} / {}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());

        return result;
    }
}
