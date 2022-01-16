package com.study.springcore.jdbc.entity;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
public class Item {
    
	//欄位
	private Integer id;
	private Integer amount;
	private Integer invid;
	private Integer ipid;
	
	private static Integer count;
    
	//關係
	private Invoice invoice;
	private Itemproduct itemproduct;
	
	
	
	
	public Item() {
		
	}

	public Item(Integer id, Integer amount, Integer invid, Integer ipid, Invoice invoice, Itemproduct itemproduct) {
		
		this.id = id;
		this.amount = amount;
		this.invid = invid;
		this.ipid = ipid;
		this.invoice = invoice;
		this.itemproduct = itemproduct;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getInvid() {
		return invid;
	}

	public void setInvid(Integer invid) {
		this.invid = invid;
	}

	public Integer getIpid() {
		return ipid;
	}

	public void setIpid(Integer ipid) {
		this.ipid = ipid;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Itemproduct getItemproduct() {
		return itemproduct;
	}

	public void setItemproduct(Itemproduct itemproduct) {
		this.itemproduct = itemproduct;
	}

	
	
	

	

	@Override
	public String toString() {
		return "Item [id=" + id + ", amount=" + amount +", invid=" + invid + ", ipid=" + ipid 
				+ ", invoice=" 
				+ (invoice==null?"": invoice.getId())
				+ ", itemproduct=" 
				+ (itemproduct==null?" ": itemproduct.getPname())
				+ "]";
	}

	

    
	
}
