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
import com.ganesh.mahindra.model.cbm.CbmMagazineChain;
import com.ganesh.mahindra.model.cbm.CbmSchedule;
import com.ganesh.mahindra.model.cbm.CbmSpindleClampingForce;
import com.ganesh.mahindra.model.cbm.CbmSpindleTemper;
import com.ganesh.mahindra.model.cbm.CbmYearEnd;
import com.ganesh.mahindra.repository.CbmEarthingResistanceRepository;
import com.ganesh.mahindra.repository.CbmMagazineChainRepository;
import com.ganesh.mahindra.repository.CbmScheduleRepository;
import com.ganesh.mahindra.repository.CbmSpindleClampingForceRepository;
import com.ganesh.mahindra.repository.CbmSpindleTemperRepository;
import com.ganesh.mahindra.repository.CbmYearEndRepository;

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
	
	@Autowired
	CbmMagazineChainRepository cbmMagazineChainRepository;
	
	@Autowired
	CbmYearEndRepository cbmYearEndRepository;
	
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
	
	@RequestMapping(value = { "/getCbmSpindleTemperHistoryByYearId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSpindleTemper> getCbmSpindleTemperHistoryByYearId(@RequestParam("yearId") int yearId) 
	{
		List<CbmSpindleTemper> list = new ArrayList<CbmSpindleTemper>();
		
		try {
			
			list= cbmSpindleTemperRepository.findByYearEnd(String.valueOf(yearId));
		    
			
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
	
	@RequestMapping(value = { "/saveCbmMagazineChain" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmMagazineChain> saveCbmMagazineChain(@RequestBody List<CbmMagazineChain> cbmMagazineChainList) 
	{
		List<CbmMagazineChain> save = new ArrayList<CbmMagazineChain>();
		
		try {
			
			 save= cbmMagazineChainRepository.save(cbmMagazineChainList);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return save;
	}
	
	@RequestMapping(value = { "/getCbmMagazineChain" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmMagazineChain> getCbmMagazineChain(@RequestParam("deptId") int deptId) 
	{
		List<CbmMagazineChain> list = new ArrayList<CbmMagazineChain>();
		
		try {
			
			list= cbmMagazineChainRepository.findByStatusAndDeptId(0,deptId);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = { "/getCbmScheduleListForCbmMagazineChain" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSchedule> getCbmScheduleListForCbmMagazineChain(@RequestParam("deptId")int deptId) 
	{
		List<CbmSchedule> cbmScheduleList = new ArrayList<>();
		
		try {
			
			cbmScheduleList=cbmScheduleRepository.getCbmScheduleListForCbmMagazineChain(deptId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return cbmScheduleList;
	}
	
	@RequestMapping(value = { "/saveCbmYearEnd" }, method = RequestMethod.POST)
	@ResponseBody
	public CbmYearEnd saveCbmYearEnd(@RequestBody  CbmYearEnd  cbmYearEnd) 
	{
		CbmYearEnd save = new CbmYearEnd();
		
		try {
			
			 save= cbmYearEndRepository.save(cbmYearEnd);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return save;
	}
	
	@RequestMapping(value = { "/getYearEndByDeptIdAndCbmType" }, method = RequestMethod.POST)
	@ResponseBody
	public CbmYearEnd getYearEndByDeptIdAndCbmType(@RequestParam("deptId")int deptId,
			@RequestParam("cbmType")int cbmType) 
	{
		CbmYearEnd getYearEndByDeptIdAndCbmType = new CbmYearEnd();
		
		try {
			
			getYearEndByDeptIdAndCbmType= cbmYearEndRepository.findByDeptIdAndCbmTypeAndStatus(deptId,cbmType,0);
			
			if(getYearEndByDeptIdAndCbmType==null) {
				getYearEndByDeptIdAndCbmType = new CbmYearEnd();
			}
		    
			
		}catch(Exception e) {
			e.printStackTrace();
			getYearEndByDeptIdAndCbmType = new CbmYearEnd();
		}
		return getYearEndByDeptIdAndCbmType;
	}
	
	@RequestMapping(value = { "/getYearEndList" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmYearEnd> getYearEndList(@RequestParam("deptId")int deptId,
			@RequestParam("cbmType")int cbmType) 
	{
		List<CbmYearEnd> getYearEndList = new ArrayList<CbmYearEnd>();
		
		try {
			
			getYearEndList= cbmYearEndRepository.getYearEndList(deptId,cbmType,1);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return getYearEndList;
	}

}
