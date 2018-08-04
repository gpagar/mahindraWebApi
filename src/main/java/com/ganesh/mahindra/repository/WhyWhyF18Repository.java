package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.WhyWhyF18;

@Repository
public interface WhyWhyF18Repository extends JpaRepository<WhyWhyF18, Integer>{

	List<WhyWhyF18> findByMachineIdAndDelStatus(int machineId, int i);

	WhyWhyF18 findById(int id);

	@Query(value="Select id,machine_id,machine_no,month,date,dept,rank,cell_circle,problem_reported,bd_time_loss,engine_loss,part_status,part_desc,bd_ms_pt,action,why1,why2,why3,why4,why5,root_cause,clarification_of_cause,failure_code,counter_measure,category,recur_non_recurr,linkage_with,status,ref_no,sap_notif_no,del_status,repaired_by,repair_start_time,repair_finish_time,idea,prepared_by,mgrorhead,subcomm_member,prev_occ_date from why_why_f18 where del_status=0 and month  between :fromMonth and :toMonth order by date",nativeQuery=true)
	List<WhyWhyF18> getAllBreakdownHistory(@Param("fromMonth")String fromMonth,@Param("toMonth") String toMonth);

}
