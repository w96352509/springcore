package com.study.springcore.proxy.sta;

public class Woman implements Person{

	@Override
	public void work() {
		//公用方法
		//System.out.println("戴口罩");
		//業務邏輯
		System.out.println("去市場買菜");
		}

}
