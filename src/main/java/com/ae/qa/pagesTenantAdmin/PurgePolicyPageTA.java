package com.ae.qa.pagesTenantAdmin;

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
import com.ae.qa.pages.InformationPage;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.Messages;

public class PurgePolicyPageTA extends TestBase {
		public WebDriverWait wait = new WebDriverWait(driver, 120);
		public LoginPageTA loginpageta = new LoginPageTA();
		public InformationPageTA informationpageta=new InformationPageTA();
		public WebElements webelements = new WebElements();

		@FindBy(xpath = "//span[(text()='Purging')]")
		WebElement purgingTab;
		@FindBy(xpath="//a[text()='Purge Policy']")
		WebElement purgePolicyTab;
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

		public PurgePolicyPageTA() {
			PageFactory.initElements(driver, this);
		}
		public void validateUpdationPurgePolicyDurationTA(String wfRequests, String auditLogs, String notHistory) throws Exception {
			loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
			Reporter.log("User log in Successfully",true);
			// click Purging Tab
			//wait.until(ExpectedConditions.visibilityOf(purgingTab));
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", purgingTab);
			Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(editBtn));
			Thread.sleep(3000);
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
				Thread.sleep(5000);
				js.executeScript("arguments[0].click();", saveBtn);
				String Actual_SuccessMsg = alert_Message.getText();
				Reporter.log("Actual success message after setting purging policy:" + Actual_SuccessMsg,true);
				String Expected_SuccessMsg = Messages.purgePolicyDuration;
				Reporter.log("Expected success message after setting purging policy:" + Expected_SuccessMsg,true);
				Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Purge policy not UPDATED successfully");
				Reporter.log("Purge policy UPDATED successfully",true);
			} else {
				Assert.assertTrue(wkfRequest >= history,
						"Value for Notification history must be less than or equal to Workflow Request.");
				Reporter.log("Purge policy not saved-failure",true);
			}
			Thread.sleep(3000);
			informationpageta.validateSignOut();
	  }
		public void validatePurgePolicyPageTA(String PageTitle) throws Exception {
			loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
			Reporter.log("User log in Successfully",true);
			//First search for tab and click on it
			//wait.until(ExpectedConditions.visibilityOf(purgingTab));
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",purgingTab);
			js.executeScript("arguments[0].click();",purgePolicyTab);
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
