package com.study.springcore.case08;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
 * 功能:
 * 1. 建立 Person 資料
 * 		-> 輸入 name, birth
 * 2. 取得 Person 全部資料
 * 		-> 不用輸入參數
 * 3. 根據姓名取得 Person 
 * 		-> 輸入 name
 * 4. 取得今天生日的 Person 未做
 * 		-> 輸入今天日期
 * 5. 取得某一歲數以上的 Person
 * 		-> 輸入 age
 * 6. 根據姓名來修改Person的生日
 * 		-> 輸入 name, birth
 * 7. 根據姓名來刪除Person
 * 		-> 輸入 name
 * */

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	public void addPerson(String name, int yyyy, int mm, int dd) {
		// 1. 判斷 name, yyyy, mm 與 dd 是否有資料?
		// 2. 將 yyyy/mm/dd 轉日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date birth = sdf.parse(yyyy + "/" + mm + "/" + dd);
			addPerson(name, birth);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addPerson(String name, Date birth) {
		// 1. 判斷 name 與 birth 是否有資料?
		// 2. 建立 Person 資料
		boolean check = personService.append(name, birth);
		String  flag = "" ;
		if (check==true) {
			 flag = "創立成功" ;
		}else {
			 flag = "創立失敗名稱+生日都相同" ;
		}
		System.out.println("add person: " + flag);
	}
	
	//2.
	public void printAllPersons() {
		System.out.println(personService.findAllPersons());
	}
	
	// 根據姓名取得 Person(多)
	public List<Person> getPersonByNames(String name) {
		// 1. 判斷 name ?
		// 2. 根據姓名取得 Person
		List<Person> person = personService.getPersons(name);
		return person;
	}
	
	//3. 根據姓名取得 Person
		public Person getPersonByName(String name) {
			// 1. 判斷 name ?
			// 2. 根據姓名取得 Person
			Person person = personService.getPerson(name);
			return person;
		}
  
	
		//4. 取得今天生日的 Person 未做
	public void getBirth( int yyyy, int mm, int dd){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date date = sdf.parse(yyyy + "/" + mm + "/" + dd);
			getBirth(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//4.
    public List<Person> getBirth(Date date){
		List<Person> person  = personService.getBirth(date);
		System.out.println(person);
    	return person;
	}
	//5. 取得某一歲數以上的 Person
	public List<Person> getage(int age) {
		List<Person> person = personService.getage(age);
		return person;
	}
	//6.根據姓名來修改Person
	public void uptParson(String name, int yyyy, int mm, int dd) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date birth = sdf.parse(yyyy + "/" + mm + "/" + dd);
			uptParson(name, birth);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void uptParson(String name , Date Birth) {
		boolean person = personService.upt(name , Birth);
		System.out.println(person+"已修改");
	}
	
	//7. 根據姓名來刪除Person
	public void delParson(String name) {
		boolean person = personService.delete(name);
		System.out.println(person+"已刪除");
	}
}
