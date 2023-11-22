package br.net.galdino.restfulwebservices.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import br.net.galdino.restfulwebservices.bean.User;

@Component
public class UserDao {
	
	private static List<User> users = new ArrayList<User>();
	
	private static int userCount = 0;
	
	static {
		users.add(new User(++userCount, "Wagner", LocalDate.now().minusYears(57)));
		users.add(new User(++userCount, "Claudio", LocalDate.now().minusYears(54)));
		users.add(new User(++userCount, "Marina", LocalDate.now().minusYears(76)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
    public User findOne(int id) {
    	Predicate<? super User> predicate = user -> user.getId().equals(id); 
    	return users.stream().filter(predicate).findFirst().orElse(null);
    }
    
    public void delete(int id) {
    	Predicate<? super User> predicate = user -> user.getId().equals(id); 
    	users.removeIf(predicate);
    }

}
