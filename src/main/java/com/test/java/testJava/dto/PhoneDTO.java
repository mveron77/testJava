<<<<<<< HEAD
package com.test.java.testJava.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.test.java.testJava.entity.UserEntity;

public class PhoneDTO {
	
	private long id;

	private String number;

	private String cityCode;
	

	private String countryCode;
	
	private UserDTO userDetails;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public UserDTO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDTO userDetails) {
		this.userDetails = userDetails;
	}


}
=======
package com.test.java.testJava.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.test.java.testJava.entity.UserEntity;

public class PhoneDTO {
	
	private long id;

	private String number;

	private String cityCode;
	

	private String countryCode;
	
	private UserDTO userDetails;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public UserDTO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDTO userDetails) {
		this.userDetails = userDetails;
	}


}
>>>>>>> 467a71f07998eaeeb191ef4130f653c991351994
