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

import com.ganesh.mahindra.model.cbm.CbmEarthingResistance;
import com.ganesh.mahindra.model.cbm.CbmSchedule;
import com.ganesh.mahindra.model.cbm.CbmSpindleClampingForce;
import com.ganesh.mahindra.model.cbm.CbmSpindleTemper;
import com.ganesh.mahindra.repository.CbmEarthingResistanceRepository;
import com.ganesh.mahindra.repository.CbmScheduleRepository;
import com.ganesh.mahindra.repository.CbmSpindleClampingForceRepository;
import com.ganesh.mahindra.repository.CbmSpindleTemperRepository;

@RestController
public class CbmSpindleTemperRestController {
	
	@Autowired
	CbmSpindleTemperRepository cbmSpindleTemperRepository;
	
	@Autowired
	CbmScheduleRepository cbmScheduleRepository;
	
	@Autowired
	CbmSpindleClampingForceRepository cbmSpindleClampingForceRepository;
	
	@Autowired
	CbmEarthingResistanceRepository cbmEarthingResistanceRepository;
	
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
	
	
	@RequestMapping(value = { "/saveCbmSpindleClimpingForce" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSpindleClampingForce> saveCbmSpindleClimpingForce(@RequestBody List<CbmSpindleClampingForce> cbmSpindleClampingForceList) 
	{
		List<CbmSpindleClampingForce> save = new ArrayList<CbmSpindleClampingForce>();
		
		try {
			
			 save= cbmSpindleClampingForceRepository.save(cbmSpindleClampingForceList);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return save;
	}
	
	@RequestMapping(value = { "/getCbmSpindleClimpingForce" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSpindleClampingForce> getCbmSpindleClimpingForce(@RequestParam("deptId") int deptId) 
	{
		List<CbmSpindleClampingForce> list = new ArrayList<CbmSpindleClampingForce>();
		
		try {
			
			list= cbmSpindleClampingForceRepository.findByStatusAndDeptId(0,deptId);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = { "/getCbmScheduleListForSpindleClimpingForce" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSchedule> getCbmScheduleListForSpindleClimpingForce(@RequestParam("deptId")int deptId) 
	{
		List<CbmSchedule> cbmScheduleList = new ArrayList<>();
		
		try {
			
			cbmScheduleList=cbmScheduleRepository.getCbmScheduleListForSpindleClimpingForce(deptId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return cbmScheduleList;
	}
	
	@RequestMapping(value = { "/saveCbmEarthingResistance" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmEarthingResistance> saveCbmEarthingResistance(@RequestBody List<CbmEarthingResistance> cbmEarthingResistanceList) 
	{
		List<CbmEarthingResistance> save = new ArrayList<CbmEarthingResistance>();
		
		try {
			
			 save= cbmEarthingResistanceRepository.save(cbmEarthingResistanceList);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return save;
	}
	
	@RequestMapping(value = { "/getCbmEarthingResistance" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmEarthingResistance> getCbmEarthingResistance(@RequestParam("deptId") int deptId) 
	{
		List<CbmEarthingResistance> list = new ArrayList<CbmEarthingResistance>();
		
		try {
			
			list= cbmEarthingResistanceRepository.findByStatusAndDeptId(0,deptId);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = { "/getCbmScheduleListForEarthingResistance" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSchedule> getCbmScheduleListForEarthingResistance(@RequestParam("deptId")int deptId) 
	{
		List<CbmSchedule> cbmScheduleList = new ArrayList<>();
		
		try {
			
			cbmScheduleList=cbmScheduleRepository.getCbmScheduleListForEarthingResistance(deptId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return cbmScheduleList;
	}

}
