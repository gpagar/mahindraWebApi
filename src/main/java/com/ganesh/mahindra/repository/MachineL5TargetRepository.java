package com.ganesh.mahindra.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.MachineL5Target;

@Repository
public interface MachineL5TargetRepository extends JpaRepository<MachineL5Target, Integer>{

	@Query(value="select SUM(1) as id,coalesce((select SUM(target_l5) as target from mac_breakdown_target m where ex_int=:deptId and graph_type=:graphType and year=:fromFirst and status=1),0) as year1l_target,\n" + 
			"coalesce((select SUM(target_l5) as target from mac_breakdown_target m where ex_int=:deptId and graph_type=:graphType and year=:fromSecond and status=1),0) as year2l_target,\n" + 
			"coalesce((select SUM(target_l5) as target from mac_breakdown_target m where ex_int=:deptId and graph_type=:graphType and year=:fromThird and status=1),0) as year3l_target,\n" + 
			"coalesce((select SUM(target_l5) as target from mac_breakdown_target m where ex_int=:deptId and graph_type=:graphType and year=:fromFourth and status=1),0) as year4l_target from mac_breakdown_target",nativeQuery=true)
	MachineL5Target getYearlyAssignedL5Target(@Param("graphType") int graphType,@Param("fromFirst") int fromFirst,@Param("fromSecond") int fromSecond,@Param("fromThird")  int fromThird,
			@Param("fromFourth")int fromFourth,@Param("deptId")int deptId);



}
