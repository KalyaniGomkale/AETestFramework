package com.ae.qa.testcasesWorkflowAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.TenantUser.DashboardsPageTU;
import com.ae.qa.pages.WorkflowAdmin.DashboardsPageWA;
import com.ae.qa.util.ExcelHandler;

public class DashboardsPageTestWA extends TestBase{
	DashboardsPageWA dashboardspagewa;

	public DashboardsPageTestWA() {
		super();
	}

	@Test(priority = 76)  
	public void  validateDashboardNoneWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardNoneWATest", "TC_94: Verify create Dashboard None level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		dashboardspagewa= new DashboardsPageWA();
		dashboardspagewa. validateDashboardNoneWA(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 77,dependsOnMethods="validateDashboardNoneWATest",alwaysRun=true)
	public void validateReportNoneMultipleWFWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateReportNoneMultipleWFWA", "TC_95: Verify create Dashboard None level and of multiple workflows");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		dashboardspagewa= new DashboardsPageWA();
		dashboardspagewa.validateReportNoneMultipleWFWA(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("reportTypeValue"),
				TestDataInMap.get("ReportWF1"),TestDataInMap.get("ReportWF2"),TestDataInMap.get("PageSize"),TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level with multiple workflows created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 78)
	public void  validateDashboardRelativeWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardRelativeWATest", "TC_Additional: To create relative type report");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		dashboardspagewa= new DashboardsPageWA();
		dashboardspagewa. validateDashboardRelativeWA(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"),
				TestDataInMap.get("LastTime"),TestDataInMap.get("RangeType"));
		extentTest.log(extentTest.getStatus(), "Realtive type report is created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 79,dependsOnMethods="validateDashboardRelativeWATest",alwaysRun=true)
	public void validateEditDashboardToCustomWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditDashboardToCustomWATest", "TC_96 : To verify Edit Dashboard");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		dashboardspagewa= new DashboardsPageWA();
		dashboardspagewa.validateEditDashboardToCustomWA(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("newDashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("dashboardDuration"),TestDataInMap.get("startDate"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("endDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"));
		extentTest.log(extentTest.getStatus(), "Dashboard is edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 80)
	public void  validateSetAsDefaultReportWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateSetAsDefaultReportWATest", "TC_97: To create relative type report");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		dashboardspagewa= new DashboardsPageWA();
		dashboardspagewa.validateSetAsDefaultReportWA(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Realtive type report is created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 81)
	public void  validateDashboardTodayWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardTodayWATest", "TC_Additional: To verify create today dashboard");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		dashboardspagewa= new DashboardsPageWA();
		dashboardspagewa.validateDashboardTodayWA(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"),
				TestDataInMap.get("StartHour"),TestDataInMap.get("StartMin"),TestDataInMap.get("EndHour"),TestDataInMap.get("EndMin"));
		extentTest.log(extentTest.getStatus(), "Today dashboard is created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}

	@Test(priority = 82,dependsOnMethods="validateDashboardTodayWATest",alwaysRun=true)
	public void  validateDeleteDashboardWithReportWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteDashboardWithReportWATest", "TC_98: To verify delete dashboard");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		dashboardspagewa= new DashboardsPageWA();
		dashboardspagewa.validateDeleteDashboardWithReportWA(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Dashboard is deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}

}
