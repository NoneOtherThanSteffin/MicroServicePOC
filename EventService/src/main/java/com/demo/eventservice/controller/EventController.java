package com.demo.eventservice.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.demo.eventservice.model.Event;
import com.demo.eventservice.service.EventService;

@RestController
@RequestMapping("/demo")
public class EventController {

	@Autowired
	@Qualifier("eventService")
	EventService eventService;

	@Autowired
	RestTemplate restTemplate;

	@Value("${user.service.url}")
	String userServiceUrl;

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public ResponseEntity<?> getByEventDate(@RequestParam("date") Date date) {
		ResponseEntity<?> eventResponse = eventService.getByEventDate(date);
		return eventResponse;
	}

	@RequestMapping(value = "/events/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllEvents() {
		ResponseEntity<?> eventResponse = eventService.getAllEvents();
		return eventResponse;
	}

	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public ResponseEntity<?> saveEvent(@RequestBody Event event, @RequestParam("userid") Long userid) {
		ResponseEntity<?> eventResponse = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			eventResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return eventResponse;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			eventResponse = eventService.saveEvent(event);
		} else {
			eventResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return eventResponse;
	}

	@RequestMapping(value = "/event", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEvent(@RequestBody Event event, @RequestParam("userid") Long userid) {
		ResponseEntity<?> eventResponse = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			eventResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return eventResponse;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			eventResponse = eventService.updateEvent(event);
		} else {
			eventResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return eventResponse;
	}

	@RequestMapping(value = "/event", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEvent(@RequestParam("eventDate") Date eventDate,
			@RequestParam("userid") Long userid) {
		ResponseEntity<?> eventResponse = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			eventResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return eventResponse;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			eventResponse = eventService.deleteEvent(eventDate);
		} else {
			eventResponse = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return eventResponse;
	}

}
