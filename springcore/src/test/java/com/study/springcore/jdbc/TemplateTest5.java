package com.study.springcore.jdbc;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.template.EmpDao;
import com.study.springcore.jdbc.template.EmpJobDao;
import com.study.springcore.jdbc.template.HomeDao;

public class TemplateTest5 {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		
		//empDao.addOnetx("Tx3tx", 30);
		System.out.println("add");
	}

}
