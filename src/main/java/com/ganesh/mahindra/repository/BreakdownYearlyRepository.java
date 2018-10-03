package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.BreakdownYearly;
@Repository
public interface BreakdownYearlyRepository extends JpaRepository<BreakdownYearly, Integer>{

	/*@Query(value="select count(*) as breakdown_count,year(date)as year from why_why_f18 where machine_id=:machinId and month between :fromMonth and :toMonth group by year",nativeQuery=true)
	List<BreakdownYearly> getYearwiseBreakdowns(@Param("machinId")int machinId,@Param("fromMonth") String fromMonth,@Param("toMonth") String toMonth);
*/
	@Query(value="select SUM(1) as id,coalesce((select count(*) as breakdown_count1 from why_why_f18 where dept=:deptId and date between :fromFirstYear and :toFirstYear ),0) as first_year, coalesce((select count(*) as breakdown_count2 from why_why_f18 where dept=:deptId and date between :fromSecondYear and :toSecondYear ),0) as second_year, coalesce((select count(*) as breakdown_count3 from why_why_f18 where dept=:deptId and date between :fromThirdYear and :toThirdYear ),0) as third_year, coalesce((select count(*) as breakdown_count4 from why_why_f18 where dept=:deptId and date between :fromFourthYear and :toFourthYear ),0) as fourth_year from why_why_f18",nativeQuery=true)
	BreakdownYearly getYearwiseBreakdowns(@Param("fromFirstYear") String fromFirstYear,@Param("toFirstYear") String toFirstYear,
			@Param("fromSecondYear")String fromSecondYear,@Param("toSecondYear") String toSecondYear, @Param("fromThirdYear")String fromThirdYear,@Param("toThirdYear") String toThirdYear,@Param("fromFourthYear") String fromFourthYear,
			@Param("toFourthYear")String toFourthYear ,@Param("deptId")int deptId);

	@Query(value="select SUM(1) as id,coalesce((select count(*) as breakdown_count1 from why_why_f18 where dept=:deptId and rank=1 and date between :fromFirstYear and :toFirstYear ),0) as first_year, coalesce((select count(*) as breakdown_count2 from why_why_f18 where rank=1 and dept=:deptId and date between :fromSecondYear and :toSecondYear ),0) as second_year, coalesce((select count(*) as breakdown_count3 from why_why_f18 where rank=1 and dept=:deptId and date between :fromThirdYear and :toThirdYear ),0) as third_year, coalesce((select count(*) as breakdown_count4 from why_why_f18 where rank=1 and dept=:deptId and date between :fromFourthYear and :toFourthYear ),0) as fourth_year from why_why_f18",nativeQuery=true)
	BreakdownYearly getARankYearwiseBreakdowns(@Param("fromFirstYear") String fromFirstYear,@Param("toFirstYear") String toFirstYear,
			@Param("fromSecondYear")String fromSecondYear,@Param("toSecondYear") String toSecondYear, @Param("fromThirdYear")String fromThirdYear,@Param("toThirdYear") String toThirdYear,@Param("fromFourthYear") String fromFourthYear,
			@Param("toFourthYear")String toFourthYear,@Param("deptId")int deptId);

	@Query(value="select SUM(1) as id,coalesce((select count(*) as breakdown_count1 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromFirstYear and :toFirstYear ),0) as first_year, coalesce((select count(*) as breakdown_count2 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromSecondYear and :toSecondYear ),0) as second_year, coalesce((select count(*) as breakdown_count3 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromThirdYear and :toThirdYear ),0) as third_year, coalesce((select count(*) as breakdown_count4 from why_why_f18 where rank!=1 and dept=:deptId and date between :fromFourthYear and :toFourthYear ),0) as fourth_year from why_why_f18",nativeQuery=true)
	BreakdownYearly getAllBrekYearwiseBreakdowns(@Param("fromFirstYear") String fromFirstYear,@Param("toFirstYear") String toFirstYear,
			@Param("fromSecondYear")String fromSecondYear,@Param("toSecondYear") String toSecondYear, @Param("fromThirdYear")String fromThirdYear,@Param("toThirdYear") String toThirdYear,@Param("fromFourthYear") String fromFourthYear,
			@Param("toFourthYear")String toFourthYear,@Param("deptId")int deptId);
}
