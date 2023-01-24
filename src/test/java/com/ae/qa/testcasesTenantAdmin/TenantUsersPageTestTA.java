package com.ae.qa.testcasesTenantAdmin;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.pagesTenantAdmin.HomePageTA;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class TenantUsersPageTestTA extends TestBase {
	TenantUsersPageTA tenantuserspageta;
	// String sheetName="TenantUserData";

	public TenantUsersPageTestTA() {
		super();
	}

	@Test(priority=44)
	public void ValidateCreatingWorkflowAdminTest(Method method) throws Exception { 
		extentTest = extent.createTest("ValidateCreatingWorkflowAdminTest","TC_023: To verify create WF Admin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta=new TenantUsersPageTA();
		tenantuserspageta.creatingUser(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
				TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
				TestDataInMap.get("role"));
		extentTest.log(extentTest.getStatus(), "It will add new workflow admin");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=45)
	public void ValidateCreatingTenantAdminTest(Method method) throws Exception { 
		extentTest = extent.createTest("ValidateCreatingTenantUserTest","TC_025: To verify create Tenant Admin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta=new TenantUsersPageTA();
		tenantuserspageta.creatingUser(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
				TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
				TestDataInMap.get("role")); 
		extentTest.log(extentTest.getStatus(), "It will add new Tenant Admin");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=46)
	public void ValidateCreatingUserAdminTest(Method method) throws Exception { 
		extentTest = extent.createTest("ValidateCreatingUserAdminTest","TC_028: To verify create User Admin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta=new TenantUsersPageTA();
		tenantuserspageta.creatingUser(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
				TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
				TestDataInMap.get("role")); 
		extentTest.log(extentTest.getStatus(), "It will add new User Admin");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=47)
	public void ValidateCreatingTenantUserTest(Method method) throws Exception { 
		extentTest = extent.createTest("ValidateCreatingTenantUserTest","TC_024: To verify create Tenant User");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta=new TenantUsersPageTA();
		tenantuserspageta.valiateCreatingTenantUser(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
				TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
				TestDataInMap.get("role")); 
		extentTest.log(extentTest.getStatus(), "It will add Tenant User");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=79)
	public void ValidateUnverifiedStatusTest(Method method) throws Exception { 
		extentTest = extent.createTest("ValidateUnverifiedStatusTest","TC_Sanity40: To verify UNVERIFIED user status functionality");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta=new TenantUsersPageTA();
		tenantuserspageta.ValidateUnverifiedStatus(TestDataInMap.get("userType"),TestDataInMap.get("fName"),TestDataInMap.get("lName"),
				TestDataInMap.get("emailId"),TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("cnfPswd"),
				TestDataInMap.get("role")); 
		extentTest.log(extentTest.getStatus(), "It will verify status of Tenant User successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test(priority=80)
	public void ValidateActiveStatusTest(Method method) throws Exception { 
		extentTest = extent.createTest("ValidateActiveStatusTest","TC_Sanity44: To verify ACTIVE user status functionality");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta=new TenantUsersPageTA();
		tenantuserspageta.ValidateActiveStatus(TestDataInMap.get("UserName"),TestDataInMap.get("Pswd"),TestDataInMap.get("NewPswd")); 
		extentTest.log(extentTest.getStatus(), "It will verify Active status of Tenant User successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=127)
	public void valiateEnableLockedUserTest(Method method) throws Exception { 
		extentTest = extent.createTest("valiateEnableLockedUserTest","TC_048: To verify TA can enable locked user ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta=new TenantUsersPageTA();
		tenantuserspageta.valiateEnableLockedUser(TestDataInMap.get("UserName"),TestDataInMap.get("Action"),
				TestDataInMap.get("NewPswd"),TestDataInMap.get("cnfPswd")); 
		extentTest.log(extentTest.getStatus(), "TA enabled locked user successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=171)
	public void validateTenantUsersPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateTenantUsersPageTATest", "TC_Additional:Verify Clicking Home tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta=new TenantUsersPageTA();
		tenantuserspageta.validateTenantUsersPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Home Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=303)
	public void ValidateBulkUserUploadWithEmailTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateBulkUserUploadWithEmailTest", "TC_060: To verify can we upload Native Users with email id");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.bulkUserUploadWithEmail("NATIVE",prop.getProperty("BulkUserUploadEmail"),"rohil","rohil@12aX","Pune@1234");
		extentTest.log(extentTest.getStatus(), "User is able to upload Bulk Native Users");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=304)
	public void ValidateBulkUserUploadWithoutEmailTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateBulkUserUploadWithoutEmailTest", "TC_062: To verify can we upload Native Users without email id");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.bulkUserUploadWithoutEmail("NATIVE",prop.getProperty("BulkUserUploadWithoutEmail"),"suyash","suyash@12aX","Pune@1234");
		extentTest.log(extentTest.getStatus(), "User is able to upload Bulk Native Users");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

	}
	@Test(priority=326)
	public void ValidateUnlockUserAccessApplicationTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateUnlockUserAccessApplicationTest", "TC_248:-To verify whether the above unlocked user is able to access the application, after change password");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateUnlockUserAccessApplication("Native Users","MadhuRani","5","MadhuRani@gmail.com","MadhuRani5",
				"Pune@123","Pune@123","Tenant User","Pune@123","Pune@1234","Pune@123",4,"MadhuRani5",
				"Pune@1234","Pune@1234","Pune@12345","Madhu@123");
		extentTest.log(extentTest.getStatus(), "Unlocked user after changed passowrd is able to access the application successfully");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

	}
	@Test(priority=317)
	public void ValidateEnableUser(Method method) throws Exception {
		extentTest = extent.createTest("ValidateEnableUser", "TC_34: To verify whether TenantAdmin is able to Enable a Disabled user(Tuser1)");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateEnableUser("TenantUser1","Pune@123","Pune@1234","Enable User");
		extentTest.log(extentTest.getStatus(), "Tenant Admin is able to enable the disabled user ");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

	}
	@Test(priority=331)
	public void ValidateDisabledUserTuserTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateDisabledUserTest", "TC_53: To verify user disabled functionality with tenant admin user(Tuser1)");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateDisabledUserTuser("Native Users","Tenant","User3","TenantUser3@gmail.com","TenantUser3",
				"Pune@123","Pune@123","Tenant User","Pune@123","Pune@1234");
		extentTest.log(extentTest.getStatus(), "Tenant Admin is able to disabled user");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=332)
	public void validateDisabledDeleteTuserTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDisabledDeleteTuserTest", "TC_54: To verify user disabled Delete functionality with Tenant admin user(Tuser1)");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateDisabledDeleteTsuer("TenantUser3","Enable User","1");
		extentTest.log(extentTest.getStatus(), "Tenant Admin is able to delete the disabled user");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

	}
	@Test(priority=730)
	public void validateCreateActivityMonitorSpaceInUsernameTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateActivityMonitorSpaceInUsernameTest", "TC_26:To verify can create user with role activity monitor(space in Username)and get access per role");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreateActivityMonitorSpaceInUsername("Native Users","Actvity","Monitor","AM@abc.com","AM Role1",
				"Pune@123","Pune@123","Activity Monitor","Pune@1234");
		extentTest.log(extentTest.getStatus(), "Activity Monitor role wit space in username is created successfully");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=731)
	public void validateCreateAgentAdminApostropheLastnameTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateAgentAdminApostropheLastnameTest", "TC_27:To verify can create user with role agent admin(apostrophe in last name)and get access per role");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreateAgentAdminApostropheLastname("Native Users","Agent","Admin's","AA@abc.com","AARole1",
				"Pune@123","Pune@123","Agent Admin","Pune@1234");
		extentTest.log(extentTest.getStatus(), "Agent admin role witd apostrophe in lastname is created successfully");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=732)
	public void validateCreateUserAdminEmailidUsernameTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateUserAdminEmailidUsernameTest", "TC_28:To verify can create user with role user admin(Emailid in Username)and get access per role");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreateUserAdminEmailidUsername("Native Users","User","Admin","UA@abc.com","UA@abc.com",
				"Pune@123","Pune@123","User Admin","Pune@1234");
		extentTest.log(extentTest.getStatus(), "User admin role with Email id  in username is created successfully");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	/*@Test(priority=339)
	public void validateEditTenantUserTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditTenantUserTest", "TC_24: To verify can edit created user");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateEditTenantUser("Native Users","WF","Admin","WFAdmin@gmail.com","WFAdmin",
				"Pune@123","Pune@123","Workflow Admin","WFAdmin1@gmail.com","Tenant User","Pune@123","Pune@1234");
		extentTest.log(extentTest.getStatus(), "Verify Edit Tenant User is verified successfully");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

	}
	@Test(priority=358)
	public void validateCreatingLDAPUserTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatingLDAPUserTest", "TC_22: To verify LDAP user can be created");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatingLDAPUser("10.51.4.56","389","automationedge.com","LDAP Users","LDAPUser1","Tenant Admin","Pune@123","Pune@1234");
		extentTest.log(extentTest.getStatus(), "LDAP User is created successfully");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());

	}*/

	//For Username
/*	@Test(priority = 3123)
	public void validateAdvSearchForUserNameEqualToTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEqualToTenantuserPageTATest", "TC_009: To Verfiy Advance search for username with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForUserNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3124)
	public void validateAdvSearchForUserNameNotEqualToTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameNotEqualTenantuserPageTATest", "TC_009: To Verfiy Advance search for username with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForUserNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3125)
	public void validateAdvSearchForUserNameIsLikeTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameIsLikeTenantuserPageTATest", "TC_009: To Verfiy Advance search for username with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForUserNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3126)
	public void validateAdvSearchForUserNameBeginsWithTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithTenantuserPageTATest", "TC_009: To Verfiy Advance search for username with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForUserNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3127)
	public void validateAdvSearchForUserNameEndsWithTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEndsWithTenantuserPageTATest", "TC_009: To Verfiy Advance search for username with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForUserNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For First Name
	@Test(priority = 3128)
	public void validateAdvSearchForFirstNameEqualToTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEqualToTenantuserPageTATest", "TC_009: To Verfiy Advance search for firstname with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForFirstNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3129)
	public void validateAdvSearchForFirstNameNotEqualToTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameNotEqualToTenantuserPageTATest", "TC_009: To Verfiy Advance search for firstname with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForFirstNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3130)
	public void validateAdvSearchForFirstNameIsLikeTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameIsLikeTenantuserPageTATest", "TC_009: To Verfiy Advance search for firstname with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForFirstNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3131)
	public void validateAdvSearchForFirstNameBeginsWithTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameBeginsWithTenantuserPageTATest", "TC_009: To Verfiy Advance search for firstname with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForFirstNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3132)
	public void validateAdvSearchForFirstNameEndsWithTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithTenantuserPageTATest", "TC_009: To Verfiy Advance search for firstname with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForFirstNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Last Name
	@Test(priority = 3133)
	public void validateAdvSearchForLastNameEqualToTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEqualToTenantuserPageTATest", "TC_009: To Verfiy Advance search for lastname with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForLastNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3134)
	public void validateAdvSearchForLastNameNotEqualToTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameNotEqualToTenantuserPageTATest", "TC_009: To Verfiy Advance search for lastname with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForLastNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3135)
	public void validateAdvSearchForLastNameIsLikeTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameIsLikeTenantuserPageTATest", "TC_009: To Verfiy Advance search for lastname with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForLastNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3136)
	public void validateAdvSearchForLastNameBeginsWithTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameBeginsWithTenantuserPageTATest", "TC_009: To Verfiy Advance search for lastname with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForLastNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3137)
	public void validateAdvSearchForLastNameEndsWithTAdminTenantuserPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEndsWithTAdminTenantuserPageTest", "TC_009: To Verfiy Advance search for lastname with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForLastNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Created [Calender]
	@Test(priority = 3138)
	public void validateCreatedEqualToTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToTenantuserPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3139)
	public void validateCreatedBeforeTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedBeforeTenantuserPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3140)
	public void validateCreatedAfterTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedAfterTenantuserPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3141)
	public void validateCreatedInBetweenTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedInBetweenTenantuserPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3142)
	public void validateCreatedNotInBetweenTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedNotInBetweenTenantuserPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
    //For Last Updated
	@Test(priority = 3143)
	public void validateLastUpdatedCreatedEqualToTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedEqualToTenantuserPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateLastUpdatedCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3144)
	public void validateLastUpdatedCreatedBeforeTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedBeforeTenantuserPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateLastUpdatedCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3145)
	public void validateLastUpdatedCreatedAfterTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedAfterTenantuserPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateLastUpdatedCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3146)
	public void validateLastUpdatedCreatedInBetweenTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedInBetweenTenantuserPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateLastUpdatedCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3147)
	public void validateLastUpdatedCreatedNotInBetweenTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedNotInBetweenTenantuserPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateLastUpdatedCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	// For State 
	@Test(priority = 3148)
	public void validateStateDropdownEqualToTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownEqualToTenantuserPageTATest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateStateDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3149)
	public void validateStateDropdownNotEqualToTenantuserPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownNotEqualToTenantuserPageTATest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateStateDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}*/
}
