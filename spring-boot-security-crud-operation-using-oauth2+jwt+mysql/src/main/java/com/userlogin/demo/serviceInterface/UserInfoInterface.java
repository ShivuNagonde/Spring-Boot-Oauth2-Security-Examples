package com.userlogin.demo.serviceInterface;

import java.util.List;
import com.userlogin.demo.model.UserInfo;

public interface UserInfoInterface {
	
	public Object saveUserInformation(UserInfo userInfo);
	
	public List<UserInfo> findAllUserInformations();
	
	public UserInfo findUserInformation(String emailId);

	void deleteUserInformation(String emailId);

	public Object updateUserInformation(UserInfo userInfo);

	void deleteAllUserInformation();

	

	
	

	



	

	

	
	
	
	

	

	

	



	

	

	

	
	
}
