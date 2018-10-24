package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.cbm.CbmEarthingResistance;

public interface CbmEarthingResistanceRepository extends JpaRepository<CbmEarthingResistance, Integer>{

	List<CbmEarthingResistance> findByStatusAndDeptId(int i, int deptId);

}
