package com.test.java.testJava.service;

import java.util.List;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.test.java.testJava.dto.UserDTO;

@Service
public interface UserService {
	
	public UserDetails loadUserByUsername(String name, String lastName);
	public UserDTO createUser(UserDTO userDTO);
	public UserDTO getUser(String email);
	public UserDTO getUserByUserId(UUID userID);
	public UserDTO updateUser(UUID userId,UserDTO userDTO);
	public void deleteUser(UUID userId);
	public List<UserDTO> getUsers(int limit);

}
