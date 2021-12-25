package com.FristServiceWeb.restFulWebServices;

public class Post {

	private int id;
	private int userId;
	private String post;
	
	public Post() {
		userId=-1;
		post="";
		id=-1;
	}
	
	public Post(int userId, String post) {
		super();
		this.userId = userId;
		this.post = post;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}	
}