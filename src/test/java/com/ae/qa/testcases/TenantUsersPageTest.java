package com.ae.qa.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SystemUsersPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class TenantUsersPageTest extends TestBase {
	TenantUsersPage tenantuserspage;
	String sheetName = "TenantUserData";

	public TenantUsersPageTest() {
		super();
	}


	@Test(priority = 8)
	public void ValidateCreatingTenantAdminTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateCreatingTenantAdminTest", "TC_015: To verify create Tenant Admin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.creatingTenantUser(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"),TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),TestDataInMap.get("UserName"),
				TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"));
		extentTest.log(extentTest.getStatus(), "New Tenant Admin created successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 9)
	public void ValidateEditTenantUserTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateEditTenantUserTest", "TC_016: To verify Edit Tenant User");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.EditTenantUser(TestDataInMap.get("OrganizationCode"),TestDataInMap.get("FirstName"),TestDataInMap.get("LastName"),TestDataInMap.get("EmailId"),TestDataInMap.get("UserName"),
				TestDataInMap.get("Password"),TestDataInMap.get("CnfPassword"),TestDataInMap.get("Role"),TestDataInMap.get("NewEmailID"));	
		extentTest.log(extentTest.getStatus(), "New Tenant Admin created & edited its emailID successfully.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=154)
	public void validateTenantUsersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTenantUsersPageTest", "TC_Additional:Verify Clicking Tenant users tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateTenantUsersPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Tenant Users page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Tenant Name
	@Test(priority = 3041)
	public void validateAdvSearchForTenantNameEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForTenantNameEqualToTenantusersPageTest", "TC_009: To Verfiy Advance search tenant name with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForTenantNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3042)
	public void validateAdvSearchForTenantNameNotEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForTenantNameNotEqualToTenantusersPageTest", "TC_009: To Verfiy Advance search tenant name with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForTenantNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3043)
	public void validateAdvSearchForTenantNameIsLikeTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForTenantNameIsLikeTenantusersPageTest", "TC_009: To Verfiy Advance search tenant name with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForTenantNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3044)
	public void validateAdvSearchForTenantNameBeginsWithTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForTenantNameBeginsWithTenantusersPageTest", "TC_009: To Verfiy Advance search for tenant name with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForTenantNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3045)
	public void validateAdvSearchForTenantNameEndsWithTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForTenantNameEndsWithTenantusersPageTest", "TC_009: To Verfiy Advance search for tenant name with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForTenantNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
    //For Username
	@Test(priority = 3046)
	public void validateAdvSearchForUserNameEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEqualToTenantusersPageTest", "TC_009: To Verfiy Advance search for username with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForUserNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3047)
	public void validateAdvSearchForUserNameNotEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameNotEqualToTenantusersPageTest", "TC_009: To Verfiy Advance search for username with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForUserNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3048)
	public void validateAdvSearchForUserNameIsLikeTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameIsLikeTenantusersPageTest", "TC_009: To Verfiy Advance search for username with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForUserNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3049)
	public void validateAdvSearchForUserNameBeginsWithTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithTenantusersPageTest", "TC_009: To Verfiy Advance search for username with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForUserNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3050)
	public void validateAdvSearchForUserNameEndsWithTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithTenantusersPageTest", "TC_009: To Verfiy Advance search for username with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForUserNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For First Name
	@Test(priority = 3051)
	public void validateAdvSearchForFirstNameEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEqualToTenantusersPageTest", "TC_009: To Verfiy Advance search firstname with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForFirstNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3052)
	public void validateAdvSearchForFirstNameNotEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameNotEqualToTenantusersPageTest", "TC_009: To Verfiy Advance search for firstname with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForFirstNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3053)
	public void validateAdvSearchForFirstNameIsLikeTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameIsLikeTenantusersPageTest", "TC_009: To Verfiy Advance search for firstname with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForFirstNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3054)
	public void validateAdvSearchForFirstNameBeginsWithTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameBeginsWithTenantusersPageTest", "TC_009: To Verfiy Advance search for firstname with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForFirstNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3055)
	public void validateAdvSearchForFirstNameEndsWithTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithTenantusersPageTest", "TC_009: To Verfiy Advance search for firstname with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForFirstNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Last Name
	@Test(priority = 3056)
	public void validateAdvSearchForLastNameEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEqualToTenantusersPageTest", "TC_009: To Verfiy Advance search for lastname with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForLastNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3057)
	public void validateAdvSearchForLastNameNotEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameNotEqualToTenantusersPageTest", "TC_009: To Verfiy Advance search for lastname with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForLastNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3058)
	public void validateAdvSearchForLastNameIsLikeTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameIsLikeTenantusersPageTest", "TC_009: To Verfiy Advance search for lastname with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForLastNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3059)
	public void validateAdvSearchForLastNameBeginsWithTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameBeginsWithTenantusersPageTest", "TC_009: To Verfiy Advance search for lastname with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForLastNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3060)
	public void validateAdvSearchForLastNameEndsWithTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEndsWithTenantusersPageTest", "TC_009: To Verfiy Advance search for lastname with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateAdvSearchForLastNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Created [Calender]
	@Test(priority = 3061)
	public void validateCreatedEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToTenantusersPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3062)
	public void validateCreatedBeforeTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedBeforeTenantusersPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3063)
	public void validateCreatedAfterTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedAfterTenantusersPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3064)
	public void validateCreatedInBetweenTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedInBetweenTenantusersPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3065)
	public void validateCreatedNotInBetweenTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedNotInBetweenTenantusersPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}

	//For Last Updated
	@Test(priority = 3066)
	public void validateLastUpdatedCreatedEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedEqualToTenantusersPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateLastUpdatedCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3067)
	public void validateLastUpdatedCreatedBeforeTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedBeforeTenantusersPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateLastUpdatedCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3068)
	public void validateLastUpdatedCreatedAfterTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedAfterTenantusersPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateLastUpdatedCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3069)
	public void validateLastUpdatedCreatedInBetweenTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedInBetweenTenantusersPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateLastUpdatedCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3070)
	public void validateLastUpdatedCreatedNotInBetweenTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedNotInBetweenTenantusersPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateLastUpdatedCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For State
	@Test(priority = 3071)
	public void validateStateDropdownEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownEqualToTenantusersPageTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateStateDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3072)
	public void validateStateDropdownNotEqualToTenantusersPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownNotEqualToTenantusersPageTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspage = new TenantUsersPage();
		tenantuserspage.validateStateDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
}
