package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.PmTargetGData;

@Repository
public interface PmTargetPlanGDataRepository extends JpaRepository<PmTargetGData, Integer>{

	@Query(value=" select (1) as id, ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=4\n" + 
			"            or s_month=4\n" + 
			"            or t_month=4\n" + 
			"        )) as apr_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=5\n" + 
			"            or s_month=5\n" + 
			"            or t_month=5\n" + 
			"        )) as may_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=6\n" + 
			"            or s_month=6\n" + 
			"            or t_month=6\n" + 
			"        )) as june_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=7\n" + 
			"            or s_month=7\n" + 
			"            or t_month=7\n" + 
			"        )) as july_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=8\n" + 
			"            or s_month=8\n" + 
			"            or t_month=8\n" + 
			"        )) as aug_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=9\n" + 
			"            or s_month=9\n" + 
			"            or t_month=9\n" + 
			"        )) as sept_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=10\n" + 
			"            or s_month=10\n" + 
			"            or t_month=10\n" + 
			"        )) as oct_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=11\n" + 
			"            or s_month=11\n" + 
			"            or t_month=11\n" + 
			"        )) as nov_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=12\n" + 
			"            or s_month=12\n" + 
			"            or t_month=12\n" + 
			"        )) as dec_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=1\n" + 
			"            or s_month=1\n" + 
			"            or t_month=1\n" + 
			"        )) as jan_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=2\n" + 
			"            or s_month=2\n" + 
			"            or t_month=2\n" + 
			"        )) as feb_target,\n" + 
			"        ( select\n" + 
			"        count(s.maint_id)\n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId\n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=3\n" + 
			"            or s_month=3\n" + 
			"            or t_month=3\n" + 
			"        )) as march_target\n" + 
			"        from dual\n" + 
			"\n" + 
			"",nativeQuery=true)
	PmTargetGData getPmPlanTargetData(@Param("deptId") int deptId);

	@Query(value="select 1 as id, (select count(*) from m_cbm_schedule where scf_q1=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q2=4 and dept_id=:deptId)+\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=4 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=4 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=4 and dept_id=:deptId) as apr_target,\n" + 
			"(select count(*) from m_cbm_schedule where scf_q1=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q2=5 and dept_id=:deptId)+\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=5 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=5 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=5 and dept_id=:deptId) as may_target,\n" + 
			"(select count(*) from m_cbm_schedule where scf_q1=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q2=6 and dept_id=:deptId)+\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=6 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=6 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=6 and dept_id=:deptId) as june_target,\n" + 
			"(select count(*) from m_cbm_schedule where scf_q1=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q2=7 and dept_id=:deptId)+\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=7 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=7 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=7 and dept_id=:deptId) as july_target,\n" + 
			"(select count(*) from m_cbm_schedule where scf_q1=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q2=8 and dept_id=:deptId)+\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=8 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=8 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=8 and dept_id=:deptId) as aug_target,\n" + 
			"(select count(*) from m_cbm_schedule where scf_q1=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q2=9 and dept_id=:deptId)+\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=9 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=9 and dept_id=:deptId) as sept_target,(select count(*) from m_cbm_schedule where scf_q1=9 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q2=9 and dept_id=:deptId)+\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=10 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=10 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=10 and dept_id=:deptId) as oct_target,\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=11 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=11 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=11 and dept_id=:deptId) as  nov_target,\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=12 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=12 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=12 and dept_id=:deptId) as dec_target,\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=1 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=1 and dept_id=:deptId) as jan_target,\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=2 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=1 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=2 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=2 and dept_id=:deptId) as feb_target,\n" + 
			"(select count(*) from m_cbm_schedule where scf_q3=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where scf_q4=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where bbt_h2=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q1=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where sv_q3=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q1=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where stc_q3=3 and dept_id=:deptId) +(select count(*) from m_cbm_schedule where tg=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h1=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where er_h2=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h1=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where ahm_h2=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h1=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where vm_h2=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h1=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where mmc_h2=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where hpp=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where oda=3 and dept_id=:deptId)+(select count(*) from m_cbm_schedule where pa=3 and dept_id=:deptId) as march_target\n" + 
			"from dual",nativeQuery=true)
	PmTargetGData getCbmTargetData(@Param("deptId")int deptId);

}
