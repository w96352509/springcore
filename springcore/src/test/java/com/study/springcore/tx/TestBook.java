package com.study.springcore.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.study.springcore.tx.controller.BookController;

public class TestBook {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		BookController bookController = ctx.getBean("bookController", BookController.class);
		System.out.println(bookController);
		//case 1 單本
		Integer wid =1;
		Integer bid =1;
		bookController.buyBook(wid, bid);
		//case2 多本
		/*Integer wid = 1;
		bookController.buyBooks(wid, 1,1,2,2,2); //600*/
	}
}