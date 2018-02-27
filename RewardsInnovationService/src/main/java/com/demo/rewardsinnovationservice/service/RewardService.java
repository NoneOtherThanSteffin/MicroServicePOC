package com.demo.rewardsinnovationservice.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.rewardsinnovationservice.model.Reward;
import com.demo.rewardsinnovationservice.repository.RewardRepository;

@Service
public class RewardService {

	@Autowired
	RewardRepository rewardRepository;

	public ResponseEntity<?> saveEmployeeRewards(Reward reward) {
		ResponseEntity<?> rewardResponse = null;
		Reward savedReward = rewardRepository.save(reward);
		if (savedReward == null) {
			rewardResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedReward);
		} else {
			rewardResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(savedReward);
		}
		return rewardResponse;
	}

	public ResponseEntity<?> getRewardByDate(Date rewardDate) {
		ResponseEntity<?> rewardResponse = null;
		List<Reward> savedReward = rewardRepository.findRewardByDateOfReward(rewardDate);
		if (savedReward == null) {
			rewardResponse = ResponseEntity.status(HttpStatus.NO_CONTENT).body(savedReward);
		} else {
			rewardResponse = ResponseEntity.status(HttpStatus.OK).body(savedReward);
		}
		return rewardResponse;
	}

	public ResponseEntity<?> getAllEmployeeRewards() {
		List<Reward> rewardList = rewardRepository.findAll();
		ResponseEntity<?> rewardResponse = null;
		if (rewardList == null || !(rewardList.size() > 0)) {
			rewardResponse = ResponseEntity.status(HttpStatus.NO_CONTENT).body(rewardList);
			return rewardResponse;
		} else {
			rewardResponse = ResponseEntity.status(HttpStatus.OK).body(rewardList);
			return rewardResponse;
		}
	}

	public ResponseEntity<?> updateEmployeeReward(Reward reward) {
		ResponseEntity<?> rewardResponse = null;
		Reward getReward = rewardRepository.findOne(reward.getReceivedEmployeeId());
		if (getReward == null) {
			rewardResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).body(getReward);
			return rewardResponse;
		}
		Reward savedReward = rewardRepository.save(reward);
		if (savedReward == null) {
			rewardResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedReward);
		} else {
			rewardResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(savedReward);
		}
		return rewardResponse;
	}

	public ResponseEntity<?> deleteEmployeeReward(Date dateOfReward) {
		ResponseEntity<?> rewardResponse = null;
		rewardRepository.deleteRewardByDateOfReward(dateOfReward);
		List<Reward> rewardList = rewardRepository.findRewardByDateOfReward(dateOfReward);
		if (!rewardList.isEmpty()) {
			rewardResponse = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(rewardList);
			return rewardResponse;
		}
		rewardResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(rewardList);
		return rewardResponse;
	}

}
