package com.study.springcore.case08;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonSystem {
	private ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext8.xml");
	private PersonController personController = ctx.getBean("personController", PersonController.class);
	private boolean stop;
	
	private void menu() {
		System.out.println("=========================================");
		System.out.println("1. 建立 Person 資料");
		System.out.println("2. 取得 Person 全部資料");
		// 作業 2:
		System.out.println("3. 根據姓名取得 Person");
		System.out.println("4. 取得今天生日的 Person");
		System.out.println("5. 取得某一歲數以上的 Person");
		System.out.println("6. 根據姓名來修改Person的生日");
		System.out.println("7. 根據姓名來刪除Person");
		System.out.println("0. 離開");
		System.out.println("=========================================");
		System.out.print("請選擇: ");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch (choice) {
			case 1:
				createPerson();
				break;
			case 2:
				printPersons();
				break;
			case 3:
				printgetByName();
				break;
			case 4:
				printgetBirth();
				break;
			case 5:
				printgetByage();
				break;
			case 6:
				uptBirth();
				break;
			case 7:
				delByName();
				break;
			case 0:
				System.out.println("離開系統");
				stop = true;
				break;
		}
	}
	
	private void createPerson() {
		System.out.print("請輸入姓名 生日年 月 日: ");
		// Ex: Jack 1999 4 5
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		int yyyy = sc.nextInt();
		int mm = sc.nextInt();
		int dd = sc.nextInt();
		personController.addPerson(name, yyyy, mm, dd);
	}
	//2.
	private void printPersons() {
		personController.printAllPersons();
	}
	//3.
	private void printgetByName() {
		System.out.print("請輸入名稱");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		personController.getPersonByNames(name);
	}
	//4.
	private void printgetBirth() {
		System.out.print("請今日or時間: ");
		Scanner sc = new Scanner(System.in);
		int yyyy = sc.nextInt();
		int mm = sc.nextInt();
		int dd = sc.nextInt();
		personController.getBirth(yyyy, mm, dd);	}
	//5.
	private void printgetByage() {
		System.out.print("請輸入年齡");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		personController.getage(age);
	}
	//6.
	private void uptBirth() {
		System.out.print("請輸入姓名 生日年 月 日: ");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		int yyyy = sc.nextInt();
		int mm = sc.nextInt();
		int dd = sc.nextInt();
		personController.uptParson(name, yyyy, mm, dd);
	}
	//7.
		private void delByName() {
			System.out.print("請輸入姓名");
			Scanner sc = new Scanner(System.in);
			String name = sc.next();
			personController.delParson(name);
		}
	public void start() {
		while (!stop) {
			menu();
		}
	}
	
	
	public static void main(String[] args) {
		new PersonSystem().start();
	}

}