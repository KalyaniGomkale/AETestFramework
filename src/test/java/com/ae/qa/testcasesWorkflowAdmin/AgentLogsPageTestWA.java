package com.ae.qa.testcasesWorkflowAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WorkflowAdmin.AgentLogsPageWA;
import com.ae.qa.util.ExcelHandler;


public class AgentLogsPageTestWA extends TestBase{
	AgentLogsPageWA agentlogspagewa;

	public AgentLogsPageTestWA() {
		super();
	}

	/*@Test(priority = 402)
	public void validateAgentLogsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentLogsTest", "TC_89: Verify download agent logs");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		agentlogspagewa= new AgentLogsPageWA();
		agentlogspagewa.validateAgentLogs("Agent","DELL@DESKTOP-5VHKQUJ","2022","May","22","2022","May","23");
		extentTest.log(extentTest.getStatus(), "Agent logs downloaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}*/
	@Test(priority = 90)
	public void validateWorkflowLogsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateWorkflowLogsTest", "TC_90: Verify download workflow logs");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		agentlogspagewa= new AgentLogsPageWA();
		agentlogspagewa.validateWorkflowLogs(TestDataInMap.get("WfInstanceID"));
		extentTest.log(extentTest.getStatus(), "Workflow logs downloaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	/*@Test(priority = 404)
	public void validateAssistedAgentLogsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAssistedAgentLogsTest", "TC_91: Verify download Assisted agent logs");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		agentlogspagewa= new AgentLogsPageWA();
		//agentlogspageta.validateAgentLogs(TestDataInMap.get("RequestType"),TestDataInMap.get("AgentName"),TestDataInMap.get("startYear"),TestDataInMap.get("startMonth"),
		//TestDataInMap.get("startDate"),TestDataInMap.get("endYear"),TestDataInMap.get("endMonth"),TestDataInMap.get("endDate"));
		agentlogspagewa.validateAgentLogs("Assisted Agent","DELL@DESKTOP-5VHKQUJ","2022","May","22","2022","May","23");
		extentTest.log(extentTest.getStatus(), "Assisted Agent logs downloaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}*/
}
