package com.ganesh.mahindra.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.GetWhyWhyF18;

@Repository
public interface GetBreakdownDataRepository extends JpaRepository<GetWhyWhyF18, Serializable>{

	@Query(value="select w.id,w.machine_no,m.machin_name as machine_name,w.month,w.date,w.dept,w.cell_circle,w.problem_reported,w.bd_time_loss,w.engine_loss,w.part_status,w.part_desc,w.bd_ms_pt,w.action,w.why1,w.why2,w.why3,w.why4,w.why5,w.root_cause,w.clarification_of_cause,w.failure_code,w.counter_measure,w.category,w.recur_non_recurr,w.linkage_with,w.status,w.ref_no,w.sap_notif_no,w.del_status,w.machine_id,w.repaired_by,w.repair_start_time,\n" + 
			"  w.repair_finish_time,w.idea,w.prepared_by,w.mgrorhead,w.subcomm_member,w.breakdown_phenomenon,w.preven_reccur_id,w.preven_reccur,w.hdp,w.prev_occ_date,w.is_hdp,w.systemclassif,\n" + 
			"  w.rank,w.machine_type from why_why_f18 w,machin_details m where m.machin_id=w.machine_id and w.machine_id IN(:machineIdList) and w.del_status=:delStatus",nativeQuery=true)
	List<GetWhyWhyF18> findByMachineIdInAndDelStatus(@Param("machineIdList")List<String> machineIdList,@Param("delStatus") int delStatus);

	@Query(value="select w.id,w.machine_no,m.machin_name as machine_name,w.month,w.date,w.dept,w.cell_circle,w.problem_reported,w.bd_time_loss,w.engine_loss,w.part_status,w.part_desc,w.bd_ms_pt,w.action,w.why1,w.why2,w.why3,w.why4,w.why5,w.root_cause,w.clarification_of_cause,w.failure_code,w.counter_measure,w.category,w.recur_non_recurr,w.linkage_with,w.status,w.ref_no,w.sap_notif_no,w.del_status,w.machine_id,w.repaired_by,w.repair_start_time,\n" + 
			"  w.repair_finish_time,w.idea,w.prepared_by,w.mgrorhead,w.subcomm_member,w.breakdown_phenomenon,w.preven_reccur_id,w.preven_reccur,w.hdp,w.prev_occ_date,w.is_hdp,w.systemclassif,\n" + 
			"  w.rank,w.machine_type from why_why_f18 w,machin_details m where m.machin_id=w.machine_id and w.bd_ms_pt=:bdMsPt and w.del_status=:delStatus",nativeQuery=true)
	List<GetWhyWhyF18> findByBdMsPTAndDelStatus(@Param("bdMsPt")String bdMsPt,@Param("delStatus") int delStatus);

	@Query(value="select w.id,w.machine_no,m.machin_name as machine_name,w.month,w.date,w.dept,w.cell_circle,w.problem_reported,w.bd_time_loss,w.engine_loss,w.part_status,w.part_desc,w.bd_ms_pt,w.action,w.why1,w.why2,w.why3,w.why4,w.why5,w.root_cause,w.clarification_of_cause,w.failure_code,w.counter_measure,w.category,w.recur_non_recurr,w.linkage_with,w.status,w.ref_no,w.sap_notif_no,w.del_status,w.machine_id,w.repaired_by,w.repair_start_time,\n" + 
			"  w.repair_finish_time,w.idea,w.prepared_by,w.mgrorhead,w.subcomm_member,w.breakdown_phenomenon,w.preven_reccur_id,w.preven_reccur,w.hdp,w.prev_occ_date,w.is_hdp,w.systemclassif,\n" + 
			"  w.rank,w.machine_type from why_why_f18 w,machin_details m where m.machin_id=w.machine_id and w.month=:month and w.del_status=:delStatus",nativeQuery=true)
	List<GetWhyWhyF18> findByMonthAndDelStatus(@Param("month")String month,@Param("delStatus") int delStatus);

	@Query(value="select w.id,w.machine_no,m.machin_name as machine_name,w.month,w.date,w.dept,w.cell_circle,w.problem_reported,w.bd_time_loss,w.engine_loss,w.part_status,w.part_desc,w.bd_ms_pt,w.action,w.why1,w.why2,w.why3,w.why4,w.why5,w.root_cause,w.clarification_of_cause,w.failure_code,w.counter_measure,w.category,w.recur_non_recurr,w.linkage_with,w.status,w.ref_no,w.sap_notif_no,w.del_status,w.machine_id,w.repaired_by,w.repair_start_time,\n" + 
			"  w.repair_finish_time,w.idea,w.prepared_by,w.mgrorhead,w.subcomm_member,w.breakdown_phenomenon,w.preven_reccur_id,w.preven_reccur,w.hdp,w.prev_occ_date,w.is_hdp,w.systemclassif,\n" + 
			"  w.rank,w.machine_type from why_why_f18 w,machin_details m where m.machin_id=w.machine_id and w.machine_id IN(:machineIdList) and w.bd_ms_pt=:bdMsPt and w.del_status=:delStatus",nativeQuery=true)
	List<GetWhyWhyF18> findByMachineIdInAndBdMsPTAndDelStatus(@Param("machineIdList")List<String> machineIdList,@Param("bdMsPt") String bdMsPt,@Param("delStatus") int delStatus);

	@Query(value="select w.id,w.machine_no,m.machin_name as machine_name,w.month,w.date,w.dept,w.cell_circle,w.problem_reported,w.bd_time_loss,w.engine_loss,w.part_status,w.part_desc,w.bd_ms_pt,w.action,w.why1,w.why2,w.why3,w.why4,w.why5,w.root_cause,w.clarification_of_cause,w.failure_code,w.counter_measure,w.category,w.recur_non_recurr,w.linkage_with,w.status,w.ref_no,w.sap_notif_no,w.del_status,w.machine_id,w.repaired_by,w.repair_start_time,\n" + 
			"  w.repair_finish_time,w.idea,w.prepared_by,w.mgrorhead,w.subcomm_member,w.breakdown_phenomenon,w.preven_reccur_id,w.preven_reccur,w.hdp,w.prev_occ_date,w.is_hdp,w.systemclassif,\n" + 
			"  w.rank,w.machine_type from why_why_f18 w,machin_details m where m.machin_id=w.machine_id and w.month=:month and w.bd_ms_pt=:bdMsPt and w.del_status=:delStatus",nativeQuery=true)
	List<GetWhyWhyF18> findByBdMsPTAndMonthAndDelStatus(@Param("bdMsPt")String bdMsPt,@Param("month") String month,@Param("delStatus") int delStatus);

	@Query(value="select w.id,w.machine_no,m.machin_name as machine_name,w.month,w.date,w.dept,w.cell_circle,w.problem_reported,w.bd_time_loss,w.engine_loss,w.part_status,w.part_desc,w.bd_ms_pt,w.action,w.why1,w.why2,w.why3,w.why4,w.why5,w.root_cause,w.clarification_of_cause,w.failure_code,w.counter_measure,w.category,w.recur_non_recurr,w.linkage_with,w.status,w.ref_no,w.sap_notif_no,w.del_status,w.machine_id,w.repaired_by,w.repair_start_time,\n" + 
			"  w.repair_finish_time,w.idea,w.prepared_by,w.mgrorhead,w.subcomm_member,w.breakdown_phenomenon,w.preven_reccur_id,w.preven_reccur,w.hdp,w.prev_occ_date,w.is_hdp,w.systemclassif,\n" + 
			"  w.rank,w.machine_type from why_why_f18 w,machin_details m where m.machin_id=w.machine_id and w.machine_id IN(:machineIdList) and w.month=:month and w.del_status=:delStatus",nativeQuery=true)
	List<GetWhyWhyF18> findByMachineIdInAndMonthDelStatus(@Param("machineIdList")List<String> machineIdList,@Param("month") String month,@Param("delStatus") int delStatus);

	@Query(value="select w.id,w.machine_no,m.machin_name as machine_name,w.month,w.date,w.dept,w.cell_circle,w.problem_reported,w.bd_time_loss,w.engine_loss,w.part_status,w.part_desc,w.bd_ms_pt,w.action,w.why1,w.why2,w.why3,w.why4,w.why5,w.root_cause,w.clarification_of_cause,w.failure_code,w.counter_measure,w.category,w.recur_non_recurr,w.linkage_with,w.status,w.ref_no,w.sap_notif_no,w.del_status,w.machine_id,w.repaired_by,w.repair_start_time,\n" + 
			"  w.repair_finish_time,w.idea,w.prepared_by,w.mgrorhead,w.subcomm_member,w.breakdown_phenomenon,w.preven_reccur_id,w.preven_reccur,w.hdp,w.prev_occ_date,w.is_hdp,w.systemclassif,\n" + 
			"  w.rank,w.machine_type from why_why_f18 w,machin_details m where m.machin_id=w.machine_id and w.machine_id IN(:machineIdList) and w.month=:month and w.bd_ms_pt=:bdMsPt and w.del_status=:delStatus",nativeQuery=true)
	List<GetWhyWhyF18> findByMachineIdInAndBdMsPtAndMonthDelStatus(@Param("machineIdList")List<String> machineIdList,@Param("bdMsPt") String bdMsPt,@Param("month")String month, @Param("delStatus")int delStatus);

}
