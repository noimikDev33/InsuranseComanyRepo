package com.cognizant.claimManagement.InsuranceCompany.logging;




import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Component
@Slf4j

public class LoggingAspect {
 
	
	@Before(" execution(* com.cognizant.claimManagement.*.*.*.*(..))")
	public void beforeAdvice(JoinPoint point) {
		
		log.info("INFO:"+point.getSignature().getName());
	}
	@After(" execution(* com.cognizant.claimManagement.*.*.*.*(..))")
	public void afterAdvice(JoinPoint point) {
		log.info("INFO:"+point.getSignature().getName());
	}
	@AfterReturning(pointcut="execution(* com.cognizant.claimManagement.*.*.*.*(..))",returning="result")
	public void afterReturning(JoinPoint point,Object result) {
		 log.debug("DEBUG:"+point.getSignature().getName()+" Return Value:"+result);
	}
	@AfterThrowing(pointcut="execution(* com.cognizant.claimManagement.*.*.*.*(..))",throwing="error")
	public void afterThrowing(JoinPoint point,Throwable error) {
		log.error("Error:"+point.getSignature().getName()+" threw exception :"+error);
	}
	@Pointcut("execution(* com.cognizant.claimManagement.*.*.*.*(..))")
	public void getPointCut() {
	}
	/*
	@Around("getPointCut()")
	public Object aroundAdvice(ProceedingJoinPoint point) {
		log.info("INFO:"+point.getSignature().getName());
		Object returnValue=null;
		try {
			returnValue=point.proceed();
		} catch (Throwable e) {
			log.error("Error:"+e.getMessage());
		}
		log.debug("DEBUG:"+returnValue);

		return returnValue;
	}*/
}