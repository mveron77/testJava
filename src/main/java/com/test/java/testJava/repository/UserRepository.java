package com.test.java.testJava.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.java.testJava.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
	
	UserEntity findByEmail(String email);

	UserEntity findByUserId(String userId);
	
	List<UserEntity> findAll();
}
