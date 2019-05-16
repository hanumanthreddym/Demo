package com.mypro.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mypro.pojo.User;

public interface UserRepository extends MongoRepository<User, String>{

	void deleteUserByMobile(long mobile);

	User findByMobile(long mobile);

	User findUserById(String id);



}
