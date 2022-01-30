package com.study.springcore.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;

@Repository
public class BookDaoImpl  implements BookDao{
     
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	//取得價錢
	public Integer getPrice(Integer bid) {
		String sql = "select price from book where bid=?" ;
		return jdbcTemplate.queryForObject(sql, Integer.class , bid); //語法sql 型別.class  對應參數(要查的號碼)
	}

	@Override
	public Integer getStockAmount(Integer bid) {
		String sql = "select amount from stock where bid=?" ;
		return jdbcTemplate.queryForObject(sql, Integer.class , bid); //語法sql 型別.class  對應參數(要查的號碼)
	}

	@Override
	public Integer getWalletMoney(Integer wid) {
		String sql = "select money from wallet where wid=?" ;
		return jdbcTemplate.queryForObject(sql, Integer.class , wid); //語法sql 型別.class  對應參數(要查的號碼)
	}

	@Override
	public Integer updateStock(Integer bid, Integer amount)  throws InsufficientQuantity {
		//確認該書的最新庫存量
		Integer new_amount = getStockAmount(bid);
		if (new_amount<=0) {
			throw new InsufficientQuantity(String.format("此書號:%d 沒庫存 目前數量:%d", bid , new_amount));
		}else if(new_amount < amount) {
			throw new InsufficientQuantity(String.format("此書號:%d 庫存不足 目前數量:%d", bid , new_amount));
		}
		//修改庫存
		String sql = "update stock set amount = amount - ? where bid=?";
		return jdbcTemplate.update(sql , amount , bid);
	}

	@Override
	public Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount{
		//先確認錢包內的餘額
		Integer new_money = getWalletMoney(wid);
		if (new_money<=0) {
			throw new InsufficientAmount(String.format("錢包號碼:%d 目前沒餘額 , 目前餘額:%d", wid , new_money));
		}else if (new_money < money) {
			throw new InsufficientAmount(String.format("錢包號碼:%d 目前餘額不足 , 目前餘額:$ %d , 扣款金額:$ %d"
					                                 , wid , new_money , money));
		}
		//修改餘額
		String sql = "update wallet set money = money - ? where wid=?";
		return jdbcTemplate.update(sql , money , wid);
	}

	@Override
	public Integer createLog(String tname, Integer bid ,Integer amount) {
		String sql = "insert into time(tname,bid,amount,total) values(? , ? , ? ,?)";
		int rowcount = jdbcTemplate.update(sql,tname,bid,amount,(getPrice(bid) * amount));
		return rowcount;
	  }

}
