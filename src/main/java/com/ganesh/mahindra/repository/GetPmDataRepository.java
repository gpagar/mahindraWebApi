package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.GetPMData;

@Repository
public interface GetPmDataRepository extends JpaRepository<GetPMData, Integer>{

	@Query(value="select machin_activity.activity_id,machin_activity.machin_id,machin_activity.activity_name,coalesce(item_details.item_id,0)as item_id,coalesce(item_details.item_name,0) as item_name,check_point.check_point_id,check_point.check_point_name from machin_activity,item_details,check_point where (machin_activity.machin_id=:machinId and machin_activity.del_status=0) and item_details.activity_id=machin_activity.activity_id And check_point.item_id=item_details.item_id",nativeQuery=true)
	List<GetPMData> getPMList(@Param("machinId")int machineId);

}
