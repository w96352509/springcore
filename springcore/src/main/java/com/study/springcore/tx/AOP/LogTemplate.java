package com.study.springcore.tx.AOP;

import java.util.Scanner;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.study.springcore.tx.dao.BookDao;

@Aspect
@Component
public class LogTemplate {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    @Pointcut(value = "execution(* com.study.springcore.tx.service.BookServiceImpl.buyOne(..))")
	public void pt() {}
	
	@Pointcut(value = "execution(* com.study.springcore.tx.service.BookServiceImpl.buyMany(..))")
	public void pt2() {}
	
	@Before(value = "pt()||pt2()")
	public void log() {
		System.out.println("1");
	}
	
}
