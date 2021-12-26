package com.FristServiceWeb.restFulWebServices;

import java.util.Date;

public class User {

	private int id;
	private String name;
	private Date birthDate;
	
	public User() {
		this.id=-1;
		this.birthDate=null;
		this.name="";
	}

	public User(int id,String name,Date birthDate) {
		this.id=id;
		this.birthDate=birthDate;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
	public String toString() {
		return "ID= "+ this.id+" Name: "+name+" BirthDay"+ this.birthDate;	
		
	}
	public String toStringUnderlined() {
		return "ID= "+ this.id+" Name: "+name+" BirthDay"+ this.birthDate+
				"\n"+"--------------------------------------"; 	
	}
}