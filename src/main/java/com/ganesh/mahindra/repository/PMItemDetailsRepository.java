package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.PMItemDetails;

public interface PMItemDetailsRepository extends JpaRepository<PMItemDetails, Integer>{

	
	List<PMItemDetails> findByActivityIdAndDelStatus(int activityId, int delStstaus);
}
