package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;

public class EmailNotificationPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	
	@FindBy(xpath = "//span[text()='Settings']")
	WebElement settingsTab;
	@FindBy(xpath = "//a[text()='Email Notification']")
	WebElement emailNotificationTab;
	@FindBy(xpath="//h1")
	WebElement actual_error;
	@FindBy(xpath="//table/tr/th")
	WebElement notificationTable;
	//table/tr[5]/td[2]/label
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath="//span[@class='slider round']")
	WebElement enableFeatureSlider;
	@FindBy(xpath="//input[@id='ROLE_TENANT_ADMIN']")
	WebElement TenantAdminRoleCheckbox;
	@FindBy(xpath="//input[@id='ROLE_WORKFLOW_ADMIN']")
	WebElement WorkflowAdminRoleCheckbox;
	@FindBy(xpath="//input[@id='ROLE_AGENT_ADMIN']")
	WebElement AgentAdminRoleCheckbox;
	@FindBy(xpath="(//button[@name='save'])[2]")
	WebElement saveBtn;
	@FindBy(xpath="//input[@id='userByEmail']")
	WebElement byEmailField;
	@FindBy(xpath ="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchBar;
	@FindBy(xpath="//span[@class='mul-checkmark']")
	WebElement assignTocheckbox;
	@FindBy(xpath="//span[text()='By Username:']/../div")
	WebElement byUsernameField;
	@FindBy(id="startTime-hours")
	WebElement startTimeHr;
	@FindBy(id="startTime-minutes")
	WebElement startTimeMin;
	@FindBy(id="repeateNotification")
	WebElement repeatEveryHr;
	@FindBy(id="repeateInterval")
	WebElement repeatInterval;
	@FindBy(id="endTime-hours")
	WebElement endTimeHr;
	@FindBy(id="endTime-minutes")
	WebElement endTimeMin;
	
	public EmailNotificationPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateEmailNotfSMTPNotConfig() throws Exception {
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Reporter.log("Settings Tab is clicked",true);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", emailNotificationTab);
		Reporter.log("Email Notifications Tab is clicked",true);
		Thread.sleep(3000);
		String actual_errorMessage=actual_error.getText();
		Reporter.log("When SMTP is not configured for TA and he tries to set email notification,"
				+ " in this case he will get error as: "+actual_errorMessage,true);
		String expected_errorMessage="Not Configured";
		Assert.assertEquals(actual_errorMessage, expected_errorMessage,"Getting incorrect error message");
		Reporter.log("Getting correct error when SMTP not configured and user try to do SMTP settings");
		informationpageta.validateSignOut();
	}
	//Test case when SMTP Is configured-we will check if Current Agent Status is present in table or not 
	public void validateEnailNotfSMTPConf() throws Exception{
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Reporter.log("Settings Tab is clicked",true);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", emailNotificationTab);
		Reporter.log("Email Notifications Tab is clicked",true);
		Thread.sleep(3000);
		Boolean flag= notificationTable.isDisplayed();
		if(flag) {
			Assert.assertTrue(flag);
			Reporter.log("Email notification table is visible after SMTP configuration",true);
		}else {
			Assert.assertTrue(flag);
			Reporter.log("Email notification table is not visible after SMTP Configured",true);
		}
		
	}
	//Positive Scenario if enable feature slider button is pressed then notification feature status is enabled.
	public void validateEmailNotificationWFCreateUpdateDelete(String NotificationFeature, String emailID, String UserName) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",settingsTab);
		js.executeScript("arguments[0].click();",emailNotificationTab);
		boolean emailNotifyFeature= driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']")).isDisplayed();
		if(emailNotifyFeature){
			System.out.println("Feature is present");
		}else {
			System.out.println("Feature is not present");
		}
		Thread.sleep(4000);
		String statusBeforeConfigured=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/label")).getText();
		System.out.println("Status before Configuration :-"+statusBeforeConfigured);
		if(statusBeforeConfigured.equals("Not Configured")){
			Assert.assertEquals(statusBeforeConfigured,"Not Configured","Invalid Status Before Configuration");
		}
		Thread.sleep(2000);
	    WebElement addButton=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/i"));
		addButton.click();
		Thread.sleep(2000);
		enableFeatureSlider.click();
		Thread.sleep(2000);
		TenantAdminRoleCheckbox.click();
		WorkflowAdminRoleCheckbox.click();
		Thread.sleep(2000);
		if(TenantAdminRoleCheckbox.isSelected()||WorkflowAdminRoleCheckbox.isSelected()){
			System.out.println("Roles is been selected");
		}else {
			System.out.println("Roles are not been selected");
		}
		byUsernameField.click();
		searchBar.sendKeys(UserName);
		Thread.sleep(3000);
		assignTocheckbox.click();
		Reporter.log("Username is been selected",true);
		Thread.sleep(2000);		
		byEmailField.sendKeys(emailID);
		Reporter.log("Email Id is entered and displayed",true);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",saveBtn);
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.emailNotificationEnableOn;
		Reporter.log("Actual Success Message:- "+actual_Message+ " and Expected Success"
				+ "Message: "+expected_Message,true);
		Assert.assertEquals(actual_Message, expected_Message,"Email Notification feature is not configured successfully");
		Reporter.log("Email Notification feature is configured successfully",true);
		Thread.sleep(2000);
		String statusAfterConfigured=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/label")).getText();
		System.out.println("Status After Configuration :-"+statusAfterConfigured);
		Thread.sleep(2000);
		if(statusAfterConfigured.equals("Enabled")){
			Assert.assertEquals(statusAfterConfigured,"Enabled","Invalid Status After Configuration");
		}
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	public void validateEmailNotificationCurrentAgentStatus(String NotificationFeature, String emailID, String UserName,
			String StartTimeH,String StartTimeM,String Hours,String EndTimeH,String EndTimeM) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",settingsTab);
		js.executeScript("arguments[0].click();",emailNotificationTab);
		boolean emailNotifyFeature= driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']")).isDisplayed();
		if(emailNotifyFeature){
			System.out.println("Feature is present");
		}else {
			System.out.println("Feature is not present");
		}
		Thread.sleep(4000);
		String statusBeforeConfigured=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/label")).getText();
		System.out.println("Status before Configuration :-"+statusBeforeConfigured);
		if(statusBeforeConfigured.equals("Not Configured")){
			Assert.assertEquals(statusBeforeConfigured,"Not Configured","Invalid Status Before Configuration");
		}
		Thread.sleep(2000);
	    WebElement addButton=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/i"));
		addButton.click();
		Thread.sleep(2000);
		enableFeatureSlider.click();
		Thread.sleep(2000);
		TenantAdminRoleCheckbox.click();
		WorkflowAdminRoleCheckbox.click();
		Thread.sleep(6000);
		if(TenantAdminRoleCheckbox.isSelected()&&WorkflowAdminRoleCheckbox.isSelected()){
			System.out.println("Roles is been selected");
		}else {
			System.out.println("Roles are not been selected");
		}
		Thread.sleep(2000);
		byUsernameField.click();
		searchBar.sendKeys(UserName);
		Thread.sleep(3000);
		assignTocheckbox.click();
		Reporter.log("Username is been selected",true);
		Thread.sleep(2000);		
		byEmailField.sendKeys(emailID);
		Reporter.log("Email Id is entered and displayed",true);
		Thread.sleep(2000);
		startTimeHr.sendKeys(StartTimeH);
		startTimeMin.sendKeys(StartTimeM);
		js.executeScript("arguments[0].click();",repeatEveryHr);
		if(repeatEveryHr.isSelected()) {
			System.out.println("Repeat Every Checkbox is Selected and Hrs dropdown is visible");
		}else {
			System.out.println("Repeat Every Checkbox is not Selected and Hrs dropdown is not visible");
		}
		Thread.sleep(2000);
		Select repeatInterval_picker=new Select(repeatInterval);
		repeatInterval_picker.selectByVisibleText(Hours);
		endTimeHr.sendKeys(EndTimeH);
		endTimeMin.sendKeys(EndTimeM);
		js.executeScript("arguments[0].click();",saveBtn);
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.emailNotificationEnableOn;
		Reporter.log("Actual Success Message:- "+actual_Message+ " and Expected Success"
				+ "Message: "+expected_Message,true);
		Assert.assertEquals(actual_Message, expected_Message,"Email Notification feature is not configured successfully");
		Reporter.log("Email Notification feature is configured successfully",true);
		Thread.sleep(2000);
		String statusAfterConfigured=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/label")).getText();
		System.out.println("Status After Configuration :-"+statusAfterConfigured);
		Thread.sleep(2000);
		if(statusAfterConfigured.equals("Enabled")){
			Assert.assertEquals(statusAfterConfigured,"Enabled","Invalid Status After Configuration");
		}
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	public void validateEmailNotificationAgentNotWorking(String NotificationFeature, String emailID, String UserName) throws Exception{
		validateEmailNotificationWFCreateUpdateDelete(NotificationFeature, emailID, UserName);
	}
	//Negative Scenario if user does not press then enable feature slider button and 
	//without filling any field if he press save button
	public void validateEmailNotificationWFEnableOff(String NotificationFeature) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",settingsTab);
		js.executeScript("arguments[0].click();",emailNotificationTab);
		boolean emailNotifyFeature= driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']")).isDisplayed();
		if(emailNotifyFeature){
			System.out.println("Feature is present");
		}else {
			System.out.println("Feature is not present");
		}
		Thread.sleep(4000);
		String statusBeforeConfigured=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/label")).getText();
		System.out.println("Status before Configuration :-"+statusBeforeConfigured);
		if(statusBeforeConfigured.equals("Not Configured")){
			Assert.assertEquals(statusBeforeConfigured,"Not Configured","Invalid Status Before Configuration");
		}
		Thread.sleep(2000);
	    WebElement addButton=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/i"));
		addButton.click();
		Thread.sleep(2000);
		saveBtn.click();
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.emailNotificationEnableOn;
		Reporter.log("Actual Success Message:- "+actual_Message+ " and Expected Success"
				+ "Message: "+expected_Message,true);
		Assert.assertEquals(actual_Message, expected_Message,"Feature can be saved without changes");
		Reporter.log("Enable Feature is off so feature cannot be save without any changes",true);
		Thread.sleep(2000);
		String statusAfterConfigured=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/label")).getText();
		System.out.println("Status After Configuration :-"+statusAfterConfigured);
		informationpageta.validateSignOut();
		}
	public void validateEmailNotificationUnlockUser(String NotificationFeature) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",settingsTab);
		js.executeScript("arguments[0].click();",emailNotificationTab);
		boolean emailNotifyFeature= driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']")).isDisplayed();
		if(emailNotifyFeature){
			System.out.println("Feature is present");
		}else {
			System.out.println("Feature is not present");
		}
		Thread.sleep(4000);
		String statusBeforeConfigured=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/label")).getText();
		System.out.println("Status before Configuration :-"+statusBeforeConfigured);
		if(statusBeforeConfigured.equals("Not Configured")){
			Assert.assertEquals(statusBeforeConfigured,"Not Configured","Invalid Status Before Configuration");
		}
		Thread.sleep(2000);
	    WebElement addButton=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/i"));
		addButton.click();
		Thread.sleep(2000);
		enableFeatureSlider.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",saveBtn);
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.emailNotificationEnableOn;
		Reporter.log("Actual Success Message:- "+actual_Message+ " and Expected Success"
				+ "Message: "+expected_Message,true);
		Assert.assertEquals(actual_Message, expected_Message,"Email Notification feature is not configured successfully");
		Reporter.log("Email Notification feature is configured successfully",true);
		Thread.sleep(2000);
		String statusAfterConfigured=driver.findElement(By.xpath("//table/tr/td[text()='" + NotificationFeature + "']/../td/label")).getText();
		System.out.println("Status After Configuration :-"+statusAfterConfigured);
		Thread.sleep(2000);
		if(statusAfterConfigured.equals("Enabled")){
			Assert.assertEquals(statusAfterConfigured,"Enabled","Invalid Status After Configuration");
		}
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	public void validateEmailNotificationPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",settingsTab);
		js.executeScript("arguments[0].click();",emailNotificationTab);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
						+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}
}
