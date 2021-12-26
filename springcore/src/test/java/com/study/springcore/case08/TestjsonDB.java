package com.study.springcore.case08;



import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.ls.LSOutput;

public class TestjsonDB {
     
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		 JsonDB jsonDB = ctx.getBean("jsonDB" , JsonDB.class);
		 
		 
		 System.out.println(jsonDB.queryAll());
	}
}
