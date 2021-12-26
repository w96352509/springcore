package com.study.springcore.case08;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class JsonDB {                  //Json資料庫

	@Autowired
	private Gson gson;
	
	//Json file 資料存放地
	private static final Path PATH = Paths.get("src/main/java/com/study/springcore/case08/person.json");
	
	
	//查詢全部
	public List<Person> queryAll() throws Exception{
		String jsonstr = Files.readAllLines(PATH).stream().collect(Collectors.joining());
		Type type = new TypeToken<ArrayList<Person>>() {}.getType();
		List<Person> people = gson.fromJson(jsonstr, type);
		Date date = new Date();
		int year = date.getYear();
		//改變年齡
		for(Person person1 : people) {
			int birth=person1.getBirth().getYear();
			int age = year-birth;
			person1.setAge(age);
		}
		return people;
	}
}
