package com.ae.qa.testcasesTenantAdmin;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.PermissionsPageTA;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.pagesTenantAdmin.UserGroupsPageTA;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestUtil;

public class UserGroupsPageTestTA extends TestBase {
	UserGroupsPageTA usergroupspageta;
	// String sheetName="TenantUserData";

	public UserGroupsPageTestTA() {
		super();
	}

	@Test(priority=48)
	public void validateCreateUserGroup(Method method) throws Exception {
		extentTest = extent.createTest("creatingTenantUserTest", "TC_066: To verify create Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.createUserGroup(TestDataInMap.get("userGroup"),TestDataInMap.get("userGrpDesc"));
		extentTest.log(extentTest.getStatus(), "It will create new User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}


	@Test (priority=49)
	public void validateEditUserGroup(Method method) throws Exception {
		extentTest = extent.createTest("validateEditUserGroup", "TC_067:To verify edit user Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		System.out.println(TestDataInMap.get("userGroup")+TestDataInMap.get("updateDesc"));
		usergroupspageta.editUserGroup(TestDataInMap.get("userGroup"),TestDataInMap.get("updateDesc"));
		extentTest.log(extentTest.getStatus(), "It will edit User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test (priority=50)
	public void validateAddUserToGroup(Method method) throws Exception {
		extentTest = extent.createTest("validateAddUserToGroup", "TC_068:To verify adding user to user Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.addUserToGroup(TestDataInMap.get("userGroup"),TestDataInMap.get("TUser1"));
		extentTest.log(extentTest.getStatus(), "It will add users to User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test (priority=51)
	public void validateRemoveUserFromGroup(Method method) throws Exception {
		extentTest = extent.createTest("validateRemoveUserFromGroup", "TC_069:To verify removing user from user Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.removeUserFromGroup(TestDataInMap.get("userGroup"),TestDataInMap.get("TUser1"));
		extentTest.log(extentTest.getStatus(), "It will remove users from User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test (priority=52,alwaysRun=true)
	public void ValidateDuplicateUserGroupTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateDuplicateUserGroupTest", "TC_69A:To verify if user can create user Group with duplicate name");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.ValidateDuplicateUserGroup(TestDataInMap.get("userGroup"));
		extentTest.log(extentTest.getStatus(), "User with duplicate user group can't be created");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//Need to change its priority as some of tc related to group further
	@Test (priority=560,alwaysRun=true)
	public void validateDeleteUserGroup(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteUserGroupTest", "TC_070: To verify Delete Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.deleteUserGroup(TestDataInMap.get("userGroup"));
		extentTest.log(extentTest.getStatus(), "It will delete User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	/*@Test(priority=1020)
	public void validateWFAccessUserAddedInUserGroupTest(Method method) throws Exception {
		extentTest = extent.createTest("validateWFAccessUserAddedInUserGroupTest", "TC_30: Verify user get workflow access as per added group in above step");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.validateWFAccessUserAddedInUserGroup("HRGroup","Update HR new peeps","Tenant User2(TenantUser2)","Sanity1","Modify","For Sanity and pp");
		extentTest.log(extentTest.getStatus(), "User get workflow access as per added in group is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=1021, dependsOnMethods="validateWFAccessUserAddedInUserGroupTest",alwaysRun=true)
	public void validateRemoveWFPermissionTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRemoveWFPermissionTest", "TC_32: Verify remove any worfklow permission from  the group");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.validateRemoveWFPermission("HRGroup","Update HR new peeps","Sanity1","Modify","View");
		extentTest.log(extentTest.getStatus(), "Remove any workflow permission is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=1022)
	public void validateWFAccessUserRemovedFromUserGroupTest(Method method) throws Exception {
		extentTest = extent.createTest("validateWFAccessUserRemovedFromUserGroupTest", "TC_31: Verify workflow access by removing  user from group added in above step");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.validateWFAccessUserRemovedFromUserGroup("HRGroup","Tenant User2(TenantUser2)");
		extentTest.log(extentTest.getStatus(), "Workflow access after removing user from group is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	@Test(priority = 172)
	public void validateUserGroupsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateUserGroupsPageTATest",
				"TC_Additional:Verify Clicking User Groups tab and checking that appropiate page is loaded");
		Map<String, String> TestDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),
				method.getName());
		usergroupspageta = new UserGroupsPageTA();
		usergroupspageta.validateUserGroupsPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "User Groups Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	 //For Username
	@Test(priority = 3150)
	public void validateAdvSearchForGroupNameEqualToUsergroupsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForGroupNameEqualToUsergroupsPageTATest", "TC_009: To Verfiy Advance search for groupname with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.validateAdvSearchForGroupNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Group Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3151)
	public void validateAdvSearchForGroupNameNotEqualToUsergroupsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForGroupNameNotEqualToUsergroupsPageTATest", "TC_009: To Verfiy Advance search for groupname with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.validateAdvSearchForGroupNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Group Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3152)
	public void validateAdvSearchForGroupNameIsLikeUsergroupsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForGroupNameIsLikeUsergroupsPageTATest", "TC_009: To Verfiy Advance search for groupname with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.validateAdvSearchForGroupNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Group Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3153)
	public void validateAdvSearchForGroupNameBeginsWithUsergroupsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForGroupNameBeginsWithUsergroupsPageTATest", "TC_009: To Verfiy Advance search for groupname with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.validateAdvSearchForGroupNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Group Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3154)
	public void validateAdvSearchForGroupNameEndsWithUsergroupsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForGroupNameEndsWithUsergroupsPageTATest", "TC_009: To Verfiy Advance search for groupname with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		usergroupspageta= new UserGroupsPageTA();
		usergroupspageta.validateAdvSearchForGroupNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Group Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}

}
