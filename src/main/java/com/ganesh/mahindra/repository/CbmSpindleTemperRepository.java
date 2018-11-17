package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.cbm.CbmSpindleTemper;

public interface CbmSpindleTemperRepository extends JpaRepository<CbmSpindleTemper, Integer>{

	List<CbmSpindleTemper> findByStatusAndDeptId(int i, int deptId);

	List<CbmSpindleTemper> findByYearEnd(String yearId);

}
