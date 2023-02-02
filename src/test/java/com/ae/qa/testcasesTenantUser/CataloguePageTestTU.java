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
	@Test(priority=96)//29
	public void validateSubmitReqDefaultCategoryTUTest(Method method) throws Exception {
	   extentTest = extent.createTest("validateSubmitReqDefaultTUCategory", "TC_8: Verify can submit request for default category");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
	   cataloguepagetu = new CataloguePageTU(); 
	   cataloguepagetu.validateSubmitReqDefaultCategory(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("TUser1"),TestDataInMap.get("TUser2"),TestDataInMap.get("Permission"));
	   extentTest.log(extentTest.getStatus(), "Request from default category is submitted successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());	
  }
}