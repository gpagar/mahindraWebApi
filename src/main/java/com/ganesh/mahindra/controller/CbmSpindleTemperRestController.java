package com.ganesh.mahindra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.mahindra.model.cbm.CbmSchedule;
import com.ganesh.mahindra.model.cbm.CbmSpindleTemper;
import com.ganesh.mahindra.repository.CbmScheduleRepository;
import com.ganesh.mahindra.repository.CbmSpindleTemperRepository;

@RestController
public class CbmSpindleTemperRestController {
	
	@Autowired
	CbmSpindleTemperRepository cbmSpindleTemperRepository;
	
	@Autowired
	CbmScheduleRepository cbmScheduleRepository;
	
	@RequestMapping(value = { "/saveCbmSpindleTemper" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSpindleTemper> saveCbmSpindleTemper(@RequestBody List<CbmSpindleTemper> CbmSpindleTemperList) 
	{
		List<CbmSpindleTemper> save = new ArrayList<CbmSpindleTemper>();
		
		try {
			
			 save= cbmSpindleTemperRepository.save(CbmSpindleTemperList);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return save;
	}
	
	@RequestMapping(value = { "/getCbmSpindleTemper" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSpindleTemper> saveCbmSpindleTemper(@RequestParam("deptId") int deptId) 
	{
		List<CbmSpindleTemper> list = new ArrayList<CbmSpindleTemper>();
		
		try {
			
			list= cbmSpindleTemperRepository.findByStatusAndDeptId(0,deptId);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	 
	@RequestMapping(value = { "/getCbmScheduleListForSpindleTemper" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSchedule> getCbmScheduleListForSpindleTemper(@RequestParam("deptId")int deptId) 
	{
		List<CbmSchedule> cbmScheduleList = new ArrayList<>();
		
		try {
			
			cbmScheduleList=cbmScheduleRepository.getCbmScheduleListForSpindleTemper(deptId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return cbmScheduleList;
	}

}
