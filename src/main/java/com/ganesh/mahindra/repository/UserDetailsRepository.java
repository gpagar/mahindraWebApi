package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{

	
	UserDetails findByEmailAndPasswordAndDelStatus(String email, String password, int delStatus);

	List<UserDetails> findByDelStatus(int i);

	List<UserDetails> findByDelStatusAndInt1In(int i, List<Integer> deptId);
}
