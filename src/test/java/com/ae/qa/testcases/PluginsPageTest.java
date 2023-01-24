package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.PluginsPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;

public class PluginsPageTest extends TestBase {
	LoginPage loginpage;
	PluginsPage pluginspage;

	public PluginsPageTest() {
		super();
	}
	//Tested for valid data, invalid location,invalid file type
	@Test(priority = 15)
	public void validateUploadPluginsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadPlugins", "TC_032: Upload plugins zip");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateUploadPlugins();
		extentTest.log(extentTest.getStatus(), "Plugins uploaded successfully and assigned to all tenants");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 128)
	public void validateUploadSinglePluginsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadSinglePluginsTest", "TC_034:Verify Single plugin upload");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateUploadSinglePlugins(prop.getProperty("uploadSinglePluginFile"));
		extentTest.log(extentTest.getStatus(), "Single Plugins uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	/*@Test(priority = 464)
	public void validateUploadSamePluginsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadSamePluginsTest", "TC_035:Verify not able to update single plugin  with same version without snapshot");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateUploadSamePlugins("C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\vbscript-3.0-complete.jar","VB-Script");
		extentTest.log(extentTest.getStatus(), "single plugin  with same version without snapshot cannot be uploaded is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//Give last priority to the test cases because can hamper other test cases beacause ootb plugin is used
	@Test(priority = 465)
	public void validateDeletePluginNoActiveWFTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeletePluginNoActiveWFTest", "TC_039:To verify able to Delete plugin for which no active workflow");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateDeletePluginNoActiveWF("Disable all workflows","OOTB-Plugin","WFwithConfigParam");
		extentTest.log(extentTest.getStatus(), "Delete single plugin for no active workflow is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 466)
	public void validateUploadPluginWithoutAssignToAllTenantTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadPluginWithoutAssignToAllTenantTest", "TC_055:Plugin zip upload without Assign to all Tenant option");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateUploadPluginWithoutAssignToAllTenant("Sanity3");
		extentTest.log(extentTest.getStatus(), "Plugin zip upload without Assign to all Tenant option is verfied successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 467)
	public void validateUploadPluginWithAssignToAllTenantFewPluginsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadPluginWithAssignToAllTenantFewPluginsTest", "TC_057:Plugin zip upload with assign to all tenant  with few plugins");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateUploadPluginWithAssignToAllTenantFewPlugins("Advanced-REST-Client","AE-Core","Sanity3");
		extentTest.log(extentTest.getStatus(), "Plugin zip upload with assign to all tenant  with few plugins is verfied successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
	@Test(priority=158)
	public void validatePluginsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePluginsPageTest", "TC_Additional:Verify Clicking Plugins tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validatePluginsPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(),"Plugins page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	/*@Test(priority=735)
	public void validateStepUnitTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStepUnitTest", "TC_44:Verify Step Unit");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateStepUnit("Manual-Intervention","0");
		extentTest.log(extentTest.getStatus(),"Step Unit is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
	/*@Test(priority=468)
	public void validateUploadSinglePluginSameVersionTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadSinglePluginSameVersionTest", "TC_35:Verify not able to update  single plugin  with same version (withot snapshot )");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateUploadSinglePluginSameVersion(TestDataInMap.get("PluginName"));
		extentTest.log(extentTest.getStatus(),"Single plugin jar with same version is not uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=469)
	public void validateSinglePluginUploadHigherVersionTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSinglePluginUploadHigherVersionTest", "TC_36:To verify single plugin uplaod with higher version");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateSinglePluginUploadHigherVersion(TestDataInMap.get("PluginName"));
		extentTest.log(extentTest.getStatus(),"Single plugin jar of higher version is uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=470)
	public void validateSinglePluginUploadLowerVersionTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSinglePluginUploadLowerVersionTest", "TC_37:To verify single plugin uplaod with lower version");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateSinglePluginUploadLowerVersion(TestDataInMap.get("PluginName"));
		extentTest.log(extentTest.getStatus(),"Single plugin jar of lower version is uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//Closure test cases Assign them at last so that other test cases are not hampered
	/*@Test(priority=905)
	public void validatePluginUploadWithoutAssignToAllTenantTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePluginUploadWithoutAssignToAllTenantTest", "TC_59:Plugin zip upload without Assign to all Tenant option");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validatePluginUploadWithoutAssignToAllTenant();
		extentTest.log(extentTest.getStatus(),"Plugin upload without Assign to all tenant is uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=906)
	public void validatePluginUploadWithAssignToAllTenantFewPluginsTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePluginUploadWithAssignToAllTenantFewPluginsTest", "TC_61:Plugin zip upload with assign to all tenant  with few plugins");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validatePluginUploadWithAssignToAllTenantFewPlugins("active-directory","GoogleSheets","Office365");
		extentTest.log(extentTest.getStatus(),"Plugin upload with assign to all tenant with few plugins is uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=907)
	public void validatePluginAccessTenantAssignAllOptionSelectedTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePluginAccessTenantAssignAllOptionSelectedTest", "TC_61:Plugin zip upload with assign to all tenant  with few plugins");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validatePluginAccessTenantAssignAllOptionSelected("50");
		extentTest.log(extentTest.getStatus(),"Plugin upload with assign to all tenant with few plugins is uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=908)
	public void validatePluginAccessTenantAssignAllOptionNotSelectedTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePluginAccessTenantAssignAllOptionNotSelectedTest", "TC_61:Plugin zip upload with assign to all tenant  with few plugins");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validatePluginAccessTenantAssignAllOptionNotSelected("TA02","For pp","50","TA02","Plugin","Admin1","abc@abc.com","PluginAdmin1","Pune@123","Pune@123","Tenant Admin",
				"Pune@1234");
		extentTest.log(extentTest.getStatus(),"Plugin upload with assign to all tenant with few plugins is uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
		//For Plugin Name
	/*@Test(priority = 3073)
	public void validateAdvSearchForPluginNameEqualTonPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForPluginNameEqualToPluginPageTest", "TC_009: To Verfiy Advance search for plugin name with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateAdvSearchForPluginNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3074)
	public void validateAdvSearchForPluginNameNotEqualToPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForPluginNameNotEqualToPluginPageTest", "TC_009: To Verfiy Advance search for plugin name with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateAdvSearchForPluginNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3075)
	public void validateAdvSearchForPluginNameIsLikePluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForPluginNameIsLikePluginPageTest", "TC_009: To Verfiy Advance search for plugin name with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateAdvSearchForPluginNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3076)
	public void validateAdvSearchForPluginNameBeginsWithPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForPluginNameBeginsWithPluginPageTest", "TC_009: To Verfiy Advance search for plugin name with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateAdvSearchForPluginNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3077)
	public void validateAdvSearchForPluginNameEndsWithPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForPluginNameEndsWithPluginPageTest", "TC_009: To Verfiy Advance search for plugin name with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateAdvSearchForPluginNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Created [Calender]
	@Test(priority = 3078)
	public void validateCreatedEqualToPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToPluginPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3079)
	public void validateCreatedBeforePluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedBeforePluginPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3080)
	public void validateCreatedAfterPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedAfterPluginPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3081)
	public void validateCreatedInBetweenPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedInBetweenPluginPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3082)
	public void validateCreatedNotInBetweenPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedNotInBetweenPluginPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}

	//For Last Modified
	@Test(priority = 3083)
	public void validateLastModifiedCreatedEqualToPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedEqualToPluginPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateLastModifiedCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3084)
	public void validateLastModifiedCreatedBeforePluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastModifiedCreatedBeforePluginPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateLastModifiedCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3085)
	public void validateLastModifiedCreatedAfterPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastModifiedCreatedAfterPluginPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateLastModifiedCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3086)
	public void validateLastModifiedCreatedInBetweenPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastModifiedCreatedInBetweenPluginPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateLastModifiedCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3087)
	public void validateLastUpdatedModifiedNotInBetweenPluginPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedNotInBetweenPluginPageTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspage = new PluginsPage();
		pluginspage.validateLastModifiedCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}*/

}
