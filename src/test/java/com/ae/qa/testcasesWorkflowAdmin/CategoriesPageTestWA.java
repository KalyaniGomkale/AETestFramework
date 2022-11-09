package com.ae.qa.testcasesWorkflowAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WorkflowAdmin.CategoriesPageWA;
import com.ae.qa.pagesTenantAdmin.CategoriesPageTA;
import com.ae.qa.util.ExcelHandler;

public class CategoriesPageTestWA extends TestBase{
	
CategoriesPageWA categoriespagewa;
	
	public CategoriesPageTestWA()
	{
		super();
	}
	
	 @Test(priority=97)
	   public void ValidateCreateCategoryWATest(Method method) throws Exception
	   {
		   extentTest = extent.createTest("ValidateCreateCategoryWATest", "TC_52: To verify can create catagory with mandotary field only");
		   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		   categoriespagewa = new CategoriesPageWA();
		   categoriespagewa.ValidateCreateCategoryWA(TestDataInMap.get("categoryName"));
		   extentTest.log(extentTest.getStatus(), "Category Created successfully");  
		   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	   }
	 
	   @Test(priority=98)
	   public void ValidateEditCategoryWATest(Method method) throws Exception
	   {
		   extentTest = extent.createTest("ValidateEditCategoryWATest", "TC_53: To verify edit category");
		   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		   categoriespagewa = new CategoriesPageWA();
		   categoriespagewa.ValidateEditCategoryWA(TestDataInMap.get("categoryName"),TestDataInMap.get("catDesc"));
		   extentTest.log(extentTest.getStatus(), "Category edited successfully");  
		   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	   }
	   @Test(priority=99)
	   public void ValidateAssignWFToCategoryWATest(Method method) throws Exception
	   {
		   extentTest = extent.createTest("ValidateAssignWFToCategoryWATest", "TC_54: To verify user can assign workflow to category");
		   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		   categoriespagewa = new CategoriesPageWA();
		   categoriespagewa.ValidateAssignWFToCategoryWA(TestDataInMap.get("wfName"),TestDataInMap.get("categoryName"));
		   extentTest.log(extentTest.getStatus(), "Workflow assigned to categories successfully");  
		   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	   }
	   @Test(priority=100)
	      public void ValidateRemoveWFFromCategoryWATest(Method method) throws Exception
	      {
	   	   extentTest = extent.createTest("ValidateRemoveWFFromCategoryWATest", "TC_55: To verify user can remove workflow from category");
	   	   Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
	   	   categoriespagewa = new CategoriesPageWA();
	   	   categoriespagewa.ValidateRemoveWFFromCategoryWA(TestDataInMap.get("wfName"),TestDataInMap.get("categoryName"));
	   	   extentTest.log(extentTest.getStatus(), "Workflow removed from category successfully");  
	   	   ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	      }    
}
