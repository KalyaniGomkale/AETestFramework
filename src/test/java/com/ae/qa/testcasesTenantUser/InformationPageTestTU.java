package com.ae.qa.testcasesTenantUser;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.AgentAdmin.InformationPageAA;
import com.ae.qa.pages.TenantUser.InformationPageTU;
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.util.ExcelHandler;

public class InformationPageTestTU extends TestBase{
	InformationPageTU informationlistpagetu;

	public InformationPageTestTU() {
		super();
	}

	@Test(priority=7)
	public void validateLastLoginTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastLoginTUTest", "TC_22: Verfiy last login time and date");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		informationlistpagetu= new InformationPageTU();
		informationlistpagetu.validateLastLoginTU(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"));
		extentTest.log(extentTest.getStatus(), "Last login time and date is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	@Test(priority=8)
	public void validateViewProfileTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateViewProfileTUTest", "TC_23: Verfiy Profile Details");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		informationlistpagetu= new InformationPageTU();
		informationlistpagetu.validateViewProfileTU();
		extentTest.log(extentTest.getStatus(), "Profile Details is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	@Test(priority=9)
	public void validateAboutTabTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAboutTabTUTest", "TC_24: Verfiy About Tab");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		informationlistpagetu= new InformationPageTU();
		informationlistpagetu.validateAboutTabTU();
		extentTest.log(extentTest.getStatus(), "About Tab is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	//Need to change the priority so that it wont effect other test cases
	/*@Test(priority=550)
	public void validateChangePasswordTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateChangePasswordTUTest", "TC_25: Verfiy Change Password");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		informationlistpagetu= new InformationPageTU();
		informationlistpagetu.validateChangePasswordTU(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"),
		TestDataInMap.get("cnfPswd"));
		extentTest.log(extentTest.getStatus(), "Change password is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}*/
	

}
