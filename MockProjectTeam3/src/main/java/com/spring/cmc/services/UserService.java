package com.spring.cmc.services;

import java.util.List;

import com.spring.cmc.entity.User;

public interface UserService {

	List<User> findAll();
	
	User findById(int id);
	
	User save(User user);
	
	boolean deleteUser(int id);
	
	
	
}
