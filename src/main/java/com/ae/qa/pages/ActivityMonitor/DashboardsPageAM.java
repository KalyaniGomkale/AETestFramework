package com.ae.qa.pages.ActivityMonitor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.Messages;

public class DashboardsPageAM extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 120);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();

	@FindBy(xpath = "//span[contains(text(),'Reports')]")
	@CacheLookup
	WebElement reportsTab;
	/*	@FindBy(xpath="//a[text()='Agent Logs']")
	WebElement agentLogsTab;*/
	@FindBy(xpath="//a[text()='Dashboards']")
	WebElement dashboardsTab;
	@FindBy(xpath = "//button[@name='add-new']")
	WebElement newDashboardBtn;
	@FindBy(xpath = "//input[@name='title']")
	WebElement title;
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement description;
	@FindBy(xpath= "//input[@name='showDescription']")
	WebElement showDescpCheckbox;
	@FindBy(id = "timeUnit")
	WebElement dashboardTimeUnit;
	@FindBy(id="refreshIntervalMinutes")
	WebElement refreshEvery;
	@FindBy(xpath="//div/input[@id='useGlobalDuration']")
	WebElement dashboardLevel;
	@FindBy(xpath="//select[@name='durationType']")
	WebElement duration;
	@FindBy(xpath="//button[text()='Create']")
	WebElement createBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="(//select[@name='dashboard-select'])[1]")
	WebElement chooseDashboard;
	@FindBy(xpath="//button[@name='dropdown-selector']")
	WebElement newDashboardDropdown;
	@FindBy(xpath="//span[text()='Add Report']")
	WebElement addReportOption;
	@FindBy(xpath="//*[@id='reportTemplate']")
	WebElement reportTypedrpdown;
	@FindBy(xpath="//input[@value='workflow']")
	WebElement generateOnWF;
	@FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement selectWFs;
	@FindBy(xpath="//input[@name='search']")
	WebElement searchBar;
	@FindBy(xpath="//*[@id='options-list']/li/label/span")
	WebElement wfCheckbox;
	@FindBy(id="rowCount")
	WebElement pageSize;
	@FindBy(xpath="//button[@name='submit-report']")
	WebElement generateBtn;
	@FindBy(xpath="//button[@id='drop-caret']")
	WebElement AddAs;
	@FindBy(xpath="//a[@id='add-table']")
	WebElement addAsTable;
	@FindBy(xpath="//input[@id='title']")
	WebElement changeReportTitle;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn;
	@FindBy(xpath="//div[@class='report-card-grid']/div/p[1]")
	WebElement savedReportTitle;
	@FindBy(xpath="//span[text()='Edit Dashboard']")
	WebElement editReport;
	@FindBy(id="startDate-datepicker")
	WebElement startDate;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement monthDrpdown;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement yearDrpdown;
	@FindBy(id="endDate-datepicker")
	WebElement endDate;
	@FindBy(xpath="//button[text()='Update']")
	WebElement updateBtn;
	@FindBy(id="range")
	WebElement last;
	@FindBy(id="rangeType")
	WebElement rangeType;
	@FindBy(xpath="//span[text()='Set As Default']")
	WebElement setAsDefault;
	@FindBy(id="startHour-hours")
	WebElement startHR;
	@FindBy(id="startHour-minutes")
	WebElement startMin;
	@FindBy(id="endHour-hours")
	WebElement endHR;
	@FindBy(id="endHour-minutes")
	WebElement endMin;
	@FindBy(xpath="//a[@id='add-chart']")
	WebElement addAsChart;
	@FindBy(xpath="//span[text()='Delete Dashboard']")
	WebElement deleteDashboard;
	@FindBy(xpath="//button[text()='Delete']")
	WebElement deletePopup;

	public DashboardsPageAM() {
		PageFactory.initElements(driver, this);
	}

	public void createNewDashboardAM(String dashboardTitle,String dashboardDescp,String timeUnit,String refreshTime,String 
			dashboardDuration) throws Exception{
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(reportsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		Reporter.log("Reports Tab is clicked", true);
		newDashboardBtn.click();
		Reporter.log("New Dashboard button is clicked",true);
		title.sendKeys(dashboardTitle);
		Thread.sleep(3000);
		description.sendKeys(dashboardDescp);
		Thread.sleep(3000);
		showDescpCheckbox.click();
		Thread.sleep(3000);
		Select dashboardTimeUnit_drpdown=new Select(dashboardTimeUnit);
		dashboardTimeUnit_drpdown.selectByVisibleText(timeUnit);
		Thread.sleep(3000);
		refreshEvery.sendKeys(refreshTime);
		Thread.sleep(3000);
		if(!dashboardLevel.isSelected()) {
			dashboardLevel.click();
		}
		else {
			Reporter.log("Dashboard level is already selcted",true);
		}
		Thread.sleep(3000);
		Select duration_drpdown=new Select(duration);
		duration_drpdown.selectByVisibleText(dashboardDuration);
		Reporter.log("Dashboard duration "+dashboardDuration+" selected",true);
	}
	public void validateDashboardNoneAM(String dashboardTitle,String dashboardDescp,String timeUnit,String refreshTime,String 
			dashboardDuration) throws Exception{
		createNewDashboardAM(dashboardTitle,dashboardDescp,timeUnit,refreshTime,dashboardDuration);
		Thread.sleep(3000);
		createBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message1 = alertMessage.getText();
		String expected_message1 = Messages.dashboardCreation;
		Reporter.log("Actual Success Msg:" + actual_message1,true);
		Reporter.log("Expected Success Msg:" + expected_message1,true);
		Assert.assertEquals(actual_message1,expected_message1, "Dashboard not created");
		Reporter.log("Dashboard at None level created successfully",true);
		informationpageta.validateSignOut();
	}
	public void makeReportUsingWFAM(String dashboardTitle,String reportTypeValue,String wfName1) throws Exception{
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(reportsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		Reporter.log("Reports Tab is clicked", true);
		Thread.sleep(4000);
		Select chooseDashboard_dropdown=new Select(chooseDashboard);
		chooseDashboard_dropdown.selectByVisibleText(dashboardTitle);
		Reporter.log("Dashboard chosed successfully",true);
		Thread.sleep(4000);
		newDashboardDropdown.click();
		Thread.sleep(4000);
		addReportOption.click();
		Reporter.log("Add report is clicked",true);
		Thread.sleep(8000);
		Select reportType_dropdown=new Select(reportTypedrpdown);
		reportType_dropdown.selectByValue(reportTypeValue);//Workflow Execution Summary 
		Reporter.log("Report Type selected successfully",true);
		if(generateOnWF.isSelected()) {
			Reporter.log("Generate on Worklfows radio button already selected",true);
		} else {
			generateOnWF.click();
			Reporter.log("Generate on Worklfows radio button not selected by default so selected now",true);
		}
		Thread.sleep(4000);
		selectWFs.click();
		Thread.sleep(4000);
		searchBar.sendKeys(wfName1);
		Thread.sleep(5000);
		wfCheckbox.click();
		Reporter.log("one workflow is selected",true);	
	}
	public void createdReportValidationAM(String NewReportTitle) throws InterruptedException{
		for(int i=0;i<60;i++) {
			changeReportTitle.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		changeReportTitle.sendKeys(NewReportTitle);
		Thread.sleep(2000);
		saveBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Actual_savedReport=alertMessage.getText();
		String Expected_savedReport=Messages.reportAddition;
		Assert.assertEquals(Actual_savedReport,Expected_savedReport,"Report created successfully");
		Reporter.log("Report saved on screen",true);
		//validation of name
		Thread.sleep(3000);
		String Actual_reportName=savedReportTitle.getText();
		String Expected_reportName=NewReportTitle;
		Assert.assertEquals(Actual_reportName,Expected_reportName,"Report doesn't displayed on screen successfully");
		Reporter.log("Report " +NewReportTitle+" displayed on screen successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateReportNoneMultipleWFAM(String dashboardTitle,String reportTypeValue,String wfName1,String wfName2,String PageSize,
			String NewReportTitle) throws Exception{
		makeReportUsingWFAM(dashboardTitle,reportTypeValue,wfName1);
		for(int i=0;i<20;i++) {
			searchBar.sendKeys(Keys.BACK_SPACE);
		}
		searchBar.sendKeys(wfName2);
		Thread.sleep(4000);
		wfCheckbox.click();
		Reporter.log("Second workflow is selected",true);
		Select pageSize_dropdown=new Select(pageSize);
		pageSize_dropdown.selectByVisibleText(PageSize);
		Thread.sleep(4000);
		generateBtn.click();
		Reporter.log("Generate button selected successfully",true);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		AddAs.click();
		Thread.sleep(3000);
		addAsTable.click();
		Reporter.log("Report added as a chart",true);
		createdReportValidationAM(NewReportTitle);
	}
	public void validateDashboardRelativeAM(String dashboardTitle,String dashboardDescp,String timeUnit,String refreshTime,String 
			dashboardDuration,String LastTime,String RangeType) throws Exception {
		createNewDashboardAM(dashboardTitle,dashboardDescp,timeUnit,refreshTime,dashboardDuration);
		Thread.sleep(3000);
		last.sendKeys(LastTime);
		Thread.sleep(3000);
		Select rangeType_dropdown=new Select(rangeType);
		rangeType_dropdown.selectByVisibleText(RangeType);
		Thread.sleep(3000);
		createBtn.click();
		Reporter.log("Create Button clicked successfully",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message1 = alertMessage.getText();
		String expected_message1 = Messages.dashboardCreation;
		Reporter.log("Actual Success Msg:" + actual_message1,true);
		Reporter.log("Expected Success Msg:" + expected_message1,true);
		Assert.assertEquals(actual_message1,expected_message1, "Dashboard not created");
		Reporter.log("Dashboard at None level created successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateEditDashboardToCustomAM(String dashboardTitle,String newDashboardTitle,String dashboardDescp,String dashboardDuration,
			String startdate,String startMonth,String startYear,String enddate,String endMonth,String endYear) throws Exception {
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(reportsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		Reporter.log("Reports Tab is clicked", true);
		Thread.sleep(3000);
		Select chooseDashboard_dropdown=new Select(chooseDashboard);
		chooseDashboard_dropdown.selectByVisibleText(dashboardTitle);
		Reporter.log("Dashboard chosed successfully",true);
		Thread.sleep(3000);
		newDashboardDropdown.click();
		Thread.sleep(3000);
		editReport.click();
		Reporter.log("Edit report is clicked",true);
		Thread.sleep(3000);
		for(int i=0;i<20;i++) {
			title.sendKeys(Keys.BACK_SPACE);
		}
		title.sendKeys(newDashboardTitle);
		Thread.sleep(3000);
		for(int i=0;i<80;i++) {
			description.sendKeys(Keys.BACK_SPACE);
		}
		description.sendKeys(dashboardDescp);
		Thread.sleep(3000);
		Select duration_drpdown=new Select(duration);
		duration_drpdown.selectByVisibleText(dashboardDuration);
		Reporter.log("Dashboard duration "+dashboardDuration+" selected",true);
		Thread.sleep(3000);
		Thread.sleep(3000);
		startDate.click();
		Thread.sleep(2000);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//a[text()='"+startdate+"']"));
		start_day_picker.click();
		Thread.sleep(10000);
		endDate.click();
		Thread.sleep(2000);
		Select end_month_picker=new Select(monthDrpdown);
		end_month_picker.selectByVisibleText(endMonth);
		Select end_year_picker=new Select(yearDrpdown);
		end_year_picker.selectByVisibleText(endYear);
		Thread.sleep(2000);
		WebElement end_day_picker=driver.findElement(By.xpath("//a[text()='"+enddate+"']"));
		end_day_picker.click();
		Thread.sleep(5000);
		updateBtn.click();
		Reporter.log("Update Button clicked successfully",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message1 = alertMessage.getText();
		String expected_message1 = Messages.updateDashboard;
		Reporter.log("Actual Success Msg:" + actual_message1,true);
		Reporter.log("Expected Success Msg:" + expected_message1,true);
		Assert.assertEquals(actual_message1,expected_message1, "Dashboard not edited");
		Reporter.log("Dashboard at Custom level updated successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateSetAsDefaultReportAM(String dashboardTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(reportsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		Reporter.log("Reports Tab is clicked", true);
		Select chooseDashboard_dropdown=new Select(chooseDashboard);
		chooseDashboard_dropdown.selectByVisibleText(dashboardTitle);
		Reporter.log("Dashboard chosed successfully",true);
		Thread.sleep(3000);
		newDashboardDropdown.click();
		Thread.sleep(3000);
		setAsDefault.click();
		Reporter.log("Set as Default option clicked",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Actual_Message=alertMessage.getText();
		String Expected_Message=Messages.reportAsDefault;
		Assert.assertEquals(Actual_Message,Expected_Message,"Report not saved as default successfully");
		Reporter.log("Report set as a default successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateDashboardTodayAM(String dashboardTitle,String dashboardDescp,String timeUnit,String refreshTime,String 
			dashboardDuration,String StartHour,String StartMinute,String EndHour,String EndMinute) throws Exception {
		createNewDashboardAM(dashboardTitle,dashboardDescp,timeUnit,refreshTime,dashboardDuration);
		Thread.sleep(3000);
		startHR.sendKeys(StartHour);
		Thread.sleep(3000);
		startMin.sendKeys(StartMinute);
		Thread.sleep(2000);
		endHR.sendKeys(EndHour);
		Thread.sleep(3000);
		endMin.sendKeys(EndMinute);
		Thread.sleep(3000);
		createBtn.click();
		Thread.sleep(3000);
		createBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message1 = alertMessage.getText();
		String expected_message1 = Messages.dashboardCreation;
		Reporter.log("Actual Success Msg:" + actual_message1,true);
		Reporter.log("Expected Success Msg:" + expected_message1,true);
		Assert.assertEquals(actual_message1,expected_message1, "Dashboard not created");
		Reporter.log("Dashboard at None level created successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateDeleteDashboardAM(String dashboardTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(reportsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		Reporter.log("Reports Tab is clicked", true);
		Select chooseDashboard_dropdown=new Select(chooseDashboard);
		chooseDashboard_dropdown.selectByVisibleText(dashboardTitle);
		Reporter.log("Dashboard chosed successfully",true);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();",newDashboardDropdown);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();",deleteDashboard);
		Reporter.log("Delete Dashboard option clicked");
		Thread.sleep(3000);
		deletePopup.click();
		Reporter.log("Delete button clicked on popup");
		String Actual_Msg=alertMessage.getText();
		String Expected_Msg = Messages.deleteDashboard;
		Reporter.log("After deleting dashboard with report, actual message get is: "+Actual_Msg,true);
		Assert.assertEquals(Actual_Msg,Expected_Msg,"Dashboard with report not deleted successfully");
		Reporter.log("Dashboard with report deleted successfully",true);
		informationpageta.validateSignOut();
	}

}
