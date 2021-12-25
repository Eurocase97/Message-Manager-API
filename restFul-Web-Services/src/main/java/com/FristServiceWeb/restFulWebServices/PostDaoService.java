package com.FristServiceWeb.restFulWebServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {

	private static List<Post> posts= new ArrayList<Post> ();
	static {
		posts.add(new Post(1,"nico"));
		posts.add(new Post(2,"emi"));
		posts.add(new Post(3,"karen"));	
	} 
	
	public List<Post> getAll(){
		return posts;
	}
	
	public Post savePost(Post post) {
		if (post.getId()==-1 || IsId(post.getId())) {
			post.setId(posts.size()+1);
		}
		posts.add(post);
		return post;
	}
	
	public Post findOne(int id) {
		Post postFound = new Post();
		int flag=0;
		for(Post u : posts) {
			if(u.getId()==id && flag==0) {
				postFound=u;
				flag=1;
			}
		}
		return postFound;
	}

	public boolean IsId(int id) {
		boolean flag= false;
		for(int i=0; i<posts.size() && flag==false; i++) {
			if(posts.get(i).getId()==id) {
				flag=true;
			}
		}
		return flag;
	}
	
	public List<Post> getAllPostsUserId(int id) {
		List<Post> postsById = new ArrayList<Post>();
		for(Post p : posts) {
			if(id == p.getUserId()) {
				postsById.add(p);
			}
		}
		return postsById;
	}
}