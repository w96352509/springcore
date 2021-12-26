package com.study.springcore.case07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext7.xml");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
	}
}
