package com.demo.eventservice.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.eventservice.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Date>{
	
	 List<Event> findByEventDate(Date eventdate);
	// List<Event> findByEventsBetweenDate(Date fromDate,Date toDate);

}
