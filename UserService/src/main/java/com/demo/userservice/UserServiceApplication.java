package com.demo.userservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.demo.userservice.model.UserDetails;
import com.demo.userservice.repository.UserRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@PostConstruct
	public void savedetails() {
		UserDetails user = new UserDetails();
		
		user.setEmployeeEmail("gulshan.k@mphasis.com");
		user.setEmployeeID(2332519);
		user.setEmployeeFirstName("Gulshan");
		user.setEmployeeLastName("Kumar");
		user.setEmployeePassword("iambakayaru");
		user.setIsAdmin(false);
		userRepository.save(user);
		
		user.setEmployeeEmail("steffin.joseph@mphasis.com");
		user.setEmployeeID(2332530);
		user.setEmployeeFirstName("Steffin");
		user.setEmployeeLastName("Joseph");
		user.setEmployeePassword("iamawesome");
		user.setIsAdmin(true);
		userRepository.save(user);
	}
}
