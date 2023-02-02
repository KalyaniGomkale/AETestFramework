package com.ae.qa.pages.TenantUser;

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
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.pagesTenantAdmin.PermissionsPageTA;
import com.ae.qa.pagesTenantAdmin.RequestsPageTA;
import com.ae.qa.util.Messages;

public class CataloguePageTU extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public RequestsPageTA requestspageta=new RequestsPageTA();
	
	@FindBy(xpath = "//span[text()='Catalogue']")
	WebElement catalogueTab;
	@FindBy(xpath="//button[@name='submit']")
	WebElement submitRequestBtn;
	@FindBy(id="popup-button-ok")
	WebElement okBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(id="category")
	WebElement categoryDropdown;
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
	@FindBy(xpath = "//div/strong")
	WebElement alert_msg;
	
	public CataloguePageTU() {
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
		if (!assistedCheckbox.isSelected()) {
			assistedCheckbox.click();
			Reporter.log("assisted Workflow is selected",true);
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
	
	public void validateSubmitReqDefaultCategory(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String userName,String userName1,String permission) throws Exception{
		ImportForm(wfName,wfdes,category,WFImportPath,priority,expTime,maxTime,cleanUpHrs,manExeTime,tUnit);
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
		PermissionsPageTA permissionpageta = new PermissionsPageTA();
		permissionpageta.selectPermissions(wfName,userName,userName1,permission);
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(catalogueTab));
		Thread.sleep(3000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",catalogueTab);
		Reporter.log("Catalogue Tab is clicked",true);
		Thread.sleep(2000);
		/*Select select_Category=new Select(categoryDropdown);
	    select_Category.selectByVisibleText(category);
	    System.out.println(category+" Category is been selected");
	    Thread.sleep(2000);	*/	
	    WebElement wfNameToSendRequest=driver.findElement(By.xpath("//h6[text()='"+wfName+"']"));
		wfNameToSendRequest.click();
		Reporter.log("Workflow whose request needs to be send is selected",true);
		Thread.sleep(2000);
		submitRequestBtn.click();
		Reporter.log("Submit request button is clicked");
		Thread.sleep(2000);
		String actual_PopupBox = alert_msg.getText();
		Reporter.log("Actual Popup Box:- "+actual_PopupBox);
		String expected_PopupBox = prop.getProperty("SuccessBox");
		Reporter.log("Expected Popup Box:- "+expected_PopupBox);
		Assert.assertEquals(actual_PopupBox,expected_PopupBox, "Popup Box Message is Failure!");
		Thread.sleep(2000);
		okBtn.click();
		Reporter.log("OK button is clicked");
		Reporter.log("Request is submitted successfully",true);
		informationpageta.validateSignOut();
	}

}
