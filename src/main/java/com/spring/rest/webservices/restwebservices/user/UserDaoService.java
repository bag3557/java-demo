package com.spring.rest.webservices.restwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int usersCount = 0;

	static {
		users.add(new User(++usersCount, "AJIT", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "DEVA", LocalDate.now().minusYears(35)));
		users.add(new User(++usersCount, "BIG B", LocalDate.now().minusYears(40)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		users.removeIf(predicate);
	}

	public User addUser(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
}
