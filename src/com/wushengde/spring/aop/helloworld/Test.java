package com.wushengde.spring.aop.helloworld;

public class Test {
	public static void main(String[] args) {
//		ArithmeticCalculator arithmeticCalculator=null;
//		arithmeticCalculator=new ArithmeticCalculatorLoggingImpl();
		
		ArithmeticCalculator target=new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy=new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		
		System.out.println(proxy.getClass().getName());
		
		int result=proxy.add(1, 2);
		System.out.println(result);
		
		int result2=proxy.div(4, 2);
		System.out.println(result2);
		
		int result3=proxy.sub(10, 5);
		System.out.println(result3);
	}
}
