package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.InformationPage;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.util.ExcelHandler;

public class InformationPageTest extends TestBase {
	InformationPage informationpage;

	public InformationPageTest() {
		super();
	}

   @Test(priority = 29)
	public void validateLastLoginTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastLoginTest", "TC_117: It should check Last Login details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		informationpage = new InformationPage();
		informationpage.validateLastLogin();
		extentTest.log(extentTest.getStatus(), "Last login verified successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 30)
	public void validateViewProfileTest(Method method) throws Exception {
		extentTest = extent.createTest("validateViewProfileTest", "TC_118: It should check Profile Details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		informationpage = new InformationPage();
		informationpage.validateViewProfile();
		extentTest.log(extentTest.getStatus(), "Profile Details verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

/*	@Test(priority = 18)
	public void validateAboutTest() throws Exception {
		extentTest = extent.createTest("validateAboutTest", "About AE details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		informationpage = new InformationPage();
		informationpage.validateAbout();
		extentTest.log(extentTest.getStatus(), "About AE Details");
	}*/

	@Test(priority = 31)
	public void validateChangePasswordTest(Method method) throws Exception {
		extentTest = extent.createTest("validateChangePasswordTest", "TC_120: Change password of user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		informationpage = new InformationPage();
		informationpage.validateChangePassword(TestDataInMap.get("UserName"),TestDataInMap.get("Password"),TestDataInMap.get("NewPswd"),TestDataInMap.get("NewCnfPswd"));
		extentTest.log(extentTest.getStatus(), "Password Changed successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	/*@Test
	public void validateSignOutTest() throws Exception {
		extentTest = extent.createTest("validateSignOutTest", "It sign out the user");
		informationpage = new InformationPage();
		informationpage.validateSignOut();
		extentTest.log(extentTest.getStatus(), "User signed out successfully");
	}*/
	//Regression Test case
	@Test(priority=301)
	public void validateAboutTabTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAboutTab", "TC_74: To verify About tab");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		informationpage = new InformationPage();
		informationpage.aboutTab();
		extentTest.log(extentTest.getStatus(), "Verify About Tab");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
}
}
