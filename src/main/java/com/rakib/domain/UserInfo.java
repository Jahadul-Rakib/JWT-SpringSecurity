package com.rakib.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.cglib.core.GeneratorStrategy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.processing.Generated;


@Document(collation = "user")
public class UserInfo implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6711981647093518770L;
	@Id
	private String id;
	private String userName;
	private String userPhone;
	private String userPassword;
	private boolean active = true;
	@DBRef
	private List<UserRole> role;
	
	public UserInfo(String userName, String userPhone, String userPassword, boolean active,
			List<UserRole> role) {
		this.userName = userName;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.active = active;
		this.role = role;
	}

	public UserInfo(String id, String userName, String userPhone, String userPassword, boolean active, List<UserRole> role) {
		this.id = id;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.active = active;
		this.role = role;
	}

	public UserInfo() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<UserRole> getRole() {
		return role;
	}

	public void setRole(List<UserRole> role) {
		this.role = role;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	
	//Granted Authority Methos

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		for(UserRole roles : this.role) {
			authority.add((GrantedAuthority) roles);
		}
		return authority;
	}

	@Override
	public String getPassword() {
		return this.userPassword;
	}

	@Override
	public String getUsername() {
		return this.userPhone;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.active;
	}
	
	
}
