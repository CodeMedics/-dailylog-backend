package com.ohgiraffers.dailylogbackend.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimeAspect {

    // 메소드의 이전 이후 시점에 동작하며 메소드 실행 시 걸린 시간에 대한 log를 출력함.
    @Around("execution(* com.ohgiraffers.dailylogbackend.*.*(..))")
    public Object timerController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        log.info("{}.{} = {}ms", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), totalTime);

        return result;
    }
}
