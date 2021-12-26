package com.study.springcore.case07;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.stream.Collectors; 

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext7.xml");
		User user = ctx.getBean("user",User.class); //class名稱第一字改小寫
	    System.out.println(user);
	}
}
