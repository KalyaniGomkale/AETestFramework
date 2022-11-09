package com.ae.qa.testcasesTenantAdmin;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.IntegrationServicesPage;
import com.ae.qa.pages.IntegrationTypesPage;
import com.ae.qa.pagesTenantAdmin.IntegrationServicesPageTA;
import com.ae.qa.pagesTenantAdmin.IntegrationTypesPageTA;
import com.ae.qa.util.ExcelHandler;

import java.lang.reflect.Method;
import java.util.Map;

public class IntegrationTypesPageTestTA extends TestBase {
	IntegrationTypesPageTA integrationtypespageta;

	public IntegrationTypesPageTestTA() {
		super();
	}

	@Test(priority=149)
	public void validateAddIntegrationTypesTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAddIntegrationTATypesTATest", "TC_470:Verfiy add integration type with default jars");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		integrationtypespageta = new IntegrationTypesPageTA();
		integrationtypespageta.validateAddIntegrationTypesTA(TestDataInMap.get("IntTypeName"),TestDataInMap.get("IntTypeDescription"));
		extentTest.log(extentTest.getStatus(), "Integration Type added successfully with default jar");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=196)
	public void validateIntegrationTypesPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateIntegrationTypesPageTATest", "TC_Additional:Verify Clicking Integration Types tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		integrationtypespageta = new IntegrationTypesPageTA();
		integrationtypespageta.validateIntegrationTypesPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Integration Types Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}
