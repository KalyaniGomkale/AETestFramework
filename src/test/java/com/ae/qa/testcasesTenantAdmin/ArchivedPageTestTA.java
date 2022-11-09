package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.ArchivedPageTA;
import com.ae.qa.util.ExcelHandler;

public class ArchivedPageTestTA extends TestBase {
	ArchivedPageTA archivedpageta;

	public ArchivedPageTestTA() {
		super();
	}
	 @Test(priority=193)
		public void validateArchivedPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateArchivedPageTATest", "TC_Additional:Verify Clicking Archived tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			archivedpageta = new ArchivedPageTA();
			archivedpageta.validateArchivedPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Archived Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

}
