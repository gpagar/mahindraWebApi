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

import com.ganesh.mahindra.model.cbm.BallBarTest;
import com.ganesh.mahindra.model.cbm.CbmSchedule;
import com.ganesh.mahindra.repository.BallBarTestRepository;
import com.ganesh.mahindra.repository.CbmScheduleRepository;

@RestController
public class BallBarTestController {

	@Autowired
	CbmScheduleRepository cbmScheduleRepository;
	
	@Autowired
	BallBarTestRepository ballBarTestRepository;
	
	@RequestMapping(value = { "/saveBallBarTest" }, method = RequestMethod.POST)
	@ResponseBody
	public List<BallBarTest> saveBallBarTest(@RequestBody List<BallBarTest> ballBarTest) 
	{
		List<BallBarTest> save = new ArrayList<BallBarTest>();
		
		try {
			
			 save= ballBarTestRepository.save(ballBarTest);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return save;
	}
	
	@RequestMapping(value = { "/getBallBarTest" }, method = RequestMethod.POST)
	@ResponseBody
	public List<BallBarTest> getBallBarTest(@RequestParam("deptId") int deptId) 
	{
		List<BallBarTest> list = new ArrayList<BallBarTest>();
		
		try {
			
			list= ballBarTestRepository.findByStatusAndDeptId(0,deptId);
		    
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@RequestMapping(value = { "/getCbmScheduleListForBallBarTest" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSchedule> getCbmScheduleListForBallBarTest(@RequestParam("deptId")int deptId) 
	{
		List<CbmSchedule> cbmScheduleList = new ArrayList<>();
		
		try {
			
			cbmScheduleList=cbmScheduleRepository.getCbmScheduleListForBallBarTest(deptId);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    return cbmScheduleList;
	}
}
