package com.rakib;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.rakib.domain.UserInfo;
import com.rakib.domain.UserRole;
import com.rakib.service.RoleService;
import com.rakib.service.UserService;

@SpringBootApplication
public class BasicSpringSecurityApplication /*implements CommandLineRunner*/  {
	
/*	  @Autowired
	  UserService userService;

	  @Autowired
	  RoleService roleService;

	  PasswordEncoder encrypt;

	public BasicSpringSecurityApplication(PasswordEncoder encrypt) {
		this.encrypt = encrypt;
	}

	@Bean
	  PasswordEncoder pse() {
	  	return new BCryptPasswordEncoder();
	  }*/

	
	public static void main(String[] args) {
		SpringApplication.run(BasicSpringSecurityApplication.class, args);
	}
/*	@Override
	public void run(String... args) throws Exception {

	 List<UserRole> roles = new ArrayList<>();
	 UserRole role = new UserRole(); role.setRole("ROLE_USER");
	 UserRole role1 = new UserRole(); role1.setRole("ROLE_ADMIN");

	 roleService.saveRole(role); roleService.saveRole(role1);

	  UserInfo userInfo = new UserInfo(); userInfo.setUserName("rakib");
	  userInfo.setUserPhone("01680023583");
	  userInfo.setUserPassword(encrypt.encode("123"));

	  roles.add(role); roles.add(role1);

	  userInfo.setRole(roles);

	  userService.SaveUser(userInfo);
 }*/

}
