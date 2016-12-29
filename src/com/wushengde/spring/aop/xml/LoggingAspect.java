package com.wushengde.spring.aop.xml;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	
	public void beforeMethod(JoinPoint joinPoint){
		//JoinPoint:表示连接点，可以获取目标方法的方法名以及参数列表
		//获取连接点的方法名
		String methodName=joinPoint.getSignature().getName();
		//获取该方法的参数列表
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method: "+methodName+"  begins with "+args);
	}
	
	
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method: "+methodName+" ends");
	}
	
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method: "+methodName+" ends with result = "+result);
	}
	
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method: "+methodName+" occurs exception: "+e);
	}
	
	public Object aroundMethod(ProceedingJoinPoint pjd){
		Object result=null;
		String methodName=pjd.getSignature().getName();
		List<Object> args=Arrays.asList(pjd.getArgs());
		try {
			//相当于：前置通知
			System.out.println("The method: "+methodName+ " begin with "+args);
			//执行目标方法
			result=pjd.proceed();
			//相当于：后置通知或返回通知，此处可以访问到目标方法的执行结果
			System.out.println("The method: "+methodName+ "ends");
		} catch (Throwable e) {
			//相当于：异常通知
			//e.printStackTrace(); 
			System.out.println("The method: "+methodName+ "occurs Exception:"+e);
		}
		//相当于：返回通知,可以访问到目标方法执行的结果
		System.out.println("The method: "+methodName+ " ends with result = "+result);
		
		return result;
	}
}
