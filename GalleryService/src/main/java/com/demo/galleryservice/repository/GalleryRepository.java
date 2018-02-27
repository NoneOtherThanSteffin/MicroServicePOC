package com.demo.galleryservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.demo.galleryservice.model.Image;

public interface GalleryRepository extends PagingAndSortingRepository<Image, Long> {

//	@Query(value = "SELECT COUNT (image_content) gallery", nativeQuery = true)
//	int getSavedImageCount(String imageStringBase64);

}
