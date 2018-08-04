package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.GetBreakdown;
@Repository
public interface GetBreakdownRepository extends JpaRepository<GetBreakdown, Integer>{

	@Query(value="select m.machin_name as machine_name,w.id,w.machine_no,w.month,w.date,dept,w.cell_circle,w.problem_reported,w.bd_time_loss,w.engine_loss,w.part_status,w.part_desc,w.bd_ms_pt,w.action,w.why1,  w.why2,  w.why3,  w.why4,  w.why5,  w.root_cause,  w.clarification_of_cause,  w.failure_code,  w.counter_measure,  w.category,  w.recur_non_recurr,w.linkage_with,  w.status,  w.ref_no,  w.sap_notif_no,  w.del_status, w.machine_id,w.repaired_by,w.repair_start_time,w.repair_finish_time,w.idea,w.prepared_by,w.mgrorhead,w.subcomm_member,w.prev_occ_date from why_why_f18 w,machin_details m where w.machine_id=m.machin_id and w.id=:id",nativeQuery=true)
	GetBreakdown findById(@Param("id")int id);

}
