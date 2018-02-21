package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.PaMaintananceDetails;

public interface PaMaintananceDetailsRepository extends JpaRepository<PaMaintananceDetails, Integer>{
	
	PaMaintananceDetails save(PaMaintananceDetails paMaintananceDetails);

}
