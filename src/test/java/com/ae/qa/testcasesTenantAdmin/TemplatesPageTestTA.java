package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.TemplatesPageTA;
import com.ae.qa.util.ExcelHandler;

public class TemplatesPageTestTA extends TestBase {
	TemplatesPageTA templatespageta;

	public TemplatesPageTestTA() {
		super();
	}
	 @Test(priority=188)
		public void validateTemplatesPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateTemplatesPageTATest", "TC_Additional:Verify Clicking Templates tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			templatespageta = new TemplatesPageTA();
			templatespageta.validateTemplatesPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Templates Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

}
