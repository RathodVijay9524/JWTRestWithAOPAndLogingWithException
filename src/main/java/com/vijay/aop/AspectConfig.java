package com.vijay.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

import com.vijay.exception.TaskException;

import lombok.extern.log4j.Log4j2;

@Aspect
@Configuration
@Log4j2
public class AspectConfig {

	/*
	 * Logging Exception Handling TimeTaken
	 */
	

	@Before(value = "execution(* com.vijay.controller.*.*(..))")
	public void logStatementBefore(JoinPoint joinPoint) {
		log.info("Executing {}", joinPoint);
	}

	@After(value = "execution(* com.vijay.controller.*.*(..))")
	public void logStatementAfter(JoinPoint joinPoint) {
		log.info("Complete exceution of {}", joinPoint);
	}
	
	
	
	
	@Around(value = "execution(* com.vijay.service.*.*(..))")
	public Object taskHandler(ProceedingJoinPoint joinPoint) throws Throwable {

		try {
			Object obj = joinPoint.proceed();
			return obj;
		} catch (TaskException e) {
			log.info(" TaskException StatusCode {}", e.getHttpStatus().value());
			log.info("TaskException Message {}", e.getMessage());
			throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
		}
	}

	@Around(value = "execution(* com.vijay.controller.*.*(..))")
	public Object timeTracker(ProceedingJoinPoint joinPoint) throws Throwable {

		long stratTime = System.currentTimeMillis();

		try {
			Object obj = joinPoint.proceed();
			long timeTaken = System.currentTimeMillis() - stratTime;
			log.info("Time taken by {} is {}", joinPoint, timeTaken);
			return obj;
		} catch (TaskException e) {
			log.info(" TaskException StatusCode {}", e.getHttpStatus().value());
			log.info("TaskException Message {}", e.getMessage());
			throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
		}
	}  

}
