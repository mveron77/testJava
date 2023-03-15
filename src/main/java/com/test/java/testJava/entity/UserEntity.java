package com.test.java.testJava.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "users")
public class UserEntity implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(generator = "UUID")
		@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
		@Column(nullable = false)
		private UUID userId;

		@Column(nullable = false, length = 50)
		private String name;

		@Column(nullable = false, length = 50)
		private String lastName;

		@Column(nullable = false, length = 100, unique = true)
		private String email;
		
		@Column(nullable = false, length = 40)
		private String password;
		
		@Column
		private String token;
		
		@Column
		private Boolean isActive;
		

		@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
		private List<PhoneEntity> phones;


		public UUID getUserId() {
			return userId;
		}


		public void setUserId(UUID userId) {
			this.userId = userId;
		}


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
		
		


		public String getToken() {
			return token;
		}


		public void setToken(String token) {
			this.token = token;
		}


		public Boolean getIsActive() {
			return isActive;
		}


		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}


		public List<PhoneEntity> getPhones() {
			return phones;
		}


		public void setPhones(List<PhoneEntity> phones) {
			this.phones = phones;
		}

		
}
