package com.study.springcore.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-config.xml");
		Calc calc = ctx.getBean("calcImpl",Calc.class);
		//calc.add(10, 20);
		//calc.div(20, 10);
		calc.div(20, 0);
	}
	
}
