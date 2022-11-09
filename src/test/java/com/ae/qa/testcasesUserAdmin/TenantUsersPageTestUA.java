package com.ae.qa.testcasesUserAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.UserAdmin.TenantUsersPageUA;
import com.ae.qa.util.ExcelHandler;


public class TenantUsersPageTestUA extends TestBase{
	TenantUsersPageUA tenantuserspageua;
	// String sheetName="TenantUserData";

	public TenantUsersPageTestUA() {
		super();
	}

	/*@Test(priority=9)
	public void validateCreateUserWithoutEmailUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateUserWithoutEmailUATest", "TC_1: To verify can add Native user withput Email Id");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateCreateUserWithoutEmailUA(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("UserName"),
				TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"));
		extentTest.log(extentTest.getStatus(), "Native user without Email ID is created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());

	}
	@Test(priority=88)
	public void validateCreateUserWithEmailUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateUserWithEmailUATest", "TC_3: To verify can create user with email id");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateCreateUserWithEmailUA(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),TestDataInMap.get("emailId"),
				TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),TestDataInMap.get("role"),TestDataInMap.get("NewPswd"));
		extentTest.log(extentTest.getStatus(), "User with email id is created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());

	}
	@Test(priority=93)
	public void validateEditUserUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditUserUATest", "TC_2: To verify can edit created user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateEditUserUA(TestDataInMap.get("UserName"),TestDataInMap.get("emailId"),
				TestDataInMap.get("role"),TestDataInMap.get("Pswd"));
		extentTest.log(extentTest.getStatus(), "User with email id is created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());

	}
	@Test(priority=89)
	public void validateCreateLdapUserUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateLdapUserUATest", "TC_4: To verify LDAP user can be created");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateCreateLdapUserUA("Tenant User","LDAP Users","LDAPRani1");
		tenantuserspageua.validateCreateLdapUserUA(TestDataInMap.get("role"),TestDataInMap.get("userType"),TestDataInMap.get("UserName"));
		extentTest.log(extentTest.getStatus(), "LDAP user is created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());

	}
	@Test(priority=90)
	public void validateBulkUserUploadWithEmailUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateBulkUserUploadWithEmailUATest", "TC_016 & TC_017: To verify can we upload Native Users with email id"
				+ "                                                                               To verify can login with uploaded user");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA();
		tenantuserspageua.validateBulkUserUploadWithEmailUA(TestDataInMap.get("userType"),TestDataInMap.get("TUser1"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd"));
		extentTest.log(extentTest.getStatus(), "User is able to upload Bulk Native Users with Email ID and also login with the uploaded user");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}
	//This test cases is in Regression sheet so currently skipped
	/*@Test(priority=91)
	public void validateBulkUserUploadWithoutEmailUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateBulkUserUploadWithoutEmailUATest", "TC_014: To verify can we upload Native Users without email id");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA();
		tenantuserspageua.validateBulkUserUploadWithoutEmailUA("NATIVE","F:\\Automation Edge Project\\Bulk Users\\Bulk User UA_1.csv","Agra");
		extentTest.log(extentTest.getStatus(), "User is able to upload Bulk Native Users without Email ID");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}
	//Need to update the script for this test case
	@Test(priority=92)
	public void validateBulkLdapUserUploadUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateBulkLdapUserUploadUATest", "TC_018: To verify can we upload LDAP users");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA();
		tenantuserspageua.validateBulkLdapUserUploadUA(TestDataInMap.get("userType"),TestDataInMap.get("TUser1"));
		extentTest.log(extentTest.getStatus(), "Bulk upload of LDAP user is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}*/
		//For Username
	@Test
	public void validateAdvSearchForUserNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForUserNameEqualTo("Username", "equal to","TenantUser1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForUserNameNotEqualTo("Username", "not equal to","TenantUser1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForUserNameIsLike("Username", "is like","User","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForUserNameBeginsWith("Username", "begins with","User","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForUserNameEndsWith("Username", "ends with","1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For First Name
	@Test
	public void validateAdvSearchForFirstNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForFirstNameEqualTo("First Name", "equal to","Tenant","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForFirstNameNotEqualTo("First Name", "not equal to","Tenant","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForFirstNameIsLike("First Name", "is like","nant","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForFirstNameBeginsWith("First Name", "begins with","U","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForFirstNameEndsWith("First Name", "ends with","t","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Last Name
	@Test
	public void validateAdvSearchForLastNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForLastNameEqualTo("Last Name", "equal to","Admin1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForLastNameNotEqualTo("Last Name", "not equal to","Admin1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForLastNameIsLike("Last Name", "is like","min","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForLastNameBeginsWith("Last Name","begins with","U","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateAdvSearchForLastNameEndsWith("Last Name", "ends with","1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Created [Calender]
	@Test
	public void validateCreatedEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateCreatedEqualTo("exact date","2022","Aug","12","50");
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
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateCreatedBefore("before","2022","Aug","18","50");
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
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateCreatedAfter("after","2022","Jul","6","50");
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
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateCreatedInBetween("in between","2022","Jul","6","2022","Aug","18","50");
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
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
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
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateLastUpdatedCreatedEqualTo("exact date","2022","Aug","12","50");
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
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateLastUpdatedCreatedBefore("before","2022","Aug","18","50");
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
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateLastUpdatedCreatedAfter("after","2022","Jul","6","50");
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
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateLastUpdatedCreatedInBetween("in between","2022","Jul","6","2022","Aug","18","50");
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
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateLastUpdatedCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For State 
	@Test
	public void validateStateDropdownEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateStateDropdownEqualTo("State", "equal to","ACTIVE","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateStateDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageua = new TenantUsersPageUA(); 
		tenantuserspageua.validateStateDropdownNotEqualTo("State", "not equal to","ACTIVE","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
