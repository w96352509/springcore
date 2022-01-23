package com.study.springcore.tx.dao;

public interface BookDao {
       Integer getPrice(Integer bid);
       Integer getStockAmount(Integer bid);
       Integer getWalletMoney(Integer wid);
       Integer updateStock(Integer bid , Integer amount); //減去庫存
       Integer updateWallet(Integer wid , Integer money); //減去餘額
}
