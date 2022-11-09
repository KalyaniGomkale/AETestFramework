package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AgentSettingsPageTA;
import com.ae.qa.util.ExcelHandler;

public class AgentSettingsTestTA extends TestBase {
	AgentSettingsPageTA agentsettingspageta;

	public AgentSettingsTestTA() {
		super();
	}
	 @Test(priority=180)
		public void validateAgentSettingsPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateAgentSettingsPageTATest", "TC_Additional:Verify Clicking Agent Settings tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			agentsettingspageta = new AgentSettingsPageTA();
			agentsettingspageta.validateAgentSettingsPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Agent Settings Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

}
