package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AgentLogsPageTA;
import com.ae.qa.pagesTenantAdmin.ExternalAppsPageTA;
import com.ae.qa.util.ExcelHandler;

public class AgentLogsPageTestTA extends TestBase {
	AgentLogsPageTA agentlogspageta;

	public AgentLogsPageTestTA() {
		super();
	}

	@Test(priority = 95)
	public void validateAgentLogsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentLogsTest", "TC_360: Verify download agent logs");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlogspageta= new AgentLogsPageTA();
		agentlogspageta.validateAgentLogs(TestDataInMap.get("RequestType"),TestDataInMap.get("AgentName"),TestDataInMap.get("startYear"),TestDataInMap.get("startMonth"),
				TestDataInMap.get("startDate"),TestDataInMap.get("endYear"),TestDataInMap.get("endMonth"),TestDataInMap.get("endDate"));
		extentTest.log(extentTest.getStatus(), "Agent logs downloaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 96)
	public void validateWorkflowLogsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateWorkflowLogsTest", "TC_363: Verify download workflow logs");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlogspageta= new AgentLogsPageTA();
		agentlogspageta.validateWorkflowLogs(TestDataInMap.get("WfInstanceID"));
		extentTest.log(extentTest.getStatus(), "Workflow logs downloaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=184)
	public void validateAgentLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentLogsPageTATest", "TC_Additional:Verify Clicking Agent Logs tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlogspageta= new AgentLogsPageTA();
		agentlogspageta.validateAgentLogsPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Agent Logs Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority = 319)
	public void validateAssistedAgentLogsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAssistedAgentLogsTest", "TC_159: Verify download Assisted agent logs");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlogspageta= new AgentLogsPageTA();
		//agentlogspageta.validateAgentLogs(TestDataInMap.get("RequestType"),TestDataInMap.get("AgentName"),TestDataInMap.get("startYear"),TestDataInMap.get("startMonth"),
		//TestDataInMap.get("startDate"),TestDataInMap.get("endYear"),TestDataInMap.get("endMonth"),TestDataInMap.get("endDate"));
		agentlogspageta.validateAgentLogs("Assisted Agent","DELL@DESKTOP-5VHKQUJ","2022","Apr","25","2022","Apr","26");
		extentTest.log(extentTest.getStatus(), "Assisted Agent logs downloaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}
