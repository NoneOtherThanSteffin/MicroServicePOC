package com.demo.rewardsinnovationservice.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.rewardsinnovationservice.model.Innovation;

@Repository
public interface InnovationRepository extends JpaRepository<Innovation, Long> {

	@Query(value = "DELETE FROM INNOVATION WHERE DATE_OF_INNOVATION = ?1", nativeQuery = true)
	public void deleteInnovationByDateOfInnovation(Date dateOfInnovation);

	@Query(value = "SELECT * FROM INNOVATION WHERE DATE_OF_INNOVATION = ?1", nativeQuery = true)
	public List<Innovation> findInnovationByDateOfInnovation(Date dateOfInnovation);

}
