package com.springboot.mongotest.user.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.springboot.mongotest.user.model.User;

@Repository
public class UserDALImpl implements UserDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public User getUserById(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public User addNewUser(User user) {
		mongoTemplate.save(user);
		return user;
	}

	@Override
	public Object getAllUserSettings(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserSetting(String userId, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addUserSetting(String userId, String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
