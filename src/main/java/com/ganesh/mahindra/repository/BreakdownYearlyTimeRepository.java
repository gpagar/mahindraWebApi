package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.BreakdownTimeYearly;
@Repository
public interface BreakdownYearlyTimeRepository extends JpaRepository<BreakdownTimeYearly, Integer> {

	@Query(value="select SUM(1) as id,coalesce((select SUM(bd_time_loss)  from why_why_f18 where rank!=1 and dept=:deptId and date between :fromFirstYear and :toFirstYear ),0) as first_year_time, coalesce((select SUM(bd_time_loss)  from why_why_f18 where rank!=1 and dept=:deptId and date between :fromSecondYear and :toSecondYear ),0) as second_year_time, coalesce((select SUM(bd_time_loss)  from why_why_f18 where rank!=1 and dept=:deptId and date between :fromThirdYear and :toThirdYear ),0) as third_year_time, coalesce((select SUM(bd_time_loss)  from why_why_f18 where rank!=1 and dept=:deptId and date between :fromFourthYear and :toFourthYear ),0) as fourth_year_time ,coalesce((select count(*) as breakdown_count1 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromFirstYear and :toFirstYear ),0) as first_year, coalesce((select count(*) as breakdown_count2 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromSecondYear and :toSecondYear ),0) as second_year, coalesce((select count(*) as breakdown_count3 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromThirdYear and :toThirdYear ),0) as third_year, coalesce((select count(*) as breakdown_count4 from why_why_f18 where rank!=1  and dept=:deptId and date between :fromFourthYear and :toFourthYear ),0) as fourth_year  from why_why_f18",nativeQuery=true)
	BreakdownTimeYearly getAllBrekYearwiseBreakdownTime(@Param("fromFirstYear") String fromFirstYear,@Param("toFirstYear") String toFirstYear,
			@Param("fromSecondYear")String fromSecondYear,@Param("toSecondYear") String toSecondYear, @Param("fromThirdYear")String fromThirdYear,@Param("toThirdYear") String toThirdYear,@Param("fromFourthYear") String fromFourthYear,
			@Param("toFourthYear")String toFourthYear,@Param("deptId")int deptId);

	@Query(value="select SUM(1) as id,coalesce((select SUM(engine_loss)  from why_why_f18 where rank!=1 and dept=:deptId and date between :fromFirstYear and :toFirstYear ),0) as first_year_time, coalesce((select SUM(engine_loss)  from why_why_f18 where rank!=1 and dept=:deptId and date between :fromSecondYear and :toSecondYear ),0) as second_year_time, coalesce((select SUM(engine_loss)  from why_why_f18 where rank!=1 and dept=:deptId and date between :fromThirdYear and :toThirdYear ),0) as third_year_time, coalesce((select SUM(engine_loss)  from why_why_f18 where rank!=1 and dept=:deptId and date between :fromFourthYear and :toFourthYear ),0) as fourth_year_time ,coalesce((select count(*) as breakdown_count1 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromFirstYear and :toFirstYear ),0) as first_year, coalesce((select count(*) as breakdown_count2 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromSecondYear and :toSecondYear ),0) as second_year, coalesce((select count(*) as breakdown_count3 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromThirdYear and :toThirdYear ),0) as third_year, coalesce((select count(*) as breakdown_count4 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromFourthYear and :toFourthYear ),0) as fourth_year  from why_why_f18",nativeQuery=true)
	BreakdownTimeYearly getAllBrekYearwiseBreakdownELoss(@Param("fromFirstYear") String fromFirstYear,@Param("toFirstYear") String toFirstYear,
			@Param("fromSecondYear")String fromSecondYear,@Param("toSecondYear") String toSecondYear, @Param("fromThirdYear")String fromThirdYear,@Param("toThirdYear") String toThirdYear,@Param("fromFourthYear") String fromFourthYear,
			@Param("toFourthYear")String toFourthYear,@Param("deptId")int deptId);

}
