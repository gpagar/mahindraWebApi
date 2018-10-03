package com.ganesh.mahindra.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.mahindra.model.MachinDetails;

public interface MachinDetailsRepository extends JpaRepository<MachinDetails, Integer>{
	
	List<MachinDetails> findByTypeAndDelStatus(int type, int delStatus);

	MachinDetails findByMachinIdAndDelStatus(int machineId, int i);
	
	@Modifying
	@Transactional
	@Query("Delete from MachinDetails m   WHERE m.machinId=:machinId")
	int deleteMachinId(@Param("machinId")int machinId );


	List<MachinDetails> findByInt1InAndDelStatusOrderByMachinName(List<Integer> deptId, int i);

	List<MachinDetails> findByTypeAndInt1AndDelStatus(int type, int deptId, int i);
	

}
