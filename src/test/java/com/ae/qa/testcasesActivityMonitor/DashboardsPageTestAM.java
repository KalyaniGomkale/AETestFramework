package com.ae.qa.testcasesActivityMonitor;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.ActivityMonitor.DashboardsPageAM;
import com.ae.qa.util.ExcelHandler;

public class DashboardsPageTestAM extends TestBase{
	DashboardsPageAM dashboardspageam;

	public DashboardsPageTestAM() {
		super();
	}

	@Test(priority = 62)  
	public void  validateDashboardNoneAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardNoneAMTest", "TC_30: Verify create Dashboard None level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam. validateDashboardNoneAM(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority = 63,dependsOnMethods="validateDashboardNoneAMTest",alwaysRun=true)
	public void validateReportNoneMultipleWFAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateReportNoneMultipleWFAM", "TC_31: Verify create Dashboard None level and of multiple workflows");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam.validateReportNoneMultipleWFAM(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("reportTypeValue"),
				TestDataInMap.get("ReportWF1"),TestDataInMap.get("ReportWF2"),TestDataInMap.get("PageSize"),TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level with multiple workflows created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority = 64)
	public void  validateDashboardRelativeAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardRelativeAMTest", "TC_Additional: To create relative type report");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam. validateDashboardRelativeAM(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"),
				TestDataInMap.get("LastTime"),TestDataInMap.get("RangeType"));
		extentTest.log(extentTest.getStatus(), "Realtive type report is created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority = 65,dependsOnMethods="validateDashboardRelativeAMTest",alwaysRun=true)
	public void validateEditDashboardToCustomAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditDashboardToCustomAMTest", "TC_32 : To verify Edit Dashboard");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam.validateEditDashboardToCustomAM(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("newDashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("dashboardDuration"),TestDataInMap.get("startDate"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("endDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"));
		extentTest.log(extentTest.getStatus(), "Dashboard is edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority = 66)
	public void  validateSetAsDefaultReportAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSetAsDefaultReportAMTest", "TC_33: To create relative type report");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam.validateSetAsDefaultReportAM(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Realtive type report is created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority = 67)
	public void  validateDashboardTodayAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardTodayAMTest", "TC_Additional: To verify create today dashboard");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam.validateDashboardTodayAM(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"),
				TestDataInMap.get("StartHour"),TestDataInMap.get("StartMin"),TestDataInMap.get("EndHour"),TestDataInMap.get("EndMin"));
		extentTest.log(extentTest.getStatus(), "Today dashboard is created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
   @Test(priority = 68,alwaysRun=true)
	public void  validateDeleteDashboardAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteDashboardTest", "TC_34: To verify delete dashboard");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
	    dashboardspageam.validateDeleteDashboardAM(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Dashboard is deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}


}
