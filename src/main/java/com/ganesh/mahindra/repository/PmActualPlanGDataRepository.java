package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.PmActualGData;

@Repository
public interface PmActualPlanGDataRepository extends JpaRepository<PmActualGData, Integer>{

	
	@Query(value="select (1) as id, (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=4\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=4\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=4\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as apr,\n" + 
			"        (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=5\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=5\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=5\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as may,\n" + 
			"         (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=6\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=6\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=6\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as june,\n" + 
			"        \n" + 
			"         (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=7\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=7\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=7\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as july,\n" + 
			"        \n" + 
			"         (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=8\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=8\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=8\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as aug,\n" + 
			"        \n" + 
			"         (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=9\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=9\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=9\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as sept,\n" + 
			"        \n" + 
			"         (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=10\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=10\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=10\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as oct,\n" + 
			"        \n" + 
			"         (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=11\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=11\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=11\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as nov\n" + 
			"        ,\n" + 
			"         (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=12\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=12\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=12\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as fdec,\n" + 
			"        \n" + 
			"         (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=1\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=1\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=1\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as jan,\n" + 
			"         (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=2\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=2\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=2\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as feb,\n" + 
			"         (select ((select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            f_month=3\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status1)\n" + 
			"        +\n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId\n" + 
			"        and (\n" + 
			"            s_month=3\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status2)\n" + 
			"        \n" + 
			"        +\n" + 
			"        \n" + 
			"         ( select\n" + 
			"        count(s.machin_id)\n" + 
			"       \n" + 
			"    from\n" + 
			"        maintanance_schedule s,\n" + 
			"        machin_details d \n" + 
			"    where\n" + 
			"        s.machin_id=d.machin_id \n" + 
			"        and s.del_status=0 \n" + 
			"        and d.del_status=0 \n" + 
			"        and s.int_2=:deptId \n" + 
			"        and d.int_1=:deptId \n" + 
			"        and (\n" + 
			"           t_month=3\n" + 
			"           \n" + 
			"        )\n" + 
			"        and  coalesce((select\n" + 
			"            t.int_1 \n" + 
			"        from\n" + 
			"            pa_maintanance t \n" + 
			"        where\n" + 
			"            t.machin_id=s.machin_id \n" + 
			"            and t.del_status=0 limit 1),\n" + 
			"        -1)  >=:status3)\n" + 
			"        \n" + 
			"        )  from dual) as march\n" + 
			"        from dual\n" + 
			"        \n" + 
			"        ",nativeQuery=true)
	PmActualGData getPmPlanActualData(@Param("deptId")int deptId,@Param("status1") int status1,@Param("status2")  int status2,@Param("status3") int status3);

	@Query(value="select  coalesce((select count(*) from dual where :date1  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)),0) + coalesce( (select count(*) from dual where :date2  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +coalesce( (select count(*) from dual where :date3  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +\n" + 
			"		        coalesce( (select count(*) from dual where :date4  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +\n" + 
			"		        coalesce( (select count(*) from dual where :date5  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +\n" + 
			"		        \n" + 
			"		        coalesce( (select count(*) from dual where :date6  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)\n" + 
			"		        +\n" + 
			"		        coalesce( (select count(*) from dual where :date7  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) + coalesce( (select count(*) from dual where :date8  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +\n" + 
			"		        coalesce( (select count(*) from dual where  :date9 IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +\n" + 
			"		        coalesce( (select count(*) from dual where :date10  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +\n" + 
			"		        coalesce( (select count(*) from dual where :date11  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +\n" + 
			"		        coalesce( (select count(*) from dual where :date12  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) + coalesce( (select count(*) from dual where :date13  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +coalesce( (select count(*) from dual where :date14  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +\n" + 
			"		        coalesce( (select count(*) from dual where :date15  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +\n" + 
			"		        coalesce( (select count(*) from dual where :date16  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)\n" + 
			"		        +\n" + 
			"		        coalesce( (select count(*) from dual where :date17  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)\n" + 
			"		        +\n" + 
			"		        coalesce( (select count(*) from dual where :date18  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)\n" + 
			"		        +\n" + 
			"		        coalesce( (select count(*) from dual where :date19  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0) +\n" + 
			"		        coalesce( (select count(*) from dual where :date20  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+\n" + 
			"		        \n" + 
			"		        coalesce( (select count(*) from dual where :date21  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+\n" + 
			"		         coalesce( (select count(*) from dual where :date22  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+\n" + 
			"		         coalesce( (select count(*) from dual where :date23  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+\n" + 
			"		         coalesce( (select count(*) from dual where :date24  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+\n" + 
			"		         coalesce( (select count(*) from dual where :date25  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+\n" + 
			"		         coalesce( (select count(*) from dual where :date26  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+ coalesce( (select count(*) from dual where :date27  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+\n" + 
			"		         coalesce( (select count(*) from dual where :date28  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+\n" + 
			"		         coalesce( (select count(*) from dual where :date29  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+\n" + 
			"		         coalesce( (select count(*) from dual where :date30  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id and m.int_1=:deptId\n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)+\n" + 
			"		         coalesce( (select count(*) from dual where :date31  IN (select\n" + 
			"		       \n" + 
			"		        coalesce((select\n" + 
			"		            (DATE_ADD(t.next_done_date,\n" + 
			"		            INTERVAL i.frequency DAY))  \n" + 
			"		        from\n" + 
			"		            t_tbm_machine t \n" + 
			"		        where\n" + 
			"		            i.item_id=t.item_id \n" + 
			"		        ORDER BY\n" + 
			"		            t.t_tbm_id DESC LIMIT 1),\n" + 
			"		        (DATE_ADD(i.last_date,\n" + 
			"		        INTERVAL i.frequency DAY))) as next_date\n" + 
			"		    from\n" + 
			"		        tbm_machine m,\n" + 
			"		        tbm_machine_item i,\n" + 
			"		        tbm_machine_location l \n" + 
			"		    where\n" + 
			"		        m.machine_id=l.machine_id \n" + 
			"		        and  l.location_id=i.location_id \n" + 
			"		    order by\n" + 
			"		        l.location_id)) ,0)\n" + 
			"		        \n" + 
			"		        from dual",nativeQuery=true)
	int findTbmPlan(@Param("date1")String date1,@Param("date2") String date2,@Param("date3") String date3,@Param("date4") String date4,@Param("date5") String date5,
			@Param("date6")String date6,@Param("date7") String date7,@Param("date8") String date8,@Param("date9") String date9,@Param("date10") String date10,@Param("date11") String date11,
			@Param("date12")String date12, @Param("date13")String date13,@Param("date14") String date14,@Param("date15") String date15,@Param("date16") String date16,@Param("date17") String date17,
			@Param("date18")String date18,@Param("date19") String date19,@Param("date20") String date20,@Param("date21") String date21,@Param("date22") String date22,@Param("date23") String date23,
			@Param("date24")String date24,@Param("date25") String date25,@Param("date26") String date26,@Param("date27") String date27,@Param("date28") String date28, @Param("date29")String date29,
			@Param("date30")String date30,@Param("date31")String date31,@Param("deptId")int deptId);

	
	        
	        
}
