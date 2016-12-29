package com.wushengde.spring.aop.xml;


/**
 * 此类是不带日志的计算器类，用于计算加减乘除。
 *
 */

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int i, int j) {
		int result= i + j ;
		return result;
	}

	@Override
	public int sub(int i, int j) {
		int result= i - j ;
		return result;
	}

	@Override
	public int mul(int i, int j) {
		int result= i * j ;
		return result;
	}

	@Override
	public int div(int i, int j) {
		int result= i / j ;
		return result;
	}

}
