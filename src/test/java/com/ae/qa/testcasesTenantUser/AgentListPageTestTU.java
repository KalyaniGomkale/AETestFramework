package com.ae.qa.testcasesTenantUser;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.TenantUser.AgentListPageTU;
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.util.ExcelHandler;

public class AgentListPageTestTU extends TestBase {
	AgentListPageTU agentlistpagetu;

	public AgentListPageTestTU() {
		super();
	}

	@Test(priority=94)
	public void validateAssistedAgentDownloadTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAssistedAgentDownloadTUTest", "TC_5: To verify can download and register Assisted Agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		agentlistpagetu = new AgentListPageTU();
		agentlistpagetu.validateAssistedAgentDownloadTU(TestDataInMap.get("UserName"));
		extentTest.log(extentTest.getStatus(), "Assisted Agent registered successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	@Test(priority=95)
	public void validateCheckAgentStatusTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCheckAgentStatusTUTest", "TC_Additional: To verify check status of assisted Agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		agentlistpagetu = new AgentListPageTU();
		agentlistpagetu.validateCheckAgentStatusTU();
		extentTest.log(extentTest.getStatus(), "Assisted Agent status checked successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	@Test(priority=96)
	public void validateEditAssistedAgentNameTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditAssistedAgentNameTU", "TC_6: To verify edit assisted agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		agentlistpagetu = new AgentListPageTU();
		agentlistpagetu.validateEditAssistedAgentNameTU(TestDataInMap.get("AgentName"));
		extentTest.log(extentTest.getStatus(), "Assisted Agent name not changed successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
	@Test(priority=97)
	public void validateAssistedAgentDeleteTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAssistedAgentDeleteTU", "TC_7: To verify delete assisted agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		agentlistpagetu = new AgentListPageTU();
		agentlistpagetu.validateAssistedAgentDeleteTU();
		extentTest.log(extentTest.getStatus(), "Assisted Agent Deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());
	}
}
