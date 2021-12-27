package com.study.springcore.case08;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PersonService {
	boolean append(String name, Date birth);
	boolean append(Person person);
	boolean delete(String name);
	boolean delete(Person person);
	boolean upt(String name ,Date birth );
	boolean upt(Person person);
	List<Person> getPersons(String name);
	Person getPerson(String name);
	List<Person> getBirth(Date date);
	List<Person> getage(int age);
	List<Person> findAllPersons();
}