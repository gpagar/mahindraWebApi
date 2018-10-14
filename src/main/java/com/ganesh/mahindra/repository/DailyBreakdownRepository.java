package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.DailyBreakdowns;

@Repository
public interface DailyBreakdownRepository extends JpaRepository<DailyBreakdowns, Integer>{

	
	@Query(value="select SUM(1) as id,coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date1  ),0) as day1,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date2  ),0) as day2,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date3  ),0) as day3,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date4  ),0) as day4,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date5  ),0) as day5,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date6  ),0) as day6,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date7  ),0) as day7,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date8  ),0) as day8,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date9  ),0) as day9,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date10  ),0) as day10,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date11  ),0) as day11,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date12 ),0) as day12,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date13  ),0) as day13,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date14 ),0) as day14,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date15  ),0) as day15,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date16  ),0) as day16,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date17  ),0) as day17,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date18  ),0) as day18,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date19  ),0) as day19,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date20  ),0) as day20,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date21 ),0) as day21,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date22  ),0) as day22,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date23  ),0) as day23,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date24 ),0) as day24,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date25  ),0) as day25,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date26 ),0) as day26,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date27  ),0) as day27,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date28  ),0) as day28,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date29  ),0) as day29,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='MS' and dept=:deptId and date=:date30  ),0) as day30\n" + 
			"from why_why_f18 ",nativeQuery=true)
	DailyBreakdowns getDailyBreakdowns(@Param("date1")String date1,@Param("date2") String date2,@Param("date3") String date3,@Param("date4") String date4,@Param("date5") String date5,
			@Param("date6")String date6,@Param("date7") String date7,@Param("date8") String date8,@Param("date9") String date9,@Param("date10") String date10,@Param("date11") String date11,
			@Param("date12")String date12, @Param("date13")String date13,@Param("date14") String date14,@Param("date15") String date15,@Param("date16") String date16,@Param("date17") String date17,
			@Param("date18")String date18,@Param("date19") String date19,@Param("date20") String date20,@Param("date21") String date21,@Param("date22") String date22,@Param("date23") String date23,
			@Param("date24")String date24,@Param("date25") String date25,@Param("date26") String date26,@Param("date27") String date27,@Param("date28") String date28, @Param("date29")String date29,
			@Param("date30")String date30,@Param("deptId")int deptId);

	@Query(value="select SUM(1) as id,coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date1 and rank=1),0) as day1,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date2 and rank=1 ),0) as day2,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date3 and rank=1 ),0) as day3,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date4 and rank=1 ),0) as day4,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date5 and rank=1 ),0) as day5,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date6 and rank=1 ),0) as day6,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date7 and rank=1 ),0) as day7,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date8  and rank=1),0) as day8,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date9 and rank=1 ),0) as day9,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date10  and rank=1),0) as day10,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date11 and rank=1 ),0) as day11,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date12 and rank=1),0) as day12,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date13  and rank=1),0) as day13,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date14 and rank=1),0) as day14,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date15 and rank=1 ),0) as day15,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date16 and rank=1 ),0) as day16,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date17 and rank=1 ),0) as day17,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date18 and rank=1 ),0) as day18,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date19 and rank=1),0) as day19,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date20 and rank=1 ),0) as day20,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date21 and rank=1),0) as day21,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date22  and rank=1),0) as day22,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date23 and rank=1 ),0) as day23,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date24 and rank=1),0) as day24,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date25  and rank=1),0) as day25,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date26 and rank=1),0) as day26,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date27 and rank=1 ),0) as day27,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date28 and rank=1 ),0) as day28,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date29 and rank=1 ),0) as day29,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date30 and rank=1 ),0) as day30\n" + 
			"from why_why_f18 ",nativeQuery=true)
	DailyBreakdowns getARankDailyBreakdowns(@Param("date1")String date1,@Param("date2") String date2,@Param("date3") String date3,@Param("date4") String date4,@Param("date5") String date5,
			@Param("date6")String date6,@Param("date7") String date7,@Param("date8") String date8,@Param("date9") String date9,@Param("date10") String date10,@Param("date11") String date11,
			@Param("date12")String date12, @Param("date13")String date13,@Param("date14") String date14,@Param("date15") String date15,@Param("date16") String date16,@Param("date17") String date17,
			@Param("date18")String date18,@Param("date19") String date19,@Param("date20") String date20,@Param("date21") String date21,@Param("date22") String date22,@Param("date23") String date23,
			@Param("date24")String date24,@Param("date25") String date25,@Param("date26") String date26,@Param("date27") String date27,@Param("date28") String date28, @Param("date29")String date29,
			@Param("date30")String date30,@Param("deptId")int deptId);


	@Query(value="select SUM(1) as id,coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and  date=:date1 and rank!=1),0) as day1,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date2 and rank!=1 ),0) as day2,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date3 and rank!=1 ),0) as day3,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date4 and rank!=1 ),0) as day4,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date5 and rank!=1 ),0) as day5,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date6 and rank!=1 ),0) as day6,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date7 and rank!=1 ),0) as day7,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date8  and rank!=1),0) as day8,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date9 and rank!=1 ),0) as day9,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date10  and rank!=1),0) as day10,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date11 and rank!=1 ),0) as day11,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date12 and rank!=1),0) as day12,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date13  and rank!=1),0) as day13,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date14 and rank!=1),0) as day14,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date15 and rank!=1 ),0) as day15,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date16 and rank!=1 ),0) as day16,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date17 and rank!=1 ),0) as day17,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date18 and rank!=1 ),0) as day18,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date19 and rank!=1),0) as day19,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date20 and rank!=1 ),0) as day20,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date21 and rank!=1),0) as day21,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date22  and rank!=1),0) as day22,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date23 and rank!=1 ),0) as day23,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date24 and rank!=1),0) as day24,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date25  and rank!=1),0) as day25,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date26 and rank!=1),0) as day26,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date27 and rank!=1 ),0) as day27,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and date=:date28 and rank!=1 ),0) as day28,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date29 and rank!=1 ),0) as day29,\n" + 
			"coalesce((select count(*)  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date30 and rank!=1 ),0) as day30\n" + 
			"from why_why_f18 ",nativeQuery=true)
	DailyBreakdowns getAllBrekDailyBreakdowns(@Param("date1")String date1,@Param("date2") String date2,@Param("date3") String date3,@Param("date4") String date4,@Param("date5") String date5,
			@Param("date6")String date6,@Param("date7") String date7,@Param("date8") String date8,@Param("date9") String date9,@Param("date10") String date10,@Param("date11") String date11,
			@Param("date12")String date12, @Param("date13")String date13,@Param("date14") String date14,@Param("date15") String date15,@Param("date16") String date16,@Param("date17") String date17,
			@Param("date18")String date18,@Param("date19") String date19,@Param("date20") String date20,@Param("date21") String date21,@Param("date22") String date22,@Param("date23") String date23,
			@Param("date24")String date24,@Param("date25") String date25,@Param("date26") String date26,@Param("date27") String date27,@Param("date28") String date28, @Param("date29")String date29,
			@Param("date30")String date30,@Param("deptId")int deptId);

	@Query(value="select SUM(1) as id,coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date1 and rank!=1),0) as day1,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date2 and rank!=1 ),0) as day2,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date3 and rank!=1 ),0) as day3,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date4 and rank!=1 ),0) as day4,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date5 and rank!=1 ),0) as day5,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date6 and rank!=1 ),0) as day6,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date7 and rank!=1 ),0) as day7,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date8  and rank!=1),0) as day8,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date9 and rank!=1 ),0) as day9,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date10  and rank!=1),0) as day10,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date11 and rank!=1 ),0) as day11,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date12 and rank!=1),0) as day12,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date13  and rank!=1),0) as day13,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date14 and rank!=1),0) as day14,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date15 and rank!=1 ),0) as day15,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date16 and rank!=1 ),0) as day16,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date17 and rank!=1 ),0) as day17,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date18 and rank!=1 ),0) as day18,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date19 and rank!=1),0) as day19,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date20 and rank!=1 ),0) as day20,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date21 and rank!=1),0) as day21,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date22  and rank!=1),0) as day22,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date23 and rank!=1 ),0) as day23,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date24 and rank!=1),0) as day24,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date25  and rank!=1),0) as day25,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date26 and rank!=1),0) as day26,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date27 and rank!=1 ),0) as day27,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date28 and rank!=1 ),0) as day28,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date29 and rank!=1 ),0) as day29,\n" + 
			"coalesce((select bd_time_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date30 and rank!=1 ),0) as day30\n" + 
			"from why_why_f18 ",nativeQuery=true)
	DailyBreakdowns getAllBrekDailyBreakdownsTime(@Param("date1")String date1,@Param("date2") String date2,@Param("date3") String date3,@Param("date4") String date4,@Param("date5") String date5,
			@Param("date6")String date6,@Param("date7") String date7,@Param("date8") String date8,@Param("date9") String date9,@Param("date10") String date10,@Param("date11") String date11,
			@Param("date12")String date12, @Param("date13")String date13,@Param("date14") String date14,@Param("date15") String date15,@Param("date16") String date16,@Param("date17") String date17,
			@Param("date18")String date18,@Param("date19") String date19,@Param("date20") String date20,@Param("date21") String date21,@Param("date22") String date22,@Param("date23") String date23,
			@Param("date24")String date24,@Param("date25") String date25,@Param("date26") String date26,@Param("date27") String date27,@Param("date28") String date28, @Param("date29")String date29,
			@Param("date30")String date30,@Param("deptId")int deptId);

	@Query(value="select SUM(1) as id,coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and  dept=:deptId and date=:date1 and rank!=1),0) as day1,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date2 and rank!=1 ),0) as day2,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date3 and rank!=1 ),0) as day3,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date4 and rank!=1 ),0) as day4,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date5 and rank!=1 ),0) as day5,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date6 and rank!=1 ),0) as day6,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date7 and rank!=1 ),0) as day7,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date8  and rank!=1),0) as day8,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date9 and rank!=1 ),0) as day9,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date10  and rank!=1),0) as day10,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date11 and rank!=1 ),0) as day11,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date12 and rank!=1),0) as day12,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date13  and rank!=1),0) as day13,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date14 and rank!=1),0) as day14,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date15 and rank!=1 ),0) as day15,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date16 and rank!=1 ),0) as day16,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date17 and rank!=1 ),0) as day17,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date18 and rank!=1 ),0) as day18,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date19 and rank!=1),0) as day19,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date20 and rank!=1 ),0) as day20,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date21 and rank!=1),0) as day21,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date22  and rank!=1),0) as day22,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date23 and rank!=1 ),0) as day23,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date24 and rank!=1),0) as day24,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date25  and rank!=1),0) as day25,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date26 and rank!=1),0) as day26,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date27 and rank!=1 ),0) as day27,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date28 and rank!=1 ),0) as day28,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date29 and rank!=1 ),0) as day29,\n" + 
			"coalesce((select engine_loss  from why_why_f18 where bd_ms_pt='BD' and dept=:deptId and date=:date30 and rank!=1 ),0) as day30\n" + 
			"from why_why_f18 ",nativeQuery=true)
	DailyBreakdowns getAllBrekDailyBreakdownsELoss(@Param("date1")String date1,@Param("date2") String date2,@Param("date3") String date3,@Param("date4") String date4,@Param("date5") String date5,
			@Param("date6")String date6,@Param("date7") String date7,@Param("date8") String date8,@Param("date9") String date9,@Param("date10") String date10,@Param("date11") String date11,
			@Param("date12")String date12, @Param("date13")String date13,@Param("date14") String date14,@Param("date15") String date15,@Param("date16") String date16,@Param("date17") String date17,
			@Param("date18")String date18,@Param("date19") String date19,@Param("date20") String date20,@Param("date21") String date21,@Param("date22") String date22,@Param("date23") String date23,
			@Param("date24")String date24,@Param("date25") String date25,@Param("date26") String date26,@Param("date27") String date27,@Param("date28") String date28, @Param("date29")String date29,
			@Param("date30")String date30,@Param("deptId")int deptId);

}
