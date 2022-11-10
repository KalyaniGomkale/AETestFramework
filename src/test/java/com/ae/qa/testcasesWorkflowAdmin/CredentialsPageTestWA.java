package com.ae.qa.testcasesWorkflowAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WorkflowAdmin.CredentialsPageWA;
import com.ae.qa.pagesTenantAdmin.CredentialsPageTA;
import com.ae.qa.util.ExcelHandler;


public class CredentialsPageTestWA extends TestBase{
	CredentialsPageWA credentialspagewa;

	public CredentialsPageTestWA()
	{
		super();

	}
	
	@Test(priority=25)
	public void ValidateCreateCredentialsWATest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateCreateCredentialsWATest", "TC_57: To verify user can create credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		credentialspagewa = new CredentialsPageWA();
		credentialspagewa.ValidateCreateCredentialsWA(TestDataInMap.get("CredName"),TestDataInMap.get("CredDescp"),
				TestDataInMap.get("CredUserName"),TestDataInMap.get("CredPswd"));
		extentTest.log(extentTest.getStatus(), "Credentials Created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=26)
	public void ValidateEditCredentialsWATest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateEditCredentialsWATest", "TC_58: To verify user can edit credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		credentialspagewa = new CredentialsPageWA();
		credentialspagewa.ValidateEditCredentialsWA(TestDataInMap.get("CredName"),TestDataInMap.get("Param1"),TestDataInMap.get("Param2"),
				TestDataInMap.get("EncParam1"),TestDataInMap.get("EncParam2"),TestDataInMap.get("Year"),
				TestDataInMap.get("Month"),TestDataInMap.get("Date"));
		extentTest.log(extentTest.getStatus(), "Credentials Edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=27)
	public void ValidateMoveCredentialToPoolWATest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateMoveCredentialToPoolWATest", "TC_59: To verify user can move credential to credential pool");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		credentialspagewa = new CredentialsPageWA();
		credentialspagewa.ValidateMoveCredentialToPoolWA(TestDataInMap.get("CredName"),TestDataInMap.get("CredPoolName"),TestDataInMap.get("CredPoolDescp"));
		extentTest.log(extentTest.getStatus(), "Credential moved to Credential Pool Successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	//closure activities
	/*@Test(priority=560)
	public void ValidateDeleteCredentialPoolWATest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateDeleteCredentialPoolWATest", "TC_60: To verify user can delete credential pool");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		credentialspagewa = new CredentialsPageWA();
		credentialspagewa.ValidateDeleteCredentialPoolWA(TestDataInMap.get("CredPoolName"));
		extentTest.log(extentTest.getStatus(), "Credential Pool deleted Successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=561)
	public void ValidateDeleteCredentialWATest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateDeleteCredentialTest", "TC_226: To verify user can delete credential");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		credentialspagewa = new CredentialsPageWA();
		credentialspagewa.ValidateDeleteCredentialWA(TestDataInMap.get("CredName"));
		extentTest.log(extentTest.getStatus(), "Credential deleted Successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}*/
}
