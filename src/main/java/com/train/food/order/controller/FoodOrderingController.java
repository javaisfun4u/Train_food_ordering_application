package com.train.food.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.food.order.service.UserService;

@RestController
@RequestMapping("/railway-food")
public class FoodOrderingController {

	@Autowired
	UserService userSer;

	@PostMapping("/users/signup/{username}/{password}")
	public ResponseEntity<Boolean> signupUser(@PathVariable String username, @PathVariable String password) {
		boolean signUo = userSer.signUp(username, password);
		return new ResponseEntity<Boolean>(signUo, HttpStatus.OK);

	}
	
	@GetMapping("/users/login/{username}/{password}")
	public ResponseEntity<Boolean> loginUser(@PathVariable String username, @PathVariable String password) {
		boolean login = userSer.login(username, password);
		return new ResponseEntity<Boolean>(login, HttpStatus.OK);

	}

}
