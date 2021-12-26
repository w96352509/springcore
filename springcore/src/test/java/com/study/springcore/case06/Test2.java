package com.study.springcore.case06;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.stream.Collectors; 

public class Test2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext6.xml");
		RoundBean area = ctx.getBean("round",getArea.class);
		System.out.println(area.getRoundArea());
	}
}
