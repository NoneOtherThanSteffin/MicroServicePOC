package com.demo.rewardsinnovationservice.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.rewardsinnovationservice.model.Reward;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {
	
	@Query(value = "DELETE FROM REWARD WHERE DATE_OF_REWARD = ?1", nativeQuery = true)
	public void deleteRewardByDateOfReward(Date dateOfReward);
	
	@Query(value = "SELECT * FROM REWARD WHERE DATE_OF_REWARD = ?1", nativeQuery = true)
	public List<Reward> findRewardByDateOfReward(Date dateOfReward);

}
