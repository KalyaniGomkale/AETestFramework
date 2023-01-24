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
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateCreateHolidayCalender(TestDataInMap.get("CalenderName"),TestDataInMap.get("CalenderDescrp"),TestDataInMap.get("CalenderYear"),
				TestDataInMap.get("Weekday"),TestDataInMap.get("Tagname"),TestDataInMap.get("startYear"),TestDataInMap.get("startMonth"),TestDataInMap.get("startDate"));
		extentTest.log(extentTest.getStatus(), "Holiday calender is created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=717)
	public void validateCreateHolidayCalenderUpcomingYearTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateHolidayCalenderUpcomingYearTest", "TC_238: To verify whether user is able to create Holiday calendar for the next upcoming years.");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateCreateHolidayCalenderUpcomingYear(TestDataInMap.get("CalenderName"),TestDataInMap.get("CalenderDescrp"),TestDataInMap.get("CalenderYear"),
				TestDataInMap.get("Weekday"),TestDataInMap.get("Tagname"),TestDataInMap.get("startYear"),TestDataInMap.get("startMonth"),TestDataInMap.get("startDate"));
		extentTest.log(extentTest.getStatus(), "Holiday Calender for upcoming year is created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=718)
	public void validateEditHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditHolidayCalenderTest", "TC_240: To verify if user is able to modify weekly days off, existing holiday, tag  on edit of holiday calendar");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateEditHolidayCalender(TestDataInMap.get("CalenderName"),TestDataInMap.get("Weekday"),TestDataInMap.get("Tagname"),
				TestDataInMap.get("startYear"),TestDataInMap.get("startMonth"),TestDataInMap.get("startDate"));
		extentTest.log(extentTest.getStatus(), "Holiday Calender is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=719)
	public void validateRemoveHolidayListDatesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRemoveHolidayListDatesTest", "TC_241: To verify whether user is  able to remove Holiday list dates , weekly days off,  while editing the calendar");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateRemoveHolidayListDates(TestDataInMap.get("CalenderName"),TestDataInMap.get("Tagname"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startMonth"),TestDataInMap.get("startDate"));
		extentTest.log(extentTest.getStatus(), "Holiday list dates are removed successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=720)
	public void validateCreateCloneHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateCloneHolidayCalenderTest", "TC_245: Verify if user can create exact duplicate of existing holiday calendar using copy From option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateCreateCloneHolidayCalender(TestDataInMap.get("CalenderName"),TestDataInMap.get("CloneCalenderName"),TestDataInMap.get("CalenderDescrp"),
				TestDataInMap.get("startYear"));
		extentTest.log(extentTest.getStatus(), "Clone Holiday Calender is created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=721)
	public void validateEditCloneHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditCloneHolidayCalenderTest", "TC_246: To verify whether user is able to change the days after copying the calendar from the last year to new year");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateEditCloneHolidayCalender(TestDataInMap.get("CloneCalenderName"),TestDataInMap.get("Weekday"),
				TestDataInMap.get("startYear"),TestDataInMap.get("startMonth"),TestDataInMap.get("startDate"));
		extentTest.log(extentTest.getStatus(), "Clone Holiday Calender is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=722)
	public void validateRenewHoildayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRenewHoildayCalenderTest", "TC_242: To verify all the last year marked dates for Holiday and Weekly off days get retained in new calendar on renewing the existing calendar");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateRenewHoildayCalender(TestDataInMap.get("CalenderName"),TestDataInMap.get("CalenderDescrp"),TestDataInMap.get("CalenderYear"),
				TestDataInMap.get("Weekday"),TestDataInMap.get("Tagname"),TestDataInMap.get("startYear"),TestDataInMap.get("startMonth"),TestDataInMap.get("startDate"));
		extentTest.log(extentTest.getStatus(), "Holiday Calender is renewed successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=723)
	public void validateEditRenewHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditRenewHolidayCalenderTest", "TC_243: To verify whether user is able to change Holiday dates, weekly off  in renewed calendar");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateEditRenewHolidayCalender(TestDataInMap.get("CalenderName"),TestDataInMap.get("Weekday"),
				TestDataInMap.get("startMonth"),TestDataInMap.get("startDate"));
		extentTest.log(extentTest.getStatus(), "Renewed Holiday Calender is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=724)
	public void validateRemoveHoildayDatesRenewTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRemoveHoildayDatesRenewTest", "TC_244: To verify whether user is  able to remove Holiday list, Weekly off,  added tag  in renewed calendar");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateRemoveHoildayDatesRenew(TestDataInMap.get("CalenderName"),TestDataInMap.get("Tagname"),
				TestDataInMap.get("startMonth"),TestDataInMap.get("startDate"));
		extentTest.log(extentTest.getStatus(), "Holiday list dates from renewed calender are removed successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=725)
	public void validateDeleteHolidayCalenderTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteHolidayCalenderTest", "TC_250: To verify delete holiday calendar from the server.");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateDeleteHolidayCalender(TestDataInMap.get("CalenderName"));
		extentTest.log(extentTest.getStatus(), "Holiay Calender is deleted successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=726)
	public void validateHolidayCalenderPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateHolidayCalenderPageTest", "TC_Additional: To verify holiday calender tab");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateHolidayCalenderPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Holiay Calender tab is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	//For Holiday Calender Name
/*	@Test(priority = 3272)
	public void validateAdvSearchForNameEqualToHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForNameEqualToHolidayPageTATest", "TC_009: To Verfiy Advance search for Holiday Calender Name with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Holiday Calender Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3273)
	public void validateAdvSearchForNameNotEqualToHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameNotEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Holiday Calender Name with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Holiday Calender Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3274)
	public void validateAdvSearchForNameIsLikeHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForNameIsLikeHolidayPageTATest", "TC_009: To Verfiy Advance search for Holiday Calender Name with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Holiday Calender Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3275)
	public void validateAdvSearchForNameBeginsWithHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForNameBeginsWithHolidayPageTATest", "TC_009: To Verfiy Advance search for Holiday Calender Name with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Holiday Calender Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3276)
	public void validateAdvSearchForNameEndsWithHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForNameEndsWithHolidayPageTATest", "TC_009: To Verfiy Advance search for Holiday Calender Name with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Holiday Calender Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Year
	@Test(priority = 3277)
	public void validateAdvSearchForYearEqualToHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForYearEqualToHolidayPageTATest", "TC_355:Verify advance search for Year equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForYearEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Year with equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3278)
	public void validateAdvSearchForYearNotEqualToHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForYearNotEqualToHolidayPageTATest", "TC_355:Verify advance search for Year not equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForYearNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Year with not equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3279)
	public void validateAdvSearchForYearLessThanHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForYearLessThanHolidayPageTATest", "TC_355:Verify advance search for Year less than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForYearLessThan(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Year with less than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	} 
	@Test(priority = 3280)
	public void validateAdvSearchForYearGreaterThanHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForYearGreaterThanHolidayPageTATest", "TC_355:Verify advance search for Year greater than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForYearGreaterThan(TestDataInMap.get("AdvancedSearchsheetname"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Year with greater than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	} 
	@Test(priority = 3281)
	public void validateAdvSearchForYearInRangeHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForYearInRangeHolidayPageTATest", "TC_355:Verify advance search for Year in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForYearInRange(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),
				TestDataInMap.get("SearchData"),TestDataInMap.get("SearchData1"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Year with in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3282)
	public void validateAdvSearchForYearNotInRangeHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForYearNotInRangeHolidayPageTATest", "TC_355:Verify advance search for Year for not in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateAdvSearchForYearNotInRange(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),
				TestDataInMap.get("SearchData"),TestDataInMap.get("SearchData1"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with not in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Time Zone
	@Test(priority = 3283)
	public void validateTimeZoneDropdownEqualToHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateTimeZoneDropdownEqualToHolidayPageTATest", "TC_009: To Verfiy Advance search for Time Zone with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateTimeZoneDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Time Zone is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3284)
	public void validateTimeZoneDropdownNotEqualToHolidayPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateTimeZoneDropdownNotEqualToHolidayPageTATest", "TC_009: To Verfiy Advance search for Time Zone with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		holidaycalenderpageta = new HolidayCalenderPageTA(); 
		holidaycalenderpageta.validateTimeZoneDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Time Zone is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}*/
}
