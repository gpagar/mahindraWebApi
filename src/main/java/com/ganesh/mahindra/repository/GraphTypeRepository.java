package com.ganesh.mahindra.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.GraphType;

@Repository
public interface GraphTypeRepository extends JpaRepository<GraphType, Integer>{

	GraphType findByGraphTypeAndDelStatusAndExInt(int graphType, int delStatus,int deptId);

	@Modifying
	@Transactional
	@Query("update GraphType set userId=:userId where graphType=:graphType and exInt=:deptId")
	int updateGraphOwner(@Param("graphType")int graphType,@Param("userId") int userId,@Param("deptId")int deptId);


}
