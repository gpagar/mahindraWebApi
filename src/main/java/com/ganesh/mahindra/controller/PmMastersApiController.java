package com.ganesh.mahindra.controller;

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
import com.ganesh.mahindra.repository.MachinDetailsRepository;
import com.ganesh.mahindra.repository.MachinMaintanaceScheduleRepository;
import com.ganesh.mahindra.repository.PMActivityDetailsRepository;
import com.ganesh.mahindra.repository.PMCheckPointsRepository;
import com.ganesh.mahindra.repository.PMItemDetailsRepository;

@RestController
public class PmMastersApiController {

	@Autowired
	MachinDetailsRepository machinDetailsRepository;
	
	@Autowired
	PMActivityDetailsRepository pMActivityDetailsRepository;
	
	@Autowired
	PMItemDetailsRepository pMItemDetailsRepository;
	
	@Autowired
	PMCheckPointsRepository pMCheckPointsRepository;
	
	
	@Autowired
	MachinMaintanaceScheduleRepository machinMaintanaceScheduleRepository;
	
	 
	@RequestMapping(value = { "/insertPmMachinePlan" }, method = RequestMethod.POST)
	@ResponseBody
	public Info insertPmMachinePlan(@RequestBody MachinMaintanaceSchedule machinMaintanaceSchedule)
	{
		
		Info info=new Info();
		machinMaintanaceScheduleRepository.save(machinMaintanaceSchedule);
		
		return info;
	}
	
	@RequestMapping(value = { "/getPmMachinePlanById" }, method = RequestMethod.POST)
	@ResponseBody
	public MachinMaintanaceSchedule getPmMachinePlanById(@RequestParam("machineId")int machineId)
	{
		MachinMaintanaceSchedule machinMaintanaceScheduleRes=null;
		try {
			machinMaintanaceScheduleRes=machinMaintanaceScheduleRepository.findByMachinIdAndDelStatus(machineId,0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return machinMaintanaceScheduleRes;
	}
	
	
	@RequestMapping(value = { "/insertPmMachine" }, method = RequestMethod.POST)
	@ResponseBody
	public MachinDetails insertPmMachine(@RequestBody MachinDetails machinDetails)
	{
		
		//Info info=new Info();
		MachinDetails machinDetailsRes=machinDetailsRepository.save(machinDetails);
		
		return machinDetailsRes;
	}
	

	@RequestMapping(value = { "/insertPmActivity" }, method = RequestMethod.POST)
	@ResponseBody
	public PMActivityDetails insertPmActivity(@RequestBody PMActivityDetails pMActivityDetails)
	{
		
		//Info info=new Info();
		 PMActivityDetails pMActivityDetailsRes=pMActivityDetailsRepository.save(pMActivityDetails);
		
		return pMActivityDetailsRes;
	}
	@RequestMapping(value = { "/getPmActivity" }, method = RequestMethod.POST)
	@ResponseBody
	public PMActivityDetails getPmActivity(@RequestParam("activityId")int activityId)	{
		
		//Info info=new Info();
		 PMActivityDetails pMActivityDetailsRes=pMActivityDetailsRepository.findByActivityId(activityId);
		
		return pMActivityDetailsRes;
	}
	
	@RequestMapping(value = { "/insertPmItem" }, method = RequestMethod.POST)
	@ResponseBody
	public PMItemDetails insertPmItem(@RequestBody PMItemDetails pMItemDetails)
	{
		
		//Info info=new Info();
		PMItemDetails pMItemDetailsRes=pMItemDetailsRepository.save(pMItemDetails);
		
		return pMItemDetailsRes;
	}
	@RequestMapping(value = { "/getPmItem" }, method = RequestMethod.POST)
	@ResponseBody
	public PMItemDetails getPmItem(@RequestParam("itemId")int itemId)	{
		
		//Info info=new Info();
		PMItemDetails pMItemDetailsRes=pMItemDetailsRepository.findByItemId(itemId);
		
		return pMItemDetailsRes;
	}
	@RequestMapping(value = { "/insertPmCheckpoint" }, method = RequestMethod.POST)
	@ResponseBody
	public PMCheckPoints insertPmCheckpoint(@RequestBody PMCheckPoints pMCheckPoints)
	{
		
		//Info info=new Info();
		PMCheckPoints pMCheckPointsRes=pMCheckPointsRepository.save(pMCheckPoints);
		
		return pMCheckPointsRes;
	}
	@RequestMapping(value = { "/getPmCheckpoints" }, method = RequestMethod.POST)
	@ResponseBody
	public PMCheckPoints getPmCheckpoints(@RequestParam("checkpointId")int checkpointId)	{
		
		//Info info=new Info();
		PMCheckPoints pMCheckPointsRes=pMCheckPointsRepository.findByCheckPointId(checkpointId);
		
		return pMCheckPointsRes;
	}
	
	
	@RequestMapping(value = { "/deleteMachinId" }, method = RequestMethod.POST)
	@ResponseBody
	public Info deleteMachinId(@RequestParam("machinId") int machinId)
	{
		System.out.println("machinId  "+machinId);
		Info info=new Info();
		int res=0;
		info.setError(true);
		info.setMessage("Delete problem");
		try {
			
			 res=machinDetailsRepository.deleteMachinId(machinId);
		}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace(); 
			}
		if(res>0)
		{	info.setError(false);
		info.setMessage("Delete Siccessfulyy");
		}
		 
		 
		
		return info;
	}
	
	
	@RequestMapping(value = { "/deletePmActivity" }, method = RequestMethod.POST)
	@ResponseBody
	public Info deletePmActivity(@RequestParam("activityId") int activityId)
	{
		System.out.println("activityId  "+activityId);
		Info info=new Info();
		int res=0;
		info.setError(true);
		info.setMessage("Delete problem");
		try {
			
			 res=pMActivityDetailsRepository.deleteMachinId(activityId);
		}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace(); 
			}
		if(res>0)
		{	info.setError(false);
		info.setMessage("Delete Siccessfulyy");
		}
		 
		 
		
		return info;
	}
	
	
	@RequestMapping(value = { "/deletePmItem" }, method = RequestMethod.POST)
	@ResponseBody
	public Info deletePmItem(@RequestParam("itemId") int itemId)
	{
		System.out.println("itemId  "+itemId);
		Info info=new Info();
		int res=0;
		info.setError(true);
		info.setMessage("Delete problem");
		try {
			
			 res=pMItemDetailsRepository.deleteItemId(itemId);
		}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace(); 
			}
		if(res>0)
		{	info.setError(false);
		info.setMessage("Delete Siccessfulyy");
		}
		 
		 
		
		return info;
	}
	
	
	@RequestMapping(value = { "/deletePmCheckpoints" }, method = RequestMethod.POST)
	@ResponseBody
	public Info deletePmCheckpoints(@RequestParam("machinCheckPoint") int machinCheckPoint)
	{
		System.out.println("machinCheckPoint  "+machinCheckPoint);
		Info info=new Info();
		int res=0;
		info.setError(true);
		info.setMessage("Delete problem");
		try {
			
			 res=pMCheckPointsRepository.deleteCheckpoints(machinCheckPoint);
		}catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace(); 
			}
		if(res>0)
		{	info.setError(false);
		info.setMessage("Delete Siccessfulyy");
		}
		 
		 
		
		return info;
	}
	
}
	
	
