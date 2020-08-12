package com.userlogin.demo.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.userlogin.demo.dao.UserInfoRepository;
import com.userlogin.demo.model.UserInfo;
import com.userlogin.demo.serviceInterface.UserInfoInterface;

@Service
public class UserInfoServiceImpl implements UserInfoInterface {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserInfoRepository userRepo;

	public Object userLogIn(UserInfo userInfo) {
		Map<String, Object> map=new HashMap<>();
		UserInfo u=userRepo.findByEmailId(userInfo.getEmailId());
		if(u!=null) {
			if(u.getPassword().equals(userInfo.getPassword())) {
				map.put("Well Come!", "login sucessful");
			}else {
				map.put("try again", "Invalid password");
				}
		}else {
			map.put("try again", "Invalid emailid");
			}
		return map;
	}
	
	@Override
	public Object saveUserInformation(UserInfo userInfo) {
		
		Map<String, Object> m = new HashMap<String, Object>();
		userInfo.setPassword(passwordEncoder.encode("password"));
        UserInfo h=userRepo.findByEmailId(userInfo.getEmailId());
		if(h!=null) {
	    m.put("try again!", "this emailid  already exist!");
        }else {
        	m.put("Data Registered! ",userRepo.save(userInfo));
    	   }
		return m;
		}
	
	@Override
	public Object updateUserInformation(@RequestBody UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode("password"));
		Map<String, Object> m = new HashMap<String, Object>();
		UserInfo h=userRepo.findByEmailId(userInfo.getEmailId());
		if(h.getEmailId().equals(userInfo.getEmailId())){
		h.setEmailId(userInfo.getEmailId());
		h.setPassword(userInfo.getPassword());
		h.setFirstName(userInfo.getFirstName());
		h.setLastName(userInfo.getLastName());
		h.setAddress(userInfo.getAddress());
		h.setDob(userInfo.getDob());
		h.setPhoneNo(userInfo.getPhoneNo());
		m.put("Ok","UserInformation hasbeen updated Successfully!");
		userRepo.save(userInfo);
		}
		else {
			m.put("try again!", "update hasbeen fail!");	
		}
		return m;
	}
	
	    @Override
	    public List<UserInfo> findAllUserInformations() {
        return (List<UserInfo>) userRepo.findAll();
	    }
	     
	    
	    @Override
		public void deleteUserInformation(String emailId) {
		userRepo.deleteByEmailId(emailId);
		}

		@Override
		public UserInfo findUserInformation(String emailId) {
		return userRepo.findByEmailId(emailId);
		}
		@Override
		public void deleteAllUserInformation() {
	    Map<String,Object> m=new HashMap<>();
	    m.put("Check your Database", "All UserInformation's hasbeen deleted Successfully!");
	    userRepo.deleteAll();	
		}

		
}
	/*
	 * public Object userLogIn(String emailId, String password) {
	 * 
	 * Map<String, Object> map=new HashMap<>(); UserInfo
	 * u=userRepo.findByEmailId(emailId); if(u!=null) {
	 * if(u.getPassword().equals(password)) { map.put("msg", "login sucessful");
	 * }else { map.put("msg", "wrong password"); } }else { map.put("msg",
	 * "wrong emailid"); } return map; }
	 */




	
	
	 

	

	



	 
	
	
	
	
