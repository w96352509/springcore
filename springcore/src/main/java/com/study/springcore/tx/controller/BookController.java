package com.study.springcore.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;
import com.study.springcore.tx.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	public void buyBook(Integer wid,String tname,Integer bid,Integer amount) {
		try {
			bookService.buyOne(wid,tname,bid,amount);
			System.out.println("單筆購買");
		} catch (InsufficientAmount e) {
			System.err.println("餘額不足" + e);
		} catch (InsufficientQuantity e) {
			System.err.println("庫存不足" + e);
		}

	}

	public void buyBooks(Integer wid,String tname,Integer amount,Integer... bids) {
		try {
			bookService.buyMany(wid,tname,amount,bids);
			System.out.println("多筆購買");
		} catch (InsufficientAmount e) {
			System.err.println("餘額不足" + e);
		} catch (InsufficientQuantity e) {
			System.err.println("庫存不足" + e);
		}

	}
}
