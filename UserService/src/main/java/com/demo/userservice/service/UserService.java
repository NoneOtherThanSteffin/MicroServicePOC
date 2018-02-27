package com.demo.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.userservice.model.UserDetails;
import com.demo.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	public ResponseEntity<?> getUser(Long userID) {
		UserDetails user = userRepo.findOne(userID);
		ResponseEntity<?> userResponseEntity = null;
		if (user == null) {
			userResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
			return userResponseEntity;
		} else {
			userResponseEntity = ResponseEntity.status(HttpStatus.OK).body(user);
			return userResponseEntity;
		}

	}

	public ResponseEntity<?> getAllUsers() {
		List<UserDetails> userList = userRepo.findAll();
		ResponseEntity<?> userResponseEntity = null;
		if (userList == null || !(userList.size() > 0)) {
			userResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(userList);
			return userResponseEntity;
		} else {
			userResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(userList);
			return userResponseEntity;
		}
	}

	public ResponseEntity<?> saveUser(UserDetails user) {
		UserDetails savedUser = userRepo.findOne(user.getEmployeeID());
		if (savedUser == null) {
			savedUser = userRepo.save(user);
		}
		ResponseEntity<?> userResponseEntity = null;
		if (savedUser == null) {
			userResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedUser);
			return userResponseEntity;
		} else {
			userResponseEntity = ResponseEntity.accepted().body(savedUser);
			return userResponseEntity;
		}
	}

	public ResponseEntity<?> isValidUser(Long userID) {
		UserDetails user = userRepo.findOne(userID);
		ResponseEntity<?> userResponseEntity = null;
		if (user.getIsAdmin()) {
			userResponseEntity = ResponseEntity.accepted().body(true);
		} else {
			userResponseEntity = ResponseEntity.accepted().body(false);
		}
		return userResponseEntity;
	}

	public ResponseEntity<?> updateUser(UserDetails user) {
		UserDetails savedUser = userRepo.findOne(user.getEmployeeID());
		if (savedUser != null) {
			savedUser = userRepo.save(user);
		}
		ResponseEntity<?> userResponseEntity = null;
		if (savedUser == null) {
			userResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedUser);
			return userResponseEntity;
		} else {
			userResponseEntity = ResponseEntity.accepted().body(savedUser);
			return userResponseEntity;
		}
	}

	public ResponseEntity<?> deleteUser(Long userId) {
		ResponseEntity<?> userResponseEntity = null;
		userRepo.delete(userId);
		UserDetails deletedUser = userRepo.findOne(userId);
		if (deletedUser != null) {
			userResponseEntity = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
			return userResponseEntity;
		} else {
			userResponseEntity = ResponseEntity.accepted().body(null);
			return userResponseEntity;
		}
	}
}
