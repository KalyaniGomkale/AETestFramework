package com.ae.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SystemUsersPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class SystemUsersPageTest extends TestBase {
	SystemUsersPage systemuserspage;

	public SystemUsersPageTest() {
		super();
	}

	@Test(priority = 5)
	public void creatingSystemAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("creatingSystemAdminTest", "TC_008: Verify create System User");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.creatingSystemAdmin(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"), TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),
				TestDataInMap.get("UserName"), TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"));
		extentTest.log(extentTest.getStatus(), "System User created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());

	}

	@Test(priority = 6)
	public void validateEditSystemUsers(Method method) throws Exception {
		extentTest = extent.createTest("ValidateEditSystemUsersTest", "TC_009: Verify Edit System User");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.EditSystemUsers(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"), TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),
				TestDataInMap.get("UserName"), TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"), TestDataInMap.get("NewEmailID"));
		extentTest.log(extentTest.getStatus(), "System User edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 7)
	public void validatePasswordMismatch(Method method) throws Exception {
		extentTest = extent.createTest("validatePasswordMismatch", "TC_014: Verify creating sysadmin with Password mismatch");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.creatingSystemAdminWithWrongPswd(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"), TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),
				TestDataInMap.get("UserName"), TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"));
		extentTest.log(extentTest.getStatus(), "Password Mismatch gave error message");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 703)
	public void validateCreatingTenantLicenseAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateCreatingTenantLicenseAdminTest", "TC_Additional: Verify create Tenant License Admin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.creatingTenantLicenseAdmin(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"), TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),
				TestDataInMap.get("UserName"), TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"));		
		extentTest.log(extentTest.getStatus(), "Tenant License Admin created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 462)
	public void uploadLicenseForTenantLicenseAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("uploadLicenseForTenantLicenseAdminTest", "TC_Additional: Verify Upload license with sysadmin with role Tenant licnese admin");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.uploadLicenseForTenantLicenseAdmin("SYSADMIN","TenantLicense","Admin","TenantLicenseAdmin@gmail.com","TLA01","Pune@123","Pune@123","Tenant License Admin","Pune@1234");		
		extentTest.log(extentTest.getStatus(), "System User created successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 704)
	public void validateEditTenantLicenseAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditTenantLicenseAdminTest", "TC_Additional: Verify Edit tenant license admin user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateEditTenantLicenseAdmin(TestDataInMap.get("UserName"),TestDataInMap.get("NewEmailID"),TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"));		
		extentTest.log(extentTest.getStatus(), "Tenant License Admin edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=153)
	public void validateSystemUsersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSystemUsersPageTest", "TC_Additional:Verify Clicking system users tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateSystemUsersPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "System Users page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	/*@Test(priority=800)
	public void validateDeleteSystemAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteSystemAdminTest", "TC_13:Verify Delete Sysadmin");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateDeleteSystemAdmin("SYSADMIN","Sysadmin","3","sys@abc.com","Sysadmin3","Pune@123","Pune@123","System Admin");
		extentTest.log(extentTest.getStatus(), "Sysadmin is deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
	
    //For Username
	@Test(priority = 3016)
	public void validateAdvSearchForUserNameEqualToSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEqualToSystemUserPageTest", "TC_009: To Verfiy Advance search for username with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForUserNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3017)
	public void validateAdvSearchForUserNameNotEqualToSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameNotEqualToSystemUserPageTest", "TC_009: To Verfiy Advance search for username with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForUserNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3018)
	public void validateAdvSearchForUserNameIsLikeSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameIsLikeSystemUserPageTest", "TC_009: To Verfiy Advance search for username with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForUserNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3019)
	public void validateAdvSearchForUserNameBeginsWithSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithSystemUserPageTest", "TC_009: To Verfiy Advance search for username with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForUserNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3020)
	public void validateAdvSearchForUserNameEndsWithSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithSystemUserPageTest", "TC_009: To Verfiy Advance search for username with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForUserNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For First Name
	@Test(priority = 3021)
	public void validateAdvSearchForFirstNameEqualToSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEqualToSystemUserPageTest", "TC_009: To Verfiy Advance search firstname with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForFirstNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3022)
	public void validateAdvSearchForFirstNameNotEqualToSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameNotEqualToSystemUserPageTest", "TC_009: To Verfiy Advance search for firstname with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForFirstNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3023)
	public void validateAdvSearchForFirstNameIsLikeSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameIsLikeSystemUserPageTest", "TC_009: To Verfiy Advance search for firstname with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForFirstNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3024)
	public void validateAdvSearchForFirstNameBeginsWithSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameBeginsWithSystemUserPageTest", "TC_009: To Verfiy Advance search for firstname with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForFirstNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3025)
	public void validateAdvSearchForFirstNameEndsWithSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithSystemUserPageTest", "TC_009: To Verfiy Advance search for firstname with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForFirstNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Last Name
	@Test(priority = 3026)
	public void validateAdvSearchForLastNameEqualToSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEqualToSystemUserPageTest", "TC_009: To Verfiy Advance search for lastname with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForLastNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3027)
	public void validateAdvSearchForLastNameNotEqualToSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameNotEqualToSystemUserPageTest", "TC_009: To Verfiy Advance search for lastname with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForLastNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3028)
	public void validateAdvSearchForLastNameIsLikeSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameIsLikeSystemUserPageTest", "TC_009: To Verfiy Advance search for lastname with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForLastNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3029)
	public void validateAdvSearchForLastNameBeginsWithSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameBeginsWithSystemUserPageTest", "TC_009: To Verfiy Advance search for lastname with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForLastNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3030)
	public void validateAdvSearchForLastNameEndsWithSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEndsWithSystemUserPageTest", "TC_009: To Verfiy Advance search for lastname with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForLastNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}

//For Created [Calender]
	@Test(priority = 3031)
	public void validateCreatedEqualToSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToSystemUserPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3032)
	public void validateCreatedBeforeSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedBeforeSystemUserPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3033)
	public void validateCreatedAfterSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedAfterSystemUserPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3034)
	public void validateCreatedInBetweenSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedInBetweenSystemUserPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3035)
	public void validateCreatedNotInBetweenSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedNotInBetweenSystemUserPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	
	//For Last Updated
	@Test(priority = 3036)
	public void validateLastUpdatedCreatedEqualToSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedEqualToSystemUserPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateLastUpdatedCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3037)
	public void validateLastUpdatedCreatedBeforeSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedBeforeSystemUserPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateLastUpdatedCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3038)
	public void validateLastUpdatedCreatedAfterSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedAfterSystemUserPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateLastUpdatedCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3039)
	public void validateLastUpdatedCreatedInBetweenSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedInBetweenSystemUserPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateLastUpdatedCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3040)
	public void validateLastUpdatedCreatedNotInBetweenSystemUserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedNotInBetweenSystemUserPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateLastUpdatedCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
}
