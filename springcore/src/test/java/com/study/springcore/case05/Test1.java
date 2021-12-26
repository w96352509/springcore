package com.study.springcore.case05;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.w3c.dom.ls.LSOutput;


public class Test1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext5.xml");
		
		Student john = ctx.getBean("s1",Student.class);
		//System.out.println(john);
		Student mary = ctx.getBean("s2",Student.class);
		//System.out.println(mary);
		Teacher[]  teachers = {ctx.getBean("t1",Teacher.class),ctx.getBean("t2",Teacher.class)};
		//請問mary的老師是誰? 印出name
		Set<Teacher> teachers2 = new LinkedHashSet<>();
		
	    for(Teacher teacher :teachers) {  //找出所有的老師的id
	    	loop:
	    	for(Clazz teacherclazz : teacher.getClazzs()) {
	    		for(Clazz studentclazz : mary.getClazzs()) {
	    			if (teacherclazz.getId()==studentclazz.getId()) {
						teachers2.add(teacher);
						break loop;
					}
	    		}
	    	}
	       }
	      //System.out.println(mary.getName()+"的老師:"+teachers2);
	      System.out.println(mary.getName()+"的老師"+teachers2.stream()
	                                       .map(t ->t.getName()).collect(Collectors.toList()));
	    }
	    
	}

	 


