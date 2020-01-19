package com.rakib.config;
public class AuthenticationRequestDTO {

	private String username;
	private String password;
	/* private List<GrantedAuthority> authorities; */
	
	public AuthenticationRequestDTO() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public Collection<? extends GrantedAuthority> getAuthorities() { return
	 * authorities; }
	 * 
	 * public void setAuthorities(List<GrantedAuthority> authorities) {
	 * this.authorities = authorities; }
	 */
	
}
