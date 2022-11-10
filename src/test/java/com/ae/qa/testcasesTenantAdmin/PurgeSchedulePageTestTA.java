package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.PurgeSchedulePageTA;
import com.ae.qa.util.ExcelHandler;

public class PurgeSchedulePageTestTA extends TestBase {
	PurgeSchedulePageTA purgeschedulepageta;

	public PurgeSchedulePageTestTA() {
		super();
	}
	 @Test(priority=192)
		public void validatePurgeSchedulePageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validatePurgeSchedulePageTATest", "TC_Additional:Verify Clicking Purge Schedule tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			purgeschedulepageta = new PurgeSchedulePageTA();
			purgeschedulepageta.validatePurgeSchedulePageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Purge Schedule Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

}
