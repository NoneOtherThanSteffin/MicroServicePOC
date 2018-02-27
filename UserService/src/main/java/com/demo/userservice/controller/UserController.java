package com.demo.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.userservice.model.UserDetails;
import com.demo.userservice.service.UserService;

@RestController
@RequestMapping("/demo")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@RequestParam("userid") Long userid) {
		ResponseEntity<?> response = userService.getUser(userid);
		return response;
	}

	@RequestMapping(value = "/users/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() {
		ResponseEntity<?> response = userService.getAllUsers();
		return response;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDetails user) {
		ResponseEntity<?> response = userService.saveUser(user);
		return response;
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UserDetails user) {
		ResponseEntity<?> response = userService.updateUser(user);
		return response;
	}

	@RequestMapping(value = "/user/valid", method = RequestMethod.GET)
	public ResponseEntity<?> validUser(@RequestParam("userid") Long userid) {
		ResponseEntity<?> response = userService.isValidUser(userid);
		return response;
	}

	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@RequestParam("userid") Long userid) {
		ResponseEntity<?> response = userService.deleteUser(userid);
		return response;
	}
}
