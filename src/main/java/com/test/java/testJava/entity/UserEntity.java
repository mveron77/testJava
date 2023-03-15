<<<<<<< HEAD
package com.test.java.testJava.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "users")
public class UserEntity implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		private long id;

		@Column(nullable = false)
		private String userId;

		@Column(nullable = false, length = 50)
		private String name;

		@Column(nullable = false, length = 50)
		private String lastName;

		@Column(nullable = false, length = 100, unique = true)
		private String email;
		
		@Column(nullable = false, length = 40)
		private String password;
		

		@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
		private List<PhoneEntity> phones;


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getUserId() {
			return userId;
		}


		public void setUserId(String userId) {
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


		public List<PhoneEntity> getPhones() {
			return phones;
		}


		public void setPhones(List<PhoneEntity> phones) {
			this.phones = phones;
		}

		
}
=======
package com.test.java.testJava.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "users")
public class UserEntity implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue
		private long id;

		@Column(nullable = false)
		private String userId;

		@Column(nullable = false, length = 50)
		private String name;

		@Column(nullable = false, length = 50)
		private String lastName;

		@Column(nullable = false, length = 100, unique = true)
		private String email;
		
		@Column(nullable = false, length = 40)
		private String password;
		

		@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
		private List<PhoneEntity> phones;


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getUserId() {
			return userId;
		}


		public void setUserId(String userId) {
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


		public List<PhoneEntity> getPhones() {
			return phones;
		}


		public void setPhones(List<PhoneEntity> phones) {
			this.phones = phones;
		}

		
}
>>>>>>> 467a71f07998eaeeb191ef4130f653c991351994
