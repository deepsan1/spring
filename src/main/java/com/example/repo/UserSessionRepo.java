package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entity.UserSessionEntity;

public interface UserSessionRepo extends JpaRepository<UserSessionEntity,Long>{

}
