package com.rakib.domain.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.rakib.domain.UserRole;
@Repository
public interface UserRoleRepo extends MongoRepository<UserRole, String> {

	UserRole findByUserRole(String userRole);
	
}
