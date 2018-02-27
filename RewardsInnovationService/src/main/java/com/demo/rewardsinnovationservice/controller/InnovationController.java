package com.demo.rewardsinnovationservice.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.core.UserDetails;
import com.demo.rewardsinnovationservice.model.Innovation;
import com.demo.rewardsinnovationservice.service.InnovationService;

@RestController
@RequestMapping("/demo")
public class InnovationController {
	@Autowired
	InnovationService innovationService;

	@Autowired
	RestTemplate restTemplate;

	@Value("${user.service.url}")
	String userServiceUrl;

	@RequestMapping(value = "/innovation", method = RequestMethod.POST)
	public ResponseEntity<?> saveInnovation(@RequestBody Innovation innovation, @RequestParam("userid") Long userid) {
		ResponseEntity<?> innovationResponseEntity = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			innovationResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return innovationResponseEntity;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			innovationResponseEntity = innovationService.saveEmployeeInnovation(innovation);
		} else {
			innovationResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return innovationResponseEntity;
	}

	@RequestMapping(value = "/innovation", method = RequestMethod.GET)
	public ResponseEntity<?> getInnovation(@RequestParam("date") Date innovationDate) {
		ResponseEntity<?> innovationResponseEntity = null;
		innovationResponseEntity = innovationService.getInnovationByDate(innovationDate);
		return innovationResponseEntity;
	}

	@RequestMapping(value = "/innovations/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllInnovations() {
		ResponseEntity<?> innovationResponseEntity = null;
		innovationResponseEntity = innovationService.getAllEmployeeInnovation();
		return innovationResponseEntity;
	}

	@RequestMapping(value = "/innovation", method = RequestMethod.PUT)
	public ResponseEntity<?> updateInnovation(@RequestBody Innovation innovation, @RequestParam("userid") Long userid) {
		ResponseEntity<?> innovationResponseEntity = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			innovationResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return innovationResponseEntity;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			innovationResponseEntity = innovationService.updateEmployeeInnovation(innovation);
		} else {
			innovationResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return innovationResponseEntity;
	}

	@RequestMapping(value = "/innovation", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteInnovation(@RequestParam("date") Date innovationDate,
			@RequestParam("userid") Long userid) {
		ResponseEntity<?> innovationResponseEntity = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			innovationResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return innovationResponseEntity;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			innovationResponseEntity = innovationService.deleteEmployeeInnovation(innovationDate);
		} else {
			innovationResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return innovationResponseEntity;
	}

}
