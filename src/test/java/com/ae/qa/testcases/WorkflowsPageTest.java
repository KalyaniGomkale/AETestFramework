package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.FileManagementPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.pages.WorkflowsPage;
import com.ae.qa.util.ExcelHandler;

public class WorkflowsPageTest extends TestBase {
WorkflowsPage workflowspage;


	public WorkflowsPageTest() {
		super();
	}
	
	@Test(priority = 133)
	public void validateDisableWorkflowsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDisableWorkflowsTest", "TC_xxx:Verify DISABLE workflow with reason plugin upgrade");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowspage= new WorkflowsPage();
		workflowspage.validateDisableWorkflows(TestDataInMap.get("Operation"));
		extentTest.log(extentTest.getStatus(), "Workflow DISABLED with reason plugin upgarde successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 134)
	public void validateEnableWorkflowsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEnableWorkflowsTest", "TC_XXX: Verify ENABLE workflow with reason plugin upgrade");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowspage= new WorkflowsPage();
		workflowspage.validateEnableWorkflows(TestDataInMap.get("Operation"));
		extentTest.log(extentTest.getStatus(), "Workflow ENabled with reason plugin upgarde successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority=155)
	public void validateWorkflowsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateWorkflowsPageTest", "TC_Additional:Verify Clicking Workflows tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowspage= new WorkflowsPage();
		workflowspage.validateWorkflowsPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Workflows page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
}


