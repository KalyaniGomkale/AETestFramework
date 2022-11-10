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
import com.ae.qa.pages.InformationPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;
import com.ae.qa.util.TestUtil;

public class TenantUsersPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public TenantPolicyPageTA tenantpolicypageta=new TenantPolicyPageTA();
	public CommonWebElements wb = new CommonWebElements();
	public LDAPPageTA ldappageta = new LDAPPageTA();
	public TestUtil testutil=new TestUtil();

	@FindBy(xpath = "//span[text()='Users']")
	WebElement usersTab;
	@FindBy(xpath = "//a[text()='Tenant Users']")
	WebElement tenantUsersTab;
	@FindBy(xpath = "//a[text()='User Groups']")
	WebElement userGroupsTab;
	@FindBy(xpath = "//button[@name='add-cred']/span")
	WebElement addBtn;
	@FindBy(xpath = "//button[@name='add-new']/span")
	WebElement addBtnUG;
	@FindBy(id = "authType")
	WebElement userTypedropdown;
	@FindBy(id = "fname")
	WebElement fName;
	@FindBy(id = "lname")
	WebElement lName;
	@FindBy(id = "useremail")
	WebElement userMail;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "pswd")
	WebElement pswd;
	@FindBy(id = "confirmPswd")
	WebElement confirmPswd;
	@FindBy(id = "role")
	WebElement roledropdown;
	@FindBy(name = "submit")
	WebElement createBtn;
	@FindBy(xpath = "//span[@class='fa fa-refresh']")
	WebElement refreshBtn;
	@FindBy(xpath = "//select[@id='pageSize'][1]")
	WebElement pageNumber;
	@FindBy(xpath = "//table[@class='ae-table table table-hover table-bordered table-striped mb-0']/tr[2]/td/span[@class='fa fa-edit']")
	WebElement editBtn;
	@FindBy(xpath = "//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[contains(text(),'User updated successfully')]")
	WebElement editUserMsg;
	@FindBy(id = "gname")
	WebElement groupNameField;
	@FindBy(id = "description")
	WebElement descriptionField;
	@FindBy(xpath = "//*[@name='create']")
	WebElement createBtnUG;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement actual_userGroupMsg;
	@FindBy(id = "change-pswd")
	WebElement changePswdTab;
	@FindBy(id = "oldpswd")
	WebElement oldPswd;
	@FindBy(id = "newpswd")
	WebElement newPswd;
	@FindBy(id = "confirmpswd")
	WebElement newConfirmPswd;
	@FindBy(xpath = "//button[text()='Change']")
	WebElement changeBtn;
	@FindBy(xpath="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//span/span[text()='Select Groups']")
	WebElement AddUserToGroup;
	@FindBy(xpath="//input[@name='search']")
	WebElement searchBar;
	@FindBy(xpath="//span[@class='mul-checkmark']")
	WebElement checkGroupName;
	@FindBy(xpath="//select[@formcontrolname='action']")
	WebElement actionDropdown;
	@FindBy(xpath="//button[text()='Next']")
	WebElement nextBtn;
	@FindBy(xpath="//*[@id='pswd']")
	WebElement Pswd;
	@FindBy(xpath="//button[@type='submit']/span")
	WebElement enableBtn;
	@FindBy(xpath="//*[@id='confirmPswd']")
	WebElement confirmPassword;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(name = "dropdown-selector")
	WebElement dropdownSelector;
	@FindBy(xpath = "//span[text()='Upload Users']")
	WebElement uploadUsers;
	@FindBy(xpath ="//select[@id='userType']")
	WebElement userTypeField;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement uploadUsersBtn;
	@FindBy(xpath = "//input[@name='csvFile']")
	WebElement chooseFileBtn;
	@FindBy(xpath="//button[@type='submit']/span")
	WebElement disableBtn;
	@FindBy(xpath="//select[@formcontrolname='action']")
	WebElement userEnableDropdown;
	@FindBy(xpath="//button[text()='Next']")
	WebElement nxtBtn;
	@FindBy(xpath="//button[@id='popup-button-ok']")
	WebElement confirmEnableBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement PopUpMsg;
	@FindBy(id = "uname")
	WebElement uName;
	@FindBy(id = "deleteUserCheck")
	WebElement deleteUserCheckbox;
	@FindBy(id = "deleteUserPeriod")
	WebElement deleteUserPeriod;
	@FindBy(xpath = "//button[text()='Delete']")
	WebElement confirmDeleteBtn;
	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowTab;
	@FindBy(xpath = "//span[text()='Catalogue']")
	WebElement catalogueTab;
	@FindBy(xpath = "//span[text()='Requests']")
	WebElement requestTab;
	@FindBy(xpath = "//span[text()='Reports']")
	WebElement reportsTab;
	@FindBy(xpath = "//span[text()='Process Studio']")
	WebElement processStudioTab;
	@FindBy(xpath = "//span[text()='Agents']")
	WebElement agentsTab;
	@FindBy(xpath = "//span[text()='Logs']")
	WebElement logsTab;
	@FindBy(xpath = "//span[text()='Plugins']")
	WebElement pluginsTab;
	@FindBy(xpath = "//span[text()='File Management']")
	WebElement fileManagementTab;
	@FindBy(xpath = "//span[text()='Home']")
	WebElement homeTab;
	@FindBy(xpath = "//select[@formcontrolname='action']")
	WebElement actionSelect;


	public TenantUsersPageTA() {
		PageFactory.initElements(driver, this);
	}
	//Workflow Admin //Tenant Admin //User Admin 
	public void creatingUser(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName) throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		//wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", tenantUsersTab);
		// click add new
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addBtn);
		Reporter.log("started creating new " +RoleName,true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select user_type = new Select(userTypedropdown);
		user_type.selectByVisibleText(userType);
		fName.sendKeys(FName);
		Thread.sleep(3000);
		lName.sendKeys(LName);
		Thread.sleep(3000);
		userMail.sendKeys(UserMail);
		Thread.sleep(3000);
		userName.sendKeys(UserName);
		Thread.sleep(3000);
		pswd.sendKeys(Pswd);
		Thread.sleep(3000);
		confirmPswd.sendKeys(ConfirmPswd);
		Thread.sleep(10000);
		Select select = new Select(roledropdown);
		select.selectByVisibleText(RoleName);
		Thread.sleep(5000);
		// create button
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].click();", createBtn);
		Reporter.log(RoleName + " is created successfully",true);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		String expected_successMsg = Messages.createUser;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"User not created.");
		Reporter.log(RoleName + " created successfully",true);
		informationpageta.validateSignOut();
	}
	//Create Tenant User and edit email ID
	public void valiateCreatingTenantUser(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName) throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		//wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", tenantUsersTab);
		// click add new
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(addBtn));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addBtn);
		Reporter.log("started creating new Tenant",true);
		// Start form
		// Locating the select dropdown for Tenant
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Thread.sleep(5000);		
		Select user_type = new Select(userTypedropdown);
		user_type.selectByVisibleText(userType);
		fName.sendKeys(FName);
		Thread.sleep(3000);
		lName.sendKeys(LName);
		Thread.sleep(3000);
		userMail.sendKeys(UserMail);
		Thread.sleep(3000);
		userName.sendKeys(UserName);
		Thread.sleep(3000);
		pswd.sendKeys(Pswd);
		Thread.sleep(3000);
		confirmPswd.sendKeys(ConfirmPswd);
		Thread.sleep(10000);
		Select select = new Select(roledropdown);
		select.selectByVisibleText(RoleName);
		Thread.sleep(5000);
		/*	AddUserToGroup.click();
		searchBar.sendKeys(groupName);
		Thread.sleep(3000);
		checkGroupName.click();*/
		// create button
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].click();", createBtn);
		Reporter.log("User is created successfully",true);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		String expected_successMsg = Messages.createUser;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"User not created.");
		Reporter.log(RoleName + " created successfully",true);
		informationpageta.validateSignOut();
	}

	public void ValidateUnverifiedStatus(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName) throws Exception {
		valiateCreatingTenantUser(userType,FName,LName,UserMail,UserName,Pswd,ConfirmPswd,RoleName);
		driver.navigate().to(prop.getProperty("url"));
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		WebElement status=driver.findElement(By.xpath("//table/tr/td/div[@title='"+UserName+"']/../../td/button"));
		String Actual_Status=status.getText();
		Reporter.log("Actual Status of New Tenant user is :"+Actual_Status,true);
		String Expected_Status= "UNVERIFIED";
		Reporter.log("Expected Status of New Tenant user is :"+Expected_Status,true);
		Assert.assertEquals(Actual_Status,Expected_Status,"Status of newly created user is not Unverified");
		Reporter.log("Status of newly created user is UNVERIFIED, verified successfully",true);
		informationpageta.validateSignOut();
	}
	public void ValidateActiveStatus(String UserName,String Pswd, String NewPswd) throws Exception {
		loginpageta.ValidateFirstTimeLogin(UserName,Pswd,NewPswd);
		Thread.sleep(5000);
		driver.navigate().to(prop.getProperty("url"));
		loginpageta.login(UserName,NewPswd);
		Reporter.log("User log in Successfully",true);
		informationpageta.validateSignOut();
		Thread.sleep(3000);
		Reporter.log("Login into TA to verify status",true);
		driver.navigate().to(prop.getProperty("url"));
		Thread.sleep(3000);
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		WebElement status=driver.findElement(By.xpath("//table/tr/td/div[@title='"+UserName+"']/../../td/button"));
		String Actual_Status=status.getText();
		Reporter.log("Actual Status of Tenant user after changing password is :"+Actual_Status,true);
		String Expected_Status= "ACTIVE";
		Reporter.log("Expected Status of Tenant user after changing password is :"+Expected_Status,true);
		Assert.assertEquals(Actual_Status,Expected_Status,"Status of newly created user is not Active");
		Reporter.log("Status of user whose First time password changed is ACTIVE, verified successfully",true);
		informationpageta.validateSignOut();
	}
	public void valiateEnableLockedUser(String UserName,String action,
			String Password, String ConfirmPswd) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		//wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Thread.sleep(2000);
		WebElement lockedBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'LOCKED')]"));
		lockedBtn.click();
		Reporter.log("Locked button clicked");
		Thread.sleep(3000);
		Select select_action=new Select(actionDropdown);
		select_action.selectByValue(action);//UNLOCK
		Thread.sleep(2000);
		nextBtn.click();
		Reporter.log("Action is selected to "+action+" user and next button is clicked",true);
		Thread.sleep(3000);
		Pswd.sendKeys(Password);
		Thread.sleep(2000);
		confirmPassword.sendKeys(ConfirmPswd);
		Thread.sleep(2000);
		enableBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		String expected_successMsg = Messages.enableUser;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"User not enabled.");
		Reporter.log(UserName+ "enabled successfully",true);
		informationpageta.validateSignOut();	
	}
	public void validateTenantUsersPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}
	public void validateBulkUpload(String userType, String filePath,String tName) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		//wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		//Click Dropdown Selector of Add New Button
		//wait.until(ExpectedConditions.visibilityOf(dropdownSelector));
		Thread.sleep(2000);
		dropdownSelector.click();
		Reporter.log("Dropdown Selector button is selected",true);
		Thread.sleep(5000);
		//Clicking on Upload Users from the Dropdown list
		//wait.until(ExpectedConditions.visibilityOf(uploadUsers));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", uploadUsers);
		//Selecting the Native type users
		Select userTypr_dropDown=new Select(userTypeField);
		userTypr_dropDown.selectByValue(userType);
		Reporter.log("Native Users is Selected",true);
		Thread.sleep(5000);
		//Clicking on Choose File Button and uploading the file
		chooseFileBtn.sendKeys(filePath);
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		List<WebElement> bulkUser_Table = driver.findElements(By.xpath("//table[@class='ae-table table table-bordered table-striped top-margin-lg']/tbody/tr/td[1]"));
		Thread.sleep(2000);
		ArrayList<String> actual_BulkUserUploaded = new ArrayList<String>();
		for (WebElement element : bulkUser_Table){
			String element_value = element.getText();
			Reporter.log(element_value);
			actual_BulkUserUploaded.add(element_value);
			Thread.sleep(4000);
			}
		int actul_BulkuserCount = actual_BulkUserUploaded.size();
		System.out.println("Actual User Count:- "+actul_BulkuserCount);
		//Click on Upload Users Button
		uploadUsersBtn.click();
		Reporter.log("Bulk User file is uploaded",true);
		String BulkuserCount = driver.findElement(By.xpath("//table[@class='ae-table table']/tbody/tr/th/font[@color='green']")).getText();
		String expected_BulkuserCount = BulkuserCount.split("- ")[1];
		System.out.println("Expected User Count:- "+expected_BulkuserCount);
		Thread.sleep(5000);
		Assert.assertEquals(Integer.toString(actul_BulkuserCount), expected_BulkuserCount,"Uploaded User Count Mismatches");
		//Again Clicking on Users Tab
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	//To verify upload users with Email Id
	public void bulkUserUploadWithEmail(String userType, String filePath,String tName,String ftpassword,String password) throws Exception
	{
		validateBulkUpload(userType,filePath,tName);
		loginpageta.ValidateFirstTimeLogin(tName,ftpassword,password);
		Thread.sleep(5000);
		loginpageta.login(tName,password);
		Thread.sleep(5000);
		String actual_tenantName = driver.findElement(By.xpath("//div/span[1][text()='"+ tName +"']")).getText();	
		String expected_tenantName = tName;
		System.out.println("Actual Name of the Tenant User:-" +actual_tenantName);
		System.out.println("Expected Name of the Tenant User:-"+expected_tenantName);
		Assert.assertEquals(actual_tenantName, expected_tenantName,"Username does not match");
		informationpageta.validateSignOut();
	}
	//To verify upload users without Email Id
	public void bulkUserUploadWithoutEmail(String userType, String filePath, String tName,String ftpassword,String password) throws Exception
	{
		validateBulkUpload(userType,filePath,tName);
		loginpageta.ValidateFirstTimeLogin(tName,ftpassword,password);
		Thread.sleep(5000);
		loginpageta.login(tName,password);
		Thread.sleep(5000);
		String actual_tenantName = driver.findElement(By.xpath("//div/span[1][text()='"+ tName +"']")).getText();	
		String expected_tenantName = tName;
		System.out.println("Actual Name of the Tenant User:-" +actual_tenantName);
		System.out.println("Expected Name of the Tenant User:-"+expected_tenantName);
		Assert.assertEquals(actual_tenantName, expected_tenantName,"Username does not match");
		informationpageta.validateSignOut();
	}
	public void validateEnableUser(String UserName, String FT_password, String password, String Action) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		//wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		Thread.sleep(2000);		
		String unverifiedBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'UNVERIFIED')]")).getText();
		System.out.println("Current Status:- "+unverifiedBtn);
		if(unverifiedBtn.equals("UNVERIFIED")) {
			Assert.assertEquals(unverifiedBtn,"UNVERIFIED","User status is not UNVERIFIED");
		}
		informationpageta.validateSignOut();
		loginpageta.ValidateFirstTimeLogin(UserName, FT_password, password);
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		Reporter.log("Tenant User signed in successfully",true);
		Thread.sleep(5000);
		informationpageta.validateSignOut();
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		Thread.sleep(2000);		
		WebElement activeBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'ACTIVE')]"));
		String activeBtnStatus=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'ACTIVE')]")).getText();
		System.out.println("Current Status:- "+activeBtnStatus);
		if(activeBtn.equals("ACTIVE")) {
			Assert.assertEquals(activeBtn,"ACTIVE","User status is not ACTIVE");
		}
		Thread.sleep(2000);
		activeBtn.click();
		Reporter.log("Active button is clicked",true);
		Thread.sleep(2000);
		disableBtn.click();
		Reporter.log("Disabled button is clicked",true);
		String disableBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'DISABLED')]")).getText();
		System.out.println("Current Status:- "+disableBtn);
		if(disableBtn.equals("DISABLED")) {
			Assert.assertEquals(disableBtn,"DISABLED","User status is not DISABLED");
		}
		informationpageta.validateSignOut();
		Thread.sleep(2000);
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		String actual_message=alertMessage.getText();
		String expected_message=Messages.failPasswordPolicy;
		Reporter.log("Actual Message on screen is: "+actual_message+ " and Expected "
				+ "message is: "+expected_message,true);
		Assert.assertEquals(actual_message, expected_message,"Appropriate message is not loaded");
		Reporter.log("User is disabled so cannot login and appropriate message is been displayed",true);
		Thread.sleep(10000);
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		Thread.sleep(2000);
		WebElement disabledBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'DISABLED')]"));
		disabledBtn.click();
		Thread.sleep(2000);
		Select userEnable_drpdown = new Select(userEnableDropdown);
		userEnable_drpdown.selectByVisibleText(Action);
		Thread.sleep(3000);
		nxtBtn.click();
		Thread.sleep(2000);
		confirmEnableBtn.click();
		Reporter.log("Enabled button is clicked",true);
		Thread.sleep(2000);
		String actual_Message=alertMessage.getText();
		System.out.println("Actual Success Message:- "+actual_Message);
		String expected_Message=Messages.Enableuser;
		System.out.println("Expected Success Message:- "+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"User not[ENABLED] successfully");
		String enableBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'ENABLED')]")).getText();
		System.out.println("Current Status:- "+enableBtn);
		if(enableBtn.equals("ENABLED")) {
			Assert.assertEquals(enableBtn,"ENABLED","User status is not ENABLED");
		}
		informationpageta.validateSignOut();
		Thread.sleep(2000);
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		Reporter.log("Tenant User signed in successfully after been Enabled",true);
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateUnlockUserAccessApplication(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName,String FT_password,String password, String invalidPwd,int NoOfAttempt,
			String UserToUnlock,String NewPswd,String CnfPswd,String FT_password1,String password1) throws Exception{
		valiateCreatingTenantUser(userType, FName, LName, UserMail, UserName, Pswd, ConfirmPswd, RoleName);
		loginpageta.ValidateFirstTimeLogin(UserName, FT_password,password);
		loginpageta.login(UserName, password);
		informationpageta.validateSignOut();
		//tenantpolicypageta.validateNoOfAttempts(UserName, password, invalidPwd, noOfattempt);
		for (int i = 1; i <= NoOfAttempt; i++) {
			if (i < NoOfAttempt) {
				loginpageta.login(UserName,invalidPwd);
				String Actual_Msg = PopUpMsg.getText();
				System.out.println("Actual_msg:" + Actual_Msg);
				if (Actual_Msg.contentEquals("You have made [" + i
						+ "] unsuccessful attempt(s). The maximum retry attempts allowed for login are [" + NoOfAttempt
						+ "]")) {
					Reporter.log(i + "th Unsuccessful attempt",true);
					// Assert.assertTrue(true);
				}
				for (int m = 0; m < 10; m++) {
					uName.sendKeys(Keys.BACK_SPACE);
					pswd.sendKeys(Keys.BACK_SPACE);
					Thread.sleep(3000);
				}
			} else if (i == NoOfAttempt) {
				System.out.println(i + "th Unsuccessful attempt");
				loginpageta.login(UserName,invalidPwd);
				String Actual_Fail = PopUpMsg.getText();
				Reporter.log("Actual_msg:" + Actual_Fail,true);
				String Expected_Fail = Messages.failPasswordPolicy;
				Reporter.log("Expected_msg:" + Expected_Fail,true);
				Assert.assertEquals(Actual_Fail, Expected_Fail);
			}
		}
		Reporter.log("No. of attempts is validated successfully",true);
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		tenantpolicypageta.UnlockUsers(UserToUnlock, NewPswd, CnfPswd);
		loginpageta.ValidateFirstTimeLogin(UserName,NewPswd,password1);
		loginpageta.login(UserName,password1);
		Thread.sleep(5000);
		if(workflowTab.isDisplayed()&&catalogueTab.isDisplayed()&&requestTab.isDisplayed()&&
				reportsTab.isDisplayed()&&processStudioTab.isDisplayed()){
			Reporter.log("Tenant user is able to access the application as per his role",true);
		}else {
			Reporter.log("Tenant user is not able to access the application as per his role",true);
		}
		informationpageta.validateSignOut();
	}
	public void validateDisabledUserTuser(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName,String FT_password,String password) throws Exception{
		valiateCreatingTenantUser(userType, FName, LName, UserMail, UserName, Pswd, ConfirmPswd, RoleName);
		loginpageta.ValidateFirstTimeLogin(UserName, FT_password, password);
		loginpageta.login(UserName,password);
		informationpageta.validateSignOut();
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		//wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		Thread.sleep(2000);
		WebElement activeBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'ACTIVE')]"));
		String activeBtnStatus=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'ACTIVE')]")).getText();
		System.out.println("Current Status:- "+activeBtnStatus);
		if(activeBtn.equals("ACTIVE")) {
			Assert.assertEquals(activeBtn,"ACTIVE","User status is not ACTIVE");
		}
		Thread.sleep(2000);
		activeBtn.click();
		Reporter.log("Active button is clicked",true);
		Thread.sleep(2000);
		disableBtn.click();
		Reporter.log("Disabled button is clicked",true);
		String disableBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'DISABLED')]")).getText();
		System.out.println("Current Status:- "+disableBtn);
		if(disableBtn.equals("DISABLED")) {
			Assert.assertEquals(disableBtn,"DISABLED","User status is not DISABLED");
		}
		informationpageta.validateSignOut();
	}
	public void validateDisabledDeleteTsuer(String UserName,String Action,String Duration) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		Thread.sleep(2000);
		WebElement disabledBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'DISABLED')]"));
		disabledBtn.click();
		Thread.sleep(2000);
		Select user_State=new Select(actionSelect);
		user_State.selectByVisibleText(Action);
		nextBtn.click();
		Thread.sleep(2000);
		confirmEnableBtn.click();
		Thread.sleep(2000);
		String actual_Message=alertMessage.getText();
		System.out.println("Actual Success Message:- "+actual_Message);
		String expected_Message=Messages.unlock_TA;
		System.out.println("Expected Success Message:- "+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"User not enabled successfully");
		Thread.sleep(2000);
		WebElement EnableBtn=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserName+"']/../../td/button[contains(text(),'ENABLED')]"));
		EnableBtn.click();
		if(!deleteUserCheckbox.isSelected()) {
			deleteUserCheckbox.click();
			Reporter.log("Delete this user checkbox is selected",true);
		}
		deleteUserPeriod.sendKeys(Duration);
		Thread.sleep(2000);
		disableBtn.click();
		Thread.sleep(2000);
		String actual_message=alertMessage.getText();
		System.out.println("Actual Success Message:- "+actual_message);
		String expected_message=Messages.Disableuser;
		System.out.println("Expected Success Message:- "+expected_message);
		Assert.assertEquals(actual_message, expected_message,"User not disabled successfully");
		informationpageta.validateSignOut();
	}
	public void validateEditTenantUser(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName,String NewUserMail,String NewRoleName,String FT_password,String password) throws Exception{
		creatingUser(userType, FName, LName, UserMail, UserName, Pswd, ConfirmPswd, RoleName);
		loginpageta.ValidateFirstTimeLogin(UserName, FT_password, password);
		loginpageta.login(UserName,password);
		Thread.sleep(2000);
		if(homeTab.isDisplayed()&&workflowTab.isDisplayed()&&agentsTab.isDisplayed()&&catalogueTab.isDisplayed()&&
				logsTab.isDisplayed()&&pluginsTab.isDisplayed()&&
				fileManagementTab.isDisplayed()&&requestTab.isDisplayed()&&
				reportsTab.isDisplayed()&&processStudioTab.isDisplayed()){
			Reporter.log("Current Tenant Role is Workflow Admin",true);
		}else{
			Reporter.log("Current Tenant Role is not Workflow Admin",true);
		}
		informationpageta.validateSignOut();
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users Tab is Clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("TenantUsers Tab is Clicked",true);
		WebElement editBtn=driver.findElement(By.xpath("//div[@class='table-responsive']/table/tr/td/div[@title='"+UserName+"']/../../td/span[@title='Edit User']"));
		editBtn.click();
		Reporter.log("Edit Button is clicked",true);
		for (int i = 0; i < 30; i++) {
			userMail.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(4000);
		userMail.sendKeys(NewUserMail);
		Reporter.log("Email Id is edited successfully",true);
		Select select = new Select(roledropdown);
		select.selectByVisibleText(NewRoleName);
		Reporter.log("New Role is edited successfully",true);
		System.out.println("Current New Role After Edit:- "+NewRoleName);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", saveBtn);
		Reporter.log("Save Button is clicked",true);
		String actual_EditUserMsg = editUserMsg.getText();
		String expected_EditUserMsg = Messages.editSystemUser;
		System.out.println("Actual Edit Username Msg:- " + actual_EditUserMsg);
		System.out.println("Expected Edit Username Msg:- " + expected_EditUserMsg);
		Assert.assertEquals(actual_EditUserMsg, expected_EditUserMsg, "Tenant User details not edited successfully");
		Reporter.log("Tenant User details got edited.",true);
		informationpageta.validateSignOut();
		loginpageta.login(UserName,password);
		Thread.sleep(5000);
		if(workflowTab.isDisplayed()&&catalogueTab.isDisplayed()&&requestTab.isDisplayed()&&
				reportsTab.isDisplayed()&&processStudioTab.isDisplayed()){
			Reporter.log("Edit Workflow Admin role to Tenant User is successfull",true);
		}else{
			Reporter.log("Edit Workflow Admin role to Tenant User is not successfull",true);
		}
		informationpageta.validateSignOut();
	}
	public void validateCreatingLDAPUser(String hostName,String portNo,String domainName,String userType,String UserName,
			String RoleName,String FT_password,String password) throws Exception{
		/*ldappageta.verifyLdapConfig(hostName, portNo, domainName);*/
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users Tab is clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users Tab is Clicked.",true);
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addBtn);
		Reporter.log("started creating new Tenant",true);
		// Start form
		// Locating the select dropdown for Tenant
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//Thread.sleep(5000);		
		Select user_type = new Select(userTypedropdown);
		user_type.selectByVisibleText(userType);
		Reporter.log("LDAP Users type is selected",true);
		Thread.sleep(3000);
		userName.sendKeys(UserName);
		Thread.sleep(3000);
		Select select = new Select(roledropdown);
		select.selectByVisibleText(RoleName);
		Reporter.log("Tenant Admin role is selected",true);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", createBtn);
		Reporter.log(RoleName + " is created successfully",true);
		String actual_successMsg = alertMessage.getText();
		String expected_successMsg = Messages.createUser;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"User not created.");
		Reporter.log(RoleName + " LDAP User is created successfully",true);
		informationpageta.validateSignOut();
		//loginpageta.ValidateFirstTimeLogin(UserName, FT_password, password);
		//loginpageta.login(UserName, password);*/
	}
	public void validateAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", usersTab);
		js_tenant.executeScript("arguments[0].click();", tenantUsersTab);
		wb.validateClickOnAdvanceSearch();
	}

	public void validateAdvSearchForUserNameEqualTo(String SearchColumn,String SearchCriteria,
			String userName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, userName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_UserName=op.get(i).getText();
			String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Tenant User Name present in table are: "+actual_UserName);
			Thread.sleep(3000);
			Assert.assertTrue(lowercase_UserName.contains(advSearchFor));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_UserName=op.get(i).getText();
			System.out.println("actual_Tenant User Name present in table are: "+actual_UserName);
			Assert.assertTrue(actual_UserName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForFirstNameEqualTo(String SearchColumn,String SearchCriteria,
			String firstName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, firstName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_FirstName=op.get(i).getText();
			String str_FirstName = actual_FirstName.split(" ")[0];
			System.out.println("actual_System User FirstName present in table are: "+str_FirstName);
			Assert.assertTrue(str_FirstName.equalsIgnoreCase(firstName));
		}
	}
	public void validateAdvSearchForFirstNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String firstName,String PageSize)throws Exception {
		//creatingSystemAdmin(tenantOrgCode, FName, LName, UserMail, UserName, Pswd,ConfirmPswd,RoleName);
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, firstName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_FirstName=op.get(i).getText();
			String str_FirstName = actual_FirstName.split(" ")[0];
			System.out.println("actual_System User LastName present in table are: "+str_FirstName);
			Assert.assertFalse(str_FirstName.equals(firstName));
		}
	}
	public void validateAdvSearchForFirstNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_FirstName=op.get(i).getText();
			String str_FirstName = actual_FirstName.split(" ")[0];
			System.out.println("actual_System User FirstName present in table are: "+str_FirstName);
			Assert.assertTrue(str_FirstName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForFirstNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		//creatingSystemAdmin(tenantOrgCode, FName, LName, UserMail, UserName, Pswd,ConfirmPswd,RoleName);
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_FirstName=op.get(i).getText();
			String str_FirstName = actual_FirstName.split(" ")[0];
			//String lowercase_FirstName = str_FirstName.toLowerCase();
			System.out.println("actual_System User FirstName present in table are: "+str_FirstName);
			Thread.sleep(2000);
			Assert.assertTrue(actual_FirstName.contains(advSearchFor));

		}
	}
	public void validateAdvSearchForFirstNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_FirstName=op.get(i).getText();
			String str_FirstName = actual_FirstName.split(" ")[0];
			System.out.println("actual_System User FirstName present in table are: "+str_FirstName);
			Assert.assertTrue(str_FirstName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForLastNameEqualTo(String SearchColumn,String SearchCriteria,String lastName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, lastName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_LastName=op.get(i).getText();
			String str_LastName = actual_LastName.split(" ")[1];
			System.out.println("actual_System User LastName present in table are: "+str_LastName);
			Assert.assertTrue(str_LastName.equalsIgnoreCase(lastName));
		}
	}
	public void validateAdvSearchForLastNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String lastName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, lastName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_LastName=op.get(i).getText();
			String str_LastName = actual_LastName.split(" ")[1];
			System.out.println("actual_System User LastName present in table are: "+str_LastName);
			Assert.assertFalse(str_LastName.equals(lastName));
		}
	}
	public void validateAdvSearchForLastNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_LastName=op.get(i).getText();
			String str_LastName = actual_LastName.split(" ")[1];
			System.out.println("actual_System User LastName present in table are: "+str_LastName);
			Assert.assertTrue(str_LastName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForLastNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_LastName=op.get(i).getText();
			String str_LastName = actual_LastName.split(" ")[1];
			String lowercase_LastName = str_LastName.toLowerCase();
			System.out.println("actual_System User LastName present in table are: "+str_LastName);
			Assert.assertTrue(lowercase_LastName.contains(advSearchFor));

		}
	}
	public void validateAdvSearchForLastNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[3]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_LastName=op.get(i).getText();
			String str_LastName = actual_LastName.split(" ")[1];
			System.out.println("actual_System User LastName present in table are: "+str_LastName);
			Assert.assertTrue(str_LastName.contains(advSearchFor));
		}
	}
	public void validateHandleCalender(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate);
		Thread.sleep(2000);
	}
	public void validateHandleCalenderForLastUpdated(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Last Updated",CreatedCriteria,startYear,startMonth,startDate);
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
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", tenantUsersTab);
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
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", tenantUsersTab);
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
	public void validateLastUpdatedCreatedEqualTo(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalenderForLastUpdated(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[5]"));
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

	public void validateLastUpdatedCreatedBefore(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalenderForLastUpdated(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[5]"));
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
	public void validateLastUpdatedCreatedAfter(String CreatedCriteria,String startYear,String startMonth,String startDate,String PageSize) throws Exception {
		validateHandleCalenderForLastUpdated(CreatedCriteria,startYear,startMonth,startDate);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[5]"));
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
	public void validateLastUpdatedCreatedInBetween(String CreatedCriteria,String startYear,String startMonth,String startDate,
			String endYear,String endMonth,String endDate,String PageSize) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Last Updated",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[5]"));
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
	public void validateLastUpdatedCreatedNotInBetween(String CreatedCriteria,String startYear,String startMonth,String startDate,
			String endYear,String endMonth,String endDate,String PageSize) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateExtraAdvanceSearchForCalender("Last Updated",CreatedCriteria,startYear,startMonth,startDate,endYear,endMonth,endDate);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		Thread.sleep(2000);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[5]"));
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
	public void validateStateDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_State=op.get(i).getText();
			System.out.println("actual_State present in table are: "+actual_State);
			Assert.assertTrue(actual_State.equalsIgnoreCase(searchValue));
		}
	}
	public void validateStateDropdownNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[6]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_State=op.get(i).getText();
			System.out.println("actual_State present in table are: "+actual_State);
			Assert.assertFalse(actual_State.equalsIgnoreCase(searchValue));
		}
	}
	
}

