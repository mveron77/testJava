package com.test.java.testJava.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.java.testJava.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
	
	UserEntity findByNameAndLastName(String name, String lastName);
	
	UserEntity findByEmail(String email);

	UserEntity findByUserId(UUID userId);
	
	List<UserEntity> findAll();
}
