package com.ae.qa.testcasesTenantAdmin;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.FileManagementPageTA;
import com.ae.qa.pagesTenantAdmin.SmtpPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class SmtpPageTestTA extends TestBase {
	SmtpPageTA smtppageta;

	public SmtpPageTestTA() {
		super();
	}

	@Test(priority = 118)
	public void validateAddSmtpServerTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAddSmtpServerTATest", "TC_486: Verify user able to set smtp connection");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		smtppageta = new SmtpPageTA();
		smtppageta.validateSetSmtpServerTA(TestDataInMap.get("Host"),TestDataInMap.get("Port"),TestDataInMap.get("SmtpUserName"),
				TestDataInMap.get("SmtpPswd"),TestDataInMap.get("encryptType"),TestDataInMap.get("PersonalName"));
		extentTest.log(extentTest.getStatus(), "SMTP connection done successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 119,dependsOnMethods="validateAddSmtpServerTATest")
	public void validateEditSmtpServerTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditSmtpServerTATest", "TC_487: Verify user able to edit smtp details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		smtppageta = new SmtpPageTA();
		smtppageta.validateEditSmtpServerTA(TestDataInMap.get("PersonalName"));
		extentTest.log(extentTest.getStatus(), "SMTP details edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//closure test case
	@Test(priority = 553,dependsOnMethods="validateAddSmtpServerTATest")
 	public void validateDeleteSmtpServerTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteSmtpServerTATest", "TC_488: Verify user is able to delete smtp details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		smtppageta = new SmtpPageTA();
		smtppageta.validateDeleteSmtpServerTA();
		extentTest.log(extentTest.getStatus(), "SMTP details delete successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	 @Test(priority=199)
		public void validateSMTPPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateSMTPPageTATest", "TC_Additional:Verify Clicking SMTP tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			smtppageta = new SmtpPageTA();
			smtppageta.validateSMTPPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "SMTP Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}
}
