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
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.Messages;

public class SmtpPage extends TestBase {
	public LoginPage loginpage = new LoginPage();
	public static WebDriverWait wait = new WebDriverWait(driver, 120);
	public InformationPage informationpage=new InformationPage();
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
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement protocolDropdown;
	@FindBy(xpath="(//span[@class='mul-checkmark'])[4]")
	WebElement protocol;

	public SmtpPage() {
		// this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void validateAddSmtpServer(String hname, String portno, String uName, String pswd, String encrypType,
			String pName) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		//wait.until(ExpectedConditions.visibilityOf(smtpTab));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", smtpTab);
		System.out.println("SMTP tab clicked");
		 Thread.sleep(10000);
		js.executeScript("arguments[0].click();", addSmtpBtn);
		Thread.sleep(2000);
		Reporter.log("Add smtp config button clicked",true);
		hostName.sendKeys(hname);
		Thread.sleep(2000);
		portNo.sendKeys(portno);
		Thread.sleep(2000);
		if (!authenticateCheckbx.isSelected()) {
			authenticateCheckbx.click();
		} else {
			System.out.println("Authenticate checkbox is already selected.");
		}
		Thread.sleep(5000);
		smtpUserName.sendKeys(uName);
		Thread.sleep(2000);
		smtpPassword.sendKeys(pswd);
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
		Reporter.log("Test connection successfully",true);
		Thread.sleep(6000);
		saveBtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String Actual_smtpConnectionMsg = successMsgBox.getText();
		String Expected_smtpConnectionMsg = Messages.addSmtpServer;
		Assert.assertEquals(Actual_smtpConnectionMsg, Expected_smtpConnectionMsg, "SMTP configuration Failed");
		Reporter.log("SMTP configured successfully",true);
		informationpage.validateSignOut();

	}
	public void validateSMTPPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(smtpTab));
		js.executeScript("arguments[0].click();", smtpTab);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
						+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpage.validateSignOut();
	}
}
