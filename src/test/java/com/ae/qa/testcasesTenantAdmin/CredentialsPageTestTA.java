package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;
import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.CredentialsPageTA;
import com.ae.qa.pagesTenantAdmin.SchedulerPageTA;
import com.ae.qa.util.ExcelHandler;


public class CredentialsPageTestTA extends TestBase {
	CredentialsPageTA credentialspageta;

	public CredentialsPageTestTA()
	{
		super();
	}

	@Test(priority=64)
	public void ValidateCreateCredentialsTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateCreateCredentialsTest", "TC_222: To verify user can create credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		credentialspageta = new CredentialsPageTA();
		credentialspageta.ValidateCreateCredentials(TestDataInMap.get("CredName"),TestDataInMap.get("CredDescp"),TestDataInMap.get("CredUserName"),TestDataInMap.get("CredPswd"));
		extentTest.log(extentTest.getStatus(), "Credentials Created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}

	@Test(priority=65)
	public void ValidateEditCredentialsTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateEditCredentialsTest", "TC_223: To verify user can edit credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		credentialspageta = new CredentialsPageTA();
		credentialspageta.ValidateEditCredentials(TestDataInMap.get("CredName"),TestDataInMap.get("Param1"),TestDataInMap.get("Param2"),
				TestDataInMap.get("EncParam1"),TestDataInMap.get("EncParam2"),TestDataInMap.get("Year"),
				TestDataInMap.get("Month"),TestDataInMap.get("Date"));
		extentTest.log(extentTest.getStatus(), "Credentials Edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=66)
	public void ValidateDuplicateCredentialsTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateCreateCredentialsTest", "TC_222: To verify user can create duplicate credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		credentialspageta = new CredentialsPageTA();
		credentialspageta.ValidateDuplicateCredentials(TestDataInMap.get("CredName"),TestDataInMap.get("CredDescp"),TestDataInMap.get("CredUserName"),TestDataInMap.get("CredPswd"));
		extentTest.log(extentTest.getStatus(), "Credentials with duplicate name can't be created");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=67)
	public void ValidateCreateCredentialPoolTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateCreateCredentialPoolTest", "TC_xxx: To verify user can create credential Pool");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		credentialspageta = new CredentialsPageTA();
		credentialspageta.ValidateCreateCredentialPool(TestDataInMap.get("CredPoolName"),TestDataInMap.get("CredPoolDescp"));
		extentTest.log(extentTest.getStatus(), "Credential Pool Created successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=68)
	public void ValidateDuplicateCredentialPoolTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateDuplicateCredentialPoolTest", "TC_xxx: To verify user can create duplicate credential pool");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		credentialspageta = new CredentialsPageTA();
		credentialspageta.ValidateDuplicateCredentialPool(TestDataInMap.get("CredPoolName"));
		extentTest.log(extentTest.getStatus(), "Credential Pool with duplicate name can't be created");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=69)
	public void ValidateMoveCredentialToPoolTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateMoveCredentialToPoolTest", "TC_226: To verify user can move credential to credential pool");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		credentialspageta = new CredentialsPageTA();
		credentialspageta.ValidateMoveCredentialToPool(TestDataInMap.get("CredName"),TestDataInMap.get("CredPoolName"));
		extentTest.log(extentTest.getStatus(), "Credential moved to Credential Pool Successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//closure activities
	/*@Test(priority=551)
	public void ValidateDeleteCredentialPoolTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateDeleteCredentialPoolTest", "TC_226: To verify user can delete credential pool");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		credentialspageta = new CredentialsPageTA();
		credentialspageta.ValidateDeleteCredentialPool(TestDataInMap.get("CredPoolName"));
		extentTest.log(extentTest.getStatus(), "Credential Pool deleted Successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=552)
	public void ValidateDeleteCredentialTest(Method method) throws Exception
	{
		extentTest = extent.createTest("ValidateDeleteCredentialTest", "TC_226: To verify user can delete credential");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		credentialspageta = new CredentialsPageTA();
		credentialspageta.ValidateDeleteCredential(TestDataInMap.get("CredName"));
		extentTest.log(extentTest.getStatus(), "Credential deleted Successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	@Test(priority=176)
	public void validateCredentialsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCredentialsPageTATest", "TC_Additional:Verify Clicking Credentials tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		credentialspageta = new CredentialsPageTA();
		credentialspageta.validateCredentialsPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Credentials Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	
}
