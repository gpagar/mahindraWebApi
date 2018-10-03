package com.ganesh.mahindra.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.mahindra.model.PMActivityDetails;
import com.ganesh.mahindra.model.PMItemDetails;

public interface PMActivityDetailsRepository extends JpaRepository<PMActivityDetails, Integer>{

	
	List<PMActivityDetails> findByMachinIdAndDelStatus(int machinId, int delStatus);

	List<PMActivityDetails> findByDelStatus(int i);


	@Modifying
	@Transactional
	@Query("Delete from PMActivityDetails m   WHERE m.activityId=:activityId")
	int deleteMachinId(@Param("activityId")int activityId );

	PMActivityDetails findByActivityId(int activityId);

	
	
	 
}
