package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.DailySearchedTarget;
@Repository
public interface DailySearchedTargetRepository extends JpaRepository<DailySearchedTarget, Integer>{

	@Query(value="select SUM(1) as id,coalesce((select target_l3 as target from mac_breakdown_target m where graph_type=:graphType and year=:yearInt and status=1),0) as yearL3target,coalesce((select target_l5 as target from mac_breakdown_target m where graph_type=:graphType and year=:yearInt and status=1),0) as yearL5target  from mac_breakdown_target",nativeQuery=true)
	DailySearchedTarget getDailyTarget(@Param("graphType")int graphType,@Param("yearInt") int yearInt);

}
