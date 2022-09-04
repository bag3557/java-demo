package com.springboot.mongotest.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongotest.user.dal.UserDAL;
import com.springboot.mongotest.user.dal.UserRepository;
import com.springboot.mongotest.user.model.User;

@RestController
@RequestMapping(value = "/")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;

//	private final UserDAL userDAL;

	public UserController(UserRepository userReopository) {
		this.userRepository = userReopository;
//		this.userDAL = userDAL;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

//	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
//	public User getUser(@PathVariable String userId) {
//		LOG.info("Getting user with ID: {}.", userId);
//		return userRepository.findOne(userId);
//	}
}
