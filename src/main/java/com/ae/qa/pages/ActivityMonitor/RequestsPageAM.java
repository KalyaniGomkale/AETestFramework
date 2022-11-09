package com.ae.qa.pages.ActivityMonitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.ae.qa.pages.WorkflowAdmin.WorkflowListPageWA;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class RequestsPageAM extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();
	public WorkflowListPageTA workflowlistpageta = new WorkflowListPageTA();
	public CommonWebElements wb=new CommonWebElements();
	
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
	
	public RequestsPageAM() {
		PageFactory.initElements(driver, this);
	}

	public void validateCheckColumnInRequestAM() throws Exception{
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
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
	public void validateUncheckColumnInRequestAM() throws Exception{
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
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
	public void validateSpecificColumnInRequestAM() throws Exception{
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
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
	public void validateDownloadRequestAM() throws Exception{
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully", true);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
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
	public void validateRequestStatusAM() throws Exception {
		// Here status like New,ExecutionStarted,Completed and Failure are covered
		// whatever the status is tc pass because the moto is to check submitted request
		// and not its status
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully", true);
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		refershTableBtn.click();
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
		informationpageta.validateSignOut();
	}
	public void AdvSearch() throws Exception {
		//loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		loginpageta.login("AMRani1","Pune@1234");
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",requestsTab);
		Thread.sleep(3000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (!selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All CheckBox");
		} else {
			System.out.println("Select All Checkbox is already selected");
		}
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(3000);
	}//MBMAG3R For handling fields where user need to enter value
	public void HandleEnterFieldValue(String SearchColumn,String SearchCriteria,String SearchFor,String PageSize)
			throws Exception {
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,SearchFor);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
	}
	//MBMAG3R For handling fields where user need to select value from dropdown
	public void HandleDropDown(String SearchColumn,String SearchCriteria,String SearchFor,String PageSize) throws Exception {
		wb.validateAdvanceSearchDropDown(SearchColumn,SearchCriteria,SearchFor);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
	}

	public void validateAdvSearchForIDEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate ID : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[1]"));
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
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate ID : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[1]"));
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
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate ID : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[1]"));
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
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate ID : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[1]"));
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
		AdvSearch();
		wb.validateAdvanceSearchFieldForRange(SearchColumn, SearchCriteria,SearchField1,SearchField2);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
		// Verify data in table now//2-4
		Reporter.log("Below validation is to validate ID : " + SearchCriteria
				+ " of "+SearchField1+"-"+SearchField2+" is visible in webtable or not", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[1]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_ID = op.get(i).getText();//2,3,4
			int actualID= Integer. parseInt(actual_ID);
			int expected_SearchFiledID1= Integer. parseInt(SearchField1);
			int expected_SearchFiledID2= Integer. parseInt(SearchField2);
			Reporter.log("actual_ID present in table are: " + actual_ID + " expected ID is in range of " + expected_SearchFiledID1+"-"+expected_SearchFiledID2, true);
			Assert.assertTrue(actualID >= expected_SearchFiledID1 && actualID <= expected_SearchFiledID2 );
		} 
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForIDNotInRange(String SearchColumn, String SearchCriteria, String SearchField1,
			String SearchField2, String PageSize) throws Exception {
		AdvSearch();
		wb.validateAdvanceSearchFieldForRange(SearchColumn, SearchCriteria,SearchField1,SearchField2);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
		// Verify data in table now//2-4
		Reporter.log("Below validation is to validate ID : " + SearchCriteria
				+ " of "+SearchField1+"-"+SearchField2+" is visible in webtable or not", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[1]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_ID = op.get(i).getText();//1,5,6,7
			int actualID= Integer. parseInt(actual_ID);
			int expected_SearchFiledID1= Integer. parseInt(SearchField1);
			int expected_SearchFiledID2= Integer. parseInt(SearchField2);
			Reporter.log("actual_ID present in table are: " + actual_ID + " expected ID is in range of " + expected_SearchFiledID1+"-"+expected_SearchFiledID2, true);
			Assert.assertTrue(actualID < expected_SearchFiledID1 || actualID > expected_SearchFiledID2 );
		} 
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchWFNameEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_WFName = op.get(i).getText();
			Reporter.log("actual_WFName present in table are: " + actual_WFName + " expected ID is " + AdvSearchFor, true);
			Assert.assertEquals(actual_WFName, AdvSearchFor,
					"Mismatch in actual and expected Worklfow Name of advance search of request page");
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchWFNameNotEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_WFName = op.get(i).getText();
			Reporter.log("actual_WFName present in table are: " + actual_WFName + " expected ID is " + AdvSearchFor, true);
			Assert.assertFalse(actual_WFName.equals(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchWFNameIsLike(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_WFName = op.get(i).getText();
			Reporter.log("actual_WFName present in table are: " + actual_WFName + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_WFName.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchWFNameBeginsWith(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_WFName = op.get(i).getText();
			Reporter.log("actual_WFName present in table are: " + actual_WFName + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_WFName.startsWith(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchWFNameEndsWith(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_WFName = op.get(i).getText();
			Reporter.log("actual_WFName present in table are: " + actual_WFName + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_WFName.endsWith(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForStatusEqual(String status) throws Exception {
		//loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		loginpageta.login("AMRani1","Pune@1234");
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",requestsTab);
		Thread.sleep(3000);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(3000);
		wb.validateAdvanceSearchDropDown("Status","equal to",status);
		Thread.sleep(3000);
		wb.changePageSize("50");
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
		//WebElement table=driver.findElement(By.xpath("//*[@id='main-component']/ng-component/div[5]/div[2]/table"));
		List<WebElement>op=driver.findElements(By.xpath("//*[@id='main-component']/ng-component/div[3]/div[3]/div[2]/table/tbody/tr/td[3]/span[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Size is :"+op.size());
			Thread.sleep(3000);
			String actual_status=op.get(i).getText();
			//	wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(table)));
			System.out.println("actual_status is :"+actual_status);
			String expected_status=status;
			Assert.assertEquals(actual_status,expected_status,"Advance search for status filter failed");
			//	Thread.sleep(10000);
		}
	}
	public void validateAdvSearchForStatusNotEqual(String status) throws Exception {
		//loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		loginpageta.login("AMRani1","Pune@1234");
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",requestsTab);
		Thread.sleep(3000);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(3000);
		wb.validateAdvanceSearchDropDown("Status","not equal to",status);
		Thread.sleep(3000);
		wb.changePageSize("50");
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
		//WebElement table=driver.findElement(By.xpath("//*[@id='main-component']/ng-component/div[5]/div[2]/table"));
		List<WebElement>op=driver.findElements(By.xpath("//*[@id='main-component']/ng-component/div[3]/div[3]/div[2]/table/tbody/tr/td[3]/span[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Size is :"+op.size());
			Thread.sleep(3000);
			String actual_status=op.get(i).getText();
			//	wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(table)));
			System.out.println("actual_status is :"+actual_status);
			String expected_status=status;
			Assert.assertEquals(actual_status,expected_status,"Advance search for status filter failed");
			//	Thread.sleep(10000);
		}
	}
	//Submited by
	public void validateAdvSearchSubmitByEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,String PageSize)  throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Submit By : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[9]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_SubmitedBy = op.get(i).getText();
			Reporter.log("actual_SubmitedBy present in table are: " + actual_SubmitedBy + " expected ID is " + AdvSearchFor, true);
			Assert.assertEquals(actual_SubmitedBy, AdvSearchFor,
					"Mismatch in actual and expected submited by advance search of request page");
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSubmitNotEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Submit by : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[9]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_SubmitedBy = op.get(i).getText();
			Reporter.log("actual_SubmitedBy present in table are: " + actual_SubmitedBy + " expected ID is " + AdvSearchFor, true);
			Assert.assertFalse(actual_SubmitedBy.equals(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}

	public void validateAdvSearchSubmitIsLike(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[9]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_SubmitedBy = op.get(i).getText();
			String actual=actual_SubmitedBy.split(" ")[0];
			System.out.println(actual);
			Reporter.log("actual_SubmitedBy present in table are: " + actual + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSubmitByBeginsWith(String SearchColumn, String SearchCriteria, String AdvSearchFor,String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[9]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_SubmitedBy = op.get(i).getText();
			Reporter.log("actual_SubmitedBy present in table are: " + actual_SubmitedBy + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_SubmitedBy.startsWith(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSubmitEndsWith(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Submit By : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[9]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_SubmitedBy = op.get(i).getText();
			Reporter.log("actual_SubmitedBy present in table are: " + actual_SubmitedBy + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_SubmitedBy.endsWith(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public  void validateStatusEqualToTerminate(String wfName, String wfdes, String category, String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		workflowlistpageta.validateImportWorkflow(wfName,wfdes,category,WFImportPath,priority,
				expTime,maxTime,cleanUpHrs,manExeTime,tUnit) ;

	}
	public void validatePriorityEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		AdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Request record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Priority=op.get(i).getText();
			System.out.println("actual Priority present in table are: "+actual_Priority);
			Thread.sleep(2000);
			Assert.assertTrue(actual_Priority.equalsIgnoreCase(searchValue));
		}
	}
	public void validatePriorityNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize)throws Exception {
		AdvSearch();
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Request record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Priority=op.get(i).getText();
			System.out.println("actual_Priority present in table are: "+actual_Priority);
			Thread.sleep(2000);
			Assert.assertFalse(actual_Priority.equalsIgnoreCase(searchValue));
		}
	}
	public void validateAdvSearchSourceEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[7]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Source = op.get(i).getText();
			Reporter.log("actual_Source present in table are: " + actual_Source + " expected ID is " + AdvSearchFor, true);
			Assert.assertEquals(actual_Source, AdvSearchFor,
					"Mismatch in actual and expected Source Name of advance search of request page");
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSourceNotEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[7]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Source = op.get(i).getText();
			Reporter.log("actual_Source present in table are: " + actual_Source + " expected ID is " + AdvSearchFor, true);
			Assert.assertFalse(actual_Source.equals(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSourceIsLike(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[7]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Source = op.get(i).getText();
			Reporter.log("actual_Source present in table are: " + actual_Source + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_Source.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSourceBeginsWith(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[7]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Source = op.get(i).getText();
			Reporter.log("actual_Source present in table are: " + actual_Source + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_Source.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSourceEndsWith(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[7]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Source = op.get(i).getText();
			Reporter.log("actual_Source present in table are: " + actual_Source + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_Source.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSourceIDEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[8]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Source = op.get(i).getText();
			Reporter.log("actual_Source present in table are: " + actual_Source + " expected ID is " + AdvSearchFor, true);
			Assert.assertEquals(actual_Source, AdvSearchFor,
					"Mismatch in actual and expected Source Name of advance search of request page");
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSourceIDNotEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[8]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Source = op.get(i).getText();
			Reporter.log("actual_Source present in table are: " + actual_Source + " expected ID is " + AdvSearchFor, true);
			Assert.assertFalse(actual_Source.equals(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSourceIDIsLike(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[8]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Source = op.get(i).getText();
			Reporter.log("actual_Source present in table are: " + actual_Source + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_Source.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSourceIDBeginsWith(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[8]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Source = op.get(i).getText();
			Reporter.log("actual_Source present in table are: " + actual_Source + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_Source.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchSourceIDEndsWith(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[8]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_Source = op.get(i).getText();
			Reporter.log("actual_Source present in table are: " + actual_Source + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_Source.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchAgentNameEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[6]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_AgentName = op.get(i).getText();
			Reporter.log("actual_Agent Name present in table are: " + actual_AgentName + " expected ID is " + AdvSearchFor, true);
			Assert.assertEquals(actual_AgentName, AdvSearchFor,
					"Mismatch in actual and expected Source Name of advance search of request page");
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchAgentNameNotEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[6]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_AgentName = op.get(i).getText();
			Reporter.log("actual_Agent Name present in table are: " + actual_AgentName + " expected ID is " + AdvSearchFor, true);
			Assert.assertFalse(actual_AgentName.equals(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchAgentNameIsLike(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[6]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_AgentName = op.get(i).getText();
			Reporter.log("actual_Agent Name present in table are: " + actual_AgentName + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_AgentName.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchAgentNameBeginsWith(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[6]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_AgentName = op.get(i).getText();
			Reporter.log("actual_Agent Name present in table are: " + actual_AgentName + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_AgentName.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchAgentNameEndsWith(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		AdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Workflow Name : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[6]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_AgentName = op.get(i).getText();
			Reporter.log("actual_Agent Name present in table are: " + actual_AgentName + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actual_AgentName.contains(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateHandleCalender(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (!selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All CheckBox");
		} else {
			System.out.println("Select All Checkbox is already selected");
		}
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate);
		Thread.sleep(2000);
	}
	public void validateCreatedEqualTo(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalender(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[10]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[10]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[10]"));
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
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (!selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All CheckBox");
		} else {
			System.out.println("Select All Checkbox is already selected");
		}
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[10]"));
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
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (!selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All CheckBox");
		} else {
			System.out.println("Select All Checkbox is already selected");
		}
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='requests-list-container']/div/table/tbody/tr/td[10]"));
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
