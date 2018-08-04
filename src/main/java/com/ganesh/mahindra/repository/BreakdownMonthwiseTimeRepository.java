package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.BreakdownTimeMonthwise;

@Repository
public interface BreakdownMonthwiseTimeRepository extends JpaRepository<BreakdownTimeMonthwise, Integer>{

	@Query(value="	select SUM(1) as id,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:first),0) as  breakdown_cnt1,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:second),0) as  breakdown_cnt2,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:third),0) as  breakdown_cnt3,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:fourth),0) as  breakdown_cnt4,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:fifth),0) as  breakdown_cnt5,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:sixth),0) as  breakdown_cnt6,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:seventh),0) as  breakdown_cnt7,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:eighth),0) as  breakdown_cnt8,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:ninth),0) as  breakdown_cnt9,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:tenth),0) as  breakdown_cnt10,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:eleventh),0) as  breakdown_cnt11,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:twelvth),0) as  breakdown_cnt12,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:first),0) as  breakdown_time1,coalesce((select sum(bd_time_loss) from why_why_f18 where rank!=1 and month=:second),0) as  breakdown_time2,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:third),0) as  breakdown_time3,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:fourth),0) as  breakdown_time4,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:fifth),0) as  breakdown_time5,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:sixth),0) as  breakdown_time6,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:seventh),0) as  breakdown_time7,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:eighth),0) as  breakdown_time8,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:ninth),0) as  breakdown_time9,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:tenth),0) as  breakdown_time10,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:eleventh),0) as  breakdown_time11,coalesce((select SUM(bd_time_loss) from why_why_f18 where rank!=1 and month=:twelvth),0) as  breakdown_time12 from why_why_f18\n" + 
			"",nativeQuery=true)
	BreakdownTimeMonthwise getAllBrekMonthwiseTimeBreakdowns(@Param("first")String first,@Param("second")String second,@Param("third")String third,@Param("fourth")String fourth,@Param("fifth")String fifth,@Param("sixth")String sixth,@Param("seventh")String seventh,@Param("eighth")String eighth,@Param("ninth")String ninth,@Param("tenth")String tenth,@Param("eleventh")String eleventh,@Param("twelvth")String twelvth);

	@Query(value="	select SUM(1) as id,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:first),0) as  breakdown_cnt1,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:second),0) as  breakdown_cnt2,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:third),0) as  breakdown_cnt3,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:fourth),0) as  breakdown_cnt4,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:fifth),0) as  breakdown_cnt5,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:sixth),0) as  breakdown_cnt6,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:seventh),0) as  breakdown_cnt7,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:eighth),0) as  breakdown_cnt8,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:ninth),0) as  breakdown_cnt9,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:tenth),0) as  breakdown_cnt10,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:eleventh),0) as  breakdown_cnt11,coalesce((select count(*) from why_why_f18 where rank!=1 and month=:twelvth),0) as  breakdown_cnt12,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:first),0) as  breakdown_time1,coalesce((select sum(engine_loss) from why_why_f18 where rank!=1 and month=:second),0) as  breakdown_time2,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:third),0) as  breakdown_time3,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:fourth),0) as  breakdown_time4,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:fifth),0) as  breakdown_time5,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:sixth),0) as  breakdown_time6,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:seventh),0) as  breakdown_time7,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:eighth),0) as  breakdown_time8,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:ninth),0) as  breakdown_time9,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:tenth),0) as  breakdown_time10,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:eleventh),0) as  breakdown_time11,coalesce((select SUM(engine_loss) from why_why_f18 where rank!=1 and month=:twelvth),0) as  breakdown_time12 from why_why_f18\n" + 
			"",nativeQuery=true)
	BreakdownTimeMonthwise getAllBrekMonthwiseELBreakdowns(@Param("first")String first,@Param("second")String second,@Param("third")String third,@Param("fourth")String fourth,@Param("fifth")String fifth,@Param("sixth")String sixth,@Param("seventh")String seventh,@Param("eighth")String eighth,@Param("ninth")String ninth,@Param("tenth")String tenth,@Param("eleventh")String eleventh,@Param("twelvth")String twelvth);


}
