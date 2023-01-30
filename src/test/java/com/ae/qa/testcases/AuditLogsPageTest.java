package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.AuditLogsPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.pagesTenantAdmin.AuditLogsPageTA;
import com.ae.qa.util.ExcelHandler;

public class AuditLogsPageTest extends TestBase {
	AuditLogsPage auditlogspage;

	public AuditLogsPageTest() {
		super();
	}

	//No data required
    @Test(priority = 10)
	public void validatedownloadingAuditLogs(Method method) throws Exception {
		extentTest = extent.createTest("validatedownloadingAuditLogs", "TC_022: Verify download audit logs");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.downloadingAuditLogs();
		extentTest.log(extentTest.getStatus(), "Audit Logs downloading started successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 11)
	public void validatecheckColumnsInAuditLogs(Method method) throws Exception {
		extentTest = extent.createTest("validatecheckColumnsInAuditLogs", "TC_026: Verify show columns- Check All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.checkColumnsInAuditLogs();
		extentTest.log(extentTest.getStatus(), "Select All options checked and verified in table successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 12)
	public void validatedeselectAllInAuditLogs(Method method) throws Exception {
		extentTest = extent.createTest("validatedeselectAllInAuditLogs", "TC_027: Verify show columns- Uncheck All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.deselectAllInAuditLogs();
		extentTest.log(extentTest.getStatus(), "Deselect All options checked and verified in table successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 13)
	public void verifySpecificColumnTest(Method method) throws Exception {
		extentTest = extent.createTest("verifySpecificColumnTest", "TC_028: Verify show columns- specific column get display ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.verifySpecificColumn();
		extentTest.log(extentTest.getStatus(), "It will check specific columns in the table");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test (priority = 32)
	public void verifycheckLogsTest(Method method) throws Exception  {
		extentTest = extent.createTest("verifycheckLogsTest", "TC_031: Verify whether logs are shown in table for last activities ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.checkLogs(TestDataInMap.get("ServerURL"),TestDataInMap.get("cleanUpRequestHour"));
		extentTest.log(extentTest.getStatus(), "Logs are shown in table for last activities are validated.");	
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=156)
	public void validateLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLogsPageTest", "TC_Additional:Verify Clicking Logs tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateLogsPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Logs page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For Entity
/*	@Test(priority = 3098)
	public void validateEntityDropdownEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for Entity with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateEntityDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Entity is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3099)
	public void validateEntityDropdownNotEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownNotEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for Entity with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateEntityDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Entity is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Source
	@Test(priority = 3100)
	public void validateSourceDropdownEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for Source with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateSourceDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3101)
	public void validateSourceDropdownNotEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownNotEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for Source with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateSourceDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Username
	@Test(priority = 3102)
	public void validateAdvSearchForUserNameEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for username with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateAdvSearchForUserNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3103)
	public void validateAdvSearchForUserNameNotEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameNotEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for username with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateAdvSearchForUserNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3104)
	public void validateAdvSearchForUserNameIsLikeAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameIsLikeAuditLogsPageTest", "TC_009: To Verfiy Advance search for username with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateAdvSearchForUserNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3105)
	public void validateAdvSearchForUserNameBeginsWithAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithAuditLogsPageTest", "TC_009: To Verfiy Advance search for username with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateAdvSearchForUserNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3106)
	public void validateAdvSearchForUserNameEndsWithAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEndsWithAuditLogsPageTest", "TC_009: To Verfiy Advance search for username with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateAdvSearchForUserNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Source IP
	@Test(priority = 3107)
	public void validateAdvSearchForSourceIPEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIPEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for SourceIP with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateAdvSearchForSourceIPEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source IP is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3108)
	public void validateAdvSearchForSourceIPNotEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIPNotEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for SourceIP with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateAdvSearchForSourceIPNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source IP is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3109)
	public void validateAdvSearchForSourceIPIsLikeAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIPIsLikeAuditLogsPageTest", "TC_009: To Verfiy Advance search for SourceIP with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateAdvSearchForSourceIPIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source IP is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3110)
	public void validateAdvSearchForSourceIPBeginsWithAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIPBeginsWithAuditLogsPageTest", "TC_009: To Verfiy Advance search for SourceIP with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateAdvSearchForSourceIPBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source IP is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3111)
	public void validateAdvSearchForSourceIPEndsWithAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIPEndsWithAuditLogsPageTest", "TC_009: To Verfiy Advance search for SourceIP with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateAdvSearchForSourceIPEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source IP is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Operation
	@Test(priority = 3112)
	public void validateOperationDropdownEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateOperationDropdownEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for Operation with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateOperationDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Operation is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3113)
	public void validateOperationDropdownNotEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateOperationDropdownNotEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for Operation with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateOperationDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Operation is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Created [Calender]
	@Test(priority = 3114)
	public void validateCreatedEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToAuditLogsPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3115)
	public void validateCreatedBeforeAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedBeforeAuditLogsPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3116)
	public void validateCreatedAfterAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedAfterAuditLogsPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3117)
	public void validateCreatedInBetweenAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedInBetweenAuditLogsPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3118)
	public void validateCreatedNotInBetweenAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedNotInBetweenAuditLogsPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Status
	@Test(priority = 3119)
	public void validateStatusDropdownEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for Status with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateStatusDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Status is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3120)
	public void validateStatusDropdownNotEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for Status with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateStatusDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Status is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Log Level
	@Test(priority = 3121)
	public void validateLogLevelDropdownEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLogLevelDropdownEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for Log level with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateLogLevelDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Log level is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3122)
	public void validateLogLevelDropdownNotEqualToAuditLogsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLogLevelDropdownNotEqualToAuditLogsPageTest", "TC_009: To Verfiy Advance search for Log level with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspage = new AuditLogsPage();
		auditlogspage.validateLogLevelDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Log level is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}*/

}
