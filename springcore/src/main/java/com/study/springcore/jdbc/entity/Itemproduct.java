package com.study.springcore.jdbc.entity;

import java.util.List;

public class Itemproduct {

	private Integer id;
	private String pname;
	private Integer price;
	private Integer inventory;
	
	
	private List<Item> items;
	
	
	public Itemproduct() {
		
	}


	public Itemproduct(Integer id, String pname, Integer price, Integer inventory, List<Item> items) {
		
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.inventory = inventory;
		this.items = items;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getInventory() {
		return inventory;
	}


	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Itemproduct [id=" + id + ", pname=" + pname + ", price=" + price + ", inventory=" + inventory
				+ ", items=" + 
				items
				+ "]";
	}


	
	


	
	
}
