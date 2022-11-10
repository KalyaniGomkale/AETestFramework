package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.AuditLogsPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;

public class AuditLogsPageTest extends TestBase {
	AuditLogsPage auditlogspage;

	public AuditLogsPageTest() {
		super();
	}

//No data required
	@Test(priority = 10)
	public void validatedownloadingAuditLogs(Method method) throws Exception {
		extentTest = extent.createTest("validatedownloadingAuditLogs", "TC_022: Verify download audit logs");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.downloadingAuditLogs();
		extentTest.log(extentTest.getStatus(), "Audit Logs downloading started successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 11)
	public void validatecheckColumnsInAuditLogs(Method method) throws Exception {
		extentTest = extent.createTest("validatecheckColumnsInAuditLogs", "TC_026: Verify show columns- Check All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.checkColumnsInAuditLogs();
		extentTest.log(extentTest.getStatus(), "Select All options checked and verified in table successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 12)
	public void validatedeselectAllInAuditLogs(Method method) throws Exception {
		extentTest = extent.createTest("validatedeselectAllInAuditLogs", "TC_027: Verify show columns- Uncheck All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.deselectAllInAuditLogs();
		extentTest.log(extentTest.getStatus(), "Deselect All options checked and verified in table successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 13)
	public void verifySpecificColumnTest(Method method) throws Exception {
		extentTest = extent.createTest("verifySpecificColumnTest", "TC_028: Verify show columns- specific column get display ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.verifySpecificColumn();
		extentTest.log(extentTest.getStatus(), "It will check specific columns in the table");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test (priority = 32)
	public void verifycheckLogsTest(Method method) throws Exception  {
		extentTest = extent.createTest("verifycheckLogsTest", "TC_031: Verify whether logs are shown in table for last activities ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.checkLogs(TestDataInMap.get("ServerURL"),TestDataInMap.get("cleanUpRequestHour"));
		extentTest.log(extentTest.getStatus(), "Logs are shown in table for last activities are validated.");	
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=156)
	public void validateLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLogsPageTest", "TC_Additional:Verify Clicking Logs tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateLogsPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Logs page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	
}
