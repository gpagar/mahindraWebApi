package com.ganesh.mahindra.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.mahindra.model.PmPlan;

public interface PmPlanRepository extends JpaRepository<PmPlan, Serializable>{

	@Query(value="select s.maint_id,s.machin_id,d.machin_name,d.machin_no as machine_no,d.line,s.f_status,s.s_status,d.type,s.f_month,s.f_week,s.s_month,s.s_week,s.t_month,s.t_week,s.del_status,s.int_1,s.int_2,s.string1,s.string2,s.t_status,coalesce((select t.int_1 from pa_maintanance t where t.machin_id=s.machin_id and t.del_status=0 limit 1),-1) as status from maintanance_schedule s,machin_details d where s.machin_id=d.machin_id and s.del_status=0 and d.del_status=0 and s.int_2=:deptId and (f_month=:month or s_month=:month or t_month=:month)",nativeQuery=true)
	List<PmPlan> findByCurrentMonth(@Param("month")int month,@Param("deptId")int deptId);

	@Query(value="select s.maint_id,s.machin_id,d.machin_name,d.machin_no as machine_no,d.line,s.f_status,s.s_status,d.type,s.f_month,s.f_week,s.s_month,s.s_week,s.t_month,s.t_week,s.del_status,s.int_1,s.int_2,s.string1,s.string2,s.t_status,coalesce((select t.int_1 from pa_maintanance t where t.machin_id=s.machin_id and t.del_status=0 limit 1),-1) as status from maintanance_schedule s,machin_details d where s.machin_id=d.machin_id and s.del_status=0 and d.del_status=0 and s.machin_id=:machineId",nativeQuery=true)
	PmPlan findByMachinId(@Param("machineId")int machineId);

}
