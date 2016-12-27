package com.wushengde.spring.aop.helloworld;

/**
 * 此类是带日志的计算器类，用于计算加减乘除，且带有日志。即：在方法执行过程中有日志信息。(可以是参数验证、以及各种校验等)。
 *
 */
public class ArithmeticCalculatorLoggingImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		System.out.println("The method add begins with["+i+","+j+"]");
		int result= i + j ;
		System.out.println("The method add ends with["+result+"]");
		return result;
	}

	@Override
	public int sub(int i, int j) {
		System.out.println("The method sub begins with["+i+","+j+"]");
		int result= i - j ;
		System.out.println("The method sub ends with["+result+"]");
		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("The method mul begins with["+i+","+j+"]");
		int result= i * j ;
		System.out.println("The method mul ends with["+result+"]");
		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("The method div begins with["+i+","+j+"]");
		int result= i / j ;
		System.out.println("The method div ends with["+result+"]");
		return result;
	}

}
