package com.study.springcore.jdbc.template;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPTemplate {
    //存檔目錄路徑
	private String pathname = "C:/Users/vic/git/repository10/springcore/src/main/java/com/study/springcore/jdbc/logintime";
	
	//切入方法
	@Pointcut(value = "execution(* com.study.springcore.jdbc.template.EmpDao.queryAll(..))")
	public void pt() {
	}

	// 前置通知
	@Before(value = "pt()")
	public void log(JoinPoint joinPoint) throws IOException {
		Date date = new Date();
		
		String name = joinPoint.getSignature().getName();
		
		System.out.println("方法名稱 :" + joinPoint.getSignature().getName() + "" + "紀錄時間:" + date);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		
		String dateToStr = dateFormat.format(date) ;
		
		Path userhome = Paths.get(pathname ,dateToStr) ;
		
		if (Files.notExists(userhome)) {
			create(userhome,name,date);
		}
	}

	
	public void create(Path userhome , String name , Date date) throws IOException {
		// 創建目錄
		Files.createDirectories(userhome);
		//時間格式
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		String datetime = dateFormat.format(date);
		//創建檔案並設定名稱
		Path profile = userhome.resolve(name+dateFormat.format(date) + ".txt"); 
		System.out.println(name+datetime+".txt");
		//寫入 profile 所創的檔案中
		try (BufferedWriter writer = Files.newBufferedWriter(profile)) {
			//內容
			writer.write(String.format("%s , %s", name , date)); //
		}
	}
}
