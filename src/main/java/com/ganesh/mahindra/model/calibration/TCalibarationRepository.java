package com.ganesh.mahindra.model.calibration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TCalibarationRepository extends JpaRepository<TCalibaration, Integer>{

	@Query(value="select max(id) as id,eq_name,sr_no,card_no,machine_no,line,frequency,last_cal_date,calibration_done_date,status,del_status,m_cal_id,dept_id,inta,intb\r\n" + 
			",file_name from t_mach_eq_calibration where del_status=0 and dept_id=:deptId group by m_cal_id",nativeQuery=true)
	List<TCalibaration> getLastRecordOfEquepmentFroEdit(@Param("deptId") int deptId);

	@Query(value="select id,eq_name,sr_no,card_no,machine_no,line,frequency,last_cal_date,calibration_done_date,status,del_status,m_cal_id,dept_id,inta,intb \r\n" + 
			",file_name from t_mach_eq_calibration where del_status=0 and dept_id=:deptId and calibration_done_date between :fromDate and :toDate",nativeQuery=true)
	List<TCalibaration> getHistoryOfCablibaration(@Param("deptId")int deptId,
			@Param("fromDate")String fromDate, @Param("toDate")String toDate);

	
	@Transactional
	@Modifying
	@Query("UPDATE TCalibaration SET del_status=1  WHERE id=:id")
	int deleteRecord(@Param("id") int id); 

}
