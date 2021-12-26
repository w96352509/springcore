package com.study.springcore.case06;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.stream.Collectors; 

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext6.xml");
		Car car1 = ctx.getBean("car" ,Car.class);
		Car car2 = ctx.getBean("car" ,Car.class);
		System.out.println(car1);
		System.out.println(car2);
	}
}
