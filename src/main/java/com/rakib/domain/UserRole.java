package com.rakib.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document(collation = "role")
public class UserRole{

    /**
	 * 
	 */
	private static final long serialVersionUID = 858445346925299906L;
	@Id
    private String id;
	private String userRole;
	
	
	public UserRole() {

	}
	
	public UserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return userRole;
	}
	public void setRole(String role) {
		userRole = role;
	}	
	
}
