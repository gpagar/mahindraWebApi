package com.ganesh.mahindra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.mahindra.model.GraphType;
import com.ganesh.mahindra.model.Info;
import com.ganesh.mahindra.model.UserDetails;
import com.ganesh.mahindra.repository.GraphTypeRepository;
import com.ganesh.mahindra.repository.UserDetailsRepository;

@RestController
public class RestApiController {
	
	@Autowired
	UserDetailsRepository UserDetailsRepository;
	
	@Autowired
	GraphTypeRepository graphTypeRepository;
	
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
	
	@RequestMapping(value = { "/getAllUsers" }, method = RequestMethod.POST)
	@ResponseBody
	public List<UserDetails> getAllUsers(@RequestParam("deptId") List<Integer> deptId) {

		List<UserDetails>	userDetails=UserDetailsRepository.findByDelStatusAndInt1In(0,deptId);
		
		return userDetails;
	}
	
	@RequestMapping(value = { "/getGraphOwner" }, method = RequestMethod.POST)
	@ResponseBody
	public GraphType getGraphOwner(@RequestParam("graphType") int graphType,@RequestParam("deptId") int deptId) {

		GraphType graphTypeRes=graphTypeRepository.findByGraphTypeAndDelStatusAndExInt(graphType,0,deptId);
		
		return graphTypeRes;
	}
	@RequestMapping(value = { "/updateGraphOwner" }, method = RequestMethod.POST)
	@ResponseBody
	public Info updateGraphOwner(@RequestParam("graphType") int graphType, @RequestParam("userId") int userId,@RequestParam("deptId") int deptId) {

		Info info=new Info();
		System.err.println(graphType);System.err.println(userId);System.err.println(graphType);
		int isUpdated=graphTypeRepository.updateGraphOwner(graphType, userId,deptId);
		if(isUpdated>0)
		{
			info.setError(false);
			info.setMessage("Updated");
		}
		else
		{
			info.setError(true);
			info.setMessage("Not Updated");
		}
		return info;
	}
}
