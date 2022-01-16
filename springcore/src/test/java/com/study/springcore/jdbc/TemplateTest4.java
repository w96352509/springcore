package com.study.springcore.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.template.EmpJobDao;
import com.study.springcore.jdbc.template.HomeDao;

public class TemplateTest4 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		HomeDao homeDao = ctx.getBean("homeDao", HomeDao.class);
		//homeDao.queryPd().forEach(System.out::println);
		homeDao.querycount().forEach(System.out::println);
	}

}
