package com.study.springcore.jdbc.entity;

import java.util.Date;

public class emp {

	private Integer eid ;
	private String name;
	private Integer age;
	private Date createtime;
	
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "emp [eid=" + eid + ", name=" + name + ", age=" + age + ", createtime=" + createtime + "]";
	}
}
