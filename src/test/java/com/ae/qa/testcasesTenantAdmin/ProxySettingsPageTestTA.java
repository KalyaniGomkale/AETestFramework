package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.ProxySettingsPageTA;
import com.ae.qa.util.ExcelHandler;

public class ProxySettingsPageTestTA extends TestBase {
	ProxySettingsPageTA proxysettingspageta;

	public ProxySettingsPageTestTA() {
		super();
	}
	 @Test(priority=203)
		public void validateProxySettingsPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateProxySettingsPageTATest", "TC_Additional:Verify Clicking Proxy Settings tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			proxysettingspageta = new ProxySettingsPageTA();
			proxysettingspageta.validateProxySettingsPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Proxy Settings Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

}
