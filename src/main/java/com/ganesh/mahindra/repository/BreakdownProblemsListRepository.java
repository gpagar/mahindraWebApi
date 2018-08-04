package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.BreakdownProblems;
import com.ganesh.mahindra.model.BreakdownProblemsList;

@Repository
public interface BreakdownProblemsListRepository extends JpaRepository<BreakdownProblems, Integer>{

	@Query(value="select id,machine_no,problem_reported  from why_why_f18 where  date=:date2",nativeQuery=true)
	List<BreakdownProblems> getDailyBreakdownMachineDetails(@Param("date2")String date2);

	
	@Query(value="select id,machine_no,problem_reported  from why_why_f18 where  date=:date2 and rank=1",nativeQuery=true)
	List<BreakdownProblems> getDailyARankBreakdownMachineDetails(@Param("date2")String date2);

	@Query(value="select id,machine_no,problem_reported  from why_why_f18 where  date=:date2 and rank!=1",nativeQuery=true)
	List<BreakdownProblems> getDailyAllBreakdownMachineDetails(@Param("date2")String date2);

}
