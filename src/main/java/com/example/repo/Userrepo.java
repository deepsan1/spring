package com.example.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Entity.UserEntity;

@Repository
public interface Userrepo extends JpaRepository<UserEntity,Long>{
	
	 @Query(value = "SELECT u FROM UserEntity u WHERE u.name = ?1")
	 Collection<UserEntity> findByName(String name);
	
}
