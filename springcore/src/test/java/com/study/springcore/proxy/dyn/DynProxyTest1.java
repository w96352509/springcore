package com.study.springcore.proxy.dyn;

import java.net.Proxy;

import com.study.springcore.proxy.sta.Person;
import com.study.springcore.proxy.sta.Woman;

public class DynProxyTest1 {

	public static void main(String[] args) {
	Person woman = (Person)new DynProxy(new Woman()).getProxy();
	woman.work();
	Calc calc=(Calc)new DynProxy(new CalcImpl()).getProxy(); //得到一個Object
	System.out.println(calc.add(10, 20));
	}
	
}
