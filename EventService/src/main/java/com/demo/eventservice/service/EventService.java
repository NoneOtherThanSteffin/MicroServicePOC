package com.demo.eventservice.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.core.UserDetails;
import com.demo.eventservice.model.Event;
import com.demo.eventservice.repository.EventRepository;

@Service(value = "eventService")
public class EventService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	RestTemplate restTemplate;

	@Value("${user.service.url}")
	String userServiceUrl;

	public ResponseEntity<?> getByEventDate(Date eventDate) {
		List<Event> event = eventRepository.findByEventDate(eventDate);
		ResponseEntity<?> eventResponseEntity = null;
		if (event == null) {
			eventResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(event);
			return eventResponseEntity;
		} else {
			eventResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(event);
			return eventResponseEntity;
		}
	}

	public ResponseEntity<?> getAllEvents() {
		List<Event> eventList = eventRepository.findAll();
		ResponseEntity<?> eventResponseEntity = null;
		if (eventList == null || !(eventList.size() > 0)) {
			eventResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(eventList);
			return eventResponseEntity;
		} else {
			eventResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(eventList);
			return eventResponseEntity;
		}
	}

	public ResponseEntity<?> saveEvent(Event event) {
		ResponseEntity<?> eventResponseEntity = null;
		Event savedEvent = eventRepository.findOne(event.getEventDate());
		if (savedEvent == null) {
			savedEvent = eventRepository.save(event);
			eventResponseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).body(savedEvent);
		} else if (savedEvent != null) {
			eventResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedEvent);
		}
		return eventResponseEntity;
	}

	public ResponseEntity<?> updateEvent(Event event) {
		ResponseEntity<?> eventResponseEntity = null;
		Event savedEvent = eventRepository.findOne(event.getEventDate());
		if (savedEvent != null) {
			savedEvent = eventRepository.save(event);
			eventResponseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).body(savedEvent);
		} else if (savedEvent == null) {
			eventResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savedEvent);
		}
		return eventResponseEntity;

	}

	public ResponseEntity<?> deleteEvent(Date eventDate) {
		ResponseEntity<?> eventResponseEntity = null;
		eventRepository.delete(eventDate);
		Event deletedEvent = eventRepository.findOne(eventDate);
		if (deletedEvent != null) {
			eventResponseEntity = ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
			return eventResponseEntity;
		} else {
			eventResponseEntity = ResponseEntity.status(HttpStatus.OK).body(null);
			return eventResponseEntity;
		}
	}

}
