package br.net.galdino.restfulwebservices.resource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import br.net.galdino.restfulwebservices.bean.Post;
import br.net.galdino.restfulwebservices.bean.User;
import br.net.galdino.restfulwebservices.exception.PostNotFoundException;
import br.net.galdino.restfulwebservices.exception.UserNotFoundException;
import br.net.galdino.restfulwebservices.repository.PostRepository;
import br.net.galdino.restfulwebservices.repository.UserRepository;
import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	private UserRepository repository;
	private PostRepository postRepository;

	public UserJpaResource(UserRepository repository, PostRepository postRepository) {
		super();
		this.repository = repository;
		this.postRepository = postRepository;
	}

	@GetMapping("/jpa/users")
	public List<User> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> findOne(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id " + id + " not found");
		
		EntityModel<User> entityModel = EntityModel.of(user.get());		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAll());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void delete(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> savePostFromUser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id " + id + " not found");
		post.setUser(user.get());
		Post savedPost = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getPostsFromUser(@PathVariable int id) {
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id " + id + " not found");
		return user.get().getPosts();
	}
	
	@GetMapping("/jpa/users/{userId}/posts/{postId}")
	public EntityModel<Post> findByIdAndUser(@PathVariable int userId, @PathVariable int postId) {
		Optional<Post> post = Optional.ofNullable(postRepository.findByIdAndUserId(postId, userId));

		if(post.isEmpty())
			throw new PostNotFoundException("post id " + postId + " from user id " + userId + " not found");
		
		EntityModel<Post> entityModel = EntityModel.of(post.get());		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getPostsFromUser(userId));
		entityModel.add(link.withRel("posts-from-user"));
		
		return entityModel;
	}

}
