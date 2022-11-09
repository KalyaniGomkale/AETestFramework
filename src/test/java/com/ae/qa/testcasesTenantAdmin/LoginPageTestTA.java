package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pagesTenantAdmin.HomePageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.ExcelHandler;

public class LoginPageTestTA extends TestBase {
	LoginPageTA loginpageta;
	HomePageTA homepageta;

	public LoginPageTestTA() {
		super();
	}
	  @Test(priority=42) 
	  public void ValidateFirstTimeTALoginTest(Method method) throws Exception { 
	  extentTest = extent.createTest( "ValidateFirstTimeLoginTest","TC_1: Verify sysadmin user able to change first time password");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  loginpageta = new LoginPageTA();
	  loginpageta.ValidateFirstTimeLogin(prop.getProperty("username_TA1"),prop.getProperty("FT_password_TA1"),prop.getProperty("password_TA1"));
	  extentTest.log(extentTest.getStatus(),"User is able to change first time password of sysadmin.");
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName()); 
	  }
}
