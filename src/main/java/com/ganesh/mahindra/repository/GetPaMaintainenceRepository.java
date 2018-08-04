package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.GetPMData;
import com.ganesh.mahindra.model.GetPaMaintainence;
@Repository
public interface GetPaMaintainenceRepository extends JpaRepository<GetPaMaintainence, Integer>{

	@Query(value="select\n" + 
			"  p.pa_maint_id,\n" + 
			"  p.type,\n" + 
			"  p.machin_id,d.machin_name,d.machin_no,\n" + 
			"  p.activity_id,a.activity_name,\n" + 
			"  p.item_id,i.item_name,\n" + 
			"  p.check_point_id,ch.check_point_name,\n" + 
			"  p.method,\n" + 
			"  p.required_value,"+
			"  p.date1,\n" + 
			"  p.date1_observation,\n" + 
			"  p.date1_photo,\n" + 
			"  p.date2,\n" + 
			"  p.date2_observation,\n" + 
			"  p.date2_photo,\n" + 
			"  p.date3,\n" + 
			"  p.date3_observation,\n" + 
			"  p.date3_photo,\n" + 
			"  p.status,\n" + 
			"  p.del_status,\n" + 
			"  p.int_1,\n" + 
			"  p.int_2,\n" + 
			"  p.string1,\n" + 
			"  p.string2,\n" + 
			"  p.remark from pa_maintanance p,machin_details d,machin_activity a,item_details i,check_point ch  where \n" + 
			"  p.check_point_id=ch.check_point_id And p.item_id=i.item_id And p.activity_id=a.activity_id And p.machin_id=d.machin_id And p.del_status=0 and p.machin_id=:machinId",nativeQuery=true)
	List<GetPaMaintainence> getPmMaintainenceList(@Param("machinId")int machinId);

}
