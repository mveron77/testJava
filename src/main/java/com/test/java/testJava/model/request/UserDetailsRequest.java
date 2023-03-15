package com.test.java.testJava.model.request;

import java.util.List;

import com.test.java.testJava.entity.PhoneEntity;

public class UserDetailsRequest {

	private String name;

	private String lastName;

	private String email;
	
	private String password;
	
	private List<PhoneEntity> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneEntity> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneEntity> phones) {
		this.phones = phones;
	}
	
	
}
