package com.study.springcore.aop_lab;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class Audience {

	@Pointcut(value = "execution(* com.study.springcore.aop_lab.Performance.perform(..))")
	public void pt() {};
	
	//前置通知
	@Before(value = "pt()")
	public void slienceCellphone() {
		System.out.println("觀眾:進入表演場");
		System.out.println("觀眾:關到手機");
		System.out.println("觀眾:找到位置做好");
	}
	
	@AfterReturning(value = "pt()")
	public void applause() {
		System.out.println("觀眾：鼓掌拍手");
	}
	
	@After(value = "pt()")
	public void exit() {
		System.out.println("觀眾：離開表演場");
	}
	
	@AfterThrowing(value = "pt()")
	public void somethingError() {
		System.out.println("觀眾：沒關係...退票~~");
	}
}
