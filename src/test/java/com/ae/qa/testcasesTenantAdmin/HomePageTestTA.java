package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.pagesTenantAdmin.HomePageTA;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.util.ExcelHandler;

public class HomePageTestTA extends TestBase {

	HomePageTA homepageta;

	public HomePageTestTA() {
		super();
	}

	@Test(priority = 43, alwaysRun = true)
	public void validateUploadLicenseTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadLicenseTest","TC_001: It will validate the license uploaad for Tenant Admin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		homepageta = new HomePageTA();
		homepageta.validateUploadLicenseNewUser(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"));
		extentTest.log(extentTest.getStatus(), "License uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=145)
	public void validateSearchFunctionalityTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateSearchFunctionalityTest", "TC_022:Search functionality in sidebar menu");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		homepageta = new HomePageTA();
		homepageta.validateSearchFunctionalityTA(TestDataInMap.get("TabName"));
		extentTest.log(extentTest.getStatus(), "Search functionality in sidebar menu is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=169)
	public void validateHomePageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateSearchFunctionalityTest", "TC_Additional:Verify Clicking Home tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		homepageta = new HomePageTA();
		homepageta.validateHomePageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Home Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=707)
	public void validateLicenseDetailTabTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLicenseDetailTabTest", "TC_19:- Verify License Details tab");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		homepageta = new HomePageTA();
		homepageta.validateLicenseDetailTab();
		extentTest.log(extentTest.getStatus(), "License Details Tab is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=708)
	public void validateLicenseDetailHomepageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLicenseDetailHomepageTest", "TC_18:- Verify License Details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		homepageta = new HomePageTA();
		homepageta.validateLicenseDetailHomepage();
		extentTest.log(extentTest.getStatus(), "License Details verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}

