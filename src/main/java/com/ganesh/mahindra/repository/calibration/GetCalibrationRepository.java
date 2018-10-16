package com.ganesh.mahindra.repository.calibration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.calibration.CalibrationDetails;
import com.ganesh.mahindra.model.calibration.EqCalDetails;
@Repository
public interface GetCalibrationRepository extends JpaRepository<CalibrationDetails, Integer>{

	@Query(value="select\n" + 
			"        t.id,\n" + 
			"        t.eq_name,\n" + 
			"        t.sr_no,\n" + 
			"        t.card_no,\n" + 
			"        t.machine_no,\n" + 
			"        t.line,\n" + 
			"        t.frequency,\n" + 
			"        coalesce((select\n" + 
			"            t_mach_eq_calibration.calibration_done_date  \n" + 
			"        from\n" + 
			"            t_mach_eq_calibration\n" + 
			"        where \n" + 
			"            t_mach_eq_calibration.id = (select max(ct.id) from t_mach_eq_calibration ct where ct.dept_id=:deptId and ct.del_status=0 and ct.m_cal_id=t.id)),\n" + 
			"            (select s.last_cal_date  \n" + 
			"        from\n" + 
			"            m_mach_eq_cal s \n" + 
			"        where\n" + 
			"            s.id=t.id)) as last_cal_date,\n" + 
			"        t.del_status,\n" + 
			"        coalesce((select\n" + 
			"            (DATE_ADD(t_mach_eq_calibration.calibration_done_date,\n" + 
			"            INTERVAL t.frequency DAY))  \n" + 
			"        from\n" + 
			"            t_mach_eq_calibration\n" + 
			"        where \n" + 
			"            t_mach_eq_calibration.id = (select max(ct.id) from t_mach_eq_calibration ct where ct.dept_id=:deptId and ct.del_status=0 and ct.m_cal_id=t.id)), (select (DATE_ADD(t.last_cal_date,\n" + 
			"            INTERVAL t.frequency DAY))  \n" + 
			"        from\n" + 
			"            m_mach_eq_cal s \n" + 
			"        where\n" + 
			"            s.id=t.id)) as next_cal_date \n" + 
			"    from\n" + 
			"        m_mach_eq_cal t \n" + 
			"    where\n" + 
			"        t.del_status=0 \n" + 
			"        and t.dept_id=:deptId",nativeQuery=true)
	List<CalibrationDetails> findCalibrationData(@Param("deptId") int deptId);
	
	@Query(value="select   t.id, t.eq_name,t.sr_no,t.card_no,t.machine_no,t.line,t.frequency,coalesce((select t_mach_eq_calibration.calibration_done_date \n" + 
			"  from  t_mach_eq_calibration    where   t_mach_eq_calibration.id = (select max(ct.id) from t_mach_eq_calibration ct where ct.dept_id=:deptId and ct.del_status=0 and ct.m_cal_id=t.id)), (select s.last_cal_date from m_mach_eq_cal s  where   s.id=t.id)) as last_cal_date, t.del_status, coalesce((select   (DATE_ADD(t_mach_eq_calibration.calibration_done_date,INTERVAL t.frequency DAY))   from t_mach_eq_calibration where  t_mach_eq_calibration.id = (select max(ct.id) from t_mach_eq_calibration ct where ct.dept_id=:deptId and ct.del_status=0 and ct.m_cal_id=t.id)), (select (DATE_ADD(t.last_cal_date,       INTERVAL t.frequency DAY)) from   m_mach_eq_cal s where  s.id=t.id)) as next_cal_date from m_mach_eq_cal t where t.del_status=0 and DATE_FORMAT( coalesce((select   (DATE_ADD(t_mach_eq_calibration.calibration_done_date,INTERVAL t.frequency DAY))   from t_mach_eq_calibration where  t_mach_eq_calibration.id = (select max(ct.id) from t_mach_eq_calibration ct where ct.dept_id=:deptId and ct.del_status=0 and ct.m_cal_id=t.id)), (select (DATE_ADD(t.last_cal_date,       INTERVAL t.frequency DAY)) from   m_mach_eq_cal s where  s.id=t.id)), '%Y-%m')=DATE_FORMAT(CURDATE(), '%Y-%m') and t.dept_id=:deptId",nativeQuery=true)
	List<CalibrationDetails> findCalibrationDataForSchedule(@Param("deptId") int deptId);

}
