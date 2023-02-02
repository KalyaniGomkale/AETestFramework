package com.ae.qa.testcasesWorkflowAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WorkflowAdmin.CataloguePageWA;
import com.ae.qa.util.ExcelHandler;

public class CataloguePageTestWA extends TestBase{
CataloguePageWA cataloguepagewa;
	
	public CataloguePageTestWA() {
		super();
	}
	
	
	@Test(priority=105)
	public void validateSubmitReqDefaultCategoryWATest(Method method) throws Exception {
	   extentTest = extent.createTest("validateSubmitReqDefaultCategoryWATest", "TC_61: Verify can submit request for default category");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
	   cataloguepagewa = new CataloguePageWA(); 
	   cataloguepagewa.validateSubmitReqDefaultCategory(TestDataInMap.get("wfName"),TestDataInMap.get("categoryName"));
	   extentTest.log(extentTest.getStatus(), "Request from default category is submitted successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
  }
	@Test(priority=106)
	public void validateSubmitReqCustomCategoryWATest(Method method) throws Exception {
	   extentTest = extent.createTest("validateSubmitReqCustomCategoryWATest", "TC_62: Verify can submit request for custom category");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
	   cataloguepagewa = new CataloguePageWA(); 
	   cataloguepagewa.validateSubmitReqCustomCategory(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFToImportPath"),
			   TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
	   extentTest.log(extentTest.getStatus(), "Request from custom category is submitted successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
  }
	
}
