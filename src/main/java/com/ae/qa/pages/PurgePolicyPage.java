package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

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

public class PurgePolicyPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 120);
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage=new InformationPage();
	public WebElements webelements = new WebElements();

	@FindBy(xpath = "//span[(text()='Purging')]")
	WebElement purgingTab;
	@FindBy(name = "add-new")
	WebElement addBtn;
	@FindBy(xpath="//span[@class='fa fa-edit']")
	WebElement editBtn;
	@FindBy(id = "durationRequests")
	WebElement WFRequests;
	@FindBy(id = "durationAudits")
	WebElement AuditLogs;
	@FindBy(id = "durationNotificationHistory")
	WebElement NotificationHistory;
//	@FindBy(id = "durationSessionHistory")
	//WebElement UserSessionHistory;
	@FindBy(xpath = "//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alert_Message;
	@FindBy(xpath="//input[@id='adv-input']")
	WebElement emailBox;
	@FindBy(xpath= "//div[@class='error']")
	WebElement errorMsg;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public PurgePolicyPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	
	public void validateWFReqLessThanNotf(String wfRequests,String auditLogs,String notHistory) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Purging Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(purgingTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", purgingTab);
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(addBtn));
		js.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);
		int WFRequest=Integer.valueOf(wfRequests);
		WFRequests.sendKeys("" +WFRequest);
		Thread.sleep(2000);
		int AudititLog=Integer.valueOf(auditLogs);
		AuditLogs.sendKeys("" +AudititLog);
		Thread.sleep(2000);
		int NotHistory=Integer.valueOf(notHistory);
		NotificationHistory.sendKeys("" +NotHistory);
		Thread.sleep(2000);	
		js.executeScript("arguments[0].click();", saveBtn);
		String Actual_ErrorMsg = alert_Message.getText();
		Reporter.log("Actual Error when notification history is gretaer than wf request" + Actual_ErrorMsg,true);
		String Expected_ErrorMsg = Messages.purgeError;
		Reporter.log("Expected Error when notification history is gretaer than wf request:" + Expected_ErrorMsg,true);
		Assert.assertEquals(Actual_ErrorMsg,Expected_ErrorMsg, "error message not coming.");
		Reporter.log("Getting correct error message.",true);
		Thread.sleep(3000);
		informationpage.validateSignOut();
  }
	
	public void validatePurgePolicyDuration(String wfRequests,String auditLogs,String notHistory)
			throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Purging Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(purgingTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", purgingTab);
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(addBtn));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);
		int WFRequest=Integer.valueOf(wfRequests);
		WFRequests.sendKeys("" +WFRequest);
		Thread.sleep(2000);
		int AudititLog=Integer.valueOf(auditLogs);
		AuditLogs.sendKeys("" +AudititLog);
		Thread.sleep(2000);
		int NotHistory=Integer.valueOf(notHistory);
		NotificationHistory.sendKeys("" +NotHistory);
		Thread.sleep(2000);
		if (WFRequest>= NotHistory) {
	//		UserSessionHistory.sendKeys("" + userSessionHist);
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", saveBtn);
			String Actual_SuccessMsg = alert_Message.getText();
			Reporter.log("Actual success message after setting purging policy:" + Actual_SuccessMsg,true);
			String Expected_SuccessMsg = Messages.purgePolicyDuration;
			Reporter.log("Expected success message after setting purging policy:" + Expected_SuccessMsg,true);
			Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Purge policy not saved successfully");
			Reporter.log("Purge policy saved successfully",true);
		} else {
			Assert.assertTrue(WFRequest >= NotHistory,
					"Value for Notification history must be less than or equal to Workflow Request.");
			Reporter.log("Purge policy not saved-failure",true);
		}
		Thread.sleep(3000);
		//informationpage.validateSignOut();
  }
	
	public void validateUpdationPurgePolicyDuration(String wfRequests, String auditLogs, String notHistory) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Purging Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(purgingTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", purgingTab);
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(editBtn));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", editBtn);
		Thread.sleep(2000);
		for(int i=0;i<5;i++) {
			WFRequests.sendKeys(Keys.BACK_SPACE);
		}
		WFRequests.sendKeys("" + wfRequests);
		int wkfRequest=Integer.valueOf(wfRequests);
		Thread.sleep(2000);
		for(int i=0;i<5;i++) {
			AuditLogs.sendKeys(Keys.BACK_SPACE);
		}
		AuditLogs.sendKeys("" + auditLogs);
		int AitLogs=Integer.valueOf(auditLogs);
		Thread.sleep(2000);
		for(int i=0;i<5;i++) {
			NotificationHistory.sendKeys(Keys.BACK_SPACE);
		}
		NotificationHistory.sendKeys("" + notHistory);
		int history=Integer.valueOf(notHistory);
		Thread.sleep(2000);
		emailBox.click();
		if (wkfRequest >= history) {
	//		UserSessionHistory.sendKeys("" + userSessionHist);
			Thread.sleep(5000);
			js.executeScript("arguments[0].click();", saveBtn);
			String Actual_SuccessMsg = alert_Message.getText();
			Reporter.log("Actual success message after setting purging policy:" + Actual_SuccessMsg,true);
			String Expected_SuccessMsg = Messages.purgePolicyDuration;
			Reporter.log("Expected success message after setting purging policy:" + Expected_SuccessMsg,true);
			Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Purge policy not saved successfully");
			Reporter.log("Purge policy saved successfully",true);
		} else {
			Assert.assertTrue(wkfRequest >= history,
					"Value for Notification history must be less than or equal to Workflow Request.");
			Reporter.log("Purge policy not saved-failure",true);
		}Thread.sleep(3000);
	//	informationpage.validateSignOut();
  }
	public void validatePurgePolicyPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(purgingTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", purgingTab);
		//Now validate page title is same as expected
		Thread.sleep(5000);
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
						+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpage.validateSignOut();
	}
	
}
