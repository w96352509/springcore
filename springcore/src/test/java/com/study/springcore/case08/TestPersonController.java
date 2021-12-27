package com.study.springcore.case08;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPersonController {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
		PersonController personContolller = ctx.getBean("personController", PersonController.class);
		
		//personContolller.printAllPersons();
		
		//personContolller.addPerson("Bob", 2013, 12, 26);
		//personContolller.addPerson("Bob", 2021, 12, 26);
		//personContolller.printAllPersons();
		//System.out.println(personContolller.getPersonByNames("Bob"));
		//System.out.println(personContolller.gettoday(LocalDateTime.now()));
		//System.out.println(LocalDateTime.now());
		//System.out.println(personContolller.getage(10));
		
		//personContolller.uptParson("Bob", 2013, 12, 25);
		personContolller.getBirth(2013,12,25);
		//personContolller.printAllPersons();
		
	}

}
