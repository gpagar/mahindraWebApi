package com.ganesh.mahindra.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.mahindra.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{

	
	UserDetails findByEmailAndPasswordAndDelStatus(String email, String password, int delStatus);

	List<UserDetails> findByDelStatus(int i);

	List<UserDetails> findByDelStatusAndInt1In(int i, List<Integer> deptId);

	@Modifying
	@Transactional
	@Query("update UserDetails set del_status=1 where user_id=:userId ")
	int deleteUser(@Param("userId") int userId);

	UserDetails findByUserId(int userId);
}
