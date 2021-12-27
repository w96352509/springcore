package com.study.springcore.case08;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {
	
	@Autowired
	private JsonDB jsonDB;
	
	@Override
	public boolean create(Person person) {
		Boolean check = null;
		try {
			check = jsonDB.add(person);
		} catch (Exception e) {
			e.printStackTrace();
			check = false ;
		}
		return check;
	}

	@Override
	public List<Person> readAll() {
		List<Person> people = null;
		try {
			people = jsonDB.queryAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return people;
	}

	@Override
	public boolean delete(Person person) {
		     Boolean check = null;
		try {
		        check = jsonDB.delete(person);	
		} catch (Exception e) {
			
		}
		return check;
	}

	@Override
	public boolean upt(Person person,Date Birth) {
		      Boolean check = null;
		      try {
				check = jsonDB.upt(person, Birth);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return check;
	}

	

	

	
	
}
