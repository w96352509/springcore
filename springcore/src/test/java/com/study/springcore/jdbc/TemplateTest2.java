package com.study.springcore.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.jdbc.entity.Emp;
import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao" , EmpDao.class);
		int rowcount = 0;
		int[] rowcounts = null;
		// 測試單筆新增 1
		//rowcount = empDao.addOne1("test1", 18);
		//System.out.println(rowcount);
		// 測試單筆新增 2
		//rowcount = empDao.addOne2("test2", 18);
		//System.out.println(rowcount);
		
		// 測試多筆新增1
	/*  List<Object[]> rows = new ArrayList<>();
		rows.add(new Object[] {"Jo" , 10});
		rows.add(new Object[] {"Jo2", 20});
		rowcounts = empDao.multiadd1(rows);
		System.out.println(rowcounts); 
		*/
		
		// 測試多筆新增2
	/*  List<emp> emps = new ArrayList<>();
		emps.add(new emp("JOJO",25));
		emps.add(new emp("JOJO2",25));
		emps.add(new emp("JOJO3",25));
		rowcounts = empDao.multiadd2(emps);
		System.out.println(Arrays.toString(rowcounts));
		*/
		
		// 測試修改
	    /*  
	    rowcount=empDao.updateById(2, "JOJOJO", 25);
	    System.out.println(rowcount+"修改測試");
	    */
		
		// 測試刪除
	    //rowcount = empDao.deleteById(1);
	}
	
}
