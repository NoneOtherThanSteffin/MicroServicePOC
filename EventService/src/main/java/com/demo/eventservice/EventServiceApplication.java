package com.demo.eventservice;

import java.sql.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

import com.demo.eventservice.model.Event;
import com.demo.eventservice.repository.EventRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class EventServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventServiceApplication.class, args);
	}

	@Autowired
	EventRepository eventRepo;

	@PostConstruct
	public void saveEvent() {
		Event event = new Event();
		event.setEmployeeID(2332530L);
		event.setEventDate(Date.valueOf("2017-11-20"));
		event.setEventName("New Day");
		eventRepo.save(event);
	}
}
