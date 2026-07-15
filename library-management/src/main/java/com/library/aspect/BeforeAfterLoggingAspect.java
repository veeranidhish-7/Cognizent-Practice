package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise 8: Implementing Basic AOP with Spring.
 * Demonstrates the classic "before" and "after" advice types for separating
 * a cross-cutting logging concern from the business logic in BookService.
 *
 * Registered as a plain bean + <aop:aspectj-autoproxy/> in
 * applicationContext-aop-full.xml.
 */
@Aspect
public class BeforeAfterLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(BeforeAfterLoggingAspect.class);

    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("BEFORE  -> about to call {}", joinPoint.getSignature());
    }

    @After("execution(* com.library.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("AFTER   -> finished calling {}", joinPoint.getSignature());
    }
}
