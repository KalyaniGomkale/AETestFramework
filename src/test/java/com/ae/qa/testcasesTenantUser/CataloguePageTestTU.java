package com.ae.qa.testcasesTenantUser;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.TenantUser.CataloguePageTU;
import com.ae.qa.util.ExcelHandler;

public class CataloguePageTestTU extends TestBase{
	CataloguePageTU cataloguepagetu;
	
	public CataloguePageTestTU() {
		super();
	}
	//Skipped due to UI Changes
	/*@Test(priority=67)
	public void validateSubmitReqDefaultCategoryTest(Method method) throws Exception {
	   extentTest = extent.createTest("validateSubmitReqDefaultCategory", "TC_8: Verify can submit request for default category");
	   //Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   cataloguepagetu = new CataloguePageTU(); 
	   cataloguepagetu.validateSubmitReqDefaultCategory("TenantUserWF1","Default");
	   extentTest.log(extentTest.getStatus(), "Request from default category is submitted successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
  }
	@Test(priority=68)
	public void validateSubmitReqCustomCategoryTest(Method method) throws Exception {
	   extentTest = extent.createTest("validateSubmitReqCustomCategoryTest", "TC_9: Verify can submit request for custom category");
	   //Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   cataloguepagetu = new CataloguePageTU(); 
	   cataloguepagetu.validateSubmitReqDefaultCategory("TenantUserWF","WebGUI");
	   extentTest.log(extentTest.getStatus(), "Request from custom category is submitted successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
  }*/
}
