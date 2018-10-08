package com.ganesh.mahindra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.ganesh.mahindra.model.Info;
import com.ganesh.mahindra.model.TCalibration;
import com.ganesh.mahindra.model.calibration.CalibrationDetails;
import com.ganesh.mahindra.model.calibration.EqCalDetails;
import com.ganesh.mahindra.model.calibration.TCalibaration;
import com.ganesh.mahindra.model.calibration.TCalibarationRepository;
import com.ganesh.mahindra.repository.calibration.CalibrationRepository;
import com.ganesh.mahindra.repository.calibration.GetCalibrationRepository;
import com.ganesh.mahindra.repository.calibration.MachineEqCalRepository;

@RestController
public class CalibrationController {

	@Autowired
	MachineEqCalRepository machineEqCalRepository;
	
	@Autowired
	GetCalibrationRepository getCalibrationRepository;
	
	@Autowired
	CalibrationRepository calibrationRepository;
	
	@Autowired
	TCalibarationRepository tCalibarationRepository;
	
	@RequestMapping(value = { "/insertMachineEqCal" }, method = RequestMethod.POST)
	@ResponseBody
	public List<EqCalDetails> insertMachineEqCal(@RequestBody List<EqCalDetails> dataLists) 
	{
		List<EqCalDetails> eqCalDetailsList=new ArrayList<EqCalDetails>();
		EqCalDetails dataresp=null;
		for(EqCalDetails data:dataLists)
		{	
			 dataresp=machineEqCalRepository.save(data);
		     eqCalDetailsList.add(dataresp);
		}
		
		return eqCalDetailsList;
	}
	
	@RequestMapping(value = { "/getAllEquipments" }, method = RequestMethod.POST)
	@ResponseBody
	public List<EqCalDetails> getAllEquipments(@RequestParam("deptId")int deptId) 
	{
		List<EqCalDetails> eqCalDetailsList=machineEqCalRepository.findByDelStatusAndDeptId(0,deptId);
	    return eqCalDetailsList;
	}
	@RequestMapping(value = { "/getEquipment" }, method = RequestMethod.POST)
	@ResponseBody
	public EqCalDetails getEquipment(@RequestParam("id") int id) 
	{
		EqCalDetails eqCalDetails=null;
		try {
			eqCalDetails=machineEqCalRepository.findByIdAndDelStatus(id,0);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return eqCalDetails;
	}
	@RequestMapping(value = { "/insertCalibration" }, method = RequestMethod.POST)
	@ResponseBody
	public TCalibration insertCalibration(@RequestBody TCalibration calibration) 
	{   
		TCalibration dataresp=null; 
	 try {
		 dataresp=calibrationRepository.save(calibration);
		
	  }catch (Exception e) {  
	   e.printStackTrace();
	  }
		
		return dataresp;
	}
	
	@RequestMapping(value = { "/getCalibrationData" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CalibrationDetails> getCalibrationData(@RequestParam("deptId") int deptId) 
	{
		List<CalibrationDetails> eqCalDetailsList=getCalibrationRepository.findCalibrationData(deptId);
		
		
		return eqCalDetailsList;
	}
	
	@RequestMapping(value = { "/saveTCalibaratoin" }, method = RequestMethod.POST)
	@ResponseBody
	public TCalibaration saveTCalibaratoin(@RequestBody TCalibaration tCalibaration) 
	{
		TCalibaration save=tCalibarationRepository.save(tCalibaration);
		
		/*select max(id),eq_name,sr_no,card_no,machine_no,line,frequency,last_cal_date,calibration_done_date,status,del_status,m_cal_id,dept_id,inta,intb,file_name from t_mach_eq_calibration where del_status=0 group by m_cal_id*/ 
		return save;
	}
	
	@RequestMapping(value = { "/getLastRecordOfEquepmentFroEdit" }, method = RequestMethod.POST)
	@ResponseBody
	public List<TCalibaration> getLastRecordOfEquepmentFroEdit(@RequestParam("deptId") int deptId) 
	{
		
		List<TCalibaration> list = new ArrayList<TCalibaration>();
		try {
			
		 list=tCalibarationRepository.getLastRecordOfEquepmentFroEdit(deptId);
		 
		}catch (Exception e) {
			e.printStackTrace();
		}
		 
		return list;
	}
	
	@RequestMapping(value = { "/getHistoryOfCablibaration" }, method = RequestMethod.POST)
	@ResponseBody
	public List<TCalibaration> getHistoryOfCablibaration(@RequestParam("deptId") int deptId,
			@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) 
	{
		
		List<TCalibaration> list = new ArrayList<TCalibaration>();
		try {
			
		 list=tCalibarationRepository.getHistoryOfCablibaration(deptId,fromDate,toDate);
		 
		}catch (Exception e) {
			e.printStackTrace();
		}
		 
		return list;
	}
	
	@RequestMapping(value = { "/deleteCalibarationRecord" }, method = RequestMethod.POST)
	@ResponseBody
	public Info deleteCalibarationRecord(@RequestParam("id") int id ) 
	{
		
		 
		Info info = new Info();
		try {
			
		 int delete = tCalibarationRepository.deleteRecord(id);
		 
		 if(delete==1) {
			 info.setError(false);
			 info.setMessage("deleted");
		 }
		 else {
			 info.setError(true);
			 info.setMessage("failed to deleted");
		 }
		 
		}catch (Exception e) {
			e.printStackTrace();
		}
		 
		return info;
	}
	
	
	
}



