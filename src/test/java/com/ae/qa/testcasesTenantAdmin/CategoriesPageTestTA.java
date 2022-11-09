package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ae.qa.Listeners.ITestListenerImplementation;
import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.CategoriesPageTA;
import com.ae.qa.pagesTenantAdmin.SchedulerPageTA;
import com.ae.qa.util.ExcelHandler;
@Listeners({ITestListenerImplementation.class})
public class CategoriesPageTestTA extends TestBase {

	CategoriesPageTA categoriespageta;

	public CategoriesPageTestTA()
	{
		super();
	}

	@Test(priority=59)
   public void ValidateCreateCategoryTest(Method method) throws Exception
   {
	   extentTest = extent.createTest("ValidateCreateCategoryTest", "TC_209: To verify can create catagory with mandotary field only");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   categoriespageta = new CategoriesPageTA ();
	   categoriespageta.ValidateCreateCategory(TestDataInMap.get("categoryName"));
	   extentTest.log(extentTest.getStatus(), "Category Created successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
   }

   @Test(priority=60)
   public void ValidateEditCategoryTest(Method method) throws Exception
   {
	   extentTest = extent.createTest("ValidateEditCategoryTest", "TC_210: To verify edit category");
	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
	   categoriespageta = new CategoriesPageTA ();
	   categoriespageta.ValidateEditCategory(TestDataInMap.get("categoryName"),TestDataInMap.get("catDesc"));
	   extentTest.log(extentTest.getStatus(), "Category edited successfully");  
	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
   }
	@Test(priority=61)
	public void ValidateAssignWFToCategoryTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateAssignWFToCategoryTest", "TC_211: To verify user can assign workflow to category");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		categoriespageta = new CategoriesPageTA ();
		categoriespageta.ValidateAssignWFToCategory(TestDataInMap.get("wfName"),TestDataInMap.get("categoryName"));
		extentTest.log(extentTest.getStatus(), "Workflow assigned to categories successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=63)
	public void ValidateCreateDuplicateCategoryTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateCreateDuplicateCategoryTest", "TC_213: To verify user can remove workflow from category");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		categoriespageta = new CategoriesPageTA ();
		categoriespageta.ValidateCreateDuplicateCategory(TestDataInMap.get("categoryName"));
		extentTest.log(extentTest.getStatus(), "Category can't be created with duplicate name");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=449)
	public void ValidateRemoveWFFromCategoryTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateRemoveWFFromCategoryTest", "TC_212: To verify user can remove workflow from category");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		categoriespageta = new CategoriesPageTA ();
		categoriespageta.ValidateRemoveWFFromCategory(TestDataInMap.get("wfName"),TestDataInMap.get("categoryName"));
		extentTest.log(extentTest.getStatus(), "Workflow removed from category successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}    

	@Test(priority=713, dependsOnMethods="ValidateCreateCategoryTest",alwaysRun=true)
	public void ValidateDeleteCategoryTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateCreateCategoryTest", "TC_221: To verify delete catagory");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		categoriespageta = new CategoriesPageTA ();
		categoriespageta.ValidateDeleteCategory(TestDataInMap.get("categoryName"));
		extentTest.log(extentTest.getStatus(), "Category deleted successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=175)
	public void validateCategoriesPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCategoriesPageTATest", "TC_Additional:Verify Clicking Categories tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		categoriespageta = new CategoriesPageTA ();
		categoriespageta.validateCategoriesPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Categories Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}

