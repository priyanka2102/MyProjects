package com.ts.us.dao;

import java.sql.Date;

public class MyUser {
	private int id;
	private String uname;
	private String password;
	private String gender;
	private String email;
	private long mno;
	private Date date;
	public MyUser() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMno() {
		return mno;
	}
	public void setMno(long mno) {
		this.mno = mno;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MyUser [id=" + id + ", uname=" + uname + ", password=" + password + ", gender=" + gender + ", email="
				+ email + ", mno=" + mno + ", date=" + date + "]";
	}
	
	

}
