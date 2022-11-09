package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.util.Messages;

public class SmtpPageTA extends TestBase {
	public LoginPageTA loginpageta = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 120);
	public InformationPageTA informationpageta=new InformationPageTA();
	@FindBy(xpath = "//span[(text()='Settings')]")
	WebElement settingsTab;
	@FindBy(xpath = "//li/a[contains(text(),'SMTP')]")
	WebElement smtpTab;
	@FindBy(xpath = "//button[@name='add-new']")
	WebElement addSmtpBtn;
	@FindBy(id = "host")
	WebElement hostName;
	@FindBy(id = "port")
	WebElement portNo;
	@FindBy(id = "authenticate")
	WebElement authenticateCheckbx;
	@FindBy(id = "smtpUserName")
	WebElement smtpUserName;
	@FindBy(id = "smtpPassword")
	WebElement smtpPassword;
	@FindBy(id = "encryptionType")
	WebElement encryptionTypeDrpDwn;
	@FindBy(id = "smtpPersonalName")
	WebElement personalName;
	@FindBy(name = "test-smtp")
	WebElement testConnectionBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement successMsgBox;
	@FindBy(xpath = "//button[@name='save'and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath="//button[@id='edit']")
	WebElement editBtn;
	@FindBy(xpath="//button[@id='delete']")
	WebElement deleteBtn;
	@FindBy(id="popup-button-ok")
	WebElement deleteConfirmation;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement protocolDropdown;
	@FindBy(xpath="(//span[@class='mul-checkmark'])[4]")
	WebElement protocol;

	 
	public SmtpPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateSetSmtpServerTA(String hname, String portno, String uName, String pswd, String encrypType,
			String pName) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		Reporter.log("Settings tab clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(smtpTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", smtpTab);
		Reporter.log("SMTP tab clicked",true);
		Thread.sleep(2000);
        //wait.until(ExpectedConditions.elementToBeClickable(addSmtpBtn)); 
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", addSmtpBtn);
		Reporter.log("Add smtp config button clicked",true);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		hostName.sendKeys(hname);
		Thread.sleep(2000);
		portNo.sendKeys(portno);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (!authenticateCheckbx.isSelected()) {
			authenticateCheckbx.click();
		} else {
			System.out.println("Authenticate checkbox is already selected.");
		}
		smtpUserName.sendKeys(uName);
		Thread.sleep(2000);
		smtpPassword.sendKeys(pswd);
		Thread.sleep(2000);
		Select encryption_DropDown = new Select(encryptionTypeDrpDwn);
		encryption_DropDown.selectByVisibleText(encrypType);
		Thread.sleep(2000);
		protocolDropdown.click();
		protocol.click();
		protocolDropdown.click();
		personalName.sendKeys(pName);
		Thread.sleep(2000);
		testConnectionBtn.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String Actual_testConnectionMsg = successMsgBox.getText();
		String Expected_testConnectionMsg = "SMTP test connection successful";
		Assert.assertEquals(Actual_testConnectionMsg, Expected_testConnectionMsg, "Test connection Failed");
		Reporter.log("Tested connection successfully",true);
		Thread.sleep(6000);
		saveBtn.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String Actual_smtpConnectionMsg = successMsgBox.getText();
		String Expected_smtpConnectionMsg = Messages.addSmtpServer;
		Assert.assertEquals(Actual_smtpConnectionMsg, Expected_smtpConnectionMsg, "SMTP configuration Failed");
		Reporter.log("Smtp configured successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateEditSmtpServerTA(String NewPersonalName) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		Reporter.log("Settings tab clicked",true);
		js.executeScript("arguments[0].click();", smtpTab);
		Reporter.log("SMTP tab clicked",true);
		Thread.sleep(2000);
		editBtn.click();
		Reporter.log("Edit button clicked",true);
		Thread.sleep(2000);
		for(int i=0;i<30;i++) {
			personalName.sendKeys(Keys.BACK_SPACE);
		}
		personalName.sendKeys(NewPersonalName);
		Thread.sleep(2000);
		testConnectionBtn.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String Actual_testConnectionMsg = successMsgBox.getText();
		String Expected_testConnectionMsg = "SMTP test connection successful";
		Assert.assertEquals(Actual_testConnectionMsg, Expected_testConnectionMsg, "Test connection Failed");
		Reporter.log("Tested connection successfully",true);
		Thread.sleep(6000);
		saveBtn.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String Actual_smtpConnectionMsg = successMsgBox.getText();
		String Expected_smtpConnectionMsg = Messages.addSmtpServer;
		Assert.assertEquals(Actual_smtpConnectionMsg, Expected_smtpConnectionMsg, "SMTP configuration Failed");
		Reporter.log("Smtp edited successfully",true);
		informationpageta.validateSignOut();
}
	public void validateDeleteSmtpServerTA() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		Reporter.log("Settings tab clicked",true);
		js.executeScript("arguments[0].click();", smtpTab);
		Reporter.log("SMTP tab clicked",true);
		Thread.sleep(2000);
		deleteBtn.click();
		Reporter.log("Delete button clicked",true);
		deleteConfirmation.click();
		Reporter.log("Confirmation popup agree for deletion",true);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String Actual_smtpConnectionMsg = successMsgBox.getText();
		String Expected_smtpConnectionMsg = Messages.deleteSMTPConfig;
		Assert.assertEquals(Actual_smtpConnectionMsg, Expected_smtpConnectionMsg, "SMTP configuration details not delted");
		Reporter.log("Smtp Configuration details deleted successfully",true);
		informationpageta.validateSignOut();
}
	public void validateSMTPPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",settingsTab);
		js.executeScript("arguments[0].click();",smtpTab);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);	
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
