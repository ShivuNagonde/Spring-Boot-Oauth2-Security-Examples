package com.userlogin.demo.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userlogin.demo.model.ApiToken;
import com.userlogin.demo.model.UserInfo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/accessToken")
public class LoginController {
 
	@PostMapping
	public ResponseEntity<ApiToken> login(@RequestBody UserInfo userInfo){
		return new ResponseEntity<>(
				new ApiToken(Jwts.builder().setSubject(userInfo.getEmailId()).
						claim("roles", "user").setIssuedAt(new Date())
						.signWith(SignatureAlgorithm.HS256,"1abc12$%BCD65wrt")
						.compact()),HttpStatus.OK);
	}
}
//http://localhost:8083/accessToken