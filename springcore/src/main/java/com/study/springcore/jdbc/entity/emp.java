package com.study.springcore.jdbc.entity;

import java.util.Date;

public class emp {

	private Integer eid ;
	private String ename;
	private Integer age;
	private Date createtime;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
		return "emp [eid=" + eid + ", ename=" + ename + ", age=" + age + ", createtime=" + createtime + "]";
	}
	
	
}
