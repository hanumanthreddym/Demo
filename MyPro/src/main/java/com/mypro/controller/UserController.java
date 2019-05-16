package com.mypro.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mypro.mongoConfig.MongoConfig;
import com.mypro.pojo.User;
import com.mypro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private GridFsOperations fsOperations;

	public UserController(UserService userService) {

		userService = new UserService();
	}

	@PostMapping(consumes = "application/json")
	public String addUser(@RequestBody User user) {
		System.out.println("called......!");
		return userService.addUser(user);

	}

	@GetMapping
	public List<User> getAllUser() {
		return userService.getAllUsers();

	}

	@DeleteMapping("/delete/{mobile}")
	public String deleteUser(@PathVariable long mobile) {
		return userService.deleteUser(mobile);

	}

	@GetMapping("/mobile/{mobile}")
	public User getUserByMobile(@PathVariable long mobile) {

		return userService.getUserByMobile(mobile);

	}

	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable String id, @RequestBody User user) {
	    user.setId(id);
		return userService.updateUser(user);

	}
	
	@GetMapping("/get/{id}")
	public User getUserById(@PathVariable String id) {
		return userService.getUserById(id);
		
	}
	
	public String storefileInDB() throws FileNotFoundException {
		DBObject object=new BasicDBObject();
		object.put("Orgnization", "pro");
		
		InputStream inputStream=new FileInputStream("E:/first.txt");
		object.put("type", "data");
		
		
		return null;
		
	}
	

}
