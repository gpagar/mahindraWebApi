package com.ganesh.mahindra.repository.tbm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.tbm.GetTbmHistory;

@Repository
public interface TbmHistoryRepository extends JpaRepository<GetTbmHistory, Integer>{

	@Query(value="select t.t_tbm_id,t.machine_id,m.machine_name,m.machine_no,t.location_id,l.location as location_name,t.item_id,i.item_name,t.frequency,t.last_done_date,t.last_done_date as last_date,t.next_done_date as next_date,coalesce((select Concat(MonthName(t.next_done_date),'-' ,YEAR(t.next_done_date))  from t_tbm_machine s where i.item_id=t.item_id and t.t_tbm_id=s.t_tbm_id),Concat(MonthName(t.next_done_date),'-' ,YEAR(t.next_done_date))) as last_done_month,t.last_observation,t.last_ob_date,t.next_done_date,coalesce((select Concat(MonthName((DATE_ADD(t.next_done_date, INTERVAL t.frequency DAY))),'-' ,YEAR((DATE_ADD(t.next_done_date, INTERVAL t.frequency DAY)))) as next_done_month from t_tbm_machine s where i.item_id=t.item_id and t.t_tbm_id=s.t_tbm_id),Concat(MonthName((DATE_ADD(t.next_done_date, INTERVAL t.frequency DAY))),'-' ,YEAR(coalesce(DATE_ADD(t.next_done_date, INTERVAL t.frequency DAY))))) as next_done_month,t.next_observation,t.next_ob_date,\n" + 
			"			t.status,t.del_status from t_tbm_machine t,tbm_machine m,tbm_machine_item i,tbm_machine_location l where t.machine_id=m.machine_id and t.location_id=l.location_id and t.item_id=i.item_id and t.del_status=0 and YEAR(t.next_done_date) between :fromYear and  :toYear ",nativeQuery=true)
	List<GetTbmHistory> getTbmHistory(@Param("fromYear")int fromYear,@Param("toYear") int toYear);

}
