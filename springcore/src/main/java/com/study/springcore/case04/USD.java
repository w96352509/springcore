package com.study.springcore.case04;

public class USD extends CurrencyImpl {

	public void init() {
		System.out.println("USD INIT");
	}
	
	@Override
	public double getValue() {
		return value;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}

	public void destory(){
		System.out.println("USD destory");
	 }
	}

