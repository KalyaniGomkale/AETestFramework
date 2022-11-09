package com.ae.qa.testcasesUserAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.UserAdmin.UserGroupsPageUA;

import com.ae.qa.util.ExcelHandler;

public class UserGroupsPageTestUA extends TestBase{
	UserGroupsPageUA usergroupspageua;
	// String sheetName="TenantUserData";

	public UserGroupsPageTestUA() {
		super();
	}

	/*@Test(priority=20)
	public void validateCreateUserGroupUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateUserGroupUATest", "TC_22: To verify create Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		usergroupspageua.createUserGroupUA(TestDataInMap.get("userGroup"),TestDataInMap.get("userGrpDesc"));
		extentTest.log(extentTest.getStatus(), "It will create new User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}


	@Test (priority=21)
	public void validateEditUserGroupUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditUserGroupUATest", "TC_23:To verify edit user Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		System.out.println(TestDataInMap.get("userGroup")+TestDataInMap.get("updateDesc"));
		usergroupspageua.editUserGroupUA(TestDataInMap.get("userGroup"),TestDataInMap.get("updateDesc"));
		extentTest.log(extentTest.getStatus(), "It will edit User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}

	@Test (priority=22)
	public void validateAddUserToGroupUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAddUserToGroupUATest", "TC_24:To verify adding user to user Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		usergroupspageua.addUserToGroupUA(TestDataInMap.get("userGroup"),TestDataInMap.get("TUser1"));
		extentTest.log(extentTest.getStatus(), "It will add users to User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}

	@Test (priority=23)
	public void validateRemoveUserFromGroupUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateRemoveUserFromGroupUATest", "TC_25:To verify removing user from user Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		usergroupspageua.removeUserFromGroupUA(TestDataInMap.get("userGroup"),TestDataInMap.get("TUser1"));
		extentTest.log(extentTest.getStatus(), "It will remove users from User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}
	@Test (priority=24)
	public void addMultipleUserToGroupUATest(Method method) throws Exception {
		extentTest = extent.createTest("addMultipleUserToGroupUATest", "TC_27:To verify adding user to user Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		usergroupspageua.addMultipleUserToGroupUA(TestDataInMap.get("userGroup"),TestDataInMap.get("TUser1"),TestDataInMap.get("TUser2"));
		extentTest.log(extentTest.getStatus(), "It will add users to User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}
	//Need to keep these test case in closure activities
	@Test (priority=561,alwaysRun=true)
	public void validateDeleteUserGroupUATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteUserGroupUATest", "TC_26: To verify Delete Group");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("UAsheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		usergroupspageua.deleteUserGroupUA(TestDataInMap.get("userGroup"));
		extentTest.log(extentTest.getStatus(), "It will delete User Group");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("UAsheetname"), "Pass", method.getName());
	}*/
	//For Username
	@Test
	public void validateAdvSearchForGroupNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForGroupNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		usergroupspageua.validateAdvSearchForGroupNameEqualTo("Group Name", "equal to","UserAdminGroup","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Group Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForGroupNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForGroupNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		usergroupspageua.validateAdvSearchForGroupNameNotEqualTo("Group Name", "not equal to","HRGroup1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Group Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForGroupNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForGroupNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		usergroupspageua.validateAdvSearchForGroupNameIsLike("Group Name", "is like","Group","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Group Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForGroupNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForGroupNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		usergroupspageua.validateAdvSearchForGroupNameBeginsWith("Group Name", "begins with","User","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Group Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForGroupNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForGroupNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		usergroupspageua= new UserGroupsPageUA();
		usergroupspageua.validateAdvSearchForGroupNameEndsWith("Group Name", "ends with","Group","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Group Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}


}
