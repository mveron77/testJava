package com.test.java.testJava.model.response;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.java.testJava.entity.UserEntity;

public class UserDTOResponse implements UserDetails{
	
    private String username;
    private String password;
    private boolean active;

    public UserDTOResponse(UserEntity user){
        
        this.username = user.getName() + " " + user.getLastName();
        this.password = user.getPassword();
        this.active = user.getIsActive();
    }


    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

}
