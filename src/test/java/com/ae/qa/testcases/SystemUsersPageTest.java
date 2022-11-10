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
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.creatingTenantLicenseAdmin("SYSADMIN","Tenant","License Admin","TenantLicenseAdmin@gmail.com","TLAdmin01","Pune@123","Pune@123","Tenant License Admin");		
		extentTest.log(extentTest.getStatus(), "Tenant License Admin created successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
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
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateEditTenantLicenseAdmin("TLAdmin01","TLA01@gmail.com","Pune@123","Pune@1234");		
		extentTest.log(extentTest.getStatus(), "Tenant License Admin edited successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
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
	
/*	//For Username
	@Test
	public void validateAdvSearchForUserNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForUserNameEqualTo("Username", "equal to","sysadmin","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForUserNameNotEqualTo("Username", "not equal to","sysadmin","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForUserNameIsLike("Username", "is like","ys","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForUserNameBeginsWith("Username", "begins with","sy","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForUserNameEndsWith("Username", "ends with","min","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For First Name
	@Test
	public void validateAdvSearchForFirstNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForFirstNameEqualTo("First Name", "equal to","sysadmin","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForFirstNameNotEqualTo("First Name", "not equal to","sysadmin","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForFirstNameIsLike("First Name", "is like","ys","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForFirstNameBeginsWith("First Name", "begins with","sy","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForFirstNameEndsWith("First Name", "ends with","min","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Last Name
	@Test(priority = 1)
	public void validateAdvSearchForLastNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForLastNameEqualTo("SYSADMIN","Hdfc","Bank","hdf@abc.com",
				"HDFC01","Pune@123","Pune@123","System Admin","Last Name", "equal to","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForLastNameNotEqualTo("Last Name", "not equal to","Bank","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForLastNameIsLike("Last Name", "is like","min","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForLastNameBeginsWith("Last Name", "begins with","ad","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateAdvSearchForLastNameEndsWith("Last Name", "ends with","Admin","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

//For Created [Calender]
	@Test
	public void validateCreatedEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchOrgEndsWithCreatedNotBetweenTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateCreatedEqualTo("exact date","2022","Jul","6","50");
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
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateCreatedBefore("before","2022","Jul","27","50");
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
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateCreatedAfter("after","2022","Jul","6","50");
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
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateCreatedInBetween("in between","2022","Jul","6","2022","Aug","1","50");
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
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	//For Last Updated
	@Test
	public void validateLastUpdatedCreatedEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateLastUpdatedCreatedEqualTo("exact date","2022","Jul","6","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateLastUpdatedCreatedBeforeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedBeforeTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateLastUpdatedCreatedBefore("before","2022","Jul","27","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateLastUpdatedCreatedAfterTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedAfterTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateLastUpdatedCreatedAfter("after","2022","Jul","6","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateLastUpdatedCreatedInBetweenTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedInBetweenTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateLastUpdatedCreatedInBetween("in between","2022","Jul","6","2022","Aug","1","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateLastUpdatedCreatedNotInBetweenTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedNotInBetweenTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		systemuserspage = new SystemUsersPage();
		systemuserspage.validateLastUpdatedCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
}
