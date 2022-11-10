package com.ae.qa.pagesTenantAdmin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class AuditLogsPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	//public WebElements webelements = new WebElements();
	public LoginPageTA loginpage = new LoginPageTA();
	public InformationPageTA informationpage = new InformationPageTA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//span[contains(text(),'Logs')]")
	@CacheLookup
	WebElement logsTab;
	@FindBy(xpath="//a[text()='Audit Logs']")
	WebElement auditLogsTab;
	@FindBy(name = "download-logs")
	WebElement downloadLogsBtn;
	@FindBy(id = "downloadBtn")
	WebElement downloadBtn;
	@FindBy(xpath = "//div/p[contains(text(),'Audit Logs download started')]")
	WebElement successMsg;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement showColumnDrpdown;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement selectAllCheckBox;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']/div")
	WebElement columnCount;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public AuditLogsPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void downloadingAuditLogsTA() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		// Click Logs Tab
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		Reporter.log("Clicked on logs tab",true);
		js.executeScript("arguments[0].click();", auditLogsTab);
		Reporter.log("Clicked on Audit logs tab",true);
		downloadLogsBtn.click();
		Thread.sleep(2000);
		downloadBtn.click();
		Reporter.log("Clicked the download button", true);
		String actual_successMsg = successMsg.getText();
		System.out.println("Actual success msg: " + actual_successMsg);
		String expected_successMsg = Messages.downloadAuditLogs;
		System.out.println("Expected success msg: " + expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg, "Download does not started.");
		Reporter.log("Audit logs download started Successfully",true);
		Thread.sleep(15000);
		informationpage.validateSignOut();
	}

	public void checkColumnsInAuditLogsTA() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		// Click Logs Tab
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		js.executeScript("arguments[0].click();", auditLogsTab);
		Reporter.log("Clicked on Audit logs tab",true);
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
		Assert.assertEquals(sizeOfColumnsInt, 12, "All columns not selected");
		Reporter.log("All Column got displayed in records after Checking select All checkbox.",true);
		informationpage.validateSignOut();
	}

	public void deselectAllInAuditLogsTA() throws Exception {
		// Click Logs Tab
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		Thread.sleep(3000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		js.executeScript("arguments[0].click();", auditLogsTab);
		Reporter.log("Clicked on Audit logs tab",true);
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
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);//4
		Reporter.log("Selected count of No. of colums " + sizeOfColumnsInt,true);//4
		List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th"));
		Reporter.log("Total No of columns in table: " + TotalColumn.size(),true);
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			Reporter.log("Field of Columns: " + TotalColumn.get(i).getText(),true);
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Entity") || value.contains("Object Id")) {
			Reporter.log("Column Value found",true);
			Assert.assertEquals(sizeOfColumnsInt, 2, "All columns are not deselected. ");
			Reporter.log("All Options got deselected except Entity and ObjectId.",true);
		} else {
			Reporter.log("Column value not found",true);
			Assert.assertTrue(false);
		}
		informationpage.validateSignOut();
	}

	public void verifySpecificColumnTA() throws Exception {
		// Click Logs Tab
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		Thread.sleep(3000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		js.executeScript("arguments[0].click();", auditLogsTab);
		Reporter.log("Clicked on Audit logs tab",true);
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
		// select 2 more columns
		driver.findElement(By.xpath("//li/div/a/span[text()='Source']")).click();
		driver.findElement(By.xpath("//li/div/a/span[text()='Description']")).click();
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
		List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th"));
		System.out.println("Total No of columns in table: " + TotalColumn.size());
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			// String Field=TotalColumn.get(i).getText();
			Reporter.log("Field of Columns: " + TotalColumn.get(i).getText(),true);
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Entity") && value.contains("Object Id") && value.contains("Description")
				&& value.contains("Source")) {
			Reporter.log("Column Value found",true);
			Assert.assertTrue(true);
			Assert.assertEquals(sizeOfColumnsInt, TotalColumn.size(), "All columns selected not found in table.");
			Reporter.log("All columns selected found in table with Entity and ObjectId.",true);
		} else {
			Reporter.log("Column value not found",true);
			Assert.assertTrue(false);
		}
		informationpage.validateSignOut();
	}
	public void validateAuditLogsPageTA(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(logsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		js.executeScript("arguments[0].click();", auditLogsTab);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpage.validateSignOut();
	}

	/*	public void checkLogs(String serverURL,String cleanUpHours) throws Exception {
		systemsettingspage.EditCleanUpRequest(serverURL,cleanUpHours);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", logsTab);
		Thread.sleep(2000);
		ArrayList<String> actual_content = new ArrayList<String>();
		ArrayList<String> expected_content=new ArrayList<String>();
		expected_content.add("LOGOUT");
		expected_content.add("UPDATE");
		expected_content.add("AUTHENTICATE");
		for (int i = 3; i <= 5; i++) {
		List<WebElement> operation_list = driver.findElements(By.xpath("//table/tr["+i+"]/td[4]"));

		for(WebElement element:operation_list) {
			String element_value=element.getText();
			Reporter.log(element_value,true);
			actual_content.add(element_value);
		}
		System.out.println("Actual content :"+actual_content);
	}
		if(actual_content.equals(expected_content)) {
			Reporter.log("Operations in audit logs validated in table",true);
			Assert.assertTrue(true, "Operations validated");
		} else {
			Assert.assertTrue(false, "Operation in audit logs not validated in table");
		}

}*/
	public void validateAdvSearch() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		js.executeScript("arguments[0].click();", auditLogsTab);
		wb.validateClickOnAdvanceSearch();
	}

	public void validateEntityDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Entity=op.get(i).getText();
			System.out.println("actual_Entity present in table are: "+actual_Entity);
			Assert.assertTrue(actual_Entity.equalsIgnoreCase(searchValue));
		}
	}
	public void validateEntityDropdownNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Entity=op.get(i).getText();
			System.out.println("actual_Entity present in table are: "+actual_Entity);
			Assert.assertFalse(actual_Entity.equalsIgnoreCase(searchValue));
		}
	}
	public void validateSourceDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[5]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Source=op.get(i).getText();
			System.out.println("actual_Source present in table are: "+actual_Source);
			Thread.sleep(2000);
			Assert.assertTrue(actual_Source.equalsIgnoreCase(searchValue));
		}
	}

	public void validateSourceDropdownNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[5]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Source=op.get(i).getText();
			System.out.println("actual_Source present in table are: "+actual_Source);
			Assert.assertFalse(actual_Source.equalsIgnoreCase(searchValue));
		}
	}
	public void validateAdvSearchForUserNameEqualTo(String SearchColumn,String SearchCriteria,
			String userName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, userName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_UserName=op.get(i).getText();
			System.out.println("actual_Tenant User Name present in table are: "+actual_UserName);
			Assert.assertTrue(actual_UserName.equals(userName));
		}
	}
	public void validateAdvSearchForUserNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String userName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, userName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_UserName=op.get(i).getText();
			System.out.println("actual_Tenant User Name present in table are: "+actual_UserName);
			Assert.assertFalse(actual_UserName.equals(userName));
		}
	}
	public void validateAdvSearchForUserNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_UserName=op.get(i).getText();
			System.out.println("actual_Tenant User Name present in table are: "+actual_UserName);
			Assert.assertTrue(actual_UserName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForUserNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_UserName=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Tenant User Name present in table are: "+actual_UserName);
			Thread.sleep(3000);
			Assert.assertTrue(actual_UserName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForUserNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_UserName=op.get(i).getText();
			System.out.println("actual_Tenant User Name present in table are: "+actual_UserName);
			Assert.assertTrue(actual_UserName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForSourceIPEqualTo(String SearchColumn,String SearchCriteria,
			String sourceIP,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, sourceIP);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SourceIP=op.get(i).getText();
			System.out.println("actual_Source IP present in table are: "+actual_SourceIP);
			Assert.assertTrue(actual_SourceIP.equals(sourceIP));
		}
	}
	public void validateAdvSearchForSourceIPNotEqualTo(String SearchColumn,String SearchCriteria,
			String sourceIP,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, sourceIP);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SourceIP=op.get(i).getText();
			System.out.println("actual_Source IP present in table are: "+actual_SourceIP);
			Assert.assertFalse(actual_SourceIP.equals(sourceIP));
		}
	}
	public void validateAdvSearchForSourceIPIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SourceIP=op.get(i).getText();
			System.out.println("actual_Source IP present in table are: "+actual_SourceIP);
			Assert.assertTrue(actual_SourceIP.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForSourceIPBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SourceIP=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Source IP present in table are: "+actual_SourceIP);
			Thread.sleep(3000);
			Assert.assertTrue(actual_SourceIP.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForSourceIPEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_SourceIP=op.get(i).getText();
			System.out.println("actual_Source IP present in table are: "+actual_SourceIP);
			Assert.assertTrue(actual_SourceIP.contains(advSearchFor));
		}
	}
	public void validateOperationDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Operation=op.get(i).getText();
			System.out.println("actual_Operations present in table are: "+actual_Operation);
			Thread.sleep(2000);
			Assert.assertTrue(actual_Operation.equalsIgnoreCase(searchValue));
		}
	}

	public void validateOperationDropdownNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Operation=op.get(i).getText();
			System.out.println("actual_Operation present in table are: "+actual_Operation);
			Assert.assertFalse(actual_Operation.equalsIgnoreCase(searchValue));
		}
	}
	public void validateHandleCalender(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		js.executeScript("arguments[0].click();", auditLogsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate);
		Thread.sleep(2000);
	}
	public void validateCreatedEqualTo(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalender(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[8]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[8]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[8]"));
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
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		js.executeScript("arguments[0].click();", auditLogsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[8]"));
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
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", logsTab);
		js.executeScript("arguments[0].click();", auditLogsTab);;
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[8]"));
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
	public void validateStatusDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[7]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[7]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Status=op.get(i).getText();
			System.out.println("actual_Status present in table are: "+actual_Status);
			Assert.assertFalse(actual_Status.equalsIgnoreCase(searchValue));
		}
	}
	public void validateLogLevelDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		driver.findElement(By.xpath("//li/div/a/span[text()='Log Level']")).click();
		showColumnDrpdown.click();
		Thread.sleep(2000);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[8]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_LogLevel=op.get(i).getText();
			System.out.println("actual_Log Level present in table are: "+actual_LogLevel);
			Thread.sleep(2000);
			Assert.assertTrue(actual_LogLevel.equalsIgnoreCase(searchValue));
		}
	}

	public void validateLogLevelDropdownNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		showColumnDrpdown.click();
		driver.findElement(By.xpath("//li/div/a/span[text()='Log Level']")).click();
		showColumnDrpdown.click();
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table']/table/tr/td[8]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Audit record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_LogLevel=op.get(i).getText();
			System.out.println("actual_Log Level present in table are: "+actual_LogLevel);
			Assert.assertFalse(actual_LogLevel.equalsIgnoreCase(searchValue));
		}
	}
	
}
