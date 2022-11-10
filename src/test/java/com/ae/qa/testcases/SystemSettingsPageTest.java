package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SystemSettingsPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;

public class SystemSettingsPageTest extends TestBase {
	SystemSettingsPage systemsettingspage;

	public SystemSettingsPageTest() {
		super();
	}
	
	@Test(priority = 16)
	public void validateAgentServerNotSetTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentServerNotSetTest", "TC_101: Verify popup when user try to download agent without server settings");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemsettingspage = new SystemSettingsPage();
		systemsettingspage.validateAgentServerNotSet();
		extentTest.log(extentTest.getStatus(), "User is not able to download agent without Server Settings- validated successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 17,alwaysRun=true)
	public void validateInvalidURLTest(Method method) throws Exception {
		extentTest = extent.createTest("validateInvalidURLTest", "TC_101: Verify server Url");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemsettingspage = new SystemSettingsPage();
		systemsettingspage.validateInvalidURL(TestDataInMap.get("ServerURL"));
		extentTest.log(extentTest.getStatus(), "Server URL saved successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 18,alwaysRun=true)
	public void validateServerUrlTest(Method method) throws Exception {
		extentTest = extent.createTest("validateServerUrlTest", "TC_101: Verify server Url");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemsettingspage = new SystemSettingsPage();
		systemsettingspage.validateServerUrl(TestDataInMap.get("ServerURL"),TestDataInMap.get("cleanUpRequestHour"));
		extentTest.log(extentTest.getStatus(), "System settings saved successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	 @Test(priority = 19,alwaysRun=true)
	 public void validateEditCleanUpRequest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditCleanUpRequest", "TC_103: Verify editing URL & cleanup Requests older than Hours");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemsettingspage = new SystemSettingsPage();
		systemsettingspage.EditCleanUpRequest(TestDataInMap.get("ServerURL"),TestDataInMap.get("cleanUpRequestHour"));
		extentTest.log(extentTest.getStatus(), "Sysadmin is able to edit URL & cleanup request for server URL setting");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
		@Test(priority=165)
		public void validateSystemSettingsPageTest(Method method) throws Exception {
			extentTest = extent.createTest("validateSystemSettingsPageTest", "TC_Additional:Verify Clicking System Settings tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			systemsettingspage = new SystemSettingsPage();
			systemsettingspage.validateSystemSettingsPage(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "System Settings page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
/*
	@Test(priority = 11)
	public void ValidateDRServerUrlTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateDRServerUrlTest", "TC_102: Verify DR server Url");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemsettingspage = new SystemSettingsPage();
		systemsettingspage.ValidateDRServerUrl(TestDataInMap.get("ServerURL"),TestDataInMap.get("cleanUpRequestHour"));
		extentTest.log(extentTest.getStatus(), "DR server URL validated successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
*/
	

}
