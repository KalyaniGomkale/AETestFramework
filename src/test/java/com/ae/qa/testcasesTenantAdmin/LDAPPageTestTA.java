package com.ae.qa.testcasesTenantAdmin;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.FileManagementPageTA;
import com.ae.qa.pagesTenantAdmin.LDAPPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class LDAPPageTestTA extends TestBase {
	LDAPPageTA ldappageta;

	public LDAPPageTestTA() {
		super();
	}
	//Need to retest
	@Test(priority=18)
	public void verifyLdapConfigTest(Method method) throws Exception {
		extentTest = extent.createTest("verifyLdapConfigTest", "TC_489: Verify user able to set LDAP configuration");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		ldappageta = new LDAPPageTA();
		ldappageta.verifyLdapConfig(TestDataInMap.get("Host"),TestDataInMap.get("Port"),TestDataInMap.get("Domain"));
		extentTest.log(extentTest.getStatus(), "User set LDAP configuration successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	

	@Test(priority=19,dependsOnMethods= {"verifyLdapConfigTest"},alwaysRun=true)
	public void verifyEditLdapConfigTest(Method method) throws Exception {
		extentTest = extent.createTest("verifyEditLdapConfigTest", "TC_490: Verify user able to edit LDAP configuration");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		ldappageta = new LDAPPageTA();
		ldappageta.verifyEditLdapConfig(TestDataInMap.get("Domain"));
		extentTest.log(extentTest.getStatus(), "User edited LDAP configuration successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	 @Test(priority=200)
		public void validateLDAPPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateLDAPPageTATest", "TC_Additional:Verify Clicking LDAP tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			ldappageta = new LDAPPageTA();
			ldappageta.validateLDAPPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "LDAP Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}
}