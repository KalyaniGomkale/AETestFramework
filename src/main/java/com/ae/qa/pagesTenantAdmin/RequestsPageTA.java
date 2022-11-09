package com.ae.qa.pagesTenantAdmin;

import java.util.ArrayList;
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
import com.ae.qa.util.Messages;

public class RequestsPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();
	public WorkflowListPageTA workflowlistpageta = new WorkflowListPageTA();
	public WorkflowAssignmentPageTA workflowassignmentta=new WorkflowAssignmentPageTA();
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
 }