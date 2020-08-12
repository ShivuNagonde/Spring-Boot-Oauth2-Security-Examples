package com.userlogin.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.userlogin.demo.model.UserInfo;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
	

	UserInfo findByEmailId(UserInfo userInfo);

	Object save(String emailId);
	
	UserInfo findByEmailId(String emailId);

	
	@Transactional
	void deleteByEmailId(String emailId);

	

	

	

	
	

	

	

	//void deleteByEmailId(String emailId);

	//UserInfo deleteByEmailId(UserInfo userInfo);

 	

    //UserInfo save(UserInfo userInfo);

}
