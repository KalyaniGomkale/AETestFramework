package com.ae.qa.pages.WorkflowAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.Messages;

public class AgentLogsPageWA extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();

	@FindBy(xpath = "//span[contains(text(),'Logs')]")
	@CacheLookup
	WebElement logsTab;
	@FindBy(xpath="//a[text()='Agent Logs']")
	WebElement agentLogsTab;
	@FindBy(xpath = "//button[@title='Submit New Request']")
	WebElement newRequestBtn;
	@FindBy(xpath = "//input[@value='agent']")
	WebElement agentRadioBtn;
	@FindBy(xpath = "//input[@value='workflow']")
	WebElement requestRadioBtn;
	@FindBy(id = "agentType")
	WebElement agentType;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement selectAgent;
	@FindBy(id="startDate-datepicker")
	WebElement startDate;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement monthDrpdown;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement yearDrpdown;
	@FindBy(id="endDate-datepicker")
	WebElement endDate;
	@FindBy(xpath="//span[text()='Submit']")
	WebElement submitBtn;
	@FindBy(id="wfinstanceId")
	WebElement requestID;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//button[@title='Refresh Table']")
	WebElement refreshBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public AgentLogsPageWA() {
		PageFactory.initElements(driver, this);
	}

	public void validateAgentLogs(String AgentType,String AgentName,String startYear,String startMonth,String 
			startdate,String endYear,String endMonth,String EndDate ) throws Exception {
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(logsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		wait.until(ExpectedConditions.visibilityOf(agentLogsTab));
		js.executeScript("arguments[0].click();", agentLogsTab);
		Reporter.log("Agent Logs Tab is clicked", true);
		newRequestBtn.click();
		Reporter.log("New Request button is clicked",true);
		Thread.sleep(3000);
		if(agentRadioBtn.isSelected())
		{
			Reporter.log("agent Radio button is selected by default",true);
		} else {
			agentRadioBtn.click();
			Reporter.log("Agent radio btn is not selected by default and selected now",true);
		}
		Thread.sleep(3000);
		Select AgentType_drpdown=new Select(agentType);
		AgentType_drpdown.selectByVisibleText(AgentType);//Agent
		Thread.sleep(3000);
		selectAgent.click();
		Thread.sleep(3000);
		WebElement selectagent=driver.findElement(By.xpath("//label[contains(text(),'"+AgentName+"')]/span"));
		selectagent.click();
		Reporter.log("Agent selected",true);
		Thread.sleep(3000);
		startDate.click();
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startdate+"']"));
		start_day_picker.click();
		Reporter.log("Start Date selected",true);
		Thread.sleep(5000);
		endDate.click();
		Thread.sleep(2000);
		Select end_year_picker=new Select(yearDrpdown);
		end_year_picker.selectByVisibleText(endYear);
		Thread.sleep(2000);
		Select end_month_picker=new Select(monthDrpdown);
		end_month_picker.selectByVisibleText(endMonth);
		Thread.sleep(2000);
		WebElement end_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+EndDate+"']"));
		end_day_picker.click();
		Reporter.log("End Date selected",true);
		Thread.sleep(5000);
		submitBtn.click();
		Reporter.log("Agent log submitted successfully",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = alertMessage.getText();
		String expected_message = Messages.requestSubmitInAgentLogs;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Agent logs request not submitted");
		Reporter.log("Agent logs request submitted successfully",true);
		Thread.sleep(10000);
		refreshBtn.click();
		Thread.sleep(2000);
		WebElement downloadBtn=driver.findElement(By.xpath("//table/tr/td[text()='"+AgentName+"']/../td/span"));
		downloadBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message1 = alertMessage.getText();
		String expected_message1 = Messages.downloadInAgentLogs;
		Reporter.log("Actual Success Msg:" + actual_message1,true);
		Reporter.log("Expected Success Msg:" + expected_message1,true);
		Assert.assertEquals(actual_message1,expected_message1, "Agent logs download not started");
		Reporter.log("Agents log downloaded successfully for Agent "+AgentName,true);
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	public void validateWorkflowLogs(String RequestID) throws Exception {
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(logsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		wait.until(ExpectedConditions.visibilityOf(agentLogsTab));
		js.executeScript("arguments[0].click();", agentLogsTab);
		Reporter.log("Agent Logs Tab is clicked", true);
		newRequestBtn.click();
		//Reporter.log("New Request button is clicked",true);
		//requestRadioBtn.click();
		//Reporter.log("Request Radio Button is selected",true);
		Thread.sleep(2000);
		requestID.sendKeys(RequestID);
		Reporter.log("Request ID entered.",true);
		Thread.sleep(2000);
		submitBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = alertMessage.getText();
		String expected_message = Messages.requestSubmitInAgentLogs;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Workflow logs request not submitted");
		Reporter.log("Workflow logs request submitted successfully",true);
		Thread.sleep(10000);
		refreshBtn.click();
		Thread.sleep(2000);
		WebElement downloadBtn=driver.findElement(By.xpath("//table/tr/td[text()='"+RequestID+"']/../td/span"));
		downloadBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message1 = alertMessage.getText();
		String expected_message1 = Messages.downloadInAgentLogs;
		Reporter.log("Actual Success Msg:" + actual_message1,true);
		Reporter.log("Expected Success Msg:" + expected_message1,true);
		Assert.assertEquals(actual_message1,expected_message1, "Workflow logs download not started");
		Reporter.log("Workflow log downloaded successfully for Workflow InstanceID "+RequestID,true);
		Thread.sleep(2000);
		informationpageta.validateSignOut();

	}
	public void validateAssistedAgentLogs(String AgentType,String AgentName,String startYear,String startMonth,String 
			startdate,String endYear,String endMonth,String EndDate ) throws Exception {
		validateAgentLogs(AgentType, AgentName, startYear, startMonth, startdate, endYear, endMonth, EndDate);
	}
}


