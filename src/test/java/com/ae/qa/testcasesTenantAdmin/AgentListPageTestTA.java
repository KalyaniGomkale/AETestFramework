package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.AgentAdmin.AgentListPageAA;
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.pagesTenantAdmin.SchedulerPageTA;
import com.ae.qa.util.ExcelHandler;

public class AgentListPageTestTA extends TestBase {
	AgentListPageTA agentlistpageta;

	public AgentListPageTestTA() {
		super();
	}

	@Test(priority=70)
	public void validateDownloadAgentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadAgentTest", "TC_227: Verify if user can download & register agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.downloadAgent();
		extentTest.log(extentTest.getStatus(), "Agent registered successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=71)
	public void validateCheckStatusOfAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateCheckStatusOfAgent", "TC_361: Verify status of agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.checkStatusOfAgent();
		extentTest.log(extentTest.getStatus(), "Agent registered successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=88)
	public void validatecheckColumnsInAgentList(Method method) throws Exception {
		extentTest = extent.createTest("validatecheckColumnsInAgentList", "TC_241:To Verify - Show colum check all option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.checkColumnsInAgentList();
		extentTest.log(extentTest.getStatus(), "Check All option on Agent List validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=89)
	public void validatedeselectAllInAgentListTA(Method method) throws Exception {
		extentTest = extent.createTest("validatedeselectAllInAgentListTA", "TC_242:To Verify - Show colum Uncheck all option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.deselectAllInAgentListTA();
		extentTest.log(extentTest.getStatus(), "UnCheck All option on Agent List validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=90)
	public void validateSpecificColumnInAgentList(Method method) throws Exception {
		extentTest = extent.createTest("validateSpecificColumnInAgentList", "TC_243:To Verify - Specific column get display");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.SpecificColumnInAgentList();
		extentTest.log(extentTest.getStatus(), "Specific column get displayed successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=308)
	public void validateDeleteAgentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteAgentTest", "TC_: Verify Delete Agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateDeleteAgent(TestDataInMap.get("AgentName"));	
		extentTest.log(extentTest.getStatus(), "Agent Deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//Regression test case
	@Test(priority=310)
	public void validateDownloadAssistedAgentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadAssistedAgentTest", "TC_: Verify if user can download & register Assisted agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.downloadAssistedAgent();		
		extentTest.log(extentTest.getStatus(), "Assisted Agent registered successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=311)
	public void validatecheckStatusOfAssistedAgent(Method method) throws Exception {
		extentTest = extent.createTest("validatecheckStatusOfAssistedAgent", "TC_: Verify status of Assisted agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.checkStatusOfAssistedAgent();		
		extentTest.log(extentTest.getStatus(), "Assisted Agent status is checked successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=309)
	public void validateassignAssistedAgentToUser(Method method) throws Exception {
		extentTest = extent.createTest("validateassignAssistedAgentToUser", "TC_132: Veify able to assign Assisted agent to Users with Enterprise licese");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.assignAssistedAgentToUser(TestDataInMap.get("UserName"));		
		extentTest.log(extentTest.getStatus(), "Assisn To User registered successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=316)
	public void validateunassignAssistedAgentToUser(Method method) throws Exception {
		extentTest = extent.createTest("validateunassignAssistedAgentToUser", "TC_133: Verify able to unassign assisted agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.unassignAssistedAgentToUser(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("TabName"));		
		extentTest.log(extentTest.getStatus(), "Assisn To User registered successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=313)
	public void ValidateEditAssistedAgentName(Method method) throws Exception {
		extentTest = extent.createTest("ValidateEditAssistedAgentName", "TC_135: Verify Edit Agent Name");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateEditAssistedAgentName(TestDataInMap.get("AgentName"));	
		extentTest.log(extentTest.getStatus(), "Edit Agent Name Successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//Regression test case
	@Test(priority=314)
	public void validateDeleteAssistedAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteAssistedAgent", "TC_: Verify Delete Assisted Agent");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateDeleteAgent(TestDataInMap.get("AgentName"));	
		extentTest.log(extentTest.getStatus(), "Agent Deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=334)
	public void validateAgentRestartTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentRestartTest", "TC_114: Verify Agent Restart");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAgentRestart();	
		extentTest.log(extentTest.getStatus(), "Agent Restart Successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	/*@Test(priority=462)
	public void validateAgentCpuUtilizationTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentCpuUtilizationTest", "TC_116:Verify CPU utilization");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAgentCpuUtilization("DELL@DESKTOP-5VHKQUJ","Agent Monitoring");
		extentTest.log(extentTest.getStatus(), "CPU utilization is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=464)
	public void validateAgentMemoryUtilizationTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentMemoryUtilizationTest", "TC_117:Verify Memory utilization");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAgentMemoryUtilization("DELL@DESKTOP-5VHKQUJ","Agent Monitoring");
		extentTest.log(extentTest.getStatus(), "Memory utilization is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=465)
	public void validateAgentHeapSizeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentHeapSizeTest", "TC_118:Verify Heap Size");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAgentHeapSize("DELL@DESKTOP-5VHKQUJ","Agent Monitoring");
		extentTest.log(extentTest.getStatus(), "Heap Size is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	@Test(priority=177)
	public void validateAgentListPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentListPageTATest", "TC_Additional:Verify Clicking Agent List tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAgentListPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Agent List Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	/*@Test
	public void validateAgentUpTimeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAgentUpTimeTest", "TC_113:Verfiy Agent Uptime ");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAgentUpTime();
		extentTest.log(extentTest.getStatus(), "Agent uptime is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	//For Agent Name
	@Test(priority = 3179)
	public void validateAdvSearchForAgentNameEqualToAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameEqualToAgentsPageTATest", "TC_009: To Verfiy Advance search for Agent name with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForAgentNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Agent Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3180)
	public void validateAdvSearchForAgentNameNotEqualToAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameNotEqualToAgentsPageTATest", "TC_009: To Verfiy Advance search for Agent name with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForAgentNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Agent Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3181)
	public void validateAdvSearchForAgentNameIsLikeAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameIsLikeAgentsPageTATest", "TC_009: To Verfiy Advance search for Agent name with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForAgentNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Agent Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3182)
	public void validateAdvSearchForAgentNameBeginsWithAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameBeginsWithAgentsPageTATest", "TC_009: To Verfiy Advance search for Agent name with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForAgentNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Agent Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3183)
	public void validateAdvSearchForAgentNameEndsWithAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameEndsWithAgentsPageTATest", "TC_009: To Verfiy Advance search for Agent name with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForAgentNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Agent Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Status 
	@Test(priority = 3184)
	public void validateStatusDropdownEqualToAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToAgentsPageTATest", "TC_009: To Verfiy Advance search for Status with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateStatusDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Status is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3185)
	public void validateStatusDropdownNotEqualToAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToAgentsPageTATest", "TC_009: To Verfiy Advance search for Status with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateStatusDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Status is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Execution Thread
	@Test(priority = 3186)
	public void validateAdvSearchForExecutionThreadEqualToAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadEqualToAgentsPageTATest", "TC_355:Verify advance search for Execution Thread equal to criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForExecutionThreadEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3187)
	public void validateAdvSearchForExecutionThreadNotEqualToAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadNotEqualToAgentsPageTATest", "TC_355:Verify advance search for Execution Thread not equal to criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForExecutionThreadNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with not equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3188)
	public void validateAdvSearchForExecutionThreadLessThanAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadLessThanAgentsPageTATest", "TC_355:Verify advance search for Execution Thread less than criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForExecutionThreadLessThan(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with less than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	} 
	@Test(priority = 3189)
	public void validateAdvSearchForExecutionThreadGreaterThanAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadGreaterThanAgentsPageTATest", "TC_355:Verify advance search for Execution Thread greater than criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForExecutionThreadGreaterThan(TestDataInMap.get("AdvancedSearchsheetname"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with greater than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	} 
	@Test(priority = 3190)
	public void validateAdvSearchForExecutionThreadInRangeAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadInRangeAgentsPageTATest", "TC_355:Verify advance search for Execution Thread in range criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForExecutionThreadInRange(TestDataInMap.get("AdvancedSearchsheetname"),TestDataInMap.get("Criterion"),
				TestDataInMap.get("SearchData"),TestDataInMap.get("SearchData1"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3191)
	public void validateAdvSearchForExecutionThreadNotInRangeAgentsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForExecutionThreadNotInRangeAgentsPageTATest", "TC_355:Verify advance search for Execution Thread for not in range criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		agentlistpageta = new AgentListPageTA();
		agentlistpageta.validateAdvSearchForExecutionThreadNotInRange(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),
				TestDataInMap.get("SearchData"),TestDataInMap.get("SearchData1"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Execution Thread with not in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
}

