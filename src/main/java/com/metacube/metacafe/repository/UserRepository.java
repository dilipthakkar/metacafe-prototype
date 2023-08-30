package com.metacube.metacafe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.metacafe.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
      
    Optional<UserEntity> findByUsername(String email);

}
