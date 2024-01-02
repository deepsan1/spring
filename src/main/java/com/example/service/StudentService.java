package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Entity.StudentEntity;
import com.example.repo.Studentrepo;




@Service
public class StudentService {
	  @Autowired
	  private Studentrepo repo;
	 
	  public ResponseEntity<StudentEntity> saveStudent( StudentEntity student) 
	  { 
	  	StudentEntity newStudent = repo.save(student); 
	  	return ResponseEntity.ok(newStudent); 
	  }
	// Get all products 
	  public ResponseEntity<List<StudentEntity>> fetchAllStudents() 
	  { 
	  	return ResponseEntity.ok(repo.findAll()); 
	  }
	// Get a product by ID 
	  public ResponseEntity<Optional<StudentEntity> > 
	  fetchStudentId(Long id) 
	  { 
	  	Optional<StudentEntity> student 
	  		= repo.findById(id); 
	  	if (student.isPresent()) { 
	  		return ResponseEntity.ok(student); 
	  	} 
	  	else { 
	  		return ResponseEntity.notFound().build(); 
	  	} 
	  }
	  public ResponseEntity<StudentEntity> updateStudent(Long id, StudentEntity updatedStudent) 
	  { 
	  	if (id == null) { 
	  		throw new IllegalArgumentException( 
	  			"ID cannot be null"); 
	  	} 
	  	StudentEntity Existingproduct 
	  		= repo.findById(id).orElseThrow( 
	  			() 
	  				-> new EntityNotFoundException( 
	  					String.valueOf(id))); 
	  	Existingproduct.setName(updatedStudent.getName()); 
	  	Existingproduct.setMarks(updatedStudent.getMarks()); 
	  	StudentEntity savedEntity 
	  		= repo.save(Existingproduct); 
	  	return ResponseEntity.ok(savedEntity); 
	  }
	  
	  public ResponseEntity<String> deleteStudent(Long id) 
	  { 
	  	repo.deleteById(id); 
	  	return ResponseEntity.ok( 
	  		"Product Deleted Successfully"); 
	  }
	  public StudentEntity getStudentById(Long id) {
		    
		 return repo.findById(id).orElse(new StudentEntity());
		  
	  }
	  
	  public List<StudentEntity> getAllStudents(){
		    return repo.findAll();
	  }

}
