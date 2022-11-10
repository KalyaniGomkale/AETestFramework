package com.ae.qa.testcases;

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
	/*	//For Tenant Name
		@Test
		public void validateAdvSearchForTenantNameEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForTenantNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForTenantNameEqualTo("Tenant", "equal to","KG","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForTenantNameNotEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForTenantNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForTenantNameNotEqualTo("Tenant", "not equal to","KG","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForTenantNameIsLikeTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForTenantNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForTenantNameIsLike("Tenant", "is like","K","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForTenantNameBeginsWithTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForTenantNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForTenantNameBeginsWith("Tenant", "begins with","K","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForTenantNameEndsWithTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForTenantNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForTenantNameEndsWith("Tenant", "ends with","G","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}

	//For Username
		@Test
		public void validateAdvSearchForUserNameEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForUserNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForUserNameEqualTo("Username", "equal to","MadhuRani1","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForUserNameNotEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForUserNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForUserNameNotEqualTo("Username", "not equal to","MadhuRani2","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForUserNameIsLikeTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForUserNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForUserNameIsLike("Username", "is like","Rani","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForUserNameBeginsWithTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForUserNameBeginsWith("Username", "begins with","ma","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForUserNameEndsWithTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForUserNameEndsWith("Username", "ends with","1","50");
			extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
	//For First Name
		@Test
		public void validateAdvSearchForFirstNameEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForFirstNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForFirstNameEqualTo("First Name", "equal to","Madhu","50");
			extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForFirstNameNotEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForFirstNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForFirstNameNotEqualTo("First Name", "not equal to","Madhu","50");
			extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForFirstNameIsLikeTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForFirstNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForFirstNameIsLike("First Name", "is like","an","50");
			extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForFirstNameBeginsWithTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForFirstNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForFirstNameBeginsWith("First Name", "begins with","madhu","50");
			extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		/*@Test
		public void validateAdvSearchForFirstNameEndsWithTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForFirstNameEndsWith("First Name", "ends with","ni","50");
			extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		//For Last Name
		@Test
		public void validateAdvSearchForLastNameEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForLastNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForLastNameEqualTo("Last Name", "equal to","Admin1","50");
			extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForLastNameNotEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForLastNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForLastNameNotEqualTo("Last Name", "not equal to","Admin1","50");
			extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForLastNameIsLikeTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForLastNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForLastNameIsLike("Last Name", "is like","min","50");
			extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForLastNameBeginsWithTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForLastNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForLastNameBeginsWith("Last Name","begins with","1","50");
			extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateAdvSearchForLastNameEndsWithTest(Method method) throws Exception {
			extentTest = extent.createTest("validateAdvSearchForLastNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateAdvSearchForLastNameEndsWith("Last Name", "ends with","Admin","50");
			extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
	//For Created [Calender]
		@Test
		public void validateCreatedEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateCreatedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateCreatedEqualTo("exact date","2022","Jul","6","50");
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
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateCreatedBefore("before","2022","Jul","27","50");
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
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateCreatedAfter("after","2022","Jul","6","50");
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
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateCreatedInBetween("in between","2022","Jul","6","2022","Aug","1","50");
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
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
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
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateLastUpdatedCreatedEqualTo("exact date","2022","Jul","6","50");
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
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateLastUpdatedCreatedBefore("before","2022","Jul","27","50");
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
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateLastUpdatedCreatedAfter("after","2022","Jul","6","50");
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
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateLastUpdatedCreatedInBetween("in between","2022","Jul","6","2022","Aug","1","50");
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
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateLastUpdatedCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
			//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
			//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
			//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
			extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
			//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateStateDropdownEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateStateDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateStateDropdownEqualTo("State", "equal to","ACTIVE","50");
			extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}
		@Test
		public void validateStateDropdownNotEqualToTest(Method method) throws Exception {
			extentTest = extent.createTest("validateStateDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
			//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
			tenantuserspage = new TenantUsersPage();
			tenantuserspage.validateStateDropdownNotEqualTo("State", "not equal to","ACTIVE","50");
			extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
			//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
		}*/

}
