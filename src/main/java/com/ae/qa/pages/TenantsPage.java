package com.ae.qa.pages;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.testng.asserts.SoftAssert;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.CataloguePageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class TenantsPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 180);
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage=new InformationPage();
	//	public WebElements webelements = new WebElements();
	public CataloguePageTA catalogueta = new CataloguePageTA();
	public WorkflowListPageTA workflowlistpageta = new WorkflowListPageTA();
	public TenantUsersPage tenantuserpage = new TenantUsersPage();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//h2")
	WebElement tenantsPageTitle;
	@FindBy(xpath = "//span[(text()='Tenants')]")
	WebElement tenantsTab;
	@FindBy(name = "add-tenant")
	WebElement addTenantBtn;
	@CacheLookup
	@FindBy(id = "tenantName")
	WebElement tenantName;
	@FindBy(id = "description")
	WebElement descriptionOfTenant;
	@FindBy(id = "orgCode")
	WebElement organizationCode;
	@FindBy(id = "fileBasedEnabled")
	WebElement fileBasedEnabled;
	@FindBy(name = "submit")
	WebElement createBtn;
	@FindBy(name = "cancel")
	WebElement cancelBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath = "//button[@title='Refresh Table']")
	WebElement rfshBtn;
	@FindBy(xpath = "//span[text()='No License']")
	WebElement licenseStatus;
	@FindBy(xpath="//*[@id='menu-search']/input")
	WebElement searchMenu;
	@FindBy(xpath = "//span[(text()='Settings')]")
	WebElement settingsTab;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath="//b[contains(text(),' Advanced Search')]")
	WebElement advSearchBtn;
	@FindBy(id = "popup-button-ok")
	WebElement disableBtn;
	@FindBy(xpath = "//span[text()='Catalogue']")
	WebElement catalogueTab;
	@FindBy(xpath="//button[@name='submit']")
	WebElement submitRequestBtn;
	@FindBy(xpath="//div[@class='card-body error']")
	WebElement disableTenantAlertMsg;
	@FindBy(id="popup-button-ok")
	WebElement okBtn;
	@FindBy(id="licenseCategory")
	WebElement licenseCategory;
	@FindBy(id="customerName")
	WebElement customerName;
	@FindBy(id="contactPerson")
	WebElement contactPerson;
	@FindBy(id="contactNumber")
	WebElement contactNumber;
	@FindBy(id="contactEmail")
	WebElement contactEmail;
	@FindBy(id="btnConsumtionbased")
	WebElement allotmentBasedTab;
	@FindBy(xpath="//button[@name='add-tenant']")
	WebElement createLicenseBtn;
	@FindBy(id="startDate-datepicker")
	WebElement startDate;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement monthDrpdown;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement yearDrpdown;
	@FindBy(id="validityInMonths")
	WebElement validateMonths;
	@FindBy(id="numberOfPs")
	WebElement processStudio;
	@FindBy(id="premiumStepUnit")
	WebElement premiumStepUnit;
	@FindBy(id="totalBotTime")
	WebElement botTime;
	@FindBy(id="submitBtn")
	WebElement submitBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement successMsgBox;
	@FindBy(xpath = "//button/span[@class='fa fa-edit']")
	WebElement amendBtn;

	public TenantsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateTenantsPageTitle() throws InterruptedException {
		// TODO Auto-generated method stub
		if (tenantsPageTitle.isDisplayed()) {
			return tenantsPageTitle.getText();
		} else {
			Thread.sleep(3000);
			return tenantsPageTitle.getText();
		}
	}

	public void addNewTenants(String tName, String tDescription, String orgCode) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Tenants Tab
		//wait.until(ExpectedConditions.visibilityOf(tenantsTab));
		Thread.sleep(5000);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", tenantsTab);
		// Click add Tenant button
		//wait.until(ExpectedConditions.visibilityOf(addTenantBtn));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addTenantBtn);
		// Fill details like Tenant Name, Description and Organization code
		//wait.until(ExpectedConditions.visibilityOf(tenantName));
		Thread.sleep(2000);
		tenantName.sendKeys(tName);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(descriptionOfTenant));
		descriptionOfTenant.sendKeys(tDescription);
		wait.until(ExpectedConditions.visibilityOf(organizationCode));
		organizationCode.sendKeys(orgCode);
		// Create button
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(createBtn));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", createBtn);
		// do advance search
		// Verify Success message
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		System.out.println("Success message: " + actual_successMsg);
		String expected_successMsg = Messages.createTenant;
		Assert.assertEquals(actual_successMsg, expected_successMsg, "Tenant not created successfully");
		Reporter.log("Tenant created successfully",true);
		// refresh the page
		// webelements.clickrefreshBtn();
		//js1.executeScript("arguments[0].click();", advSearchBtn);
		//	webelements.AdvanceSearchField("name", "eq", tName);
		//js1.executeScript("arguments[0].click();", advSearchBtn);
		//	webelements.ExtraAdvanceSearch("orgCode", "eq", orgCode);
		//	webelements.InputSearchField(tName);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable",true);
		String actual_TenantName = driver.findElement(By.xpath("//table/tr/td[text()='" + tName + "']")).getText();
		String expected_TenantName = tName;
		System.out.println("Actual:"+actual_TenantName+"Expected:"+expected_TenantName);
		Assert.assertEquals(actual_TenantName, expected_TenantName, "Tenant can not added in list");
		Reporter.log("New Tenant is present in the table-Validated successfully",true);
		informationpage.validateSignOut();
	}

	public void addNewTenantsWithDuplicateOrgCode(String ttName, String ttDescription, String oorgCode)
			throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Tenants Tab
		//wait.until(ExpectedConditions.visibilityOf(tenantsTab));
		Thread.sleep(5000);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", tenantsTab);
		// Click add Tenant button
		//wait.until(ExpectedConditions.visibilityOf(addTenantBtn));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addTenantBtn);
		// Fill details like Tenant Name, Description and Organization code
		//wait.until(ExpectedConditions.visibilityOf(tenantName));
		Thread.sleep(2000);
		tenantName.sendKeys(ttName);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(descriptionOfTenant));
		descriptionOfTenant.sendKeys(ttDescription);
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(organizationCode));
		organizationCode.sendKeys(oorgCode);
		// Create button
		//wait.until(ExpectedConditions.visibilityOf(createBtn));
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", createBtn);
		// Verify Success message
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_failureMsg = alertMessage.getText();
		Reporter.log("Failure message after entering same org code : " + actual_failureMsg,true);
		//	String expected_Msg = Messages.createTenant;
		//To make tc pass: String expected_Msg = "Duplicate orgcode ["+oorgCode+"].";
		String expected_failureMsg="Duplicate org code ["+oorgCode.toUpperCase()+"].";
		Assert.assertEquals(actual_failureMsg,expected_failureMsg,"User might not got correct error on duplicate org code");
		Reporter.log ("New Usernot created due to duplicate orgcode.",true);
		informationpage.validateSignOut();
	}

	public String createUniqueName() {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
		String datetime=ft.format(date);
		return datetime;
	}

	public void verifyLicenseInfo() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Tenants Tab
		//wait.until(ExpectedConditions.visibilityOf(tenantsTab));
		Thread.sleep(5000);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", tenantsTab);
		Thread.sleep(3000);
		String actual_licenseStatus = licenseStatus.getText();
		System.out.println("The License Status for System Admin is " + actual_licenseStatus);
		String expected_licenseStatus = "No License";
		Assert.assertEquals(actual_licenseStatus, expected_licenseStatus, "License Status could not match.");
		Reporter.log("License status verified", true);
		informationpage.validateSignOut();
	}
	public void validateTenantsPage(String TabName,String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		Thread.sleep(3000);
		//First search for tab and click on it
		searchMenu.sendKeys(TabName);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement tabname=driver.findElement(By.xpath("//*[text()='"+TabName+"']"));
		tabname.click();
		Reporter.log(TabName+ " tab is clicked",true);
		Thread.sleep(3000);
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Search functionality and appropriate page didn't loaded properly");
		Reporter.log("Search Functionality working fine for "+actual_title+" & Respective Page is clicked and "
				+ "appropriate page is loaded properly",true);
		informationpage.validateSignOut();
	}
	//For Agent Enable disable tenant
	public void validateDisableTenant(String tName) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Tenants Tab
		wait.until(ExpectedConditions.visibilityOf(tenantsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", tenantsTab);
		Reporter.log("Tenant tab is clicked successfully",true);
		Thread.sleep(3000);
		WebElement disable_Slider = driver.findElement(By.xpath("//table/tr/td[text()='"+tName+"']/../td/label/input/../span"));
		disable_Slider.click();
		Thread.sleep(2000);
		String actual_Btn = driver.findElement(By.xpath("//button[@id='popup-button-ok']")).getText();
		System.out.println("Actual Button Displayed:-"+actual_Btn);
		String expected_Btn = prop.getProperty("Disable_Btn");
		System.out.println("Expected Button Displayed:-"+expected_Btn);
		Assert.assertEquals(actual_Btn, expected_Btn, "Disable button is not displayed");
		Reporter.log("Disable button is displayed successfully");
		Thread.sleep(2000);
		disableBtn.click();
		informationpage.validateSignOut();
	}
	public void validateSubmitRequestDisabledTenant(String wfName,String tOrgCode) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
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
		submitRequestBtn.click();
		Reporter.log("Submit request button is clicked");
		Thread.sleep(2000);
		String actual_failureMsg=disableTenantAlertMsg.getText();
		String expected_failureMsg="Failure in submitting the request!! Error: Your tenant ["+tOrgCode+"] has been disabled by the System Administrator. Please contact AutomationEdge Administrator.";
		Reporter.log("Actual Failure Msg : "+actual_failureMsg);
		Reporter.log("Expected Failure Msg : "+expected_failureMsg);		
		Assert.assertEquals(actual_failureMsg, expected_failureMsg,"Request is submitted successfully");
		Reporter.log("Tenant is disabled so request cannot be submitted successfully");
		okBtn.click();
		Reporter.log("OK button is clicked");
		Thread.sleep(2000);
		informationpage.validateSignOut();
	}
	public void validateSubmitRequestEnableTenant(String tName,String wfName) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		// click Tenants Tab
		wait.until(ExpectedConditions.visibilityOf(tenantsTab));
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", tenantsTab);
		Reporter.log("Tenant tab is clicked successfully",true);
		Thread.sleep(3000);
		WebElement enable_Slider = driver.findElement(By.xpath("//table/tr/td[text()='"+tName+"']/../td/label/input/../span"));
		enable_Slider.click();
		String actual_Btn = driver.findElement(By.xpath("//button[@id='popup-button-ok']")).getText();
		System.out.println("Actual Button Displayed:-"+actual_Btn);
		String expected_Btn = prop.getProperty("Enable_Btn");
		System.out.println("Expected Button Displayed:-"+expected_Btn);
		Assert.assertEquals(actual_Btn,expected_Btn, "Enable button is not displayed");
		Reporter.log("Enable button is displayed successfully");
		Thread.sleep(2000);
		disableBtn.click();
		informationpage.validateSignOut();
		catalogueta.validateSubmitRequest(wfName);
	}
	//For Assisted Agent Enable disable tenant
	public void validateSubmitRequestDisableTenantAssistedAgent(String wfName, String wfdes, String category, String WFImportPath, String priority,
			String expTime, String maxTime, String cleanUpHrs, String manExeTime, String tUnit, String tName, String tOrgCode) throws Exception{
		workflowlistpageta.validateImportAssistedWorkflow(wfName, wfdes, category, WFImportPath, priority,expTime,
				maxTime, cleanUpHrs, manExeTime, tUnit);
		validateDisableTenant(tName);
		validateSubmitRequestDisabledTenant(wfName,tOrgCode);
	}
	public void validateSubmitRequestEnableTenantAssistedAgent(String tName,String wfName) throws Exception{
		validateSubmitRequestEnableTenant(tName,wfName);
	}
	//Creating a new tenant of allotment based for usage base licensing
	public void validateCreateAllotmentBasedTenant(String tName,String tDescription,String orgCode,String Category,
			String cName,String cPersonName,String cNumber,String cEmail) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully", true);
		Thread.sleep(5000);		
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", tenantsTab);
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(addTenantBtn));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addTenantBtn);
		// Fill details like Tenant Name, Description and Organization code
		tenantName.sendKeys(tName);
		Thread.sleep(2000);
		descriptionOfTenant.sendKeys(tDescription);
		Thread.sleep(2000);
		organizationCode.sendKeys(orgCode);
		if (fileBasedEnabled.isSelected()) {
			fileBasedEnabled.click();
		} else {
			Reporter.log("File Based License checkbox is already unchecked",true);
		}
		Select licenseCategory_drpdown = new Select(licenseCategory);
		licenseCategory_drpdown.selectByVisibleText(Category);
		Reporter.log("License Category is Selected",true);
		Thread.sleep(2000);
		customerName.sendKeys(cName);
		contactPerson.sendKeys(cPersonName);
		contactNumber.sendKeys(cNumber);
		contactEmail.sendKeys(cEmail);
		Thread.sleep(2000);
		createBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		System.out.println("Success message: " + actual_successMsg);
		String expected_successMsg = Messages.createTenant;
		Assert.assertEquals(actual_successMsg, expected_successMsg, "Tenant not created successfully");
		Reporter.log("Tenant created successfully",true);
		//Clicking on Allotment Based tab
		wait.until(ExpectedConditions.visibilityOf(allotmentBasedTab));
		js.executeScript("arguments[0].click();",allotmentBasedTab);
		Reporter.log("Allotment Based Tab is clicked", true);
		//Verfiying whether user is not created or not
		Thread.sleep(2000);
		Reporter.log("Below validation is to validate new tenant record is visible in webtable",true);
		String actual_TenantName = driver.findElement(By.xpath("//table/tr/td[text()='" + tName + "']")).getText();
		String expected_TenantName = tName;
		System.out.println("Actual:"+actual_TenantName+"Expected:"+expected_TenantName);
		Assert.assertEquals(actual_TenantName, expected_TenantName, "Tenant can not added in list");
		Reporter.log("New Tenant is present in the table-Validated successfully",true);
		informationpage.validateSignOut();

	}
	//For allocating license consumption
	public void validateAllocateConsumptionBased(String tName,String startYear,String startMonth,String startdate,String validity,
			String psCount,String psuCount,String btCount) throws Exception{
		loginpage.login(prop.getProperty("username_TLA"), prop.getProperty("password_TLA"));
		Reporter.log("User log in Successfully",true);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(tenantsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",tenantsTab);
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(allotmentBasedTab));
		js.executeScript("arguments[0].click();",allotmentBasedTab);
		WebElement licenseVisibleButton = driver.findElement(By.xpath("//table/tr/td[text()='"+tName+"']/../td/span[@title='View License']"));
		licenseVisibleButton.click();
		Thread.sleep(2000);
		createLicenseBtn.click();
		Reporter.log("Create button is clicked successfully",true);
		Thread.sleep(5000);
		//For Comparing Current balance and Closing Balance
		List<WebElement> Table_CurrentBalance = driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover table-striped'][1]/tr/td"));
		Thread.sleep(2000);
		ArrayList<String> actual_CurrentBalance = new ArrayList<String>();
		for (WebElement element : Table_CurrentBalance){
			if(actual_CurrentBalance.contains("Current Balance")){
				actual_CurrentBalance.remove("Current Balance");
			}
			Thread.sleep(2000);
			String element_value = element.getText();
			Reporter.log(element_value);
			actual_CurrentBalance.add(element_value);
			Thread.sleep(4000);
		}
		System.out.println("Actual Current Balance details :-" +actual_CurrentBalance);
		Thread.sleep(2000);
		List<WebElement> Table_ClosingBalance = driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover table-striped'][3]/tr/td"));
		Thread.sleep(2000);
		ArrayList<String> expected_ClosingBalance = new ArrayList<String>();
		for (WebElement element : Table_ClosingBalance){
			if(expected_ClosingBalance.contains("Closing Balance")){
				expected_ClosingBalance.remove("Closing Balance");
			}
			String element_value = element.getText();
			Reporter.log(element_value);
			expected_ClosingBalance.add(element_value);
			Thread.sleep(4000);
		}
		System.out.println("Actual Closing Balance details :-" +expected_ClosingBalance);
		Thread.sleep(2000);
		if(actual_CurrentBalance.equals(expected_ClosingBalance)) {
			Assert.assertTrue(true);
			Reporter.log("Current Balance and Closing Balance are Equal",true);
		} else {
			Assert.assertTrue(false);
			Reporter.log("Current Balance and Closing Balance are Not Equal",true);
		} 
		Thread.sleep(2000);
		startDate.click();
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startdate+"']"));
		start_day_picker.click();
		Thread.sleep(2000);
		validateMonths.sendKeys(validity);
		processStudio.sendKeys(psCount);
		premiumStepUnit.sendKeys(psuCount);
		botTime.sendKeys(btCount);
		Thread.sleep(2000);
		//After allocation values we need to verify and check the closing balance
		List<WebElement> Actual_ClosingBalance = driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover table-striped'][3]/tr/td"));
		Thread.sleep(2000);
		ArrayList<String> actual_CloseBalance = new ArrayList<String>();
		for (WebElement element : Actual_ClosingBalance){
			if(actual_CloseBalance.contains("Closing Balance")){
				actual_CloseBalance.remove("Closing Balance");
			}
			String element_value = element.getText();
			Reporter.log(element_value);
			actual_CloseBalance.add(element_value);
			Thread.sleep(4000);
		}
		//For Process Studio
		int expected_PS_Count = Integer.parseInt(actual_CurrentBalance.get(0)) - Integer.parseInt(psCount);
		System.out.println("Actual PS Closing Balance:-"+actual_CloseBalance.get(0));
		System.out.println("Expected PS Closing Balance:-"+expected_PS_Count);
		Assert.assertEquals(Integer.parseInt(actual_CloseBalance.get(0)), expected_PS_Count);
		//For Premium Steps
		int expected_PremiumSteps_Count = Integer.parseInt(actual_CurrentBalance.get(1)) - Integer.parseInt(btCount);
		System.out.println("Actual Premium Steps Closing Balance:-"+actual_CloseBalance.get(1));
		System.out.println("Expected Premium Steps Closing Balance:-"+expected_PremiumSteps_Count);
		Assert.assertEquals(Integer.parseInt(actual_CloseBalance.get(1)), expected_PremiumSteps_Count);
		//For Bot Time
		int expected_BotTime_Count = Integer.parseInt(actual_CurrentBalance.get(2)) - Integer.parseInt(psuCount);
		System.out.println("Actual Premium Steps Closing Balance:-"+actual_CloseBalance.get(2));
		System.out.println("Expected Premium Steps Closing Balance:-"+expected_BotTime_Count);
		Assert.assertEquals(Integer.parseInt(actual_CloseBalance.get(2)), expected_BotTime_Count);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",submitBtn);
		Reporter.log("Save Button is Clicked successfully",true);
		//License allocation successful
		String actual_SuccessMsg = successMsgBox.getText();
		System.out.println("Actual Success Message:-"+actual_SuccessMsg);
		String expected_SuccessMsg = Messages.licenseConsumptionMessage;
		System.out.println("Expected Success Message:-"+expected_SuccessMsg);
		Assert.assertEquals(actual_SuccessMsg, expected_SuccessMsg, "License allocation not successful");
		Reporter.log("License consumption is done successfully",true);
		informationpage.validateSignOut();
	}
	//For Amend License
	public void validateAmendLicense(String tName,String psCount,String psuCount,String btCount,String tenantOrgCode, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName,String password) throws Exception{
		loginpage.login(prop.getProperty("username_TLA"), prop.getProperty("password_TLA"));
		Reporter.log("User log in Successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(tenantsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",tenantsTab);
		//wait.until(ExpectedConditions.visibilityOf(allotmentBasedTab));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();",allotmentBasedTab);
		WebElement licenseVisibleButton = driver.findElement(By.xpath("//table/tr/td[text()='"+tName+"']/../td/span[@title='View License']"));
		licenseVisibleButton.click();
		Thread.sleep(2000);
		amendBtn.click();	
		Reporter.log("Amend Button is Clicked successfully",true);
		processStudio.sendKeys(psCount);
		premiumStepUnit.sendKeys(psuCount);
		botTime.sendKeys(btCount);
		Thread.sleep(3000);
		List<WebElement> Table_updateBalance = driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-hover table-striped'][2]/tr[5]/td"));
		Thread.sleep(2000);
		ArrayList<String> expected_updateBalance = new ArrayList<String>();
		for (WebElement element : Table_updateBalance){
			if(expected_updateBalance.contains("Updated Balance")){
				expected_updateBalance.remove("Updated Balance");
			}
			String element_value = element.getText();
			Reporter.log(element_value);
			expected_updateBalance.add(element_value);
			Thread.sleep(4000);
		}
		js.executeScript("arguments[0].click();",submitBtn);
		Reporter.log("Save Button is Clicked successfully",true);
		//License allocation successful
		String actual_SuccessMsg = successMsgBox.getText();
		System.out.println("Actual Success Message:-"+actual_SuccessMsg);
		String expected_SuccessMsg = Messages.licenseConsumptionMessage;
		System.out.println("Expected Success Message:-"+expected_SuccessMsg);
		Assert.assertEquals(actual_SuccessMsg, expected_SuccessMsg, "License allocation not successful");
		Reporter.log("License consumption is done successfully",true);
		informationpage.validateSignOut();
		tenantuserpage.creatingTenantUser(tenantOrgCode, FName, LName, UserMail, UserName,Pswd, ConfirmPswd, RoleName);
		loginpage.ValidateFirstTimeLogin(UserName, ConfirmPswd, password);
		loginpage.login(prop.getProperty("username_AL"), prop.getProperty("password_AL"));
		Reporter.log("User log in Successfully",true);
		List<WebElement> Actual_Consumption = driver.findElements(By.xpath("//div/span/../label/b"));
		Thread.sleep(3000);
		ArrayList<String> actual_Consumption = new ArrayList<String>();
		for (WebElement element : Actual_Consumption) {
			String element_value = element.getText();
			Reporter.log(element_value);
			actual_Consumption.add(element_value);
			Thread.sleep(4000);
		}
		Reporter.log("Actual License Consumption details :-" +actual_Consumption);
		Thread.sleep(5000);
		//For Process Studio
		System.out.println("Actual PS Consumption Balance:-"+actual_Consumption.get(2));
		System.out.println("Expected PS Consumption Balance:-"+expected_updateBalance.get(0));
		Assert.assertEquals(actual_Consumption.get(2), expected_updateBalance.get(0));
		//For Premium Step Units 
		System.out.println("Actual Premium Step Unit Consumption Balance:-"+actual_Consumption.get(0));
		System.out.println("Expected Premium Step Unit Consumption Balance:-"+expected_updateBalance.get(1));
		Assert.assertEquals(actual_Consumption.get(0), expected_updateBalance.get(1));
		//For Process Studio
		System.out.println("Actual Bot Time Consumption Balance:-"+actual_Consumption.get(1));
		System.out.println("Expected Bot Time Consumption Balance:-"+expected_updateBalance.get(2));
		Assert.assertEquals(actual_Consumption.get(1), expected_updateBalance.get(2));
		informationpage.validateSignOut();
	}
	public void validateAdvSearch() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", tenantsTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
	}
	public void validateAdvSearchForOrgCodeEqualTo(String SearchColumn,String SearchCriteria,
			String orgCode, String year, String month, String date,String PageSize)
					throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, orgCode);
		Thread.sleep(2000);
		wb.changePageSize("50");
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		String actual_OrgCode = driver.findElement(By.xpath("//table/tr/td[text()='" + orgCode + "']")).getText();
		String expected_OrgCode = orgCode;
		System.out.println("Actual OrgCode :" + actual_OrgCode + "Expected OrgCode:" + expected_OrgCode);
		Assert.assertEquals(actual_OrgCode, expected_OrgCode, "Actual and advance org code is not matching for particular created date.");
		Reporter.log("Record with org code is present in the table- Advance search Validated successfully", true);
		informationpage.validateSignOut();
	}
	public void validateAdvSearchForOrgCodeNotEqualTo(String SearchColumn,String SearchCriteria,
			String orgCode,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, orgCode);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_TenantName=op.get(i).getText();
			System.out.println("actual_Tenant Name present in table are: "+actual_TenantName);
			Assert.assertFalse(actual_TenantName.equals(orgCode));
		}
	}
	public void validateAdvSearchForOrgCodeIsLike(String tName, String tDescription, String orgCode,String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		addNewTenants(tName,tDescription,orgCode);
		driver.navigate().to(prop.getProperty("url"));
		Thread.sleep(5000);
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_TenantName=op.get(i).getText();
			System.out.println("actual_Tenant Name present in table are: "+actual_TenantName);
			Assert.assertTrue(actual_TenantName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchOrgBeginsWith(String SearchColumn,String SearchCriteria,String advSearchFor,String PageSize) throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		// Verify above created tenant is not available after adv search otherwise get error
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Tenant Name begins with:"+advSearchFor+ "is: "+op.size());
			Thread.sleep(3000);
			String actual_TenantName=op.get(i).getText();
			System.out.println("actual_Tenant Name is :"+actual_TenantName);
			Assert.assertTrue(actual_TenantName.startsWith(advSearchFor));
		}
	}
	public void validateAdvSearchOrgEndsWith(String SearchColumn,String SearchCriteria,String advSearchFor,String PageSize) throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant whose org code ends with "+advSearchFor+ "are: "+op.size());
			Thread.sleep(3000);
			String actual_orgCode=op.get(i).getText();
			System.out.println("actual_Orgcode present in table are: "+actual_orgCode);
			Assert.assertTrue(actual_orgCode.endsWith(advSearchFor));
		}
	}
	public void validateAdvSearchForTNameEqualTo(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total tenant Name eqaul to: "+op.size());
			Thread.sleep(3000);
			String actual_TenantName=op.get(i).getText();
			System.out.println("actual_Tenant Name is :"+actual_TenantName);
			Assert.assertEquals(actual_TenantName,advSearchFor,"Expected and actual Tenant name through adv search mismatched.");
		}
	}
	public void validateAdvSearchNameNotEqual(String tName, String tDescription, String orgCode,
			String SearchColumn,String SearchCriteria,String PageSize) throws Exception {
		addNewTenants(tName,tDescription,orgCode);
		driver.navigate().to(prop.getProperty("url"));
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,tName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		// Verify above created tenant is not available after adv search otherwise get error
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_TenantName=op.get(i).getText();
			System.out.println("actual_Tenant Name present in table are: "+actual_TenantName);
			Assert.assertFalse(actual_TenantName.equals(tName));
		}
	}
	public void validateAdvSearchNameIsLike(String tName, String tDescription, String orgCode,
			String SearchColumn,String SearchCriteria,String advSearchFor,String PageSize) throws Exception {
		addNewTenants(tName,tDescription,orgCode);
		driver.navigate().to(prop.getProperty("url"));
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		// Verify above created tenant is not available after adv search otherwise get error
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_TenantName=op.get(i).getText();
			System.out.println("actual_Tenant Name present in table are: "+actual_TenantName);
			Assert.assertTrue(actual_TenantName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchNameBeginWith(String tName, String tDescription, String orgCode,
			String SearchColumn,String SearchCriteria,String TNameBeginsWith,String PageSize) throws Exception {
		addNewTenants(tName,tDescription,orgCode);
		driver.navigate().to(prop.getProperty("url"));
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,TNameBeginsWith);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		// Verify data in table now
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Tenant Name begins with:"+TNameBeginsWith+ "is: "+op.size());
			Thread.sleep(3000);
			String actual_TenantName=op.get(i).getText();
			System.out.println("actual_Tenant Name is :"+actual_TenantName);
			Assert.assertTrue(actual_TenantName.startsWith(TNameBeginsWith));
		}
	}
	public void validateAdvSearchNameEndWith(String SearchColumn,String SearchCriteria,String advSearchFor,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		// Verify data in table now
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant whose name ends with "+advSearchFor+ "are: "+op.size());
			Thread.sleep(3000);
			String actual_orgCode=op.get(i).getText();
			System.out.println("actual_Orgcode present in table are: "+actual_orgCode);
			Assert.assertTrue(actual_orgCode.endsWith(advSearchFor));
		}
	}


	//This take case basically handles all calender criterias
	//exact date-done, before , after, in between ,not in between
	public void validateHandleCalender(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		tenantsTab.click();
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate);
		Thread.sleep(2000);
	}

	public void validateCreatedEqualTo(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalender(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[4]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+str_actual_Date);
			//System.out.println("After trimming actual date"+actual_Date.substring(0,11));
			//String actual_date=actual_Date.substring(0,11);
			//System.out.println("ACtual date:"+actual_date);
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[4]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+str_actual_Date);
			//System.out.println("After trimming actual date"+actual_Date.substring(0,11));
			//String actual_date=actual_Date.substring(0,11);
			//System.out.println("Actual date:"+actual_date);
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[4]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+str_actual_Date);
			//System.out.println("After trimming actual date"+actual_Date.substring(0,11));
			//String actual_date=actual_Date.substring(0,11);
			//System.out.println("Actual date:"+actual_date);
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
		tenantsTab.click();
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[4]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+str_actual_Date);
			//System.out.println("After trimming actual date :"+actual_Date.substring(0,11));
			//String actual_date=actual_Date.substring(0,11);
			//System.out.println("Actual date:"+actual_date);
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
		tenantsTab.click();
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[4]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total records found are: "+op.size());
			Thread.sleep(3000);
			String actual_Date=op.get(i).getText();
			String str_actual_Date = actual_Date.split(" ")[0];
			System.out.println("actual_date present in table are: "+str_actual_Date);
			//System.out.println("After trimming actual date :"+actual_Date.substring(0,11));
			//String actual_date=actual_Date.substring(0,11);
			//System.out.println("Actual date:"+actual_date);
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

