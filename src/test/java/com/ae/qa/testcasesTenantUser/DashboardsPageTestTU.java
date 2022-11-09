package com.ae.qa.testcasesTenantUser;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.TenantUser.DashboardsPageTU;
import com.ae.qa.util.ExcelHandler;

public class DashboardsPageTestTU extends TestBase{
	DashboardsPageTU dashboardspagetu;

	public DashboardsPageTestTU() {
		super();
	}

	@Test(priority = 69)  
	public void  validateDashboardNoneTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardNoneTUTest", "TC_16: Verify create Dashboard None level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		dashboardspagetu= new DashboardsPageTU();
		dashboardspagetu. validateDashboardNoneTU(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	@Test(priority = 70,dependsOnMethods="validateDashboardNoneTUTest",alwaysRun=true)
	public void validateReportNoneMultipleWFTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateReportNoneMultipleWFTU", "TC_17: Verify create Dashboard None level and of multiple workflows");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		dashboardspagetu= new DashboardsPageTU();
		dashboardspagetu.validateReportNoneMultipleWFTU(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("reportTypeValue"),
				TestDataInMap.get("ReportWF1"),TestDataInMap.get("ReportWF2"),TestDataInMap.get("PageSize"),TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level with multiple workflows created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	@Test(priority = 71)
	public void  validateDashboardRelativeTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardRelativeTUTest", "TC_Additional: To create relative type report");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		dashboardspagetu= new DashboardsPageTU();
		dashboardspagetu. validateDashboardRelativeTU(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"),
				TestDataInMap.get("LastTime"),TestDataInMap.get("RangeType"));
		extentTest.log(extentTest.getStatus(), "Realtive type report is created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	@Test(priority = 72,alwaysRun=true)
	public void validateEditDashboardToCustomTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditDashboardToCustomTUTest", "TC_18 : To verify Edit Dashboard");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		dashboardspagetu= new DashboardsPageTU();
		dashboardspagetu.validateEditDashboardToCustomTU(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("newDashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("dashboardDuration"),TestDataInMap.get("startDate"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("endDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"));
		extentTest.log(extentTest.getStatus(), "Dashboard is edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	@Test(priority = 73)
	public void  validateSetAsDefaultReportTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSetAsDefaultReportTUTest", "TC_19: Verify Set as default");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		dashboardspagetu= new DashboardsPageTU();
		dashboardspagetu.validateSetAsDefaultReportTU(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Dashboard is set to default successsfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	@Test(priority = 74)
	public void  validateDashboardTodayTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardTodayTUTest", "TC_Additional: To verify create today dashboard");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		dashboardspagetu= new DashboardsPageTU();
		dashboardspagetu.validateDashboardTodayTU(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"),
				TestDataInMap.get("StartHour"),TestDataInMap.get("StartMin"),TestDataInMap.get("EndHour"),TestDataInMap.get("EndMin"));
		extentTest.log(extentTest.getStatus(), "Today dashboard is created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}

	@Test(priority = 75,dependsOnMethods="validateDashboardTodayTUTest",alwaysRun=true)
	public void  validateDeleteDashboardWithReportTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteDashboardWithReportTUTest", "TC_20: To verify delete dashboard");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		dashboardspagetu= new DashboardsPageTU();
		dashboardspagetu.validateDeleteDashboardWithReportTU(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Dashboard is deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
}
