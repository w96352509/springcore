package com.study.springcore.case05;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.stream.Collectors; 

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext5.xml");
		
		Student john = ctx.getBean("s1",Student.class);
		//System.out.println(john);
		Student mary = ctx.getBean("s2",Student.class);
		//System.out.println(mary);
		Teacher t1 = ctx.getBean("t1" , Teacher.class);
		Teacher t2 = ctx.getBean("t2" , Teacher.class);
		//請問mary的老師是誰? 印出name
		System.out.println("課程"+mary.getClazzs()); //Mary的課程
		Teacher[] teachers = {t1 , t2};
		Set<Teacher> teachers2 = new LinkedHashSet<>();
		for(Teacher teacher :teachers) {  //找出所有的老師的id
			clazz_loop:                            //迴圈名稱
			for(Clazz cla1:teacher.getClazzs()) { //所有老師的課程
				for(Clazz cla2:john.getClazzs()) { //Mary所有有的課程
					if (cla1.getId() == cla2.getId()) { //比對id
						//System.out.println(teacher.getName());
						teachers2.add(teacher);
						break clazz_loop;
					}
				}
			}
		}
		
		System.out.println("老師"+teachers2.stream().map(Teacher::getName).collect(Collectors.toSet())); //Mary的課程
				
	}
	
}
