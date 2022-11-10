package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.IPWhitelistingPageTA;
import com.ae.qa.util.ExcelHandler;

public class IPWhitelistingPageTestTA extends TestBase {
	IPWhitelistingPageTA ipwhitelistingpageta;

	public IPWhitelistingPageTestTA() {
		super();
	}
	 @Test(priority=179)
		public void validateIPWhitelistingPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateIPWhitelistingPageTATest", "TC_Additional:Verify Clicking IP Whitelisting tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			ipwhitelistingpageta = new IPWhitelistingPageTA();
			ipwhitelistingpageta.validateIPWhitelistingPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "IP Whitelisting Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

}
