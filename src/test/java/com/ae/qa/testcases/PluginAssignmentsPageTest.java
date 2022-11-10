package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.PluginAssignmentsPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;

public class PluginAssignmentsPageTest extends TestBase {
	LoginPage loginpage;
	PluginAssignmentsPage pluginassignmentspage;

	public PluginAssignmentsPageTest() {
		super();
	}

	@Test(priority = 129)
	public void validateAssignPluginSingleTenantTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadPlugins", "TC_041: Verify assign plugin to single tenant ");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		//pluginassignmentspage.validateAssignPluginSingleTenant("OOTB-Plugin", "BR01");
		pluginassignmentspage.validateAssignPluginSingleTenant(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),
				TestDataInMap.get("OrganizationCode"),TestDataInMap.get("PluginName"),TestDataInMap.get("TenantOrgCode"));
		extentTest.log(extentTest.getStatus(), "Plugin assigned to single tenant successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test (priority = 130)
	public void validateAssignTenantSinglePluginTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAssignTenantSinglePluginTest", "TC_044: Verify assign tenant a single plugins");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		//pluginassignmentspage.validateAssignTenantSinglePlugin("BR01","MSSQL-Server");
		pluginassignmentspage.validateAssignTenantSinglePlugin(TestDataInMap.get("TenantOrgCode"),TestDataInMap.get("PluginName"));
		extentTest.log(extentTest.getStatus(), "Plugin assigned to single tenant successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	} 

	@Test(priority = 131)
	public void validateAssignPluginAllTenantTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadPlugins", "TC_042: Verify assign plugin to all tenants");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		pluginassignmentspage.validateAssignPluginAllTenant(TestDataInMap.get("PluginName"));
		extentTest.log(extentTest.getStatus(), "Plugin assigned to all tenants successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=159)
	public void validatePluginAssignmentsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTenantUsersPageTest", "TC_Additional:Verify Clicking Plugin Assignments tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		pluginassignmentspage.validatePluginAssignmentsPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Plugin Assignments page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	/*@Test(priority=464)
	public void validateWFInActiveAfterSysadminRemovesPluginPermissionTest(Method method) throws Exception {
		//Workflow should be in active state
		extentTest = extent.createTest("validateWFInActiveAfterSysadminRemovesPluginPermissionTest", "TC_38:Verify workflow active/inactive status after sysadmin removes the permission of plugin");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		pluginassignmentspage.validateWFInActiveAfterSysadminRemovesPluginPermission("PowerShellWF","For Plugin permission","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\Powershell_v1_signed.zip",
				"High","15","20","3","15","Minutes","10","20","Powershell-Script");
		extentTest.log(extentTest.getStatus(), "WF status are sysadmin removes plugin permission is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=465,dependsOnMethods="validateWFInActiveAfterSysadminRemovesPluginPermissionTest")
	public void validateWFActiveAfterSysadminRemovesPluginPermissionTest(Method method) throws Exception {
		//Workflow should be in active state
		extentTest = extent.createTest("validateWFActiveAfterSysadminRemovesPluginPermissionTest", "TC_39:Verify workflow active/inactive functioanality after sysadmin removes permission of plugin");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		pluginassignmentspage.validateWFActiveAfterSysadminRemovesPluginPermission("PowerShellWF");
		extentTest.log(extentTest.getStatus(), "WF status after sysadmin removes plugin permission is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=464)
	public void validateUploadPluginWithoutAssignToAllTenantTest(Method method) throws Exception {
		//Workflow should be in active state
		extentTest = extent.createTest("validateUploadPluginWithoutAssignToAllTenantTest", "TC_40:Plugin zip upload without Assign to all Tenant option");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		pluginassignmentspage.validateUploadPluginWithoutAssignToAllTenant();
		extentTest.log(extentTest.getStatus(), "Plugin zip upload without Assign to all Tenant option is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=466)
	public void validatePluginAccessAssignToAllSelectedTest(Method method) throws Exception {
		//Workflow should be in active state
		extentTest = extent.createTest("validatePluginAccessAssignToAllSelectedTest", "TC_36:Verify  plugin access of newly added tenant when  assign all option  selected on Plugin assignment page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		pluginassignmentspage.validatePluginAccessAssignToAllSelected("PS","For Plugin assignment","PS01","Plugin","User1","PUSer@gmail.com","PluginUser1","Pune@123","Tenant Admin","Pune@1234","Plugin Name","equal to","Powershell-Script","50");
		extentTest.log(extentTest.getStatus(), "plugin access of newly added tenant when  assign all option  selected on Plugin assignment page is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=467)
	public void validatePluginAccessAssignToAllNotSelectedTest(Method method) throws Exception {
		//Workflow should be in active state
		extentTest = extent.createTest("validatePluginAccessAssignToAllNotSelectedTest", "TC_37:Verify  plugin access of newly added tenant when  assign all option not selected on Plugin assignment page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		pluginassignmentspage.validatePluginAccessAssignToAllNotSelected("Plugin Name","equal to","Powershell-Script","50");
		extentTest.log(extentTest.getStatus(), "plugin access of newly added tenant when  assign all option not selected on Plugin assignment page is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	/*	
	@Test(priority = 37)
	public void validateAssignPluginToMultipleTenantTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadPlugins", "TC_043: Verify assign plugins to Specific/multiple tenants");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		pluginassignmentspage.validateAssignPluginToMultipleTenants(TestDataInMap.get("PluginName"),TestDataInMap.get("TenantOrgCode1"),TestDataInMap.get("TenantOrgCode2"),TestDataInMap.get("TenantOrgCode3"));
		extentTest.log(extentTest.getStatus(), "Plugin assigned to specific/multiple tenants successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

/*	

	@Test(priority = 39)
	public void validateAssignTenantMultiplePluginsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAssignTenantSinglePluginTest", "TC_045: Verify assign tenant Specific/multiple plugins");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		pluginassignmentspage.validateAssignTenantMultiplePlugins(TestDataInMap.get("TenantOrgCode"),TestDataInMap.get("PluginName1"),TestDataInMap.get("PluginName2"));//("BR01","MSSQL-Server");
		extentTest.log(extentTest.getStatus(), "Plugin assigned to specific/mutiple tenants successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test (priority = 40)
	public void validateAssignTenantAllPluginsTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAssignTenantAllPluginsTest", "TC_046: Verify assigning tenant all plugins");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		pluginassignmentspage = new PluginAssignmentsPage();
		pluginassignmentspage.validateAssignTenantAllPlugins(TestDataInMap.get("TenantOrgCode"));//("BR01","MSSQL-Server");
		extentTest.log(extentTest.getStatus(), "All Plugins are assigned to tenant successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
}