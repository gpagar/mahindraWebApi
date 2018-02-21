package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.MachinDetails;

public interface MachinDetailsRepository extends JpaRepository<MachinDetails, Integer>{
	
	List<MachinDetails> findByTypeAndDelStatus(int type, int delStatus);
	

}
