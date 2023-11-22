package br.net.galdino.restfulwebservices.resource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.net.galdino.restfulwebservices.bean.User;
import br.net.galdino.restfulwebservices.dao.UserDao;
import br.net.galdino.restfulwebservices.exception.UserNotFoundException;
import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDao userDao;
	
	public UserResource(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@GetMapping("/users")
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> findOne(@PathVariable int id) {
		User user = userDao.findOne(id);
		if(user == null)
			throw new UserNotFoundException("id " + id + " not found");
		
		EntityModel<User> entityModel = EntityModel.of(user);		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> save(@Valid @RequestBody User user) {
		user = userDao.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable int id) {
		userDao.delete(id);
	}

}
