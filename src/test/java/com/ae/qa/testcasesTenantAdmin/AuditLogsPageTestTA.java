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

	}*/
   // For Entity
	@Test(priority = 3207)
	public void validateEntityDropdownEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for Entity with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateEntityDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Entity is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3208)
	public void validateEntityDropdownNotEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownNotEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for Entity with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateEntityDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Entity is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Source
	@Test(priority = 3209)
	public void validateSourceDropdownEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for Source with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateSourceDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3210)
	public void validateSourceDropdownNotEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownNotEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for Source with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateSourceDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Username
	@Test(priority = 3211)
	public void validateAdvSearchForUserNameEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for username with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForUserNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3212)
	public void validateAdvSearchForUserNameNotEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameNotEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for username with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForUserNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3213)
	public void validateAdvSearchForUserNameIsLikeAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameIsLikeAuditLogsPageTATest", "TC_009: To Verfiy Advance search for username with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForUserNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3214)
	public void validateAdvSearchForUserNameBeginsWithAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithAuditLogsPageTATest", "TC_009: To Verfiy Advance search for username with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForUserNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3215)
	public void validateAdvSearchForUserNameEndsWithAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEndsWithAuditLogsPageTATest", "TC_009: To Verfiy Advance search for username with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForUserNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Source IP
	@Test(priority = 3216)
	public void validateAdvSearchForSourceIPEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIPEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for SourceIP with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForSourceIPEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source IP is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3217)
	public void validateAdvSearchForSourceIPNotEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIPNotEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for SourceIP with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForSourceIPNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source IP is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3218)
	public void validateAdvSearchForSourceIPIsLikeAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIPIsLikeAuditLogsPageTATest", "TC_009: To Verfiy Advance search for SourceIP with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForSourceIPIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source IP is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3219)
	public void validateAdvSearchForSourceIPBeginsWithAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIPBeginsWithAuditLogsPageTATest", "TC_009: To Verfiy Advance search for SourceIP with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForSourceIPBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source IP is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3220)
	public void validateAdvSearchForSourceIPEndsWithAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIPEndsWithAuditLogsPageTATest", "TC_009: To Verfiy Advance search for SourceIP with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateAdvSearchForSourceIPEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source IP is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Operation
	@Test(priority = 3221)
	public void validateOperationDropdownEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateOperationDropdownEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for Operation with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateOperationDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Operation is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3222)
	public void validateOperationDropdownNotEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateOperationDropdownNotEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for Operation with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateOperationDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Operation is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Created [Calender]
	@Test(priority = 3223)
	public void validateCreatedEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToAuditLogsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3224)
	public void validateCreatedBeforeAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedBeforeAuditLogsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3225)
	public void validateCreatedAfterAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedAfterAuditLogsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3226)
	public void validateCreatedInBetweenAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedInBetweenAuditLogsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3227)
	public void validateCreatedNotInBetweenAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedNotInBetweenAuditLogsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Status
	@Test(priority = 3228)
	public void validateStatusDropdownEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for Status with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateStatusDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Status is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3229)
	public void validateStatusDropdownNotEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for Status with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateStatusDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Status is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For Log Level
	@Test(priority = 3230)
	public void validateLogLevelDropdownEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLogLevelDropdownEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for Log level with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateLogLevelDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Log level is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3231)
	public void validateLogLevelDropdownNotEqualToAuditLogsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLogLevelDropdownNotEqualToAuditLogsPageTATest", "TC_009: To Verfiy Advance search for Log level with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		auditlogspageta = new AuditLogsPageTA();
		auditlogspageta.validateLogLevelDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Log level is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
}
