package com.ganesh.mahindra.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.BreakdownTarget;

@Repository
public interface BreakdownTargetRepository extends JpaRepository<BreakdownTarget, Integer>{

	List<BreakdownTarget> findByStatusAndGraphTypeAndExInt(int status, int graphType,int deptId);

	@Transactional
	@Modifying
	@Query("UPDATE BreakdownTarget SET status=0  WHERE targetId=:targetId")
	int deleteTarget(@Param("targetId")int targetId);

	BreakdownTarget findByStatusAndGraphTypeAndExIntAndYear(int i, int graphType, int deptId, int year);

	BreakdownTarget findByTargetId(int targetId);

}
