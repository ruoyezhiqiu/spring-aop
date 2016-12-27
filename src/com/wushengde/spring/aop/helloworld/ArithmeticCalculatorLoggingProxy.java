package com.wushengde.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理：代码混乱、代码分散 这两个问题。 目前常用解决方法是：利用spring AOP解决以上两个问题
 *
 */

//此类利用动态代理解决：代码混乱与代码分散问题
public class ArithmeticCalculatorLoggingProxy {
	
	//要代理的对象
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		super();
		this.target = target;
	}

	public ArithmeticCalculator getLoggingProxy(){
		
		ArithmeticCalculator proxy=null;
		
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader=target.getClass().getClassLoader();
		
		//代理对象的类型，即其中有哪些方法
		Class [] interfaces=new Class[] {ArithmeticCalculator.class};
		
		//当调用代理对象其中的方法时，需要执行的代码
		InvocationHandler h=new InvocationHandler() {
			
			/**
			 * proxy:正在返回的那个代理对象，一般情况下，在invoke方法中都不使用该对象；
			 * method:正在被调用的方法；
			 * args：调用方法时传入的参数；
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				//测试使用一下proxy：会出现内存溢出。
				//System.out.println(proxy.toString());
				
				String methodName=method.getName();
				//日志：
				System.out.println("At wusheng-->The method: "+methodName+" begins with: "+Arrays.asList(args));
				//执行方法：
				Object result=method.invoke(target, args);
				//日志：
				System.out.println("At wusheng-->The method: "+ methodName+" ends with: "+result);
				return result;
			}
		};
		proxy=(ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
