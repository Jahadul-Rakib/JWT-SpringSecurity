package com.rakib.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.rakib.domain.UserInfo;
import com.rakib.domain.UserRole;
import com.rakib.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class SecurityController {

	@Autowired
	UserService userService;

	@Bean
	PasswordEncoder pdEncoder() 
	{
	    return new BCryptPasswordEncoder();
	}
	
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public void saveUser(@RequestBody UserInfo user) {
		
		
		  List<UserRole> roles = new ArrayList<>();
		  
		  UserRole role = new UserRole(); 
		  role.setRole("ROLE_USER"); 
		  roles.add(role);
		  
		  UserInfo userInfo = new UserInfo(); 
		  userInfo.setUserName(user.getUserName());
		  userInfo.setUserPhone(user.getUserPhone());
		  userInfo.setUserPassword(pdEncoder().encode(user.getPassword()));
		  userInfo.setRole(roles);
		  
		  userService.SaveUser(userInfo);
	}

	@GetMapping("login")
	public String getLogin() {
		return "login";
	}
}
