package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class SystemSettingsPage extends TestBase {
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage = new InformationPage();
	public static WebDriverWait wait = new WebDriverWait(driver, 120);
	@FindBy(xpath = "//span[(text()='Settings')]")
	WebElement settingsTab;
	@FindBy(xpath = "//button[@name='add-new']/span")
	WebElement configureBtn;
	@FindBy(name = "dropdown-selector")
	WebElement configureDropdown;
	@FindBy(xpath = "//button[@aria-expanded='false']/b")
	WebElement httpProtocolBtn;
	@FindBy(xpath = "//span[(text()='http://')]")
	WebElement httpOption;
	@FindBy(xpath = "//span[(text()='https://')]")
	WebElement httpsOption;
	@FindBy(id = "serverUrl")
	WebElement serverUrl;
	@FindBy(id = "drServerUrl")
	WebElement drServerUrl;
	@FindBy(id = "cleanupOldReqHours")
	WebElement cleanUpRequest;
	@FindBy(name = "verify")
	WebElement verifyUrlBtn;
	@FindBy(xpath = "//button[@name='save' and @type='button']")
	WebElement saveBtn;
	@FindBy(xpath = "//button[@name='cancel' and @type='button']")
	WebElement cancelBtn;
	@FindBy(xpath = "//div[@class='alert alert-success ae-alert ae-success-alert place-alert']")
	WebElement SuccessMsgBox;
	@FindBy(xpath = "//div[@class='alert ae-alert place-alert alert-danger ae-danger-alert']")
	WebElement failMsgBox;
	@FindBy(xpath = "//span[contains(text(),'DR Site')]")
	WebElement drSite;
	@FindBy(xpath="//div[@class='form-body']/div/h2")
	WebElement ServerSettingsStatus;
	@FindBy(xpath="//div[@class='card popup-panel border-0']/div[2]")
	WebElement agentPopup;
	@FindBy(xpath="//span[text()='Agents']")
	WebElement AgentsTab;
	@FindBy(id="popup-button-ok")
	WebElement okBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	
	public SystemSettingsPage() {
		PageFactory.initElements(driver, this);
	}
//Validate user gets proper message when TA try to download agent without doing system settings	
	public void validateAgentServerNotSet() throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		String actual_settingsStatus=ServerSettingsStatus.getText();
		System.out.println("After sysadmin login Server Setting is:  "+actual_settingsStatus);
		//Reporter.log("After sysadmin login Server Setting is: "+actual_settingsStatus,true);
		String expected_settingsStatus="Not Configured";
		Thread.sleep(2000);
		Assert.assertEquals(actual_settingsStatus,expected_settingsStatus);
		Reporter.log("Server Settings are not done, validated successfully");
		Thread.sleep(4000);
		informationpage.validateSignOut();
		driver.navigate().to(prop.getProperty("url"));
		loginpage.ValidateFirstTimeLogin(prop.getProperty("username_TA"),prop.getProperty("FT_password_TA"),prop.getProperty("password_TA"));
		driver.navigate().to(prop.getProperty("url"));
		//now negative case is when sysadmin do not do system settings in that case TA is not able to download agent
		//so Login as TA, navigate to agents tab and check the popup is coming correctly or not
		loginpage.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		String actual_agentPopup=agentPopup.getText();
		Reporter.log("When server settings are not done & user try to download agent.Popup is : "+actual_agentPopup,true);
		String expected_agentPopup="It seems you have not configured the server URL for this server. Please contact administrator";
		Assert.assertEquals(actual_agentPopup,expected_agentPopup);
		Reporter.log("Agent can't be download due ro server settings,Error validated successfully");
		okBtn.click();
		informationpage.validateSignOut();
	}
	
	//When user give Invalid URL in system settings
	public void validateInvalidURL(String invalidServerURL) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		Reporter.log("Settings tab clicked",true);
		Thread.sleep(3000);
		configureBtn.click();
		Reporter.log("configure button is clicked",true);
		Reporter.log("Started configuring server url",true);
		httpProtocolBtn.click();
		Thread.sleep(1000);
		httpOption.click();
		for (int i = 0; i < 50; i++) {
			serverUrl.sendKeys(Keys.BACK_SPACE);
		}
		serverUrl.sendKeys(invalidServerURL);
		Thread.sleep(2000);
		verifyUrlBtn.click();
		Reporter.log("Verify button is clicked",true);
		String actual_success_msg =alertMessage.getText();
		String expected_success_msg = Messages.setInvalidServerUrl;
		System.out.println("actual success msg is: " + actual_success_msg);
		Assert.assertEquals(actual_success_msg, expected_success_msg, "System settings are not configured.");
	}

	public void validateServerUrl(String serverURL,String cleanUpRequestHour) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		Reporter.log("Settings tab clicked",true);
		Thread.sleep(3000);
		configureBtn.click();
		Reporter.log("configure button is clicked",true);
		Reporter.log("Started configuring server url",true);
		httpProtocolBtn.click();
		Thread.sleep(1000);
		httpOption.click();
		for (int i = 0; i < 50; i++) {
			serverUrl.sendKeys(Keys.BACK_SPACE);
		}
		serverUrl.sendKeys(serverURL);
		Thread.sleep(2000);
		cleanUpRequest.sendKeys(cleanUpRequestHour);
		if (verifyUrlBtn.isDisplayed()) {
			verifyUrlBtn.click();
			Reporter.log("Verify button is clicked",true);
			wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
			saveBtn.click();
			Thread.sleep(1000);
			String actual_success_msg =alertMessage.getText();
			String expected_success_msg = Messages.setServerUrl;
			System.out.println("actual success msg is: " + actual_success_msg);
			Assert.assertEquals(actual_success_msg, expected_success_msg, "System settings are not configured.");
			Reporter.log("System Settings saved",true);
		} else {
			Reporter.log("System settings is not configured",true);
			Assert.assertTrue(false);
		}
		informationpage.validateSignOut();
	}

	public void EditCleanUpRequest(String serverURL,String cleanUpRequestHour) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		Thread.sleep(3000);
		configureBtn.click();
		Reporter.log("configure button is clicked",true);
		Reporter.log("Started configuring server url",true);
		httpProtocolBtn.click();
		Thread.sleep(1000);
		httpOption.click();
		for (int i = 0; i < 50; i++) {
			serverUrl.sendKeys(Keys.BACK_SPACE);
		}
		serverUrl.sendKeys(serverURL);
		Reporter.log("Server URL field edited Successfully",true);
		Thread.sleep(2000);
		for (int i = 0; i < 5; i++) {
			cleanUpRequest.sendKeys(Keys.BACK_SPACE);
		}
		cleanUpRequest.sendKeys(cleanUpRequestHour);
		Reporter.log("Clean Up Requests Hours field edited Successfully",true);
		if (verifyUrlBtn.isDisplayed()) {
			verifyUrlBtn.click();
			Reporter.log("Verify button is clicked",true);
			wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
			saveBtn.click();
			Thread.sleep(1000);
			String actual_success_msg = alertMessage.getText();
			String expected_success_msg = Messages.setServerUrl;
			System.out.println("actual success msg is: " + actual_success_msg);
			Assert.assertEquals(actual_success_msg, expected_success_msg, "System settings are not configured.");
			Reporter.log("System Settings saved",true);
		} else {
			Reporter.log("System settings not configured",true);
			Assert.assertTrue(false);
		}
		informationpage.validateSignOut();
	}

	public void ValidateDRServerUrl(String DRServerURL,String cleanUpRequestHour) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		//wait.until(ExpectedConditions.elementToBeClickable(configureDropdown));
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", configureDropdown);
		Reporter.log("configure dropdown selected",true);
		drSite.click();
		log.info("Started configuring DR server url");
		httpProtocolBtn.click();
		Thread.sleep(1000);
		httpOption.click();
		for (int i = 0; i < 50; i++) {
			drServerUrl.sendKeys(Keys.BACK_SPACE);
		}
		drServerUrl.sendKeys(DRServerURL);
		Thread.sleep(2000);
		for (int i = 0; i < 10; i++) {
			cleanUpRequest.sendKeys(Keys.BACK_SPACE);
		}
		cleanUpRequest.sendKeys(cleanUpRequestHour);
		verifyUrlBtn.click();
		Reporter.log("Verify button is clicked",true);
			Thread.sleep(10000);
		if(saveBtn.isEnabled()) {
			saveBtn.click();
			Thread.sleep(1000);
			String actual_success_msg =alertMessage.getText();
			String expected_success_msg = Messages.setServerUrl;
			System.out.println("actual success msg is: " + actual_success_msg);
			Assert.assertEquals(actual_success_msg, expected_success_msg, "System settings are not configured.");
			Reporter.log("System Settings for DR Server saved successfully");
		} else {
			Reporter.log("System settings for DR Server not configured validation of URL fail",true);
			Assert.assertTrue(false);
		}
		informationpage.validateSignOut();
	}
	public void validateSystemSettingsPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
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