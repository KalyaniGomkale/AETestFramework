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

	

}
