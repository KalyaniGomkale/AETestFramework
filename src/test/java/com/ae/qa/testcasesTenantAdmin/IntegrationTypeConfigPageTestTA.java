package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ae.qa.Listeners.ITestListenerImplementation;
import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.IntegrationTypeConfigPageTA;
import com.ae.qa.pagesTenantAdmin.IntegrationTypesPageTA;
import com.ae.qa.util.ExcelHandler;

	@Listeners({ITestListenerImplementation.class})
	public class IntegrationTypeConfigPageTestTA extends TestBase {
		IntegrationTypeConfigPageTA integrationtypeconfigpageta;

		public IntegrationTypeConfigPageTestTA() {
			super();
		}
		
		@Test(priority=150)
		public void validateTypeConfBothTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateTypeConfBothTATest", "TC_475:Create Type  Configuration with IS  and IT created by Tenant Admin");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			integrationtypeconfigpageta = new IntegrationTypeConfigPageTA();
			integrationtypeconfigpageta.validateTypeConfBothTA(TestDataInMap.get("ConfigName"), TestDataInMap.get("ConfigDescp"),
					TestDataInMap.get("IntTypeName"),TestDataInMap.get("IntName"),TestDataInMap.get("TimeZone"),
					TestDataInMap.get("startDate"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
					TestDataInMap.get("endDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),
					TestDataInMap.get("RepeatAfter"),TestDataInMap.get("RepeatPeriod"),
					TestDataInMap.get("StartHour"),TestDataInMap.get("StartMin"),
					TestDataInMap.get("EndHour"),TestDataInMap.get("EndMin"),TestDataInMap.get("ConfigParamType"),
					TestDataInMap.get("ConfigParamName"),TestDataInMap.get("ConfigParamValue"));
			extentTest.log(extentTest.getStatus(), "Integration configuration created successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}
		 @Test(priority=197)
			public void validateIntegrationTypeConfigurationsTabPageTATest(Method method) throws Exception {
				extentTest = extent.createTest("validateIntegrationTypeConfigurationsTabPageTATest", "TC_Additional:Verify Clicking Integration Type configurations tab and checking that appropiate page is loaded");
				Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
				integrationtypeconfigpageta = new IntegrationTypeConfigPageTA();
				integrationtypeconfigpageta.validateIntegrationTypeConfigurationsTabPageTA(TestDataInMap.get("PageTitle"));
				extentTest.log(extentTest.getStatus(), "Integration Type configurations Page loading validated successfully");
				ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
			}

}
