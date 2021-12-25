package com.FristServiceWeb.restFulWebServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;


@Component 
public class UserDaoService {

	private static List<User> users= new ArrayList<User> ();
	static {
		users.add(new User(1,"nico",new Date()));
		users.add(new User(2,"emi",new Date()));
		users.add(new User(3,"karen",new Date()));	
	} 
	
	public List<User> getAll(){
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId()==-1) {
			user.setId(users.size()+1);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		User userFound = new User();
		int flag=0;
		for(User u : users) {
			if(u.getId()==id && flag==0) {
				userFound=u;
				flag=1;
			}
		}
		return userFound;
	}
	
	public User deleteById(int id) {
		User userFound = new User();
		Iterator<User> it = users.iterator();
		while(it.hasNext()) {
			User u = it.next();
			if(u.getId()==id) {
				userFound = u;
				it.remove();
			}
		}
	
		return userFound;
	}
	
	public boolean IsId(int id) {
		boolean flag= false;
		for(int i=0; i<users.size() && flag==false; i++) {
			if(users.get(i).getId()==id) {
				flag=true;
			}
		}
		return flag;
	}
	
}