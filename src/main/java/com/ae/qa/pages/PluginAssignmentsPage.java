package com.ae.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class PluginAssignmentsPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 220);
	public LoginPage loginpage = new LoginPage();
	public WebElements webelements = new WebElements();
	public InformationPage informationpage=new InformationPage();
	public TenantsPage tenantpage=new TenantsPage();
	public TenantUsersPage tenantuserspage=new TenantUsersPage();
	public PluginsPage pluginspage=new PluginsPage();
	public WorkflowListPageTA workflowpage = new WorkflowListPageTA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//span[(text()='Plugins')]")
	WebElement pluginsTab;
	@FindBy(xpath = "//a[text()='Plugin Assignments']")
	WebElement pluginAssignmentsTab;
	@FindBy(id = "pluginRadio")
	WebElement pluginRadioBtn;
	@FindBy(id = "tenantRadio")
	WebElement tenantRadioBtn;
	@FindBy(id = "dropDownElement")
	WebElement pluginList;
	@FindBy(id = "edit-button")
	WebElement editBtn;
	@FindBy(id = "select-all")
	WebElement selectAllTenant;
	@FindBy(xpath = "//button[@id='popup-button-ok']")
	WebElement okBtn;
	@FindBy(id = "uploadButton")
	WebElement saveBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement success_Message;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Workflow List']")
	WebElement workflowListTab;
	@FindBy(xpath="//input[@id='select-KG01']")
	WebElement tenantCheckbox;
	@FindBy(name = "upload-zip")
	WebElement uploadZipBtn;
	@CacheLookup
	@FindBy(id = "pluginsFile")
	WebElement chooseFile;
	@FindBy(xpath = "//input[@id='pluginsFile']")
	WebElement chooseFileFromLocation;
	@FindBy(id = "uploadButton")
	WebElement uploadBtn;
	@FindBy(id = "select-all")
	WebElement upgradeAllBox;
	@FindBy(id = "select-all-assignment")
	WebElement assignAllBox;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement SaveBtn;
	@FindBy(xpath="(//span[@class='fa fa-caret-right'])[2]")
	WebElement configParamBar;
	@FindBy(id = "no1")
	WebElement configParam1;
	@FindBy(id = "no2")
	WebElement configParam2;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement success_msg;
	

	public PluginAssignmentsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void validateAssignPluginSingleTenant(String tenantName,String tDescp,String Orgcode,
			String pluginName, String tenanOrgCode) throws Exception {
		//first create tenant and then assign plugin to it
		tenantpage.addNewTenants(tenantName,tDescp,Orgcode);
		Reporter.log("Tenant is created successfully, now assign specific plugin to that tenant");
		Thread.sleep(2000);
		driver.navigate().to(prop.getProperty("url"));
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		// click on plugin Assignments Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginAssignmentsTab));
		js.executeScript("arguments[0].click();", pluginAssignmentsTab);
		Thread.sleep(3000);
		// Verify if pluginRadio btn is already selected
		if (!pluginRadioBtn.isSelected()) {
			pluginRadioBtn.click();
		} else {
			System.out.println("Plugin Radio Btn is already selected");
		}

		Select plugin_dropdwn = new Select(pluginList);
		plugin_dropdwn.selectByValue(pluginName);
		Thread.sleep(3000);
		editBtn.click();
		Thread.sleep(7000);
		// verify if all tenant org code is selected-deselect it first and then select
		// single tenant
		if (selectAllTenant.isSelected()) {
			selectAllTenant.click();
			System.out.println(
					"Tenant orgcode select all checkbox deselected and now please select single tenant org code");
		} else {
			for (int i = 0; i < 2; i++) {
				selectAllTenant.click();
			}
			System.out.println("Please select single tenant org code");
		}
		okBtn.click();
		Thread.sleep(2000);
		WebElement tenant_Orgcode = driver.findElement(By.xpath("//input[@id='select-" + tenanOrgCode + "']"));
		tenant_Orgcode.click();
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", saveBtn);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String Actual_successMsg = success_Message.getText();
		System.out.println("Actual Sucess Message" + Actual_successMsg);
		String Expected_successMsg = Messages.assignPluginSingleTenant ;
		System.out.println("Expected Sucess Message" + Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Plugin not assigned to single tenant.");
		Reporter.log("Plugin assigned to single tenant",true);
		informationpage.validateSignOut();
	}
	//assign tenant specific plugin
	public void validateAssignTenantSinglePlugin(String tenantCode,String pluginName) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		// click on pluginAssignments Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginAssignmentsTab));
		js.executeScript("arguments[0].click();", pluginAssignmentsTab);
		wait.until(ExpectedConditions.visibilityOf(tenantRadioBtn));
		// Verify if pluginRadio btn is already selected
		if (!tenantRadioBtn.isSelected()) {
			tenantRadioBtn.click();
		} else {
			Reporter.log("Tenant Radio Btn is already selected",true);
		}
		Thread.sleep(5000);
		Select tenant_dropdwn = new Select(pluginList);
		tenant_dropdwn.selectByValue(tenantCode);
		Thread.sleep(5000);
		editBtn.click();
		/*	wait.until(ExpectedConditions.visibilityOf(selectAllTenant));
		// verify if all plugins are selcted if yes then deselct and then select single plugin which needs to assign
		if (selectAllTenant.isSelected()) {
			Reporter.log("If all plugins are already selected then we need to deslect it first",true);
			selectAllTenant.click();
			okBtn.click();
			Reporter.log(
					"Plugin name select all checkbox deselected and now please select single Plugin",true);
		} else {
			for (int i = 0; i < 2; i++) {
				selectAllTenant.click();
			}
			Reporter.log("Please select single plugin",true);
		}*/
		Thread.sleep(2000);
		WebElement plugin_Name = driver.findElement(By.xpath("//input[@id='select-" + pluginName + "']"));
		if(!plugin_Name.isSelected()) {
			plugin_Name.click();
		} else {
			System.out.println(pluginName+" is already selected");
		}
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", saveBtn);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Actual_successMsg = success_Message.getText();
		System.out.println("Actual Sucess Message: " + Actual_successMsg);
		String Expected_successMsg = Messages.assignPluginSingleTenant ;
		System.out.println("Expected Sucess Message: " + Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Single Plugin not assigned to desired tenant.");
		Reporter.log("Single plugin assigned to desired tenant",true);
		informationpage.validateSignOut();
	}
	public void validateAssignPluginAllTenant(String pluginName) throws Exception {
		//Here first upload single plugin and then assign it to multiple/all tenants
		pluginspage.validateUploadSinglePlugins(prop.getProperty("uploadJarFile1"));
		Reporter.log("New plugin jar is uploaded now we will assign it to all tenants");
		Thread.sleep(2000);
		driver.navigate().to(prop.getProperty("url"));
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		// click on pluginAssignments Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginAssignmentsTab));
		js.executeScript("arguments[0].click();", pluginAssignmentsTab);
		Thread.sleep(3000);
		// Verify if pluginRadio btn is already selected
		if (!pluginRadioBtn.isSelected()) {
			pluginRadioBtn.click();
		} else {
			System.out.println("Plugin Radio Btn is already selected");
		}
		Select plugin_dropdwn = new Select(pluginList);
		plugin_dropdwn.selectByValue(pluginName);
		Thread.sleep(3000);
		editBtn.click();
		wait.until(ExpectedConditions.visibilityOf(selectAllTenant));
		// verify if all tenant org code is deselected first and then select all tenant
		if (!selectAllTenant.isSelected()) {
			selectAllTenant.click();
			System.out.println(
					"All tenant selected");
		} else {
			System.out.println("all tenant already selected");
		}
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", saveBtn);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String Actual_successMsg = success_Message.getText();
		System.out.println("Actual Sucess Message: " + Actual_successMsg);
		String Expected_successMsg=Messages.assignPluginSingleTenant;
		System.out.println("Expected Sucess Message: " + Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Plugin not assigned to all tenant.");
		Reporter.log("Plugin assigned to all tenant successfully",true);
		informationpage.validateSignOut();
	}

	public void validateAssignPluginToMultipleTenants(String pluginName, String tenantOrgCode1,String tenantOrgCode2,String tenantOrgCode3) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		// click on pluginAssignments Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginAssignmentsTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", pluginAssignmentsTab);
		Thread.sleep(3000);
		// Verify if pluginRadio btn is already selected
		if (!pluginRadioBtn.isSelected()) {
			pluginRadioBtn.click();
		} else {
			System.out.println("Plugin Radio Btn is already selected");
		}

		Select plugin_dropdwn = new Select(pluginList);
		plugin_dropdwn.selectByValue(pluginName);
		Thread.sleep(3000);
		editBtn.click();
		Thread.sleep(7000);
		// verify if all tenant org code is selected-deselect it first and then select
		// single tenant
		if (selectAllTenant.isSelected()) {
			selectAllTenant.click();
			System.out.println(
					"Tenant orgcode select all checkbox deselected and now please select multiple tenant org code");
		} else {
			for (int i = 0; i < 2; i++) {
				selectAllTenant.click();
			}
			System.out.println("Please select Multiple tenants org code");

		}
		okBtn.click();
		Thread.sleep(2000);
		WebElement tenant_Orgcode1 = driver.findElement(By.xpath("//input[@id='select-" + tenantOrgCode1 + "']"));
		tenant_Orgcode1.click();
		Thread.sleep(2000);
		WebElement tenant_Orgcode2 = driver.findElement(By.xpath("//input[@id='select-" + tenantOrgCode2 + "']"));
		tenant_Orgcode2.click();
		Thread.sleep(2000);
		WebElement tenant_Orgcode3 = driver.findElement(By.xpath("//input[@id='select-" + tenantOrgCode3 + "']"));
		tenant_Orgcode3.click();
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", saveBtn);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String Actual_successMsg = success_Message.getText();
		System.out.println("Actual Sucess Message" + Actual_successMsg);
		String Expected_successMsg = Messages.assignPluginSingleTenant ;
		System.out.println("Expected Sucess Message" + Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Plugin not assigned to multiple tenants.");
		Reporter.log("Plugin assigned to multiple tenant",true);
		informationpage.validateSignOut();

	}
	public void validateAssignTenantMultiplePlugins(String TenantCode, String PluginName1,String PluginName2) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		// click on pluginAssignments Tab
		//wait.until(ExpectedConditions.visibilityOf(pluginAssignmentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", pluginAssignmentsTab);
		wait.until(ExpectedConditions.visibilityOf(tenantRadioBtn));
		// Select tenant radio button
		tenantRadioBtn.click();
		Reporter.log("Tenant Radio Btn is selected",true);
		Thread.sleep(5000);
		Select tenant_dropdwn = new Select(pluginList);
		tenant_dropdwn.selectByValue(TenantCode);
		Thread.sleep(5000);
		editBtn.click();
		wait.until(ExpectedConditions.visibilityOf(selectAllTenant));
		// verify if all plugins are selected if yes,deselect and then select specific ones
		if (selectAllTenant.isSelected()) {
			Reporter.log("If all plugins are already selected then we need to deselect it first",true);
			selectAllTenant.click();
			okBtn.click();
			Reporter.log(
					"Plugin name select all checkbox deselected and now please specific Plugins which needs to assign tenant",true);
		} else {
			for (int i = 0; i < 2; i++) {
				selectAllTenant.click();
			}
			Reporter.log("Please select specific/multiple plugins",true);
		}
		Thread.sleep(2000);
		WebElement plugin_Name1 = driver.findElement(By.xpath("//input[@id='select-" + PluginName1 + "']"));
		Reporter.log(PluginName1+" is selected", true);
		/*	if(!plugin_Name1.isSelected()) {
		plugin_Name1.click();
		} else {
			System.out.println(PluginName1+" is already selected");
		}*/
		Thread.sleep(5000);
		WebElement plugin_Name2 = driver.findElement(By.xpath("//input[@id='select-" + PluginName2 + "']"));
		Reporter.log(PluginName2+" is selected", true);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", saveBtn);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Actual_successMsg = success_Message.getText();
		System.out.println("Actual Sucess Message" + Actual_successMsg);
		String Expected_successMsg = Messages.assignPluginSingleTenant ;
		System.out.println("Expected Sucess Message" + Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Single Plugin not assigned to desired tenant.");
		Reporter.log("Single plugin assigned to desired tenant",true);
		informationpage.validateSignOut();
	}
	public void validateAssignTenantAllPlugins(String TenantCode) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		// click on pluginAssignments Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(pluginAssignmentsTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", pluginAssignmentsTab);
		wait.until(ExpectedConditions.visibilityOf(tenantRadioBtn));
		// Select tenant radio button
		tenantRadioBtn.click();
		Reporter.log("Tenant Radio Btn is selected",true);
		Thread.sleep(5000);
		Select tenant_dropdwn = new Select(pluginList);
		tenant_dropdwn.selectByValue(TenantCode);
		Thread.sleep(5000);
		editBtn.click();
		wait.until(ExpectedConditions.visibilityOf(selectAllTenant));
		// verify if all plugins are selected if yes,deselect and then select specific ones
		if (!selectAllTenant.isSelected()) {
			selectAllTenant.click();
			Reporter.log("All Plugins selected",true);
		} else {
			Reporter.log("all plugins are already selected",true);
		}
		Thread.sleep(5000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", saveBtn);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Actual_successMsg = success_Message.getText();
		System.out.println("Actual Sucess Message" + Actual_successMsg);
		String Expected_successMsg = Messages.assignPluginSingleTenant ;
		System.out.println("Expected Sucess Message" + Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "All Plugins are not assigned to desired tenant.");
		Reporter.log("All plugins are assigned to desired tenant",true);
		informationpage.validateSignOut();	
	}
	//Method for workflow
	public void validateImportWFForPlugin(String wfName,String value1,String value2) throws InterruptedException{
		configParamBar.click();
		Thread.sleep(2000);
		configParam1.sendKeys(value1);
		configParam2.sendKeys(value2);
		SaveBtn.click();
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
		informationpage.validateSignOut();
	}
	public void validateWFInActiveAfterSysadminRemovesPluginPermission(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit,String value1,String value2,String pluginName) throws Exception{
		//Need to hard the values
		workflowpage.ImportForm(wfName, wfdes, category, WFImportPath, priority,
				expTime, maxTime, cleanUpHrs, manExeTime, tUnit);
		validateImportWFForPlugin(wfName,value1,value2);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Plugins Tab
		wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		Reporter.log("Plugin Tab is Selected",true);
		// click on pluginAssignments Tab
		wait.until(ExpectedConditions.visibilityOf(pluginAssignmentsTab));
		js.executeScript("arguments[0].click();", pluginAssignmentsTab);
		Reporter.log("Plugin Assignment tab is Selected",true);
		if (!pluginRadioBtn.isSelected()) {
			pluginRadioBtn.click();
		} else {
			System.out.println("Plugin Radio Btn is already selected");
		}

		Select plugin_dropdwn = new Select(pluginList);
		plugin_dropdwn.selectByValue(pluginName);
		Thread.sleep(3000);
		editBtn.click();
		Thread.sleep(7000);
		tenantCheckbox.click();
		Reporter.log("Tenant Checkbox is unchecked",true);
		okBtn.click();
		Thread.sleep(2000);
		saveBtn.click();
		Reporter.log("Save Button is Clicked",true);
		Thread.sleep(4000);
		String Actual_SuccessMsg = success_Message.getText();
		System.out.println("Actual Success Message" + Actual_SuccessMsg);
		String Expected_SuccessMsg = Messages.assignPluginSingleTenant;
		System.out.println("Expected Success Message" + Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Plugin assignment is not successfully");
		informationpage.validateSignOut();
		//Login with tenant admin and checking wf can be made inactive
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr/td[@title='"+wfName+"']/../td/label/span"));
		String color = sliderToEnableWF.getCssValue("background-color");
		String HexColor = Color.fromString(color).asHex();
		Reporter.log("HexColor of WF Slider:-"+HexColor);
		if(HexColor.equals(prop.getProperty("GreySlider"))){
			String actual_SliderColor = HexColor;
			System.out.println("Actual Color of Inactive WF Slider:-"+actual_SliderColor);
			String expected_SliderColor = prop.getProperty("GreySlider");
			System.out.println("Expected Color of Inactive WF Slider:-"+expected_SliderColor);
			Assert.assertEquals(actual_SliderColor, expected_SliderColor, "Workflow is not in Inactive state");
			informationpage.validateSignOut();
		}
		else if(HexColor.equals(prop.getProperty("BlueSlider"))){
			String actual_SliderColor = HexColor;
			System.out.println("Actual Color of Inactive WF Slider:-"+actual_SliderColor);
			String expected_SliderColor = prop.getProperty("GreySlider");
			System.out.println("Expected Color of Inactive WF Slider:-"+expected_SliderColor);
			Assert.assertEquals(actual_SliderColor, expected_SliderColor, "Workflow is not in Inactive state");
		}
	}
	public void validateWFActiveAfterSysadminRemovesPluginPermission(String wfName) throws Exception{
		//Login with tenant admin and checking wf can be made inactive
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(2000);
		WebElement sliderToEnableWF=driver.findElement(By.xpath("//table/tr/td[@title='"+wfName+"']/../td/label/span"));
		sliderToEnableWF.click();
		String Actual_FailureMsg = success_Message.getText();
		System.out.println("Actual Failure Message" + Actual_FailureMsg);
		String Expected_FailureMsg = "["+wfName+"] contains one or more invalid steps/entries";
		System.out.println("Expected Failure Message" + Expected_FailureMsg);
		Assert.assertEquals(Actual_FailureMsg, Expected_FailureMsg, "Workflow is made active successfully");
		Reporter.log("Plugin permission is removed so workflow cannot be made inactive",true);
		informationpage.validateSignOut();	
	}
	public void validateUploadPluginWithoutAssignToAllTenant() throws Exception{
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
		js.executeScript("arguments[0].click();", upgradeAllBox);
		Reporter.log("Upgrade all plugin checkbox is selected",true);
		Thread.sleep(1000);
		if (!assignAllBox.isSelected()) {
			assignAllBox.click();
			assignAllBox.click();
		} else {
			System.out.println("Assign to checkbox is already selected");
			assignAllBox.click();
		}
		Reporter.log("Assign to all checkbox is unselected",true);
		Thread.sleep(1000);
		SaveBtn.click();
		Reporter.log("Save button is selected",true);
		Thread.sleep(6000);
		informationpage.validateSignOut();
	}
	public void validateAdvSearch() throws Exception {
		loginpage.login("PluginUser1","Pune@1234");
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", pluginsTab);
		wb.validateClickOnAdvanceSearch();
	}
	public void validatePluginAccessAssignToAllSelected(String tName, String tDescription, String orgCode,String FName,String LName,String UserMail,
			String Username ,String FT_password ,String RoleName,String password,
			String SearchColumn,String SearchCriteria,String pluginName,String PageSize) throws Exception {
		pluginspage.validateUploadSinglePluginsAssignToAll();
		tenantpage.addNewTenants(tName, tDescription, orgCode);
		tenantuserspage.creatingTenantUser(orgCode,FName, LName, UserMail,Username,FT_password,FT_password,RoleName);
		loginpage.ValidateFirstTimeLogin(Username, FT_password, password);
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, pluginName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new Plugin record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='workflow-list-container table-responsive']/table/tbody/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Plugin record present in table are :"+op.size());
			Thread.sleep(5000);
			String actual_PluginName=op.get(i).getText();
			System.out.println("actual_Plugin Name present in table are: "+actual_PluginName);
			Assert.assertTrue(actual_PluginName.equals(pluginName));
			informationpage.validateSignOut();
		}
	}
	public void validatePluginAccessAssignToAllNotSelected(String SearchColumn,String SearchCriteria,String pluginName,String PageSize) throws Exception{
	    //ALready vb script plugin is added without assign to all tenant option
		pluginspage.validateAdvSearchForPluginNameEqualTo(SearchColumn,SearchCriteria,pluginName,PageSize);
		informationpage.validateSignOut();
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, pluginName);
		Thread.sleep(2000);
		// Verify data in table now
		WebElement success_Msg = driver.findElement(By.xpath("//table/tr/td/i/b"));
		String actual_Message = success_Msg.getText();
		System.out.println("Actual success_Message:-"+actual_Message);
		String expected_Message=Messages.recordFoundMessage;
		System.out.println("Expected success_Message:-"+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message, "Record is visible because assign to all tenant checkbox is selected");
		informationpage.validateSignOut();
	}
	public void validatePluginAssignmentsPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		// click Plugins Tab
		wait.until(ExpectedConditions.visibilityOf(pluginsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", pluginsTab);
		// click on pluginAssignments Tab
		wait.until(ExpectedConditions.visibilityOf(pluginAssignmentsTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", pluginAssignmentsTab);
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpage.validateSignOut();
	}
}
