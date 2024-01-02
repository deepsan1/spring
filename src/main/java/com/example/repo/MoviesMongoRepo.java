package com.example.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.Entity.MoviesMongoEntity;

public interface MoviesMongoRepo extends MongoRepository<MoviesMongoEntity, BigInteger>, PagingAndSortingRepository<MoviesMongoEntity, BigInteger> {
    
    @Query("{title:'?0'}")
    MoviesMongoEntity findItemByTitle(String title);
    
    @Query(value="{}")
    Page<MoviesMongoEntity> findAll(Pageable pageable);
    @Query(value="{}")
    List<MoviesMongoEntity> findAll();
    
    public long count();

}
