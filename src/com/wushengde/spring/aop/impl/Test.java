package com.wushengde.spring.aop.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//1.创建spring的IOC容器：
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从IOC容器中获取bean的实例：
		ArithmeticCalculator arithmeticCalculator=ctx.getBean(ArithmeticCalculator.class);
		
		//3.使用bean：
		int result=arithmeticCalculator.add(3, 6);
		System.out.println("result = "+result+";");
		
		int result2=arithmeticCalculator.div(10, 2);
		System.out.println("result2 = "+result2);
		
//		ctx.close();
	}
}
