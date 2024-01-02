package com.example.controller;

import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.Entity.MoviesEntity;
import com.example.Entity.MoviesMongoEntity;
import com.example.Entity.UserEntity;
import com.example.Entity.UserSessionEntity;
import com.example.events.PaginatedResultsRetrievedEvent;
import com.example.events.PaginatedResultsRetrievedPublisher;
import com.example.service.MoviesMongoService;
import com.example.service.MoviesService;
import com.example.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
	
	 @Autowired
	 private UserService userservice;
	 @Autowired
	 private MoviesService movieservice;
	 @Autowired
	 private MoviesMongoService moviesmongoservice;
	 @Autowired
	 private PaginatedResultsRetrievedPublisher eventPublisher;
	

	// Create a new User
	 @PostMapping("/user") 
	 public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) 
	 { 
	 	return userservice.saveUser(user); 
	 }
	// Get all products 
	 @GetMapping("/users") 
	 public List<UserEntity> getAllUsers() 
	 { 
	 	return userservice.getAllUsers(); 
	 }
	 
	// Get a product by ID 
	 @GetMapping("/user/{id}") 
	 public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) 
	 { 
	 	UserEntity user = userservice.getUserById(id); 
	 	if (user != null) { 
	 		return ResponseEntity.ok(user); 
	 	} 
	 	else { 
	 		return ResponseEntity.notFound().build(); 
	 	} 
	 }
	
	 @PutMapping(path = "/user/{userId}") 
	 public ResponseEntity<UserEntity> updateUser(@PathVariable(value = "userId") 
	 			Long userId, @RequestBody UserEntity user) 
	 { 
	 	return userservice.updateUser(userId, user); 
	 }
	 
	// Delte a product 
	 @DeleteMapping(value = "/users/{userId}") 
	 public String deleteUser(@PathVariable Long userId) 
	 { 
	 	userservice.deleteUser(userId); 
	 	return "Product Deleted Successfully against id "
	 		+ userId + " "; 
	 }
	 
	 @PostMapping("/login")
	 public ResponseEntity<UserSessionEntity> checkLogin(@RequestBody UserEntity user) {
		 
		 
		 return userservice.validateUser(user);


}
	 @GetMapping("/movies")
	 public List<MoviesEntity> getmovies(){
		 
		 return movieservice.getAllmovies();
	 }
	 @GetMapping("/movies_with_limit")
	 public ResponseEntity<List<MoviesEntity>> getmovieswithlimit(){
		 
		 return  movieservice.getAllmovieswithlimit();
	 }
	 @GetMapping("/get_all_documents")
	 public List<MoviesMongoEntity> getAllDocuments(){
		   return moviesmongoservice.getAll();
	 }
	 @GetMapping(value = "/get_all_documents",params = { "page", "size" })
	 public ResponseEntity<List<MoviesMongoEntity>> findPaginated(@RequestParam("page") int page, 
	   @RequestParam("size") int size, UriComponentsBuilder uriBuilder,
	   HttpServletResponse response) throws Exception {
	     Page<MoviesMongoEntity> resultPage = moviesmongoservice.findPaginated(page, size);
	     if (page > resultPage.getTotalPages()) {
	         throw new Exception("Resource Not Found");
	     }
	     eventPublisher.publishCustomEvent(new PaginatedResultsRetrievedEvent(
	    		 MoviesMongoEntity.class, uriBuilder, response, page, resultPage.getTotalPages(), size));
	     HttpHeaders httpHeaders = new HttpHeaders();
	     httpHeaders.add("Link",response.getHeader("Link") );
	     httpHeaders.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Link");
	     System.out.println(response.getHeader("Link"));
	     
	     return ResponseEntity.ok().headers(httpHeaders).body(resultPage.getContent());

	   
	 }
	
			   
			
	
}	 
