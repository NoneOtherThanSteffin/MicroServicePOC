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
import com.demo.rewardsinnovationservice.model.Reward;
import com.demo.rewardsinnovationservice.service.RewardService;

@RestController
@RequestMapping("/demo")
public class RewardController {

	@Autowired
	RewardService rewardService;

	@Autowired
	RestTemplate restTemplate;

	@Value("${user.service.url}")
	String userServiceUrl;

	@RequestMapping(value = "/reward", method = RequestMethod.GET)
	public ResponseEntity<?> getReward(@RequestParam("date") Date rewardDate) {
		ResponseEntity<?> rewardResponseEntity = rewardService.getRewardByDate(rewardDate);
		return rewardResponseEntity;
	}

	@RequestMapping(value = "/rewards/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllRewards() {
		ResponseEntity<?> rewardResponseEntity = rewardService.getAllEmployeeRewards();
		return rewardResponseEntity;

	}

	@RequestMapping(value = "/reward", method = RequestMethod.POST)
	public ResponseEntity<?> saveReward(@RequestBody Reward reward, @RequestParam("userid") Long userid) {
		ResponseEntity<?> rewardResponseEntity = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			rewardResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return rewardResponseEntity;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			rewardResponseEntity = rewardService.saveEmployeeRewards(reward);
		} else {
			rewardResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return rewardResponseEntity;
	}

	@RequestMapping(value = "/reward", method = RequestMethod.PUT)
	public ResponseEntity<?> updateReward(@RequestBody Reward reward, @RequestParam("userid") Long userid) {
		ResponseEntity<?> rewardResponseEntity = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			rewardResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return rewardResponseEntity;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			rewardResponseEntity = rewardService.updateEmployeeReward(reward);
		} else {
			rewardResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return rewardResponseEntity;
	}

	@RequestMapping(value = "/reward", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteReward(@RequestParam("date") Date rewardDate, @RequestParam("userid") Long userid) {
		ResponseEntity<?> rewardResponseEntity = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			rewardResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return rewardResponseEntity;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			rewardResponseEntity = rewardService.deleteEmployeeReward(rewardDate);
		} else {
			rewardResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return rewardResponseEntity;
	}

}
