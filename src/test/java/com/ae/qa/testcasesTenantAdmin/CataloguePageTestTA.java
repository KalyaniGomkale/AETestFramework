package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.pagesTenantAdmin.CataloguePageTA;
import com.ae.qa.util.ExcelHandler;

public class CataloguePageTestTA extends TestBase{
	CataloguePageTA cataloguepageta;

	public CataloguePageTestTA() {
		super();
	}

	@Test(priority=73)
	public void validateSubmitRequestTest(Method method) throws Exception {
	   extentTest = extent.createTest("validateSubmitRequestTest", "TC_082: Verify if user can submit request for specific workflow");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   cataloguepageta = new CataloguePageTA(); 
	   cataloguepageta.validateSubmitRequest(TestDataInMap.get("wfName"));
	   extentTest.log(extentTest.getStatus(), "Request for a workflow submitted successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
  }
	@Test(priority=710)
	public void validateSubmitRequestCustomCategoryTest(Method method) throws Exception {
	   extentTest = extent.createTest("validateSubmitRequestCustomCategoryTest", "TC_357: Verfiy can submit request from Custom category");
	   //Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   cataloguepageta = new CataloguePageTA(); 
	   cataloguepageta.validateSubmitRequestCustomCategory("CustomCategoryWF","For custom category","WebGUI",prop.getProperty("WFToImportPath"),"Low","20","60","3","30","Minutes");
	   extentTest.log(extentTest.getStatus(), "Submit request from custom category is verified successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
  }
	@Test(priority=711)
	public void validateSubmitRequestDefaultCategoryTest(Method method) throws Exception {
	   extentTest = extent.createTest("validateSubmitRequestDefaultCategoryTest", "TC_356: Verfiy can submit request from Default category");
	   //Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   cataloguepageta = new CataloguePageTA(); 
	   cataloguepageta.validateSubmitRequestDefaultCategory("Default","Sanity1");
	   extentTest.log(extentTest.getStatus(), "Submit request from default category is verified successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
  }
	 @Test(priority=181)
		public void validateCataloguePageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateCataloguePageTATest", "TC_Additional:Verify Clicking Catalogue tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			cataloguepageta = new CataloguePageTA(); 
			cataloguepageta.validateCataloguePageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Catalogue Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	 }

}
