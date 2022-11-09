package com.ae.qa.pagesTenantAdmin;

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
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class SchedulerPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public CataloguePageTA cataloguepageta=new CataloguePageTA();
	public RequestsPageTA requestpageta=new RequestsPageTA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Scheduler']")
	WebElement schedulerTab;
	@FindBy(xpath = "//a[text()='Tenant Users']")
	WebElement tenantUsersTab;
	@FindBy(xpath = "//button[@name='add-new']")
	WebElement addNewBtn;
	@FindBy(xpath="//div[@class='mul-position']/span")
	WebElement workflowDrpdwn;
	@FindBy(id="scheduleName")
	WebElement scheduleName; 
	@FindBy(id="scheduleDesc")
	WebElement description;
	@FindBy(id="WfExecStartDate")
	WebElement startDate;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement monthDrpdown;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement yearDrpdown;
	@FindBy(xpath="//button[text()='Done']")
	WebElement doneBtn;
	@FindBy(id="wfExecEndDate-datepicker")
	WebElement endDate;
	@FindBy(id="scheduleType")
	WebElement scheduleTypeDrpdown;
	@FindBy(id="timeZone")
	WebElement timeZone;
	@FindBy(id="wfExecStartTime-hours")
	WebElement scheduleHRS;
	@FindBy(id="wfExecStartTime-minutes")
	WebElement scheduleMins; 
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement actual_Msg;
	@FindBy(xpath="//span[text()='Requests']")
	WebElement requestTab;
	//@FindBy(xpath="//div[@class='mul-position']/span[@class='mul-dorpdown-button']")
	@FindBy(xpath="//*[@id='selectedWeekDays']/div/span")
	WebElement weekly_dropdown;
	@FindBy(id="repeatInstruct")
	WebElement repeatCheckbox;
	@FindBy(id="timePeriodValue")
	WebElement repeatHr;
	@FindBy(xpath="//*[@id='timePeriod']")
	WebElement repeatPeriod;
	@FindBy(id="wfExecEndTime-hours")
	WebElement endTimeHR;
	@FindBy(id="wfExecEndTime-minutes")
	WebElement endTimeMin;
	@FindBy(id="wfExecStartTime")
	WebElement startTime;
	@FindBy(xpath="//*[@id='selectedMonth']/div/span")
	WebElement monthly_dropdown;
	@FindBy(xpath="//*[@id='selectedDayofMonth']/div/span")
	WebElement dayOfMonth;
	@FindBy(xpath="//span[@class='mul-checkmark']")
	WebElement day;
	@FindBy(xpath="(//input[@name='search'])[3]")
	WebElement searchBar;
	@FindBy(xpath="//*[@id='wfExecEndTime']")
	WebElement endTime;
	@FindBy(id="isScheduleInfinite")
	WebElement infiniteSchedule;
	@FindBy(id="wfExecStartTime-hours")
	WebElement inf_startHR;
	@FindBy(id="wfExecStartTime-minutes")
	WebElement inf_startMin;
	@FindBy(xpath="//button[text()='Delete']")
	WebElement deletePopupBtn;
	//Fot transfering schedule
	@FindBy(name="dropdown-selector")
	WebElement addDropdown;
	@FindBy(xpath="//a[@name='transfer-schedule']")
	WebElement transferSchedBtn;
	@FindBy(id="sourceUser")
	WebElement owner;
	@FindBy(id="targetUser")
	WebElement transferTo;
	@FindBy(name="submit")
	WebElement transferBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath="//a[text()='Categories']")
	WebElement categoriesTab;
	@FindBy(xpath="(//span[@title='Assign Permissions'])[1]")
	WebElement permissionIcon;
	@FindBy(xpath = "//span[text()='Users']") 
	WebElement usersTab;
	@FindBy(xpath = "(//span[@title='Delete User'])[3]") 
	WebElement userDelete;
	@FindBy(name = "refresh-btn")
	WebElement refershTableBtn;

	public SchedulerPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateDailySchedule(String wfName,String schedulename,String scheduleDescrip,String startMonth,String startYear,String startdate,
			String endMonth,String endYear,String enddate,String scheduleType,String timezone,String Hrs,String Mins) throws Exception {
		// Remaining is how to fetch time and then apply to scheduler
		//(String wfName,String wfdes,String category,String wfPath,String priority,String expTime,String maxTime, String cleanUpHrs,String manExeTime,String tUnit
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		//wait.until(ExpectedConditions.elementToBeClickable(schedulerTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		js.executeScript("arguments[0].click();", addNewBtn);
		Reporter.log("Add new Button clicked",true);
		Thread.sleep(5000);
		Reporter.log("Schedule form details started",true);
		workflowDrpdwn.click();
		WebElement search_wfName=driver.findElement(By.xpath("//label[contains(text(),'"+wfName+"')]/span"));
		search_wfName.click();
		Thread.sleep(3000);
		scheduleName.sendKeys(schedulename);
		Thread.sleep(2000);
		description.sendKeys(scheduleDescrip);
		Thread.sleep(3000);
		startDate.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startdate+"']"));
		start_day_picker.click();
		//Thread.sleep(5000);
		//doneBtn.click();
		Thread.sleep(10000);
		endDate.click();
		Thread.sleep(2000);
		Select end_year_picker=new Select(yearDrpdown);
		end_year_picker.selectByVisibleText(endYear);
		Select end_month_picker=new Select(monthDrpdown);
		end_month_picker.selectByVisibleText(endMonth);
		Thread.sleep(2000);
		WebElement end_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+enddate+"']"));
		end_day_picker.click();
		Thread.sleep(5000);
		//doneBtn.click();
		Select schedule=new Select(scheduleTypeDrpdown);
		schedule.selectByVisibleText(scheduleType);
		Thread.sleep(2000);
		Select timezone_drpdown=new Select(timeZone);
		timezone_drpdown.selectByVisibleText(timezone);
		Thread.sleep(2000);
		scheduleHRS.sendKeys(Hrs);
		Thread.sleep(2000);
		scheduleMins.sendKeys(Mins);
		Thread.sleep(2000);
		submitBtn.click();
		Reporter.log("Schedule submitted",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.createSchedule;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Daily Schedule not created");
		Reporter.log("Daily Schedule created successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateEditDailySchedule(String schedulename,String endMonth,String endYear,String enddate) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		//wait.until(ExpectedConditions.elementToBeClickable(schedulerTab));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		//just change end date to verify if we can edit schedule
		Thread.sleep(2000);
		WebElement editBtn=driver.findElement(By.xpath("//table/tr/td[text()='"+schedulename+"']/../td/span[contains(@id,'edit')]"));
		editBtn.click();
		Thread.sleep(10000);
		endDate.click();
		Thread.sleep(2000);
		Select end_year_picker=new Select(yearDrpdown);
		end_year_picker.selectByVisibleText(endYear);
		Select end_month_picker=new Select(monthDrpdown);
		end_month_picker.selectByVisibleText(endMonth);
		Thread.sleep(2000);
		WebElement end_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+enddate+"']"));
		end_day_picker.click();
		Thread.sleep(5000);
		Reporter.log("End date changed",true);
		submitBtn.click();
		Reporter.log("Submit button clicked",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.editSchedule;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Schedule not edited");
		Reporter.log("Schedule edited successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateWeeklySchedule(String wfName,String schedulename,String scheduleDescrip,String startMonth,String startYear,String startdate,
			String endMonth,String endYear,String enddate,String scheduleType,String timezone,String Hrs,String Mins,String day,
			String RepeatAfter,String RepeatPeriod,String endTimeHour, String endTimeMinute) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		js.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.elementToBeClickable(addNewBtn));
		//js.executeScript("arguments[0].click();", addNewBtn);
		addNewBtn.click();
		Reporter.log("Add new Button clicked",true);
		Thread.sleep(5000);
		Reporter.log("Schedule form details started",true);
		workflowDrpdwn.click();
		WebElement search_wfName=driver.findElement(By.xpath("//label[contains(text(),'"+wfName+"')]/span"));
		search_wfName.click();
		Thread.sleep(3000);
		scheduleName.sendKeys(schedulename);
		Thread.sleep(2000);
		description.sendKeys(scheduleDescrip);
		Thread.sleep(3000);
		startDate.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startdate+"']"));
		start_day_picker.click();
		Reporter.log("Start day selected",true);
		Thread.sleep(10000);
		endDate.click();
		Thread.sleep(2000);
		Select end_year_picker=new Select(yearDrpdown);
		end_year_picker.selectByVisibleText(endYear);
		Select end_month_picker=new Select(monthDrpdown);
		end_month_picker.selectByVisibleText(endMonth);
		Thread.sleep(2000);
		WebElement end_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+enddate+"']"));
		end_day_picker.click();
		Reporter.log("End day selected",true);
		Thread.sleep(5000);
		Select schedule=new Select(scheduleTypeDrpdown);
		schedule.selectByVisibleText(scheduleType);
		Reporter.log("Schedule type selected",true);
		Thread.sleep(3000);
		Select timezone_drpdown=new Select(timeZone);
		timezone_drpdown.selectByVisibleText(timezone);
		Thread.sleep(2000);
		scheduleHRS.sendKeys(Hrs);
		Thread.sleep(2000);
		scheduleMins.sendKeys(Mins);
		Thread.sleep(2000);
		weekly_dropdown.click();
		Thread.sleep(2000);
		WebElement schedule_day=driver.findElement(By.xpath("//label[contains(text(),'"+day+"')]/span"));
		schedule_day.click();
		Thread.sleep(2000);
		weekly_dropdown.click();
		Thread.sleep(5000);
		repeatCheckbox.click();
		Reporter.log("Repeat Every checkbox is selected",true);
		Thread.sleep(2000);
		Select RepeatAfter_drpdown=new Select(repeatHr);
		RepeatAfter_drpdown.selectByValue(RepeatAfter);
		Thread.sleep(2000);
		Select Period_drpdown=new Select(repeatPeriod);
		Period_drpdown.selectByVisibleText(RepeatPeriod);
		Thread.sleep(2000);
		Reporter.log("Repeat time is selcted",true);
		endTimeHR.sendKeys(endTimeHour);
		Thread.sleep(2000);
		endTimeMin.sendKeys(endTimeMinute);
		Thread.sleep(2000);
		Reporter.log("End Time is selected",true);
		submitBtn.click();
		Reporter.log("Schedule submitted",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.createSchedule;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Weekly Schedule not created");
		Reporter.log("Weekly Schedule created successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateEditWeeklySchedule(String schedulename,String day,String RepeatAfter,String RepeatPeriod) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		js.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		Thread.sleep(2000);
		WebElement editBtn=driver.findElement(By.xpath("//table/tr/td[text()='"+schedulename+"']/../td/span[contains(@id,'edit')]"));
		editBtn.click();
		weekly_dropdown.click();
		Thread.sleep(2000);
		WebElement schedule_day=driver.findElement(By.xpath("//label[contains(text(),'"+day+"')]/span"));
		schedule_day.click();
		Thread.sleep(2000);
		weekly_dropdown.click();
		Thread.sleep(2000);
		Select RepeatAfter_drpdown=new Select(repeatHr);
		RepeatAfter_drpdown.selectByValue(RepeatAfter);
		Thread.sleep(2000);
		Select Period_drpdown=new Select(repeatPeriod);
		Period_drpdown.selectByVisibleText(RepeatPeriod);
		Thread.sleep(2000);
		Reporter.log("Repeat time is selcted",true);
		submitBtn.click();
		Reporter.log("Submit button clicked",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.editSchedule;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Schedule not edited");
		Reporter.log("Schedule edited successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateMonthlySchedule(String wfName,String schedulename,String scheduleDescrip,String startMonth,String startYear,String startdate,
			String endMonth,String endYear,String enddate,String scheduleType,String timezone,String StartTime,String ScheduleMonth,
			String Day,String RepeatAfter, String RepeatPeriod,String EndTime) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		//wait.until(ExpectedConditions.elementToBeClickable(schedulerTab));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addNewBtn);
		Reporter.log("Add new Button clicked",true);
		Thread.sleep(5000);
		Reporter.log("Schedule form details started",true);
		workflowDrpdwn.click();
		WebElement search_wfName=driver.findElement(By.xpath("//label[contains(text(),'"+wfName+"')]/span"));
		search_wfName.click();
		Thread.sleep(3000);
		scheduleName.sendKeys(schedulename);
		Thread.sleep(2000);
		description.sendKeys(scheduleDescrip);
		Thread.sleep(3000);
		startDate.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startdate+"']"));
		start_day_picker.click();
		Thread.sleep(10000);
		endDate.click();
		Thread.sleep(2000);
		Select end_year_picker=new Select(yearDrpdown);
		end_year_picker.selectByVisibleText(endYear);
		Select end_month_picker=new Select(monthDrpdown);
		end_month_picker.selectByVisibleText(endMonth);
		Thread.sleep(2000);
		WebElement end_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+enddate+"']"));
		end_day_picker.click();
		Thread.sleep(5000);
		Select schedule=new Select(scheduleTypeDrpdown);
		schedule.selectByVisibleText(scheduleType);
		Thread.sleep(2000);
		Select timezone_drpdown=new Select(timeZone);
		timezone_drpdown.selectByVisibleText(timezone);
		Thread.sleep(2000);
		Select StartTime_dropdown=new Select(startTime);
		StartTime_dropdown.selectByValue(StartTime);
		Thread.sleep(2000);
		monthly_dropdown.click();
		Thread.sleep(2000);
		WebElement schedule_month=driver.findElement(By.xpath("//label[contains(text(),'"+ScheduleMonth+"')]/span"));
		schedule_month.click();
		Thread.sleep(2000);
		monthly_dropdown.click();
		Thread.sleep(2000);
		dayOfMonth.click();
		Thread.sleep(2000);
		WebElement day= driver.findElement(By.xpath("(//div[@class='mul-options-list'])[3]/li["+Day+"]/label/span"));
		day.click();
		Thread.sleep(2000);
		repeatCheckbox.click();
		Reporter.log("Repeat Every checkbox is selected",true);
		Thread.sleep(2000);
		Select RepeatAfter_drpdown=new Select(repeatHr);
		RepeatAfter_drpdown.selectByValue(RepeatAfter);
		Thread.sleep(2000);
		Select Period_drpdown=new Select(repeatPeriod);
		Period_drpdown.selectByValue(RepeatPeriod);
		Thread.sleep(2000);
		Reporter.log("Repeat time is selcted",true);
		Select endTime_monthly=new Select(endTime);
		endTime_monthly.selectByValue(EndTime);
		Thread.sleep(2000);
		Reporter.log("End Time is selected",true);
		submitBtn.click();
		Reporter.log("Schedule submitted",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.createSchedule;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Weekly Schedule not created");
		Reporter.log("Weekly Schedule created successfully",true);
		informationpageta.validateSignOut();	
	}
	public void validateEditMonthlySchedule(String schedulename,String StartTime,String ScheduleMonth) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		js.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		Thread.sleep(2000);
		WebElement editBtn=driver.findElement(By.xpath("//table/tr/td[text()='"+schedulename+"']/../td/span[contains(@id,'edit')]"));
		editBtn.click();
		Select StartTime_dropdown=new Select(startTime);
		StartTime_dropdown.selectByValue(StartTime);
		Thread.sleep(2000);
		monthly_dropdown.click();
		Thread.sleep(2000);
		WebElement schedule_month=driver.findElement(By.xpath("//label[contains(text(),'"+ScheduleMonth+"')]/span"));
		schedule_month.click();
		Thread.sleep(2000);
		monthly_dropdown.click();
		submitBtn.click();
		Reporter.log("Submit button clicked",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.editSchedule;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Schedule not edited");
		Reporter.log("Schedule edited successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateInfineSchedule(String wfName,String schedulename,String scheduleDescrip,String startMonth,String startYear,String startdate,
			String scheduleType,String timezone,String ExecHR,String ExecMin,String day,String RepeatAfter,String RepeatPeriod,
			String endTimeHour, String endTimeMinute) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		//wait.until(ExpectedConditions.elementToBeClickable(schedulerTab));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addNewBtn);
		Reporter.log("Add new Button clicked",true);
		Thread.sleep(5000);
		Reporter.log("Schedule form details started",true);
		workflowDrpdwn.click();
		WebElement search_wfName=driver.findElement(By.xpath("//label[contains(text(),'"+wfName+"')]/span"));
		search_wfName.click();
		Thread.sleep(3000);
		scheduleName.sendKeys(schedulename);
		Thread.sleep(2000);
		description.sendKeys(scheduleDescrip);
		Thread.sleep(3000);
		infiniteSchedule.click();
		Reporter.log("Run Schedule Infinitely checbox selected",true);
		Thread.sleep(2000);
		startDate.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startdate+"']"));
		start_day_picker.click();
		Thread.sleep(10000);
		Select schedule=new Select(scheduleTypeDrpdown);
		schedule.selectByVisibleText(scheduleType);
		Thread.sleep(2000);
		Select timezone_drpdown=new Select(timeZone);
		timezone_drpdown.selectByVisibleText(timezone);
		Thread.sleep(2000);
		inf_startHR.sendKeys(ExecHR);
		Thread.sleep(2000);
		inf_startMin.sendKeys(ExecMin);
		weekly_dropdown.click();
		Thread.sleep(2000);
		WebElement schedule_day=driver.findElement(By.xpath("//label[contains(text(),'"+day+"')]/span"));
		schedule_day.click();
		Thread.sleep(2000);
		weekly_dropdown.click();
		Thread.sleep(2000);
		repeatCheckbox.click();
		Reporter.log("Repeat Every checkbox is selected",true);
		Thread.sleep(2000);
		Select RepeatAfter_drpdown=new Select(repeatHr);
		RepeatAfter_drpdown.selectByValue(RepeatAfter);
		Thread.sleep(2000);
		Select Period_drpdown=new Select(repeatPeriod);
		Period_drpdown.selectByVisibleText(RepeatPeriod);
		Thread.sleep(2000);
		Reporter.log("Repeat time is selcted",true);
		endTimeHR.sendKeys(endTimeHour);
		Thread.sleep(2000);
		endTimeMin.sendKeys(endTimeMinute);
		Thread.sleep(2000);
		submitBtn.click();
		Reporter.log("Schedule submitted",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.createSchedule;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Weekly Infinite Schedule not created");
		Reporter.log("Infinite Weekly Schedule created successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateEditInfineSchedule(String schedulename,String scheduleType,String ScheduleMonth,String Day) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		js.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		Thread.sleep(2000);
		WebElement editBtn=driver.findElement(By.xpath("//table/tr/td[text()='"+schedulename+"']/../td/span[contains(@id,'edit')]"));
		editBtn.click();
		Select schedule=new Select(scheduleTypeDrpdown);
		schedule.selectByVisibleText(scheduleType);
		Thread.sleep(2000);
		monthly_dropdown.click();
		Thread.sleep(2000);
		WebElement schedule_month=driver.findElement(By.xpath("//label[contains(text(),'"+ScheduleMonth+"')]/span"));
		schedule_month.click();
		Thread.sleep(2000);
		monthly_dropdown.click();
		Thread.sleep(2000);
		dayOfMonth.click();
		Thread.sleep(2000);
		WebElement day= driver.findElement(By.xpath("(//div[@class='mul-options-list'])[3]/li["+Day+"]/label/span"));
		day.click();
		Thread.sleep(2000);
		if(repeatCheckbox.isSelected()){
			repeatCheckbox.click();
			Reporter.log("Repeat Every checkbox is unselected",true);
		}
		submitBtn.click();
		Reporter.log("Submit button clicked",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.editSchedule;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Schedule not edited");
		Reporter.log("Schedule edited successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateDeleteSchedule(String schedulename,String scheduleDescrip) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		wait.until(ExpectedConditions.elementToBeClickable(schedulerTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		Thread.sleep(2000);
		WebElement slideBar=driver.findElement(By.xpath("//table/tr/td[text()='"+schedulename+"']/../td/label"));
		slideBar.click();
		Reporter.log("Schedule got disable",true);
		Thread.sleep(3000);
		WebElement deleteBtn=driver.findElement(By.xpath("//table/tr/td[text()='"+schedulename+"']/../td/span[@title='Delete']"));
		deleteBtn.click();
		Reporter.log("Delete schedule button clicked",true);
		Thread.sleep(3000);
		deletePopupBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = scheduleDescrip+" deleted successfully";
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Schedule not deleted");
		Reporter.log("Schedule deleted successfully",true);
		informationpageta.validateSignOut();
	}

	public void validateTransferSchedule(String ownerName,String TransferToName,String scheduleName) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		//wait.until(ExpectedConditions.elementToBeClickable(schedulerTab));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", schedulerTab);
		Reporter.log("Scheduler tab clicked",true);
		Thread.sleep(2000);
		addDropdown.click();
		Thread.sleep(2000);
		transferSchedBtn.click();
		Reporter.log("Add Transfer Schedule button is clicked",true);
		Select selectOwner=new Select(owner);
		selectOwner.selectByVisibleText(ownerName);
		Reporter.log("User from whom schedule needs to transfer is selcted",true);
		Select TransferTo = new Select(transferTo);
		TransferTo.selectByVisibleText(TransferToName);
		Reporter.log("User to whom schedule needs to is selcted",true);
		Thread.sleep(3000);
		WebElement selectSchedule=driver.findElement(By.xpath("//label[starts-with(text(),'"+scheduleName+"')]"));
		selectSchedule.click();
		Thread.sleep(3000);
		transferBtn.click();
		Reporter.log("Transfer button clicked",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.transferSchedule;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "Schedule not transfered");
		Reporter.log("Schedule transfered successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateDeleteUserScheduleTransfer(String PageSize,String UserName) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", tenantUsersTab);
		wb.changePageSize(PageSize);
		WebElement deleteBtn=driver.findElement(By.xpath("//table/tr/td/div[@title='"+UserName+"']/../../td/span[@title='Delete User']"));
		deleteBtn.click();
		deletePopupBtn.click();
		String actual_message = actual_Msg.getText();
		String expected_message = Messages.deleteScheduleCreatedUser;
		Reporter.log("Actual Success Msg:" + actual_message,true);
		Reporter.log("Expected Success Msg:" + expected_message,true);
		Assert.assertEquals(actual_message,expected_message, "User delete successfully");
		Reporter.log("User is not deleted successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateSchedulerPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		js.executeScript("arguments[0].click();", schedulerTab);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}
	public void validateAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
		js_tenant.executeScript("arguments[0].click();", schedulerTab);
		wb.validateClickOnAdvanceSearch();
	}

	public void validateAdvSearchForScheduleNameEqualTo(String SearchColumn,String SearchCriteria,
			String scheduleName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,scheduleName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Schedule record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_ScheduleName=op.get(i).getText();
			System.out.println("actual_Schedule Name present in table are: "+actual_ScheduleName);
			Thread.sleep(2000);
			Assert.assertTrue(actual_ScheduleName.contentEquals(scheduleName));
		}
	}
	public void validateAdvSearchForScheduleNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String scheduleName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, scheduleName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Schedule record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_ScheduleName=op.get(i).getText();
			System.out.println("actual_Schedule Name present in table are: "+actual_ScheduleName);
			Assert.assertFalse(actual_ScheduleName.equals(scheduleName));
		}
	}
	public void validateAdvSearchForScheduleNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Schedule record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_ScheduleName=op.get(i).getText();
			System.out.println("actual_Schedule Name present in table are: "+actual_ScheduleName);
			Assert.assertTrue(actual_ScheduleName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForScheduleNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Schedule record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_ScheduleName=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Schedule Name present in table are: "+actual_ScheduleName);
			Thread.sleep(3000);
			Assert.assertTrue(actual_ScheduleName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForScheduleNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Schedule record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_ScheduleName=op.get(i).getText();
			System.out.println("actual_Schedule Name present in table are: "+actual_ScheduleName);
			Assert.assertTrue(actual_ScheduleName.contains(advSearchFor));
		}
	}
	public void validateStatusDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[7]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Status=op.get(i).getText();
			System.out.println("actual_Status present in table are: "+actual_Status);
			Thread.sleep(2000);
			Assert.assertTrue(actual_Status.equalsIgnoreCase(searchValue));
		}
	}
	public void validateStatusDropdownNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[7]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Status=op.get(i).getText();
			System.out.println("actual_Status present in table are: "+actual_Status);
			Thread.sleep(2000);
			Assert.assertFalse(actual_Status.equalsIgnoreCase(searchValue));
		}
	}

}

