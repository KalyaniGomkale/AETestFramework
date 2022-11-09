package com.ae.qa.testcasesWorkflowAdmin;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WorkflowAdmin.CataloguePageWA;
import com.ae.qa.util.ExcelHandler;

public class CataloguePageTestWA extends TestBase{
CataloguePageWA cataloguepagewa;
	
	public CataloguePageTestWA() {
		super();
	}
	
	//Skipped due to Ui Changes
	/*@Test(priority=111)
	public void validateSubmitReqDefaultCategoryWATest(Method method) throws Exception {
	   extentTest = extent.createTest("validateSubmitReqDefaultCategoryWATest", "TC_61: Verify can submit request for default category");
	   //Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   cataloguepagewa = new CataloguePageWA(); 
	   cataloguepagewa.validateSubmitReqDefaultCategory("DefaultWF","Default");
	   extentTest.log(extentTest.getStatus(), "Request from default category is submitted successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
  }
	@Test(priority=112)
	public void validateSubmitReqDefaultCustomWATest(Method method) throws Exception {
	   extentTest = extent.createTest("validateSubmitReqCustomCategoryWATest", "TC_62: Verify can submit request for custom category");
	   //Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   cataloguepagewa = new CataloguePageWA(); 
	   cataloguepagewa.validateSubmitReqDefaultCategory("CustomWF","WebGUI");
	   extentTest.log(extentTest.getStatus(), "Request from custom category is submitted successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
  }*/
	
}
