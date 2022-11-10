package com.ae.qa.testcasesActivityMonitor;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.ActivityMonitor.AgentListPageAM;
import com.ae.qa.pages.AgentAdmin.AgentListPageAA;
import com.ae.qa.util.ExcelHandler;

public class AgentListPageTestAM extends TestBase{
	AgentListPageAM agentlistpageam;

	public AgentListPageTestAM() {
		super();
	}
	/*@Test(priority=102)
	public void validateAgentDetailsAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentDetailsAMTest", "TC_14: To verify able to view Agent details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAgentDetailsAM(TestDataInMap.get("AgentName"));
		extentTest.log(extentTest.getStatus(), "Agent Details are verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority=103)
	public void checkColumnsInAgentListAMTest(Method method) throws Exception {
		extentTest = extent.createTest("checkColumnsInAgentListAMTest", "TC_17: To verify show column Check all Option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.checkColumnsInAgentListAM();
		extentTest.log(extentTest.getStatus(), "Show column check all option is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority=104)
	public void deselectAllInAgentListAMTest(Method method) throws Exception {
		extentTest = extent.createTest("deselectAllInAgentListAMTest", "TC_18: To verify show column UnCheck all Option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.deselectAllInAgentListAM();
		extentTest.log(extentTest.getStatus(), "Show column Uncheck all option is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority=105)
	public void SpecificColumnInAgentListAMTest(Method method) throws Exception {
		extentTest = extent.createTest("SpecificColumnInAgentListAMTest", "TC_19: To verify show column specific column get display");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.SpecificColumnInAgentListAM();
		extentTest.log(extentTest.getStatus(), "Show column specific column get display is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AMsheetname"), "Pass", method.getName());
	}
	@Test(priority=91)
	public void  validateAssistedAgentDetailsAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAssistedAgentDetailsAMTest", "TC_20: To verify able to view Assisted Agent details");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AMsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAssistedAgentDetailsAM(TestDataInMap.get("AgentName"));
		extentTest.log(extentTest.getStatus(), "Assisted Agent Details are verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty(""), "Pass", method.getName());
	}*/
	//For Agent Name
	@Test
	public void validateAdvSearchForAgentNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForAgentNameEqualTo("Agent Name", "equal to","DELL@DESKTOP-5VHKQUJ","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForAgentNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForAgentNameNotEqualTo("Agent Name", "not equal to","DELL@DESKTOP-5VHKQUJ123","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForAgentNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForAgentNameIsLike("Agent Name", "is like","DESKTOP","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForAgentNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForAgentNameBeginsWith("Agent Name", "begins with","DELL","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForAgentNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForAgentNameEndsWith("Agent Name", "ends with","5VHKQUJ","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For Status 
	@Test
	public void validateStatusDropdownEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateStatusDropdownEqualTo("Status", "equal to","RUNNING","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateStatusDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateStatusDropdownNotEqualTo("Status", "not equal to","STOPPED","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Execution Thread
	@Test
	public void validateAdvSearchForExecutionThreadEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadEqualToTest", "TC_355:Verify advance search for Execution Thread equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForExecutionThreadEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForExecutionThreadNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadNotEqualToTest", "TC_355:Verify advance search for Execution Thread not equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForExecutionThreadNotEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with not equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForExecutionThreadLessThanTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadLessThanTest", "TC_355:Verify advance search for Execution Thread less than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForExecutionThreadLessThan(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with less than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test
	public void validateAdvSearchForExecutionThreadGreaterThanTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadGreaterThanTest", "TC_355:Verify advance search for Execution Thread greater than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForExecutionThreadGreaterThan(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with greater than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test
	public void validateAdvSearchForExecutionThreadInRangeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadInRangeTest", "TC_355:Verify advance search for Execution Thread in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForExecutionThreadInRange(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("AdvSearchFor2"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForExecutionThreadNotInRangeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadNotInRangeTest", "TC_355:Verify advance search for Execution Thread for not in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageam = new AgentListPageAM();
		agentlistpageam.validateAdvSearchForExecutionThreadNotInRange(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("AdvSearchFor2"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with not in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}