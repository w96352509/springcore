package com.study.springcore.tx.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.springcore.tx.dao.BookDao;
import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Transactional(propagation = Propagation.REQUIRED,
			       //針對錯誤 rollback
			       rollbackFor = {InsufficientAmount.class ,InsufficientQuantity.class},
			       //針對錯誤 不回rollback
			       noRollbackFor = {ArithmeticException.class}       
			) //一起提交
	// getConnect() , setAutocommit(false) , commit()
	@Override
	public void buyOne(Integer wid,String tname,Integer bid ,Integer amount) throws InsufficientAmount , InsufficientQuantity {
		// 減去一本庫存
		bookDao.updateStock(bid, 1);
		//取得書籍
		Integer price = bookDao.getPrice(bid);
		//數值錯誤
		//System.out.println(10/0); 產生ArithmeticException錯誤 根據上方的定義不做回滾
		//減去錢包裡的價格
		bookDao.updateWallet(wid, price);
		//Log ... 
		bookDao.createLog(tname,bid,amount);
	}

	@Transactional(propagation = Propagation.REQUIRED,
		       //針對錯誤 rollback
		       rollbackFor = {InsufficientAmount.class ,InsufficientQuantity.class},
		       //針對錯誤 不回rollback
		       noRollbackFor = {ArithmeticException.class}  //數學錯誤      
		) //一起提交  //各改各
	@Override
	public void buyMany(Integer wid,String tname,Integer amount,Integer... bids) throws InsufficientAmount , InsufficientQuantity {
		//重複執行 buyone
		//Stream.of(bids).forEach(bid->buyOne(wid, bid)); 此方法無法拋出例外
		for(int bid : bids) {
			buyOne(wid,tname,bid,amount);
			};
		//Log ... 
		
	
	}

}
