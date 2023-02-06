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

	@Test(priority = 21)  
	public void  validateDashboardNoneAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardNoneAMTest", "TC_30: Verify create Dashboard None level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam. validateDashboardNoneAM(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority = 22,dependsOnMethods="validateDashboardNoneAMTest",alwaysRun=true)
	public void validateReportNoneMultipleWFAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateReportNoneMultipleWFAM", "TC_31: Verify create Dashboard None level and of multiple workflows");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam.validateReportNoneMultipleWFAM(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("reportTypeValue"),
				TestDataInMap.get("ReportWF1"),TestDataInMap.get("ReportWF2"),TestDataInMap.get("PageSize"),TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level with multiple workflows created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority = 23)
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
	@Test(priority = 24,dependsOnMethods="validateDashboardRelativeAMTest",alwaysRun=true)
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
	@Test(priority = 25)
	public void  validateSetAsDefaultReportAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSetAsDefaultReportAMTest", "TC_33: To create relative type report");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam.validateSetAsDefaultReportAM(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Realtive type report is created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority = 26)
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
	@Test(priority = 600)
	public void  validateReportCustomAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateReportCustomAMTest", "TC_Additional: To verify add report to custom dashboard");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam.validateReportCustom(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("reportTypeValue"),TestDataInMap.get("ReportWF1"),TestDataInMap.get("PageSize"),
				TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Report is added successfully to custom dashboard");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority = 601,dependsOnMethods="validateReportCustomAMTest",alwaysRun=true)
	public void  validateDeleteDashboardWithReportAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteDashboardWithReportAMTest", "TC_34: To verify delete dashboard with report");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		dashboardspageam= new DashboardsPageAM();
		dashboardspageam.validateDeleteDashboardAM(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Dashboard is deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}


}
