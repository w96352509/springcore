package com.study.springcore.aop_lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//使用 JAVA 配置來替代 .xml

@Configuration          // 此類別為配置檔
@EnableAspectJAutoProxy // 啟動 AOP 自動代理機制
@ComponentScan          // 啟動自動掃描
public class AOPConfig {
  
	@Bean(name = "dancer")    
	public Performance dancer() {
	  return new Dancer();  //代理建立
    }
	
	@Bean
	public Audience audience() {
		return new Audience();
	}
	
	@Bean
	public Introducter introducter() {
		return new Introducter();
	}
}
