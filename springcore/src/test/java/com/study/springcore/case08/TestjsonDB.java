package com.study.springcore.case08;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.ls.LSOutput;

public class TestjsonDB {
     
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		JsonDB jsonDB = ctx.getBean("jsonDB", JsonDB.class);
		System.out.println(jsonDB.queryAll());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		boolean check = jsonDB.add(new Person("Molly",0,sdf.parse("1992/08/22")));
		System.out.println(check);
		System.out.println(jsonDB.queryAll());
	}
}
