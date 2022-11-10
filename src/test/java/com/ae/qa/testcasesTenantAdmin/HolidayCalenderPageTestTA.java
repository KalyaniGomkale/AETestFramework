package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.HolidayCalenderPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.ExcelHandler;

public class HolidayCalenderPageTestTA extends TestBase{
	HolidayCalenderPageTA holidaycalenderpageta;
	
	public HolidayCalenderPageTestTA() {
		super();
	}
	
	
	@Test(priority=716)
	public void validateCreateHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateHolidayCalenderTest", "TC_237: To verify whether user is able to provide Holiday dates, weekly day offs  and tag while creating calendar.");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateCreateHolidayCalender("HolidayCalender","For pp","2022","Saturday","WeekOff","2022","Oct","20");
		extentTest.log(extentTest.getStatus(), "Holiday calender is created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=717)
	public void validateCreateHolidayCalenderUpcomingYearTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateHolidayCalenderUpcomingYearTest", "TC_238: To verify whether user is able to create Holiday calendar for the next upcoming years.");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateCreateHolidayCalenderUpcomingYear("HldyCalenderUpcomingYear","For upcoming year","2023","Saturday","WeekOff","2023","Oct","20");
		extentTest.log(extentTest.getStatus(), "Holiday Calender for upcoming year is created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=718)
	public void validateEditHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditHolidayCalenderTest", "TC_240: To verify if user is able to modify weekly days off, existing holiday, tag  on edit of holiday calendar");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateEditHolidayCalender("HldyCalenderUpcomingYear","Sunday","WeeklyOff","2023","Dec","20");
		extentTest.log(extentTest.getStatus(), "Holiday Calender is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=719)
	public void validateRemoveHolidayListDatesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRemoveHolidayListDatesTest", "TC_241: To verify whether user is  able to remove Holiday list dates , weekly days off,  while editing the calendar");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateRemoveHolidayListDates("HldyCalenderUpcomingYear","WeeklyOff","2023","Nov","20");
		extentTest.log(extentTest.getStatus(), "Holiday list dates are removed successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=720)
	public void validateCreateCloneHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateCloneHolidayCalenderTest", "TC_245: Verify if user can create exact duplicate of existing holiday calendar using copy From option");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateCreateCloneHolidayCalender("HolidayCalender","CloneHolidayCalender","For pp","2023");
		extentTest.log(extentTest.getStatus(), "Clone Holiday Calender is created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=721)
	public void validateEditCloneHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditCloneHolidayCalenderTest", "TC_245: To verify whether user is able to change the days after copying the calendar from the last year to new year");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateEditCloneHolidayCalender("CloneHolidayCalender","Friday","2023","Dec","28");
		extentTest.log(extentTest.getStatus(), "Clone Holiday Calender is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=722)
	public void validateRenewHoildayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRenewHoildayCalenderTest", "TC_242: To verify all the last year marked dates for Holiday and Weekly off days get retained in new calendar on renewing the existing calendar");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateRenewHoildayCalender("RenewCalender","For pp","2022","Saturday","WeekOff","2022","Oct","20");
		extentTest.log(extentTest.getStatus(), "Holiday Calender is renewed successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=723)
	public void validateEditRenewHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditRenewHolidayCalenderTest", "TC_243: To verify whether user is able to change Holiday dates, weekly off  in renewed calendar");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateEditRenewHolidayCalender("RenewCalender","Sunday","Dec","20");
		extentTest.log(extentTest.getStatus(), "Renewed Holiday Calender is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=724)
	public void validateRemoveHoildayDatesRenewTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRemoveHoildayDatesRenewTest", "TC_244: To verify whether user is  able to remove Holiday list, Weekly off,  added tag  in renewed calendar");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateRemoveHoildayDatesRenew("RenewCalender","WeeklyOff","Nov","20");
		extentTest.log(extentTest.getStatus(), "Holiday list dates from renewed calender are removed successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=725)
	public void validateDeleteHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteHolidayCalenderTest", "TC_250: To verify delete holiday calendar from the server.");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateDeleteHolidayCalender("HldyCalenderUpcomingYear");
		extentTest.log(extentTest.getStatus(), "Holiay Calender is deleted successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=726)
	public void validateHolidayCalenderPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateHolidayCalenderPageTest", "TC_Additional: To verify holiday calender tab");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateHolidayCalenderPage("Holiday Calendar");
		extentTest.log(extentTest.getStatus(), "Holiay Calender tab is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	
}
