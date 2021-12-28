package com.study.springcore.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Boxed {

	public static void main(String[] args) {
		List<String> strings = Stream.of("1","2").collect(Collectors.toList());
		
		List<Integer> ints0 = Stream.of(1,3,5,7).collect(Collectors.toList());
		System.out.println(ints0);
		
		List<Integer> ints = IntStream.of(1,3,5,7).boxed().collect(Collectors.toList());
		System.out.println(ints);
		System.out.println(IntStream.rangeClosed(1, 10).mapToObj(Integer::valueOf).collect(Collectors.toList()));
		
		List<Integer> ints2 = IntStream.of(3, 1, 4, 1, 5, 9)
//           .collect(Collectors.toList());
             .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(ints2);
		
		int[] Arrays2 = IntStream.of(3,1).toArray();
		System.out.println(Arrays.toString(Arrays2));
		
		int sum = Arrays.stream(Arrays2).sum();
		System.out.println(sum);
		
	}
	
}
