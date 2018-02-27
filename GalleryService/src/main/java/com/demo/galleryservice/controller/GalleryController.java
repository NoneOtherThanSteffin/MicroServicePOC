package com.demo.galleryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.core.UserDetails;
import com.demo.galleryservice.model.Image;
import com.demo.galleryservice.service.GalleryService;

@RestController
@RequestMapping("/demo")
public class GalleryController {

	@Autowired
	GalleryService galleryService;

	@Autowired
	RestTemplate restTemplate;

	@Value("${user.service.url}")
	String userServiceUrl;

	@RequestMapping(value = "/image", method = RequestMethod.GET)
	public ResponseEntity<?> getImage(@RequestParam("imageid") Long imageId) {
		ResponseEntity<?> galleryResponseEntity = galleryService.getImage(imageId);
		return galleryResponseEntity;
	}

	@RequestMapping(value = "/image/{page}/{number}", method = RequestMethod.GET)
	public ResponseEntity<?> getImagesLimit(@PathVariable(value = "page") Integer page,
			@PathVariable(value = "number") Integer number) {
		ResponseEntity<?> galleryResponseEntity = galleryService.getLimitedImage(page, number);
		return galleryResponseEntity;
	}

	@RequestMapping(value = "/image", method = RequestMethod.POST)
	public ResponseEntity<?> saveImage(@RequestBody Image image, @RequestParam("userid") Long userid) {
		ResponseEntity<?> galleryResponseEntity = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			galleryResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return galleryResponseEntity;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			galleryResponseEntity = galleryService.insertImage(image);
		} else {
			galleryResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return galleryResponseEntity;
	}

	@RequestMapping(value = "/image", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteImage(@RequestParam("imageid") Long imageid, @RequestParam("userid") Long userid) {
		ResponseEntity<?> galleryResponseEntity = null;
		UserDetails userDetails = restTemplate.getForObject(userServiceUrl + userid, UserDetails.class);
		if (userDetails == null) {
			galleryResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
			return galleryResponseEntity;
		}
		System.out.println("\n\nUserDetails\n" + userDetails.toString());
		if (userDetails.getIsAdmin()) {
			galleryResponseEntity = galleryService.deleteImage(imageid);
		} else {
			galleryResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
		return galleryResponseEntity;
	}
}
