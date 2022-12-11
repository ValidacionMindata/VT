package com.mindata.challenge.model;

import java.util.Date;

public class Course {
	private String name;
	private Date date;
	
	public Course(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
