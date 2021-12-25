package Resource.copy;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.FristServiceWeb.restFulWebServices.User;
import com.FristServiceWeb.restFulWebServices.UserDaoService;
import com.FristServiceWeb.restFulWebServices.UserNotFoundException;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path= "/allUsers")
	public List<User> retrieveAllUsers(){
		return service.getAll();	
	}
	
	@GetMapping(path= "/user/{id}")
	public User getById(@PathVariable int id) {		
		User user= service.findOne(id);
		if(user.getId()==-1) {
			throw new UserNotFoundException("Not found id "+id);
		}
		return user; 
	}	
	
	@PostMapping(path="/user")
	public ResponseEntity<Object> creatUsers(@RequestBody User user) {
		if(service.IsId(user.getId())) {
			return new ResponseEntity<>("This ID is not enabled", HttpStatus.CONFLICT);
		}else {
			service.saveUser(user);
			URI location= ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").
				buildAndExpand(user.getId()).toUri();
			return ResponseEntity.created(location).build();
			//return new ResponseEntity<>("This ID is enabled", HttpStatus.ACCEPTED);
		}
	}
}