package com.myjavasolutions.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjavasolutions.logging.LogLevel;
import com.myjavasolutions.logging.LoggingPropBean;
import com.myjavasolutions.logging.LoginUtil;
import com.myjavasolutions.logging.LoginUtilImpl;

@Aspect
public class LoggingAspect {

	@Autowired
	private LoginUtil logger;
	
	@Autowired
	private LoggingPropBean logginPropBean;
	
	public LoggingAspect() {}
	
	//it runs before execution proceeds to the method's body
	@Before(value ="@annotation(Loggable)", argNames = "joinPoint, Loggable")
	public void log(JoinPoint joinPoint, Loggable loggable) throws Throwable {
		
		logginPropBean.setClassName(joinPoint.getTarget().getClass());
		logginPropBean.setMethodSignature(joinPoint.getSignature().toString());
		logginPropBean.setState("Entering");
		logginPropBean.setArguments(joinPoint.getArgs());
		
		logger.log(loggable.value(), null, logginPropBean);
		logginPropBean.reset();
		
	}
	
	//runs after the target method finishes normally. It will not execute if exception occurs
	@AfterReturning(value = "@annotation(Loggable)", returning = "returnValue",
			argNames = "joinPoint, Loggable, returnValue")
	public void afterReturning(JoinPoint joinPoint, Loggable loggable,
			Object returnValue) {

		logginPropBean.setClassName(joinPoint.getTarget().getClass());
		logginPropBean.setMethodSignature(joinPoint.getSignature().toString());
		logginPropBean.setArguments(joinPoint.getArgs());
		logginPropBean.setState("Exiting");
		
		if (joinPoint.getSignature() instanceof MethodSignature) {
			MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		
			if (!signature.getReturnType().getName().equals("void")) {
				logginPropBean.setReturnValue(returnValue.toString());
			}
			else {
				logginPropBean.setReturnValue("none");
			}
		}
		
		logger.log(loggable.value(), null, logginPropBean);
		logginPropBean.reset();
	}
	
	//executes when its target method throws an exception.
	@AfterThrowing(value = "@annotation(com.myjavasolutions.aspect.Loggable)",
			throwing = "throwable", argNames = "joinPoint, throwable")
	public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
		
		logginPropBean.setClassName(joinPoint.getTarget().getClass());
		logginPropBean.setMethodSignature(joinPoint.getSignature().toString());
		logginPropBean.setArguments(joinPoint.getArgs());
		logginPropBean.setState("Exception Occured");
		
		logger.log(LogLevel.ERROR, throwable, logginPropBean);
		logginPropBean.reset();	
	}
	
}
