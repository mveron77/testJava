package com.test.java.testJava.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.testJava.dto.UserDTO;
import com.test.java.testJava.exception.UsernameNotFoundException;
import com.test.java.testJava.model.request.UserDetailsRequest;
import com.test.java.testJava.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserDTO createUser(@RequestBody UserDetailsRequest userDetails) throws Exception
	{
		if (userDetails.getEmail().isEmpty())
		{
			//throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELDS.getErrorMessage());
			throw new UsernameNotFoundException("error");
		}

		ModelMapper modelMapper = new ModelMapper();
		UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);

		UserDTO createdUserDTO = userService.createUser(userDTO);

		return createdUserDTO;
	}

}
