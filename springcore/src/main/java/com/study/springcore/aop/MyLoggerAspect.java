package com.study.springcore.aop;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect   //切面程式
@Order(1) //數字越小越先執行
public class MyLoggerAspect {
    //PointCut 切入點  , 用來定義 JoinPoint , 優點:可做不同的切入點
	@Pointcut(value = "execution(* com.study.springcore.aop.CalcImpl.add(..))")
	public void pt() {}
	
	@Pointcut(value = "execution(* com.study.springcore.aop.CalcImpl.div(..))")
	public void pt2() {}	
    
	/*
	//前置通知 : 運行在目標方法執行之前
	@Before(value = "pt()") //切入點表達式支援: && , || , !例如: " pt() && !pt2()"
	public void before(JoinPoint joinPoint) {
		System.out.printf("%s %s %s\n" 
				, "前置通知"
				, joinPoint.getSignature().getName() 
				, Arrays.toString(joinPoint.getArgs()));
	}
	
	//後置通知 : 不論目標方法是否有例外發生都會執行 (會放在 finally 中)
	
	@After(value = "pt2()")
	public void after() {
		System.out.println("後置通知...");
	}
	
	//返回通知 : 可以在切面程式中得到目標方法的回傳值
	//有錯誤發生不會執行
	@AfterReturning(value = "pt2()" , returning = "result") //returning 回傳放入位置(Type:Object)
	public void afterReturning(Object result) {
		System.out.println("返回通知 - result = " + result);
	}
	
	//異常通知 : 可知道目標方法所發生的事情(用於捕捉錯誤訊息)
	@AfterThrowing(value = "pt2()" , throwing = "ex")
	public void afterThrowing(Exception ex) {
		System.out.println("異常通知 - ex" + ex);
	}
	*/
	
	//環繞通知
	@Around(value = "pt2() || pt()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object result = null;
		//前置通知
		System.out.println("環繞通知->前置通知");
		try {
		//業務邏輯方法
		result = joinPoint.proceed();
		//返回通知
		System.out.println("環繞通知->返回通知" + result);
		} catch (Throwable ex) {
		//異常通知
		System.out.println("環繞通知->異常通知" + ex);	
		}finally {
		//後置通知
	    System.out.println("環繞通知->後置通知");
		}
		return result ;
	}
	
}
