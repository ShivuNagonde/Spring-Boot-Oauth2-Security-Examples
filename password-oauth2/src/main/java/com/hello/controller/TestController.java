package com.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test")
	public String test() {
		return "Hello World"; 
		}
}

//1.In POST Method  URL: http://localhost:8082/oauth/token
//  In Body
//Key                               Value
//1.grant_type                      password
//2.username                        javainuse-user
//3.password                        javainuse-pass
//In Authorization 
//     we select 
 //    Type  =>   Basic Auth
//      username===>javainuse-client
//      password===>javainuse-secret
//      then send and get access token,copy that 
//2. In GET Method  URL: http://localhost:8082/test
//In Authorization we select 
 //      Type ==>Bearer Token
 //       Token==>past that copied token here.
//then send and get the Result.
