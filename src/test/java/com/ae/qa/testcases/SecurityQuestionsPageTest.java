package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.SecurityQuestionsPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;

public class SecurityQuestionsPageTest extends TestBase {
	SecurityQuestionsPage securityquestionspage;

	public SecurityQuestionsPageTest() {
		super();
	}
	//sysadmin data can work
	@Test(priority = 21)
	public void validateSkipQuesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSkipQuesTest",
				"TC_105: Verify sysadmin user will be redirected to his regular dashboard after skipping answering three security questions");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		securityquestionspage = new SecurityQuestionsPage();
	//	securityquestionspage.validateSkipQues(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("SysadminPswd"));
		securityquestionspage.validateSkipQues();
		extentTest.log(extentTest.getStatus(), "It will skip the security questions");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 22)
	public void validateSecurityQuesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSecurityQuesTest",
		"TC_106: Verify sysadmin user will be asked to submit only three security question out of ten when security question answers are not set by sysadmin and he logs in");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		securityquestionspage = new SecurityQuestionsPage();
		securityquestionspage.validateSecurityQues(prop.getProperty("username"), prop.getProperty("password"));
		extentTest.log(extentTest.getStatus(), "Sysadmin set security question successfully and logged in.");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority = 23)
	public void validateUpdatingSecQuesWithWrongPswdTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUpdatingSecQuesWithWrongPswdTest",
				"TC_109: Verify sysadmin will get error if he/she tries to update security question with wrong password");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		securityquestionspage = new SecurityQuestionsPage();
		securityquestionspage.validateUpdatingSecQuesWithWrongPswd(TestDataInMap.get("SysadminInvalidPswd"));
		extentTest.log(extentTest.getStatus(), "It will give error while updating security questions");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 24)
	public void validateUpdatingSecurityQuesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUpdatingSecurityQuesTest",
				"TC_108: Verify sysadmin user can update answers which he already set previously when visits security questions section in his profile");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		securityquestionspage = new SecurityQuestionsPage();
		securityquestionspage.validateUpdatingSecurityQues();
		extentTest.log(extentTest.getStatus(), "It will update the security questions");
	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
//On sysadmin page we created sysadmin1 so using it
	@Test(priority = 25)
	public void validateSkipThenSetQuesTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSkipThenSetQuesTest",
				"TC_110: Verify sysadmin user able to answer the security answers which he skiped previously when he visits security question in his profile");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		securityquestionspage = new SecurityQuestionsPage();
		securityquestionspage.validateSkipThenSetQues(TestDataInMap.get("SysadminUsername"),TestDataInMap.get("SysadminInvalidPswd"),TestDataInMap.get("SysadminPswd"));
		extentTest.log(extentTest.getStatus(), "It will first skip the security questions and then set");
	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=168)
	public void validateSecurityQuestionsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSecurityQuestionsPageTest", "TC_Additional:Verify Clicking Security Questions tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		securityquestionspage = new SecurityQuestionsPage();
		securityquestionspage.validateSecurityQuestionsPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Security Questions page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
}
