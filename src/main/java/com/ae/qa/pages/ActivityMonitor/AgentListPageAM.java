package com.ae.qa.pages.ActivityMonitor;

import java.util.ArrayList;
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
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.CommonWebElements;

public class AgentListPageAM extends TestBase{
	public LoginPageTA loginpageta = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 300);
	public InformationPageTA informationpageta=new InformationPageTA();
	public AgentListPageTA agentlistpageta = new AgentListPageTA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath="//span[text()='Agents']")
	WebElement AgentsTab;
	@FindBy(xpath="//a[text()='Agent List']")
	WebElement AgentListTab;
	@FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement showColumnDrpdown;
	@FindBy(xpath="//span[@class='mul-checkmark']")
	WebElement selectAllCheckBox;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']/div")
	WebElement columnCount;
	@FindBy(id ="btnAssisted")
	WebElement AssistedAgentTab;

	public AgentListPageAM()
	{
		PageFactory.initElements(driver, this);
	}

	public void validateAgentDetailsAM(String AgentName) throws Exception{
		//agentlistpageta.downloadAgent();
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(5000);
		String Actual_AgentName = driver.findElement(By.xpath("//table/tr/td/span[text()='" +AgentName + "']")).getText();
		System.out.println("Actual Agent Name:- "+Actual_AgentName);
		String Expected_AgentName=prop.getProperty("AgentName");
		System.out.println("Expected Agent Name:-"+Expected_AgentName);
		if(Actual_AgentName.contentEquals(Expected_AgentName)){
			Assert.assertTrue(true);
			Reporter.log("Agent details is verified successfully.",true);
		}else {
			Assert.assertTrue(false);
			Reporter.log("Agent deatils are not verified successfully.",true);
		}
		informationpageta.validateSignOut();
	}
	public void checkColumnsInAgentListAM() throws Exception {
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to AgentList tab",true);
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
		Assert.assertEquals(sizeOfColumnsInt, 7, "All columns not selected");
		Reporter.log("All Column got displayed in records after Checking select All checkbox.",true);
		informationpageta.validateSignOut();
	}
	public void deselectAllInAgentListAM() throws Exception {
		// Click Logs Tab
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to AgentList tab",true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			Reporter.log("Clicked on Select All and resulted into deselected all columns.",true);
		} else {
			for (int i = 1; i <= 2; i++) {
				selectAllCheckBox.click();
			}
			Reporter.log("Select All Checkbox is not already selected, Hence selected twice to deselect it.",true);
		}
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);//3
		Reporter.log("Selected count of No. of colums " + sizeOfColumnsInt,true);//3
		List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th/span"));
		Reporter.log("Total No of columns in table: " + TotalColumn.size(),true);
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			Reporter.log("Field of Columns: " + TotalColumn.get(i).getText(),true);
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Agent Name") || value.contains("Status") || value.contains("Resource Utilization")) {
			Reporter.log("Column Value found",true);
			Assert.assertEquals(sizeOfColumnsInt, 3, "All columns are not deselected. ");
			Reporter.log("All Options got deselected except Agent Name,Status and Resource Utilization.",true);
		} else {
			Reporter.log("Column value not found",true);
			Assert.assertTrue(false);
		}
		informationpageta.validateSignOut();
	}
	public void SpecificColumnInAgentListAM() throws Exception {
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to AgentList tab",true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			Reporter.log("Clicked on Select All and resulted into deselected all columns.",true);
		} else {
			for (int i = 1; i <= 2; i++) {
				selectAllCheckBox.click();
				Thread.sleep(3000);
			}
			Reporter.log("Select All Checkbox is not already selected, Hence selected twice to deselect it.",true);

		}
		// select 2 more columns
		driver.findElement(By.xpath("//a/span[text()='Execution Threads']")).click();
		driver.findElement(By.xpath("//a/span[text()='Executing Workflows']")).click();
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
		List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th/span"));
		System.out.println("Total No of columns in table: " + TotalColumn.size());
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			// String Field=TotalColumn.get(i).getText();
			Reporter.log("Field of Columns: " + TotalColumn.get(i).getText(),true);
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Agent Name") && value.contains("Execution Threads") && value.contains("Resource Utilization")
				&& value.contains("Status") && value.contains("Executing Workflows")) {
			Reporter.log("Column Value found",true);
			Assert.assertTrue(true);
			Assert.assertEquals(sizeOfColumnsInt, TotalColumn.size(), "All columns selected not found in table.");
			Reporter.log("All columns selected found in table.",true);
		} else {
			Reporter.log("Column value not found",true);
			Assert.assertTrue(false);
		}
		informationpageta.validateSignOut();
	}
	public void validateAssistedAgentDetailsAM(String AgentName) throws Exception{
		//agentlistpageta.validateDeleteAgent(AgentName);
		//agentlistpageta.downloadAssistedAgent();
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agents Tab",true);
		Thread.sleep(5000);
		String Actual_AssitedAgentName = driver.findElement(By.xpath("//table/tr/td/span[text()='" +AgentName + "']")).getText();
		System.out.println("Actual Agent Name:- "+Actual_AssitedAgentName);
		String Expected_AssistedAgentName=prop.getProperty("AgentName");
		System.out.println("Expected Agent Name:-"+Expected_AssistedAgentName);
		if(Actual_AssitedAgentName.contentEquals(Expected_AssistedAgentName)){
			Assert.assertTrue(true);
			Reporter.log("Assisted Agent details is verified successfully.",true);
		}else {
			Assert.assertTrue(false);
			Reporter.log("Assisted Agent details are not verified successfully.",true);
		}
		informationpageta.validateSignOut();

	}
	public void validateAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		js.executeScript("arguments[0].click();", AgentListTab);
		wb.validateClickOnAdvanceSearch();
	}

	public void validateAdvSearchForAgentNameEqualTo(String SearchColumn,String SearchCriteria,
			String agentName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,agentName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Thread.sleep(2000);
			Assert.assertTrue(actual_AgentName.contentEquals(agentName));
		}
	}
	public void validateAdvSearchForAgentNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String agentName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, agentName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Assert.assertFalse(actual_AgentName.equals(agentName));
		}
	}
	public void validateAdvSearchForAgentNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Assert.assertTrue(actual_AgentName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForAgentNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
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
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Assert.assertTrue(actual_AgentName.contains(advSearchFor));
		}
	}
	public void validateStatusDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[5]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[5]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Status=op.get(i).getText();
			System.out.println("actual_Status present in table are: "+actual_Status);
			Thread.sleep(2000);
			Assert.assertFalse(actual_Status.equalsIgnoreCase(searchValue));
		}
	}
	public void HandleEnterFieldValue(String SearchColumn,String SearchCriteria,String SearchFor,String PageSize)
			throws Exception {
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,SearchFor);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
	}
	public void validateAdvSearchForExecutionThreadEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Execution Thread : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected ID is " + AdvSearchFor, true);
			Assert.assertEquals(actual_EThread, AdvSearchFor,
					"Mismatch in actual and expected ID of advance search of request page");
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForExecutionThreadNotEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Execution Thread : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected ID is " + AdvSearchFor, true);
			Assert.assertFalse(actual_EThread.equals(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForExecutionThreadLessThan(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Execution Thread : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();
			int actualEThread= Integer. parseInt(actual_EThread);
			int expectedEThread= Integer. parseInt(AdvSearchFor);
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actualEThread < expectedEThread);
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForExecutionThreadGreaterThan(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Execution Thread : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();
			int actualEThread= Integer. parseInt(actual_EThread);
			int expectedEThread= Integer. parseInt(AdvSearchFor);
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actualEThread > expectedEThread);
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForExecutionThreadInRange(String SearchColumn, String SearchCriteria, String SearchField1,
			String SearchField2,String PageSize) throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchFieldForRange(SearchColumn, SearchCriteria,SearchField1,SearchField2);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
		// Verify data in table now//2-4
		Reporter.log("Below validation is to validate Execution Thread : " + SearchCriteria
				+ " of "+SearchField1+"-"+SearchField2+" is visible in webtable or not", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();//2,3,4
			int actualEThread= Integer. parseInt(actual_EThread);
			int expected_SearchFiledEThread1= Integer. parseInt(SearchField1);
			int expected_SearchFiledEThread2= Integer. parseInt(SearchField2);
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected Execution Thread is in range of " + expected_SearchFiledEThread1+"-"+expected_SearchFiledEThread2, true);
			Assert.assertTrue(actualEThread >= expected_SearchFiledEThread1 && actualEThread <= expected_SearchFiledEThread2 );
		} 
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForExecutionThreadNotInRange(String SearchColumn, String SearchCriteria, String SearchField1,
			String SearchField2, String PageSize) throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchFieldForRange(SearchColumn, SearchCriteria,SearchField1,SearchField2);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
		// Verify data in table now//2-4
		Reporter.log("Below validation is to validate Execution Thread : " + SearchCriteria
				+ " of "+SearchField1+"-"+SearchField2+" is visible in webtable or not", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();//1,5,6,7
			int actualEThread= Integer. parseInt(actual_EThread);
			int expected_SearchFiledEThread1= Integer. parseInt(SearchField1);
			int expected_SearchFiledEThread2= Integer. parseInt(SearchField2);
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected Execution Thread is in range of " + expected_SearchFiledEThread1+"-"+expected_SearchFiledEThread2, true);
			Assert.assertTrue(actualEThread < expected_SearchFiledEThread1 || actualEThread > expected_SearchFiledEThread2 );
		} 
		informationpageta.validateSignOut();
	}
}