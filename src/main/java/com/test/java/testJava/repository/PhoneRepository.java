<<<<<<< HEAD
package com.test.java.testJava.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.java.testJava.entity.PhoneEntity;
import com.test.java.testJava.entity.UserEntity;

@Repository
public interface PhoneRepository extends CrudRepository<PhoneEntity, Long> {

	List<PhoneEntity> findAllByUserDetails(UserEntity userEntity);
	PhoneEntity findByUserDetailsAndNumber(UserEntity userEntity,String number);
}
=======
package com.test.java.testJava.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.java.testJava.entity.PhoneEntity;
import com.test.java.testJava.entity.UserEntity;

@Repository
public interface PhoneRepository extends CrudRepository<PhoneEntity, Long> {

	List<PhoneEntity> findAllByUserDetails(UserEntity userEntity);
	PhoneEntity findByUserDetailsAndNumber(UserEntity userEntity,String number);
}
>>>>>>> 467a71f07998eaeeb191ef4130f653c991351994
