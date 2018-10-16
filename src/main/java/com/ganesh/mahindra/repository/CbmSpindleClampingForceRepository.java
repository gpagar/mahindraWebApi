package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.cbm.CbmSpindleClampingForce;

public interface CbmSpindleClampingForceRepository extends JpaRepository<CbmSpindleClampingForce, Integer>{

	List<CbmSpindleClampingForce> findByStatusAndDeptId(int i, int deptId);

}
