package com.example.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Entity.MoviesEntity;



@Repository
public interface MoviesRepo extends JpaRepository<MoviesEntity,Long>{
	
	 @Query(value = "SELECT m FROM MoviesEntity m order by m.id Limit 10")
	 Collection<MoviesEntity> findOrderedByIdLimitedTo();

}
