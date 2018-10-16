package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.cbm.CbmSchedule;

@Repository
public interface CbmScheduleRepository extends JpaRepository<CbmSchedule, Integer>{

	List<CbmSchedule> findByDeptId(int deptId);

	@Query(value="select * from m_cbm_schedule where (stc_q1>0 or stc_q3>0 ) and dept_id=:deptId",nativeQuery=true)
	List<CbmSchedule> getCbmScheduleListForSpindleTemper(@Param("deptId")int deptId);

	@Query(value="select * from m_cbm_schedule where (scf_q1>0 or scf_q2>0 or scf_q3>0 or scf_q4>0) and dept_id=:deptId",nativeQuery=true)
	List<CbmSchedule> getCbmScheduleListForSpindleClimpingForce(@Param("deptId")int deptId);


	@Query(value="select * from m_cbm_schedule where bbt_h2>0  and dept_id=:deptId",nativeQuery=true)
	List<CbmSchedule> getCbmScheduleListForBallBarTest(@Param("deptId")int deptId);
}
