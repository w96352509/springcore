package com.study.springcore.case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//處理SINGLETON 要到 applicationContext.xml中 , 設定 scope(defult:singleton)
        CPU cpu = ctx.getBean(CPU.class);
		CPU cpu2 = ctx.getBean(CPU.class);
		cpu.setGhz(2.8);
		cpu2.setGhz(3.8);
		
		System.out.println(cpu.toString());
		System.out.println(cpu2.toString());
	}
	
}
