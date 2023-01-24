package com.ae.qa.pagesTenantAdmin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class RequestsPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();
	public WorkflowListPageTA workflowlistpageta = new WorkflowListPageTA();
	public WorkflowAssignmentPageTA workflowassignmentta=new WorkflowAssignmentPageTA();
	public CommonWebElements wb = new CommonWebElements();
	//	public AdvanceSearchPage advancesearchpage = new AdvanceSearchPage();

	@FindBy(xpath = "//span[text()='Requests']")
	WebElement requestsTab;
	@FindBy(xpath = "//*[@id='main-component']/ng-component/div[3]/div[3]/div[2]/table/tbody[1]/tr/td[3]/span[1]")
	WebElement requestStatus;
	@FindBy(name = "refresh-btn")
	WebElement refershTableBtn;
	@FindBy(xpath = "//span[contains(@id,'trow-true')]")
	WebElement reqStatus;
	@FindBy(xpath = "//table[@class='ae-table table table-bordered table-hover']/tbody/tr[2]/td/div/span[1]")
	WebElement execMessage;
	@FindBy(xpath = "//table[@id='agentTable']/tr[3]/td[5]/span")
	WebElement status;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement showColumnDrpdown;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement selectAllCheckBox;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']/div")
	WebElement columnCount;
	@FindBy(name="download-requests")
	WebElement downloadRequest;
	@FindBy(id="downloadBtn")
	WebElement downloadBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(name = "submit")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement success_msg;
	@FindBy(xpath = "//span[text()='Catalogue']")
	WebElement catalogueTab;
	@FindBy(xpath="//button[@name='submit']")
	WebElement submitRequestBtn;
	@FindBy(xpath="//input[@id='a']")
	WebElement RunParamInput;
	@FindBy(id="popup-button-ok")
	WebElement okBtn;
	@FindBy(xpath = "//span[contains(@title,'Restart')]")
	WebElement restartStatus;
	@FindBy(xpath="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(id="num1")
	WebElement runParam1;
	@FindBy(id="num3")
	WebElement runParam2;
	@FindBy(id="num4")
	WebElement runParam3;
	@FindBy(xpath = "//span[@title='Terminate']")
	WebElement terminateBtn;
	@FindBy(xpath = "//button[text()='Terminate']")
	WebElement confirmTerminateBtn;
	@FindBy(id="num2")
	WebElement configParamInput;
	@FindBy(xpath="//span[@class='fa fa-caret-right']")
	WebElement configParamBar;

	public RequestsPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateRequestStatus() throws Exception {
		// Here status like New,ExecutionStarted,Completed and Failure are covered
		// whatever the status is tc pass because the moto is to check submitted request
		// and not its status
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		Thread.sleep(20000);
		//wait.until(ExpectedConditions.visibilityOf(requestsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		js.executeScript("arguments[0].click();", refershTableBtn);
		//refershTableBtn.click();
		Thread.sleep(10000);
		String wfStatus = requestStatus.getText();
		Boolean flag = false;
		if (wfStatus.equals("New")) {
			Thread.sleep(10000);
			Reporter.log("Workflow status is:" + wfStatus, true);
			refershTableBtn.click();
			Assert.assertTrue(!flag);
		} else if (wfStatus.equals("ExecutionStarted")) {
			Reporter.log("Execution of workflow just started", true);
			Thread.sleep(10000);
			refershTableBtn.click();
			Thread.sleep(3000);
			reqStatus.click();
			Reporter.log("Workflow status is:" + wfStatus, true);
			Assert.assertTrue(!flag);
		} else if (wfStatus.equals("Complete")) {
			reqStatus.click();
			Reporter.log("Additional status details is clicked", true);
			String actual_message = execMessage.getText();
			Reporter.log("Message after execution of wf:" + actual_message, true);
			String expected_message = Messages.executionMessage;
			Reporter.log("Workflow status is:" + wfStatus, true);
			Assert.assertEquals(actual_message, expected_message, "Execution is not successful");
		} else if (wfStatus.equals("Failure")) {
			Reporter.log("Workflow status is:" + wfStatus, true);
			Assert.assertTrue(!flag);
		} else {
			Reporter.log("Workflow status is neither completed nor Failure, but other than that: " + wfStatus, true);
			Assert.assertTrue(flag);
		}
		// informationpageta.validateSignOut();
	}

	public void checkColumnsInRequests() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(requestsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (!selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All CheckBox");
		} else {
			System.out.println("Select All Checkbox is already selected");
		}
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
		Assert.assertEquals(sizeOfColumnsInt, 26, "All columns not selected");
		Reporter.log("All Column got displayed in records after Checking select All checkbox.", true);
		informationpageta.validateSignOut();
	}

	public void deselectAllInRequests() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(requestsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			Reporter.log("Clicked on Select All and resulted into deselected all columns.", true);
		} else {
			for (int i = 1; i <= 2; i++) {
				selectAllCheckBox.click();
			}
			Reporter.log("Select All Checkbox is not already selected, Hence selected twice to deselect it.", true);
		}
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);// 3
		Reporter.log("Selected count of No. of colums " + sizeOfColumnsInt, true);// 3
		List<WebElement> TotalColumn = driver
				.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th"));
		Reporter.log("Total No of columns in table: " + TotalColumn.size(), true);
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			Reporter.log("Field of Columns: " + TotalColumn.get(i).getText(), true);
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Id") || value.contains("Workflow Name") || value.contains("Status")) {
			Reporter.log("Column Value found", true);
			Assert.assertEquals(sizeOfColumnsInt, 3, "All columns are not deselected. ");
			Reporter.log("All Options got deselected except Id,Workflow Name,Status.", true);
		} else {
			Reporter.log("Column value not found", true);
			Assert.assertTrue(false);
		}
		informationpageta.validateSignOut();
	}

	public void SpecificColumnInRequests() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(requestsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			Reporter.log("Clicked on Select All and resulted into deselected all columns.", true);
		} else {
			for (int i = 1; i <= 2; i++) {
				selectAllCheckBox.click();
				Thread.sleep(3000);
			}
			Reporter.log("Select All Checkbox is not already selected, Hence selected twice to deselect it.", true);

		}
		// select 2 more columns
		driver.findElement(By.xpath("//a/span[text()='Priority']")).click();
		driver.findElement(By.xpath("//a/span[text()='Completed']")).click();
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
		List<WebElement> TotalColumn = driver
				.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th"));
		System.out.println("Total No of columns in table: " + TotalColumn.size());
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			// String Field=TotalColumn.get(i).getText();
			Reporter.log("Field of Columns: " + TotalColumn.get(i).getText(), true);
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Id") && value.contains("Workflow Name") && value.contains("Priority")
				&& value.contains("Status") && value.contains("Completed")) {
			Reporter.log("Column Value found", true);
			Assert.assertTrue(true);
			Assert.assertEquals(sizeOfColumnsInt, TotalColumn.size(), "All columns selected not found in table.");
			Reporter.log("All columns selected found in table.", true);
		} else {
			Reporter.log("Column value not found", true);
			Assert.assertTrue(false);
		}
		informationpageta.validateSignOut();
	}

	public void validateDownloadRequest() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		//wait.until(ExpectedConditions.visibilityOf(requestsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		downloadRequest.click();
		Thread.sleep(3000);
		downloadBtn.click();
		Reporter.log("Download button is clicked & request download started",true);
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateRequestAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		refershTableBtn.click();
		Thread.sleep(10000);
		// webelements.AdvanceSearchField("name", "eq", tName);
		// webelements.ExtraAdvanceSearch("orgCode", "eq", orgCode);
	}

	public void validateRequestsPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(requestsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}
	// loginpageta.login(prop.getProperty("username_TA"),
	// prop.getProperty("password_TA"));
	// Reporter.log("User logged in successfully",true);
	/*
	 * wait.until(ExpectedConditions.visibilityOf(requestsTab)); JavascriptExecutor
	 * js= (JavascriptExecutor) driver;
	 * js.executeScript("arguments[0].click();",requestsTab);
	 * Reporter.log("Requests Tab is clicked",true); Thread.sleep(4000);
	 * //refershTableBtn.click(); Reporter.log("Refreshed Table ",true); String
	 * wfStatus=requestStatus.getText(); Boolean flag=false;
	 * if(wfStatus.equals("Complete")) { reqStatus.click();
	 * Reporter.log("Additional status details is clicked",true); String
	 * actual_message=execMessage.getText();
	 * Reporter.log("Message after execution of wf:"+actual_message, true); String
	 * expected_message = Messages.executionMessage;
	 * Reporter.log("Workflow status is not completed & status is:"+wfStatus,true);
	 * Assert.assertEquals(actual_message,
	 * expected_message,"Execution is not successful"); } else
	 * if(wfStatus.equals("Failure")){
	 * Reporter.log("Workflow status is not completed & status is:"+wfStatus,true);
	 * Assert.assertTrue(!flag); } else { //mostly status will be either completed
	 * or failure but for others it is covered Reporter.
	 * log("Workflow status is neither completed nor Failure, but other than that: "
	 * +wfStatus,true); Assert.assertTrue(flag); }
	 * informationpageta.validateSignOut(); }
	 */
	public void validateAdvanceSearchRequestPage(String colunmValue,String comparatorType,String searchValue) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Thread.sleep(5000);
		//advancesearchpage.validateAdvanceSearchField(colunmValue,comparatorType,searchValue);
		//advancesearchpage.validateAdvanceSearchDropDown(colunmValue1,comparatorType1,searchValue1);
		//advancesearchpage.validateAdvanceSearchForCalender(colunmValue2,comparatorType2,
		//startYear,startMonth,startdate);
		informationpageta.validateSignOut();
	}
	public void validateRequestFailureReason(String wfName, String wfdes, String category, String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String RunParam) throws Exception {
		// Here status like New,ExecutionStarted,Completed and Failure are covered
		// whatever the status is tc pass because the moto is to check submitted request
		// and not its status
		workflowlistpageta.ImportForm(wfName,wfdes,category,WFImportPath,priority,expTime,maxTime,cleanUpHrs,manExeTime,tUnit);
		Thread.sleep(2000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
		workflowassignmentta.validateSingleWorkflowAssignment(wfName);
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(catalogueTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",catalogueTab);
		Reporter.log("Catalogue Tab is clicked",true);
		Thread.sleep(2000);
		WebElement wfNameToSendRequest=driver.findElement(By.xpath("//h6[text()='"+wfName+"']"));
		wfNameToSendRequest.click();
		Reporter.log("Workflow whose request needs to be send is selected",true);
		Thread.sleep(2000);
		RunParamInput.sendKeys(RunParam);
		submitRequestBtn.click();
		Reporter.log("Submit request button is clicked");
		Thread.sleep(2000);
		okBtn.click();
		Reporter.log("OK button is clicked");
		Thread.sleep(2000);
		informationpageta.validateSignOut();
		//Checking status in wf admin now
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User logged in successfully", true);
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		js.executeScript("arguments[0].click();", refershTableBtn);
		Thread.sleep(10000);
		String wfStatus = requestStatus.getText();
		Boolean flag = false;
		if (wfStatus.equals("New")) {
			Thread.sleep(10000);
			Reporter.log("Workflow status is:" + wfStatus, true);
			refershTableBtn.click();
			Assert.assertTrue(!flag);
		} else if (wfStatus.equals("ExecutionStarted")) {
			Reporter.log("Execution of workflow just started", true);
			Thread.sleep(10000);
			refershTableBtn.click();
			Thread.sleep(3000);
			reqStatus.click();
			Reporter.log("Workflow status is:" + wfStatus, true);
			Assert.assertTrue(!flag);
		} else if (wfStatus.equals("Failure")) {
			reqStatus.click();
			Reporter.log("Additional status details is clicked", true);
			String actual_message = execMessage.getText();
			Reporter.log("Message after execution of wf:" + actual_message, true);
			String expected_message = Messages.executionFailureMessage;
			Reporter.log("Workflow status is:" + wfStatus, true);
			Assert.assertEquals(actual_message, expected_message, "Execution is successful");
		} else if (wfStatus.equals("Complete")) {
			Reporter.log("Workflow status is:" + wfStatus, true);
			Assert.assertTrue(!flag);
		} else {
			Reporter.log("Workflow status is neither completed nor Failure, but other than that: " + wfStatus, true);
			Assert.assertTrue(flag);
		}
		informationpageta.validateSignOut();
	}
	public void validateRestartRequest() throws Exception{
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		Thread.sleep(2000);
		String requestID=driver.findElement(By.xpath("(//table/tbody/tr[1]/td[1])[2]")).getText();
		System.out.println("Request ID:- "+requestID);
		String wfStatus = requestStatus.getText();
		System.out.println("Request Status:-" +wfStatus);
		Thread.sleep(2000);		
		if(wfStatus.equals("Failure"))
		{
			Assert.assertTrue(wfStatus.equals("Failure"));
			js.executeScript("arguments[0].click();", restartStatus);
			Reporter.log("Restart icon is clicked", true);
			okBtn.click();
			Reporter.log("Request Status is "+wfStatus+" So Restart button is visible and clicked",true);
		}else if(wfStatus.equals("Complete")){
			Assert.assertTrue(wfStatus.equals("Failure"));
			Reporter.log("Request Status is "+wfStatus+" So Restart button is not visible and clicked",true);
		}
		String actual_Message=alertMessage.getText();
		System.out.println("Actual Message:- "+actual_Message);
		String expected_Message="Request ["+requestID+"] has been restarted";
		Assert.assertEquals(actual_Message, expected_Message, "Request has not been restarted");
		Reporter.log("Request ["+requestID+"] has been restarted",true);
		informationpageta.validateSignOut();
	}
	public void validateTerminateRequest(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String ConfigParamString,
			String RunParam1,String RunParam2,String RunParam3) throws Exception{
		workflowlistpageta.ImportForm(wfName, wfdes, category, WFImportPath, priority, expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", configParamBar);
		Reporter.log("Config Parameter is clicked",true);
		Thread.sleep(3000);
		configParamInput.sendKeys(ConfigParamString);
		Reporter.log("Config Parameter is entered",true);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
		workflowassignmentta.validateSingleWorkflowAssignment(wfName);
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(catalogueTab));
		js.executeScript("arguments[0].click();",catalogueTab);
		Reporter.log("Catalogue Tab is clicked",true);
		Thread.sleep(2000);
		WebElement wfNameToSendRequest=driver.findElement(By.xpath("//h6[text()='"+wfName+"']"));
		js.executeScript("arguments[0].click();", wfNameToSendRequest);
		Reporter.log("Workflow whose request needs to be send is selected",true);
		Thread.sleep(2000);
		runParam1.sendKeys(RunParam1);
		runParam2.sendKeys(RunParam2);
		runParam3.sendKeys(RunParam3);
		submitRequestBtn.click();
		Reporter.log("Submit request button is clicked");
		Thread.sleep(2000);
		okBtn.click();
		Reporter.log("OK button is clicked");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		Thread.sleep(2000);
		String requestID=driver.findElement(By.xpath("(//table/tbody/tr[1]/td[1])[2]")).getText();
		System.out.println("Request ID:- "+requestID);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", refershTableBtn);
		Thread.sleep(2000);
		String wfStatus = requestStatus.getText();
		if(wfStatus.equals("ExecutionStarted"))
		{
			Assert.assertTrue(wfStatus.equals("ExecutionStarted"));
			terminateBtn.click();
			confirmTerminateBtn.click();
			Reporter.log("Request Status is "+wfStatus+" So Terminate button is visible and clicked",true);
		}else if(wfStatus.equals("Complete")||wfStatus.equals("Failure")){
			Assert.assertTrue(wfStatus.equals("ExecutionStarted"));
			Reporter.log("Request Status is "+wfStatus+" So Terminate button is not visible and clicked",true);
		}
		String actual_Message=alertMessage.getText();
		System.out.println("Actual Message:- "+actual_Message);
		String expected_Message="Request ["+requestID+"] termination has been initiated";
		Assert.assertEquals(actual_Message, expected_Message, "Termination has not been initiated");
		Reporter.log("Request ["+requestID+"] termination has been initiated",true);
		informationpageta.validateSignOut();
	}
	public void validateAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		wb.validateClickOnAdvanceSearch();
	}
	public void HandleEnterFieldValue(String SearchColumn,String SearchCriteria,String SearchFor,String PageSize)
			throws Exception {
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,SearchFor);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
	}
	public void validateAdvSearchForIDEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate ID : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[1]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_ID = op.get(i).getText();
			Reporter.log("actual_ID present in table are: " + actual_ID + " expected ID is " + AdvSearchFor, true);
			Assert.assertEquals(actual_ID, AdvSearchFor,
					"Mismatch in actual and expected ID of advance search of request page");
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForIDNotEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate ID : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[1]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_ID = op.get(i).getText();
			Reporter.log("actual_ID present in table are: " + actual_ID + " expected ID is " + AdvSearchFor, true);
			Assert.assertFalse(actual_ID.equals(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForIDLessThan(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate ID : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[1]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_ID = op.get(i).getText();
			int actualID= Integer. parseInt(actual_ID);
			int expectedID= Integer. parseInt(AdvSearchFor);
			Reporter.log("actual_ID present in table are: " + actual_ID + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actualID < expectedID);
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForIDGreaterThan(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate ID : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[1]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_ID = op.get(i).getText();
			int actualID= Integer. parseInt(actual_ID);
			int expectedID= Integer. parseInt(AdvSearchFor);
			Reporter.log("actual_ID present in table are: " + actual_ID + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actualID > expectedID);
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForIDInRange(String SearchColumn, String SearchCriteria, String SearchField1,
			String SearchField2,String PageSize) throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchFieldForRange(SearchColumn, SearchCriteria,SearchField1,SearchField2);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
		// Verify data in table now//2-4
		Reporter.log("Below validation is to validate ID : " + SearchCriteria
				+ " of "+SearchField1+"-"+SearchField2+" is visible in webtable or not", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[1]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_ID = op.get(i).getText();//2,3,4
			int actualID= Integer. parseInt(actual_ID);
			int expected_SearchFiledIDRange1= Integer. parseInt(SearchField1);
			int expected_SearchFiledIDRange2= Integer. parseInt(SearchField2);
			Reporter.log("actual_ID present in table are: " + actual_ID + " expected ID is in range of " + expected_SearchFiledIDRange1+"-"+expected_SearchFiledIDRange2, true);
			Assert.assertTrue(actualID >= expected_SearchFiledIDRange1 && actualID <= expected_SearchFiledIDRange2 );
		} 
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForIDNotInRange(String SearchColumn, String SearchCriteria, String SearchField1,
			String SearchField2, String PageSize) throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchFieldForRange(SearchColumn, SearchCriteria,SearchField1,SearchField2);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
		// Verify data in table now//2-4
		Reporter.log("Below validation is to validate ID : " + SearchCriteria
				+ " of "+SearchField1+"-"+SearchField2+" is visible in webtable or not", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[1]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_ID = op.get(i).getText();//1,5,6,7
			int actualID= Integer. parseInt(actual_ID);
			int expected_SearchFiledIDRange1= Integer. parseInt(SearchField1);
			int expected_SearchFiledIDRange2= Integer. parseInt(SearchField2);
			Reporter.log("actual_ID present in table are: " + actual_ID + " expected ID is in range of " + expected_SearchFiledIDRange1+"-"+expected_SearchFiledIDRange2, true);
			Assert.assertTrue(actualID < expected_SearchFiledIDRange1 || actualID > expected_SearchFiledIDRange2 );
		} 
		informationpageta.validateSignOut();
	}
	//For Workflow Name
	public void validateAdvSearchForWFNameEqualTo(String SearchColumn,String SearchCriteria,
			String wfName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, wfName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Workflow name record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFName=op.get(i).getText();
			System.out.println("actual_Workflow name present in table are: "+actual_WFName);
			Assert.assertTrue(actual_WFName.equals(wfName));
		}
	}
	public void validateAdvSearchForWFNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String wfName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, wfName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Workflow name record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFName=op.get(i).getText();
			System.out.println("actual_Workflow name present in table are: "+actual_WFName);
			Assert.assertFalse(actual_WFName.equals(wfName));
		}
	}
	public void validateAdvSearchForWFNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Workflow name record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFName=op.get(i).getText();
			System.out.println("actual_Workflow name present in table are: "+actual_WFName);
			Assert.assertTrue(actual_WFName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForWFNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Workflow name record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFName=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Workflow name present in table are: "+actual_WFName);
			Thread.sleep(3000);
			Assert.assertTrue(actual_WFName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForWFNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Workflow name record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFName=op.get(i).getText();
			System.out.println("actual_Workflow name present in table are: "+actual_WFName);
			Assert.assertTrue(actual_WFName.contains(advSearchFor));
		}
	}
	//For priority
	public void validatePriorityDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Priority record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Priority record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Priority=op.get(i).getText();
			System.out.println("actual_Priority present in table are: "+actual_Priority);
			Assert.assertTrue(actual_Priority.equalsIgnoreCase(searchValue));
		}
	}
	public void validatePriorityDropdownNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Priority record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Priority record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Priority=op.get(i).getText();
			System.out.println("actual_Priority present in table are: "+actual_Priority);
			Assert.assertFalse(actual_Priority.equalsIgnoreCase(searchValue));
		}
	}
	//For Status
	public void validateStatusDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Status record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[4]/span[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Status record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Status=op.get(i).getText();
			System.out.println("actual_Status present in table are: "+actual_Status);
			Assert.assertTrue(actual_Status.equalsIgnoreCase(searchValue));
		}
	}
	public void validateStatusDropdownNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Status record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[4]/span[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Status record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Status=op.get(i).getText();
			System.out.println("actual_Status present in table are: "+actual_Status);
			Assert.assertTrue(actual_Status.equalsIgnoreCase(searchValue));
		}
	}
	//For Source
	public void validateAdvSearchForSourceEqualTo(String SearchColumn,String SearchCriteria,
			String source,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, source);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Source record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[7]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Source record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Source=op.get(i).getText();
			System.out.println("actual_Source present in table are: "+actual_Source);
			Assert.assertTrue(actual_Source.equals(source));
		}
	}
	public void validateAdvSearchForSourceNotEqualTo(String SearchColumn,String SearchCriteria,
			String source,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, source);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Source record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[7]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Source record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Source=op.get(i).getText();
			System.out.println("actual_Source present in table are: "+actual_Source);
			Assert.assertFalse(actual_Source.equals(source));
		}
	}
	public void validateAdvSearchForSourceIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Source record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[7]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Source record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Source=op.get(i).getText();
			System.out.println("actual_Source present in table are: "+actual_Source);
			Assert.assertTrue(actual_Source.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForSourceBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Source record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[7]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Source record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Source=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Source present in table are: "+actual_Source);
			Thread.sleep(3000);
			Assert.assertTrue(actual_Source.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForSourceEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Source record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[7]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Source record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Source=op.get(i).getText();
			System.out.println("actual_Source present in table are: "+actual_Source);
			Assert.assertTrue(actual_Source.contains(advSearchFor));
		}
	}
	//For Source ID
	public void validateAdvSearchForSourceIDEqualTo(String SearchColumn,String SearchCriteria,
			String sourceID,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, sourceID);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Source ID record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[8]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Source ID record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SourceID=op.get(i).getText();
			System.out.println("actual_Source ID present in table are: "+actual_SourceID);
			Assert.assertTrue(actual_SourceID.equals(sourceID));
		}
	}
	public void validateAdvSearchForSourceIDNotEqualTo(String SearchColumn,String SearchCriteria,
			String sourceID,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, sourceID);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Source ID record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[8]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Source ID record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SourceID=op.get(i).getText();
			System.out.println("actual_Source ID present in table are: "+actual_SourceID);
			Assert.assertFalse(actual_SourceID.equals(sourceID));
		}
	}
	public void validateAdvSearchForSourceIDIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Source ID record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[8]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Source ID record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SourceID=op.get(i).getText();
			System.out.println("actual_Source ID present in table are: "+actual_SourceID);
			Assert.assertTrue(actual_SourceID.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForSourceIDBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Source ID record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[8]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Source ID record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SourceID=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Source ID present in table are: "+actual_SourceID);
			Thread.sleep(3000);
			Assert.assertTrue(actual_SourceID.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForSourceIDEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Source ID record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[8]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Source ID record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SourceID=op.get(i).getText();
			System.out.println("actual_Source ID present in table are: "+actual_SourceID);
			Assert.assertTrue(actual_SourceID.contains(advSearchFor));
		}
	}
	//For Agent Name
	public void validateAdvSearchForAgentNameEqualTo(String SearchColumn,String SearchCriteria,
			String agentName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, agentName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Agent Name record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent Name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Assert.assertTrue(actual_AgentName.equals(agentName));
		}
	}
	public void validateAdvSearchForAgentNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String agentName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, agentName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Agent Name record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent Name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Assert.assertFalse(actual_AgentName.equals(agentName));
		}
	}
	public void validateAdvSearchForAgentNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Agent Name record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent Name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Assert.assertTrue(actual_AgentName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForAgentNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Agent Name record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent Name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Thread.sleep(3000);
			Assert.assertTrue(actual_AgentName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForAgentNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Agent Name record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent Name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Assert.assertTrue(actual_AgentName.contains(advSearchFor));
		}
	}
	//For Submitted By
	public void validateAdvSearchForSubmittedByEqualTo(String SearchColumn,String SearchCriteria,
			String tname,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, tname);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Submitted By record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[9]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Submitted By record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SubmittedBy=op.get(i).getText();
			System.out.println("actual_Submitted By present in table are: "+actual_SubmittedBy);
			Assert.assertTrue(actual_SubmittedBy.equals(tname));
		}
	}
	public void validateAdvSearchForSubmittedByNotEqualTo(String SearchColumn,String SearchCriteria,
			String tname,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, tname);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Submitted By record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[9]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Submitted By record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SubmittedBy=op.get(i).getText();
			System.out.println("actual_Submitted By present in table are: "+actual_SubmittedBy);
			Assert.assertFalse(actual_SubmittedBy.equals(tname));
		}
	}
	public void validateAdvSearchForSubmittedByIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Submitted By record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[9]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Submitted By record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SubmittedBy=op.get(i).getText();
			System.out.println("actual_Submitted By present in table are: "+actual_SubmittedBy);
			Assert.assertTrue(actual_SubmittedBy.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForSubmittedByBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Submitted By record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[9]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Submitted By record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SubmittedBy=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Submitted By present in table are: "+actual_SubmittedBy);
			Thread.sleep(3000);
			Assert.assertTrue(actual_SubmittedBy.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForSubmittedByEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Submitted By record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[9]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Submitted By record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SubmittedBy=op.get(i).getText();
			System.out.println("actual_Submitted By present in table are: "+actual_SubmittedBy);
			Assert.assertTrue(actual_SubmittedBy.contains(advSearchFor));
		}
	}
	//For Created
	public void validateHandleCalender(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate);
		Thread.sleep(2000);
	}
	public void validateCreatedEqualTo(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalender(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[10]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+str_actual_Date);
			SimpleDateFormat sdformat = new SimpleDateFormat("dd-MMM-yyyy");
			String expected_date=startDate+"-"+startMonth+"-"+startYear;
			System.out.println("Expected date:"+expected_date);
			Date d1 = sdformat.parse(str_actual_Date);//27
			Date d2=sdformat.parse(expected_date);//27
			Assert.assertTrue(d1.compareTo(d2) == 0);	
			Reporter.log("User is getting correct records for created on date with equal to criteria",true);
		}
	}
   public void validateCreatedBefore(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalender(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[10]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+str_actual_Date);
			SimpleDateFormat sdformat = new SimpleDateFormat("dd-MMM-yyyy");
			String expected_date=startDate+"-"+startMonth+"-"+startYear;
			System.out.println("Expected date:"+expected_date);
			Date d1 = sdformat.parse(str_actual_Date);//19,20,21
			Date d2=sdformat.parse(expected_date);//27
			System.out.println(d1.compareTo(d2) < 0);//it will return negative value//true
			//  System.out.println(d1.compareTo(d2) > 0);
			Assert.assertTrue(d1.compareTo(d2) < 0);	
			Reporter.log("User is getting correct records for created on date with before criteria",true);
		}
	}
	public void validateCreatedAfter(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalender(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[10]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+str_actual_Date);
			SimpleDateFormat sdformat = new SimpleDateFormat("dd-MMM-yyyy");
			String expected_date=startDate+"-"+startMonth+"-"+startYear;
			System.out.println("Expected date:"+expected_date);
			Date d1 = sdformat.parse(str_actual_Date);//22,23,24,26,27
			Date d2=sdformat.parse(expected_date);//21
			System.out.println(d1.compareTo(d2) > 0);//it will return positive value//true
			Assert.assertTrue(d1.compareTo(d2) > 0);	
			Reporter.log("User is getting correct records for created on date with after criteria",true);
		}
	}
	public void validateCreatedInBetween(String CreatedCriteria,String startYear,String startMonth,String startDate,
			String endYear,String endMonth,String endDate,String PageSize) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[10]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+str_actual_Date);
			SimpleDateFormat sdformat = new SimpleDateFormat("dd-MMM-yyyy");
			String expected_startdate=startDate+"-"+startMonth+"-"+startYear;
			String expected_enddate=endDate+"-"+endMonth+"-"+endYear;
			System.out.println("Expected start date:"+expected_startdate);
			System.out.println("Expected end date:"+expected_enddate);
			Date d1 = sdformat.parse(str_actual_Date);//22,23,24,26,27
			Date d2=sdformat.parse(expected_startdate);//21
			Date d3=sdformat.parse(expected_enddate);//28
			System.out.println(d1.compareTo(d2) > 0);//it will return positive value//true
			System.out.println(d1.compareTo(d3) < 0);
			Assert.assertTrue(d1.compareTo(d2) >= 0 & d1.compareTo(d3) <= 0);	
			Reporter.log("User is getting correct records for created on date with after criteria",true);
		}
	}
	public void validateCreatedNotInBetween(String CreatedCriteria,String startYear,String startMonth,String startDate,
			String endYear,String endMonth,String endDate,String PageSize) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover']/tbody/tr/td[10]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+str_actual_Date);
			SimpleDateFormat sdformat = new SimpleDateFormat("dd-MMM-yyyy");
			String expected_startdate=startDate+"-"+startMonth+"-"+startYear;
			String expected_enddate=endDate+"-"+endMonth+"-"+endYear;
			System.out.println("Expected start date:"+expected_startdate);
			System.out.println("Expected end date:"+expected_enddate);
			Date d1 = sdformat.parse(str_actual_Date);//19,20,29,30
			Date d2=sdformat.parse(expected_startdate);//21
			Date d3=sdformat.parse(expected_enddate);//28
			System.out.println(d1.compareTo(d2) < 0);//it will return positive value//true
			System.out.println(d1.compareTo(d3) > 0);
			Assert.assertTrue((d1.compareTo(d2) < 0 & d1.compareTo(d3) < 0) ||(d1.compareTo(d2) > 0 & d1.compareTo(d3) > 0));	
			Reporter.log("User is getting correct records for created on date with after criteria",true);
		}
	}
}