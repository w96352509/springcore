package com.study.springcore.case08;

import java.text.SimpleDateFormat;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPersonDao {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		PersonDao personDao = ctx.getBean("personDaoImpl", PersonDaoImpl.class);
		
		System.out.println(personDao.readAll());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		boolean check = personDao.create(new Person("Mary", 0, sdf.parse("2010/1/1")));
		System.out.println(check);
		
		System.out.println(personDao.readAll());
	}

}
