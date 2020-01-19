package com.rakib.domain.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.rakib.domain.UserInfo;
@Repository
public interface UserInfoRepo extends MongoRepository<UserInfo, String> {
	
	UserInfo findByUserPhone(String userPhone);

}
