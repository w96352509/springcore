package com.study.springcore.Test;

import java.util.Random;

public class CreateId {
	// 地區英文驗證
	static String checkHead = "ABCDEFGHJKLMNPQRSTUVWXYZIO";

	public static void main(String[] args) {
		Random r = new Random();
		String s = "";
		int checknum = 0; // 產生前9碼的同時計算產生驗證碼

		// 產生第一個英文字母
		int t = (r.nextInt(26) + 65);
		// System.out.println(t);
		s += (char) t;
		t = checkHead.indexOf((char) t) + 10;
		System.out.println("地區代碼" + s);
		System.out.println("checkHead得位置:" + t);
		checknum += t / 10; // 第一碼驗證: checkHead位置10/10取第一碼
		System.out.println("checknum:" + checknum);
		checknum += t % 10 * 9; // 第二碼驗證: 取餘數第二碼 *9
		System.out.println("checknum%10:" + checknum);
		// 產生第2個數字 (1~2)
		s += Integer.toString(t = r.nextInt(2) + 1);
		checknum += t * 8;
		
		// 產生後3~9碼   ㄠ
		for (int i = 2; i < 9; i++) {
			s += Integer.toString(t = r.nextInt(10));
			checknum += t * (9 - i); //產生順便驗證驗證程序
			System.out.println(i);
			System.out.println("號碼產生中"+s);
		}
		// 完成驗證碼計算 checknum 總和 //創出符合條件的第10碼
		System.out.println("驗證前:" + checknum);
		checknum = (10 - ((checknum) % 10)) % 10; // 找到補足10的方法
		System.out.println("驗證後:" + checknum);  //補足10整數的最後一碼
		s += Integer.toString(checknum); // 最後一碼+到String中
		System.out.println(s);
	}
}
