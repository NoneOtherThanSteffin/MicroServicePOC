package com.demo.galleryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.galleryservice.model.Image;
import com.demo.galleryservice.repository.GalleryRepository;

@Service
public class GalleryService {

	@Autowired
	GalleryRepository galleryRepo;

	public ResponseEntity<?> insertImage(Image image) {
		Image savedImage = null;
		// int imageCount = galleryRepo.getSavedImageCount(image.getImage());
		int imageCount = 0;
		ResponseEntity<?> galleryResponse = null;
		if (imageCount > 0) {
			galleryResponse = ResponseEntity.status(HttpStatus.CONFLICT).body(savedImage);
			return galleryResponse;
		}
		savedImage = galleryRepo.save(image);
		if (savedImage == null) {
			galleryResponse = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(savedImage);
			return galleryResponse;
		} else {
			galleryResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(savedImage);
			return galleryResponse;
		}
	}

	public ResponseEntity<?> getImage(Long imageId) {
		ResponseEntity<?> galleryResponse;
		Image savedImage = galleryRepo.findOne(imageId);
		if (savedImage == null) {
			galleryResponse = ResponseEntity.status(HttpStatus.NO_CONTENT).body(savedImage);
		} else {
			galleryResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(savedImage);
		}
		galleryResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(savedImage);
		return galleryResponse;
	}

	public ResponseEntity<?> getLimitedImage(int page, int number) {
		ResponseEntity<?> galleryResponse;
		Page<Image> images = galleryRepo.findAll(new PageRequest(page, number));
		if (images == null || !(images.getSize() > 0)) {
			galleryResponse = ResponseEntity.status(HttpStatus.NO_CONTENT).body(images);
		} else {
			List<Image> imageList = images.getContent();
			galleryResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(imageList);
		}
		return galleryResponse;
	}

	public ResponseEntity<?> deleteImage(Long imageId) {
		ResponseEntity<?> galleryResponse;
		galleryRepo.delete(imageId);
		Image deletedImage = galleryRepo.findOne(imageId);
		if (deletedImage != null) {
			galleryResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(deletedImage);
		} else {
			galleryResponse = ResponseEntity.status(HttpStatus.ACCEPTED).body(deletedImage);
		}
		return galleryResponse;
	}
}
