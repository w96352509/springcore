package com.study.springcore.proxy.sta;

public class Man implements Person {

	@Override
	public void work() {
		//公用方法(前)
		//System.out.println("戴口罩");
		//公用方法(例外)
		//System.out.println("若沒口罩,要去買口罩");
		//業務邏輯
		System.out.println("上班工作");
		//例外業務邏輯
		System.out.println(10/0);
		//公用方法(後)
		//System.out.println("脫口罩");
		}

}
