package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.mahindra.model.cbm.CbmEarthingResistance;

public interface CbmEarthingResistanceRepository extends JpaRepository<CbmEarthingResistance, Integer>{

	List<CbmEarthingResistance> findByStatusAndDeptId(int i, int deptId);

	@Query(value=" select * from t_cbm_erthing_resis where varchar2=:yearId",nativeQuery=true)
	List<CbmEarthingResistance> getByYearId(@Param("yearId")int yearId);

}
