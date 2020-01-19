package com.rakib.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakib.domain.UserRole;
import com.rakib.domain.repo.UserRoleRepo;
import com.rakib.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	UserRoleRepo roleRepo;


	@Override
	public UserRole saveRole(UserRole roleInfo) {
		UserRole save = roleRepo.save(roleInfo);
		return save;
	}


}
