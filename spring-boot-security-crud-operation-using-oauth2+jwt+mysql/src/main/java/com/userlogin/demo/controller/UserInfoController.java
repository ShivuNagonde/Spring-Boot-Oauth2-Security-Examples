package com.userlogin.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.userlogin.demo.model.UserInfo;
import com.userlogin.demo.serviceImpl.UserInfoServiceImpl;

@RestController
@CrossOrigin("*")
public class UserInfoController {
	@Autowired
	private UserInfoServiceImpl userServiceImpl;

	//http://localhost:8083/login
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public Object login(@RequestBody UserInfo userInfo) {
		return userServiceImpl.userLogIn(userInfo);
	}

	//http://localhost:8083/register
	@RequestMapping(method = RequestMethod.POST, value = "/register", produces = "application/json")
	public Object saveUserInfo(@RequestBody UserInfo userInfo) {
		return userServiceImpl.saveUserInformation(userInfo);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/update/{emailId}",produces = "application/json")
	public Object updateUserInformation(@RequestBody UserInfo userInfo) {
	    return userServiceImpl.updateUserInformation(userInfo);
	 }
	 //http://localhost:8083/getAllUserInformation
	@RequestMapping(method = RequestMethod.GET,value = "/getAllUserInformation",produces = "application/json")
	public List<UserInfo> getAllUserInformation() {
		return userServiceImpl.findAllUserInformations();
	}

	@RequestMapping(method = RequestMethod.GET,value = "/getsingleuser/{emailId}",produces = "application/json")
	public UserInfo getUserInformation(@PathVariable("emailId") String emailId) {
		return userServiceImpl.findUserInformation(emailId);
	}

	@RequestMapping(value = "/delete/{emailId}",method = RequestMethod.DELETE ,produces = "application/json") 
	public String deleteUserInformation(@PathVariable("emailId") String emailId ) {
    userServiceImpl.deleteUserInformation(emailId);
    return "User data has been deleted successfully.";
	}
	//http://localhost:8083/deleteall
	@RequestMapping(method = RequestMethod.DELETE,value = "/deleteall",produces = "application/json")
	public String deleteAllUserInformations() {
	 userServiceImpl.deleteAllUserInformation();
	 return "All UserInformation hasbeen Deleted Successfully!";
	 }
 }
