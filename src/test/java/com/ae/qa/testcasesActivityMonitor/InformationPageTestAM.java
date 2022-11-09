package com.ae.qa.testcasesActivityMonitor;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.ActivityMonitor.InformationPageAM;

import com.ae.qa.util.ExcelHandler;

public class InformationPageTestAM extends TestBase{
	InformationPageAM informationlistpageam;

	public InformationPageTestAM() {
		super();
	}

	@Test(priority=1)
	public void validateLastLoginAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastLoginAMTest", "TC_36: Verfiy last login time and date");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		informationlistpageam= new InformationPageAM();
		informationlistpageam.validateLastLoginAM(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
				       TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),
				       TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"));
		extentTest.log(extentTest.getStatus(), "Last login time and date is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority=2)
	public void validateViewProfileAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateViewProfileAMTest", "TC_37: Verfiy Profile Details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		informationlistpageam= new InformationPageAM();
		informationlistpageam.validateViewProfileAM();
		extentTest.log(extentTest.getStatus(), "Profile Details is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority=3)
	public void validateAboutTabAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAboutTabAMTest", "TC_38: Verfiy About Tab");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		informationlistpageam= new InformationPageAM();
		informationlistpageam.validateAboutTabAM();
		extentTest.log(extentTest.getStatus(), "About Tab is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	//Need to change the priority so that it wont effect other test cases
	/*@Test(priority=551)
	public void validateChangePasswordAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateChangePasswordAMTest", "TC_39: Verfiy Change Password");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		informationlistpageam= new InformationPageAM();
		informationlistpageam.validateChangePasswordAM(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"),
		TestDataInMap.get("cnfPswd"));
		extentTest.log(extentTest.getStatus(), "Change password is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}*/


}
