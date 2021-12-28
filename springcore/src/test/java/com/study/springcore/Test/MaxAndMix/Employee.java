package com.study.springcore.Test.MaxAndMix;

import java.util.Objects;

public class Employee {

	private String name;
	private Integer price;
	private String name2;

	public Employee(String name, Integer price, String name2) {

		this.name = name;
		this.price = price;
		this.name2 = name2;
	}

	public Employee() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, name2, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name) && Objects.equals(name2, other.name2)
				&& Objects.equals(price, other.price);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", price=" + price + ", name2=" + name2 + "]";
	}
	
	

}
