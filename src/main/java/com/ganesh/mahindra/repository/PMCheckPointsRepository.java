package com.ganesh.mahindra.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.mahindra.model.PMCheckPoints;

public interface PMCheckPointsRepository extends JpaRepository<PMCheckPoints, Integer>{

	
	List<PMCheckPoints> findByItemIdAndDelStatus(int itemId,int delStatus);

	List<PMCheckPoints> findByDelStatus(int i);


	@Modifying
	@Transactional
	@Query("update PMCheckPoints m  set m.delStatus=1 WHERE m.checkPointId=:machinCheckPoint")
	int deleteCheckpoints(@Param("machinCheckPoint")int machinCheckPoint );

	PMCheckPoints findByCheckPointId(int checkpointId);
	
	
	 
}
