package com.study.springcore.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.study.springcore.tx.controller.BookController;

public class TestBook {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("tx-config.xml");
		BookController bookController = ctx.getBean("bookController", BookController.class);
		System.out.println(bookController);
		//case 1 單本
		Integer wid =1;
		Integer bid =1;
		String  tname = "vic5";
		Integer amount = 1;
		//bookController.buyBook(wid,tname,bid,amount);
		//case2 多本
		
		bookController.buyBooks(wid,tname,amount,1,1,2,2,2); //600
	}
}
