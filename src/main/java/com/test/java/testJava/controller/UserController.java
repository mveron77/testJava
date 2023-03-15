package com.test.java.testJava.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.testJava.dto.UserDTO;
import com.test.java.testJava.entity.UserEntity;
import com.test.java.testJava.exception.UsernameNotFoundException;
import com.test.java.testJava.model.request.UserDetailsRequest;
import com.test.java.testJava.repository.UserRepository;
import com.test.java.testJava.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	Logger logger = (Logger) LoggerFactory.logger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody UserDetailsRequest userDetails) throws Exception
	{
		logger.info("In process to register");
		
		if (userDetails.getEmail().isEmpty())
		{
			throw new UsernameNotFoundException("Mail is empty");
		}
		
		Pattern patternEmail = Pattern.compile("[a-z]{7}@?dominio\\.cl");		
		Pattern patternPassword = Pattern.compile("^[A-Z]{1}[a-z]+[0-9]{2}$");
		Matcher matherEmail = patternEmail.matcher(userDetails.getEmail());
		Matcher matherPassword = patternPassword.matcher(userDetails.getPassword());
		
		if(!matherEmail.find()) {
			return ResponseEntity.badRequest().body("Error: The mail format is not correct");
		}		
		if(!matherPassword.find()) {
			return ResponseEntity.badRequest().body("Error: The mail format is not correct");
		}		
		
		ModelMapper modelMapper = new ModelMapper();
		UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);
		

		UserDTO createdUserDTO = userService.createUser(userDTO);

		return ResponseEntity.ok(createdUserDTO);
	}
	

}
