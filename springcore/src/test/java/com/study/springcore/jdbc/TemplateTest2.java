package com.study.springcore.jdbc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao" , EmpDao.class);
		int rowcount = 0;
		
		// 測試單筆新增 1
		//rowcount = empDao.addOne1("test1", 18);
		//System.out.println(rowcount);
		// 測試單筆新增 2
		rowcount = empDao.addOne2("test2", 18);
		System.out.println(rowcount);
		
	}
	
}
