package com.ae.qa.pages.WorkflowAdmin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowAssignmentPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class WorkflowListPageWA extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();
	public WorkflowListPageTA workflowlistpageta = new WorkflowListPageTA();
	public WorkflowAssignmentPageTA workflowassignmentpageta = new WorkflowAssignmentPageTA();
	public AgentListPageWA agentlistpagewa = new AgentListPageWA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Workflow List']")
	WebElement workflowListTab;
	@FindBy(xpath = "//button[@name='add-new']/span")
	WebElement importTab;
	@FindBy(id = "workflow_name")
	WebElement workflowName;
	@FindBy(id = "description")
	WebElement wfDescription;
	@FindBy(id = "category_name")
	WebElement wfCategory;
	@FindBy(id = "is_assisted")
	WebElement assistedCheckbox;
	@FindBy(name = "rdpEnabled")
	WebElement enableRDPCheckbox;
	@FindBy(xpath="//fieldset[@class='workflow-fieldset']/div/label//input")
	WebElement ChooseWFToImport;
	@FindBy(name = "submit")
	WebElement createBtn;
	@FindBy(id = "wfPriority")
	WebElement wfPriority;
	@FindBy(id = "expectedCompletionTime")
	WebElement expected_completionTime;
	@FindBy(id = "maxCompletionTime")
	WebElement max_CompletionTime;
	@FindBy(id = "cleanupOldReqHours")
	WebElement cleanupOldReqHours;
	@FindBy(id = "manualExecutionTime")
	WebElement manualExecutionTime;
	@FindBy(id = "manualTimeUnit")
	WebElement manualTimeUnit;
	@FindBy(xpath="//span[@class='text-danger']")
	WebElement smtpEmailNotification;
	@FindBy(name = "submit")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement success_msg;
	@FindBy(xpath="//span[@class='fa fa-caret-right']")
	WebElement configParamBar;
	@FindBy(xpath="(//span[@class='fa fa-caret-right'])[1]")
	WebElement emailNotificationBar;
	@FindBy(xpath="//input[@id='a']")
	WebElement configParamInput;
	@FindBy(xpath="//input[@id='b']")
	WebElement configParamInput1;
	@FindBy(name = "dropdown-selector")
	WebElement importDrpDwn;
	@FindBy(xpath = "//span[text()='Update']")
	WebElement updateBtnDropdown;
	@FindBy(xpath = "//ae-multiselect[@id='workflow_name']/div/span")
	WebElement updateSelectWF;
	@FindBy(xpath = "//div[@class='right-inner-addon']/input[@name='search']")
	WebElement searchBar;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement updateWFCheckbox;
	@FindBy(xpath = "//fieldset[@class='workflow-fieldset']/div/label[contains(text(),'Choose File')]/input[@type='file']")
	WebElement updateSelectWFFile;
	@FindBy(xpath="//legend[@id='conf-toggle']")
	WebElement configParam;
	@FindBy(xpath="//button[@name='submit']")
	WebElement submitRequestBtn;
	@FindBy(id="popup-button-ok")
	WebElement okBtn;
	@FindBy(xpath="//input[@id='c']")
	WebElement runParamInput;
	@FindBy(xpath="//input[@id='d']")
	WebElement runParamInput1;
	@FindBy(xpath = "//span[text()='Catalogue']")
	WebElement catalogueTab;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	List<WebElement> WfsList1;
	//@FindBy(xpath="//*[@id='options-list']/li[6]/label")
	//WebElement Workflow;
	@FindBy(id="export-btn")
	WebElement ExportBtn;
	@FindBy(id="wfName")
	WebElement WfsList;
	@FindBy(xpath = "//span[text()='Export']")
	WebElement exportBtn;
	@FindBy(id = "wfIcon")
	WebElement wfIcon;
	@FindBy(id = "isSeqExec")
	WebElement SeqExecCheckbox;
	@FindBy(id = "notifyWfFailure")
	WebElement wfFailureCheckbox;
	@FindBy(id = "notifyLongRunningWf")
	WebElement wfExceedingTimeLimitCheckbox;
	@FindBy(id = "ROLE_TENANT_ADMIN")
	WebElement roleTenantAdmin;
	@FindBy(id = "ROLE_WORKFLOW_ADMIN")
	WebElement roleWorkflowAdmin;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement byUsernameField;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement usernameCheckbox;
	@FindBy(id="toEmail")
	WebElement emailIDField;
	@FindBy(id="sendToRequestCreator")
	WebElement requestCreator;

	public WorkflowListPageWA() {
		PageFactory.initElements(driver, this);
	}
	public void ImportFormWA(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(2000);
		importTab.click();
		Reporter.log("Import button clicked",true);
		workflowName.sendKeys(wfName);
		Thread.sleep(3000);
		wfDescription.sendKeys(wfdes);
		Thread.sleep(3000);
		Select wfCategory_drpdown = new Select(wfCategory);
		wfCategory_drpdown.selectByVisibleText(category);
		Thread.sleep(3000);
		if (assistedCheckbox.isSelected()) {
			Reporter.log("assisted Workflow is selected",true);
			assistedCheckbox.click();
			Reporter.log("assisted Workflow is unselected",true);
		} else {
			Reporter.log("Is Assisted Workflow checkbox is unselected");
		}
		Thread.sleep(3000);
		if (enableRDPCheckbox.isSelected()) {
			Reporter.log("Enable RDP checkbox is selected",true);
			enableRDPCheckbox.click();
			Reporter.log("Enable RDP checkbox is unselected",true);
		} else {
			System.out.println("Enable RDP checkbox is unselected");
		}
		Thread.sleep(3000);
		//ChooseWFToImport.sendKeys(prop.getProperty("WFToImportPath"));
		ChooseWFToImport.sendKeys(WFImportPath);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click();", createBtn);
		Reporter.log("Create Button is clicked",true);
		//Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(wfPriority));
		Select wfPriority_drpdown = new Select(wfPriority);
		wfPriority_drpdown.selectByVisibleText(priority);
		Reporter.log("Priority is set",true);
		Thread.sleep(2000);
		expected_completionTime.clear();
		expected_completionTime.sendKeys(expTime);
		Reporter.log("Expected Completion Time in Seconds is set",true);
		Thread.sleep(2000);
		max_CompletionTime.clear();
		max_CompletionTime.sendKeys(maxTime);
		Reporter.log("Maximum Completion Time in Seconds is set",true);
		Thread.sleep(2000);
		cleanupOldReqHours.clear();
		cleanupOldReqHours.sendKeys(cleanUpHrs);
		Reporter.log("Cleanup Requests older than Hours fields is set",true);
		Thread.sleep(2000);
		manualExecutionTime.clear();
		manualExecutionTime.sendKeys(manExeTime);
		Reporter.log("Manual Execution Time is set",true);
		wait.until(ExpectedConditions.visibilityOf(manualTimeUnit));
		Select manualTimeUnit_drpdown = new Select(manualTimeUnit);
		manualTimeUnit_drpdown.selectByVisibleText(tUnit);
		Reporter.log("Manual Execution time unit is set",true);
		Thread.sleep(3000);
	}
	public void validateImportWFConfigParamWA(String wfName, String wfdes, String category, String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String ConfigParamString) throws Exception {
		ImportFormWA(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
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
	}
	public void validateUpdateWFConfigParamCreatedByTAdminWA(String wfName, String wfdes, String category, String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String wfFilePath,String configParameter,String configParameter1,
			String runParameter,String runParameter1) throws Exception{
		workflowlistpageta.ImportForm(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveBtn);
		//saveBtn.click();
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
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(2000);
		importDrpDwn.click();
		Reporter.log("Import Dropdown is clicked",true);
		Thread.sleep(2000);
		//Clicking on Update button from the dropdown
		updateBtnDropdown.click();
		Reporter.log("Update Button is Clicked",true);
		updateSelectWF.click();
		searchBar.sendKeys(wfName);
		Reporter.log("Workflow is been selected",true);
		updateWFCheckbox.click();
		Thread.sleep(2000);
		updateSelectWFFile.sendKeys(wfFilePath);
		Reporter.log("Updated workflow file is choosed",true);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		js.executeScript("arguments[0].click();", configParam);
		Reporter.log("Configuration Parameters dropdown is clicked",true);
		configParamInput.sendKeys(configParameter);
		configParamInput1.sendKeys(configParameter1);
		Thread.sleep(2000);
		saveBtn.click();
		Thread.sleep(4000);
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg1 = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg1);
		String Expected_successMsg1 = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg1);
		Assert.assertEquals(Actual_successMsg1, Expected_successMsg1, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF1=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF1.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
		workflowassignmentpageta.validateSingleWorkflowAssignment(wfName);
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		wait.until(ExpectedConditions.visibilityOf(catalogueTab));
		js.executeScript("arguments[0].click();",catalogueTab);
		Reporter.log("Catalogue Tab is clicked",true);
		Thread.sleep(2000);
		WebElement wfNameToSendRequest=driver.findElement(By.xpath("//h6[text()='"+wfName+"']"));
		wfNameToSendRequest.click();
		Reporter.log("Workflow whose request needs to be send is selected",true);
		Thread.sleep(2000);
		runParamInput.sendKeys(runParameter);
		runParamInput1.sendKeys(runParameter1);
		Reporter.log("Run Parameter are displayed and entered",true);
		Thread.sleep(2000);
		submitRequestBtn.click();
		Reporter.log("Submit request button is clicked");
		Thread.sleep(2000);
		okBtn.click();
		Reporter.log("OK button is clicked");
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	public void validateExportWFVerifiedWA() throws Exception{
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		js.executeScript("arguments[0].click();", workflowListTab);
		Reporter.log("workflowList  tab clicked",true);
		importDrpDwn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Dropdown button", true);
		exportBtn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Export option from dropdown", true);
		WfsList.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Workflows dropdown ", true);
		searchBar.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on search bar");
		//Selecting all the Workflows present in the dropdown list
		List<WebElement> workflow_List =  WfsList1;
		int workflows_size = workflow_List.size();
		System.out.println("Number of Workflows:- "+workflows_size);
		for(int i = 0; i<workflows_size; i++) {

			workflow_List.get(i).click();
		}
		Thread.sleep(5000);
		WfsList.click();
		Thread.sleep(2000);
		ExportBtn.click();
		Thread.sleep(2000);
		String actual_successMsg = success_msg.getText();
		System.out.println("Actual success msg: " + actual_successMsg);
		String expected_successMsg = Messages.exportWorkflow;
		System.out.println("Expected success msg: " + expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg, "export does not started.");
		Reporter.log("Multiple Workflow are exported successfully", true);
		informationpageta.validateSignOut();
	}
	public void validateEditWFWA(String wfname,String IconPath,String priority,String cleanUpHrs) throws Exception{
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		js.executeScript("arguments[0].click();", workflowListTab);
		Reporter.log("workflowList  tab clicked",true);
		Thread.sleep(3000);
		WebElement editBtn= driver.findElement(By.xpath("//table/tr/td[@title='"+wfname+"']/../td[7]/span[@title='Edit Workflow']"));
		editBtn.click();
		Reporter.log("Edit button is clicked",true);
		wfIcon.sendKeys(IconPath);
		Thread.sleep(3000);
		/*SeqExecCheckbox.click();
		Thread.sleep(2000);
		if(SeqExecCheckbox.isSelected()){
			Reporter.log("Enable Sequential Execution checkbox is selected",true);
		}else {
			Reporter.log("Enable Sequential Execution checkbox is not selected",true);
		}*/
		wait.until(ExpectedConditions.visibilityOf(wfPriority));
		Select wfPriority_drpdown = new Select(wfPriority);
		wfPriority_drpdown.selectByVisibleText(priority);
		Reporter.log("Priority is set",true);
		cleanupOldReqHours.clear();
		cleanupOldReqHours.sendKeys(cleanUpHrs);
		Reporter.log("Cleanup Requests older than Hours fields is set",true);
		js.executeScript("arguments[0].click();", saveBtn);
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		informationpageta.validateSignOut();
	}
	public void validateEmailNotificationWF(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String Username,String Username1,
			String EmailID) throws Exception{
		ImportFormWA(wfName, wfdes, category, WFImportPath, priority, expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		emailNotificationBar.click();
		Reporter.log("Email Notification Setting bar is clicked",true);
		Thread.sleep(2000);
		wfFailureCheckbox.click();
		if(wfFailureCheckbox.isSelected()){
			Reporter.log("Notify on workflow failure checkbox is selected",true);
		}else {
			Reporter.log("Notify on workflow failure checkbox is not selected",true);
		}
		wfExceedingTimeLimitCheckbox.click();
		if(wfExceedingTimeLimitCheckbox.isSelected()){
			Reporter.log("Notify on Exceeding time limit checkbox is selected",true);
		}else{
			Reporter.log("Notify on Exceeding time limit checkbox is not selected",true);
		}
		roleTenantAdmin.click();
		if(roleTenantAdmin.isSelected()){
			Reporter.log("Tenant Admin role checkbox is selected",true);
		}else{
			Reporter.log("Tenant Admin role checkbox is not selected",true);
		}
		roleWorkflowAdmin.click();
		if(roleWorkflowAdmin.isSelected()){
			Reporter.log("Workflow Admin role checkbox is selected",true);
		}else{
			Reporter.log("Workflow Admin role checkbox is not selected",true);
		}
		Thread.sleep(2000);
		byUsernameField.click();
		searchBar.sendKeys(Username);
		usernameCheckbox.click();
		for (int i = 0; i < 30; i++) {
			searchBar.sendKeys(Keys.BACK_SPACE);
		}
		searchBar.sendKeys(Username1);
		usernameCheckbox.click();
		byUsernameField.click();
		Thread.sleep(2000);
		Reporter.log("Username is been selected",true);
		emailIDField.sendKeys(EmailID);
		Reporter.log("Email ID is been entered",true);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",requestCreator);
		//requestCreator.click();
		if(requestCreator.isSelected()){
			Reporter.log("Request creator checkbox is selected",true);
		}else{
			Reporter.log("Request creator checkbox is not selected",true);
		}
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",saveBtn);
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
	}
	public void validateAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", workflowsTab);
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
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
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
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
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
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
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
