package com.ae.qa.testcasesTenantUser;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.TenantUser.SchedulerPageTU;
import com.ae.qa.pages.WorkflowAdmin.SchedulerPageWA;
import com.ae.qa.util.ExcelHandler;


public class SchedulerPageTestTU extends TestBase{
	SchedulerPageTU schedulerpagetu;

	public SchedulerPageTestTU() {
		super();
	}
	
	@Test(priority=61)
	public void validateDailyScheduleTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDailyScheduleTUTest", "TC_3: To Verify create schedule");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		schedulerpagetu = new SchedulerPageTU();
		schedulerpagetu.validateDailyScheduleTU(TestDataInMap.get("wfName"),TestDataInMap.get("ScheduleName"),TestDataInMap.get("ScheduleDesc"),TestDataInMap.get("startMonth"),TestDataInMap.get("startYear"),
				TestDataInMap.get("startDate"),TestDataInMap.get("endMonth"),TestDataInMap.get("endYear"),TestDataInMap.get("endDate"),
				TestDataInMap.get("ScheduleType"),TestDataInMap.get("TimeZone"),TestDataInMap.get("ScheduleExecHH"),TestDataInMap.get("ScheduleExecMM"));
		extentTest.log(extentTest.getStatus(), "User created schedule successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());	
	}

}
