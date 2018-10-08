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

import com.ganesh.mahindra.model.BreakdownDetail;
import com.ganesh.mahindra.model.BreakdownMonthwise;
import com.ganesh.mahindra.model.BreakdownProblems;
import com.ganesh.mahindra.model.BreakdownProblemsList;
import com.ganesh.mahindra.model.BreakdownTarget;
import com.ganesh.mahindra.model.BreakdownTimeMonthwise;
import com.ganesh.mahindra.model.BreakdownTimeYearly;
import com.ganesh.mahindra.model.BreakdownYearly;
import com.ganesh.mahindra.model.DailyBreakdowns;
import com.ganesh.mahindra.model.DailyGraphData;
import com.ganesh.mahindra.model.DailySearchedTarget;
import com.ganesh.mahindra.model.GetBreakdown;
import com.ganesh.mahindra.model.GetPMData;
import com.ganesh.mahindra.model.GetPaMaintainence;
import com.ganesh.mahindra.model.Info;
import com.ganesh.mahindra.model.MachinDetails;
import com.ganesh.mahindra.model.MachinDetailsList;
import com.ganesh.mahindra.model.MachinMaintanaceSchedule;
import com.ganesh.mahindra.model.MachineL3Target;
import com.ganesh.mahindra.model.MachineL3TimeTarget;
import com.ganesh.mahindra.model.MachineL5Target;
import com.ganesh.mahindra.model.MachineL5TimeTarget;
import com.ganesh.mahindra.model.PMActivityDetails;
import com.ganesh.mahindra.model.PMCheckPoints;
import com.ganesh.mahindra.model.PMItemDetails;
import com.ganesh.mahindra.model.PaMaintananceDetails;
import com.ganesh.mahindra.model.PmPlan;
import com.ganesh.mahindra.model.PmRequiredValue;
import com.ganesh.mahindra.model.TSetting;
import com.ganesh.mahindra.model.UserDetails;
import com.ganesh.mahindra.model.WhyWhyF18;
import com.ganesh.mahindra.model.YearlyMachinBreakdownList;
import com.ganesh.mahindra.model.YearlyMachineBdTimeList;
import com.ganesh.mahindra.repository.BreakdownDetailRepository;
import com.ganesh.mahindra.repository.BreakdownMonthwiseRepository;
import com.ganesh.mahindra.repository.BreakdownMonthwiseTimeRepository;
import com.ganesh.mahindra.repository.BreakdownProblemsListRepository;
import com.ganesh.mahindra.repository.BreakdownTargetRepository;
import com.ganesh.mahindra.repository.BreakdownYearlyRepository;
import com.ganesh.mahindra.repository.BreakdownYearlyTimeRepository;
import com.ganesh.mahindra.repository.DailyBreakdownRepository;
import com.ganesh.mahindra.repository.DailySearchedTargetRepository;
import com.ganesh.mahindra.repository.GetBreakdownRepository;
import com.ganesh.mahindra.repository.GetPaMaintainenceRepository;
import com.ganesh.mahindra.repository.GetPmDataRepository;
import com.ganesh.mahindra.repository.MachinDetailsRepository;
import com.ganesh.mahindra.repository.MachinMaintanaceScheduleRepository;
import com.ganesh.mahindra.repository.MachineL3TargetRepository;
import com.ganesh.mahindra.repository.MachineL3TimeTargetRepository;
import com.ganesh.mahindra.repository.MachineL5TargetRepository;
import com.ganesh.mahindra.repository.MachineL5TimeTargetRepository;
import com.ganesh.mahindra.repository.PMActivityDetailsRepository;
import com.ganesh.mahindra.repository.PMCheckPointsRepository;
import com.ganesh.mahindra.repository.PMItemDetailsRepository;
import com.ganesh.mahindra.repository.PaMaintananceDetailsRepository;
import com.ganesh.mahindra.repository.PmPlanRepository;
import com.ganesh.mahindra.repository.PmRequiredValueRepository;
import com.ganesh.mahindra.repository.TSettingRepository;
import com.ganesh.mahindra.repository.WhyWhyF18Repository;

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
	
	@Autowired
	GetPaMaintainenceRepository getPaMaintainenceRepository;
	@Autowired
	GetPmDataRepository getPmDataRepository;
	
	@Autowired
	WhyWhyF18Repository whyWhyF18Repository;
	
	@Autowired
	TSettingRepository tSettingRepository;
	
	@Autowired
	BreakdownMonthwiseRepository breakdownMonthwiseRepository;
	
	@Autowired
	BreakdownYearlyRepository breakdownYearlyRepository;
	
	@Autowired
	MachineL5TargetRepository machineL5TargetRepository;
	
	@Autowired
	GetBreakdownRepository getBreakdownRepository;
	
	@Autowired
	BreakdownDetailRepository breakdownDetailRepository;
	
	@Autowired
	BreakdownTargetRepository breakdownTargetRepository;
	
	@Autowired
	MachineL3TargetRepository machineL3TargetRepository;
	
	@Autowired
	DailyBreakdownRepository dailyBreakdownRepository;
	
	@Autowired
	DailySearchedTargetRepository dailySearchedTargetRepository;
	
	@Autowired
	BreakdownYearlyTimeRepository breakdownYearlyTimeRepository;
	
	@Autowired
	MachineL3TimeTargetRepository machineL3TimeTargetRepository;
	
	@Autowired
	MachineL5TimeTargetRepository machineL5TimeTargetRepository;
	
	@Autowired
	BreakdownMonthwiseTimeRepository breakdownMonthwiseTimeRepository;
	
	@Autowired
	BreakdownProblemsListRepository breakdownProblemsListRepository;
	
	@Autowired
	PmPlanRepository pmPlanRepository;
	
	@RequestMapping(value = { "/getMachineById" }, method = RequestMethod.POST)
	@ResponseBody
	public MachinDetails getMachineById(@RequestParam("machineId")int machineId ) 
	{
		MachinDetails machinDetails=machinDetailsRepository.findByMachinIdAndDelStatus(machineId,0);
		return machinDetails;
		
	}
	@RequestMapping(value = { "/getAllPmRequiredValue" }, method = RequestMethod.GET)
	@ResponseBody
	public List<PmRequiredValue> getAllPmRequiredValue() 
	{
		System.out.println("getAllPmRequiredValue");
		return pmRequiredValueRepository.findByDelStatus(0);
	}

	@RequestMapping(value = { "/getMachineByType" }, method = RequestMethod.POST)
	@ResponseBody
	public MachinDetailsList getMachineByType(@RequestParam("type")int type,@RequestParam("deptId")int deptId)
	{
		System.out.println("getMachineByType");
		Info info=new Info();
		MachinDetailsList machinDetailsList=new MachinDetailsList();
		try {
		List<MachinDetails> machinDetailslistRes= machinDetailsRepository.findByTypeAndInt1AndDelStatus(type,deptId, 0);
		
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
	@RequestMapping(value = { "/getMachineByDeptId" }, method = RequestMethod.POST)
	@ResponseBody
	public MachinDetailsList getMachineByDeptId(@RequestParam("deptId")List<Integer> deptId )
	{
		Info info=new Info();
		MachinDetailsList machinDetailsList=new MachinDetailsList();
		try {
		List<MachinDetails> machinDetailslistRes= machinDetailsRepository.findByInt1InAndDelStatusOrderByMachinName(deptId, 0);
		
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
	@RequestMapping(value = { "/getAllActivity" }, method = RequestMethod.GET)
	@ResponseBody
	public List<PMActivityDetails> getAllActivity() 
	{
		List<PMActivityDetails> pMActivityDetailsList=new ArrayList<>();
		try {
			pMActivityDetailsList=pMActivityDetailsRepository.findByDelStatus(0);
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
	
	@RequestMapping(value = { "/getAllItems" }, method = RequestMethod.GET)
	@ResponseBody
	public List<PMItemDetails> getAllItems() 
	{
		 return pMItemDetailsRepository.findByDelStatus(0);
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
	@RequestMapping(value = { "/deleteTarget" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteTarget(@RequestParam("targetId") int targetId) {

		Info infoRes = new Info();

		try {
			int delete = breakdownTargetRepository.deleteTarget(targetId);

			if (delete == 1) {
				infoRes.setError(false);
				infoRes.setMessage("Target Deleted Successfully");
			} else {
				infoRes.setError(true);
				infoRes.setMessage("Target Deletion Failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			infoRes.setError(true);
			infoRes.setMessage("Target Deletion Failed :EXC");

		}
		return infoRes;
	}
	@RequestMapping(value = { "/getAllCheckPoints" }, method = RequestMethod.GET)
	@ResponseBody
	public List<PMCheckPoints> getAllCheckPoints() 
	{
		List<PMCheckPoints> checkPointList = new ArrayList<PMCheckPoints>();
		try
		{
			System.out.println("getCheckPointsByItemId");
			checkPointList = pMCheckPointsRepository.findByDelStatus(0);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return checkPointList;
	}
	@RequestMapping(value = { "/getBreakdownTargetById" }, method = RequestMethod.POST)
	@ResponseBody
	public List<BreakdownTarget> getBreakdownTargetById(@RequestParam("graphType")int graphType,@RequestParam("deptId")int deptId) 
	{
		List<BreakdownTarget> brTargetList = new ArrayList<BreakdownTarget>();
		try
		{
			brTargetList = breakdownTargetRepository.findByStatusAndGraphTypeAndExInt(1,graphType,deptId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return brTargetList;
	}
	
	@RequestMapping(value = { "/insertPMaintananceDetails" }, method = RequestMethod.POST)
	@ResponseBody
	public PaMaintananceDetails insertPMaintananceDetails(@RequestBody PaMaintananceDetails paMaintananceDetails) 
	{
		System.out.println("getCheckPointsByItemId");
		return paMaintananceDetailsRepository.save(paMaintananceDetails);
	}
	@RequestMapping(value = { "/insertBreakdownTarget" }, method = RequestMethod.POST)
	@ResponseBody
	public BreakdownTarget insertBreakdownTarget(@RequestBody BreakdownTarget breakdownTargetRes) 
	{
		return breakdownTargetRepository.save(breakdownTargetRes);
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
	@RequestMapping(value = { "/getPmMaintenancePlanList" }, method = RequestMethod.POST)
	@ResponseBody
	public List<PmPlan> getPmMaintenancePlanList(@RequestParam("month")int month,@RequestParam("deptId")int deptId) 
	{
		List<PmPlan> getPmMaintenancePlan = new ArrayList<PmPlan>();
		try
		{
			getPmMaintenancePlan = pmPlanRepository.findByCurrentMonth(month,deptId);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return getPmMaintenancePlan;
	}
	@RequestMapping(value = { "/getPmMaintenancePlanOfMc" }, method = RequestMethod.POST)
	@ResponseBody
	public PmPlan getPmMaintenancePlanOfMc(@RequestParam("machineId")int machineId) 
	{
		PmPlan getPmMaintenancePlan = new PmPlan();
		try
		{
			getPmMaintenancePlan = pmPlanRepository.findByMachinId(machineId);
			
		}catch(Exception e)
		{
			getPmMaintenancePlan = new PmPlan();
			e.printStackTrace();
		}
		return getPmMaintenancePlan;
	}
	@RequestMapping(value = { "/getPmMaintainenceList" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetPaMaintainence> getPmMaintainenceList(@RequestParam("machineId")int machineId,@RequestParam("deptId")int deptId ) 
	{
		List<GetPaMaintainence> paMaintainenceList=new ArrayList<>();
		try {
		
		 paMaintainenceList=getPaMaintainenceRepository.getPmMaintainenceList(machineId,deptId);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return paMaintainenceList;
	}
	@RequestMapping(value = { "/getPMList" }, method = RequestMethod.POST)
	@ResponseBody
	public List<GetPMData> getPMList(@RequestParam("machinId")int machineId ) 
	{
		List<GetPMData> paMaintainenceList=new ArrayList<GetPMData>();
		try {
		
		 paMaintainenceList=getPmDataRepository.getPMList(machineId);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return paMaintainenceList;
	}
	
	@RequestMapping(value = { "/getAllWhyWhyF18" }, method = RequestMethod.POST)
	@ResponseBody
	public List<WhyWhyF18> getAllWhyWhyF18(@RequestParam("machineIdList")List<String> machineIdList) 
	{
		List<WhyWhyF18> whyWhyF18List=new ArrayList<WhyWhyF18>();
		try {
		
			whyWhyF18List=whyWhyF18Repository.findByMachineIdInAndDelStatus(machineIdList,0);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return whyWhyF18List;
	}
	@RequestMapping(value = { "/getAllWhyWhyByDeptId" }, method = RequestMethod.POST)
	@ResponseBody
	public List<WhyWhyF18> getAllWhyWhyByDeptId(@RequestParam("deptId")List<Integer> deptId) 
	{
		List<WhyWhyF18> whyWhyF18List=new ArrayList<WhyWhyF18>();
		try {
		
			whyWhyF18List=whyWhyF18Repository.findByDeptInAndDelStatus(deptId,0);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return whyWhyF18List;
	}
	@RequestMapping(value = { "/getAllBreakdownHistory" }, method = RequestMethod.POST)
	@ResponseBody
	public List<WhyWhyF18> getAllBreakdownHistory(@RequestParam("year")int year,@RequestParam("deptId")int deptId) 
	{
		List<WhyWhyF18> whyWhyF18List=new ArrayList<WhyWhyF18>();
		try {
		     int yearminus1=year-1;
		     String fromMonth=yearminus1+"-04";
		     String toMonth=year+"-03";
			whyWhyF18List=whyWhyF18Repository.getAllBreakdownHistory(fromMonth,toMonth,deptId);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return whyWhyF18List;
	}
	@RequestMapping(value = { "/getWhyWhyById" }, method = RequestMethod.POST)
	@ResponseBody
	public GetBreakdown getWhyWhyById(@RequestParam("id")int id) 
	{
		GetBreakdown getBreakdownRes=null;
		try {
		
			getBreakdownRes=getBreakdownRepository.findById(id);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return getBreakdownRes;
	}
	@RequestMapping(value = { "/insertWhyWhyF18" }, method = RequestMethod.POST)
	@ResponseBody
	public WhyWhyF18 insertWhyWhyF18(@RequestBody WhyWhyF18 whyWhyF18) 
	{
		return whyWhyF18Repository.save(whyWhyF18);
	}
	@RequestMapping(value = { "/insertBreakdownDetail" }, method = RequestMethod.POST)
	@ResponseBody
	public BreakdownDetail insertBreakdownDetail(@RequestBody BreakdownDetail breakdownDetailRes) 
	{
		return breakdownDetailRepository.save(breakdownDetailRes);
	}
	@RequestMapping(value = { "/getBreakdownDetail" }, method = RequestMethod.POST)
	public @ResponseBody BreakdownDetail getBreakdownDetail(@RequestParam("id") int id) {

		BreakdownDetail breakdownDetails = breakdownDetailRepository.findBreakdownDetailById(id);

		return breakdownDetails;
	}
	
	@RequestMapping(value = { "/getSettingValue" }, method = RequestMethod.POST)
	public @ResponseBody TSetting getSettingValue(@RequestParam("settingKey") String settingKey) {

		TSetting settingRes = tSettingRepository.findBySettingKey(settingKey);

		return settingRes;
	}
	@RequestMapping(value = { "/updateSetingValue" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSeetingForPB(@RequestParam("settingValue") int settingValue,
			@RequestParam("settingKey") String settingKey) {

		Info info = new Info();

		int result = tSettingRepository.updateSetingValue(settingValue, settingKey);

		if (result > 0) {

			info.setError(false);
			info.setMessage("Setting Value updated successfully");
		}

		else {

			info.setError(true);
			info.setMessage("Setting Value Not updated");
		}

		return info;

	}
	/*@RequestMapping(value = "/getMonthwiseL5Target", method = RequestMethod.POST)
	public @ResponseBody BreakdownMonthwise getMonthwiseL5Target( @RequestParam("fromYear") int fromYear,@RequestParam("toYear") int toYear) {
		
		BreakdownMonthwise breakdownMonthwiseList=breakdownMonthwiseRepository.getMonthwiseL5Target( fromYear,toYear);
		 
		return breakdownMonthwiseList;
		
	}*/
	@RequestMapping(value = "/getMonthwiseBreakdowns", method = RequestMethod.POST)
	public @ResponseBody BreakdownMonthwise getMonthwiseBreakdowns(
			 @RequestParam("first") String first,@RequestParam("second") String second, @RequestParam("third") String third,@RequestParam("fourth") String fourth, @RequestParam("fifth") String fifth, @RequestParam("sixth") String sixth, @RequestParam("seventh") String seventh, @RequestParam("eighth") String eighth, @RequestParam("ninth") String ninth, @RequestParam("tenth") String tenth, @RequestParam("eleventh") String eleventh, @RequestParam("twelvth") String twelvth,@RequestParam("deptId") int deptId) {
		
		BreakdownMonthwise breakdownMonthwiseList=breakdownMonthwiseRepository.getMonthwiseBreakdowns( first, second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth,eleventh,twelvth,deptId);
		 
		return breakdownMonthwiseList;
		
	}
	@RequestMapping(value = "/getARankMonthwiseBreakdowns", method = RequestMethod.POST)
	public @ResponseBody BreakdownMonthwise getARankMonthwiseBreakdowns(
			 @RequestParam("first") String first,@RequestParam("second") String second, @RequestParam("third") String third,@RequestParam("fourth") String fourth, @RequestParam("fifth") String fifth, @RequestParam("sixth") String sixth, @RequestParam("seventh") String seventh, @RequestParam("eighth") String eighth, @RequestParam("ninth") String ninth, @RequestParam("tenth") String tenth, @RequestParam("eleventh") String eleventh, @RequestParam("twelvth") String twelvth,@RequestParam("deptId") int deptId) {
		
		BreakdownMonthwise breakdownMonthwiseList=breakdownMonthwiseRepository.getARankMonthwiseBreakdowns( first, second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth,eleventh,twelvth,deptId);
		 
		return breakdownMonthwiseList;
		
	}
	@RequestMapping(value = "/getAllBrekMonthwiseBreakdowns", method = RequestMethod.POST)
	public @ResponseBody BreakdownMonthwise getAllBrekMonthwiseBreakdowns(
			 @RequestParam("first") String first,@RequestParam("second") String second, @RequestParam("third") String third,@RequestParam("fourth") String fourth, @RequestParam("fifth") String fifth, @RequestParam("sixth") String sixth, @RequestParam("seventh") String seventh, @RequestParam("eighth") String eighth, @RequestParam("ninth") String ninth, @RequestParam("tenth") String tenth, @RequestParam("eleventh") String eleventh, @RequestParam("twelvth") String twelvth,@RequestParam("deptId") int deptId) {
		
		BreakdownMonthwise breakdownMonthwiseList=breakdownMonthwiseRepository.getAllBrekMonthwiseBreakdowns( first, second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth,eleventh,twelvth,deptId);
		 
		return breakdownMonthwiseList;
		
	}
	@RequestMapping(value = "/getAllBrekMonthwiseBreakdownTime", method = RequestMethod.POST)
	public @ResponseBody BreakdownTimeMonthwise getAllBrekMonthwiseBreakdownTime(
			 @RequestParam("first") String first,@RequestParam("second") String second, @RequestParam("third") String third,@RequestParam("fourth") String fourth, @RequestParam("fifth") String fifth, @RequestParam("sixth") String sixth, @RequestParam("seventh") String seventh, @RequestParam("eighth") String eighth, @RequestParam("ninth") String ninth, @RequestParam("tenth") String tenth, @RequestParam("eleventh") String eleventh, @RequestParam("twelvth") String twelvth,@RequestParam("deptId") int deptId) {
		
		BreakdownTimeMonthwise breakdownMonthwiseList=breakdownMonthwiseTimeRepository.getAllBrekMonthwiseTimeBreakdowns( first, second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth,eleventh,twelvth,deptId);
		 
		return breakdownMonthwiseList;
		
	}
	@RequestMapping(value = "/getAllBrekMonthwiseBreakdownELoss", method = RequestMethod.POST)
	public @ResponseBody BreakdownTimeMonthwise getAllBrekMonthwiseBreakdownELoss(
			 @RequestParam("first") String first,@RequestParam("second") String second, @RequestParam("third") String third,@RequestParam("fourth") String fourth, @RequestParam("fifth") String fifth, @RequestParam("sixth") String sixth, @RequestParam("seventh") String seventh, @RequestParam("eighth") String eighth, @RequestParam("ninth") String ninth, @RequestParam("tenth") String tenth, @RequestParam("eleventh") String eleventh, @RequestParam("twelvth") String twelvth,@RequestParam("deptId") int deptId) {
		
		BreakdownTimeMonthwise breakdownMonthwiseList=breakdownMonthwiseTimeRepository.getAllBrekMonthwiseELBreakdowns( first, second,third,fourth,fifth,sixth,seventh,eighth,ninth,tenth,eleventh,twelvth,deptId);
		 
		return breakdownMonthwiseList;
		
	}
	@RequestMapping(value = "/getDailyBreakdownsTime", method = RequestMethod.POST)
	public @ResponseBody DailyGraphData getDailyBreakdownsTime(@RequestParam("month") String month,@RequestParam("graphType") int graphType,@RequestParam("deptId") int deptId) {
		BreakdownProblemsList bProblemsList=new BreakdownProblemsList();

		DailyGraphData dailyGraphData=new DailyGraphData();
		try {
		String str[] = month.split("-");
		int yearInt = Integer.parseInt(str[0]);
		int monthInt = Integer.parseInt(str[1]);
		DailySearchedTarget dSearchedTarget=null;
		if(monthInt<4)
		{
			int ofYear=yearInt;
			 dSearchedTarget=dailySearchedTargetRepository.getDailyTarget(graphType,ofYear,deptId);
			 dailyGraphData.setdSearchedTarget(dSearchedTarget);
		}
		else {
			int ofYear=yearInt+1;
			 dSearchedTarget=dailySearchedTargetRepository.getDailyTarget(graphType,ofYear,deptId);
			 dailyGraphData.setdSearchedTarget(dSearchedTarget);

		}
		DailyBreakdowns dailyBreakdownsRes=dailyBreakdownRepository.getAllBrekDailyBreakdownsTime(
				month+"-01",month+"-02",month+"-03",month+"-04",
				month+"-05",month+"-06",month+"-07",month+"-08",
				month+"-09",month+"-10",month+"-11",month+"-12",
				month+"-13",month+"-14",month+"-15",month+"-16",
				month+"-17",month+"-18",month+"-19",month+"-20",
				month+"-21",month+"-22",month+"-23",month+"-24",
				month+"-25",month+"-26",month+"-27",month+"-28",
				month+"-29",month+"-30",deptId);
		dailyGraphData.setDailyBreakdowns(dailyBreakdownsRes);
		for(int i=01;i<=30;i++)
		{
			List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyAllBreakdownMachineDetails(month+"-"+i,deptId);
			if(i==1)
			bProblemsList.setList1(breakPList);
			if(i==2)
			bProblemsList.setList2(breakPList);
			if(i==3)
			bProblemsList.setList3(breakPList);
			if(i==4)
			bProblemsList.setList4(breakPList);
			if(i==5)
			bProblemsList.setList5(breakPList);
			if(i==6)
			bProblemsList.setList6(breakPList);
			if(i==7)
			bProblemsList.setList7(breakPList);
			if(i==8)
			bProblemsList.setList8(breakPList);
			if(i==9)
			bProblemsList.setList9(breakPList);
			if(i==10)
			bProblemsList.setList10(breakPList);
			if(i==11)
			bProblemsList.setList11(breakPList);
			if(i==12)
			bProblemsList.setList12(breakPList);
			if(i==13)
			bProblemsList.setList13(breakPList);
			if(i==14)
			bProblemsList.setList14(breakPList);
			if(i==15)
			bProblemsList.setList15(breakPList);
			if(i==16)
			bProblemsList.setList16(breakPList);
			if(i==17)
			bProblemsList.setList17(breakPList);
			if(i==18)
			bProblemsList.setList18(breakPList);
			if(i==19)
			bProblemsList.setList19(breakPList);
			if(i==20)
			bProblemsList.setList20(breakPList);
			if(i==21)
			bProblemsList.setList21(breakPList);
			if(i==22)
			bProblemsList.setList22(breakPList);
			if(i==23)
			bProblemsList.setList23(breakPList);
			if(i==24)
			bProblemsList.setList24(breakPList);
			if(i==25)
			bProblemsList.setList25(breakPList);
			if(i==26)
			bProblemsList.setList26(breakPList);
			if(i==27)
			bProblemsList.setList27(breakPList);
			if(i==28)
			bProblemsList.setList28(breakPList);
			if(i==29)
			bProblemsList.setList29(breakPList);
			if(i==30)
			bProblemsList.setList30(breakPList);

			
		}System.err.println("bProblemsList"+bProblemsList.toString());
		dailyGraphData.setbProblemsList(bProblemsList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dailyGraphData;
	}
	@RequestMapping(value = "/getDailyBreakdownsELoss", method = RequestMethod.POST)
	public @ResponseBody DailyGraphData getDailyBreakdownsELoss(@RequestParam("month") String month,@RequestParam("graphType") int graphType,@RequestParam("deptId") int deptId) {
		BreakdownProblemsList bProblemsList=new BreakdownProblemsList();

		DailyGraphData dailyGraphData=new DailyGraphData();
		try {
		String str[] = month.split("-");
		int yearInt = Integer.parseInt(str[0]);
		int monthInt = Integer.parseInt(str[1]);
		DailySearchedTarget dSearchedTarget=null;
		if(monthInt<4)
		{
			int ofYear=yearInt;
			 dSearchedTarget=dailySearchedTargetRepository.getDailyTarget(graphType,ofYear,deptId);
			 dailyGraphData.setdSearchedTarget(dSearchedTarget);
		}
		else {
			int ofYear=yearInt+1;
			 dSearchedTarget=dailySearchedTargetRepository.getDailyTarget(graphType,ofYear,deptId);
			 dailyGraphData.setdSearchedTarget(dSearchedTarget);

		}
		DailyBreakdowns dailyBreakdownsRes=dailyBreakdownRepository.getAllBrekDailyBreakdownsELoss(
				month+"-01",month+"-02",month+"-03",month+"-04",
				month+"-05",month+"-06",month+"-07",month+"-08",
				month+"-09",month+"-10",month+"-11",month+"-12",
				month+"-13",month+"-14",month+"-15",month+"-16",
				month+"-17",month+"-18",month+"-19",month+"-20",
				month+"-21",month+"-22",month+"-23",month+"-24",
				month+"-25",month+"-26",month+"-27",month+"-28",
				month+"-29",month+"-30",deptId);
		dailyGraphData.setDailyBreakdowns(dailyBreakdownsRes);
		for(int i=01;i<=30;i++)
		{
			List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyAllBreakdownMachineDetails(month+"-"+i,deptId);
			if(i==1)
			bProblemsList.setList1(breakPList);
			if(i==2)
			bProblemsList.setList2(breakPList);
			if(i==3)
			bProblemsList.setList3(breakPList);
			if(i==4)
			bProblemsList.setList4(breakPList);
			if(i==5)
			bProblemsList.setList5(breakPList);
			if(i==6)
			bProblemsList.setList6(breakPList);
			if(i==7)
			bProblemsList.setList7(breakPList);
			if(i==8)
			bProblemsList.setList8(breakPList);
			if(i==9)
			bProblemsList.setList9(breakPList);
			if(i==10)
			bProblemsList.setList10(breakPList);
			if(i==11)
			bProblemsList.setList11(breakPList);
			if(i==12)
			bProblemsList.setList12(breakPList);
			if(i==13)
			bProblemsList.setList13(breakPList);
			if(i==14)
			bProblemsList.setList14(breakPList);
			if(i==15)
			bProblemsList.setList15(breakPList);
			if(i==16)
			bProblemsList.setList16(breakPList);
			if(i==17)
			bProblemsList.setList17(breakPList);
			if(i==18)
			bProblemsList.setList18(breakPList);
			if(i==19)
			bProblemsList.setList19(breakPList);
			if(i==20)
			bProblemsList.setList20(breakPList);
			if(i==21)
			bProblemsList.setList21(breakPList);
			if(i==22)
			bProblemsList.setList22(breakPList);
			if(i==23)
			bProblemsList.setList23(breakPList);
			if(i==24)
			bProblemsList.setList24(breakPList);
			if(i==25)
			bProblemsList.setList25(breakPList);
			if(i==26)
			bProblemsList.setList26(breakPList);
			if(i==27)
			bProblemsList.setList27(breakPList);
			if(i==28)
			bProblemsList.setList28(breakPList);
			if(i==29)
			bProblemsList.setList29(breakPList);
			if(i==30)
			bProblemsList.setList30(breakPList);

			
		}System.err.println("bProblemsList"+bProblemsList.toString());
		dailyGraphData.setbProblemsList(bProblemsList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dailyGraphData;
	}
	@RequestMapping(value = "/getDailyBreakdowns", method = RequestMethod.POST)
	public @ResponseBody DailyGraphData getDailyBreakdowns(@RequestParam("month") String month,@RequestParam("graphType") int graphType,@RequestParam("deptId") int deptId) {
		BreakdownProblemsList bProblemsList=new BreakdownProblemsList();

		DailyGraphData dailyGraphData=new DailyGraphData();
		try {
		String str[] = month.split("-");
		int yearInt = Integer.parseInt(str[0]);
		int monthInt = Integer.parseInt(str[1]);
		DailySearchedTarget dSearchedTarget=null;
		if(monthInt<4)
		{
			int ofYear=yearInt;
			 dSearchedTarget=dailySearchedTargetRepository.getDailyTarget(graphType,ofYear,deptId);
			 dailyGraphData.setdSearchedTarget(dSearchedTarget);
		}
		else {
			int ofYear=yearInt+1;
			 dSearchedTarget=dailySearchedTargetRepository.getDailyTarget(graphType,ofYear,deptId);
			 dailyGraphData.setdSearchedTarget(dSearchedTarget);

		}
		DailyBreakdowns dailyBreakdownsRes=dailyBreakdownRepository.getDailyBreakdowns(
				month+"-01",month+"-02",month+"-03",month+"-04",
				month+"-05",month+"-06",month+"-07",month+"-08",
				month+"-09",month+"-10",month+"-11",month+"-12",
				month+"-13",month+"-14",month+"-15",month+"-16",
				month+"-17",month+"-18",month+"-19",month+"-20",
				month+"-21",month+"-22",month+"-23",month+"-24",
				month+"-25",month+"-26",month+"-27",month+"-28",
				month+"-29",month+"-30",deptId);
		dailyGraphData.setDailyBreakdowns(dailyBreakdownsRes);
		for(int i=01;i<=30;i++)
		{
			List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyBreakdownMachineDetails(month+"-"+i,deptId);
			if(i==1)
			bProblemsList.setList1(breakPList);
			if(i==2)
			bProblemsList.setList2(breakPList);
			if(i==3)
			bProblemsList.setList3(breakPList);
			if(i==4)
			bProblemsList.setList4(breakPList);
			if(i==5)
			bProblemsList.setList5(breakPList);
			if(i==6)
			bProblemsList.setList6(breakPList);
			if(i==7)
			bProblemsList.setList7(breakPList);
			if(i==8)
			bProblemsList.setList8(breakPList);
			if(i==9)
			bProblemsList.setList9(breakPList);
			if(i==10)
			bProblemsList.setList10(breakPList);
			if(i==11)
			bProblemsList.setList11(breakPList);
			if(i==12)
			bProblemsList.setList12(breakPList);
			if(i==13)
			bProblemsList.setList13(breakPList);
			if(i==14)
			bProblemsList.setList14(breakPList);
			if(i==15)
			bProblemsList.setList15(breakPList);
			if(i==16)
			bProblemsList.setList16(breakPList);
			if(i==17)
			bProblemsList.setList17(breakPList);
			if(i==18)
			bProblemsList.setList18(breakPList);
			if(i==19)
			bProblemsList.setList19(breakPList);
			if(i==20)
			bProblemsList.setList20(breakPList);
			if(i==21)
			bProblemsList.setList21(breakPList);
			if(i==22)
			bProblemsList.setList22(breakPList);
			if(i==23)
			bProblemsList.setList23(breakPList);
			if(i==24)
			bProblemsList.setList24(breakPList);
			if(i==25)
			bProblemsList.setList25(breakPList);
			if(i==26)
			bProblemsList.setList26(breakPList);
			if(i==27)
			bProblemsList.setList27(breakPList);
			if(i==28)
			bProblemsList.setList28(breakPList);
			if(i==29)
			bProblemsList.setList29(breakPList);
			if(i==30)
			bProblemsList.setList30(breakPList);

			
		}System.err.println("bProblemsList"+bProblemsList.toString());
		dailyGraphData.setbProblemsList(bProblemsList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dailyGraphData;
		
	}
	@RequestMapping(value = "/getARankDailyBreakdowns", method = RequestMethod.POST)
	public @ResponseBody DailyGraphData getARankDailyBreakdowns(@RequestParam("month") String month,@RequestParam("graphType") int graphType,@RequestParam("deptId") int deptId) {
		BreakdownProblemsList bProblemsList=new BreakdownProblemsList();

		DailyGraphData dailyGraphData=new DailyGraphData();
		try {
		String str[] = month.split("-");
		int yearInt = Integer.parseInt(str[0]);
		int monthInt = Integer.parseInt(str[1]);
		DailySearchedTarget dSearchedTarget=null;
		if(monthInt<4)
		{
			int ofYear=yearInt;
			 dSearchedTarget=dailySearchedTargetRepository.getDailyTarget(graphType,ofYear,deptId);
			 dailyGraphData.setdSearchedTarget(dSearchedTarget);
		}
		else {
			  int ofYear=yearInt+1;
			 dSearchedTarget=dailySearchedTargetRepository.getDailyTarget(graphType,ofYear,deptId);
			 dailyGraphData.setdSearchedTarget(dSearchedTarget);

		}
		DailyBreakdowns dailyBreakdownsRes=dailyBreakdownRepository.getARankDailyBreakdowns(
				month+"-01",month+"-02",month+"-03",month+"-04",
				month+"-05",month+"-06",month+"-07",month+"-08",
				month+"-09",month+"-10",month+"-11",month+"-12",
				month+"-13",month+"-14",month+"-15",month+"-16",
				month+"-17",month+"-18",month+"-19",month+"-20",
				month+"-21",month+"-22",month+"-23",month+"-24",
				month+"-25",month+"-26",month+"-27",month+"-28",
				month+"-29",month+"-30",deptId);
		 dailyGraphData.setDailyBreakdowns(dailyBreakdownsRes);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyARankBreakdownMachineDetails(month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			dailyGraphData.setbProblemsList(bProblemsList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dailyGraphData;
		
	}
	@RequestMapping(value = "/getAllBrekDailyBreakdowns", method = RequestMethod.POST)
	public @ResponseBody DailyGraphData getAllBrekDailyBreakdowns(@RequestParam("month") String month,@RequestParam("graphType") int graphType,@RequestParam("deptId") int deptId) {
		BreakdownProblemsList bProblemsList=new BreakdownProblemsList();

		DailyGraphData dailyGraphData=new DailyGraphData();
		try {
		String str[] = month.split("-");
		int yearInt = Integer.parseInt(str[0]);
		int monthInt = Integer.parseInt(str[1]);
		DailySearchedTarget dSearchedTarget=null;
		if(monthInt<4)
		{
			int ofYear=yearInt;
			 dSearchedTarget=dailySearchedTargetRepository.getDailyTarget(graphType,ofYear,deptId);
			 dailyGraphData.setdSearchedTarget(dSearchedTarget);
		}
		else {
			int ofYear=yearInt+1;
			 dSearchedTarget=dailySearchedTargetRepository.getDailyTarget(graphType,ofYear,deptId);
			 dailyGraphData.setdSearchedTarget(dSearchedTarget);

		}
		DailyBreakdowns dailyBreakdownsRes=dailyBreakdownRepository.getAllBrekDailyBreakdowns(
				month+"-01",month+"-02",month+"-03",month+"-04",
				month+"-05",month+"-06",month+"-07",month+"-08",
				month+"-09",month+"-10",month+"-11",month+"-12",
				month+"-13",month+"-14",month+"-15",month+"-16",
				month+"-17",month+"-18",month+"-19",month+"-20",
				month+"-21",month+"-22",month+"-23",month+"-24",
				month+"-25",month+"-26",month+"-27",month+"-28",
				month+"-29",month+"-30",deptId);
		dailyGraphData.setDailyBreakdowns(dailyBreakdownsRes);
		for(int i=01;i<=30;i++)
		{
			List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyAllBreakdownMachineDetails(month+"-"+i,deptId);
			if(i==1)
			bProblemsList.setList1(breakPList);
			if(i==2)
			bProblemsList.setList2(breakPList);
			if(i==3)
			bProblemsList.setList3(breakPList);
			if(i==4)
			bProblemsList.setList4(breakPList);
			if(i==5)
			bProblemsList.setList5(breakPList);
			if(i==6)
			bProblemsList.setList6(breakPList);
			if(i==7)
			bProblemsList.setList7(breakPList);
			if(i==8)
			bProblemsList.setList8(breakPList);
			if(i==9)
			bProblemsList.setList9(breakPList);
			if(i==10)
			bProblemsList.setList10(breakPList);
			if(i==11)
			bProblemsList.setList11(breakPList);
			if(i==12)
			bProblemsList.setList12(breakPList);
			if(i==13)
			bProblemsList.setList13(breakPList);
			if(i==14)
			bProblemsList.setList14(breakPList);
			if(i==15)
			bProblemsList.setList15(breakPList);
			if(i==16)
			bProblemsList.setList16(breakPList);
			if(i==17)
			bProblemsList.setList17(breakPList);
			if(i==18)
			bProblemsList.setList18(breakPList);
			if(i==19)
			bProblemsList.setList19(breakPList);
			if(i==20)
			bProblemsList.setList20(breakPList);
			if(i==21)
			bProblemsList.setList21(breakPList);
			if(i==22)
			bProblemsList.setList22(breakPList);
			if(i==23)
			bProblemsList.setList23(breakPList);
			if(i==24)
			bProblemsList.setList24(breakPList);
			if(i==25)
			bProblemsList.setList25(breakPList);
			if(i==26)
			bProblemsList.setList26(breakPList);
			if(i==27)
			bProblemsList.setList27(breakPList);
			if(i==28)
			bProblemsList.setList28(breakPList);
			if(i==29)
			bProblemsList.setList29(breakPList);
			if(i==30)
			bProblemsList.setList30(breakPList);

			
		}System.err.println("bProblemsList"+bProblemsList.toString());
		dailyGraphData.setbProblemsList(bProblemsList);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dailyGraphData;
		
	}
	@RequestMapping(value = "/getYearwiseBreakdowns", method = RequestMethod.POST)
	public @ResponseBody YearlyMachinBreakdownList getYearwiseBreakdowns(@RequestParam("graphType") int graphType,
			 @RequestParam("month") int month,@RequestParam("year") int year,@RequestParam("deptId") int deptId) {
		
		YearlyMachinBreakdownList yearlyList=new YearlyMachinBreakdownList();
		BreakdownProblemsList bProblemsList=new BreakdownProblemsList();
		BreakdownYearly breakdownYearlyRes=null;
		MachineL5Target machineL5TargetRes=null;
		MachineL3Target machineL3TargetRes=null;
        DailyBreakdowns dailyBreakdownsRes=null;
		if(month<4)
		{
			String toFourthYear=year+"-03-31";
			int fromFourth=year-1;
			String fromFourthYear=fromFourth+"-04-01";
			String toThirdYear=fromFourth+"-03-31";
			int fromThird=year-2;
			String fromThirdYear=fromThird+"-04-01";
			String toSecondYear=fromThird+"-03-31";
			int fromSecond=year-3;
			String fromSecondYear=fromSecond+"-04-01";
			String toFirstYear=fromSecond+"-03-31";
			int fromFirst=year-4;
			String fromFirstYear=fromFirst+"-04-01";
			System.out.println( year+""+month+""+fromFirstYear+""+ toFirstYear+""+fromSecondYear+""+toSecondYear+""+fromThirdYear+""+toThirdYear+""+fromFourthYear+""+toFourthYear);
			breakdownYearlyRes=breakdownYearlyRepository.getYearwiseBreakdowns(fromFirstYear, toFirstYear,fromSecondYear,toSecondYear,fromThirdYear,toThirdYear,fromFourthYear,toFourthYear,deptId);
			machineL5TargetRes=machineL5TargetRepository.getYearlyAssignedL5Target(graphType,fromSecond,fromThird,fromFourth,year,deptId);
			machineL3TargetRes=machineL3TargetRepository.getYearlyAssignedL3Target(graphType,fromSecond,fromThird,fromFourth,year,deptId);
			dailyBreakdownsRes=dailyBreakdownRepository.getDailyBreakdowns(
					year+"-"+month+"-01",year+"-"+month+"-02",year+"-"+month+"-03",year+"-"+month+"-04",
					year+"-"+month+"-05",year+"-"+month+"-06",year+"-"+month+"-07",year+"-"+month+"-08",
					year+"-"+month+"-09",year+"-"+month+"-10",year+"-"+month+"-11",year+"-"+month+"-12",
					year+"-"+month+"-13",year+"-"+month+"-14",year+"-"+month+"-15",year+"-"+month+"-16",
					year+"-"+month+"-17",year+"-"+month+"-18",year+"-"+month+"-19",year+"-"+month+"-20",
					year+"-"+month+"-21",year+"-"+month+"-22",year+"-"+month+"-23",year+"-"+month+"-24",
					year+"-"+month+"-25",year+"-"+month+"-26",year+"-"+month+"-27",year+"-"+month+"-28",
					year+"-"+month+"-29",year+"-"+month+"-30",deptId);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyBreakdownMachineDetails(year+"-"+month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			yearlyList.setbProblemsList(bProblemsList);
			yearlyList.setBreakdownYearly(breakdownYearlyRes);
			 yearlyList.setMachineL5Target(machineL5TargetRes);
			 yearlyList.setMachineL3Target(machineL3TargetRes);
			 yearlyList.setDailyBreakdowns(dailyBreakdownsRes);
		}
		else
		{
			int yearPlus1=year+1;
			String toFourthYear=yearPlus1+"-03-31";
			int fromFourth=yearPlus1-1;
			String fromFourthYear=fromFourth+"-04-01";
			String toThirdYear=fromFourth+"-03-31";
			int fromThird=yearPlus1-2;
			String fromThirdYear=fromThird+"-04-01";
			String toSecondYear=fromThird+"-03-31";
			int fromSecond=yearPlus1-3;
			String fromSecondYear=fromSecond+"-04-01";
			String toFirstYear=fromSecond+"-03-31";
			int fromFirst=yearPlus1-4;
			String fromFirstYear=fromFirst+"-04-01";
			System.out.println(year+""+month+""+ fromFirstYear+""+ toFirstYear+""+fromSecondYear+""+toSecondYear+""+fromThirdYear+""+toThirdYear+""+fromFourthYear+""+toFourthYear);
			breakdownYearlyRes=breakdownYearlyRepository.getYearwiseBreakdowns(fromFirstYear, toFirstYear,fromSecondYear,toSecondYear,fromThirdYear,toThirdYear,fromFourthYear,toFourthYear,deptId);
			machineL5TargetRes=machineL5TargetRepository.getYearlyAssignedL5Target(graphType,fromSecond,fromThird,fromFourth,yearPlus1,deptId);
			machineL3TargetRes=machineL3TargetRepository.getYearlyAssignedL3Target(graphType,fromSecond,fromThird,fromFourth,yearPlus1,deptId);
			dailyBreakdownsRes=dailyBreakdownRepository.getDailyBreakdowns(
					year+"-"+month+"-01",year+"-"+month+"-02",year+"-"+month+"-03",year+"-"+month+"-04",
					year+"-"+month+"-05",year+"-"+month+"-06",year+"-"+month+"-07",year+"-"+month+"-08",
					year+"-"+month+"-09",year+"-"+month+"-10",year+"-"+month+"-11",year+"-"+month+"-12",
					year+"-"+month+"-13",year+"-"+month+"-14",year+"-"+month+"-15",year+"-"+month+"-16",
					year+"-"+month+"-17",year+"-"+month+"-18",year+"-"+month+"-19",year+"-"+month+"-20",
					year+"-"+month+"-21",year+"-"+month+"-22",year+"-"+month+"-23",year+"-"+month+"-24",
					year+"-"+month+"-25",year+"-"+month+"-26",year+"-"+month+"-27",year+"-"+month+"-28",
					year+"-"+month+"-29",year+"-"+month+"-30",deptId);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyBreakdownMachineDetails(year+"-"+month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			yearlyList.setbProblemsList(bProblemsList);
			yearlyList.setBreakdownYearly(breakdownYearlyRes);
			 yearlyList.setMachineL5Target(machineL5TargetRes);
			 yearlyList.setMachineL3Target(machineL3TargetRes);
			 yearlyList.setDailyBreakdowns(dailyBreakdownsRes);
		}
		
		return yearlyList;
		
	}
	@RequestMapping(value = "/getARankYearwiseBreakdowns", method = RequestMethod.POST)
	public @ResponseBody YearlyMachinBreakdownList getARankYearwiseBreakdowns(@RequestParam("graphType") int graphType,
			 @RequestParam("month") int month,@RequestParam("year") int year,@RequestParam("deptId") int deptId) {
		
		YearlyMachinBreakdownList yearlyList=new YearlyMachinBreakdownList();
		BreakdownYearly breakdownYearlyRes=null;
		BreakdownProblemsList bProblemsList=new BreakdownProblemsList();

		MachineL5Target machineL5TargetRes=null;
		MachineL3Target machineL3TargetRes=null;
        DailyBreakdowns dailyBreakdownsRes=null;
		if(month<4)
		{
			String toFourthYear=year+"-03-31";
			int fromFourth=year-1;
			String fromFourthYear=fromFourth+"-04-01";
			String toThirdYear=fromFourth+"-03-31";
			int fromThird=year-2;
			String fromThirdYear=fromThird+"-04-01";
			String toSecondYear=fromThird+"-03-31";
			int fromSecond=year-3;
			String fromSecondYear=fromSecond+"-04-01";
			String toFirstYear=fromSecond+"-03-31";
			int fromFirst=year-4;
			String fromFirstYear=fromFirst+"-04-01";
			System.out.println( year+""+month+""+fromFirstYear+""+ toFirstYear+""+fromSecondYear+""+toSecondYear+""+fromThirdYear+""+toThirdYear+""+fromFourthYear+""+toFourthYear);
			breakdownYearlyRes=breakdownYearlyRepository.getARankYearwiseBreakdowns(fromFirstYear, toFirstYear,fromSecondYear,toSecondYear,fromThirdYear,toThirdYear,fromFourthYear,toFourthYear,deptId);
			machineL5TargetRes=machineL5TargetRepository.getYearlyAssignedL5Target(graphType,fromSecond,fromThird,fromFourth,year,deptId);
			machineL3TargetRes=machineL3TargetRepository.getYearlyAssignedL3Target(graphType,fromSecond,fromThird,fromFourth,year,deptId);
			dailyBreakdownsRes=dailyBreakdownRepository.getARankDailyBreakdowns(
					year+"-"+month+"-01",year+"-"+month+"-02",year+"-"+month+"-03",year+"-"+month+"-04",
					year+"-"+month+"-05",year+"-"+month+"-06",year+"-"+month+"-07",year+"-"+month+"-08",
					year+"-"+month+"-09",year+"-"+month+"-10",year+"-"+month+"-11",year+"-"+month+"-12",
					year+"-"+month+"-13",year+"-"+month+"-14",year+"-"+month+"-15",year+"-"+month+"-16",
					year+"-"+month+"-17",year+"-"+month+"-18",year+"-"+month+"-19",year+"-"+month+"-20",
					year+"-"+month+"-21",year+"-"+month+"-22",year+"-"+month+"-23",year+"-"+month+"-24",
					year+"-"+month+"-25",year+"-"+month+"-26",year+"-"+month+"-27",year+"-"+month+"-28",
					year+"-"+month+"-29",year+"-"+month+"-30",deptId);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyARankBreakdownMachineDetails(year+"-"+month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			yearlyList.setbProblemsList(bProblemsList);
			yearlyList.setBreakdownYearly(breakdownYearlyRes);
			 yearlyList.setMachineL5Target(machineL5TargetRes);
			 yearlyList.setMachineL3Target(machineL3TargetRes);
			 yearlyList.setDailyBreakdowns(dailyBreakdownsRes);
		}
		else
		{
			int yearPlus1=year+1;
			String toFourthYear=yearPlus1+"-03-31";
			int fromFourth=yearPlus1-1;
			String fromFourthYear=fromFourth+"-04-01";
			String toThirdYear=fromFourth+"-03-31";
			int fromThird=yearPlus1-2;
			String fromThirdYear=fromThird+"-04-01";
			String toSecondYear=fromThird+"-03-31";
			int fromSecond=yearPlus1-3;
			String fromSecondYear=fromSecond+"-04-01";
			String toFirstYear=fromSecond+"-03-31";
			int fromFirst=yearPlus1-4;
			String fromFirstYear=fromFirst+"-04-01";
			System.out.println(year+""+month+""+ fromFirstYear+""+ toFirstYear+""+fromSecondYear+""+toSecondYear+""+fromThirdYear+""+toThirdYear+""+fromFourthYear+""+toFourthYear);
			breakdownYearlyRes=breakdownYearlyRepository.getARankYearwiseBreakdowns(fromFirstYear, toFirstYear,fromSecondYear,toSecondYear,fromThirdYear,toThirdYear,fromFourthYear,toFourthYear,deptId);
			machineL5TargetRes=machineL5TargetRepository.getYearlyAssignedL5Target(graphType,fromSecond,fromThird,fromFourth,yearPlus1,deptId);
			machineL3TargetRes=machineL3TargetRepository.getYearlyAssignedL3Target(graphType,fromSecond,fromThird,fromFourth,yearPlus1,deptId);
			dailyBreakdownsRes=dailyBreakdownRepository.getARankDailyBreakdowns(
					year+"-"+month+"-01",year+"-"+month+"-02",year+"-"+month+"-03",year+"-"+month+"-04",
					year+"-"+month+"-05",year+"-"+month+"-06",year+"-"+month+"-07",year+"-"+month+"-08",
					year+"-"+month+"-09",year+"-"+month+"-10",year+"-"+month+"-11",year+"-"+month+"-12",
					year+"-"+month+"-13",year+"-"+month+"-14",year+"-"+month+"-15",year+"-"+month+"-16",
					year+"-"+month+"-17",year+"-"+month+"-18",year+"-"+month+"-19",year+"-"+month+"-20",
					year+"-"+month+"-21",year+"-"+month+"-22",year+"-"+month+"-23",year+"-"+month+"-24",
					year+"-"+month+"-25",year+"-"+month+"-26",year+"-"+month+"-27",year+"-"+month+"-28",
					year+"-"+month+"-29",year+"-"+month+"-30",deptId);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyARankBreakdownMachineDetails(year+"-"+month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			yearlyList.setbProblemsList(bProblemsList);
			yearlyList.setBreakdownYearly(breakdownYearlyRes);
			 yearlyList.setMachineL5Target(machineL5TargetRes);
			 yearlyList.setMachineL3Target(machineL3TargetRes);
			 yearlyList.setDailyBreakdowns(dailyBreakdownsRes);
		}
		
		return yearlyList;
		
	}
	@RequestMapping(value = "/getAllBrekYearwiseBreakdowns", method = RequestMethod.POST)
	public @ResponseBody YearlyMachinBreakdownList getAllBrekYearwiseBreakdowns(@RequestParam("graphType") int graphType,
			 @RequestParam("month") int month,@RequestParam("year") int year,@RequestParam("deptId") int deptId) {
		
		YearlyMachinBreakdownList yearlyList=new YearlyMachinBreakdownList();
		BreakdownProblemsList bProblemsList=new BreakdownProblemsList();

		BreakdownYearly breakdownYearlyRes=null;
		MachineL5Target machineL5TargetRes=null;
		MachineL3Target machineL3TargetRes=null;
        DailyBreakdowns dailyBreakdownsRes=null;
		if(month<4)
		{
			String toFourthYear=year+"-03-31";
			int fromFourth=year-1;
			String fromFourthYear=fromFourth+"-04-01";
			String toThirdYear=fromFourth+"-03-31";
			int fromThird=year-2;
			String fromThirdYear=fromThird+"-04-01";
			String toSecondYear=fromThird+"-03-31";
			int fromSecond=year-3;
			String fromSecondYear=fromSecond+"-04-01";
			String toFirstYear=fromSecond+"-03-31";
			int fromFirst=year-4;
			String fromFirstYear=fromFirst+"-04-01";
			System.out.println( year+""+month+""+fromFirstYear+""+ toFirstYear+""+fromSecondYear+""+toSecondYear+""+fromThirdYear+""+toThirdYear+""+fromFourthYear+""+toFourthYear);
			breakdownYearlyRes=breakdownYearlyRepository.getAllBrekYearwiseBreakdowns(fromFirstYear, toFirstYear,fromSecondYear,toSecondYear,fromThirdYear,toThirdYear,fromFourthYear,toFourthYear,deptId);
			machineL5TargetRes=machineL5TargetRepository.getYearlyAssignedL5Target(graphType,fromSecond,fromThird,fromFourth,year,deptId);
			machineL3TargetRes=machineL3TargetRepository.getYearlyAssignedL3Target(graphType,fromSecond,fromThird,fromFourth,year,deptId);
			dailyBreakdownsRes=dailyBreakdownRepository.getAllBrekDailyBreakdowns(
					year+"-"+month+"-01",year+"-"+month+"-02",year+"-"+month+"-03",year+"-"+month+"-04",
					year+"-"+month+"-05",year+"-"+month+"-06",year+"-"+month+"-07",year+"-"+month+"-08",
					year+"-"+month+"-09",year+"-"+month+"-10",year+"-"+month+"-11",year+"-"+month+"-12",
					year+"-"+month+"-13",year+"-"+month+"-14",year+"-"+month+"-15",year+"-"+month+"-16",
					year+"-"+month+"-17",year+"-"+month+"-18",year+"-"+month+"-19",year+"-"+month+"-20",
					year+"-"+month+"-21",year+"-"+month+"-22",year+"-"+month+"-23",year+"-"+month+"-24",
					year+"-"+month+"-25",year+"-"+month+"-26",year+"-"+month+"-27",year+"-"+month+"-28",
					year+"-"+month+"-29",year+"-"+month+"-30",deptId);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyAllBreakdownMachineDetails(year+"-"+month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			yearlyList.setbProblemsList(bProblemsList);

			yearlyList.setBreakdownYearly(breakdownYearlyRes);
			 yearlyList.setMachineL5Target(machineL5TargetRes);
			 yearlyList.setMachineL3Target(machineL3TargetRes);
			 yearlyList.setDailyBreakdowns(dailyBreakdownsRes);
		}
		else
		{
			int yearPlus1=year+1;
			String toFourthYear=yearPlus1+"-03-31";
			int fromFourth=yearPlus1-1;
			String fromFourthYear=fromFourth+"-04-01";
			String toThirdYear=fromFourth+"-03-31";
			int fromThird=yearPlus1-2;
			String fromThirdYear=fromThird+"-04-01";
			String toSecondYear=fromThird+"-03-31";
			int fromSecond=yearPlus1-3;
			String fromSecondYear=fromSecond+"-04-01";
			String toFirstYear=fromSecond+"-03-31";
			int fromFirst=yearPlus1-4;
			String fromFirstYear=fromFirst+"-04-01";
			System.out.println(year+""+month+""+ fromFirstYear+""+ toFirstYear+""+fromSecondYear+""+toSecondYear+""+fromThirdYear+""+toThirdYear+""+fromFourthYear+""+toFourthYear);
			breakdownYearlyRes=breakdownYearlyRepository.getAllBrekYearwiseBreakdowns(fromFirstYear, toFirstYear,fromSecondYear,toSecondYear,fromThirdYear,toThirdYear,fromFourthYear,toFourthYear,deptId);
			machineL5TargetRes=machineL5TargetRepository.getYearlyAssignedL5Target(graphType,fromSecond,fromThird,fromFourth,yearPlus1,deptId);
			machineL3TargetRes=machineL3TargetRepository.getYearlyAssignedL3Target(graphType,fromSecond,fromThird,fromFourth,yearPlus1,deptId);
			dailyBreakdownsRes=dailyBreakdownRepository.getAllBrekDailyBreakdowns(
					year+"-"+month+"-01",year+"-"+month+"-02",year+"-"+month+"-03",year+"-"+month+"-04",
					year+"-"+month+"-05",year+"-"+month+"-06",year+"-"+month+"-07",year+"-"+month+"-08",
					year+"-"+month+"-09",year+"-"+month+"-10",year+"-"+month+"-11",year+"-"+month+"-12",
					year+"-"+month+"-13",year+"-"+month+"-14",year+"-"+month+"-15",year+"-"+month+"-16",
					year+"-"+month+"-17",year+"-"+month+"-18",year+"-"+month+"-19",year+"-"+month+"-20",
					year+"-"+month+"-21",year+"-"+month+"-22",year+"-"+month+"-23",year+"-"+month+"-24",
					year+"-"+month+"-25",year+"-"+month+"-26",year+"-"+month+"-27",year+"-"+month+"-28",
					year+"-"+month+"-29",year+"-"+month+"-30",deptId);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyAllBreakdownMachineDetails(year+"-"+month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			yearlyList.setbProblemsList(bProblemsList);

			yearlyList.setBreakdownYearly(breakdownYearlyRes);
			 yearlyList.setMachineL5Target(machineL5TargetRes);
			 yearlyList.setMachineL3Target(machineL3TargetRes);
			 yearlyList.setDailyBreakdowns(dailyBreakdownsRes);
		}
		
		return yearlyList;
		
	}
	@RequestMapping(value = "/getYearwiseBreakdownTime", method = RequestMethod.POST)
	public @ResponseBody YearlyMachineBdTimeList getYearwiseBreakdownTime(@RequestParam("graphType") int graphType,
			 @RequestParam("month") int month,@RequestParam("year") int year,@RequestParam("deptId") int deptId) {
		BreakdownProblemsList bProblemsList=new BreakdownProblemsList();

		YearlyMachineBdTimeList yearlyList=new YearlyMachineBdTimeList();
		BreakdownTimeYearly breakdownTimeYearlyRes=null;
		MachineL5TimeTarget machineL5TimeTargetRes=null;
		MachineL3TimeTarget machineL3TimeTargetRes=null;
        DailyBreakdowns dailyBreakdownsRes=null;
		if(month<4)
		{
			String toFourthYear=year+"-03-31";
			int fromFourth=year-1;
			String fromFourthYear=fromFourth+"-04-01";
			String toThirdYear=fromFourth+"-03-31";
			int fromThird=year-2;
			String fromThirdYear=fromThird+"-04-01";
			String toSecondYear=fromThird+"-03-31";
			int fromSecond=year-3;
			String fromSecondYear=fromSecond+"-04-01";
			String toFirstYear=fromSecond+"-03-31";
			int fromFirst=year-4;
			String fromFirstYear=fromFirst+"-04-01";
			System.out.println( year+""+month+""+fromFirstYear+""+ toFirstYear+""+fromSecondYear+""+toSecondYear+""+fromThirdYear+""+toThirdYear+""+fromFourthYear+""+toFourthYear);
			breakdownTimeYearlyRes=breakdownYearlyTimeRepository.getAllBrekYearwiseBreakdownTime(fromFirstYear, toFirstYear,fromSecondYear,toSecondYear,fromThirdYear,toThirdYear,fromFourthYear,toFourthYear,deptId);
			machineL5TimeTargetRes=machineL5TimeTargetRepository.getYearlyAssignedL5TargetTime(graphType,fromSecond,fromThird,fromFourth,year,deptId);
			machineL3TimeTargetRes=machineL3TimeTargetRepository.getYearlyAssignedL3TargetTime(graphType,fromSecond,fromThird,fromFourth,year,deptId);
			dailyBreakdownsRes=dailyBreakdownRepository.getAllBrekDailyBreakdownsTime(
					year+"-"+month+"-01",year+"-"+month+"-02",year+"-"+month+"-03",year+"-"+month+"-04",
					year+"-"+month+"-05",year+"-"+month+"-06",year+"-"+month+"-07",year+"-"+month+"-08",
					year+"-"+month+"-09",year+"-"+month+"-10",year+"-"+month+"-11",year+"-"+month+"-12",
					year+"-"+month+"-13",year+"-"+month+"-14",year+"-"+month+"-15",year+"-"+month+"-16",
					year+"-"+month+"-17",year+"-"+month+"-18",year+"-"+month+"-19",year+"-"+month+"-20",
					year+"-"+month+"-21",year+"-"+month+"-22",year+"-"+month+"-23",year+"-"+month+"-24",
					year+"-"+month+"-25",year+"-"+month+"-26",year+"-"+month+"-27",year+"-"+month+"-28",
					year+"-"+month+"-29",year+"-"+month+"-30",deptId);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyAllBreakdownMachineDetails(year+"-"+month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			yearlyList.setbProblemsList(bProblemsList);
			yearlyList.setBreakdownYearly(breakdownTimeYearlyRes);
			 yearlyList.setMachineL5Target(machineL5TimeTargetRes);
			 yearlyList.setMachineL3Target(machineL3TimeTargetRes);
			 yearlyList.setDailyBreakdowns(dailyBreakdownsRes);
		}
		else
		{
			int yearPlus1=year+1;
			String toFourthYear=yearPlus1+"-03-31";
			int fromFourth=yearPlus1-1;
			String fromFourthYear=fromFourth+"-04-01";
			String toThirdYear=fromFourth+"-03-31";
			int fromThird=yearPlus1-2;
			String fromThirdYear=fromThird+"-04-01";
			String toSecondYear=fromThird+"-03-31";
			int fromSecond=yearPlus1-3;
			String fromSecondYear=fromSecond+"-04-01";
			String toFirstYear=fromSecond+"-03-31";
			int fromFirst=yearPlus1-4;
			String fromFirstYear=fromFirst+"-04-01";
			System.out.println(year+""+month+""+ fromFirstYear+""+ toFirstYear+""+fromSecondYear+""+toSecondYear+""+fromThirdYear+""+toThirdYear+""+fromFourthYear+""+toFourthYear);
			breakdownTimeYearlyRes=breakdownYearlyTimeRepository.getAllBrekYearwiseBreakdownTime(fromFirstYear, toFirstYear,fromSecondYear,toSecondYear,fromThirdYear,toThirdYear,fromFourthYear,toFourthYear,deptId);
			machineL5TimeTargetRes=machineL5TimeTargetRepository.getYearlyAssignedL5TargetTime(graphType,fromSecond,fromThird,fromFourth,yearPlus1,deptId);
			machineL3TimeTargetRes=machineL3TimeTargetRepository.getYearlyAssignedL3TargetTime(graphType,fromSecond,fromThird,fromFourth,yearPlus1,deptId);
			dailyBreakdownsRes=dailyBreakdownRepository.getAllBrekDailyBreakdownsTime(
					year+"-"+month+"-01",year+"-"+month+"-02",year+"-"+month+"-03",year+"-"+month+"-04",
					year+"-"+month+"-05",year+"-"+month+"-06",year+"-"+month+"-07",year+"-"+month+"-08",
					year+"-"+month+"-09",year+"-"+month+"-10",year+"-"+month+"-11",year+"-"+month+"-12",
					year+"-"+month+"-13",year+"-"+month+"-14",year+"-"+month+"-15",year+"-"+month+"-16",
					year+"-"+month+"-17",year+"-"+month+"-18",year+"-"+month+"-19",year+"-"+month+"-20",
					year+"-"+month+"-21",year+"-"+month+"-22",year+"-"+month+"-23",year+"-"+month+"-24",
					year+"-"+month+"-25",year+"-"+month+"-26",year+"-"+month+"-27",year+"-"+month+"-28",
					year+"-"+month+"-29",year+"-"+month+"-30",deptId);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyAllBreakdownMachineDetails(year+"-"+month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			yearlyList.setbProblemsList(bProblemsList);
			yearlyList.setBreakdownYearly(breakdownTimeYearlyRes);
			 yearlyList.setMachineL5Target(machineL5TimeTargetRes);
			 yearlyList.setMachineL3Target(machineL3TimeTargetRes);
			 yearlyList.setDailyBreakdowns(dailyBreakdownsRes);
		}
		
		return yearlyList;
		
	}
	@RequestMapping(value = "/getYearwiseBreakdownELoss", method = RequestMethod.POST)
	public @ResponseBody YearlyMachineBdTimeList getYearwiseBreakdownELoss(@RequestParam("graphType") int graphType,
			 @RequestParam("month") int month,@RequestParam("year") int year,@RequestParam("deptId") int deptId) {
		
		BreakdownProblemsList bProblemsList=new BreakdownProblemsList();

		YearlyMachineBdTimeList yearlyList=new YearlyMachineBdTimeList();
		BreakdownTimeYearly breakdownTimeYearlyRes=null;
		MachineL5TimeTarget machineL5TimeTargetRes=null;
		MachineL3TimeTarget machineL3TimeTargetRes=null;
        DailyBreakdowns dailyBreakdownsRes=null;
		if(month<4)
		{
			String toFourthYear=year+"-03-31";
			int fromFourth=year-1;
			String fromFourthYear=fromFourth+"-04-01";
			String toThirdYear=fromFourth+"-03-31";
			int fromThird=year-2;
			String fromThirdYear=fromThird+"-04-01";
			String toSecondYear=fromThird+"-03-31";
			int fromSecond=year-3;
			String fromSecondYear=fromSecond+"-04-01";
			String toFirstYear=fromSecond+"-03-31";
			int fromFirst=year-4;
			String fromFirstYear=fromFirst+"-04-01";
			System.out.println( year+""+month+""+fromFirstYear+""+ toFirstYear+""+fromSecondYear+""+toSecondYear+""+fromThirdYear+""+toThirdYear+""+fromFourthYear+""+toFourthYear);
			breakdownTimeYearlyRes=breakdownYearlyTimeRepository.getAllBrekYearwiseBreakdownELoss(fromFirstYear, toFirstYear,fromSecondYear,toSecondYear,fromThirdYear,toThirdYear,fromFourthYear,toFourthYear,deptId);
			machineL5TimeTargetRes=machineL5TimeTargetRepository.getYearlyAssignedL5TargetTime(graphType,fromSecond,fromThird,fromFourth,year,deptId);
			machineL3TimeTargetRes=machineL3TimeTargetRepository.getYearlyAssignedL3TargetTime(graphType,fromSecond,fromThird,fromFourth,year,deptId);
			dailyBreakdownsRes=dailyBreakdownRepository.getAllBrekDailyBreakdownsELoss(
					year+"-"+month+"-01",year+"-"+month+"-02",year+"-"+month+"-03",year+"-"+month+"-04",
					year+"-"+month+"-05",year+"-"+month+"-06",year+"-"+month+"-07",year+"-"+month+"-08",
					year+"-"+month+"-09",year+"-"+month+"-10",year+"-"+month+"-11",year+"-"+month+"-12",
					year+"-"+month+"-13",year+"-"+month+"-14",year+"-"+month+"-15",year+"-"+month+"-16",
					year+"-"+month+"-17",year+"-"+month+"-18",year+"-"+month+"-19",year+"-"+month+"-20",
					year+"-"+month+"-21",year+"-"+month+"-22",year+"-"+month+"-23",year+"-"+month+"-24",
					year+"-"+month+"-25",year+"-"+month+"-26",year+"-"+month+"-27",year+"-"+month+"-28",
					year+"-"+month+"-29",year+"-"+month+"-30",deptId);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyAllBreakdownMachineDetails(year+"-"+month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			yearlyList.setbProblemsList(bProblemsList);
			yearlyList.setBreakdownYearly(breakdownTimeYearlyRes);
			 yearlyList.setMachineL5Target(machineL5TimeTargetRes);
			 yearlyList.setMachineL3Target(machineL3TimeTargetRes);
			 yearlyList.setDailyBreakdowns(dailyBreakdownsRes);
		}
		else
		{
			int yearPlus1=year+1;
			String toFourthYear=yearPlus1+"-03-31";
			int fromFourth=yearPlus1-1;
			String fromFourthYear=fromFourth+"-04-01";
			String toThirdYear=fromFourth+"-03-31";
			int fromThird=yearPlus1-2;
			String fromThirdYear=fromThird+"-04-01";
			String toSecondYear=fromThird+"-03-31";
			int fromSecond=yearPlus1-3;
			String fromSecondYear=fromSecond+"-04-01";
			String toFirstYear=fromSecond+"-03-31";
			int fromFirst=yearPlus1-4;
			String fromFirstYear=fromFirst+"-04-01";
			System.out.println(year+""+month+""+ fromFirstYear+""+ toFirstYear+""+fromSecondYear+""+toSecondYear+""+fromThirdYear+""+toThirdYear+""+fromFourthYear+""+toFourthYear);
			breakdownTimeYearlyRes=breakdownYearlyTimeRepository.getAllBrekYearwiseBreakdownELoss(fromFirstYear, toFirstYear,fromSecondYear,toSecondYear,fromThirdYear,toThirdYear,fromFourthYear,toFourthYear,deptId);
			machineL5TimeTargetRes=machineL5TimeTargetRepository.getYearlyAssignedL5TargetTime(graphType,fromSecond,fromThird,fromFourth,yearPlus1,deptId);
			machineL3TimeTargetRes=machineL3TimeTargetRepository.getYearlyAssignedL3TargetTime(graphType,fromSecond,fromThird,fromFourth,yearPlus1,deptId);
			dailyBreakdownsRes=dailyBreakdownRepository.getAllBrekDailyBreakdownsELoss(
					year+"-"+month+"-01",year+"-"+month+"-02",year+"-"+month+"-03",year+"-"+month+"-04",
					year+"-"+month+"-05",year+"-"+month+"-06",year+"-"+month+"-07",year+"-"+month+"-08",
					year+"-"+month+"-09",year+"-"+month+"-10",year+"-"+month+"-11",year+"-"+month+"-12",
					year+"-"+month+"-13",year+"-"+month+"-14",year+"-"+month+"-15",year+"-"+month+"-16",
					year+"-"+month+"-17",year+"-"+month+"-18",year+"-"+month+"-19",year+"-"+month+"-20",
					year+"-"+month+"-21",year+"-"+month+"-22",year+"-"+month+"-23",year+"-"+month+"-24",
					year+"-"+month+"-25",year+"-"+month+"-26",year+"-"+month+"-27",year+"-"+month+"-28",
					year+"-"+month+"-29",year+"-"+month+"-30",deptId);
			for(int i=01;i<=30;i++)
			{
				List<BreakdownProblems>	breakPList=breakdownProblemsListRepository.getDailyAllBreakdownMachineDetails(year+"-"+month+"-"+i,deptId);
				if(i==1)
				bProblemsList.setList1(breakPList);
				if(i==2)
				bProblemsList.setList2(breakPList);
				if(i==3)
				bProblemsList.setList3(breakPList);
				if(i==4)
				bProblemsList.setList4(breakPList);
				if(i==5)
				bProblemsList.setList5(breakPList);
				if(i==6)
				bProblemsList.setList6(breakPList);
				if(i==7)
				bProblemsList.setList7(breakPList);
				if(i==8)
				bProblemsList.setList8(breakPList);
				if(i==9)
				bProblemsList.setList9(breakPList);
				if(i==10)
				bProblemsList.setList10(breakPList);
				if(i==11)
				bProblemsList.setList11(breakPList);
				if(i==12)
				bProblemsList.setList12(breakPList);
				if(i==13)
				bProblemsList.setList13(breakPList);
				if(i==14)
				bProblemsList.setList14(breakPList);
				if(i==15)
				bProblemsList.setList15(breakPList);
				if(i==16)
				bProblemsList.setList16(breakPList);
				if(i==17)
				bProblemsList.setList17(breakPList);
				if(i==18)
				bProblemsList.setList18(breakPList);
				if(i==19)
				bProblemsList.setList19(breakPList);
				if(i==20)
				bProblemsList.setList20(breakPList);
				if(i==21)
				bProblemsList.setList21(breakPList);
				if(i==22)
				bProblemsList.setList22(breakPList);
				if(i==23)
				bProblemsList.setList23(breakPList);
				if(i==24)
				bProblemsList.setList24(breakPList);
				if(i==25)
				bProblemsList.setList25(breakPList);
				if(i==26)
				bProblemsList.setList26(breakPList);
				if(i==27)
				bProblemsList.setList27(breakPList);
				if(i==28)
				bProblemsList.setList28(breakPList);
				if(i==29)
				bProblemsList.setList29(breakPList);
				if(i==30)
				bProblemsList.setList30(breakPList);

				
			}System.err.println("bProblemsList"+bProblemsList.toString());
			yearlyList.setbProblemsList(bProblemsList);
			yearlyList.setBreakdownYearly(breakdownTimeYearlyRes);
			 yearlyList.setMachineL5Target(machineL5TimeTargetRes);
			 yearlyList.setMachineL3Target(machineL3TimeTargetRes);
			 yearlyList.setDailyBreakdowns(dailyBreakdownsRes);
		}
		
		return yearlyList;
		
	}
	
	
	@RequestMapping(value = { "/updatePmDetailList" }, method = RequestMethod.POST)
	@ResponseBody
	public List<PaMaintananceDetails> insertPMaintananceDetails(@RequestBody List<PaMaintananceDetails> paMaintananceDetails) 
	{
		List<PaMaintananceDetails> save = new ArrayList<>();
		
		try {
			
			
			save = paMaintananceDetailsRepository.save(paMaintananceDetails);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return save;
	}
	
}
