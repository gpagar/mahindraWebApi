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

import com.ganesh.mahindra.mail.MailMail;
import com.ganesh.mahindra.model.Info;
import com.ganesh.mahindra.model.LearningLibrary;
import com.ganesh.mahindra.model.cbm.CbmSchedule;
import com.ganesh.mahindra.repository.CbmScheduleRepository;
import com.ganesh.mahindra.repository.LearningLibraryRepository;

@RestController
public class LearningLibraryWebApi {
	
	@Autowired
	LearningLibraryRepository learningLibraryRepository;
	 
	@RequestMapping(value = { "/sendMail" }, method = RequestMethod.GET)
	@ResponseBody
	public LearningLibrary sendMail() 
	{
		
		LearningLibrary save = new LearningLibrary();
		
		try {
			String msg = "mail send through Boot ";
			//MailMail.sendMsgThoughMail(msg);
			MailMail.sendFileThoughMail();
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	    return save;
	}
	
	@RequestMapping(value = { "/saveFile" }, method = RequestMethod.POST)
	@ResponseBody
	public LearningLibrary saveFile(@RequestBody LearningLibrary learningLibrary) 
	{
		
		LearningLibrary save = new LearningLibrary();
		
		try {
			
			save = learningLibraryRepository.save(learningLibrary);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	    return save;
	}
	
	@RequestMapping(value = { "/deleteFile" }, method = RequestMethod.POST)
	@ResponseBody
	public Info deleteFile(@RequestParam("fileId") int fileId) 
	{
		
		Info info = new Info();
		
		try {
			
			int delete = learningLibraryRepository.deleteFile(fileId);
			
			if(delete==0) {
				info.setError(true);
				info.setMessage("failed to Delete");
			}
			else {
				info.setError(false);
				info.setMessage("deleted");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			info.setError(true);
			info.setMessage("Error in failed to Delete");
		}
		 
	    return info;
	}
	
	@RequestMapping(value = { "/getFileList" }, method = RequestMethod.GET)
	@ResponseBody
	public List<LearningLibrary> getFileList() 
	{
		
		List<LearningLibrary> list = new ArrayList<LearningLibrary>();
		
		try {
			
			list = learningLibraryRepository.findByDelStatus(0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	    return list;
	}

}
