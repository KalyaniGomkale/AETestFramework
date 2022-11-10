package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

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
import com.ae.qa.util.Messages;


public class WorkflowsPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 220);
	public LoginPage loginpage = new LoginPage();
	public WebElements webelements = new WebElements();
	public InformationPage informationpage=new InformationPage();
	

	@FindBy(xpath = "//span[(text()='Workflows')]")
	WebElement workflowsTab;
	@FindBy(id = "operation")
	WebElement operationDropdown;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement reasondropdown;
	@FindBy(xpath="//label[contains(text(),'Plugin Update')]/span")
	WebElement pluginUpdateCheckbox;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement PluginCheckbox;
	@FindBy(xpath = "//button[text()='Enable']")
	WebElement enableBtn;
	@FindBy(xpath="//button[text()='Disable']")
	WebElement disableBtn;
	@FindBy(xpath = "//table/tr/th/span[text()='Message']/../../../tbody/tr[1]/td[5]")
	WebElement Message;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement success_Message;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public WorkflowsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validateDisableWorkflows(String operation) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Workflows Tab
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",workflowsTab);
		Thread.sleep(3000);
		Select option_dropdown=new Select(operationDropdown);//Disable all workflows
		option_dropdown.selectByVisibleText(operation);
		Reporter.log("Opertaion of "+operation+" is selected from dropdown",true);
		reasondropdown.click();
		Thread.sleep(3000);
		pluginUpdateCheckbox.click();
		Reporter.log("Plugin Update checkbox selected",true);
		Thread.sleep(3000);
		disableBtn.click();
		Reporter.log("Disable button is selected, now verify message",true);
		Thread.sleep(3000);
		String actualMessage=Message.getText();
		String expectedMessage="Workflow disabled";
		Reporter.log("Message get after disabling workflow: "+actualMessage,true);
		Reporter.log("Workflow disabled successfully",true);
		informationpage.validateSignOut();
	}
	public void validateEnableWorkflows(String operation) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Workflows Tab
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",workflowsTab);
		Thread.sleep(3000);
		Select option_dropdown=new Select(operationDropdown);//Enable all workflows
		option_dropdown.selectByVisibleText(operation);
		Reporter.log("Opertaion of "+operation+" is selected from dropdown",true);
		reasondropdown.click();
		Thread.sleep(3000);
		pluginUpdateCheckbox.click();
		Reporter.log("Plugin Update checkbox selected",true);
		Thread.sleep(3000);
		enableBtn.click();
		Reporter.log("Enable button is selected, now verify message",true);
		Thread.sleep(3000);
		String actualMessage= Message.getText();
		String expectedMessage="Workflow enabled successfully";
		Reporter.log("Message get after enabling workflow: "+actualMessage,true);
		Reporter.log("Workflow enabled successfully",true);
		informationpage.validateSignOut();
	}
	public void validateWorkflowsPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",workflowsTab);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
						+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and "
						+ "appropriate page is loaded properly",true);
		informationpage.validateSignOut();
	}

}
