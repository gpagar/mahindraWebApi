package com.ganesh.mahindra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.mahindra.model.cbm.CbmSchedule;
import com.ganesh.mahindra.repository.CbmScheduleRepository;

@RestController
public class CbmController {

	@Autowired
	CbmScheduleRepository cbmScheduleRepository;
	
	@RequestMapping(value = { "/getCbmSchedule" }, method = RequestMethod.POST)
	@ResponseBody
	public List<CbmSchedule> getCbmSchedule(@RequestParam("deptId")int deptId) 
	{
		List<CbmSchedule> cbmScheduleList=cbmScheduleRepository.findByDeptId(deptId);
	    return cbmScheduleList;
	}
}
