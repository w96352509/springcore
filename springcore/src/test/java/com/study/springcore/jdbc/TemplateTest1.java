package com.study.springcore.jdbc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao" , EmpDao.class);
		
		List<Map<String, Object>> emps = empDao.queryAll();
		//如何取得 eid=2的員工姓名
		//物件要改成字串比對
		String name=emps.stream().filter(e ->(e.get("eid")+"").equals("1"))
				.findFirst()
				.get()  //取得Map
				.get("ename")+""; ////取得Map中的資料
		System.out.println(name);
		
		// homework
		// 在每次的 查詢queryAll()中 都可以將 查詢時間的 log 記錄下來
		//
	}
	
}
