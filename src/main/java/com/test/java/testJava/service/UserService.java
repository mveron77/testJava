package com.test.java.testJava.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.java.testJava.dto.UserDTO;

@Service
public interface UserService {
	
	public UserDTO createUser(UserDTO userDTO);
	public UserDTO getUser(String email);
	public UserDTO getUserByUserId(String userId);
	public UserDTO updateUser(String userId,UserDTO userDTO);
	public void deleteUser(String userId);
	public List<UserDTO> getUsers(int limit);

}
