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

public class EmailReportsPageTA extends TestBase{
	public LoginPageTA loginpage = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 300);
	public InformationPageTA informationpageta=new InformationPageTA();

	@FindBy(xpath="//span[text()='Reports']")
	WebElement reportsTab;
	@FindBy(xpath="//a[text()='Email Reports']")
	WebElement emailReportsTab;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath="//button[@name='add-new']")
	WebElement addBtn;
	@FindBy(id="name")
	WebElement scheduleName;
	@FindBy(id="type")
	WebElement scheduleType;
	@FindBy(id="startTime-hours")
	WebElement startTimeHour;
	@FindBy(id="startTime-minutes")
	WebElement startTimeMinutes;
	@FindBy(id="endDate-datepicker")
	WebElement endDate;
	@FindBy(xpath="(//fieldset/legend/span)[2]")
	WebElement reportSelection;
	@FindBy(id="duration")
	WebElement duration;
	@FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement reportTemplate;
	@FindBy(xpath="//input[@name='search']")
	WebElement searchBar;
	@FindBy(id="reportType")
	WebElement reportType;
	@FindBy(xpath="(//fieldset/legend/span)[3]")
	WebElement notificationSettings;
	@FindBy(id="ROLE_WORKFLOW_ADMIN")
	WebElement workflowAdminRole;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement monthDrpdown;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement yearDrpdown;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn;
	@FindBy(id="dayOfWeek")
	WebElement dayOfWeek;
	@FindBy(id="criteria")
	WebElement criteria;
	@FindBy(id="weekDayOfMonth")
	WebElement purgingWeekdayMonth;

	public EmailReportsPageTA()
	{
		PageFactory.initElements(driver, this);
	}
	public void validateEmailReportsDaily(String ScheduleName,String ScheduleType,String StartHours,String StartMinutes,String StartYear,String StartMonth,String StartDate,String DurationType,
			String ReportTemplateType,String ReportType) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(reportsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		js.executeScript("arguments[0].click();",emailReportsTab);
		addBtn.click();
		Thread.sleep(2000);
		scheduleName.sendKeys(ScheduleName);
		Thread.sleep(2000);
		Select type_drpdown = new Select(scheduleType);
		type_drpdown.selectByVisibleText(ScheduleType);
		Thread.sleep(2000);
		startTimeHour.sendKeys(StartHours);
		startTimeMinutes.sendKeys(StartMinutes);
		endDate.click();
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(StartYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(StartMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+StartDate+"']"));
		start_day_picker.click();
		Thread.sleep(2000);
		reportSelection.click();
		Thread.sleep(2000);
		Select duration_drpdown = new Select(duration);
		duration_drpdown.selectByVisibleText(DurationType);
		Thread.sleep(2000);
		reportTemplate.click();
		searchBar.sendKeys(ReportTemplateType);
		WebElement checkbox=driver.findElement(By.xpath("//span[@class='mul-checkmark']"));
		checkbox.click();
		Thread.sleep(2000);
		Select report_drpdown = new Select(reportType);
		report_drpdown.selectByVisibleText(ReportType);
		Thread.sleep(2000);
		notificationSettings.click();
		workflowAdminRole.click();
		Thread.sleep(2000);
		if(workflowAdminRole.isSelected()) {
			System.out.println("Roles are been Selected");
		}else {
			System.out.println("Please select users for email notification");
		}
		saveBtn.click();
		Thread.sleep(5000);
		for (int i = 0; i <= 2; i++) {
			String actual_ScheduleName = driver.findElement(By.xpath("//table/tr/td[@title='" + ScheduleName + "']")).getText();
			String expected_ScheduleName = ScheduleName;
			System.out.println("Actual Schedule Name:" + actual_ScheduleName);
			System.out.println("Expected Schedule Name:" + expected_ScheduleName);
			Assert.assertEquals(actual_ScheduleName, expected_ScheduleName, "Schedule Name not added in list");
			Reporter.log("Schedule Name is verified and present in the webtable",true);
			break;
		}
		informationpageta.validateSignOut();
	}
	public void validateEmailReportsWeekly(String ScheduleName,String ScheduleType,String DayOfWeek,String StartHours,String StartMinutes,String StartYear,String StartMonth,String StartDate,String DurationType,
			String ReportTemplateType,String ReportType) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(reportsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		js.executeScript("arguments[0].click();",emailReportsTab);
		addBtn.click();
		Thread.sleep(2000);
		scheduleName.sendKeys(ScheduleName);
		Thread.sleep(2000);
		Select type_drpdown = new Select(scheduleType);
		type_drpdown.selectByVisibleText(ScheduleType);
		Thread.sleep(2000);
		Select dayOfWeek_drpdown = new Select(dayOfWeek);
		dayOfWeek_drpdown.selectByVisibleText(DayOfWeek);
		Thread.sleep(2000);
		startTimeHour.sendKeys(StartHours);
		startTimeMinutes.sendKeys(StartMinutes);
		endDate.click();
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(StartYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(StartMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+StartDate+"']"));
		start_day_picker.click();
		Thread.sleep(2000);
		reportSelection.click();
		Thread.sleep(2000);
		Select duration_drpdown = new Select(duration);
		duration_drpdown.selectByVisibleText(DurationType);
		Thread.sleep(2000);
		reportTemplate.click();
		searchBar.sendKeys(ReportTemplateType);
		WebElement checkbox=driver.findElement(By.xpath("//span[@class='mul-checkmark']"));
		checkbox.click();
		Thread.sleep(2000);
		Select report_drpdown = new Select(reportType);
		report_drpdown.selectByVisibleText(ReportType);
		Thread.sleep(2000);
		notificationSettings.click();
		workflowAdminRole.click();
		Thread.sleep(2000);
		if(workflowAdminRole.isSelected()) {
			System.out.println("Roles are been Selected");
		}else {
			System.out.println("Please select users for email notification");
		}
		saveBtn.click();
		Thread.sleep(5000);
		for (int i = 0; i <= 2; i++) {
			String actual_ScheduleName = driver.findElement(By.xpath("//table/tr/td[@title='" + ScheduleName + "']")).getText();
			String expected_ScheduleName = ScheduleName;
			System.out.println("Actual Schedule Name:" + actual_ScheduleName);
			System.out.println("Expected Schedule Name:" + expected_ScheduleName);
			Assert.assertEquals(actual_ScheduleName, expected_ScheduleName, "Schedule Name not added in list");
			Reporter.log("Schedule Name is verified and present in the webtable",true);
			break;
		}
		informationpageta.validateSignOut();
	}
	public void validateEmailReportsMonthly(String ScheduleName,String ScheduleType,String CriteriaType,String DayOfWeek,String PurgingWeekMonth,String StartHours,String StartMinutes,String StartYear,String StartMonth,String StartDate,String DurationType,
			String ReportTemplateType,String ReportType) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(reportsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		js.executeScript("arguments[0].click();",emailReportsTab);
		addBtn.click();
		Thread.sleep(2000);
		scheduleName.sendKeys(ScheduleName);
		Thread.sleep(2000);
		Select type_drpdown = new Select(scheduleType);
		type_drpdown.selectByVisibleText(ScheduleType);
		Thread.sleep(2000);
		Select criteria_picker=new Select(criteria);
		criteria_picker.selectByVisibleText(CriteriaType);
		Thread.sleep(2000);
		Select dayOfWeek_drpdown = new Select(dayOfWeek);
		dayOfWeek_drpdown.selectByVisibleText(DayOfWeek);
		Thread.sleep(2000);
		Select purging_Month = new Select(purgingWeekdayMonth);
		purging_Month.selectByVisibleText(PurgingWeekMonth);
		Thread.sleep(2000);
		startTimeHour.sendKeys(StartHours);
		startTimeMinutes.sendKeys(StartMinutes);
		endDate.click();
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(StartYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(StartMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+StartDate+"']"));
		start_day_picker.click();
		Thread.sleep(2000);
		reportSelection.click();
		Thread.sleep(2000);
		Select duration_drpdown = new Select(duration);
		duration_drpdown.selectByVisibleText(DurationType);
		Thread.sleep(2000);
		reportTemplate.click();
		searchBar.sendKeys(ReportTemplateType);
		WebElement checkbox=driver.findElement(By.xpath("//span[@class='mul-checkmark']"));
		checkbox.click();
		Thread.sleep(2000);
		Select report_drpdown = new Select(reportType);
		report_drpdown.selectByVisibleText(ReportType);
		Thread.sleep(2000);
		notificationSettings.click();
		workflowAdminRole.click();
		Thread.sleep(2000);
		if(workflowAdminRole.isSelected()) {
			System.out.println("Roles are been Selected");
		}else {
			System.out.println("Please select users for email notification");
		}
		saveBtn.click();
		Thread.sleep(5000);
		for (int i = 0; i <= 2; i++) {
			String actual_ScheduleName = driver.findElement(By.xpath("//table/tr/td[@title='" + ScheduleName + "']")).getText();
			String expected_ScheduleName = ScheduleName;
			System.out.println("Actual Schedule Name:" + actual_ScheduleName);
			System.out.println("Expected Schedule Name:" + expected_ScheduleName);
			Assert.assertEquals(actual_ScheduleName, expected_ScheduleName, "Schedule Name not added in list");
			Reporter.log("Schedule Name is verified and present in the webtable",true);
			break;
		}
		informationpageta.validateSignOut();
	}
	public void validateEmailReportsPageTA(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(reportsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		js.executeScript("arguments[0].click();",emailReportsTab);
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
