package com.ae.qa.pages;



import java.util.List;
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
import com.ae.qa.util.Messages;

public class PurgeSchedulePage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 120);
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage=new InformationPage();
	public WebElements webelements = new WebElements();

	@FindBy(xpath = "//span[(text()='Purging')]")
	WebElement purgingTab;
	@FindBy(xpath="//button[@id='btnAssisted']")
	WebElement purgeScheduleTab;
	@FindBy(name = "add-new")
	//List <WebElement> addBtn;
	WebElement addBtn;
	@FindBy(id = "criteria")
	WebElement criteria;
	@FindBy(id = "dayOfMonth")
	WebElement dayOfMonth;
	@FindBy(id = "hour")
	WebElement Hour;
	@FindBy(id = "minutes")
	WebElement Minutes;
	@FindBy(id = "dayOfWeek")
	WebElement dayOfWeek;
	@FindBy(id = "weekdayOfMonth")
	WebElement weekdayOfMonth;
	@FindBy(xpath = "//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath="//button/span[@class='fa fa-trash']")
	List <WebElement> deleteBtn;
	@FindBy(id="popup-button-ok")
	WebElement deletePopup;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement success_Message;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath="//button[@id='btnAssisted']")
	WebElement scheduleBtn;

	public PurgeSchedulePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validatePurgingScheduleDay(String dayCriteria, String day, String hr, String min) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Purging Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(purgingTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", purgingTab);
		Thread.sleep(3000);
		// click on purge schedule tab
		wait.until(ExpectedConditions.visibilityOf(purgeScheduleTab));
		js.executeScript("arguments[0].click();", purgeScheduleTab);
		Thread.sleep(3000);
		addBtn.click();
		Reporter.log("Add button clicked",true);
		Select criteria_dropdwn = new Select(criteria);
		criteria_dropdwn.selectByVisibleText(dayCriteria);
		Thread.sleep(2000);
		int dayofmonth=Integer.valueOf(day);
		dayOfMonth.sendKeys("" + dayofmonth);
		Thread.sleep(2000);
		Select Hour_dropdwn = new Select(Hour);
		Hour_dropdwn.selectByValue(hr);
		Select Minutes_dropdwn = new Select(Minutes);
		Minutes_dropdwn.selectByValue(min);
		Thread.sleep(10000);
		if (dayofmonth <= 28) {
			js.executeScript("arguments[0].click();", saveBtn);
			String Actual_SuccessMsg = success_Message.getText();
			System.out.println(
					"Actual success message after setting purging schedule for day of Month:" + Actual_SuccessMsg);
			String Expected_SuccessMsg = Messages.purgingScheduleDay;
			System.out.println(
					"Expected success message after setting purging schedule for day of Month:" + Expected_SuccessMsg);
			Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Schedule not created for day of Month");
			Reporter.log("Schedule created for day of Month",true);
		} else {
			Assert.assertTrue(dayofmonth <= 28, "Day of the Month Value should be less than or equal to 28.");
			Reporter.log("Day of the Month Value should be less than or equal to 28.",true);
		}
		if(deleteBtn.size()>0) {
			System.out.println("Lets delete");
			deleteBtn.get(0).click();
		Thread.sleep(3000);
		deletePopup.click();
		informationpage.validateSignOut();
	}
	}

	public void validatePurgingScheduleWeekend(String dayCriteria, String day, String wkday, String hr, String min)
			throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click PurgingTab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(purgingTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", purgingTab);
		Thread.sleep(3000);
		// click on purge schedule tab
		//wait.until(ExpectedConditions.visibilityOf(purgeScheduleTab));
		js.executeScript("arguments[0].click();", purgeScheduleTab);
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.visibilityOf(addBtn));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", addBtn);
		Thread.sleep(2000);
		Select criteria_dropdwn = new Select(criteria);
		criteria_dropdwn.selectByVisibleText(dayCriteria);
		Thread.sleep(2000);
		// day of week
		Select dayOfWeek_dropdwn = new Select(dayOfWeek);
		dayOfWeek_dropdwn.selectByVisibleText(day);
		Thread.sleep(2000);
		// weekdayOfMonth
		Select weekdayOfMonth_dropdwn = new Select(weekdayOfMonth);
		weekdayOfMonth_dropdwn.selectByVisibleText(wkday);
		Thread.sleep(2000);
		// Start Time
		Select Hour_dropdwn = new Select(Hour);
		Hour_dropdwn.selectByValue(hr);
		Select Minutes_dropdwn = new Select(Minutes);
		Minutes_dropdwn.selectByValue(min);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", saveBtn);
		String Actual_SuccessMsg = success_Message.getText();
		System.out
				.println("Actual success message after setting purging schedule for day of week:" + Actual_SuccessMsg);
		String Expected_SuccessMsg = Messages.purgingScheduleDay;
		System.out.println(
				"Expected success message after setting purging schedule for day of week:" + Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Schedule not created for day of week");
		Reporter.log("Schedule created for day of week",true);
		informationpage.validateSignOut();
	}
	public void validatePurgeSchedulePage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(purgingTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", purgingTab);
		Thread.sleep(3000);
		// click on purge schedule tab
		wait.until(ExpectedConditions.visibilityOf(purgeScheduleTab));
		js.executeScript("arguments[0].click();", purgeScheduleTab);
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
