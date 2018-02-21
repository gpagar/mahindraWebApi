package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.PMActivityDetails;

public interface PMActivityDetailsRepository extends JpaRepository<PMActivityDetails, Integer>{

	
	List<PMActivityDetails> findByMachinIdAndDelStatus(int machinId, int delStatus);
}
