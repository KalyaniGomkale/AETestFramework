package com.ae.qa.pagesTenantAdmin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;
import com.aventstack.extentreports.Status;

public class WorkflowListPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 100);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public CataloguePageTA cataloguepageta=new CataloguePageTA();
	public RequestsPageTA requestspageta=new RequestsPageTA();
	public CredentialsPageTA credentialspageta=new CredentialsPageTA(); 
	public AgentListPageTA agentlistta=new AgentListPageTA();
	public CommonWebElements wb = new CommonWebElements();
	public WorkflowAssignmentPageTA workflowassignmentpageta= new WorkflowAssignmentPageTA();

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
	@FindBy(name = "submit")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement success_msg;
	@FindBy(xpath = "//div/h5[text()='Show file content']")
	WebElement showFileContent;
	@FindBy(xpath = "//div/h5[text()='Content:']")
	WebElement content;
	@FindBy(name = "dropdown-selector")
	WebElement importDrpDwn;
	@FindBy(xpath = "//span[text()='Export']")
	WebElement exportBtn;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement selectWf;
	@FindBy(xpath = "//div[@class='right-inner-addon']/input[@name='search']")
	WebElement searchBar;
	@FindBy(id = "isVerified")
	WebElement verifiedCheckbx;
	@FindBy(id = "export-btn")
	WebElement ewfBtn;
	@FindBy(id = "wfIcon")
	WebElement wfIcon;
	@FindBy(xpath = "//form/fieldset[2]/legend[1]/span")
	WebElement emailNotification;
	@FindBy(id = "notifyWfFailure")
	WebElement notifyWfFailureBox;
	@FindBy(id = "notifyLongRunningWf")
	WebElement notifyExceedingTimeBox;
	@FindBy(id = "ROLE_TENANT_ADMIN")
	WebElement roleTA;
	@FindBy(id = "ROLE_WORKFLOW_ADMIN")
	WebElement roleWA;
	@FindBy(id = "toEmail")
	WebElement emailID;
	@FindBy(id = "sendToRequestCreator")
	WebElement reqCreator;
	@FindBy(id = "failureMessage")
	WebElement failMsg;
	@FindBy(id = "isSeqExec")
	WebElement enableSeqExec;
	@FindBy(xpath="//span[@class='text-danger']")
	WebElement smtpEmailNotification;
	@FindBy(id="wfName")
	WebElement WfsList;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	List<WebElement> WfsList1;
	//@FindBy(xpath="//*[@id='options-list']/li[6]/label")
	//WebElement Workflow;
	@FindBy(id="export-btn")
	WebElement ExportBtn;
	@FindBy(xpath="//*[@id='psExportModal']/export-workflow/div/div/form/div[1]")
	WebElement Anywhere;
	@FindBy(xpath="//*[@id='options-list']/li/label")
	WebElement Wfselect;
	@FindBy(xpath="//span[@class='fa fa-caret-right']")
	WebElement configParamBar;
	@FindBy(xpath="//input[@id='a']")
	WebElement configParamInput;
	@FindBy(xpath="//input[@id='b']")
	WebElement configParamInput1;
	@FindBy(xpath="//select[@id='a']")
	WebElement credParam1;
	@FindBy(xpath="//select[@id='b']")
	WebElement credParam2;
	@FindBy(xpath="//li[@class='list-group-item']/b")
	WebElement uploadedZipName;
	@FindBy(xpath="//span[text()='Update']")
	WebElement updateOption;
	@FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement wf_dropdown;
	@FindBy(xpath="//input[@name='search']")
	WebElement search;
	@FindBy(xpath="//*[@id='options-list']/li/label/span")
	WebElement selectWF;
	@FindBy(xpath="(//label/input[@type=\"file\"])[2]")
	WebElement updateWFBox;
	@FindBy(xpath="//div[@class='pull-left']/button[1]/span")
	WebElement updateBtn;
	@FindBy(xpath="//input[@id='a-poolCredential-pool']")
	WebElement credPoolRadioBtn_a;
	@FindBy(xpath="//input[@id='b-poolCredential-pool']")
	WebElement credPoolRadioBtn_b;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
   @FindBy(xpath="//legend[@id='conf-toggle']")
	WebElement configParam;
	@FindBy(xpath="(//input[@id='a-poolCredential'])[1]")
	WebElement credentials;
	@FindBy(xpath="//select[@id='a']")
	WebElement credentialsDropdown;
	@FindBy(xpath="//select[@id='b']")
	WebElement credentialsPoolDropdown;
	@FindBy(xpath = "//span[text()='Catalogue']")
	WebElement catalogueTab;
	@FindBy(xpath = "//b[text()='No workflow(s) found']")
	WebElement wfNotFoundTitle;
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement cancelBtn;
	@FindBy(id = "a")
	WebElement runtimeParam;
	@FindBy(id = "c")
	WebElement UpdateruntimeParam;
	@FindBy(xpath="//button[@name='submit']")
	WebElement submitRequestBtn;
	@FindBy(id="popup-button-ok")
	WebElement okBtn;
	@FindBy(xpath = "//span[text()='Update']")
	WebElement updateBtnDropdown;
	@FindBy(xpath = "//ae-multiselect[@id='workflow_name']/div/span")
	WebElement updateSelectWF;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement updateWFCheckbox;
	@FindBy(xpath = "//fieldset[@class='workflow-fieldset']/div/label[contains(text(),'Choose File')]/input[@type='file']")
	WebElement updateSelectWFFile;
	@FindBy(xpath="//input[@id='c']")
	WebElement runParamInput;
	@FindBy(xpath="//input[@id='d']")
	WebElement runParamInput1;
	@FindBy(xpath = "//span[text()='Requests']")
	WebElement requestsTab;
	@FindBy(name = "refresh-btn")
	WebElement refershTableBtn;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement showColumnDrpdown;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement selectAllCheckBox;

	public WorkflowListPageTA() {
		PageFactory.initElements(driver, this);
	}
	public void ImportForm(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
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
	public void validateImportWorkflow(String wfName, String wfdes, String category, String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		ImportForm(wfName, wfdes, category,WFImportPath,priority,expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		String emailActual_message=smtpEmailNotification.getText();
		Reporter.log("Alert Message when user dont configure smtp"+emailActual_message,true);
		String emailExpected_message=Messages.smtpNotConfig;
		Assert.assertEquals(emailActual_message,emailExpected_message, "Not getting correct message when smtp not set");
		Reporter.log("Getting correct message for email notification as smtp not configured",true);
		Thread.sleep(3000);
		//JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", saveBtn);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(success_msg));
		Thread.sleep(2000);
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
	public void validateImportWorkflowWithConfigParam(String wfName, String wfdes, String category,String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String ConfigParamString) throws Exception {
		ImportForm(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		configParamBar.click();
		Thread.sleep(3000);
		configParamInput.sendKeys(ConfigParamString);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(success_msg));
		Thread.sleep(2000);
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
	public void validateImportWorkflowWithRuntimeParam(String wfName, String wfdes, String category,String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		ImportForm(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		//	configParamBar.click();
		//	Thread.sleep(3000);
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
	public void validateImportWorkflowWithConfigRuntimeParam(String wfName, String wfdes, String category,String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String ConfigParamString) throws Exception {
		ImportForm(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		configParamBar.click();
		Thread.sleep(3000);
		configParamInput.sendKeys(ConfigParamString);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(success_msg));
		Thread.sleep(2000);
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
	public void validateImportWorkflowWithCredConfigParam(String wfName, String wfdes, String category,String WFImportPath,String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String Credential1,String Credential2) throws Exception {
		ImportForm(wfName, wfdes, category,WFImportPath,priority,
				expTime, maxTime,cleanUpHrs, manExeTime, tUnit);
		configParamBar.click();
		Thread.sleep(2000);
		credPoolRadioBtn_a.click();
		Thread.sleep(2000);
		Select cred_dropdwn1=new Select(credParam1);
		cred_dropdwn1.selectByVisibleText(Credential1);
		Thread.sleep(2000);
		credPoolRadioBtn_b.click();
		Thread.sleep(2000);
		Select cred_dropdwn2=new Select(credParam2);
		cred_dropdwn2.selectByVisibleText(Credential2);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(success_msg));
		Thread.sleep(2000);
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
	public void ValidateUploadInvalidIcon(String wfname, String IconPath) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(3000);
		WebElement editBtn= driver.findElement(By.xpath("//table/tr/td[@title='"+wfname+"']/../td[7]/span[@title='Edit Workflow']"));
		editBtn.click();
		Reporter.log("Edit button is clicked",true);
		wfIcon.sendKeys(IconPath);
		//wait.until(ExpectedConditions.visibilityOf(success_msg));
		Thread.sleep(2000);
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.InvalidWFIcon;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow icon updated");
		Reporter.log("Icon Updation done successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}

	public void ValidateUploadIcon(String wfname, String IconPath) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(3000);
		WebElement editBtn= driver.findElement(By.xpath("//table/tr/td[@title='"+wfname+"']/../td[7]/span[@title='Edit Workflow']"));
		editBtn.click();
		Reporter.log("Edit button is clicked",true);
		wfIcon.sendKeys(IconPath);
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(success_msg));
		Thread.sleep(2000);
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Icon Updation done successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void ValidateEditManualExecution(String wfname,String manExeTime, String tUnit) throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		Thread.sleep(5000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		Reporter.log("workflowList  tab clicked",true);
		Thread.sleep(4000);
		//Click on Edit Button
		WebElement edit_btn = driver.findElement(By.xpath("//tr/td[contains(text(),'"+wfname +"')]/../td/span[@title='Edit Workflow']"));
		js.executeScript("arguments[0].click();", edit_btn);
		Thread.sleep(3000);
		Reporter.log("Edit button is Clicked",true);
		//Clear and Enter Manual Execution time.
		manualExecutionTime.clear();
		manualExecutionTime.sendKeys(manExeTime);
		wait.until(ExpectedConditions.visibilityOf(manualTimeUnit));
		Select manualTimeUnit_drpdown = new Select(manualTimeUnit);
		manualTimeUnit_drpdown.selectByVisibleText(tUnit);
		Thread.sleep(3000);
		saveBtn.click();
		//wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		Thread.sleep(2000);
		Reporter.log("Aactual Success Message after editing workflow: " + Actual_successMsg,true);
		String Expected_successMsg = Messages.updateWorkflow;
		Reporter.log("Expected Success Message after editing workflow: " +Expected_successMsg ,true);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		informationpageta.validateSignOut();
	}
	public void ValidateExportWorkflow(String wfName) throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		Thread.sleep(3000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
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
		searchBar.sendKeys(wfName);
		Wfselect.click();
		Reporter.log("Checked the Workflow name ", true);
		WfsList.click();
		Thread.sleep(2000);
		ExportBtn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on export bottun", true);
		String actual_successMsg = success_msg.getText();
		System.out.println("Actual success msg: " + actual_successMsg);
		String expected_successMsg = Messages.exportWorkflow;
		System.out.println("Expected success msg: " + expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg, "export does not started.");
		informationpageta.validateSignOut();
	}
	public void ValidateShowFileStructure(String wfName, String wfdes, String category, String WFImportPath,String ExpectedFileName) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
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
		ChooseWFToImport.sendKeys(WFImportPath);
		Thread.sleep(3000);
		showFileContent.click();
		//here we will validate UploadedFile.zip
		String Actual_FileName=uploadedZipName.getText();
		String Expected_FileName=ExpectedFileName;
		Assert.assertEquals(Actual_FileName,Expected_FileName,"Zip file not found");
		Reporter.log("Zip File found in File Structure:"+Actual_FileName,true);
		informationpageta.validateSignOut();
	}
	public void validateShowFileStructureWorkflow(String wfname) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", workflowListTab);
		Reporter.log("workflowList  tab clicked",true);
		//Click on Show File Strucutre Button
		WebElement showFileStructure_btn = driver.findElement(By.xpath("//tr/td[contains(text(),'"+wfname +"')]/../td/span[@title='Show workflow files']"));
		showFileStructure_btn.click();
		Reporter.log("Show File Structure button is Clicked",true);
		Thread.sleep(3000);
		String fileStructure_wfName=driver.findElement(By.xpath("//tree-view/ul/li/b[text()='"+wfname+"']")).getText();
		Thread.sleep(3000);
		String actual_wfName=fileStructure_wfName;
		Reporter.log("Actual File Structure workflow Name:- "+actual_wfName);
		String expected_wfName=wfname;
		Reporter.log("Expected File Structure workflow Name:- "+expected_wfName);
		Assert.assertEquals(actual_wfName, expected_wfName, "Appropriate File Structure is not displayed");
		cancelBtn.click();
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	public void ValidateUpdateWFWithConfigWF(String wfName,String updatedWFPath) throws Exception
	{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		Thread.sleep(3000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", workflowListTab);
		Reporter.log("workflowList  tab clicked",true);
		importDrpDwn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Dropdown button", true);
		updateOption.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Update option from dropdown", true);
		wf_dropdown.click();
		Thread.sleep(2000);
		Reporter.log("Clicked the Workflows dropdown ", true);
		search.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on search bar");
		selectWF.click();
		Reporter.log("Checked the Workflow name which needs to be updated", true);
		updateWFBox.sendKeys(updatedWFPath);
		Thread.sleep(2000);
		updateBtn.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Update bottun", true);
		Thread.sleep(3000);
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		informationpageta.validateSignOut();
		cataloguepageta.validateSubmitRequest(wfName);
		requestspageta.validateRequestStatus();

	}
	public void validateWorkflowListPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		js.executeScript("arguments[0].click();", workflowListTab);
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
	public void validateImportWorkflowWithConfigParamCredAndCredpool(String CredName,String CredDescp,String UserName,String Pswd,String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit , String credentialName , String credentialPoolName) throws Exception
	{
		credentialspageta.ValidateCreateCredentials(CredName,CredDescp,UserName,Pswd);
		ImportForm(wfName, wfdes, category, WFImportPath, priority, expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		//Clicking on Configuration Parameters
		//wait.until(ExpectedConditions.visibilityOf(configParam));
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", configParam);
		Reporter.log("Configuration Parameters dropdown is clicked",true);
		//Clicking on Credential Radio Button
		credentials.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Credentials Radio Button", true);
		//Selecting Credentials from the dropdown
		Select credentials_drpdown = new Select(credentialsDropdown);
		credentials_drpdown.selectByVisibleText(credentialName);
		Thread.sleep(3000);
		//Clicking on Credentials Pool Radio Button
		credPoolRadioBtn_b.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Credentials Pool Radio Button", true);
		//Selecting Credentials Radio Button
		Select credentialsPool_drpdown = new Select(credentialsPoolDropdown);
		credentialsPool_drpdown.selectByVisibleText(credentialPoolName);
		Thread.sleep(3000);
		//Clicking on Save Button
		saveBtn.click();
		Thread.sleep(4000);
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();         
	}
	public void validateImportWorkflowRegistredAssistedAgent(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		ImportForm(wfName,wfdes,category, WFImportPath, priority,
				expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		saveBtn.click();
		Thread.sleep(4000);
		Reporter.log("Save button is clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(success_msg));
		Thread.sleep(2000);
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut(); 
		cataloguepageta.validateSubmitRequest(wfName);
		requestspageta.validateRequestStatus();
		informationpageta.validateSignOut();
	}
	public void validateImportWorkflowUnRegistredAssistedAgent(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception {
		ImportForm(wfName,wfdes,category, WFImportPath, priority,
				expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		saveBtn.click();
		Thread.sleep(4000);
		Reporter.log("Save button is clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(success_msg));
		Thread.sleep(2000);
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(catalogueTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",catalogueTab);
		Reporter.log("Catalogue Tab is clicked",true);
		Thread.sleep(2000);
		boolean wfNameToSendRequest = wfNotFoundTitle.isDisplayed();
		if(wfNameToSendRequest){
			System.out.println("Agent is been deleted need to be registred so that WF will be present in Catalogue");
		}else {
			System.out.println("Agent is registered and not been deleted");
		}
		informationpageta.validateSignOut();
		agentlistta.downloadAssistedAgent();
		agentlistta.checkStatusOfAssistedAgent();
		cataloguepageta.validateSubmitRequest(wfName);
	}


	public void vaildateExportMutlipleWorkflow() throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		System.out.println("workflowTab clicked");
		//wait.until(ExpectedConditions.visibilityOf(workflowListTab));
		Thread.sleep(3000);
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
		//searchBar.sendKeys(wfName);
		//Wfselect.click();
		//Reporter.log("Checked the Workflow name ", true);
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
	public void validateImportWFRunParamCred(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String Parameter) throws Exception{
		ImportForm(wfName, wfdes, category, WFImportPath, priority, expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(success_msg));
		Thread.sleep(5000);
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
		workflowassignmentpageta.validateSingleWorkflowAssignment(wfName);
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
		Select runtime_Parameter = new Select(runtimeParam);
		runtime_Parameter.selectByVisibleText(Parameter);
		Thread.sleep(2000);
		submitRequestBtn.click();
		Reporter.log("Submit request button is clicked");
		Thread.sleep(2000);
		okBtn.click();
		Reporter.log("OK button is clicked");
		Thread.sleep(2000);
		//requestspageta.validateRequestStatus();
		informationpageta.validateSignOut();
		requestspageta.validateRequestStatus();
		informationpageta.validateSignOut();
	}
	public void validateUpdateConfigParam(String wfName,String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String wfFilePath,String configParameter,
			String configParameter1,String runParameter,String runParameter1) throws Exception{
		ImportForm(wfName, wfdes, category, WFImportPath, priority, expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		//informationpageta.validateSignOut();
		//loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		//Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
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
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
		workflowassignmentpageta.validateSingleWorkflowAssignment(wfName);
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
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
	//Need some changes 
	//FAILED: validateUpdateWFCredAndCredpoolTest(public void com.ae.qa.testcasesTenantAdmin.WorkflowListPageTestTA.validateUpdateWFCredAndCredpoolTest(java.lang.reflect.Method) throws java.lang.Exception)
	//org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"#a"}
	public void validateUpdateWFCredAndCredpool(String CredName,String CredDescp,String UserName,String Pswd,String wfName,String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String wfFilePath,String credentialName,
			String credentialPoolName,String RuncredentialName)throws Exception{
		credentialspageta.ValidateCreateCredentials(CredName,CredDescp,UserName,Pswd);
		ImportForm(wfName, wfdes, category, WFImportPath, priority, expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		//informationpageta.validateSignOut();
		//loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		//Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", workflowsTab);
		Thread.sleep(5000);
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
		//Clicking on Credential Radio Button
		credentials.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Credentials Radio Button", true);
		//Selecting Credentials from the dropdown
		Select credentials_drpdown = new Select(credentialsDropdown);
		credentials_drpdown.selectByVisibleText(credentialName);
		Thread.sleep(3000);
		//Clicking on Credentials Pool Radio Button
		credPoolRadioBtn_b.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Credentials Pool Radio Button", true);
		//Selecting Credentials Radio Button
		Select credentialsPool_drpdown = new Select(credentialsPoolDropdown);
		credentialsPool_drpdown.selectByVisibleText(credentialPoolName);
		Thread.sleep(3000);
		//Clicking on Save Button
		saveBtn.click();
		Thread.sleep(4000);
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
		workflowassignmentpageta.validateSingleWorkflowAssignment(wfName);
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(catalogueTab));
		js.executeScript("arguments[0].click();",catalogueTab);
		Reporter.log("Catalogue Tab is clicked",true);
		Thread.sleep(2000);
		WebElement wfNameToSendRequest=driver.findElement(By.xpath("//h6[text()='"+wfName+"']"));
		wfNameToSendRequest.click();
		Reporter.log("Workflow whose request needs to be send is selected",true);
		Thread.sleep(2000);
		Select runtimeCredParameter = new Select(UpdateruntimeParam);
		runtimeCredParameter.selectByVisibleText(RuncredentialName);
		Thread.sleep(2000);
		submitRequestBtn.click();
		Reporter.log("Submit request button is clicked");
		Thread.sleep(2000);
		okBtn.click();
		Reporter.log("OK button is clicked");
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	//Need to have a wf with config cred&credPool and one RuntimeParam// Currently wehave only config cred and credPool
	public void validateImportWFConfigCredCredpoolandRunParam(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String credentialName,String credentialPoolName) throws Exception{
		ImportForm(wfName, wfdes, category, WFImportPath, priority, expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", configParam);
		Reporter.log("Configuration Parameters dropdown is clicked",true);
		//Clicking on Credential Radio Button
		credentials.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Credentials Radio Button", true);
		//Selecting Credentials from the dropdown
		Select credentials_drpdown = new Select(credentialsDropdown);
		credentials_drpdown.selectByVisibleText(credentialName);
		Thread.sleep(3000);
		//Clicking on Credentials Pool Radio Button
		credPoolRadioBtn_b.click();
		Thread.sleep(2000);
		Reporter.log("Clicked on Credentials Pool Radio Button", true);
		//Selecting Credentials Radio Button
		Select credentialsPool_drpdown = new Select(credentialsPoolDropdown);
		credentialsPool_drpdown.selectByVisibleText(credentialPoolName);
		Thread.sleep(3000);
		//Clicking on Save Button
		saveBtn.click();
		Thread.sleep(4000);
		Reporter.log("Save button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(success_msg));
		String Actual_successMsg = success_msg.getText();
		System.out.println("Actual Message : " + Actual_successMsg);
		String Expected_successMsg = Messages.updateWorkflow;
		System.out.println("Expected Message :"+Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not updated");
		Reporter.log("Workflow updated",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr[2]/td[@title='"+wfName+"']/../td[6]/label/span"));
		sliderToEnableWF.click();
		Reporter.log("Workflow is enabled successfully",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void validateImportAssistedWorkflow(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
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
		if (!assistedCheckbox.isSelected()) {
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
	public void validateDeleteCredentialWF(String wfName,String CredName) throws Exception{
		workflowassignmentpageta.validateSingleWorkflowAssignment(wfName);
		credentialspageta.ValidateDeleteCredential(CredName);
		cataloguepageta.validateSubmitRequest(wfName);
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully", true);
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		js.executeScript("arguments[0].click();", refershTableBtn);
		refershTableBtn.click();
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (!selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All CheckBox");
		} else {
			System.out.println("Select All Checkbox is already selected");
		}
		Thread.sleep(2000);
		refershTableBtn.click();
		Thread.sleep(10000);
		String requestStatus = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+wfName+"']/../td/span[1]")).getText();
		String wfStatus = requestStatus;
		Boolean flag = false;
		if (wfStatus.equals("Failure")) {
			Thread.sleep(10000);
			String actual_FailureMsg = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+wfName+"']/../td[5]/p")).getText();
			String expected_FailureMsg = Messages.credDeleteWFMsg;
			Assert.assertEquals(actual_FailureMsg,expected_FailureMsg);
			informationpageta.validateSignOut();
			Assert.assertTrue(!flag);
		} else if (wfStatus.equals("New")) {
			Thread.sleep(10000);
			Reporter.log("Workflow status is:" + wfStatus, true);
			refershTableBtn.click();
			Assert.assertTrue(!flag);
		}
	}
	
	public void validateAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
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
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
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
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
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
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
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
