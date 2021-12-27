package com.study.springcore.case08;

import java.util.Date;
import java.util.List;

public interface PersonDao {
	// 建立 Person
	public boolean create(Person person);
	// 查詢所有 Person
	public List<Person> readAll();
	
	public boolean upt(Person person,Date Birth);
	
	public boolean delete(Person person);
	
}
