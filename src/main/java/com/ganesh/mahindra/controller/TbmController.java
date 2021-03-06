package com.ganesh.mahindra.controller;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ganesh.mahindra.model.PmRequiredValue;
import com.ganesh.mahindra.model.tbm.GetTbmHistory;
import com.ganesh.mahindra.model.tbm.PostTbm;
import com.ganesh.mahindra.model.tbm.TbmData;
import com.ganesh.mahindra.model.tbm.TbmMachine;
import com.ganesh.mahindra.model.tbm.UpdateTbm;
import com.ganesh.mahindra.repository.tbm.PostTbmRepository;
import com.ganesh.mahindra.repository.tbm.TbmDataRepository;
import com.ganesh.mahindra.repository.tbm.TbmHistoryRepository;
import com.ganesh.mahindra.repository.tbm.TbmMachineRepository;
import com.ganesh.mahindra.repository.tbm.UpdateTbmRepository;

@RestController
public class TbmController {

	
	@Autowired
	TbmMachineRepository tbmMachineRepository;
	
	@Autowired
	TbmDataRepository tbmDataRepository;
	
	@Autowired
	PostTbmRepository postTbmRepository;
	
	@Autowired
	TbmHistoryRepository tbmHistoryRepository;
	
	@Autowired
	UpdateTbmRepository updateTbmRepository;
	
	@RequestMapping(value = { "/getAllTbmMachines" }, method = RequestMethod.POST)
	@ResponseBody
	public List<TbmMachine> getAllTbmMachines(@RequestParam("deptId")int deptId) 
	{
		List<TbmMachine> machineList=null;
		
		try {
			machineList=tbmMachineRepository.findByDelStatusAndInt1OrderByMachineName(0,deptId);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return machineList;
	}
	
	@RequestMapping(value = { "/getTbmDataByMachineId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<TbmData> getTbmDataByMachineId(@RequestParam("machineId")int machineId) 
	{
		List<TbmData> tbmDataList=null;
		
		try {
			tbmDataList=tbmDataRepository.getTbmDataByMachineId(machineId);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tbmDataList;
	}
	@RequestMapping(value = { "/insertTbm" }, method = RequestMethod.POST)
	@ResponseBody
	public PostTbm insertTbm(@RequestBody PostTbm postTbm) 
	{
		PostTbm postTbmRes=null;
		
		try {
			postTbmRes=postTbmRepository.saveAndFlush(postTbm);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return postTbmRes;
	}
	@RequestMapping(value = { "/updateTbm" }, method = RequestMethod.POST)
	@ResponseBody
	public UpdateTbm updateTbm(@RequestBody UpdateTbm updateTbm) 
	{
		UpdateTbm updateTbmRes=null;
		
		try {
			updateTbmRes=updateTbmRepository.saveAndFlush(updateTbm);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return updateTbmRes;
	}
	@RequestMapping(value = { "/getTbmHistory" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetTbmHistory> getTbmHistory(@RequestParam("deptId")int deptId,@RequestParam("fromYear")int fromYear,@RequestParam("toYear")int toYear) 
	{
		List<GetTbmHistory> tbmDataList=null;
		
		try {
			tbmDataList=tbmHistoryRepository.getTbmHistory(deptId,fromYear,toYear);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tbmDataList;
	}
			
}
