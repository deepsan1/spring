package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Entity.StudentEntity;
import com.example.Entity.UserEntity;
import com.example.Entity.UserSessionEntity;
import com.example.service.StudentService;
import com.example.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentController {
	 @Autowired
	 private StudentService studentservice;
	 
	// Create a new product 
	 @PostMapping("/student") 
	 public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentEntity student) 
	 { 
	 	return studentservice.saveStudent(student); 
	 }
	// Get all products 
	 @GetMapping("/students") 
	 public List<StudentEntity> getAllStudents() 
	 { 
	 	return studentservice.getAllStudents(); 
	 }
	 
	// Get a product by ID 
	 @GetMapping("/student/{id}") 
	 public ResponseEntity<StudentEntity> getProductById(@PathVariable Long id) 
	 { 
	 	StudentEntity student = studentservice.getStudentById(id); 
	 	if (student != null) { 
	 		return ResponseEntity.ok(student); 
	 	} 
	 	else { 
	 		return ResponseEntity.notFound().build(); 
	 	} 
	 }
	// Update a product 
	 @PutMapping(path = "/student/{studentId}") 
	 public ResponseEntity<StudentEntity> updateProduct(@PathVariable(value = "studentId") 
	 			Long studentId, @RequestBody StudentEntity student) 
	 { 
	 	return studentservice.updateStudent(studentId, student); 
	 }
	 
	// Delte a product 
	 @DeleteMapping(value = "/students/{studentId}") 
	 public String deleteProduct(@PathVariable Long studentId) 
	 { 
	 	studentservice.deleteStudent(studentId); 
	 	return "Product Deleted Successfully against id "
	 		+ studentId + " "; 
	 }
	 
	
	 
}
