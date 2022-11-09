package com.ae.qa.testcasesWorkflowAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WorkflowAdmin.AgentListPageWA;
import com.ae.qa.util.ExcelHandler;

public class AgentListPageTestWA extends TestBase{
	AgentListPageWA agentlistpagewa;
	
	public AgentListPageTestWA() {
		super();
	}

	@Test(priority=88)
	public void validateAssistedAgentDownloadWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAssistedAgentDownloadWATest", "TC_5: To verify can download and register Assisted Agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		agentlistpagewa = new AgentListPageWA();
		agentlistpagewa.validateAssistedAgentDownloadWA(TestDataInMap.get("UserName"),TestDataInMap.get("AgentName"));
		extentTest.log(extentTest.getStatus(), "Assisted Agent registered successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=89)
	public void validateCheckAgentStatusWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCheckAgentStatusWATest", "TC_Additional: To verify check status of assisted Agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		agentlistpagewa = new AgentListPageWA();
		agentlistpagewa.validateCheckAgentStatusWA();
		extentTest.log(extentTest.getStatus(), "Assisted Agent status checked successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
}
