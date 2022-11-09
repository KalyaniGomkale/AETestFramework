package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.pagesTenantAdmin.AgentLogsPageTA;
import com.ae.qa.pagesTenantAdmin.DashboardsPageTA;
import com.ae.qa.pagesTenantAdmin.ExternalAppsPageTA;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.Messages;

public class DashboardsPageTestTA extends TestBase {
	DashboardsPageTA dashboardspageta;

	public DashboardsPageTestTA() {
		super();
	}

	/*@Test(priority = 97)
	public void validateDashboardNoneTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardNoneTest", "TC_378: Verify create Dashboard None level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateDashboardNone(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 104,dependsOnMethods="validateDashboardNoneTest",alwaysRun=true)
	public void validateReportNoneMultipleWFTest(Method method) throws Exception {
		extentTest = extent.createTest("validateReportNoneMultipleWFTest", "TC_380: Verify create Dashboard None level and of multiple workflows");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateReportNoneMultipleWF(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("reportTypeValue"),
				TestDataInMap.get("ReportWF1"),TestDataInMap.get("ReportWF2"),TestDataInMap.get("PageSize"),TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level with multiple workflows created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 105,alwaysRun=true)
	public void validateDashboardTodayTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardTodayTest", "TC_383: Verify create Dashboard with Today level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateDashboardToday(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"),
				TestDataInMap.get("StartHour"),TestDataInMap.get("StartMin"),TestDataInMap.get("EndHour"),TestDataInMap.get("EndMin"));
		extentTest.log(extentTest.getStatus(), "Dashboard at today level created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 106,dependsOnMethods="validateDashboardTodayTest",alwaysRun=true)
	public void validateReportTodayTest(Method method) throws Exception {
		extentTest = extent.createTest("validateReportTodayTest", "TC_380: Verify create report at dashboard today level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateReportToday(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("reportTypeValue"),
				TestDataInMap.get("ReportWF1"),TestDataInMap.get("PageSize"),TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Report at Today level created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 107,alwaysRun=true)
	public void validateDashboarRelativeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboarRelativeTest", "TC_385: Verify create Dashboard Relative level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateDashboardRelative(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"),
				TestDataInMap.get("LastTime"),TestDataInMap.get("RangeType"));
		extentTest.log(extentTest.getStatus(), "Dashboard at none level created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 108,dependsOnMethods="validateDashboarRelativeTest",alwaysRun=true)
	public void validateReportRelativeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateReportRelativeTest", "TC_386: Verify create report at dashboard relative level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateReportRelative(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("reportTypeValue"),
				TestDataInMap.get("ReportWF1"),TestDataInMap.get("PageSize"),TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Report at Today level created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 109,dependsOnMethods="validateDashboarRelativeTest",alwaysRun=true)
	public void validateEditDashboardToCustomTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditDashboardToCustomTest", "TC_405: Verify edit Dashboard to custom level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateEditDashboardToCustom(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("newDashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("dashboardDuration"),TestDataInMap.get("startDate"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("endDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"));
		extentTest.log(extentTest.getStatus(), "Dashboard edited to custom level successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 110)
	public void validateReportCustomTest(Method method) throws Exception {
		extentTest = extent.createTest("validateReportCustomTest", "TC_386: Verify create report at dashboard relative level");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateReportCustom(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("reportTypeValue"),
				TestDataInMap.get("ReportWF1"),TestDataInMap.get("PageSize"),TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Report at Today level created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 111)
	public void validateSetAsDefaultReportTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSetAsDefaultReportTest", "TC_410: Verify report set as a default");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateSetAsDefaultReport(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Report set as default successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 112)
	public void validatePinToHomeTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePinToHomeTest", "TC_413: Verify Pin to Home");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validatePinToHome(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Pin to Home validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 113,alwaysRun=true)
	public void validateMakePublicTest(Method method) throws Exception {
		extentTest = extent.createTest("validateMakePublicTest", "TC_420: Verify Make to Public");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateMakePublic(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Make as Public validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 114, alwaysRun=true)
	public void validateDeleteDashboardWithReportTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteDashboardWithReportTest", "TC_411: Verify delete dashboard with report");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateDeleteDashboardWithReport(TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Dashboard with report deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 115,alwaysRun=true)
	public void validateDeleteDashboardWithoutReportTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteDashboardWithoutReportTest", "TC_412: Verify delete dashboard without report");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateDeleteDashboardWithoutReport(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("dashboardDescp"),
				TestDataInMap.get("timeUnit"),TestDataInMap.get("refreshTime"),TestDataInMap.get("dashboardDuration"));
		extentTest.log(extentTest.getStatus(), "Dashboard without report deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=320)
	public void ValidateLabelChangeInReportTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateLabelChangeInReportTest", "TC_186:Label Change in Report");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateLabelChangeInReport(TestDataInMap.get("reportTypeName"),TestDataInMap.get("dashboardTitle"));
		extentTest.log(extentTest.getStatus(), "Label Changed in Report successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=321)
	public void ValidateDownloadReportPdfTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateDownloadReportPdfTest", "TC_188:Verify download report as PDF");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateDownloadReportPdf(TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Report is downloaded as PDF successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=186)
	public void validateDashboardsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDashboardsPageTATest", "TC_Additional:Verify Clicking Dashboards tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateDashboardsPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Dashboards Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=336)
	public void validateReportNoneMultipleCategoryTest(Method method) throws Exception {
		extentTest = extent.createTest("validateReportNoneMultipleCategoryTest", "TC_174:Verify add report in-Dashboard level Duration Duration-None and with multiple category");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateReportNoneMultipleCategory(TestDataInMap.get("dashboardTitle"),TestDataInMap.get("reportTypeValue"),TestDataInMap.get("PageSize"),TestDataInMap.get("reportTypeName"));
		extentTest.log(extentTest.getStatus(), "Add report in-Dashboard level Duration Duration-None and with multiple category is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	/*@Test(priority=590)
	public void validateFullScreenModeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateFullScreenModeTest", "TC_185:Verfiy Report in Full screen mode");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateFullScreenMode();
		extentTest.log(extentTest.getStatus(), "Report in full screen is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	@Test(priority=336)
	public void validateColumnHideTest(Method method) throws Exception {
		extentTest = extent.createTest("validateColumnHideTest", "TC_425:Verify Column hide");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		dashboardspageta= new DashboardsPageTA();
		dashboardspageta.validateColumnHide("DashboardNone");
		extentTest.log(extentTest.getStatus(), "Column hide is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}