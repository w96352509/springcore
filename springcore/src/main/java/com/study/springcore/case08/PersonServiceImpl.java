package com.study.springcore.case08;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDao personDao;
	//題目1
	@Override
	public boolean append(String name, Date birth) {
		Person person = new Person();
		person.setName(name);
		person.setBirth(birth);
		return append(person);
	}
	//題目1
	@Override
	public boolean append(Person person) {
		return personDao.create(person);
	}
	//題目2
	@Override
	public List<Person> findAllPersons() {
		return personDao.readAll();
	}
	//題目3
	@Override
	public Person getPerson(String name) {
		Optional<Person> optPerson = findAllPersons()
				.stream()
				.filter(p -> p.getName().equals(name))
				.findFirst();
		return optPerson.isPresent() ? optPerson.get() : null;
	}
	//題目3
	@Override
	public List<Person> getPersons(String name) {
		List<Person> people =findAllPersons();
		List<Person> optPerson = 
				people.stream().filter(p ->p.getName().equals(name))
				.collect(Collectors.toList());
		System.out.println(optPerson);
		return optPerson;
	}
	
	//題目4
	@Override
	public List<Person> getBirth(Date date) {
		List<Person> persons = findAllPersons()
				.stream().filter(p->p.getBirth().equals(date)).collect(Collectors.toList());
		System.out.println(persons);
		return persons;
	}
	
	//題目5
	@Override
	public List<Person> getage(int age) {
		List<Person> people =findAllPersons();
		List<Person> optPerson = 
				people.stream()
				.filter(p->p.getAge()>=age).collect(Collectors.toList());
		System.out.println(optPerson);
		return optPerson;
	}
	
	//題目6
		@Override
		public boolean upt(String name , Date birth) {
			Person person =getPerson(name);
			       person.setBirth(birth);
			return upt(person);
		}
		//題目6
		@Override
		public boolean upt(Person person) {
			
			return personDao.upt(person, person.getBirth());
		}
	
	//題目7
	@Override
	public boolean delete(String name) {
		Person person = getPerson(name);
		return delete(person);
	}
	//題目7
	@Override
	public boolean delete(Person person) {
		return personDao.delete(person);
	}
	

	

	

	

	
	

	
	
}
