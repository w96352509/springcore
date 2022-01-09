package com.study.springcore.aop_lab;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class Introducter {  //經紀人
   
	// 將 Performance 及其子類別轉會為 Singer
	
	@DeclareParents(value = "com.study.springcore.aop_lab.Performance+", //要被轉換者Performance的位置
			        defaultImpl = BackSinger.class) //替補類別
	public Singer singer;
	
	@DeclareParents(value = "com.study.springcore.aop_lab.Performance+", //要被轉換者Performance的位置
	        defaultImpl = TalkActor.class) //替補類別
	public Actor actor;
	
}
