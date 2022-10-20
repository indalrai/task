package com.cats.ems.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cats.ems.model.CredentialManager;
import com.cats.ems.model.Employee;


import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class EmployeeAopAspect {

	@Pointcut("execution(* com.cats.ems.controller.*.*(..))")
	public void loggingPointCut() {
	}

	@Around("loggingPointCut()")
	public Object around(ProceedingJoinPoint jointPoint) throws Throwable {
		log.info("Before method invoked..." + jointPoint.getArgs()[0]);
		Object object = jointPoint.proceed();

		if (object instanceof Employee) {
			log.info("After method invoked..." + jointPoint.getArgs()[0]);
		} else if (object instanceof CredentialManager) {
			log.info("After method invoked..." + jointPoint.getArgs()[0]);
		}
		return object;
	}

	@Before("loggingPointCut()")
	public void savingData() {
		System.out.println("YOUR DATA IS STARTED SAVING TO DATABASE");
	}

	@After("loggingPointCut()")
	public void afterSavingData() {
		System.out.println("YOUR DATA IS SAVED SUCCESSFULLY");
	}

	Logger logger = LoggerFactory.getLogger(EmployeeAopAspect.class);

	@Around("@annotation(com.cats.ems.advisor.TrackExecutionTime)")
	public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		logger.info("Method name... " + joinPoint.getSignature() + " Time taken to execute..." + (endTime - startTime));
		return obj;
	}
}
