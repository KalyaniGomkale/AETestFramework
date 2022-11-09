package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.EmailReportsPageTA;
import com.ae.qa.util.ExcelHandler;

public class EmailReportsPageTestTA extends TestBase {
	EmailReportsPageTA emailreportspageta;

	public EmailReportsPageTestTA() {
		super();
	}
	@Test(priority=322)
	public void validateEmailReportsDailyTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailReportsDailyTest", "TC_200:Verify email notification for schedule type Daily with Report duration daily");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailreportspageta = new EmailReportsPageTA();
		emailreportspageta.validateEmailReportsDaily("Sanity","Daily","10","00","2022","Apr","27","Daily","User-wise Average Execution Time",
				"PDF");
		extentTest.log(extentTest.getStatus(), "Email notification for schedule type Daily with Report duration daily is done successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=323)
	public void validateEmailReportsWeeklyTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailReportsWeeklyTest", "TC_201:Verify email notification for schedule type Daily with Report duration weekly");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailreportspageta = new EmailReportsPageTA();
		emailreportspageta.validateEmailReportsWeekly("Sanity1","Weekly","Monday","10","00","2022","May","27","Weekly","User-wise Average Execution Time",
				"PDF");
		extentTest.log(extentTest.getStatus(), "Email notification for schedule type Weekly with Report duration daily is done successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=323)
	public void validateEmailReportsMonthlyTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailReportsMonthlyTest", "TC_202:Verify email notification for schedule type Daily with Report duration monthly");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailreportspageta = new EmailReportsPageTA();
		emailreportspageta.validateEmailReportsMonthly("Sanity2","Monthly","Day of Week","Monday","First","10","00","2022","May","27","Monthly","User-wise Average Execution Time",
				"PDF");
		extentTest.log(extentTest.getStatus(), "Email notification for schedule type Monthly with Report duration daily is done successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=189)
	public void validateEmailReportsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailReportsPageTATest", "TC_Additional:Verify Clicking Email Reports tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailreportspageta = new EmailReportsPageTA();
		emailreportspageta.validateEmailReportsPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Email Reports Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

}
