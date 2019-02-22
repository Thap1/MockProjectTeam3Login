package com.spring.cmc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cmc.entity.User;
import com.spring.cmc.repository.UserRepository;
import com.spring.cmc.services.impl.UserServiceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@GetMapping(value = "/user")
	public ResponseEntity<List<User>> listUser(){
//		List<User> listCurrent = userService.findAll();
//		List<User> listNew =new  ArrayList<User>();
//		for (User user : listCurrent) {
//			user.setGroups(null);
//			listNew.add(user);
//		}
		System.out.println(userService.findAll());
		return new ResponseEntity<List<User>>(userService.findAll(),HttpStatus.OK);
	}

	
	@GetMapping(value = "/user/infor/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id){
		if(userService.findById(id) == null) {
			return new ResponseEntity<User>(userService.findById(id),HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<User>(userService.findById(id),HttpStatus.OK);
		} 
	}
	
	@PostMapping(value = "/user/create")
	public ResponseEntity<String> addUser(@RequestBody User user){
		userService.save(user);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/user/update/{id}")
	public ResponseEntity<String> update(@RequestBody User user){
		userService.save(user);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/user/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		userService.deleteUser(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
	
	
	

}
