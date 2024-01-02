package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.Entity.MoviesMongoEntity;
import com.example.repo.MoviesMongoRepo;

@Service
public class MoviesMongoService {
	 @Autowired
	 MoviesMongoRepo mongorepo;
	 
	 public List<MoviesMongoEntity> getAll() {
		 return mongorepo.findAll();
		 
	 }
	 public Page<MoviesMongoEntity> findPaginated(int page, int size) {
		 Pageable firstPageWithTwoElements = PageRequest.of(page, size);
		 Page<MoviesMongoEntity> pages = mongorepo.findAll(firstPageWithTwoElements);
		 return pages;
		 
	 }
	 
	 

}
