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

import com.ganesh.mahindra.model.Info;
import com.ganesh.mahindra.model.MachinDetails;
import com.ganesh.mahindra.model.MachinDetailsList;
import com.ganesh.mahindra.model.MachinMaintanaceSchedule;
import com.ganesh.mahindra.model.PMActivityDetails;
import com.ganesh.mahindra.model.PMCheckPoints;
import com.ganesh.mahindra.model.PMItemDetails;
import com.ganesh.mahindra.model.PaMaintananceDetails;
import com.ganesh.mahindra.model.PmRequiredValue;
import com.ganesh.mahindra.model.UserDetails;
import com.ganesh.mahindra.repository.MachinDetailsRepository;
import com.ganesh.mahindra.repository.MachinMaintanaceScheduleRepository;
import com.ganesh.mahindra.repository.PMActivityDetailsRepository;
import com.ganesh.mahindra.repository.PMCheckPointsRepository;
import com.ganesh.mahindra.repository.PMItemDetailsRepository;
import com.ganesh.mahindra.repository.PaMaintananceDetailsRepository;
import com.ganesh.mahindra.repository.PmRequiredValueRepository;

@RestController
public class PMaintanance {

	
	@Autowired
	MachinDetailsRepository machinDetailsRepository;
	
	@Autowired
	PMActivityDetailsRepository pMActivityDetailsRepository;
	
	@Autowired
	PMItemDetailsRepository pMItemDetailsRepository;
	
	@Autowired
	PMCheckPointsRepository pMCheckPointsRepository;
	
	@Autowired
	PmRequiredValueRepository pmRequiredValueRepository;
	
	@Autowired
	MachinMaintanaceScheduleRepository machinMaintanaceScheduleRepository;
	
	@Autowired
	PaMaintananceDetailsRepository paMaintananceDetailsRepository;
	
	@RequestMapping(value = { "/getAllPmRequiredValue" }, method = RequestMethod.GET)
	@ResponseBody
	public List<PmRequiredValue> getAllPmRequiredValue() 
	{
		System.out.println("getAllPmRequiredValue");
		return pmRequiredValueRepository.findByDelStatus(0);
	}
	
	
	
	@RequestMapping(value = { "/getMachineByType" }, method = RequestMethod.POST)
	@ResponseBody
	public MachinDetailsList getMachineByType(@RequestParam("type")int type )
	{
		System.out.println("getMachineByType");
		Info info=new Info();
		MachinDetailsList machinDetailsList=new MachinDetailsList();
		try {
		List<MachinDetails> machinDetailslistRes= machinDetailsRepository.findByTypeAndDelStatus(type, 0);
		
		if(machinDetailslistRes!=null && !machinDetailslistRes.isEmpty())
		{
			machinDetailsList.setMachinDetailsList(machinDetailslistRes);
			info.setError(false);
			info.setMessage("success");
			machinDetailsList.setInfo(info);
		}
		
		else {
			info.setError(true);
			info.setMessage("Failed");
			machinDetailsList.setInfo(info);
		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			info.setError(true);
			info.setMessage("Failed");
			machinDetailsList.setInfo(info);
		}
	return machinDetailsList;	
	}
	
	@RequestMapping(value = { "/getActivityByMachin" }, method = RequestMethod.POST)
	@ResponseBody
	public List<PMActivityDetails> getMachineActivityByMachinId(@RequestParam("machinId")int machinId ) 
	{
		System.out.println("getMachineActivityByMachinId    + "+machinId);
		List<PMActivityDetails> pMActivityDetailsList=new ArrayList<>();
		try {
			pMActivityDetailsList=pMActivityDetailsRepository.findByMachinIdAndDelStatus(machinId, 0);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return pMActivityDetailsList;
	}
	
	
	@RequestMapping(value = { "/getItemsByActivityId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<PMItemDetails> getItemsByActivityId(@RequestParam("activityId")int activityId ) 
	{
		System.out.println("getItemsByActivityId");
	
		 return pMItemDetailsRepository.findByActivityIdAndDelStatus(activityId, 0);
	}
	
	
	
	@RequestMapping(value = { "/getCheckPointsByItemId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<PMCheckPoints> getCheckPointsByItemId(@RequestParam("itemId")int itemId ) 
	{
		List<PMCheckPoints> checkPointList = new ArrayList<PMCheckPoints>();
		try
		{
			System.out.println("getCheckPointsByItemId");
			checkPointList = pMCheckPointsRepository.findByItemIdAndDelStatus(itemId, 0);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return checkPointList;
	}
	
	
	
	@RequestMapping(value = { "/insertPMaintananceDetails" }, method = RequestMethod.POST)
	@ResponseBody
	public PaMaintananceDetails insertPMaintananceDetails(@RequestBody PaMaintananceDetails paMaintananceDetails) 
	{
		System.out.println("getCheckPointsByItemId");
		return paMaintananceDetailsRepository.save(paMaintananceDetails);
	}
	
	@RequestMapping(value = { "/getCheckRecordAgistMachine" }, method = RequestMethod.POST)
	@ResponseBody
	public PaMaintananceDetails getCheckRecordAgistMachine(@RequestParam("checkPointId")int checkPointId, @RequestParam("machineId")int machineId ) 
	{
		PaMaintananceDetails paMaintananceDetails = new PaMaintananceDetails();
		try
		{
			System.out.println("getCheckPointsByItemId");
			paMaintananceDetails = paMaintananceDetailsRepository.getCheckRecordAgistMachine(checkPointId,machineId);
			System.out.println("paMaintananceDetails " + paMaintananceDetails);
			
			if(paMaintananceDetails==null)
			{
				paMaintananceDetails = new PaMaintananceDetails();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return paMaintananceDetails;
	}
	
	@RequestMapping(value = { "/getPmMaintenancePlan" }, method = RequestMethod.POST)
	@ResponseBody
	public MachinMaintanaceSchedule getPmMaintenancePlan(@RequestParam("machineId")int machineId ) 
	{
		MachinMaintanaceSchedule getPmMaintenancePlan = new MachinMaintanaceSchedule();
		try
		{
			System.out.println("getCheckPointsByItemId");
			getPmMaintenancePlan = machinMaintanaceScheduleRepository.findByMachinIdAndDelStatus(machineId,0);
			System.out.println("getPmMaintenancePlan " + getPmMaintenancePlan);
			
			if(getPmMaintenancePlan==null)
			{
				getPmMaintenancePlan = new MachinMaintanaceSchedule();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return getPmMaintenancePlan;
	}
	
}
