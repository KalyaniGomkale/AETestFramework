package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.PurgePolicyPage;
import com.ae.qa.pagesTenantAdmin.EmailReportsPageTA;
import com.ae.qa.pagesTenantAdmin.PurgePolicyPageTA;
import com.ae.qa.util.ExcelHandler;

public class PurgePolicyPageTestTA extends TestBase {
//	LoginPage loginpage;
	PurgePolicyPageTA purgepolicypageta;

	public PurgePolicyPageTestTA() {
		super();
	}
	
	@Test(priority = 117)
	public void validateUpdationPurgePolicyDurationTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateUpdatePurgePolicyTATest","TC_455:To verify that TA is able to modify default purging values for each of the tables");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		purgepolicypageta = new PurgePolicyPageTA();
	//	purgepolicyspage.validateUpdationPurgePolicyDuration(TestDataInMap.get(WfRequests), TestDataInMap.get(AuditLogs),TestDataInMap.get(NotificationHistory));
		purgepolicypageta.validateUpdationPurgePolicyDurationTA(TestDataInMap.get("WfRequests"), TestDataInMap.get("AuditLogs"),TestDataInMap.get("NotificationHistory"));
		extentTest.log(extentTest.getStatus(), "TA can update different purging entity successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	 @Test(priority=191)
		public void validatePurgePolicyPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validatePurgePolicyPageTATest", "TC_Additional:Verify Clicking Purge Policy tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			purgepolicypageta = new PurgePolicyPageTA();
			purgepolicypageta.validatePurgePolicyPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Purge Policy Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}
}
