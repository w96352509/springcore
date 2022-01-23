package com.study.springcore.tx.exception;

import org.w3c.dom.ls.LSOutput;

//庫存量不足
public class InsufficientQuantity extends Exception {

	public InsufficientQuantity(String message) {
		super(message);
		
	}
   
}
