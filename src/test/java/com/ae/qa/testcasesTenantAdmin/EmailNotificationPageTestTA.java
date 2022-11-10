package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.EmailNotificationPageTA;
import com.ae.qa.pagesTenantAdmin.LDAPPageTA;
import com.ae.qa.util.ExcelHandler;

public class EmailNotificationPageTestTA extends TestBase {
	EmailNotificationPageTA emailnotificationpageta;

	public EmailNotificationPageTestTA() {
		super();
	}
	//Negative case when SMTP not configured
	@Test(priority=10)
	public void validateEmailNotfSMTPNotConfigTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailNotfSMTPNotConfigTest", "TC_082: Verify if user try to set email notofication w/o SMTP settings");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailnotificationpageta = new EmailNotificationPageTA(); 
		emailnotificationpageta.validateEmailNotfSMTPNotConfig();
		extentTest.log(extentTest.getStatus(), "User cant set email notification w/o SMTP Setting tested successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	//Test case when SMTP Is configured-we will check if Current Agent Status is present in table or not 
	@Test(priority=12)
	public void validateEnailNotfSMTPConfTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEnailNotfSMTPConfTest", "TC_082: Verify if user try to set email notofication after SMTP settings");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailnotificationpageta = new EmailNotificationPageTA(); 
		emailnotificationpageta.validateEnailNotfSMTPConf();
		extentTest.log(extentTest.getStatus(), "User can set email notification after SMTP Setting tested successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	//Positive Scenario
	@Test(priority=314)
	public void validateEmailNotificationWFCreateUpdateDeleteTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailNotificationWFCreateUpdateDeleteTest", "TC_227 & TC_228: To verify get notification to Config user when workflow get created"
				+ "                                                                             To verify get notification to Config user if any change in workflow configuration");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailnotificationpageta = new EmailNotificationPageTA(); 
		emailnotificationpageta.validateEmailNotificationWFCreateUpdateDelete("Workflow Create and Update","rohil.kumbhar06@gmail.com","rohil");
		extentTest.log(extentTest.getStatus(), "Email Notification when workflow get create and update is verified");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=325)
	public void validateEmailNotificationCurrentAgentStatusTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailNotificationCurrentAgentStatusTest", "TC_230: To verify get email notification of agent status everyday at specific interval");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailnotificationpageta = new EmailNotificationPageTA(); 
		emailnotificationpageta.validateEmailNotificationCurrentAgentStatus("Current Agent Status","rohil.kumbhar06@gmail.com","rohil","06","00","1","10","00");
		extentTest.log(extentTest.getStatus(), "Email Notification of agent status everyday at specific interval is been verified");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=326)
	public void validateEmailNotificationAgentNotWorkingTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailNotificationAgentNotWorkingTest", "TC_231: To verify get email notification after agent changes state");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailnotificationpageta = new EmailNotificationPageTA(); 
		emailnotificationpageta.validateEmailNotificationAgentNotWorking("Agent Not Working","rohil.kumbhar06@gmail.com","rohil");
		extentTest.log(extentTest.getStatus(), "Email Notification of agent not working is been verified");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=327)
	public void validateEmailNotificationUnlockUserTest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailNotificationUnlockUserTest", "TC_231: To verify get email notification after get unlock");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailnotificationpageta = new EmailNotificationPageTA(); 
		emailnotificationpageta.validateEmailNotificationUnlockUser("Unlock User");
		extentTest.log(extentTest.getStatus(), "Email Notification of unlock User is been verified");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//Negative Scenario
	@Test(priority=315)
	public void validateEmailNotificationWFEnableOff(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailNotificationWFEnableOff", "TC_539: To verify get notification to configured user when workflow get created");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailnotificationpageta = new EmailNotificationPageTA(); 
		emailnotificationpageta.validateEmailNotificationWFEnableOff("Workflow Create and Update");
		extentTest.log(extentTest.getStatus(), "User cannot get email notification if enable feature is disabled");  
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=201)
	public void validateEmailNotificationPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateEmailNotificationPageTATest", "TC_Additional:Verify Clicking Email Notification tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		emailnotificationpageta = new EmailNotificationPageTA(); 
		emailnotificationpageta.validateEmailNotificationPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Email Notification Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}
