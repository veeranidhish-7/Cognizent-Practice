package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 3: Implementing Logging with Spring AOP.
 * Wraps every method in com.library.service with an @Around advice that
 * measures and logs how long the method took to execute.
 *
 * Registered as a plain bean + <aop:aspectj-autoproxy/> in
 * applicationContext-aop.xml.
 */
@Aspect
public class ExecutionTimeLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeLoggingAspect.class);

    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedMs = System.currentTimeMillis() - start;
        logger.info("{} executed in {} ms", joinPoint.getSignature(), elapsedMs);
        return result;
    }
}
