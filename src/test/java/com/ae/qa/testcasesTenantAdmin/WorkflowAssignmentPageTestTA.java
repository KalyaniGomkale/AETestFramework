package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.pagesTenantAdmin.RequestsPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowAssignmentPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class WorkflowAssignmentPageTestTA extends TestBase{
	WorkflowAssignmentPageTA workflowassignmentpageta;

	public WorkflowAssignmentPageTestTA() {
		super();
	}

	@Test(priority=72)
	public void validateSingleWorkflowAssignmentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSingleWorkflowAssignmentTest", "Verify user is able to assign single workflow to default agent ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowassignmentpageta = new WorkflowAssignmentPageTA();
		workflowassignmentpageta.validateSingleWorkflowAssignment(TestDataInMap.get("wfName"));
		extentTest.log(extentTest.getStatus(), "Workflow assigned to agent successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=178)
	public void validateWorkflowAssignmentPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateWorkflowAssignmentPageTATest", "TC_Additional:Verify Clicking Workflow Assignment tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowassignmentpageta = new WorkflowAssignmentPageTA();
		workflowassignmentpageta.validateWorkflowAssignmentPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Workflow Assignment Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=709)
	public void validateMultipleWorkflowAssignmentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateMultipleWorkflowAssignmentTest", "TC_142:To verify multiple workflows can get assigned to agent");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowassignmentpageta = new WorkflowAssignmentPageTA();
		workflowassignmentpageta.validateMultipleWorkflowAssignment();
		extentTest.log(extentTest.getStatus(), "Muliple Workflow assigned to agent successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

}
