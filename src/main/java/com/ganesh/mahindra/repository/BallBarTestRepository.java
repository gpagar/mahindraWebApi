package com.ganesh.mahindra.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.cbm.BallBarTest;

@Repository
public interface BallBarTestRepository extends JpaRepository<BallBarTest, Serializable>{

	List<BallBarTest> findByStatusAndDeptId(int i, int deptId);

}
