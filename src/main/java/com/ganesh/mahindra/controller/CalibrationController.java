package com.ganesh.mahindra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.ganesh.mahindra.model.TCalibration;
import com.ganesh.mahindra.model.calibration.CalibrationDetails;
import com.ganesh.mahindra.model.calibration.EqCalDetails;
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
	
	@RequestMapping(value = { "/getCalibrationData" }, method = RequestMethod.GET)
	@ResponseBody
	public List<CalibrationDetails> getCalibrationData() 
	{
		List<CalibrationDetails> eqCalDetailsList=getCalibrationRepository.findCalibrationData();
		
		
		return eqCalDetailsList;
	}
}
