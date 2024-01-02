package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Entity.MoviesEntity;
import com.example.repo.MoviesRepo;

@Service
public class MoviesService {
	@Autowired
	private MoviesRepo movierepo;
	
	  public ResponseEntity<MoviesEntity> savemovie( MoviesEntity movie) 
	  { 
	  	MoviesEntity newMovie = movierepo.save(movie); 
	  	return ResponseEntity.ok(newMovie); 
	  }
	// Get all products 
	  public ResponseEntity<List<MoviesEntity>> fetchAllMovies() 
	  { 
	  	return ResponseEntity.ok(movierepo.findAll()); 
	  }
	  
	
	  
	// Get a product by ID 
	  public ResponseEntity<Optional<MoviesEntity> > 
	  fetchMovieId(Long id) 
	  { 
	  	Optional<MoviesEntity> movie 
	  		= movierepo.findById(id); 
	  	if (movie.isPresent()) { 
	  		return ResponseEntity.ok(movie); 
	  	} 
	  	else { 
	  		return ResponseEntity.notFound().build(); 
	  	} 
	  }
	  public ResponseEntity<MoviesEntity> updateMovie(Long id, MoviesEntity updatedMovie) 
	  { 
	  	if (id == null) { 
	  		throw new IllegalArgumentException( 
	  			"ID cannot be null"); 
	  	} 
	  	MoviesEntity Existingmovie 
	  		= movierepo.findById(id).orElseThrow( 
	  			() 
	  				-> new EntityNotFoundException( 
	  					String.valueOf(id))); 
	  	Existingmovie.setOriginal_title(updatedMovie.getOriginal_title()); 
	  	Existingmovie.setOverview(updatedMovie.getOverview()); 
	  	MoviesEntity savedEntity 
	  		= movierepo.save(Existingmovie); 
	  	return ResponseEntity.ok(savedEntity); 
	  }
	  
	  public ResponseEntity<String> deletemovie(Long id) 
	  { 
	  	movierepo.deleteById(id); 
	  	return ResponseEntity.ok( 
	  		"Product Deleted Successfully"); 
	  }
	  public MoviesEntity getmovieById(Long id) {
		    
		 return movierepo.findById(id).orElse(new MoviesEntity());
		  
	  }
	  public List<MoviesEntity> getAllmovies(){
		    return (List<MoviesEntity>)movierepo.findAll();
	  }
	  
	  public ResponseEntity<List<MoviesEntity>> getAllmovieswithlimit(){
		    return ResponseEntity.ok((List<MoviesEntity>)movierepo.findOrderedByIdLimitedTo());
	  }
	  
	
}
