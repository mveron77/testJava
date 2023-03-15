package com.test.java.testJava.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.java.testJava.dto.PhoneDTO;
import com.test.java.testJava.dto.UserDTO;
import com.test.java.testJava.entity.PhoneEntity;
import com.test.java.testJava.entity.UserEntity;
import com.test.java.testJava.exception.UsernameNotFoundException;
import com.test.java.testJava.model.response.UserDTOResponse;
import com.test.java.testJava.repository.PhoneRepository;
import com.test.java.testJava.repository.UserRepository;
import com.test.java.testJava.service.UserService;
import com.test.java.testJava.utils.JwtTokenUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
    JwtTokenUtil jwtUtil;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String name, String lastName) {
		UserEntity user =  userRepository.findByNameAndLastName(name, lastName);
		if (user == null) {
			throw new UsernameNotFoundException("User was not found with name: " + name + lastName);
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				new ArrayList<>());
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		UserEntity userEntityByEmail = userRepository.findByEmail(userDTO.getEmail());
		if (userEntityByEmail != null)
		{
			throw new RuntimeException("Email existente");
		}

		List<PhoneDTO> phoneDTOList = userDTO.getPhones();		
		for (PhoneDTO phoneDTO : phoneDTOList)
		{
			phoneDTO.setUserDetails(userDTO);
		}
		
		ModelMapper modelMapper = new ModelMapper();
		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
		userEntity.setIsActive(true);
		UserDTOResponse userDTORes = new UserDTOResponse(userEntity);
		userEntity.setPassword(bcryptPasswordEncoder.encode(userDTO.getPassword()));
		
		userEntity.setToken(jwtUtil.tokenCreate(userDTORes));

		

		UserEntity storedUserEntity = userRepository.save(userEntity);
		UserDTO returnUserDTO = modelMapper.map(storedUserEntity, UserDTO.class);

		return returnUserDTO;
	}

	@Override
	public UserDTO getUser(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null)
		{
			throw new UsernameNotFoundException(email);
		}
		UserDTO returnUserDTO = new UserDTO();
		BeanUtils.copyProperties(userEntity, returnUserDTO);
		return returnUserDTO;
	}

	@Override
	public UserDTO getUserByUserId(UUID userId) {
		UserEntity userEntityByUserId = userRepository.findByUserId(userId);

		if (userEntityByUserId == null)
		{
			throw new UsernameNotFoundException("The Id was not found for user: " + userId);
		}

		ModelMapper modelMapper = new ModelMapper();
		UserDTO returnUserDTO = modelMapper.map(userEntityByUserId, UserDTO.class);

		return returnUserDTO;

	}

	@Override
	public UserDTO updateUser(UUID userId, UserDTO userDTO) {
		UserEntity userEntityfromDB = userRepository.findByUserId(userId);

		if (userEntityfromDB == null)
		{
			//throw new UserServiceException(ErrorMessages.RECORD_NOT_FOUND.getErrorMessage());
			throw new UsernameNotFoundException("error");
		}
		
		List<PhoneEntity> phoneEntityList = userEntityfromDB.getPhones();
		for (PhoneEntity phoneEntity : phoneEntityList)
		{
			phoneEntity.setUserDetails(null);
			phoneRepository.save(phoneEntity);
		}
		
		List<PhoneDTO> phoneDTOList = userDTO.getPhones();		
		for (PhoneDTO phoneDTO : phoneDTOList)
		{
			phoneDTO.setUserDetails(userDTO);
		}
		
		ModelMapper modelMapper = new ModelMapper();	

		UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
		
		userEntity.setPassword(bcryptPasswordEncoder.encode(userDTO.getPassword()));
			
		UserEntity updatedUserEntity = userRepository.save(userEntity);

		UserDTO returnUserDTO =  modelMapper.map(updatedUserEntity, UserDTO.class);
		
		return returnUserDTO;
	}

	@Override
	public void deleteUser(UUID userId) {
		UserEntity userEntityByUserId = userRepository.findByUserId(userId);

		if (userEntityByUserId == null)
		{
			throw new UsernameNotFoundException("Error: Id not found");
		}
		userRepository.delete(userEntityByUserId);
		
	}

	@Override
	public List<UserDTO> getUsers(int limit) {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		
		List<UserEntity> userEntityList = (List<UserEntity>) userRepository.findAll();
		
		if(limit > 0) {
			for (int i = 0; i <= limit; i++) {
				ModelMapper modelMapper = new ModelMapper();
				UserDTO userDTO = modelMapper.map(userEntityList.get(i), UserDTO.class);
				userDTOList.add(userDTO);
			}
			return userDTOList;
		}else {
			for (UserEntity userEntity : userEntityList)
			{
				
				ModelMapper modelMapper = new ModelMapper();
				UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
				userDTOList.add(userDTO);
			}

			return userDTOList;
		}
	}
}