package com.ae.qa.testcasesAgentAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.ActivityMonitor.InformationPageAM;
import com.ae.qa.pages.AgentAdmin.InformationPageAA;
import com.ae.qa.util.ExcelHandler;

public class InformationPageTestAA extends TestBase{
	InformationPageAA informationlistpageaa;

	public InformationPageTestAA() {
		super();
	}

	@Test(priority=4)
	public void validateLastLoginAATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastLoginAATest", "TC_27: Verfiy last login time and date");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		informationlistpageaa= new InformationPageAA();
		informationlistpageaa.validateLastLoginAA(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
				TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),
				TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"));
		extentTest.log(extentTest.getStatus(), "Last login time and date is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}
	@Test(priority=5)
	public void validateViewProfileAATest(Method method) throws Exception {
		extentTest = extent.createTest("validateViewProfileAATest", "TC_28: Verfiy Profile Details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		informationlistpageaa= new InformationPageAA();
		informationlistpageaa.validateViewProfileAA();
		extentTest.log(extentTest.getStatus(), "Profile Details is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}
	@Test(priority=6)
	public void validateAboutTabAATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAboutTabAATest", "TC_29: Verfiy About Tab");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		informationlistpageaa= new InformationPageAA();
		informationlistpageaa.validateAboutTabAA();
		extentTest.log(extentTest.getStatus(), "About Tab is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}
	//Need to change the priority so that it wont effect other test cases
	/*@Test(priority=552)
	public void validateChangePasswordAATest(Method method) throws Exception {
		extentTest = extent.createTest("validateChangePasswordAATest", "TC_30: Verfiy Change Password");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		informationlistpageaa= new InformationPageAA();
		informationlistpageaa.validateChangePasswordAA(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"),
		TestDataInMap.get("cnfPswd"));
		extentTest.log(extentTest.getStatus(), "Change password is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}*/
	
}
