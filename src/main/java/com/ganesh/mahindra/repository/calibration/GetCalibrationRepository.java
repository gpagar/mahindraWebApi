package com.ganesh.mahindra.repository.calibration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.calibration.CalibrationDetails;
import com.ganesh.mahindra.model.calibration.EqCalDetails;
@Repository
public interface GetCalibrationRepository extends JpaRepository<CalibrationDetails, Integer>{

	@Query(value="select t.id,t.eq_name,t.sr_no,t.card_no,t.machine_no,t.line,t.frequency,t.last_cal_date,t.del_status,coalesce((select (DATE_ADD(t.last_cal_date, INTERVAL t.frequency DAY))  from m_mach_eq_cal s where s.id=t.id),0) as next_cal_date from m_mach_eq_cal t where t.del_status=0",nativeQuery=true)
	List<CalibrationDetails> findCalibrationData();

}
