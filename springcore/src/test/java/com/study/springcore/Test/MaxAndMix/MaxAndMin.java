package com.study.springcore.Test.MaxAndMix;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MaxAndMin {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
                new Employee("Cersei"  ,250_000  , "Lannister"),
                new Employee("Jamie"   ,150_000  , "Lannister"),
                new Employee("Tyrion"  ,1_000    , "Lannister"),
                new Employee("Tywin"   ,1_000_000, "Lannister"),
                new Employee("Jon Snow",75_000   , "Stark"),
                new Employee("Robb"    ,120_000  , "Stark"),
                new Employee("Eddard"  ,125_000  , "Stark"),
                new Employee("Sansa"   ,0        , "Stark"),
                new Employee("Arya"    ,1_000    , "Stark"));
	  Employee defaultEmployee = new Employee("A man (or woman) has no name", 0, "Black and White");
	  Optional<Employee> maxproice = employees.stream().max(Comparator.comparingInt(Employee::getPrice));
	  System.out.println(maxproice);
	}

}
