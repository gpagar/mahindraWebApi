package com.ganesh.mahindra.model.calibration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TCalibarationRepository extends JpaRepository<TCalibaration, Integer>{

	@Query(value="select id,eq_name,sr_no,card_no,machine_no,line,frequency,last_cal_date,calibration_done_date,status,del_status,m_cal_id,dept_id,inta,intb\r\n" + 
			",file_name from t_mach_eq_calibration where del_status=0 and dept_id=:deptId and id in (SELECT max(c.id) FROM t_mach_eq_calibration c where c.m_cal_id=m_cal_id GROUP BY m_cal_id ) order by id desc\r\n" + 
			"",nativeQuery=true)
	List<TCalibaration> getLastRecordOfEquepmentFroEdit(@Param("deptId") int deptId);

	@Query(value="select\r\n" + 
			"        t.id,\r\n" + 
			"        m.eq_name,\r\n" + 
			"        m.sr_no,\r\n" + 
			"        m.card_no,\r\n" + 
			"        m.machine_no,\r\n" + 
			"        m.line,\r\n" + 
			"        t.frequency,\r\n" + 
			"        t.last_cal_date,\r\n" + 
			"        t.calibration_done_date,\r\n" + 
			"        t.status,\r\n" + 
			"        t.del_status,\r\n" + 
			"        t.m_cal_id,\r\n" + 
			"        t.dept_id,\r\n" + 
			"        t.inta,\r\n" + 
			"        t.intb   ,\r\n" + 
			"        t.file_name \r\n" + 
			"    from\r\n" + 
			"        t_mach_eq_calibration t,\r\n" + 
			"        m_mach_eq_cal m\r\n" + 
			"    where\r\n" + 
			"        t.del_status=0 \r\n" + 
			"        and t.dept_id=:deptId \r\n" + 
			"        and t.calibration_done_date between :fromDate and :toDate and t.m_cal_id=m.id",nativeQuery=true)
	List<TCalibaration> getHistoryOfCablibaration(@Param("deptId")int deptId,
			@Param("fromDate")String fromDate, @Param("toDate")String toDate);

	
	@Transactional
	@Modifying
	@Query("UPDATE TCalibaration SET del_status=1  WHERE id=:id")
	int deleteRecord(@Param("id") int id); 

}
