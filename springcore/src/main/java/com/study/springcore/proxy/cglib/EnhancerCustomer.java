package com.study.springcore.proxy.cglib;

//Echancer 增強型的 Customer
public class EnhancerCustomer extends Customer {

	@Override
	public String buy(String data) {
		
		return super.buy(data)+"  "+"麻煩請出示實聯制";
	}
       
	}
