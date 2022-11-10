package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.LDAPPageTA;
import com.ae.qa.pagesTenantAdmin.TenantPolicyPageTA;
import com.ae.qa.util.ExcelHandler;

public class TenantPolicyPageTestTA extends TestBase {
	TenantPolicyPageTA tenantpolicypageta;

	public TenantPolicyPageTestTA() {
		super();
	}
    @Test(priority = 120)
	public void validatePswdComplexityTATest(Method method) throws Exception {
		extentTest = extent.createTest("validatePswdComplexityTATest", "TC_582:Verify Password Complexity Criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validatePswdComplexityTA(TestDataInMap.get("PSWDWoCriteria"));
		extentTest.log(extentTest.getStatus(), "Password Complexity Criteria is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 121,alwaysRun=true)
	public void validatePasswordHistoryTATest(Method method) throws Exception {
		extentTest = extent.createTest("validatePasswordHistoryTest", "TC_583: Verify Password History");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validatePasswordHistory(TestDataInMap.get("TAUsername"),TestDataInMap.get("TAPswd"),TestDataInMap.get("PswdHistory"));
		extentTest.log(extentTest.getStatus(), "Password History is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 

	@Test(priority = 122,alwaysRun=true)
	public void validateNoOfAttemptsTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateNoOfAttemptsTest", "TC_562: To verify whether the user gets blocked, when max no of attempts is reached");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validateNoOfAttempts(TestDataInMap.get("TAUsername"),TestDataInMap.get("TAPswd"),
				TestDataInMap.get("PSWDWoCriteria"),TestDataInMap.get("NoOfPswdAttempt"));
		extentTest.log(extentTest.getStatus(), "No of Attempts for password is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	 @Test(priority=202)
		public void validateTenantPolicyPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateTenantPolicyPageTATest", "TC_Additional:Verify Clicking Tenant Policy tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			tenantpolicypageta = new TenantPolicyPageTA();
			tenantpolicypageta.validateTenantPolicyPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Tenant Policy Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}
	@Test(priority = 205)
	public void validateUnlockTenantBySysadminTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateUnlockTenantBySysadminTATest", "TC_564: Verify whether respective System admin is able to unlock the locked Tenant Admin user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validateUnlockTenantBySysadminTA(TestDataInMap.get("UserName"),TestDataInMap.get("NewPswd"),TestDataInMap.get("cnfPswd"));
		extentTest.log(extentTest.getStatus(), "TA account unlocked by sysadmin successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 206)
	public void validateUnlockTenantUserRespectToTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateUnlockTenantUserRespectToTATest", "TC_565: Verify whether respective Tenant admin is able to unlock the locked Tenant Admin user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		System.out.println("Data:" +TestDataInMap.get("UserName")+TestDataInMap.get("NewPswd")+TestDataInMap.get("cnfPswd"));
		tenantpolicypageta.validateUnlockTenantUserRespectToTA(TestDataInMap.get("NoOfPswdAttempt"),TestDataInMap.get("UserName"),TestDataInMap.get("InvalidPswd"),TestDataInMap.get("NewPswd"),TestDataInMap.get("cnfPswd"));
		extentTest.log(extentTest.getStatus(), "TA account unlocked by sysadmin successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	/*Remaining for mapping
	@Test(priority = 22,alwaysRun=true)
	public void validateNoOfAttemptsRespectToTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateNoOfAttemptsRespectToTATest", "TC_: To verify whether respective Tenant admin is able to unlock the locked Tenant user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validateNoOfAttemptsRespectToTA(5);
		extentTest.log(extentTest.getStatus(), "No of Attempts for password is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
/*	 
	*/
/*
 	@Test(priority = 24,alwaysRun=true,dependsOnMethods="validateUnlockTenantRespectToTATest")
	public void validateTenantLoginTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTenantLoginTest", "TC_567: verify whether the above unlocked user  is able to get access to application, after change password");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantpolicypageta = new TenantPolicyPageTA();
		tenantpolicypageta.validateTenantLogin(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),
				TestDataInMap.get("NewPswd"),TestDataInMap.get("cnfPswd"));
		extentTest.log(extentTest.getStatus(), "TA account unlocked by sysadmin successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	*/

}
