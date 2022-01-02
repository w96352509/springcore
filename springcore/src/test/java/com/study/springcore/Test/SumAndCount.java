package com.study.springcore.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumAndCount {
  
	public static void main(String[] args) {
	
		
		int sum = IntStream.of(1,2,3,4,5,6,7,8,9,10).reduce(1,(x,y)->{
			System.out.printf("x=%d , y=%d%n",x,y);
			return x+(y+1);
		});
		int[] arr = {1,2,3,4} ;
		int i = 0;
		do {
			System.out.println(arr[i]);
			i++;
		} while (i<arr.length-1);
    }
}
