package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.PurgeSchedulePage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;

public class PurgeSchedulePageTest extends TestBase {
	LoginPage loginpage;
	PurgeSchedulePage purgeschedulepage;

	public PurgeSchedulePageTest() {
		super();
	}

	@Test(priority=36)
	public void validatePurgingScheduleDayTest(Method method) throws Exception {
		extentTest = extent.createTest( "validatePurgingScheduleDayTest","TC_066: verify that sysadmin can create a purging schedule for -any day of the month" ); 
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		purgeschedulepage=new PurgeSchedulePage();
		//Specify criteria as Day of the Month,For value specify day  > 7 days from current date and specify start time
		purgeschedulepage.validatePurgingScheduleDay(TestDataInMap.get("Criteria"),TestDataInMap.get("DayOfMonth"),TestDataInMap.get("StartTimeHR"),TestDataInMap.get("StartTimeMin"));
		extentTest.log(extentTest.getStatus(),"SA can create a purging schedule for any day of month successfully"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 37)
	public void validatePurgingScheduleWeekendTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePurgingScheduleWeekendTest","TC_067: To verify validation for weekday purging schedule-day of week");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		purgeschedulepage = new PurgeSchedulePage();
		//purgeschedulepage.validatePurgingScheduleWeekend("Day of Week", "Friday", "Fourth", "4", "2");
		purgeschedulepage.validatePurgingScheduleWeekend(TestDataInMap.get("Criteria"),TestDataInMap.get("DayOfWeek"),TestDataInMap.get("WeekdayOfMonth"),TestDataInMap.get("StartTimeHR"),TestDataInMap.get("StartTimeMin"));
		extentTest.log(extentTest.getStatus(), "SA can create a purging schedule for any day of week successfully");
	}
	@Test(priority=161)
	public void validatePurgeSchedulePageTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePurgeSchedulePageTest", "TC_Additional:Verify Clicking Purge Schedule tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		purgeschedulepage = new PurgeSchedulePage();
		purgeschedulepage.validatePurgeSchedulePage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Purge Schedule page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
