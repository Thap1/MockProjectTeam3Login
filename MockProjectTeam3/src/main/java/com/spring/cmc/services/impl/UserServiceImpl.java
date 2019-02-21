package com.spring.cmc.services.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.cmc.entity.User;
import com.spring.cmc.repository.UserRepository;
import com.spring.cmc.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	//public final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	private UserRepository userRepository;
	
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		Optional<User> create = userRepository.findById(user.getUserId());
		if(create.isPresent()) {
			return null;
		}
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		try {
			userRepository.deleteById(id);
			return true;
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
