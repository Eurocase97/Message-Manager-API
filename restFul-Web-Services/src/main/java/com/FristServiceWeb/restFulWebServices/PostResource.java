package com.FristServiceWeb.restFulWebServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResource {

	@Autowired
	private PostDaoService posts; 
	
	@GetMapping(path="/user/{id}/post")
	public List<Post> getPostsByUserId(@PathVariable int id) {
		return posts.getAllPostsUserId(id);
	}
	
	@PostMapping(path="user/{id}/post")
	public Post createPost(@RequestBody Post p, @PathVariable int id) {
		if(p.getUserId()==-1) {
			p.setUserId(id);
		}
		return posts.savePost(p);
	}
	
	@GetMapping(path="/user/{id}/post/{post_id}")
	public Post getPost(@PathVariable int id, @PathVariable int post_id) {
		return posts.findOne(post_id);
	}
}