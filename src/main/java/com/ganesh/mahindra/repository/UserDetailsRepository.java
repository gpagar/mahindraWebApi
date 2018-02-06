package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{

	
	UserDetails findByEmailAndPassword(String email, String password);
}
