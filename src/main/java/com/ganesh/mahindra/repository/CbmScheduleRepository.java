package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.cbm.CbmSchedule;

@Repository
public interface CbmScheduleRepository extends JpaRepository<CbmSchedule, Integer>{

	List<CbmSchedule> findByDeptId(int deptId);


}
