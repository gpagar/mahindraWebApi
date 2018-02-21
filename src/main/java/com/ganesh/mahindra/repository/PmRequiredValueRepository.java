package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.PmRequiredValue;

public interface PmRequiredValueRepository extends JpaRepository<PmRequiredValue, Integer>{

	
	List<PmRequiredValue> findByDelStatus(int delStatus);
}
