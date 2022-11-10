package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.FileManagementPage;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestDataHandler;


public class FileManagementPageTest extends TestBase {
	FileManagementPage filemanagementpage;


	public FileManagementPageTest() {
		super();
	}

	@Test(priority = 132)
	public void validateUploadDriverTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadDriverTest", "TC_136: Verify uploading driver file through file managment");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadDriver(TestDataInMap.get("PluginName"));
		extentTest.log(extentTest.getStatus(), "Chrome driver file uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 468)
	public void validateEditUploadDriverTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditUploadDriverTest", "TC_Additional:Verify edit above uploaded driver");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateEditUploadDriver("CHROME92.zip");
		extentTest.log(extentTest.getStatus(), "Uploaded driver is edited successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 469)
	public void validateDeleteUploadDriverTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteUploadDriverTest", "TC_Additional:Verify Delete uplaoded webgui driver file");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateDeleteUploadDriver("CHROME92.zip");
		extentTest.log(extentTest.getStatus(), "Uploaded driver is deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=164)
	public void validateFileManagmentPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTenantUsersPageTest", "TC_Additional:Verify Clicking File Managment tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateFileManagmentPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "File Managment page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
/*	//For File Name
	@Test
	public void validateAdvSearchForFileNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFileNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateAdvSearchForFileNameEqualTo("File Name", "equal to","CHROME92.zip","50");
		extentTest.log(extentTest.getStatus(), "Advance search for File Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFileNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFileNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateAdvSearchForFileNameNotEqualTo("File Name", "not equal to","CHROME921.zip","50");
		extentTest.log(extentTest.getStatus(), "Advance search for File Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFileNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFileNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateAdvSearchForFileNameIsLike("File Name", "is like","ROME","50");
		extentTest.log(extentTest.getStatus(), "Advance search for File Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFileNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFileNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateAdvSearchForFileNameBeginsWith("File Name","begins with","ch","50");
		extentTest.log(extentTest.getStatus(), "Advance search for File Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForFileNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFileNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateAdvSearchForFileNameEndsWith("File Name", "ends with","zip","50");
		extentTest.log(extentTest.getStatus(), "Advance search for File Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//For Uploaded [Calender]
	@Test
	public void validateUploadedEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadedEqualTo("exact date","2022","Aug","5","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateUploadedBeforeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadedBeforeTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadedBefore("before","2022","Aug","8","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateUploadedAfterTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadedAfterTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadedAfter("after","2022","Jul","6","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateUploadedInBetweenTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadedInBetweenTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadedInBetween("in between","2022","Jul","6","2022","Aug","8","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateUploadedNotInBetweenTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadedNotInBetweenTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/

}
