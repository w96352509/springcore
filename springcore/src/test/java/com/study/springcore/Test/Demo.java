package com.study.springcore.Test;
import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;
public class Demo {
	public static int sumD3(int x , int y) {
    	return IntStream.range(x, y)
    			.map(n->{
    				//System.out.println(n);
    				return n;
    			})
    			.map(n->n*2)
    			.filter(n-> n % 3 ==0).sum();
    }
    @Test
   	public void sum() throws Exception{
   		Assert.assertEquals(1314,sumD3(100 ,120));
    }
}
  
