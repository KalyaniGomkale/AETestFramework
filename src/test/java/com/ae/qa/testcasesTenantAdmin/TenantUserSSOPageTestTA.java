package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.TenantUserSSOPageTA;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.util.ExcelHandler;

public class TenantUserSSOPageTestTA extends TestBase {
	TenantUserSSOPageTA tenantuserssopageta;

		public TenantUserSSOPageTestTA() {
			super();
		}
		
		 @Test(priority=151)
		  public void ValidateConfigureOKTAwidOpenIDTest(Method method) throws Exception { 
		  extentTest = extent.createTest("ValidateConfigureOKTAwidOpenIDTest","TC_0549A: Verify able to import configuration for OKTA+ Open ID from IDP Site");
		  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		  tenantuserssopageta=new TenantUserSSOPageTA();
		 tenantuserssopageta.ValidateConfigureOKTAwidOpenID(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),
		TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),
		TestDataInMap.get("TAPswd"),TestDataInMap.get("IdentityProvider"),TestDataInMap.get("Protocol"),
		TestDataInMap.get("RedirectURL"),TestDataInMap.get("ClientID"),
		TestDataInMap.get("SSOUserType"),TestDataInMap.get("SSOUsername"),TestDataInMap.get("IDPUserName"),TestDataInMap.get("OKTAUserName"),
		TestDataInMap.get("OKTAPassword"));
		  extentTest.log(extentTest.getStatus(), "User is able to import configuration for OKTA+Open ID from IDP site");
		  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		 }
		

}
