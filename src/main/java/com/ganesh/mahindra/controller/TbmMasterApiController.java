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
import com.ganesh.mahindra.model.tbm.TbmMachineDetails;
import com.ganesh.mahindra.model.tbm.TbmMachineItem;
import com.ganesh.mahindra.model.tbm.TbmMachineLocation;
import com.ganesh.mahindra.repository.tbm.TbmMachineDetailsRepository;
import com.ganesh.mahindra.repository.tbm.TbmMachineItemRepository;
import com.ganesh.mahindra.repository.tbm.TbmMachineLocationRepository;

@RestController
public class TbmMasterApiController {

	
	@Autowired
	TbmMachineDetailsRepository tbmMachineDetailsRepository;
	
	@Autowired
	TbmMachineItemRepository tbmMachineItemRepository;
	
	@Autowired
	TbmMachineLocationRepository tbmMachineLocationRepository;
	
	
	@RequestMapping(value = { "/insertTbmMachine" }, method = RequestMethod.POST)
	@ResponseBody
	public TbmMachineDetails insertTbmMachine(@RequestBody TbmMachineDetails tbmMachineDetails)
	{
		
		Info info=new Info();
		
		TbmMachineDetails tbmMachineDetailsRes;
		tbmMachineDetailsRes=tbmMachineDetailsRepository.save(tbmMachineDetails);
		
 
		return tbmMachineDetailsRes;
	}
	@RequestMapping(value = { "/insertTbmMachineLocation" }, method = RequestMethod.POST)
	@ResponseBody
	public TbmMachineLocation insertTbmMachineLocation(@RequestBody TbmMachineLocation tbmMachineLocation)
	{
		
		TbmMachineLocation tbmMachineLocationRes=tbmMachineLocationRepository.save(tbmMachineLocation);
		return tbmMachineLocationRes;
	}
	
	@RequestMapping(value = { "/insertTbmMachineitem" }, method = RequestMethod.POST)
	@ResponseBody
	public TbmMachineItem insertTbmMachineitem(@RequestBody TbmMachineItem tbmMachineItem)
	{
		TbmMachineItem tbmMachineItemRes=new TbmMachineItem();
		try {
		tbmMachineItemRes=tbmMachineItemRepository.save(tbmMachineItem); 
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return tbmMachineItemRes;
	}
	
	
	
	@RequestMapping(value = { "/getTbmMachine" }, method = RequestMethod.GET)
	@ResponseBody
	public List<TbmMachineDetails>  getTbmMachine(@RequestParam("deptId")int deptId) 
	{
		
		
		return tbmMachineDetailsRepository.findByInt1AndDelStatus(deptId,0);
	}
	
	@RequestMapping(value = { "/getTbmByMachineId" }, method = RequestMethod.POST)
	@ResponseBody
	public  TbmMachineDetails   getTbmByMachineId(@RequestParam("machineId")int machineId ) 
	{
		
		System.out.println("machineId  "+machineId);
	
		 
	
		 
		return tbmMachineDetailsRepository.findByDelStatusAndMachineId(0, machineId);
	}
	
	
	@RequestMapping(value = { "/getLocationByMachineId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<TbmMachineLocation>  getLocationByMachineId(@RequestParam("machineId")int machineId ) 
	{
		
		System.out.println("machineId  "+machineId);
		List<TbmMachineLocation> tbmMachineLocationList=new ArrayList<TbmMachineLocation>(); 
		try {
		tbmMachineLocationList=tbmMachineLocationRepository.findByDelStatusAndMachineId(0, machineId);
		System.out.println(" tbmMachineLocationList  "+tbmMachineLocationList.toString());
		}catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		return tbmMachineLocationList;
	}
	
	@RequestMapping(value = { "/getLocationByLocationId" }, method = RequestMethod.POST)
	@ResponseBody
	public TbmMachineLocation  getLocationByLocationId(@RequestParam("locationId")int locationId ) 
	{
		
		System.out.println("locationId  "+locationId);
		 
		return tbmMachineLocationRepository.findByLocationId(locationId);
	}
	
	
	@RequestMapping(value = { "/getTbmMachineitem" }, method = RequestMethod.POST)
	@ResponseBody
	public List<TbmMachineItem> insertTbmMachineitem(@RequestParam("locationId")int locationId )
	{
		 
	 
		return tbmMachineItemRepository.findByDelStatusAndLocationId(0, locationId);
	}
	
	@RequestMapping(value = { "/getTbmMachineItemByItemId" }, method = RequestMethod.POST)
	@ResponseBody
	public TbmMachineItem getTbmMachineItemByItemId(@RequestParam("itemId")int itemId )
	{
		 
	 
		return tbmMachineItemRepository.findByDelStatusAndItemId(0, itemId);
	}
}
