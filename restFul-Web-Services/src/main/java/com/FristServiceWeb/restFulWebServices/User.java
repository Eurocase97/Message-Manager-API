package com.FristServiceWeb.restFulWebServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

public class User {

	private int id;
	private String name;
	private Date birthDate;
	private List<Post> posts;
	
	public User() {
		this.id=-1;
		this.birthDate=null;
		this.name="";
		posts = new ArrayList<Post>();
	}

	public User(int id,String name,Date birthDate) {
		this.id=id;
		this.birthDate=birthDate;
		this.name=name;
		posts = new ArrayList<Post>();
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