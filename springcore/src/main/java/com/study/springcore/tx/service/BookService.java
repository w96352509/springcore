package com.study.springcore.tx.service;

import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;

public interface BookService {

	void buyOne (Integer wid,String tname,Integer bid,Integer amount)     throws InsufficientAmount , InsufficientQuantity;
	void buyMany(Integer wid ,String tname,Integer amount, Integer... bids) throws InsufficientAmount , InsufficientQuantity;
}
