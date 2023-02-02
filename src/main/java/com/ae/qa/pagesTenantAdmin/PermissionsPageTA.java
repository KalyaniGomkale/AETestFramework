package com.ae.qa.pagesTenantAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;

public class PermissionsPageTA extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();

	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Permissions']")
	WebElement permissionsTab;
	@FindBy(xpath = "//button[normalize-space(text())='Workflows']")
	WebElement workflowsBtn;
	@FindBy(xpath = "//button[normalize-space(text())='Groups']")
	WebElement groupBtn;
	@FindBy(xpath = "//button[contains(text(),'Users')]")
	WebElement usersBtn;
	@FindBy(xpath = "(//button[@name='save'])[2]")
	WebElement saveBtn;
	@FindBy(name = "submit")
	WebElement submitBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath = "//table/tr/td/i/b")
	WebElement NoRecordMessage;
	@FindBy(id = "wfDesc")
	WebElement wfDescription;

	public PermissionsPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void selectPermissions(String wfName,String userName,String userName1,String permission) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked", true);
		//wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions Tab is clicked", true);
		//We need to select the workflow first
		workflowsBtn.click();
		Thread.sleep(2000);
		Reporter.log("Workflows button is clicked", true);
		WebElement selectWF = driver.findElement(By.xpath("//div/ul/li[normalize-space(@title) = '"+wfName+"']/label/i"));
		selectWF.click();
		Reporter.log("Workflow is been selected", true);
		usersBtn.click();
		Reporter.log("Users button is clicked", true);
		WebElement selectPermisson = driver.findElement(By.xpath("//div/ul/li/label[normalize-space(@title)='"+userName+" "+userName1+"']/../span/label/del[normalize-space()='"+permission+"']"));
		selectPermisson.click();
		Reporter.log("Permission is selected successfully", true);
		Thread.sleep(2000);
		saveBtn.click();
		Reporter.log("Save button is clicked", true);
		Thread.sleep(2000);
		String actual_SuccessMsg = alertMessage.getText();
		Reporter.log("Actual Success Message:- " +actual_SuccessMsg);
		String expected_SuccessMsg=Messages.permissionsSuccessMsg;
		Reporter.log("Expected Success Message:- " +expected_SuccessMsg);
		Assert.assertEquals(actual_SuccessMsg, expected_SuccessMsg, "Permission not updated successfully");
		Reporter.log("Permission is updated successfully",true);
		informationpageta.validateSignOut();
	}

}
