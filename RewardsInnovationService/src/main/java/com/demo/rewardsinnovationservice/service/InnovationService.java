package com.demo.rewardsinnovationservice.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.rewardsinnovationservice.model.Innovation;
import com.demo.rewardsinnovationservice.model.Reward;
import com.demo.rewardsinnovationservice.repository.InnovationRepository;

@Service
public class InnovationService {

	@Autowired
	InnovationRepository innovationRepo;

	public ResponseEntity<?> saveEmployeeInnovation(Innovation innovation) {
		ResponseEntity<?> innovationResponse = null;
		Innovation savedInnovation = innovationRepo.save(innovation);
		if (savedInnovation == null) {
			innovationResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedInnovation);
		} else {
			innovationResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(savedInnovation);
		}
		return innovationResponse;
	}

	public ResponseEntity<?> getInnovationByDate(Date innovationDate) {
		ResponseEntity<?> innovationResponse = null;
		List<Innovation> savedInnovation = innovationRepo.findInnovationByDateOfInnovation(innovationDate);
		if (savedInnovation == null) {
			innovationResponse = ResponseEntity.status(HttpStatus.NO_CONTENT).body(savedInnovation);
		} else {
			innovationResponse = ResponseEntity.status(HttpStatus.OK).body(savedInnovation);
		}
		return innovationResponse;

	}

	public ResponseEntity<?> getAllEmployeeInnovation() {
		List<Innovation> innovationList = innovationRepo.findAll();
		ResponseEntity<?> innovationResponse = null;
		if (innovationList == null || !(innovationList.size() > 0)) {
			innovationResponse = ResponseEntity.status(HttpStatus.NO_CONTENT).body(innovationList);
			return innovationResponse;
		} else {
			innovationResponse = ResponseEntity.status(HttpStatus.OK).body(innovationList);
			return innovationResponse;
		}
	}

	public ResponseEntity<?> updateEmployeeInnovation(Innovation innovation) {
		ResponseEntity<?> innovationResponse = null;
		Innovation getInnovation = innovationRepo.findOne(innovation.getInnovationEmployeeId());
		if (getInnovation == null) {
			innovationResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).body(getInnovation);
			return innovationResponse;
		}
		Innovation savedInnovation = innovationRepo.save(innovation);
		if (savedInnovation == null) {
			innovationResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedInnovation);
		} else {
			innovationResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(savedInnovation);
		}
		return innovationResponse;
	}

	public ResponseEntity<?> deleteEmployeeInnovation(Date dateOfInnovation) {
		ResponseEntity<?> innovationResponse = null;
		innovationRepo.deleteInnovationByDateOfInnovation(dateOfInnovation);
		List<Innovation> innovationList = innovationRepo.findInnovationByDateOfInnovation(dateOfInnovation);
		if (!innovationList.isEmpty()) {
			innovationResponse = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(innovationList);
			return innovationResponse;
		}
		innovationResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(innovationList);
		return innovationResponse;
	}

}
