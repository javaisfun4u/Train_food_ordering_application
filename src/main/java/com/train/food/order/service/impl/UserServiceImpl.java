package com.train.food.order.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.food.order.entity.User;
import com.train.food.order.repo.UserRepository;
import com.train.food.order.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public boolean login(String username, String password) {
		Optional<User> findByUsername = repo.findByUsername(username);
		if (findByUsername.get().getUsername().equals(username) && findByUsername.get().getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean signUp(String username, String password) {
		Long uniqueNumber = (long) ((Math.random() * 9_000_000) + 1_000_000);
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setId(uniqueNumber);
		User save = repo.save(user);

		if (save != null) {
			return true;
		} else {
			return false;
		}
	}

}
