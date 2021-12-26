package com.study.springcore.case05;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test2 {
	public static void main(String[] args) {
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
	}
}
