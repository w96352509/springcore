package com.study.springcore.case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//處理SINGLETON 要到 applicationContext.xml中 , 設定 scope(defult:singleton)
        CPU cpu1 = ctx.getBean("cpu1",CPU.class);
		CPU cpu2 = ctx.getBean("cpu2",CPU.class);
		CPU cpu3 = ctx.getBean("cpu3",CPU.class);
		CPU cpu4 = ctx.getBean("cpu4",CPU.class);
		CPU cpu5 = ctx.getBean("cpu5",CPU.class);
		CPU cpu6 = ctx.getBean("cpu6",CPU.class);
		cpu1.setGhz(2.8); 
		cpu2.setGhz(3.8);
		
		System.out.println(cpu1.toString());
		System.out.println(cpu2.toString());
		System.out.println(cpu3.toString());
		System.out.println(cpu4.toString());
		System.out.println(cpu5.toString());
		System.out.println(cpu6.toString());
	}
	
}
