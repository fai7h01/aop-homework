package com.aop.aophomework.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    @Pointcut("@annotation(com.aop.aophomework.annotation.ExecutionTime)")
    public void executionTimePC() {};

    @Around("executionTimePC()")
    public Object aroundAnyExecutionTimeAdvice(ProceedingJoinPoint proceedingJoinPoint) {

        long beforeExecutionTime = System.currentTimeMillis();

        Object result = null;
        log.info("Execution Starts...");

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("Error occurred while measuring execution time: {}", throwable.getMessage());
        }

        long afterExecutionTime = System.currentTimeMillis();
        long duration = afterExecutionTime - beforeExecutionTime;
        log.info("Time taken to execute: {} ms, Method: {}",
                duration, proceedingJoinPoint.getSignature().toShortString());

        return result;
    }

}
