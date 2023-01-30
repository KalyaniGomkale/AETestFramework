package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.PluginsPage;
import com.ae.qa.pages.WorkflowAdmin.PluginsPageWA;
import com.ae.qa.pagesTenantAdmin.PluginsPageTA;
import com.ae.qa.util.ExcelHandler;

public class PluginsPageTestTA extends TestBase {
	PluginsPageTA pluginspageta;

	public PluginsPageTestTA() {
		super();
	}
	@Test(priority=190)
	public void validatePluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validatePluginsPageTATest", "TC_Additional:Verify Clicking Plugins tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validatePluginsPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Plugins Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//For Plugin Name
	@Test(priority = 3192)
	public void validateAdvSearchForPluginNameEqualToPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForPluginNameEqualToPluginsPageTATest", "TC_009: To Verfiy Advance search for Plugin name with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateAdvSearchForPluginNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3193)
	public void validateAdvSearchForPluginNameNotEqualToPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForPluginNameNotEqualToPluginsPageTATest", "TC_009: To Verfiy Advance search for Plugin name with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateAdvSearchForPluginNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3194)
	public void validateAdvSearchForPluginNameIsLikePluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForPluginNameIsLikePluginsPageTATest", "TC_009: To Verfiy Advance search for Plugin name with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateAdvSearchForPluginNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3195)
	public void validateAdvSearchForPluginNameBeginsWithPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForPluginNameBeginsWithPluginsPageTATest", "TC_009: To Verfiy Advance search for Plugin name with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateAdvSearchForPluginNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3196)
	public void validateAdvSearchForPluginNameEndsWithPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForPluginNameEndsWithPluginsPageTATest", "TC_009: To Verfiy Advance search for Plugin name with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateAdvSearchForPluginNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for User Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Created [Calender]
	@Test(priority = 3197)
	public void validateCreatedEqualToPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToPluginsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3198)
	public void validateCreatedBeforePluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedBeforePluginsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3199)
	public void validateCreatedAfterPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedAfterPluginsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3200)
	public void validateCreatedInBetweenPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedInBetweenPluginsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3201)
	public void validateCreatedNotInBetweenPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedNotInBetweenPluginsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
    //For Last Modified
	@Test(priority = 3202)
	public void validateLastModifiedCreatedEqualToPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedEqualToPluginsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateLastModifiedCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3203)
	public void validateLastModifiedCreatedBeforePluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastModifiedCreatedBeforePluginsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateLastModifiedCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3204)
	public void validateLastModifiedCreatedAfterPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastModifiedCreatedAfterPluginsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateLastModifiedCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3205)
	public void validateLastModifiedCreatedInBetweenPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastModifiedCreatedInBetweenPluginsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateLastModifiedCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3206)
	public void validateLastUpdatedModifiedNotInBetweenPluginsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateLastUpdatedCreatedNotInBetweenPluginsPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		pluginspageta = new PluginsPageTA();
		pluginspageta.validateLastModifiedCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}

}
