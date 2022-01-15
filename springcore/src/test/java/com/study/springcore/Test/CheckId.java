package com.study.springcore.Test;
import java.util.Arrays;
import java.util.Scanner;

public class CheckId {

	public static void main(String[] args) {
		System.out.print("請輸入身分證字號: ");
		String id = new Scanner(System.in).next();
		System.out.println(id);
		int[] nums = new int[11]; // 英文(2)index(0,1) + 數字(9)index(2~10)
		//System.out.println(id.charAt(0));
		//int x = id.charAt(1);
		//System.out.println(id.charAt(1));
		//System.out.println(x - 48);
		System.out.println(id.length());
		for(int i=1;i<id.length();i++) {
			//System.out.println(i);        //最後一輪i =9
			nums[i+1] = id.charAt(i) - 48;  //index(2~10) 
			}
		
		switch (id.charAt(0)) {
			case 'A':
				nums[0] = 1;nums[1] = 0;
				break;
			case 'F':
				nums[0] = 1;nums[1] = 5;
				break;	
		}
		//System.out.println(Arrays.toString(nums));
		// 驗證
		int[] m = {1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
		//System.out.println(Arrays.toString(m));
		int sum = 0;
		// nums 與 m 依序相乘
		for(int i=0;i<nums.length;i++) {
			sum += nums[i] * m[i];
		}
		System.out.println(sum);
		System.out.println(sum % 10 == 0);
	}

}