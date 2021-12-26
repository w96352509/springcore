package com.study.springcore.case01;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Test5 {
    public static void main(String[] args) {
       String name = Stream.of("1","2").collect(Collectors.joining("."));
       System.out.println(name);
       List<String> names = Stream.of("1","2").collect(Collectors.toList());
       names.add("3");
       System.out.println(names);
       names.removeIf(s->s.startsWith("3"));
       System.out.println(names);
    }
}

