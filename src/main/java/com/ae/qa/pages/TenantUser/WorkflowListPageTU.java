package com.ae.qa.pages.TenantUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.ae.qa.pages.WebElements;
import com.ae.qa.pagesTenantAdmin.CategoriesPageTA;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class WorkflowListPageTU extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();
	public WorkflowListPageTA workflowpageta = new WorkflowListPageTA();
	public CategoriesPageTA categoriespageta = new CategoriesPageTA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath="//span[text()='Workflows']")
	WebElement workflowTab;
	@FindBy(xpath = "//a[text()='Workflow List']")
	WebElement workflowListTab;
	@FindBy(xpath="//a[text()='Permissions']")
	WebElement permissionsTab;
	@FindBy(id="selectType")
	WebElement selectTypeDropdown;
	@FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement memberTypeDropdown;
	@FindBy(xpath="//input[@name='search']")
	WebElement searchBar;
	@FindBy(xpath="//span[@class='mul-checkmark']")
	WebElement inputCheckbox;
	@FindBy(xpath="//button[@name='submit']")
	WebElement saveBtn;
	@FindBy(xpath="(//button[@name='save'])[2]")
	WebElement saveBtn1;
	@FindBy(xpath="//span[@class='fa fa-caret-right']")
	WebElement configParamBar;
	@FindBy(xpath="//span[@class='fa fa-caret-right']")
	WebElement editConfigParamBar;
	@FindBy(xpath="//input[@id='a']")
	WebElement configParamInput;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement success_msg;
	@FindBy(xpath="//div[@class='move-workflows']/select")
	WebElement moveWFDropdwn;
	@FindBy(xpath="//button[@name='move' and @class='btn btn-primary']")
	WebElement moveBtn;
	@FindBy(xpath="//button[@title='Workflow View']")
	WebElement wfViewButton;
	@FindBy(xpath="//button[@title='User View']")
	WebElement userViewButton;
	@FindBy(xpath="(//span[@class='dropdown-toggle fa fa-search floating-search'])[2]")
	WebElement rightTabSearchBar;
	@FindBy(xpath="(//span[@class='dropdown-toggle fa fa-search floating-search'])[1]")
	WebElement leftTabSearchBar;
	@FindBy(xpath="//label/i[@class='fa fa-user']")
	WebElement tUser;

	public WorkflowListPageTU() {
		PageFactory.initElements(driver, this);
	}
	public void assignPermissionsUserWF(String Username,String wfName) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab clicked",true);
		Thread.sleep(4000);
		//For Tenant user permissions
		wfViewButton.click();
		Reporter.log("Workflow view button is clicked",true);
		Thread.sleep(2000);
		rightTabSearchBar.click();
		Reporter.log("Right Search Bar is clicked",true);
		WebElement searchBarField = driver.findElement(By.id("r-search"));
		searchBarField.sendKeys(Username);
		Thread.sleep(5000);
		//For View Permissions for Tenant User
		WebElement viewPermission = driver.findElement(By.xpath("//span/label/del[contains(text(),'View')]"));
		js.executeScript("arguments[0].click();", viewPermission);
		Reporter.log("View Permission for Tenant user is Selected",true);
		//For Run Permissions for Tenant User
		WebElement runPermission = driver.findElement(By.xpath("//span/label/del[contains(text(),'Run')]"));
		js.executeScript("arguments[0].click();", runPermission);
		Reporter.log("Run Permission for Tenant user is Selected",true);
		//For Modify Permissions for Tenant User
		WebElement modifyPermission = driver.findElement(By.xpath("//span/label/del[contains(text(),'Modify')]"));
		js.executeScript("arguments[0].click();", modifyPermission);
		Reporter.log("Modify Permission for Tenant user is Selected",true);
		Thread.sleep(2000);
		saveBtn1.click();
		Reporter.log("Save button is clicked",true);
		String Actual_SuccessMsg = success_msg.getText();
		System.out.println("Actual Message for User Permissions : " + Actual_SuccessMsg);
		String Expected_SuccessMsg = Messages.permissionsSuccessMsg;
		System.out.println("Expected Message for User Permissions :"+Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Permissions not updated successfully");
		informationpageta.validateSignOut();
		//For workflow permissions
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Categories tab clicked",true);
		Thread.sleep(4000);
		userViewButton.click();
		Reporter.log("User view button is clicked",true);
		Thread.sleep(2000);
		leftTabSearchBar.click();
		Reporter.log("Left Search Bar is clicked",true);
		WebElement searchBarField1 = driver.findElement(By.id("l-search"));
		searchBarField1.sendKeys(Username);
		tUser.click();
		Thread.sleep(5000);
		rightTabSearchBar.click();
		Reporter.log("Search Bar is clicked",true);
		WebElement searchBarField2 = driver.findElement(By.id("r-search"));
		searchBarField2.sendKeys(wfName);
		Thread.sleep(5000);
		//For View Permissions for Workflow
		WebElement viewWFPermission = driver.findElement(By.xpath("//span/label/del[contains(text(),'View')]"));
		js.executeScript("arguments[0].click();", viewWFPermission);
		Reporter.log("View Permission for Workflow is Selected",true);
		//For Run Permissions for Workflow
		WebElement runWFPermission = driver.findElement(By.xpath("//span/label/del[contains(text(),'Run')]"));
		js.executeScript("arguments[0].click();", runWFPermission);
		Reporter.log("Run Permission for Workflow is Selected",true);
		//For Modify Permissions for Workflow
		WebElement modifyWFPermission = driver.findElement(By.xpath("//span/label/del[contains(text(),'Modify')]"));
		js.executeScript("arguments[0].click();", modifyWFPermission);
		Reporter.log("Modify Permission for Workflow is Selected",true);
		Thread.sleep(2000);
		saveBtn1.click();
		Reporter.log("Save button is clicked",true);
		String Actual_SuccessMsg1 = success_msg.getText();
		System.out.println("Actual Message for Workflow permissions : " + Actual_SuccessMsg1);
		String Expected_SuccessMsg1 = Messages.permissionsSuccessMsg;
		System.out.println("Expected Message for Workflow permissions :"+Expected_SuccessMsg1);
		Assert.assertEquals(Actual_SuccessMsg1, Expected_SuccessMsg1, "Permissions not updated successfully");
		informationpageta.validateSignOut();	
	}


	public void validateEditWorkflowTU(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String ConfigParamString,
			String EditConfigParamString,String Username) throws Exception{
		workflowpageta.ImportForm(wfName, wfdes, category, WFImportPath, priority, expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		configParamBar.click();
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
		assignPermissionsUserWF(Username,wfName);
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		Reporter.log("Workflow tab is clicked", true);
		Boolean WfName = driver.findElement(By.xpath("//table/tr/td[contains(@title,'"+wfName+"')]")).isDisplayed();
		if(WfName){
			Assert.assertTrue(WfName, "Workflow is not present in table");
			Reporter.log("Workflow is present in table.", true);
		}else {
			Reporter.log("Workflow is not present in table", true);
			Assert.assertTrue(false);
		}
		WebElement edit_btn = driver.findElement(By.xpath("//table/tr/td[@title='"+wfName+"']/../td/span[@title='Edit Workflow']"));
		js.executeScript("arguments[0].click();", edit_btn);
		Thread.sleep(3000);
		Reporter.log("Edit button is Clicked",true);
		editConfigParamBar.click();
		Reporter.log("Config Parameter is clicked",true);
		Thread.sleep(3000);
		configParamInput.sendKeys(EditConfigParamString);
		Reporter.log("Config Parameter is entered",true);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_WFEditSuccessMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_WFEditSuccessMsg);
		String Expected_WFEditSuccessMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_WFEditSuccessMsg);
		Assert.assertEquals(Actual_WFEditSuccessMsg, Expected_WFEditSuccessMsg, "Workflow not edited successfully");
		Reporter.log("Workflow edited successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowTab);
		wb.validateClickOnAdvanceSearch();
	}

	public void validateAdvSearchForWFNameEqualTo(String SearchColumn,String SearchCriteria,
			String wfName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,wfName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFName=op.get(i).getText();
			System.out.println("actual_Workflow Name present in table are: "+actual_WFName);
			Thread.sleep(2000);
			Assert.assertTrue(actual_WFName.contentEquals(wfName));
		}
	}
	public void validateAdvSearchForWFNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String wfName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, wfName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFName=op.get(i).getText();
			System.out.println("actual_Workflow Name present in table are: "+actual_WFName);
			Assert.assertFalse(actual_WFName.equals(wfName));
		}
	}
	public void validateAdvSearchForWFNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFName=op.get(i).getText();
			System.out.println("actual_Workflow Name present in table are: "+actual_WFName);
			Assert.assertTrue(actual_WFName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForWFNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFName=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Workflow Name present in table are: "+actual_WFName);
			Thread.sleep(3000);
			Assert.assertTrue(actual_WFName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForWFNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFName=op.get(i).getText();
			System.out.println("actual_Workflow Name present in table are: "+actual_WFName);
			Assert.assertTrue(actual_WFName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForWFCategoryEqualTo(String SearchColumn,String SearchCriteria,
			String wfCategory,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,wfCategory);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFCategory=op.get(i).getText();
			System.out.println("actual_Workflow Category present in table are: "+actual_WFCategory);
			Thread.sleep(2000);
			Assert.assertTrue(actual_WFCategory.contentEquals(wfCategory));
		}
	}
	public void validateAdvSearchForWFCategoryNotEqualTo(String SearchColumn,String SearchCriteria,
			String wfCategory,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, wfCategory);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFCategory=op.get(i).getText();
			System.out.println("actual_Workflow Category present in table are: "+actual_WFCategory);
			Assert.assertFalse(actual_WFCategory.equals(wfCategory));
		}
	}
	public void validateAdvSearchForWFCategoryIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFCategory=op.get(i).getText();
			System.out.println("actual_Workflow Category present in table are: "+actual_WFCategory);
			Assert.assertTrue(actual_WFCategory.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForWFCategoryBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFCategory=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Workflow Name present in table are: "+actual_WFCategory);
			Thread.sleep(3000);
			Assert.assertTrue(actual_WFCategory.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForWFCategoryEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Workflow record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_WFCategory=op.get(i).getText();
			System.out.println("actual_Workflow Category present in table are: "+actual_WFCategory);
			Assert.assertTrue(actual_WFCategory.contains(advSearchFor));
		}
	}
	public void validateHandleCalender(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate);
		Thread.sleep(2000);
	}

	public void validateCreatedEqualTo(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalender(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[4]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[4]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[4]"));
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
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[4]"));
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
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[4]"));
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
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[6]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tr/td[6]"));
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
