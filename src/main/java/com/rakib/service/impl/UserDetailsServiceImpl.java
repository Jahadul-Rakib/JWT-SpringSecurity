package com.rakib.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.rakib.domain.UserInfo;
import com.rakib.domain.repo.UserInfoRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserInfoRepo userInfo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = userInfo.findByUserPhone(username);

		if (user != null) {
			return user;
		} else {
			throw new UsernameNotFoundException("user not found by phone number "+ user.getUserPhone());
		}
	}

}
