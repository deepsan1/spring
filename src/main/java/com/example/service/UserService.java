package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Entity.UserEntity;
import com.example.Entity.UserSessionEntity;
import com.example.repo.Userrepo;
import com.example.repo.UserSessionRepo;





@Service
public class UserService {
	  @Autowired
	  private Userrepo userrepo;
	  @Autowired
	  private UserSessionRepo sessionrepo;
	  public ResponseEntity<UserEntity> saveUser( UserEntity user) 
	  { 
	  	UserEntity newUser = userrepo.save(user); 
	  	return ResponseEntity.ok(newUser); 
	  }
	// Get all products 
	  public ResponseEntity<List<UserEntity>> fetchAllUsers() 
	  { 
	  	return ResponseEntity.ok(userrepo.findAll()); 
	  }
	// Get a product by ID 
	  public ResponseEntity<Optional<UserEntity> > 
	  fetchUserId(Long id) 
	  { 
	  	Optional<UserEntity> user 
	  		= userrepo.findById(id); 
	  	if (user.isPresent()) { 
	  		return ResponseEntity.ok(user); 
	  	} 
	  	else { 
	  		return ResponseEntity.notFound().build(); 
	  	} 
	  }
	  public ResponseEntity<UserEntity> updateUser(Long id, UserEntity updatedUser) 
	  { 
	  	if (id == null) { 
	  		throw new IllegalArgumentException( 
	  			"ID cannot be null"); 
	  	} 
	  	UserEntity Existingproduct 
	  		= userrepo.findById(id).orElseThrow( 
	  			() 
	  				-> new EntityNotFoundException( 
	  					String.valueOf(id))); 
	  	Existingproduct.setName(updatedUser.getName()); 
	  	Existingproduct.setPassword(updatedUser.getPassword()); 
	  	UserEntity savedEntity 
	  		= userrepo.save(Existingproduct); 
	  	return ResponseEntity.ok(savedEntity); 
	  }
	  
	  public ResponseEntity<String> deleteUser(Long id) 
	  { 
	  	userrepo.deleteById(id); 
	  	return ResponseEntity.ok( 
	  		"Product Deleted Successfully"); 
	  }
	  public UserEntity getUserById(Long id) {
		    
		 return userrepo.findById(id).orElse(new UserEntity());
		  
	  }
	  
	  public List<UserEntity> getAllUsers(){
		    return userrepo.findAll();
	  }
	  
	  public ResponseEntity<UserSessionEntity> validateUser(UserEntity user) {
		  System.out.println("usernentiy"+user.getName()+user.getPassword());
		  List<UserEntity> users = (List<UserEntity>) userrepo.findByName(user.getName());
		  UserSessionEntity sessionentity = new UserSessionEntity();
		  System.out.print(users);
		  for (UserEntity currentuser:users) {
			   System.out.println("Users : "+currentuser.getName() + currentuser.getPassword());
			   if (currentuser.getPassword().equals(user.getPassword())) {
				   	System.out.println("Password matched"); 
				   sessionentity.setLoggedin(true);
					  sessionentity.setUser(user);
					  sessionentity.setUsername(user.getName());
					  UserSessionEntity newsession = sessionrepo.save(sessionentity);
					  return ResponseEntity.ok(newsession);
				    
			   }
			  
		  }
		  
		  return ResponseEntity.notFound().build();
		  
	  }

}
