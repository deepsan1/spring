package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.StudentEntity;

@Repository
public interface Studentrepo extends JpaRepository<StudentEntity,Long>{
    
}
