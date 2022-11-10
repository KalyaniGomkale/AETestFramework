package com.ae.qa.testcasesTenantAdmin;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.UserGroupsPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class InformationPageTestTA extends TestBase {
	InformationPageTA informationpageta;

	public InformationPageTestTA() {
		super();
	}
	//No data required

	@Test (priority=123)
	public void validateLastLoginTATest(Method method) throws Exception  {
		extentTest = extent.createTest( "validateLastLoginTest","TC_072: To Veify Last Login date and time");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		informationpageta=new InformationPageTA();
		informationpageta.validateLastLoginTA(); 
		extentTest.log(extentTest.getStatus(), "Last Login details verified.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test (priority=124,alwaysRun=true)
	public void validateViewProfileTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateViewProfileTest","TC_073: Verify  Profile details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		informationpageta=new InformationPageTA();
		informationpageta.validateViewProfileTA();
		extentTest.log(extentTest.getStatus(), "Profile Details are verified"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}



	/* @Test (priority=7,alwaysRun=true)
	  public void validateChangePasswordTest(Method method) throws Exception  { 
	  extentTest = extent.createTest("validateChangePasswordTest","TC_075: Change password of user");
	  Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	  informationpageta=new InformationPageTA();
	  informationpageta.validateChangePassword(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"),TestDataInMap.get("cnfPswd"));
	  extentTest.log(extentTest.getStatus(), "User changed password successfully"); 
	  ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	  }*/

	@Test(priority=125,alwaysRun=true)
	public void validateSetTenantLogo(Method method) throws Exception {
		extentTest = extent.createTest("validateChangePasswordTest", "TC_076:Set Tenant Logo");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		informationpageta = new InformationPageTA();
		informationpageta.setTenantLogo();
		extentTest.log(extentTest.getStatus(), "Tenant Logo set successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=126,alwaysRun=true)
	public void validateRemoveTenantLogo(Method method) throws Exception {
		extentTest = extent.createTest("validateRemoveTenantLogo", "TC_077: Remove Tenant Logo");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		informationpageta = new InformationPageTA();
		informationpageta.removeTenantLogo();
		extentTest.log(extentTest.getStatus(), "Tenant Logo removed successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=604)
	public void validateChangeTenantLogoTest(Method method) throws Exception {
		extentTest = extent.createTest("validateChangeTenantLogoTest", "TC_091: Change Tenant Logo");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		informationpageta = new InformationPageTA();
		informationpageta.validateChangeTenantLogo();
		extentTest.log(extentTest.getStatus(), "Tenant Logo is changed successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=300)
	public void validateAboutTabTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAboutTab", "TC_45: To verify About tab");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		informationpageta = new InformationPageTA();
		informationpageta.aboutTab();
		extentTest.log(extentTest.getStatus(), "Verify About Tab");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}
