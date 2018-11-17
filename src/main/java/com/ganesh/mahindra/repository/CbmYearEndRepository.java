package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.mahindra.model.cbm.CbmYearEnd;

public interface CbmYearEndRepository extends JpaRepository<CbmYearEnd, Integer>{

	CbmYearEnd findByDeptIdAndCbmTypeAndStatus(int deptId, int cbmType, int i);

	
	@Query(value="select * from cbm_yar_end where dept_id=:deptId and cbm_type=:cbmType and status=:status",nativeQuery=true)
	List<CbmYearEnd> getYearEndList(@Param("deptId")int deptId,@Param("cbmType") int cbmType,@Param("status") int status);

}
