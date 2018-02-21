package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.mahindra.model.PaMaintananceDetails; 

public interface PaMaintananceDetailsRepository extends JpaRepository<PaMaintananceDetails, Integer>{
	
	PaMaintananceDetails save(PaMaintananceDetails paMaintananceDetails);

	@Query(value="select * from pa_maintanance where machin_id=:machineId and check_point_id=:checkPointId and status<4",nativeQuery=true)
	PaMaintananceDetails getCheckRecordAgistMachine(@Param("checkPointId") int checkPointId,@Param("machineId") int machineId);

}
