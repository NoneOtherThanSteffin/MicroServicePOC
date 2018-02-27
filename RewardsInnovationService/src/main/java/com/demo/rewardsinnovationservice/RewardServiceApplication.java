package com.demo.rewardsinnovationservice;

import java.sql.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.demo.rewardsinnovationservice.model.Reward;
import com.demo.rewardsinnovationservice.repository.RewardRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class RewardServiceApplication {

	@Autowired
	RewardRepository rewardRepo;

	public static void main(String[] args) {
		SpringApplication.run(RewardServiceApplication.class, args);
	}

	@PostConstruct
	public void saveRewardData() {
		Reward reward = new Reward();
		reward.setComments("Hi");
		reward.setDateOfReward(new Date(System.currentTimeMillis()));
		reward.setReceivedEmployeeId(2332530L);
		reward.setReceivedEmployeeName("Steffin");
		reward.setRewardType("Monthly Summit");
		reward.setTitle("Awesome");
		rewardRepo.save(reward);
	}
}
