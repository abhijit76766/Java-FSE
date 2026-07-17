package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore() {
        System.out.println("[AOP] Method execution started");
    }

    @After("execution(* com.library.service.*.*(..))")
    public void logAfter() {
        System.out.println("[AOP] Method execution completed");
    }

    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            return joinPoint.proceed();
        } finally {
            long timeTaken = System.nanoTime() - start;
            System.out.println("[AOP] " + joinPoint.getSignature().getName() + " took " + timeTaken + " ns");
        }
    }
}
