package com.study.springcore.proxy.sta;

public class PersonProxy implements Person {

	private Person person;

	public PersonProxy(Person person) {
		this.person = person;
	}

	@Override
	public void work() {
		// 公用邏輯 - 前
				System.out.println("戴上口罩");
				try {
					// 代理調用 person 的 work() 方法
					person.work();
				} catch (Exception e) {
					// 公用邏輯 - 例外發生
					System.err.println("買口罩");
					System.err.println("重新戴上口罩");
				}
				// 公用邏輯 - 後
				System.out.println("脫下口罩");

}
}
