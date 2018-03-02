package com.ganesh.mahindra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.mahindra.model.Info;
import com.ganesh.mahindra.model.UserDetails;
import com.ganesh.mahindra.repository.UserDetailsRepository;

@RestController
public class RestApiController {
	
	@Autowired
	UserDetailsRepository UserDetailsRepository;
	
	//Login 
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	@ResponseBody
	public UserDetails loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {

		UserDetails userDetails=new UserDetails();
		userDetails=UserDetailsRepository.findByEmailAndPasswordAndDelStatus(email, password,0);
		
		return userDetails;
	}
	
	//Insert New User
	@RequestMapping(value = { "/insertNewUser" }, method = RequestMethod.POST)
	@ResponseBody
	public Info insertNewUser(@RequestBody UserDetails userDetails) {

		UserDetails userDetailsRes=new UserDetails();
		userDetailsRes=UserDetailsRepository.save(userDetails);
		Info info=new Info();
		
		if(userDetailsRes!=null)
		{
			info.setError(false);
			info.setMessage("Success");
		}
		else {
			info.setError(true);
			info.setMessage("Failed Insert");
		}
		return info;
		
		
	}
	
	
	
}
