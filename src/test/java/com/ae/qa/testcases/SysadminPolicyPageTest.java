package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SysadminPolicyPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;

public class SysadminPolicyPageTest extends TestBase {
	SysadminPolicyPage sysadminpolicypage;

	public SysadminPolicyPageTest() {
		super();
	}

	//sysadmin1 data can be use
	@Test(priority = 26)
	public void validatePswdComplexityTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePswdComplexityTest", "TC_123: To verify how system behaves when user violates the password complexity");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		sysadminpolicypage = new SysadminPolicyPage();
		//sysadminpolicypage.validatePswdComplexity("PswdComp","Pune@123","6","19","2","2","2","2","Pune1254");
		sysadminpolicypage.validatePswdComplexity(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("SysadminPswd"),TestDataInMap.get("invalidPswd"));//6, 19, 2, 2, 2, 2, "Pune1254");
		extentTest.log(extentTest.getStatus(), "Password Complexity Criteria is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	} 

	//sysadmin2 data
	@Test(priority= 27,alwaysRun=true) 
	public void validatePasswordHistoryTest(Method method) throws Exception
	{ 
		extentTest = extent.createTest("validatePasswordHistoryTest","TC_133: Verify Password History");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		sysadminpolicypage=new SysadminPolicyPage();
		sysadminpolicypage.validatePasswordHistory(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("SysadminInvalidPswd"),TestDataInMap.get("SysadminPswd"),TestDataInMap.get("PswdHistory"));
		//sysadminpolicypage.validatePasswordHistory("sysadmin2","Pune@123","Pune@0","4","4");
		extentTest.log(extentTest.getStatus(),"Password History is validated successfully"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

    @Test(priority=28,alwaysRun=true)	 
	public void validateNoOfAttemptsTest(Method method) throws Exception {
		extentTest =extent.createTest("validateNoOfAttemptsTest","TC_125: To check the calculation of unsucessful attempt post first unsucessful attempt");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		sysadminpolicypage=new SysadminPolicyPage();
		sysadminpolicypage.validateNoOfAttempts(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("SysadminPswd"),TestDataInMap.get("SysadminInvalidPswd"),TestDataInMap.get("NoOfAttempt"));
		extentTest.log(extentTest.getStatus(), "No of Attempts for password is validated successfully"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	} 
	@Test(priority=167)
	public void validateSysadminPolicyPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSysadminPolicyPageTest", "TC_Additional:Verify Clicking Sysadmin Policy tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		sysadminpolicypage=new SysadminPolicyPage();
		sysadminpolicypage.validateSysadminPolicyPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Sysadmin Policy page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	/*@Test(priority=123,alwaysRun=true)	 
	public void dragAndDrop(Method method) throws Exception {
		extentTest =extent.createTest("dragAndDrop","TC_125: To check the calculation of unsucessful attempt post first unsucessful attempt");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		sysadminpolicypage=new SysadminPolicyPage();
		sysadminpolicypage.dragAndDrop("sysadmin","Pune@1234","Pune12345");
		extentTest.log(extentTest.getStatus(), "No of Attempts for password is validated successfully"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	} */
}
