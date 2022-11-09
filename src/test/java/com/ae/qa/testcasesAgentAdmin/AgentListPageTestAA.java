package com.ae.qa.testcasesAgentAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.ActivityMonitor.AgentListPageAM;
import com.ae.qa.pages.AgentAdmin.AgentListPageAA;
import com.ae.qa.pages.WorkflowAdmin.DashboardsPageWA;
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.util.ExcelHandler;


public class AgentListPageTestAA extends TestBase{
	AgentListPageAA agentlistpageaa;

	public AgentListPageTestAA() {
		super();
	}

	/*@Test(priority=92)
	public void validateEditAssistedAgentNameAATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditAssistedAgentNameAATest", "TC_15: Verify Edit Assisted Agent Name");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateEditAssistedAgentNameAA(TestDataInMap.get("AgentName"));	
		extentTest.log(extentTest.getStatus(), "Edit Assisted Agent Name Successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}
	@Test(priority=93)
	public void validateDeleteAssistedAgentAATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteAssistedAgentAATest", "TC_16: Verify delete Assisted Agent ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateDeleteAssistedAgentAA(TestDataInMap.get("AgentName"));	
		extentTest.log(extentTest.getStatus(), "Assisted Agent deleted Successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}
	@Test(priority=98)
	public void downloadAgentAATest(Method method) throws Exception {
		extentTest = extent.createTest("downloadAgentAATest", "TC_1: To verify able to download agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.downloadAgentAA();	
		extentTest.log(extentTest.getStatus(), "Agent downloaded Successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}
	@Test(priority=99)
	public void checkStatusOfAgentAATest(Method method) throws Exception {
		extentTest = extent.createTest("checkStatusOfAgentAATest", "TC_additional: Verify check agent status");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.checkStatusOfAgent();	
		extentTest.log(extentTest.getStatus(), "Agent status checked successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}
	@Test(priority=100)
	public void validateEditAgentNameAATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditAgentNameAATest", "TC_8: Verify Edit Agent Name");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateEditAgentNameAA(TestDataInMap.get("AgentName"));	
		extentTest.log(extentTest.getStatus(), "Edit Agent Name Successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}
	@Test(priority=101)
	public void validateEditIPAddressTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditIPAddressTest", "TC_10: To verify edit IP Address");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateEditIPAddress(TestDataInMap.get("AgentIPAddress"));	
		extentTest.log(extentTest.getStatus(), "IP Address is changed successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}
	@Test(priority=106)
	public void validateStopAgentAATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStopAgentAATest", "TC_11: To verify agent get stop");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateStopAgentAA();	
		extentTest.log(extentTest.getStatus(), "Agent is stopped successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}
	@Test(priority =107 ,alwaysRun=true)
	public void validateDeleteAgentAATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteAgentAATest", "TC_12: To verify delete agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateDeleteAgentAA();
		extentTest.log(extentTest.getStatus(), "Agent is deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AAsheetname"), "Pass", method.getName());
	}*/
	//For Agent Name
	@Test
	public void validateAdvSearchForAgentNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForAgentNameEqualTo("Agent Name", "equal to","DELL@DESKTOP-5VHKQUJ","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForAgentNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForAgentNameNotEqualTo("Agent Name", "not equal to","DELL@DESKTOP-5VHKQUJ123","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForAgentNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForAgentNameIsLike("Agent Name", "is like","DESKTOP","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForAgentNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForAgentNameBeginsWith("Agent Name", "begins with","DELL","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForAgentNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForAgentNameEndsWith("Agent Name", "ends with","5VHKQUJ","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For Status 
	@Test
	public void validateStatusDropdownEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateStatusDropdownEqualTo("Status", "equal to","RUNNING","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateStatusDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateStatusDropdownNotEqualTo("Status", "not equal to","STOPPED","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Execution Thread
	@Test
	public void validateAdvSearchForExecutionThreadEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadEqualToTest", "TC_355:Verify advance search for Execution Thread equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForExecutionThreadEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForExecutionThreadNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadNotEqualToTest", "TC_355:Verify advance search for Execution Thread not equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForExecutionThreadNotEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with not equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForExecutionThreadLessThanTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadLessThanTest", "TC_355:Verify advance search for Execution Thread less than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForExecutionThreadLessThan(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with less than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test
	public void validateAdvSearchForExecutionThreadGreaterThanTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadGreaterThanTest", "TC_355:Verify advance search for Execution Thread greater than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForExecutionThreadGreaterThan(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with greater than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test
	public void validateAdvSearchForExecutionThreadInRangeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadInRangeTest", "TC_355:Verify advance search for Execution Thread in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForExecutionThreadInRange(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("AdvSearchFor2"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForExecutionThreadNotInRangeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadNotInRangeTest", "TC_355:Verify advance search for Execution Thread for not in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageaa = new AgentListPageAA();
		agentlistpageaa.validateAdvSearchForExecutionThreadNotInRange(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("AdvSearchFor2"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with not in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}
