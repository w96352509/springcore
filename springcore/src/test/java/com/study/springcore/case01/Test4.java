package com.study.springcore.case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        CPU cpu3 = ctx.getBean("cpu3",CPU.class);
		CPU cpu4 = ctx.getBean("cpu4",CPU.class);
		CPU cpu5 = ctx.getBean("cpu5",CPU.class);
		CPU cpu6 = ctx.getBean("cpu6",CPU.class);
		
		RAM ram1 = ctx.getBean("ram1",RAM.class);
		RAM ram2 = ctx.getBean("ram2",RAM.class);
		RAM ram3 = ctx.getBean("ram3",RAM.class);
		RAM ram4 = ctx.getBean("ram4",RAM.class);
		
		HD hd1 = ctx.getBean("hd1" , HD.class);
		HD hd2 = ctx.getBean("hd2" , HD.class);
		HD hd3 = ctx.getBean("hd3" , HD.class);
		
		//組成
		Computer computer = ctx.getBean("computer",Computer.class);
		computer.setCpu(cpu6);
		computer.setHd(hd3);
		computer.setRam(ram4);
		System.out.println(computer);
	}
	
}
