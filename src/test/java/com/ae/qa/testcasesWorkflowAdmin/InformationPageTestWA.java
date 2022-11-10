package com.ae.qa.testcasesWorkflowAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.UserAdmin.InformationPageUA;
import com.ae.qa.pages.WorkflowAdmin.InformationPageWA;
import com.ae.qa.util.ExcelHandler;

public class InformationPageTestWA extends TestBase{
	InformationPageWA informationlistpagewa;

	public InformationPageTestWA() {
		super();
	}
	@Test(priority=13)
	public void validateLastLoginWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastLoginWATest", "TC_14: Verfiy last login time and date");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		informationlistpagewa= new InformationPageWA();
		informationlistpagewa.validateLastLoginWA(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"));
		extentTest.log(extentTest.getStatus(), "Last login time and date is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=14)
	public void validateViewProfileWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateViewProfileWATest", "TC_15: Verfiy Profile Details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		informationlistpagewa= new InformationPageWA();
		informationlistpagewa.validateViewProfileWA();
		extentTest.log(extentTest.getStatus(), "Profile Details is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=15)
	public void validateAboutTabWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAboutTabWATest", "TC_16: Verfiy About Tab");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		informationlistpagewa= new InformationPageWA();
		informationlistpagewa.validateAboutTabWA();
		extentTest.log(extentTest.getStatus(), "About Tab is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	//Need to change the priority so that it wont effect other test cases
	/*@Test(priority=551)
	public void validateChangePasswordWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateChangePasswordWATest", "TC_17: Verfiy Change Password");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		informationlistpagewa= new InformationPageWA();
		informationlistpagewa.validateChangePasswordWA(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"),
		TestDataInMap.get("cnfPswd"));
		extentTest.log(extentTest.getStatus(), "Change password is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}*/
	

}
