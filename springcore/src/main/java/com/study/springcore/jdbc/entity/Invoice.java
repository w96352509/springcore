package com.study.springcore.jdbc.entity;

import java.util.Date;
import java.util.List;

public class Invoice {
    //欄位
	private Integer id ;
	private Date invdate;

	private List<Item> items;
	
	public Invoice() {
		
	}

	public Invoice(Integer id, Date invdate, List<Item> items) {
		
		this.id = id;
		this.invdate = invdate;
		this.items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInvdate() {
		return invdate;
	}

	public void setInvdate(Date invdate) {
		this.invdate = invdate;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", invdate=" + invdate + ", items=" 
	           + items + "]";
	}

	

	
	
  
	
    


	
}
