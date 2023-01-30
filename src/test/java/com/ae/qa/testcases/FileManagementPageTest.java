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
	//For File Name
	@Test(priority = 3088)
	public void validateAdvSearchForFileNameEqualToFileManagementPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFileNameEqualToFileManagementPageTest", "TC_009: To Verfiy Advance search for file name with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateAdvSearchForFileNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for File Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3089)
	public void validateAdvSearchForFileNameNotEqualToFileManagementPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFileNameNotEqualToFileManagementPageTest", "TC_009: To Verfiy Advance search for file name with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateAdvSearchForFileNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for File Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3090)
	public void validateAdvSearchForFileNameIsLikeFileManagementPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFileNameIsLikeFileManagementPageTest", "TC_009: To Verfiy Advance search for file name with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateAdvSearchForFileNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for File Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3091)
	public void validateAdvSearchForFileNameBeginsWithFileManagementPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFileNameBeginsWithFileManagementPageTest", "TC_009: To Verfiy Advance search for file name with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateAdvSearchForFileNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for File Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3092)
	public void validateAdvSearchForFileNameEndsWithFileManagementPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForFileNameEndsWithFileManagementPageTest", "TC_009: To Verfiy Advance search for file name with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateAdvSearchForFileNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for File Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Uploaded [Calender]
	@Test(priority = 3093)
	public void validateUploadedEqualToFileManagementPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadedEqualToFileManagementPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3094)
	public void validateUploadedBeforeFileManagementPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadedBeforeFileManagementPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3095)
	public void validateUploadedAfterFileManagementPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadedAfterFileManagementPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3096)
	public void validateUploadedInBetweenFileManagementPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadedInBetweenFileManagementPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3097)
	public void validateUploadedNotInBetweenFileManagementPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadedNotInBetweenFileManagementPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		filemanagementpage= new FileManagementPage();
		filemanagementpage.validateUploadedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}

}
