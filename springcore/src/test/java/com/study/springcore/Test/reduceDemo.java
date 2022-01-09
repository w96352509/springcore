package com.study.springcore.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Stream;

public class reduceDemo {

	public static void main(String[] args) {
		Integer max = Stream.of(3,4,5,6,7,8).reduce(Integer.MIN_VALUE,Integer::max);
		System.out.println(max);
		Optional<String> s = Stream.of("this" , "is" , "a").reduce(String::concat);
		System.out.println(s);
		
		 List<Book> books = Arrays.asList(
	                new Book(3, "Modern Java Recipes"),
	                new Book(2, "Making Java Groovy"),
	                new Book(1, "Gradle Recipes for Android"),
	                new Book(4, "Kotlin Cookbook"));
		 TreeMap<Integer, Book> bookMap = books.stream()
	                .reduce(new TreeMap<Integer, Book>(),  // identity for putAll
	                        (map, book) -> {               // map 用來裝取book(建構子表達式)
	                            map.put(book.getId(), book);
	                            return map;
	                        },
	                        (map1, map2) -> {              // 平行才有用
	                            map1.putAll(map2);
	                            return map1;
	                        });

	        bookMap.forEach((k,v) -> System.out.println(k + ": " + v));
	        
	        BigDecimal total = Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
	                .limit(10)
	                .reduce(BigDecimal.ZERO, (acc, val) -> acc.add(val));
	        System.out.println("The total is " + total);
	        
	        
		
	}
}
