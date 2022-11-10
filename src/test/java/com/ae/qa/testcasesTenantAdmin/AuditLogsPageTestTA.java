package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AuditLogsPageTA;
import com.ae.qa.pagesTenantAdmin.ExternalAppsPageTA;
import com.ae.qa.util.ExcelHandler;

public class AuditLogsPageTestTA extends TestBase {
	AuditLogsPageTA auditlogspageta;

	public AuditLogsPageTestTA() {
		super();
	}

	//No data required
		@Test(priority = 75)
	public void validatedownloadingAuditLogsTA(Method method) throws Exception {
		extentTest = extent.createTest("validatedownloadingAuditLogsTA", "TC_368: Verify download audit logs for TA");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.downloadingAuditLogsTA();
		extentTest.log(extentTest.getStatus(), "Audit Logs for TA downloading started successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority = 76)
	public void validatecheckColumnsInAuditLogsTA(Method method) throws Exception {
		extentTest = extent.createTest("validatecheckColumnsInAuditLogsTA", "TC_373: Verify show columns TA- Check All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.checkColumnsInAuditLogsTA();
		extentTest.log(extentTest.getStatus(), "Select All options checked and verified in table for TA successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority = 77)
	public void validatedeselectAllInAuditLogsTA(Method method) throws Exception {
		extentTest = extent.createTest("validatedeselectAllInAuditLogsTA", "TC_374: Verify show columns TA- Uncheck All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.deselectAllInAuditLogsTA();
		extentTest.log(extentTest.getStatus(), "Deselect All options checked and verified in table for TA successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority = 78)
	public void verifySpecificColumnTestTA(Method method) throws Exception {
		extentTest = extent.createTest("verifySpecificColumnTestTA", "TC_375: Verify show columns for TA- specific column get display ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.verifySpecificColumnTA();
		extentTest.log(extentTest.getStatus(), "It will check specific columns for TA in the table");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	 @Test(priority=185)
		public void validateAuditLogsPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateAuditLogsPageTATest", "TC_Additional:Verify Clicking Audit Logs tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateAuditLogsPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Audit Logs Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}

/*	@Test (priority = 32)
	public void verifycheckLogsTest(Method method) throws Exception  {
		extentTest = extent.createTest("verifycheckLogsTest", "TC_031: Verify whether logs are shown in table for last activities ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.checkLogs(TestDataInMap.get("ServerURL"),TestDataInMap.get("cleanUpRequestHour"));
		extentTest.log(extentTest.getStatus(), "Logs are shown in table for last activities are validated.");	
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

	}
	// For Entity
	@Test
	public void validateEntityDropdownEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateEntityDropdownEqualTo("Entity", "equal to","USER","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateEntityDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateEntityDropdownNotEqualTo("Entity", "not equal to","USER","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For Source
	@Test
	public void validateSourceDropdownEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateSourceDropdownEqualTo("Source", "equal to","AGENT","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateSourceDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateSourceDropdownNotEqualTo("Source", "not equal to","AGENT","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Username
	@Test
	public void validateAdvSearchForUserNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForUserNameEqualTo("Username", "equal to","MadhuRani2","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForUserNameNotEqualTo("Username", "not equal to","MadhuRani2","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForUserNameIsLike("Username", "is like","Rani","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForUserNameBeginsWith("Username", "begins with","Madhu","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForUserNameEndsWith("Username", "ends with","Rani1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Source IP
		@Test
		public void validateAdvSearchForSourceIPEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForSourceIPEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateAdvSearchForSourceIPEqualTo("Source IP", "equal to","127.0.0.1","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForSourceIPNotEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForSourceIPNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateAdvSearchForSourceIPNotEqualTo("Source IP", "not equal to","127.0.0.1","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForSourceIPIsLikeTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForSourceIPIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateAdvSearchForSourceIPIsLike("Source IP", "is like","168","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForSourceIPBeginsWithTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForSourceIPBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateAdvSearchForSourceIPBeginsWith("Source IP", "begins with","192","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForSourceIPEndsWithTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForSourceIPEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateAdvSearchForSourceIPEndsWith("Source IP", "ends with","1","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
	// For Operation
		@Test
		public void validateOperationDropdownEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateOperationDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateOperationDropdownEqualTo("Operation", "equal to","AUTHENTICATE","50");
			extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateOperationDropdownNotEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateOperationDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateOperationDropdownNotEqualTo("Operation", "not equal to","AUTHENTICATE","50");
			extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		//For Created [Calender]
		@Test
		public void validateCreatedEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateCreatedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateCreatedEqualTo("exact date","2022","Aug","12","50");
			//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
			//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
			//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
			extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
			//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateCreatedBeforeTest(Method method) throws Exception {
			extentTest = extent.createTest("validateCreatedBeforeTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateCreatedBefore("before","2022","Aug","15","50");
			//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
			//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
			//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
			extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
			//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateCreatedAfterTest(Method method) throws Exception {
			extentTest = extent.createTest("validateCreatedAfterTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateCreatedAfter("after","2022","Aug","10","50");
			//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
			//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
			//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
			extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
			//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateCreatedInBetweenTest(Method method) throws Exception {
			extentTest = extent.createTest("validateCreatedInBetweenTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateCreatedInBetween("in between","2022","Jul","6","2022","Aug","13","50");
			//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
			//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
			//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
			extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
			//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateCreatedNotInBetweenTest(Method method) throws Exception {
			extentTest = extent.createTest("validateCreatedNotInBetweenTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			auditlogspageta = new AuditLogsPageTA();
			auditlogspageta.validateCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
			//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
			//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
			//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
			extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
			//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
	// For Status
	@Test
	public void validateStatusDropdownEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateStatusDropdownEqualTo("Status", "equal to","Success","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateStatusDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateStatusDropdownNotEqualTo("Status", "not equal to","Success","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For Log Level
	@Test
	public void validateLogLevelDropdownEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLogLevelDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateLogLevelDropdownEqualTo("Log Level", "equal to","INFO","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateLogLevelDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLogLevelDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateLogLevelDropdownNotEqualTo("Log Level", "not equal to","INFO","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
}
