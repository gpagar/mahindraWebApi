package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.PMCheckPoints;

public interface PMCheckPointsRepository extends JpaRepository<PMCheckPoints, Integer>{

	
	List<PMCheckPoints> findByItemIdAndDelStatus(int itemId,int delStatus);
}
