package com.mypro.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypro.pojo.User;

import com.mypro.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepositery;

	public UserService() {

	}

	public UserService(UserRepository userRepositery) {

		this.userRepositery = userRepositery;
	}

	public String addUser(User user) {
		userRepositery.save(user);
		return "Üser added successfully";
	}

	public List<User> getAllUsers() {

		return userRepositery.findAll();
	}

	public String deleteUser(long mobile) {
		userRepositery.deleteUserByMobile(mobile);
		return "user deleted successfully";
	}

	public User updateUser(User user) {
		return userRepositery.save(user);
	}

	public User getUserByMobile(long mobile) {

		return userRepositery.findByMobile(mobile);
	}

	public User getUserById(String id) {
	
		return userRepositery.findUserById(id);
	}

	
	

}
