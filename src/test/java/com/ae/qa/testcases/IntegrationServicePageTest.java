package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.IntegrationServicesPage;
import com.ae.qa.pages.PluginAssignmentsPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;

public class IntegrationServicePageTest extends TestBase {
	IntegrationServicesPage integrationservicespage;

	public IntegrationServicePageTest() {
		super();
	}
	
	@Test(priority=138)
	public void validateAddIntegrationServicesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAddIntegrationServicesTest", "TC_87: Verify adding integration services");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		integrationservicespage = new IntegrationServicesPage();
		System.out.println(TestDataInMap.get("IntName")+TestDataInMap.get("ConfLowerLimit")+TestDataInMap.get("ResponseLowerLimit")+TestDataInMap.get("MachineName")+TestDataInMap.get("IntUserName")+TestDataInMap.get("ClusterIP")+TestDataInMap.get("ClusterPort"));
		integrationservicespage.validateAddIntegrationServices(TestDataInMap.get("IntName"), TestDataInMap.get("ConfLowerLimit"),TestDataInMap.get("ResponseLowerLimit"),TestDataInMap.get("MachineName"),TestDataInMap.get("IntUserName"),TestDataInMap.get("ClusterIP"),TestDataInMap.get("ClusterPort"));
		extentTest.log(extentTest.getStatus(), "It will add integration services successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=139)
	public void validateEditIntegrationServicesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditIntegrationServicesTest", "TC_91: Verify editing integration services");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		integrationservicespage = new IntegrationServicesPage();
		integrationservicespage.validateEditIntegrationServices(TestDataInMap.get("IntName"),TestDataInMap.get("MachineName"));
		extentTest.log(extentTest.getStatus(), "It edited machine details of integration services successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=140)
	public void validateDownloadIntegrationServicesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadIntegrationServicesTest", "TC_92: Verify downloading integration services");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		integrationservicespage = new IntegrationServicesPage();
		integrationservicespage.validateDownloadIntegrationServices(TestDataInMap.get("IntName"));
		extentTest.log(extentTest.getStatus(), "Integration services downloaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=141)
	public void validateEnableIntForMultipleTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEnableIntForMultipleTATest", "TC_94:Verify enable  Integration  service for more than one  tenantadmin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		integrationservicespage = new IntegrationServicesPage();
		integrationservicespage.validateEnableIntForMultipleTA(TestDataInMap.get("TenantOrgCode1"),TestDataInMap.get("TenantOrgCode2"),
				TestDataInMap.get("AllowedNoOfConfig1"),TestDataInMap.get("AllowedNoOfConfig2"));
		extentTest.log(extentTest.getStatus(), "Integration services enabled for more than one tenant successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=162)
	public void validateIntegrationServicesPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateIntegrationServicesPageTest", "TC_Additional:Verify Clicking Integration Services tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		integrationservicespage = new IntegrationServicesPage();
		integrationservicespage.validateIntegrationServicesPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Integration Services page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
}

