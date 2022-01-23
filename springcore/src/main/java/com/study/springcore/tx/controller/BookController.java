package com.study.springcore.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.springcore.tx.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	public void buyBook(Integer wid , Integer bid) {
		bookService.buyOne(wid, bid);
		System.out.println("單筆購買");
	}
	
    public void buyBooks(Integer wid , Integer... bids) {
    	bookService.buyMany(wid, bids);
		System.out.println("多筆購買");
	}
}
