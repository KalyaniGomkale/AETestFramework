package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.pagesTenantAdmin.HomePageTA;
import com.ae.qa.pagesTenantAdmin.LicenseDetailsPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestDataHandler;

public class LicenseDetailsPageTestTA extends TestBase {
	LicenseDetailsPageTA licensedetailspageta;
	TestDataHandler testdata=new TestDataHandler();

	public LicenseDetailsPageTestTA() {
		super();
	}
/*not added now
	@Test(priority=1)
	public void validateSelectAllColumnsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSelectAllColumnsTest", "TC_020:Verify License Details tab-Select All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		licensedetailspageta = new LicenseDetailsPageTA();
		licensedetailspageta.validateSelectAllColumns();
		extentTest.log(extentTest.getStatus(), "Tenant added successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}*/
	@Test(priority=170)
	public void validateLicenseDetailsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateSearchFunctionalityTest", "TC_Additional:Verify Clicking License Details tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		licensedetailspageta = new LicenseDetailsPageTA();
		licensedetailspageta.validateLicenseDetailsPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "License Details Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}
