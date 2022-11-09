package com.ae.qa.testcasesWorkflowAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WorkflowAdmin.WorkflowListPageWA;
import com.ae.qa.util.ExcelHandler;

public class WorkflowListPageTestWA extends TestBase{
	WorkflowListPageWA workflowlistpagewa;

	public WorkflowListPageTestWA() {
		super();
	}

	/*@Test(priority=28)
	public void validateImportWFConfigParamWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWFConfigParamWATest", "TC_18:-Verfiy import PS workflow with configuration parameter");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateImportWFConfigParamWA(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("ParamValue"));
		extentTest.log(extentTest.getStatus(), "Workflow with config parameter is imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=29)
	public void validateUpdateWFConfigParamCreatedByTAdminWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateUpdateWFConfigParamCreatedByTAdminWATest", "TC_19:-Verfiy update workflow which uses config parameter created by tenant admin");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateUpdateWFConfigParamCreatedByTAdminWA(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),prop.getProperty("UpdatedConfigParamWF"),
				TestDataInMap.get("ParamValue"),TestDataInMap.get("ParamValue2"),TestDataInMap.get("ParamValue3"),TestDataInMap.get("ParamValue4"));
		extentTest.log(extentTest.getStatus(), "Update workflow which uses config parameter created by tenant admin is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=30)
	public void validateExportWFVerifiedWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateExportWFVerifiedWATest", "TC_22:-To verify can export muliple workflow at a time as verified");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateExportWFVerifiedWA();
		extentTest.log(extentTest.getStatus(), "Export muliple workflow at a time as verified is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=31)
	public void validateEditWFWATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditWFWATest", "TC_29:-To verify can edit workflow");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateEditWFWA(TestDataInMap.get("wfName"),prop.getProperty("TAlogoPath"),
				TestDataInMap.get("priority"),TestDataInMap.get("cleanUpHrs"));
		extentTest.log(extentTest.getStatus(), "Workflow is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=32)
	public void validateEmailNotificationWFTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailNotificationWFTest", "TC_30:-To verify all type of users get email notification if workflow exceed time andthen fail");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateEmailNotificationWF(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("TUser1"),
				TestDataInMap.get("TUser2"),TestDataInMap.get("emailId"));
		extentTest.log(extentTest.getStatus(), "Email Notifiaction if WF excced time and fail is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
		//For Workflow Name
	@Test
	public void validateAdvSearchForWFNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateAdvSearchForWFNameEqualTo("Name","equal to","Sanity1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateAdvSearchForWFNameNotEqualTo("Name", "not equal to","Sanity1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateAdvSearchForWFNameIsLike("Name", "is like","Sanity","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateAdvSearchForWFNameBeginsWith("Name", "begins with","WF","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateAdvSearchForWFNameEndsWith("Name", "ends with","1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	//For Workflow Category
	@Test
	public void validateAdvSearchForWFCategoryEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateAdvSearchForWFCategoryEqualTo("Category","equal to","Default","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFCategoryNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateAdvSearchForWFCategoryNotEqualTo("Category", "not equal to","Default1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFCategoryIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateAdvSearchForWFCategoryIsLike("Category", "is like","fault","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFCategoryBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateAdvSearchForWFCategoryBeginsWith("Category", "begins with","De","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFCategoryEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateAdvSearchForWFCategoryEndsWith("Category", "ends with","fault","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	//For Created [Calender]
	@Test
	public void validateCreatedEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateCreatedEqualTo("exact date","2022","Aug","12","50");
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
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateCreatedBefore("before","2022","Aug","18","50");
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
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateCreatedAfter("after","2022","Aug","6","50");
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
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateCreatedInBetween("in between","2022","Jul","6","2022","Aug","18","50");
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
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For Workflow Status 
	@Test
	public void validateStatusDropdownEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateStatusDropdownEqualTo("Status", "equal to","Active","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateStatusDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpagewa = new WorkflowListPageWA(); 
		workflowlistpagewa.validateStatusDropdownNotEqualTo("Status", "not equal to","Active","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
}
