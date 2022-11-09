package com.ae.qa.testcasesWorkflowAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WorkflowAdmin.SchedulerPageWA;
import com.ae.qa.pagesTenantAdmin.SchedulerPageTA;
import com.ae.qa.util.ExcelHandler;


public class SchedulerPageTestWA extends TestBase{
	SchedulerPageWA schedulerpagewa;

	public SchedulerPageTestWA() {
		super();
	}

	@Test(priority=51)
	public void validateDailyScheduleWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDailyScheduleWATest", "TC_38: Verify user can create daily schedule for a day and only at once");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateDailyScheduleWA(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"),
				TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("ScheduleExecHH"),TestDataInMap.get("ScheduleExecMM"));
		extentTest.log(extentTest.getStatus(), "User created daily schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=52)
	public void validateEditDailyScheduleWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditDailyScheduleWATest", "TC_41: Verify user can edit schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateEditDailyScheduleWA(TestDataInMap.get("ScheduleName"),
				TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"),TestDataInMap.get("RepeatAfter"),
				TestDataInMap.get("RepeatPeriod"),TestDataInMap.get("EndTimeHR"),TestDataInMap.get("EndTimeMinute"));
		extentTest.log(extentTest.getStatus(), "User edited daily schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=53, alwaysRun=true)
	public void validateWeeklyScheduleWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateWeeklyScheduleWATest", "TC_42: Verify weekly schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateWeeklyScheduleWA(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"),
				TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("ScheduleExecHH"),TestDataInMap.get("ScheduleExecMM"),TestDataInMap.get("ScheduleDay"),
				TestDataInMap.get("RepeatAfter"),TestDataInMap.get("RepeatPeriod"),TestDataInMap.get("EndTimeHR"),TestDataInMap.get("EndTimeMinute"));
		extentTest.log(extentTest.getStatus(), "User created weekly schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=54)
	public void validateEditWeeklyScheduleWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditWeeklyScheduleWA", "TC_43: Verify edit weekly schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateEditWeeklyScheduleWA(TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDay"),
				TestDataInMap.get("RepeatAfter"),TestDataInMap.get("RepeatPeriod"));
		extentTest.log(extentTest.getStatus(), "User created weekly schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=55,alwaysRun=true)
	public void validateMonthlyScheduleWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateMonthlyScheduleWATest", "TC_44:To Verify create monthly schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateMonthlyScheduleWA(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"),
				TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("SchedStartTime"),TestDataInMap.get("SchedMonth"),TestDataInMap.get("SchedDayOfMonth"),
				TestDataInMap.get("RepeatAfter"),TestDataInMap.get("RepeatPeriod"),TestDataInMap.get("EndTimeHR"));
		extentTest.log(extentTest.getStatus(), "User created monthly schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=56,alwaysRun=true)
	public void validateEditMonthlyScheduleWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditMonthlyScheduleWATest", "TC_45: To Verify edit monthly schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateEditMonthlyScheduleWA(TestDataInMap.get("ScheduleName"),TestDataInMap.get("SchedStartTime"),TestDataInMap.get("SchedMonth"));
		extentTest.log(extentTest.getStatus(), "User edited monthly schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=57,alwaysRun=true)
	public void validateInfineScheduleWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateInfineScheduleWATest", "TC_46: Verify user can create infinite schedule with repeat intervals");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateInfineScheduleWA(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("ScheduleExecHH"),TestDataInMap.get("ScheduleExecMM"),TestDataInMap.get("ScheduleDay"),
				TestDataInMap.get("RepeatAfter"),TestDataInMap.get("RepeatPeriod"),TestDataInMap.get("EndTimeHR"),TestDataInMap.get("EndTimeMinute"));
		extentTest.log(extentTest.getStatus(), "User created infinite schedule with repeated interval successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=58,alwaysRun=true)
	public void validateDeleteScheduleWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteScheduleWATest", "TC_47: Verify user can delete schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateDeleteScheduleWA(TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"));
		extentTest.log(extentTest.getStatus(), "User deleted schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=59,alwaysRun=true)
	public void validateEditScheduleCreateTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditScheduleCreateTATest", "TC_48:To Verify edit schedule created by tenant user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateEditScheduleCreateTA(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"),
				TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("ScheduleExecHH"),TestDataInMap.get("ScheduleExecMM"),TestDataInMap.get("RepeatAfter"),
				TestDataInMap.get("RepeatPeriod"),TestDataInMap.get("EndTimeHR"),TestDataInMap.get("EndTimeMinute"));
		extentTest.log(extentTest.getStatus(), "User edited the schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=60,alwaysRun=true)
	public void validateInactiveScheduleCreateTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateInactiveScheduleCreateTATest", "TC_49:To Verify inactive/active schedule created by tenant admin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateInactiveScheduleCreateTA(TestDataInMap.get("ScheduleName"));
		extentTest.log(extentTest.getStatus(), "User made the schedule inactive successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}
	//For Schedule Name
	@Test
	public void validateAdvSearchForScheduleNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForScheduleNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateAdvSearchForScheduleNameEqualTo("Schedule Name","equal to","DailyScheduleWA1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Schedule Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForScheduleNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForScheduleNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateAdvSearchForScheduleNameNotEqualTo("Schedule Name", "not equal to","WeeklySchedule","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Schedule Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForScheduleNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForScheduleNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateAdvSearchForScheduleNameIsLike("Schedule Name", "is like","Schedule","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Schedule Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForScheduleNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForScheduleNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateAdvSearchForScheduleNameBeginsWith("Schedule Name", "begins with","Daily","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Schedule Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForScheduleNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForScheduleNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateAdvSearchForScheduleNameEndsWith("Schedule Name", "ends with","WA1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Schedule Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For Schedule Status 
	@Test
	public void validateStatusDropdownEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateStatusDropdownEqualTo("Status", "equal to","Active","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateStatusDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		schedulerpagewa = new SchedulerPageWA();
		schedulerpagewa.validateStatusDropdownNotEqualTo("Status", "not equal to","Active","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
}
