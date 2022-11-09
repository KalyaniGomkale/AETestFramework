package com.ae.qa.testcasesUserAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.TenantUser.InformationPageTU;
import com.ae.qa.pages.UserAdmin.InformationPageUA;
import com.ae.qa.util.ExcelHandler;

public class InformationPageTestUA extends TestBase{
	InformationPageUA informationlistpageua;

	public InformationPageTestUA() {
		super();
	}

	@Test(priority=10)
	public void validateLastLoginUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastLoginUATest", "TC_36: Verfiy last login time and date");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		informationlistpageua= new InformationPageUA();
		informationlistpageua.validateLastLoginUA(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"));
		extentTest.log(extentTest.getStatus(), "Last login time and date is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}
	@Test(priority=11)
	public void validateViewProfileUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateViewProfileUATest", "TC_37: Verfiy Profile Details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		informationlistpageua= new InformationPageUA();
		informationlistpageua.validateViewProfileUA();
		extentTest.log(extentTest.getStatus(), "Profile Details is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}
	@Test(priority=12)
	public void validateAboutTabUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAboutTabUATest", "TC_38: Verfiy About Tab");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		informationlistpageua= new InformationPageUA();
		informationlistpageua.validateAboutTabUA();
		extentTest.log(extentTest.getStatus(), "About Tab is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}
	//Need to change the priority so that it wont effect other test cases
	/*@Test(priority=552)
	public void validateChangePasswordUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateChangePasswordUATest", "TC_39: Verfiy Change Password");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		informationlistpageua= new InformationPageUA();
		informationlistpageua.validateChangePasswordUA(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"),
		TestDataInMap.get("cnfPswd"));
		extentTest.log(extentTest.getStatus(), "Change password is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}*/
	

}
