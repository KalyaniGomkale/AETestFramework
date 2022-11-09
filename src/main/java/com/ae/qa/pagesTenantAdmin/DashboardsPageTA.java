package com.ae.qa.pagesTenantAdmin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;

public class DashboardsPageTA extends TestBase {
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
	@FindBy(xpath="//*[@id='report-tview']/div[1]/b")
	WebElement ReportTitle;
	@FindBy(id="startHour-hours")
	WebElement startHR;
	@FindBy(id="startHour-minutes")
	WebElement startMin;
	@FindBy(id="endHour-hours")
	WebElement endHR;
	@FindBy(id="endHour-minutes")
	WebElement endMin;
	@FindBy(xpath="//button[@id='drop-caret']")
	WebElement AddAs;
	@FindBy(xpath="//a[@id='add-chart']")
	WebElement addAsChart;
	@FindBy(xpath="//a[@id='add-table']")
	WebElement addAsTable;
	@FindBy(xpath="//input[@id='title']")
	WebElement changeReportTitle;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveBtn;
	@FindBy(xpath="//div[@class='report-card-grid']/div/p[1]")
	WebElement savedReportTitle;
	@FindBy(xpath="(//div[@class='report-card-grid'])[2]/div/p[1]")
	WebElement updatedReportTitle;
	@FindBy(id="range")
	WebElement last;
	@FindBy(id="rangeType")
	WebElement rangeType;
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
	@FindBy(xpath="//span[text()='Set As Default']")
	WebElement setAsDefault;
	@FindBy(xpath="//span[text()='Pin to Home']")
	WebElement pinToHome;
	@FindBy(xpath="//span[text()='Make Public']")
	WebElement makePublic;
	@FindBy(xpath="//span[text()='Delete Dashboard']")
	WebElement deleteDashboard;
	@FindBy(xpath="//button[text()='Delete']")
	WebElement deletePopup;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath="//div[@title='Maximize']")
	WebElement maximizeBtn;
	@FindBy(xpath="//div[@title='Download as PDF']")
	WebElement pdfDownloadBtn;
	@FindBy(xpath="(//select[@title='Choose Dashboard'])[1]")
	WebElement selectReport;
	@FindBy(xpath="(//input[@id='chooser'])[2]")
	WebElement categoryRadioButton;
	@FindBy(xpath="//span[@class='mul-checkmark']")
	WebElement selectAll;
	@FindBy(xpath="//div/p[@class='title']")
	WebElement reportTitle;
	@FindBy(xpath="//span[@id='col-toggle']")
	WebElement hideColumnIcon;

	public DashboardsPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void createNewDashboard(String dashboardTitle,String dashboardDescp,String timeUnit,String refreshTime,String 
			dashboardDuration) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
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
	public void validateDashboardNone(String dashboardTitle,String dashboardDescp,String timeUnit,String refreshTime,String 
			dashboardDuration ) throws Exception {
		createNewDashboard(dashboardTitle,dashboardDescp,timeUnit,refreshTime,dashboardDuration);
		Thread.sleep(3000);
		createBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message1 = alertMessage.getText();
		String expected_message1 = Messages.dashboardCreation;
		Reporter.log("Actual Success Msg:" + actual_message1,true);
		Reporter.log("Expected Success Msg:" + expected_message1,true);
		Assert.assertEquals(actual_message1,expected_message1, "Dashboard not created");
		Reporter.log("Dashboard at None level created successfully",true);
	}
	public void validateDashboardToday(String dashboardTitle,String dashboardDescp,String timeUnit,String refreshTime,String 
			dashboardDuration,String StartHour,String StartMinute,String EndHour,String EndMinute) throws Exception {
		createNewDashboard(dashboardTitle,dashboardDescp,timeUnit,refreshTime,dashboardDuration);
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
		Thread.sleep(3000);
		String actual_message1 = alertMessage.getText();
		String expected_message1 = Messages.dashboardCreation;
		Reporter.log("Actual Success Msg:" + actual_message1,true);
		Reporter.log("Expected Success Msg:" + expected_message1,true);
		Assert.assertEquals(actual_message1,expected_message1, "Dashboard not created");
		Reporter.log("Dashboard at None level created successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateDashboardRelative(String dashboardTitle,String dashboardDescp,String timeUnit,String refreshTime,String 
			dashboardDuration,String LastTime,String RangeType) throws Exception {
		createNewDashboard(dashboardTitle,dashboardDescp,timeUnit,refreshTime,dashboardDuration);
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
	//common method while creating report till user choose one wf
	public void makeReportUsingWF(String dashboardTitle,String reportTypeValue,String wfName1) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
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
	public void validateReportNoneMultipleWF(String dashboardTitle,String reportTypeValue,String wfName1,String wfName2,String PageSize,
			String NewReportTitle) throws Exception {
		makeReportUsingWF(dashboardTitle,reportTypeValue,wfName1);
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
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(2000);
		AddAs.click();
		Thread.sleep(3000);
		addAsTable.click();
		Reporter.log("Report added as a chart",true);
		createdReportValidation(NewReportTitle);
	}
	//common method from changing title of report and its name validation
	public void createdReportValidation(String NewReportTitle) throws Exception {
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

	public void validateReportToday(String dashboardTitle,String reportTypeValue,String wfName1,String PageSize,
			String NewReportTitle) throws Exception {
		makeReportUsingWF(dashboardTitle,reportTypeValue,wfName1);
		Select pageSize_dropdown=new Select(pageSize);
		pageSize_dropdown.selectByVisibleText(PageSize);
		Thread.sleep(3000);
		generateBtn.click();
		Reporter.log("Generate button selected successfully",true);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		AddAs.click();
		Thread.sleep(2000);
		addAsChart.click();
		Reporter.log("Report added as a chart",true);
		createdReportValidation(NewReportTitle);
	}

	public void validateReportRelative(String dashboardTitle,String reportTypeValue,String wfName1,String PageSize,
			String NewReportTitle) throws Exception {
		makeReportUsingWF(dashboardTitle,reportTypeValue,wfName1);
		Select pageSize_dropdown=new Select(pageSize);
		pageSize_dropdown.selectByVisibleText(PageSize);
		Thread.sleep(3000);
		generateBtn.click();
		Reporter.log("Generate button selected successfully",true);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		AddAs.click();
		Thread.sleep(2000);
		addAsChart.click();
		Reporter.log("Report added as a chart",true);
		createdReportValidation(NewReportTitle);
	}
	public void validateEditDashboardToCustom(String dashboardTitle,String newDashboardTitle,String dashboardDescp,String dashboardDuration,
			String startdate,String startMonth,String startYear,String enddate,String endMonth,String endYear) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
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
	public void validateReportCustom(String dashboardTitle,String reportTypeValue,String wfName1,String PageSize,
			String NewReportTitle) throws Exception {
		makeReportUsingWF(dashboardTitle,reportTypeValue,wfName1);
		Select pageSize_dropdown=new Select(pageSize);
		pageSize_dropdown.selectByVisibleText(PageSize);
		Thread.sleep(3000);
		generateBtn.click();
		Reporter.log("Generate button selected successfully",true);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		AddAs.click();
		Thread.sleep(2000);
		addAsTable.click();
		Reporter.log("Report added as a Table",true);
		for(int i=0;i<60;i++) {
			changeReportTitle.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		changeReportTitle.sendKeys(NewReportTitle);
		Thread.sleep(2000);
		saveBtn.click();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		String Actual_savedReport=alertMessage.getText();
		String Expected_savedReport=Messages.reportAddition;
		Assert.assertEquals(Actual_savedReport,Expected_savedReport,"Report created successfully");
		Reporter.log("Report saved on screen",true);
		//validation of name
		Thread.sleep(3000);
		String Actual_reportName=updatedReportTitle.getText();
		String Expected_reportName=NewReportTitle;
		Assert.assertEquals(Actual_reportName,Expected_reportName,"Report doesn't displayed on screen successfully");
		Reporter.log("Report " +NewReportTitle+" displayed on screen successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateSetAsDefaultReport(String dashboardTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
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
	public void validatePinToHome(String dashboardTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		Reporter.log("Reports Tab is clicked", true);
		Select chooseDashboard_dropdown=new Select(chooseDashboard);
		chooseDashboard_dropdown.selectByVisibleText(dashboardTitle);
		Reporter.log("Dashboard chosed successfully",true);
		Thread.sleep(3000);
		newDashboardDropdown.click();
		Thread.sleep(3000);
		pinToHome.click();
		Reporter.log("Pin to Home option clicked");
		String Actual_Msg=alertMessage.getText();
		String Expected_Msg ="Dashboard ["+dashboardTitle+"] set as home dashboard";
		Reporter.log("After Pin to Home actual message get is: "+Actual_Msg,true);
		Assert.assertEquals(Actual_Msg,Expected_Msg,"Report not saved as default successfully");
		Reporter.log("Report set as a default successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateMakePublic(String dashboardTitle) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		Reporter.log("Reports Tab is clicked", true);
		Select chooseDashboard_dropdown=new Select(chooseDashboard);
		chooseDashboard_dropdown.selectByVisibleText(dashboardTitle);
		Reporter.log("Dashboard chosed successfully",true);
		Thread.sleep(3000);
		newDashboardDropdown.click();
		Thread.sleep(3000);
		makePublic.click();
		Reporter.log("Make Public option clicked");
		String Actual_Msg=alertMessage.getText();
		String Expected_Msg = "Dashboard ["+dashboardTitle+"], Access Level set to Public";
		Reporter.log("After making dashboard public actual message get is: "+Actual_Msg,true);
		Assert.assertEquals(Actual_Msg,Expected_Msg,"Report not made public successfully");
		Reporter.log("Dashboard made as public successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateDeleteDashboardWithReport(String dashboardTitle) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		Reporter.log("Reports Tab is clicked", true);
		Select chooseDashboard_dropdown=new Select(chooseDashboard);
		chooseDashboard_dropdown.selectByVisibleText(dashboardTitle);
		Reporter.log("Dashboard chosed successfully",true);
		Thread.sleep(3000);
		newDashboardDropdown.click();
		Thread.sleep(3000);
		deleteDashboard.click();
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
	public void validateDeleteDashboardWithoutReport(String dashboardTitle,String dashboardDescp,String timeUnit,
			String refreshTime,String dashboardDuration) throws Exception{
		createNewDashboard(dashboardTitle,dashboardDescp,timeUnit,refreshTime,dashboardDuration);
		Thread.sleep(3000);
		createBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_message1 = alertMessage.getText();
		String expected_message1 = Messages.dashboardCreation;
		Reporter.log("Actual Success Msg:" + actual_message1,true);
		Reporter.log("Expected Success Msg:" + expected_message1,true);
		Assert.assertEquals(actual_message1,expected_message1, "Dashboard not created");
		Reporter.log("Dashboard at None level created successfully",true);
		Select chooseDashboard_dropdown=new Select(chooseDashboard);
		chooseDashboard_dropdown.selectByVisibleText(dashboardTitle);
		Reporter.log("Dashboard chosed successfully",true);
		Thread.sleep(3000);
		newDashboardDropdown.click();
		Thread.sleep(3000);
		deleteDashboard.click();
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
	public void validateLabelChangeInReport(String reportName,String changedColumnName) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", reportsTab);
		js.executeScript("arguments[0].click();", dashboardsTab);
		Thread.sleep(2000);
		WebElement reportTitle=driver.findElement(By.xpath("//div/p[contains(text(),'"+reportName+"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(reportTitle).perform();
		reportTitle.click();
		js.executeScript("arguments[0].click();",maximizeBtn);
		Reporter.log("Maximize Button is clicked", true);
		Thread.sleep(2000);
		WebElement column=driver.findElement(By.xpath("//table/thead/tr/th[1]"));
		column.click();
		WebElement columnName = driver.findElement(By.xpath("//table/thead/tr/th/input[@id='column-0']"));
		for(int i = 0; i < 50; i++) {
			columnName.sendKeys(Keys.BACK_SPACE);
		}
		Reporter.log("Column name is been cleared",true);
		columnName.sendKeys(changedColumnName);
		Reporter.log("New Column name is been updated",true);
		Thread.sleep(2000);
		WebElement reportTitleTable=driver.findElement(By.xpath("//div/b[contains(text(),'"+reportName+"')]"));
		reportTitleTable.click();
		Thread.sleep(5000);
		String actual_ChangedColumnName=column.getText();
		System.out.println("Actual Changed Column Label:- "+actual_ChangedColumnName);
		String expected_ChangedColumnName=changedColumnName;
		System.out.println("Expected Changed Column Label:- "+expected_ChangedColumnName);
		Assert.assertEquals(actual_ChangedColumnName,expected_ChangedColumnName,"Report Column Label is not changed successfully");
		Reporter.log("Report Column Label changed successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateDownloadReportPdf(String reportName) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", reportsTab);
		js.executeScript("arguments[0].click();", dashboardsTab);
		Thread.sleep(2000);
		WebElement reportTitle=driver.findElement(By.xpath("//div/p[contains(text(),'"+reportName+"')]"));
		Actions action = new Actions(driver);
		action.moveToElement(reportTitle).perform();
		reportTitle.click();
		js.executeScript("arguments[0].click();",pdfDownloadBtn);
		Reporter.log("Download pdf Button is clicked", true);
		Thread.sleep(3000);
		String actualsuccess_Msg=alertMessage.getText();
		System.out.println("Actual Success Message:- "+actualsuccess_Msg);
		String expectedsuccess_Msg=Messages.reportDownloadSuccessMsg;
		System.out.println("Expected Success Message:- "+expectedsuccess_Msg);
		Assert.assertEquals(actualsuccess_Msg,expectedsuccess_Msg,"Report download not started");
		Reporter.log("Report is downloaded as PDF successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateReportNoneMultipleCategory(String dashboardTitle,String reportTypeValue,String PageSize,String reportTypeName) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", reportsTab);
		js.executeScript("arguments[0].click();", dashboardsTab);
		Thread.sleep(2000);		
		Select chooseDashboard_dropdown=new Select(chooseDashboard);
		chooseDashboard_dropdown.selectByVisibleText(dashboardTitle);
		Reporter.log("Dashboard chosed successfully",true);
		Thread.sleep(4000);
		newDashboardDropdown.click();
		Thread.sleep(4000);
		addReportOption.click();
		Reporter.log("Add report is clicked",true);
		Thread.sleep(2000);
		Select reportType_dropdown=new Select(reportTypedrpdown);
		reportType_dropdown.selectByValue(reportTypeValue);
		Reporter.log("Report Type selected successfully",true);
		categoryRadioButton.click();
		if(categoryRadioButton.isSelected()){
			Reporter.log("Select Categories Radio Button is Selected");
			selectWFs.click();
			selectAll.click();
		}else {
			Reporter.log("Select Categories Radio Button is not Selected");
		}
		Select pageSize_dropdown=new Select(pageSize);
		pageSize_dropdown.selectByVisibleText(PageSize);
		Thread.sleep(4000);
		generateBtn.click();
		Reporter.log("Generate button selected successfully",true);
		Thread.sleep(3000);
		String Actual_reportName=reportTitle.getText();
		System.out.println("Actual Report Name:- "+Actual_reportName);
		String Expected_reportName=reportTypeName;
		System.out.println("Expected Report Name:- "+Expected_reportName);
		Assert.assertEquals(Actual_reportName,Expected_reportName,"Report doesn't displayed on screen successfully");
		Reporter.log("Report " +reportTypeName+" displayed on screen successfully",true);
		informationpageta.validateSignOut();

	}
	public void validateFullScreenMode() throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", reportsTab);
		js.executeScript("arguments[0].click();", dashboardsTab);
		Thread.sleep(2000);
		//height 768 width 1366
		//height 744 width 1382
		Dimension actual_size = driver.manage().window().getSize();
		int actual_height = actual_size.getHeight();
		int actual_width =  actual_size.getWidth();
		System.out.println("Actual height " + actual_height + "Actual width " + actual_width);
		Thread.sleep(2000);
		WebElement maximizeBtn = driver.findElement(By.id("display-toggle-screen"));
		maximizeBtn.click();
		Thread.sleep(3000);
		Dimension expected_size = driver.manage().window().getSize();
		int expected_height = expected_size.getHeight();
		int expected_width =  expected_size.getWidth();
		System.out.println("Expected height " + expected_height + "Expected width " + expected_width);
		SoftAssert s=new SoftAssert();
		s.assertNotEquals(actual_height, expected_height,"Height matches");
		s.assertNotEquals(actual_width, expected_width,"Width matches");
		maximizeBtn.click();
		informationpageta.validateSignOut();
	}  
	public void validateColumnHide(String dashboardTitle) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",reportsTab);
		Reporter.log("Reports Tab is clicked", true);
		Select chooseDashboard_dropdown=new Select(chooseDashboard);
		chooseDashboard_dropdown.selectByVisibleText(dashboardTitle);
		Reporter.log("Dashboard chosed successfully",true);
		Thread.sleep(3000);
		hideColumnIcon.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li[@title='Status']")).click();
		Thread.sleep(5000);
		hideColumnIcon.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul/li[@title='Source']")).click();
		Thread.sleep(4000);
		//hideColumnIcon.click();
		Thread.sleep(4000);
		List<WebElement> tableHeader = driver.findElements(By.xpath("//table/thead[@class='report-view-row-header']/tr[1]/th/div/div"));
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < tableHeader.size(); i++) {
			// String Field=TotalColumn.get(i).getText();
			Reporter.log("Field of Columns: " + tableHeader.get(i).getText(), true);
			value.add(tableHeader.get(i).getText());
		}
		if (value.contains("Workflow Name") && value.contains("Submitted By") && value.contains("Created Time")
				&& value.contains("Execution Start Time") && value.contains("Completed Time")) {
			Reporter.log("Column Value found", true);
			Assert.assertTrue(true);
			Reporter.log("All columns selected found in table.", true);
		} else {
			Reporter.log("Column value not found", true);
			Assert.assertTrue(false);
		}
		informationpageta.validateSignOut();
	}

	public void validateDashboardsPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", reportsTab);
		js.executeScript("arguments[0].click();", dashboardsTab);
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



