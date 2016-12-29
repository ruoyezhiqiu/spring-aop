package com.wushengde.spring.aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

public class ValidationAspect {
	public void validateArgs(JoinPoint joinPoint){
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("validate-->:"+args);
	}
}
