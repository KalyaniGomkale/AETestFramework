package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.ArchivedPageTA;
import com.ae.qa.pagesTenantAdmin.ProcessStudioPageTA;
import com.ae.qa.util.ExcelHandler;

public class ProcessStudioPageTestTA extends TestBase{
	ProcessStudioPageTA processstudiopageta;

	public ProcessStudioPageTestTA() {
		super();
	}

	@Test(priority=53)
	public void validateDownloadandAssignPSTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadandAssignPSTest", "TC_585/6: Verify if user can download PS & assign ps license to TA");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		processstudiopageta = new ProcessStudioPageTA(); 
		processstudiopageta.validateDownloadandAssignPS();
		extentTest.log(extentTest.getStatus(), "PS downloaded and assigned to TA successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=337)
	public void validateUnAssignPSTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadandUnAssignPSTest", "TC_214: Verify able to unasign user");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		processstudiopageta = new ProcessStudioPageTA(); 
		processstudiopageta.validateUnAssignPS();
		extentTest.log(extentTest.getStatus(), "PS downloaded and Unassigned to TA successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=338)
	public void ValidateAssignPSToUserAsPerLicenseTest(Method method) throws Exception {
		extentTest = extent.createTest("assignPSToUserAsPerLicenseTest", "TC_213: Verify able to assign PS to user as per license");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		processstudiopageta = new ProcessStudioPageTA(); 
		processstudiopageta.validateAssignPSToUserAsPerLicense();
		extentTest.log(extentTest.getStatus(), "Assign PS to user as per license is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=194)
	public void validateProcessStudioPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateProcessStudioPageTATest", "TC_Additional:Verify Clicking Process Studio tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		processstudiopageta = new ProcessStudioPageTA(); 
		processstudiopageta.validateProcessStudioPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Process Studio Registration Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=463)
	public void validateProcessStudioDownloadLinuxTest(Method method) throws Exception {
		extentTest = extent.createTest("validateProcessStudioDownloadLinuxTest", "TC_256:Verify PS download for Linux");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		processstudiopageta = new ProcessStudioPageTA(); 
		processstudiopageta.validateProcessStudioDownloadLinux();
		extentTest.log(extentTest.getStatus(), "PS download for linux is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

}
