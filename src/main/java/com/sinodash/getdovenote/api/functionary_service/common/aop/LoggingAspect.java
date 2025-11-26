package com.sinodash.getdovenote.api.functionary_service.common.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    // Define a pointcut to log methods in service or controller packages
    @Around("execution(* com.example.sinodash.getdevnote.api.functionary_service.features.*.*(..))")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();

        logger.info("Before method execution: {}.{}()", className, methodName);

        Object result = null;
        try {
            result = joinPoint.proceed(); // Execute the actual method
            long duration = System.currentTimeMillis() - startTime;
            logger.info("After method execution: {}.{}() with result: {}. Execution time: {}ms", className, methodName, result, duration);
        } catch (Throwable throwable) {
            logger.error("Exception in method: {}.{}()", className, methodName, throwable);
            throw throwable;
        }
        return result;
    }
}
