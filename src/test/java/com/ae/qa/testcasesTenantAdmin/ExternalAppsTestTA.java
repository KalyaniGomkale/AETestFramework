package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.ExternalAppsPageTA;
import com.ae.qa.util.ExcelHandler;

public class ExternalAppsTestTA extends TestBase {
	ExternalAppsPageTA externalappspageta;

	public ExternalAppsTestTA() {
		super();
	}
	 @Test(priority=182)
		public void validateExternalAppsPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateExternalAppsPageTATest", "TC_Additional:Verify Clicking External Apps tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			externalappspageta = new ExternalAppsPageTA();
			externalappspageta.validateExternalAppsPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "External Apps Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

}
