package com.ganesh.mahindra.repository.tbm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.tbm.TbmData;

@Repository
public interface TbmDataRepository extends JpaRepository<TbmData, Integer>{

	@Query(value="select m.machine_id,m.machine_name,m.machine_no,coalesce((l.location_id),0)as location_id,coalesce((l.location),0)as location_name,coalesce((i.item_id),0)as item_id ,coalesce((i.item_name),0)as item_name,coalesce((i.frequency),0)as frequency,(0) as t_tbm_id," + 
			"coalesce((select t.next_done_date from t_tbm_machine t where i.item_id=t.item_id ORDER BY t.t_tbm_id DESC LIMIT 1),(i.last_date))as last_date,\n" + 
			"coalesce((select Concat(MonthName(t.next_done_date),'-' ,YEAR(t.next_done_date))  from t_tbm_machine t where i.item_id=t.item_id ORDER BY t.t_tbm_id DESC LIMIT 1),Concat(MonthName(i.last_date),'-' ,YEAR(i.last_date))) as last_done_month, \n" + 
			"coalesce((select (DATE_ADD(t.next_done_date, INTERVAL i.frequency DAY))  from t_tbm_machine t where i.item_id=t.item_id ORDER BY t.t_tbm_id DESC LIMIT 1),(DATE_ADD(i.last_date, INTERVAL i.frequency DAY))) as next_date,coalesce((select Concat(MonthName((DATE_ADD(t.next_done_date, INTERVAL i.frequency DAY))),'-' ,YEAR((DATE_ADD(t.next_done_date, INTERVAL i.frequency DAY)))) as next_done_month from t_tbm_machine t where i.item_id=t.item_id ORDER BY t.t_tbm_id DESC LIMIT 1),Concat(MonthName((DATE_ADD(i.last_date, INTERVAL i.frequency DAY))),'-' ,YEAR(coalesce(DATE_ADD(i.last_date, INTERVAL i.frequency DAY))))) as next_done_month,coalesce((select t.last_done_date from t_tbm_machine t where i.item_id=t.item_id ORDER BY t.t_tbm_id DESC LIMIT 1),0) as last_done_date,coalesce((select t.last_observation from t_tbm_machine t where i.item_id=t.item_id ORDER BY t.t_tbm_id DESC LIMIT 1),0) as last_observation,coalesce((select t.last_ob_date from t_tbm_machine t where i.item_id=t.item_id ORDER BY t.t_tbm_id DESC LIMIT 1),0) as last_ob_date,coalesce((select t.next_done_date from t_tbm_machine t where i.item_id=t.item_id ORDER BY t.t_tbm_id DESC LIMIT 1),0) as next_done_date,coalesce((select t.next_observation from t_tbm_machine t where i.item_id=t.item_id ORDER BY t.t_tbm_id DESC LIMIT 1),0) as next_observation,coalesce((select t.next_ob_date from t_tbm_machine  t where i.item_id=t.item_id ORDER BY t.t_tbm_id DESC LIMIT 1),0) as next_ob_date   from tbm_machine m,tbm_machine_item i,tbm_machine_location l where m.machine_id=l.machine_id and m.machine_id=:machineId and  l.location_id=i.location_id order by l.location_id",nativeQuery=true)
	List<TbmData> getTbmDataByMachineId(@Param("machineId")int machineId);
	

}