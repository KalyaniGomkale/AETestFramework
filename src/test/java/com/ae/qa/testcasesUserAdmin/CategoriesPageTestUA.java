package com.ae.qa.testcasesUserAdmin;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.UserAdmin.CategoriesPageUA;
import com.ae.qa.util.ExcelHandler;

public class CategoriesPageTestUA extends TestBase{
	CategoriesPageUA categoriespageua;

	public CategoriesPageTestUA() {
		super();
	}
//Skipped due to UI Changes
	/*@Test(priority=10)
	public void validateReadPermissionTest(Method method) throws Exception {
		extentTest = extent.createTest("validateReadPermissionTest", "TC_28:-To verify read permission to category of users");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		categoriespageua = new CategoriesPageUA(); 
		categoriespageua.validateReadPermissionUser("WebGUI","Users","Suyash Desai");
		extentTest.log(extentTest.getStatus(), "Read Permission is assigned to category of user successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=11)
	public void validateWritePermissionTest(Method method) throws Exception {
		extentTest = extent.createTest("validateWritePermissionTest", "TC_29:-To verify Write permission to category of users");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		categoriespageua = new CategoriesPageUA(); 
		categoriespageua.validateWritePermissionUser("WebGUI","Users","Suyash Desai");
		extentTest.log(extentTest.getStatus(), "Write Permission is assigned to category of user successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=12)
	public void validateExecutePermissionTest(Method method) throws Exception {
		extentTest = extent.createTest("validateExecutePermissionTest", "TC_30:-To verify Execute permission to category of users");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		categoriespageua = new CategoriesPageUA(); 
		categoriespageua.validateExecutePermissionUser("WebGUI","Users","Suyash Desai");
		extentTest.log(extentTest.getStatus(), "Execute Permission is assigned to category of user successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=13)
	public void validateExecutePermissionGroupTest(Method method) throws Exception {
		extentTest = extent.createTest("Test", "TC_32:-To verify edit permission[execute to write]");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		categoriespageua = new CategoriesPageUA(); 
		categoriespageua.validateExecutePermissionGroup("WebGUI","Groups","Tenant Users");
		extentTest.log(extentTest.getStatus(), "Permission is assigned to group successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=14)
	public void validateEditPermissionToWriteTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEditPermissionToWriteTest", "TC_32:-To verify edit permission[execute to write]");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		categoriespageua = new CategoriesPageUA(); 
		categoriespageua.validateEditPermissionToWrite("WebGUI","Users","Suyash Desai");
		extentTest.log(extentTest.getStatus(), "Permission is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/

}
