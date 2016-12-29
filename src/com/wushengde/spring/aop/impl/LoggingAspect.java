package com.wushengde.spring.aop.impl;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 	把这个类申明为一个切面步骤：
 * 	1.把该类放入到IOC容器中：加上@Component注解；
 * 	2.再申明为一个切面:加上@Aspect注解
 *	3.切面的优先级指定：利用@Order注解指定其优先级，值越小，优先级越大。
 */
@Order(2)
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 *	定义一个方法，用于声明切入点表达式，一般情况下，该方法中不需要添加代码。
	 */
	
//	@Pointcut("execution(public int com.wushengde.spring.aop.impl.ArithmeticCalculator.*(..))")
//	public void declareJointPointExpression(){}
	
	//1.前置通知：在目标方法开始之前执行要执行的通知
	
	//before注解表示：声明该方法为一个前置通知
	//注解before表示：前置通知
	@Before("execution(public int com.wushengde.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void beforeMethod(JoinPoint joinPoint){
		//JoinPoint:表示连接点，可以获取目标方法的方法名以及参数列表
		//获取连接点的方法名
		String methodName=joinPoint.getSignature().getName();
		//获取该方法的参数列表
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("The method: "+methodName+"  begins with "+args);
	}
	
	
	//2.后置通知：在目标方法执行后，无论是否发生异常都会执行的通知
	
	//*注：后置通知：不能访问目标方法的执行结果，只能在返回通知中访问目标方法的执行结果。
	//after注解表示：声明该方法为一个后置通知，其中的 * 1.依次表示 任意修饰符及任意返回类型 2.该包中的任意类 3.表示任意类中的任意方法 
	@After("execution(public int com.wushengde.spring.aop.impl.ArithmeticCalculator.*(..))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method: "+methodName+" ends");
	}
	
	//3.返回通知：在目标方法正常结束后，再执行的通知，如果目标方法有异常则不执行返回通知
	
	//返回通知可以访问到目标方法的返回值的
	@AfterReturning(value="execution(public int com.wushengde.spring.aop.impl.ArithmeticCalculator.*(..))",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method: "+methodName+" ends with result = "+result);
	}
	
	//4.异常通知：
	
	//异常通知可以访问到目标方法执行过程中产生的异常,且该通知只在出现异常时执行,且可以指定出现特定异常时才执行该通知，即：Exception可以换成各种异常
	@AfterThrowing(value="execution(public int com.wushengde.spring.aop.impl.ArithmeticCalculator.*(..))",throwing="e")
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("The method: "+methodName+" occurs exception: "+e);
	}
	
	//5.环绕通知：功能最强大，但是不常用
	
	/**
	 * a.环绕通知需要携带ProceedingJoinPoint类型的参数
	 * b.环绕通知类似于动态代理的全过程
	 * c.ProceedingJoinPoint类型的参数可以决定是否执行目标方法
	 * d.环绕通知必须有返回值，返回值即为目标方法的返回值
	 */
	/*@Around("execution(public int com.wushengde.spring.aop.impl.ArithmeticCalculator.*(..))")
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
	}*/
}
