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

	}

/*	//For Username
	@Test
	public void validateAdvSearchForUserNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForUserNameEqualTo("Username", "equal to","MadhuRani1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForUserNameNotEqualTo("Username", "not equal to","MadhuRani2","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForUserNameIsLike("Username", "is like","Rani","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForUserNameBeginsWith("Username", "begins with","ma","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForUserNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForUserNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForUserNameEndsWith("Username", "ends with","1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For First Name
	@Test
	public void validateAdvSearchForFirstNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForFirstNameEqualTo("First Name", "equal to","Madhu","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForFirstNameNotEqualTo("First Name", "not equal to","Madhu","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForFirstNameIsLike("First Name", "is like","an","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForFirstNameBeginsWith("First Name", "begins with","Madhu","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFirstNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFirstNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForFirstNameEndsWith("First Name", "ends with","ni","50");
		extentTest.log(extentTest.getStatus(), "Advance search for First Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Last Name
	@Test
	public void validateAdvSearchForLastNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForLastNameEqualTo("Last Name", "equal to","Admin1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForLastNameNotEqualTo("Last Name", "not equal to","Admin1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForLastNameIsLike("Last Name", "is like","min","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForLastNameBeginsWith("Last Name","begins with","1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForLastNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForLastNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateAdvSearchForLastNameEndsWith("Last Name", "ends with","Admin","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Created [Calender]
	@Test
	public void validateCreatedEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatedEqualTo("exact date","2022","Jul","6","50");
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
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatedBefore("before","2022","Jul","27","50");
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
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatedAfter("after","2022","Jul","6","50");
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
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatedInBetween("in between","2022","Jul","6","2022","Aug","1","50");
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
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
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
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateLastUpdatedCreatedEqualTo("exact date","2022","Jul","6","50");
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
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateLastUpdatedCreatedBefore("before","2022","Jul","27","50");
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
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateLastUpdatedCreatedAfter("after","2022","Jul","6","50");
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
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateLastUpdatedCreatedInBetween("in between","2022","Jul","6","2022","Aug","1","50");
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
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateLastUpdatedCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
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
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateStateDropdownEqualTo("State", "equal to","ACTIVE","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateStateDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStateDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantuserspageta = new TenantUsersPageTA(); 
		tenantuserspageta.validateStateDropdownNotEqualTo("State", "not equal to","ACTIVE","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
}
