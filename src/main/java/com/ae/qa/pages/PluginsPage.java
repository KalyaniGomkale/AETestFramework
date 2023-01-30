package com.ae.qa.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.HomePageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowAssignmentPageTA;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class PluginsPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 180);
	public LoginPage loginpage = new LoginPage();
	public WebElements webelements = new WebElements();
	public InformationPage informationpage=new InformationPage();
	public WorkflowsPage workflowpage = new WorkflowsPage();
	public WorkflowAssignmentPageTA wfAssignmentPageTA = new WorkflowAssignmentPageTA();
	public TenantUsersPage tenantuserpage = new TenantUsersPage();
	public TenantsPage tenantspage = new TenantsPage();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//span[(text()='Plugins')]")
	WebElement pluginsTab;
	@FindBy(xpath="//span[text()='Home']")
	WebElement homeTab;
	@FindBy(name = "upload-zip")
	WebElement uploadZipBtn;
	@FindBy(xpath="//h2[text()='Activate']")
	WebElement uploadLicense;
	@CacheLookup
	@FindBy(id = "pluginsFile")
	WebElement chooseFile;
	@FindBy(xpath = "//input[@id='pluginsFile']")
	WebElement chooseFileFromLocation;
	@FindBy(id = "uploadButton")
	WebElement uploadBtn;
	@FindBy(id = "assignedToAllTenantCheck")
	WebElement assignToAllCheckbox;
	@FindBy(id = "select-all")
	WebElement upgradeAllBox;
	@FindBy(id = "select-all-assignment")
	WebElement assignAllBox;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//button[@name='back']")
	WebElement backBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath = "//table/tr[2]/td[5]/span")
	WebElement licenseStatus;
	@FindBy(xpath="//button[@name='dropdown-selector']")
	WebElement uploadDropdown;
	@FindBy(xpath="//span[@name='update-ps-wf']")
	WebElement newPlugin;
	@FindBy(xpath="//input[@id='pluginsFile']")
	WebElement uploadJar;
	@FindBy(id="uploadButton")
	WebElement uploadSingeJarBtn;
	@FindBy(xpath="//input[@id='singlePluginFile']")
	WebElement updateUploadJar;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(id = "add-filter")
	WebElement addFilterBtn;
	@FindBy(xpath = "//button/i[@class='fa fa-search']")
	WebElement searchBtn;
	@FindBy(xpath = "//button[@id='popup-button-ok']")
	WebElement confirmDeleteBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement success_Message;
	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Workflow List']")
	WebElement workflowListTab;
	@FindBy(xpath = "(//input[@name='search'])[1]")
	WebElement searchField;
	@FindBy(id = "assignedToAllTenantCheck")
	WebElement assignToAllTenantCheck;

	public PluginsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validateUploadPlugins() throws Exception {
		//For uploading IT Plugins
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		// Click Upload zip button
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(uploadZipBtn));
		js.executeScript("arguments[0].click();", uploadZipBtn);
		Reporter.log("Upload zip button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		chooseFileFromLocation.sendKeys(prop.getProperty("uploadITPluginFile"));
		Thread.sleep(3000);
		uploadBtn.click();
		Reporter.log("Plugin zip started uploading",true);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", upgradeAllBox);
		Reporter.log("Upgrade all plugin checkbox is selected",true);
		Thread.sleep(1000);
		assignAllBox.click();
		Reporter.log("Assign to all checkbox is selected",true);
		Thread.sleep(1000);
		saveBtn.click();
		Reporter.log("Save button is selected",true);
		Thread.sleep(10000);
		informationpage.validateSignOut();
		//For uploading PS Plugins
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		// Click Upload zip button
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(uploadZipBtn));
		js.executeScript("arguments[0].click();", uploadZipBtn);
		Reporter.log("Upload zip button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		chooseFileFromLocation.sendKeys(prop.getProperty("uploadPluginFile"));
		Thread.sleep(3000);
		uploadBtn.click();
		Reporter.log("Plugin zip started uploading",true);
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", upgradeAllBox);
		Reporter.log("Upgrade all plugin checkbox is selected",true);
		Thread.sleep(1000);
		assignAllBox.click();
		Reporter.log("Assign to all checkbox is selected",true);
		Thread.sleep(1000);
		saveBtn.click();
		Reporter.log("Save button is selected",true);
		Thread.sleep(6000);
		informationpage.validateSignOut();
		Thread.sleep(5000);	
	}
	public void validateUploadSinglePlugins(String uploadJarFile) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		Thread.sleep(3000);
		uploadDropdown.click();
		Thread.sleep(1000);
		newPlugin.click();
		Reporter.log("New Plugin button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		uploadJar.sendKeys(uploadJarFile);
		Thread.sleep(3000);
		if (!assignToAllTenantCheck.isSelected()) {
			assignToAllTenantCheck.click();
		} else {
			System.out.println("Assign to all Tenant Checkbox is already selected");
		}
		Thread.sleep(2000);
		uploadSingeJarBtn.click();
		Reporter.log("Single Plugin Jar started uploading",true);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		String actual_success_msg =alertMessage.getText();
		String expected_success_msg =Messages.singlePluginUpload;
		System.out.println("actual success msg is: " + actual_success_msg);
		Assert.assertEquals(actual_success_msg, expected_success_msg, "Single Plugin not uploaded.");
		Reporter.log("Single plugin jar uploaded successfully");
		informationpage.validateSignOut();
	}
	public void validateUploadSamePlugins(String uploadJarFile,String PluginName) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		Thread.sleep(3000);
		uploadDropdown.click();
		Thread.sleep(1000);
		newPlugin.click();
		Reporter.log("New Plugin button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		uploadJar.sendKeys(uploadJarFile);
		Thread.sleep(3000);
		uploadSingeJarBtn.click();
		Reporter.log("Single Plugin Jar started uploading",true);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		String actual_failure_msg =alertMessage.getText();
		String expected_failure_msg ="Duplicate plugin name ["+PluginName+"]";
		System.out.println("actual failure msg is: " + actual_failure_msg);
		System.out.println("expected failure msg is: " + expected_failure_msg);
		Assert.assertEquals(actual_failure_msg, expected_failure_msg, "Single Plugin uploaded.");
		Reporter.log("Same plugin jar not uploaded successfully");
		informationpage.validateSignOut();
	}
	//Need to change to plugin to Powershell currently it is OOTB Plugin which can hamper the test suite
	public void validateDeletePluginNoActiveWF(String Operation,String pName,String wfName) throws Exception {
		wfAssignmentPageTA.validateSingleWorkflowAssignment(wfName);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		Thread.sleep(3000);
		webelements.AdvanceSearchField("name", "eq", pName);
		js.executeScript("arguments[0].click();", addFilterBtn);
		js.executeScript("arguments[0].click();", searchBtn);
		WebElement deletePluginBtn = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+pName+"']/../td/span[@title='Delete']"));
		Thread.sleep(2000);
		deletePluginBtn.click();
		Reporter.log("Delete button is clicked",true);
		confirmDeleteBtn.click();
		Thread.sleep(2000);
		String actual_failure_msg =alertMessage.getText();
		String expected_failure_msg ="Step/Entry [ScriptValueMod] from plugin ["+pName+"] is being used in workflows ["+wfName+"]. Make these workflows inactive and try again";
		System.out.println("actual failure msg is: " + actual_failure_msg);
		Assert.assertEquals(actual_failure_msg, expected_failure_msg, "Plugin is deleted successfully");
		Reporter.log("Plugin is not deleted successfully because workflow are enabled");
		informationpage.validateSignOut();
		workflowpage.validateDisableWorkflows(Operation);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		Thread.sleep(3000);
		webelements.AdvanceSearchField("name", "eq", pName);
		js.executeScript("arguments[0].click();", addFilterBtn);
		js.executeScript("arguments[0].click();", searchBtn);
		WebElement deletePluginBtn1 = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+pName+"']/../td/span[@title='Delete']"));
		Thread.sleep(2000);
		deletePluginBtn1.click();
		Reporter.log("Delete button is clicked",true);
		confirmDeleteBtn.click();
		Thread.sleep(2000);
		String actual_success_msg =alertMessage.getText();
		String expected_success_msg =Messages.singlePluginDelete;
		System.out.println("actual success msg is: " + actual_success_msg);
		System.out.println("expected success msg is: " + expected_success_msg);
		Assert.assertEquals(actual_success_msg, expected_success_msg, "Plugin is not deleted successfully");
		Reporter.log("Plugin is deleted successfully because workflow are disabled");
		informationpage.validateSignOut();
	}
	public void validateUploadPluginWithoutAssignToAllTenant(String wfName) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		// Click Upload zip button
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(uploadZipBtn));
		js.executeScript("arguments[0].click();", uploadZipBtn);
		Reporter.log("Upload zip button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		chooseFileFromLocation.sendKeys(prop.getProperty("uploadPluginFile"));
		Thread.sleep(3000);
		uploadBtn.click();
		Reporter.log("Plugin zip started uploading",true);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		js.executeScript("arguments[0].click();", upgradeAllBox);
		Reporter.log("Upgrade all plugin checkbox is selected",true);
		Thread.sleep(1000);
		saveBtn.click();
		Reporter.log("Save button is selected",true);
		Thread.sleep(6000);
		informationpage.validateSignOut();
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF1=driver.findElement(By.xpath("//table/tr/td[@title='"+wfName+"']/../td/label/span"));
		sliderToEnableWF1.click();
		String actual_FailureMsg = success_Message.getText();
		System.out.println("Actual Failure Message:-" + actual_FailureMsg);
		String expected_FailureMsg = "["+wfName+"] contains one or more invalid steps/entries";
		System.out.println("Expected Failure Message:-" + expected_FailureMsg);
		Assert.assertEquals(actual_FailureMsg, expected_FailureMsg, "Workflow Enabled successfully");
		informationpage.validateSignOut();
	}
	public void validateUploadPluginWithAssignToAllTenantFewPlugins(String pName1,String pName2,String wfName) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		// Click Upload zip button
		wait.until(ExpectedConditions.visibilityOf(uploadZipBtn));
		js.executeScript("arguments[0].click();", uploadZipBtn);
		Reporter.log("Upload zip button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		chooseFileFromLocation.sendKeys(prop.getProperty("uploadPluginFile"));
		Thread.sleep(3000);
		uploadBtn.click();
		Reporter.log("Plugin zip started uploading",true);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		WebElement plugin1 = driver.findElement(By.xpath("(//table/tbody/tr/td[text()='"+pName1+"']/../td/input)[1]"));
		js.executeScript("arguments[0].click();", plugin1);
		Reporter.log("Plugin "+pName1+" is clicked",true);
		WebElement plugin2 = driver.findElement(By.xpath("(//table/tbody/tr/td[text()='"+pName2+"']/../td/input)[1]"));
		js.executeScript("arguments[0].click();", plugin2);
		Reporter.log("Plugin "+pName2+" is clicked",true);
		Thread.sleep(2000);
		saveBtn.click();
		Reporter.log("Save button is selected",true);
		Thread.sleep(6000);
		informationpage.validateSignOut();
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF1=driver.findElement(By.xpath("//table/tr/td[@title='"+wfName+"']/../td/label/span"));
		sliderToEnableWF1.click();
		String actual_FailureMsg = success_Message.getText();
		System.out.println("Actual Failure Message:-" + actual_FailureMsg);
		String expected_FailureMsg = "["+wfName+"] contains one or more invalid steps/entries";
		System.out.println("Expected Failure Message:-" + expected_FailureMsg);
		Assert.assertEquals(actual_FailureMsg, expected_FailureMsg, "Workflow Enabled successfully");
		informationpage.validateSignOut();
	}
	public void validateUploadSinglePluginsAssignToAll() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		Thread.sleep(3000);
		uploadDropdown.click();
		Thread.sleep(1000);
		newPlugin.click();
		Reporter.log("New Plugin button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		uploadJar.sendKeys(prop.getProperty("uploadSinglePluginAssignToAll"));
		Thread.sleep(3000);
		assignToAllCheckbox.click();
		Reporter.log("Assign to all checkbox is clicked",true);
		uploadSingeJarBtn.click();
		Reporter.log("Single Plugin Jar started uploading",true);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		String actual_success_msg =alertMessage.getText();
		String expected_success_msg =Messages.singlePluginUpload;
		System.out.println("actual success msg is: " + actual_success_msg);
		Assert.assertEquals(actual_success_msg, expected_success_msg, "Single Plugin not uploaded.");
		Reporter.log("Single plugin jar uploaded successfully");
		informationpage.validateSignOut();
	}
	public void validateUploadSinglePluginSameVersion(String pluginName) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",pluginsTab);
		Thread.sleep(5000);
		uploadDropdown.click();
		Thread.sleep(1000);
		newPlugin.click();
		Reporter.log("New Plugin button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		uploadJar.sendKeys(prop.getProperty("uploadSinglePluginFile"));
		Thread.sleep(3000);
		uploadSingeJarBtn.click();
		Reporter.log("Single Plugin Jar of same version is started uploading",true);
		Thread.sleep(2000);
		String actual_success_msg =alertMessage.getText();
		String expected_success_msg ="Duplicate plugin name ["+pluginName+"]";
		Reporter.log("actual success msg is: " + actual_success_msg);
		Reporter.log("expected success msg is: " + expected_success_msg);
		Assert.assertEquals(actual_success_msg, expected_success_msg, "Single Plugin with same version is uploaded.");
		Reporter.log("Single plugin jar with same version is not uploaded successfully");
		informationpage.validateSignOut();
	}
	public void validateSinglePluginUploadHigherVersion(String pluginName) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",pluginsTab);
		Thread.sleep(5000);
		String actual_PluginVersion = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+pluginName+"']/../td[2]")).getText();
		System.out.println("Actual Plugin Version:-"+actual_PluginVersion);
		Thread.sleep(2000);
		WebElement editBtn = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+pluginName+"']/../td/span[@title='Edit Plugin']"));
		editBtn.click();
		Thread.sleep(2000);
		updateUploadJar.sendKeys(prop.getProperty("uploadHigherVersionPlugin"));
		Thread.sleep(2000);
		saveBtn.click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		String actual_success_msg =alertMessage.getText();
		String expected_success_msg =Messages.singlePluginUpload;
		System.out.println("actual success msg is: " + actual_success_msg);
		Assert.assertEquals(actual_success_msg, expected_success_msg, "Single Plugin not uploaded.");
		Thread.sleep(2000);
		String expected_PluginVersion = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+pluginName+"']/../td[2]")).getText();
		System.out.println("Expected Plugin Version:-"+expected_PluginVersion);
		Thread.sleep(2000);
		Assert.assertNotEquals(actual_PluginVersion, expected_PluginVersion,"Plugin version are same");
		Reporter.log("Single plugin jar of higher version is uploaded successfully");
		informationpage.validateSignOut();
	}
	public void validateSinglePluginUploadLowerVersion(String pluginName) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",pluginsTab);
		Thread.sleep(5000);
		String actual_PluginVersion = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+pluginName+"']/../td[2]")).getText();
		System.out.println("Actual Plugin Version:-"+actual_PluginVersion);
		Thread.sleep(2000);
		WebElement editBtn = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+pluginName+"']/../td/span[@title='Edit Plugin']"));
		editBtn.click();
		Thread.sleep(2000);
		updateUploadJar.sendKeys(prop.getProperty("uploadLowerVersionPlugin"));
		Thread.sleep(2000);
		saveBtn.click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		String actual_success_msg =alertMessage.getText();
		String expected_success_msg =Messages.singlePluginUpload;
		System.out.println("actual success msg is: " + actual_success_msg);
		Assert.assertEquals(actual_success_msg, expected_success_msg, "Single Plugin not uploaded.");
		Thread.sleep(2000);
		String expected_PluginVersion = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+pluginName+"']/../td[2]")).getText();
		System.out.println("Expected Plugin Version:-"+expected_PluginVersion);
		Thread.sleep(2000);
		Assert.assertNotEquals(actual_PluginVersion, expected_PluginVersion,"Plugin version are same");
		Reporter.log("Single plugin jar of lower version is uploaded successfully");
		informationpage.validateSignOut();
	}
	public void validateStepUnit(String pluginName,String stepUnitCount) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",pluginsTab);
		Thread.sleep(2000);
		WebElement stepUnitBtn = driver.findElement(By.xpath("//table/tbody/tr/td[@title='"+pluginName+"']/../td/span[@title='Plugin Steps']"));
		stepUnitBtn.click();
		Thread.sleep(5000);
		String Actual_stepUnitCount = driver.findElement(By.xpath("//div[@class='modal-body step-window-body']/table/tbody/tr/td[text()='"+pluginName+"']/../td[4]")).getText();
		String Expected_stepUnitCount = stepUnitCount;
		Assert.assertEquals(Actual_stepUnitCount, Expected_stepUnitCount,"Step Unit Count did not Matched");
		informationpage.validateSignOut();
	}
	public void validatePluginUploadWithoutAssignToAllTenant() throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		// Click Upload zip button
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(uploadZipBtn));
		js.executeScript("arguments[0].click();", uploadZipBtn);
		Reporter.log("Upload zip button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		chooseFileFromLocation.sendKeys(prop.getProperty("uploadITPluginFile"));
		Thread.sleep(3000);
		uploadBtn.click();
		Reporter.log("Plugin zip started uploading",true);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", upgradeAllBox);
		Reporter.log("Upgrade all plugin checkbox is selected",true);
		Thread.sleep(1000);
		if (!assignAllBox.isSelected()) {
			assignAllBox.click();
			assignAllBox.click();
		} else {
			System.out.println("Assign to checkbox is already unselected");
		}
		Reporter.log("Assign to all checkbox is unselected",true);
		Thread.sleep(1000);
		saveBtn.click();
		Reporter.log("Save button is selected",true);
		Thread.sleep(10000);
		informationpage.validateSignOut();
	}
	public void validatePluginUploadWithAssignToAllTenantFewPlugins(String pName1,String pName2,String pName3) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugins Tab is selected",true);
		// Click Upload zip button
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(uploadZipBtn));
		js.executeScript("arguments[0].click();", uploadZipBtn);
		Reporter.log("Upload zip button clicked",true);
		Thread.sleep(2000);
		//choose file from location
		chooseFileFromLocation.sendKeys(prop.getProperty("uploadITPluginFile"));
		Thread.sleep(3000);
		uploadBtn.click();
		Reporter.log("Plugin zip started uploading",true);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", upgradeAllBox);
		Reporter.log("Upgrade all plugin checkbox is selected",true);
		Thread.sleep(1000);
		if (!assignAllBox.isSelected()) {
			assignAllBox.click();
			assignAllBox.click();
		} else {
			System.out.println("Assign to checkbox is already unselected");
		}
		Thread.sleep(2000);
		//Selecting Few Plugins
		WebElement plugin1 = driver.findElement(By.xpath("(//table/tbody/tr/td[text()='"+pName1+"']/../td/input[@type='checkbox'])[2]"));
		plugin1.click();
		WebElement plugin2 = driver.findElement(By.xpath("(//table/tbody/tr/td[text()='"+pName2+"']/../td/input[@type='checkbox'])[2]"));
		plugin2.click();
		WebElement plugin3 = driver.findElement(By.xpath("(//table/tbody/tr/td[text()='"+pName3+"']/../td/input[@type='checkbox'])[2]"));
		plugin3.click();
		Thread.sleep(1000);
		saveBtn.click();
		Reporter.log("Save button is selected",true);
		Thread.sleep(5000);
		informationpage.validateSignOut();
	}
	public void validatePluginAccessTenantAssignAllOptionSelected(String PageSize) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",pluginsTab);
		Thread.sleep(5000);
		wb.changePageSize(PageSize);
		Thread.sleep(3000);
		List<WebElement> ActualTable_content = driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tbody/tr/td[1]"));
		ArrayList<String> actual_Plugin = new ArrayList<String>();
		for (WebElement element : ActualTable_content) {
			String element_value = element.getText();
			System.out.println(element_value);
			actual_Plugin.add(element_value);
			Thread.sleep(4000);
		}
		System.out.println("Actual content in the table is :" +actual_Plugin);
		Thread.sleep(5000);
		informationpage.validateSignOut();
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",pluginsTab);
		Thread.sleep(5000);
		wb.changePageSize(PageSize);
		Thread.sleep(5000);
		List<WebElement> ExpectedTable_content = driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tbody/tr/td[1]"));
		ArrayList<String> expected_Plugin = new ArrayList<String>();
		for (WebElement element : ExpectedTable_content) {
			String element_value = element.getText();
			System.out.println(element_value);
			expected_Plugin.add(element_value);
			Thread.sleep(4000);
		}
		System.out.println("Expected content in the table is :" +expected_Plugin);
		Thread.sleep(4000);
		if(actual_Plugin.equals(expected_Plugin)) {
			Assert.assertTrue(true);
			Reporter.log("Actual Plugin and Expected Plugin are Equal",true);
		} else {
			Assert.assertTrue(false);
			Reporter.log("Actual Plugin and Expected Plugin are not Equal",true);
		} 
		informationpage.validateSignOut();
	}
	public void validatePluginAccessTenantAssignAllOptionNotSelected(String tName,String tDescription,String PageSize,String tenantOrgCode,String FName,String LName,
			String UserMail,String UserName,String Pswd,String ConfirmPswd,String RoleName,String password) throws Exception{
		tenantspage.addNewTenants(tName,tDescription,tenantOrgCode);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",pluginsTab);
		Thread.sleep(5000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement> ActualTable_content = driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tbody/tr/td[1]"));
		ArrayList<String> actual_Plugin = new ArrayList<String>();
		for (WebElement element : ActualTable_content) {
			String element_value = element.getText();
			System.out.println(element_value);
			actual_Plugin.add(element_value);
			Thread.sleep(4000);
		}
		int PluginCount = actual_Plugin.size();
		String actual_PluginCount = Integer.toString(PluginCount);
		System.out.println("Actual content in the table is :" +actual_PluginCount);
		Thread.sleep(5000);
		informationpage.validateSignOut();
		tenantuserpage.creatingTenantUser(tenantOrgCode, FName, LName, UserMail, UserName,Pswd, ConfirmPswd, RoleName);
		loginpage.ValidateFirstTimeLogin(UserName, ConfirmPswd, password);
		loginpage.login(prop.getProperty("username_PA"), prop.getProperty("password_PA"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",pluginsTab);
		Thread.sleep(5000);
		wb.changePageSize(PageSize);
		Thread.sleep(5000);
		List<WebElement> ExpectedTable_content = driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tbody/tr/td[1]"));
		ArrayList<String> expected_Plugin = new ArrayList<String>();
		for (WebElement element : ExpectedTable_content) {
			String element_value = element.getText();
			System.out.println(element_value);
			expected_Plugin.add(element_value);
			Thread.sleep(4000);
		}
		int plugincount = expected_Plugin.size();
		String expected_PluginCount = Integer.toString(plugincount);
		System.out.println("Expected content in the table is :" +expected_PluginCount);
		Thread.sleep(4000);
		if(!actual_PluginCount.equals(expected_PluginCount)) {
			Assert.assertTrue(true);
			Reporter.log("Actual Plugin Count and Expected Plugin Count are not Equal",true);
		} else {
			Assert.assertTrue(false);
			Reporter.log("Actual Plugin Count and Expected Plugin Count are Equal",true);
		} 
		informationpage.validateSignOut();
	}
	public void validatePluginsPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",pluginsTab);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpage.validateSignOut();
	}

	public void validateAdvSearch() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js_tenant.executeScript("arguments[0].click();", pluginsTab);
		wb.validateClickOnAdvanceSearch();
	}

	public void validateAdvSearchForPluginNameEqualTo(String SearchColumn,String SearchCriteria,
			String pluginName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, pluginName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Plugin record present in table are :"+op.size());
			Thread.sleep(5000);
			String actual_PluginName=op.get(i).getText();
			System.out.println("actual_Plugin Name present in table are: "+actual_PluginName);
			Assert.assertTrue(actual_PluginName.equals(pluginName));
		}
	}
	public void validateAdvSearchForPluginNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String pluginName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, pluginName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Plugin record present in table are :"+op.size());
			Thread.sleep(5000);
			String actual_PluginName=op.get(i).getText();
			System.out.println("actual_Plugin Name present in table are: "+actual_PluginName);
			Assert.assertFalse(actual_PluginName.equals(pluginName));
		}
	}
	public void validateAdvSearchForPluginNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Plugin record present in table are :"+op.size());
			Thread.sleep(5000);
			String actual_PluginName=op.get(i).getText();
			System.out.println("actual_Plugin Name present in table are: "+actual_PluginName);
			Assert.assertTrue(actual_PluginName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForPluginNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Plugin record present in table are :"+op.size());
			Thread.sleep(5000);
			String actual_PluginName=op.get(i).getText();
			String lowercase_PluginName = actual_PluginName.toLowerCase();
			System.out.println("actual_Plugin Name present in table are: "+actual_PluginName);
			Assert.assertTrue(lowercase_PluginName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForPluginNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Plugin record present in table are :"+op.size());
			Thread.sleep(5000);
			String actual_PluginName=op.get(i).getText();
			System.out.println("actual_Plugin Name present in table are: "+actual_PluginName);
			Assert.assertTrue(actual_PluginName.contains(advSearchFor));
		}
	}
	public void validateHandleCalender(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", pluginsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate);
		Thread.sleep(2000);
	}
	public void validateHandleCalenderForLastModified(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", pluginsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Last Modified",CreatedCriteria,startYear,startMonth,startDate);
		Thread.sleep(2000);
	}

	public void validateCreatedEqualTo(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalender(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[5]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[5]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[5]"));
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
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", pluginsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[5]"));
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
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", pluginsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[5]"));
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
	public void validateLastModifiedCreatedEqualTo(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalenderForLastModified(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[6]"));
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

	public void validateLastModifiedCreatedBefore(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalenderForLastModified(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+actual_Date);
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
	public void validateLastModifiedCreatedAfter(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalenderForLastModified(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[6]"));
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
	public void validateLastModifiedCreatedInBetween(String CreatedCriteria,String startYear,String startMonth,String startDate,
			String endYear,String endMonth,String endDate,String PageSize) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", pluginsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Last Modified",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[6]"));
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
	public void validateLastModifiedCreatedNotInBetween(String CreatedCriteria,String startYear,String startMonth,String startDate,
			String endYear,String endMonth,String endDate,String PageSize) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", pluginsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Last Modified",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[6]"));
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
	public void validateSearchFunctionalityPlugin(String PageSize,String PluginName) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", pluginsTab);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		searchField.sendKeys(PluginName);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Plugin record present in table are :"+op.size());
			Thread.sleep(5000);
			String actual_PluginName=op.get(i).getText();
			System.out.println("actual_Plugin Name present in table are: "+actual_PluginName);
			Assert.assertTrue(actual_PluginName.equalsIgnoreCase(PluginName));
		}
	}
}
