package com.ae.qa.pages.UserAdmin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class TenantUsersPageUA extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//span[text()='Users']")
	WebElement usersTab;
	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowTab;
	@FindBy(xpath = "//span[text()='Catalogue']")
	WebElement catalogueTab;
	@FindBy(xpath = "//span[text()='Requests']")
	WebElement requestTab;
	@FindBy(xpath = "//span[text()='Logs']")
	WebElement logsTab;
	@FindBy(xpath = "//span[text()='Reports']")
	WebElement reportsTab;
	@FindBy(xpath = "//span[text()='Plugins']")
	WebElement pluginsTab;
	@FindBy(xpath = "//a[text()='Tenant Users']")
	WebElement tenantUsersTab;
	@FindBy(xpath = "//span[text()='Settings']")
	WebElement settingsTab;
	@FindBy(xpath = "//span[text()='Process Studio']")
	WebElement processStudioTab;
	@FindBy(xpath = "//a[text()='User Groups']")
	WebElement userGroupsTab;
	@FindBy(xpath = "//button[@name='add-cred']/span")
	WebElement addBtn;
	@FindBy(id = "authType")
	WebElement userTypedropdown;
	@FindBy(id = "fname")
	WebElement fName;
	@FindBy(id = "lname")
	WebElement lName;
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
	@FindBy(xpath="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(id = "useremail")
	WebElement userMail;
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
	@FindBy(id="add-filter")
	WebElement addFilterBtn;
	@FindBy(xpath="//button/i[@class='fa fa-search']")
	WebElement searchBtn;
	@FindBy(xpath = "//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[contains(text(),'User updated successfully')]")
	WebElement editUserMsg;

	public TenantUsersPageUA() {
		PageFactory.initElements(driver, this);
	}

	public void creatingUserWithEmail(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName) throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
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
	public void creatingUserWithoutEmail(String userType, String FName, String LName, String UserName,
			String Pswd, String ConfirmPswd, String RoleName) throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
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
	public void validateCreateUserWithoutEmailUA(String userType, String FName, String LName,String UserName,
			String Pswd, String ConfirmPswd, String RoleName,String password) throws Exception{
		creatingUserWithoutEmail(userType, FName,LName,UserName,Pswd,ConfirmPswd,RoleName);
		loginpageta.ValidateFirstTimeLogin(UserName, Pswd, password);
		loginpageta.login(UserName, password);
		Thread.sleep(2000);
		if(workflowTab.isDisplayed() && usersTab.isDisplayed() && settingsTab.isDisplayed()){
			Assert.assertTrue(true);
			Reporter.log("User admin without Email ID is created successfully",true);
		}else {
			Assert.assertTrue(false);
			Reporter.log("User admin without Email ID is not created successfully",true);
		}
		informationpageta.validateSignOut();
	}
	public void validateCreateUserWithEmailUA(String userType, String FName, String LName,String UserMail,String UserName,
			String Pswd, String ConfirmPswd, String RoleName,String password) throws Exception{
		creatingUserWithEmail(userType, FName,LName,UserMail,UserName,Pswd,ConfirmPswd,RoleName);
		loginpageta.ValidateFirstTimeLogin(UserName, Pswd, password);
		loginpageta.login(UserName, password);
		Thread.sleep(2000);
		if(workflowTab.isDisplayed() && catalogueTab.isDisplayed() && requestTab.isDisplayed()
				&& requestTab.isDisplayed() && settingsTab.isDisplayed() && processStudioTab.isDisplayed()){
			Assert.assertTrue(true);
			Reporter.log("Tenant User with Email ID is created successfully",true);
		}else {
			Assert.assertTrue(false);
			Reporter.log("Tenant User with Email ID is not created successfully",true);
		}
		informationpageta.validateSignOut();
	}
	public void validateCreateLdapUserUA(String RoleName,String userType,String uName) throws Exception{
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		//click add new
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", addBtn);
		Reporter.log("started creating new " +RoleName,true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select user_type = new Select(userTypedropdown);
		user_type.selectByVisibleText(userType);
		Thread.sleep(2000);
		userName.sendKeys(uName);
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
	public void validateBulkUserUploadEmail(String userType,String tName) throws Exception {
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		//Click Dropdown Selector of Add New Button
		wait.until(ExpectedConditions.visibilityOf(dropdownSelector));
		dropdownSelector.click();
		Reporter.log("Dropdown Selector button is selected",true);
		Thread.sleep(5000);
		//Clicking on Upload Users from the Dropdown list
		wait.until(ExpectedConditions.visibilityOf(uploadUsers));
		js.executeScript("arguments[0].click();", uploadUsers);
		//Selecting the Native type users
		Select userType_dropDown=new Select(userTypeField);
		userType_dropDown.selectByValue(userType);
		Reporter.log("Native Users is Selected",true);
		Thread.sleep(5000);
		//Clicking on Choose File Button and uploading the file
		chooseFileBtn.sendKeys(prop.getProperty("BulkUserUploadWithEmail"));
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		//Click on Upload Users Button
		uploadUsersBtn.click();
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		//Again Clicking on Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		Thread.sleep(5000);
		webelements.AdvanceSearchField("userName", "eq", tName);
		js.executeScript("arguments[0].click();", addFilterBtn);
		addFilterBtn.click();
		Reporter.log("Add filter button is clicked successfully",true);
		js.executeScript("arguments[0].click();", searchBtn);
		searchBtn.click();
		Reporter.log("Search button is clicked",true);
		Reporter.log("Below validation is to validate new tenant record is visible in webtable",true);
		Thread.sleep(2000);		
		String actual_TenantName = driver.findElement(By.xpath("//table/tr/td/div[text()='" + tName + "']")).getText();
		String expected_TenantName = tName;
		System.out.println("Actual:"+actual_TenantName+"Expected:"+expected_TenantName);
		Assert.assertEquals(actual_TenantName, expected_TenantName, "Tenant not added in list");
		Reporter.log("New Tenant User is present in the table-Validated successfully",true);
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateBulkUserUploadWithoutEmail(String userType,String tName) throws Exception {
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		//Click Dropdown Selector of Add New Button
		wait.until(ExpectedConditions.visibilityOf(dropdownSelector));
		dropdownSelector.click();
		Reporter.log("Dropdown Selector button is selected",true);
		Thread.sleep(5000);
		//Clicking on Upload Users from the Dropdown list
		wait.until(ExpectedConditions.visibilityOf(uploadUsers));
		js.executeScript("arguments[0].click();", uploadUsers);
		//Selecting the Native type users
		Select userType_dropDown=new Select(userTypeField);
		userType_dropDown.selectByValue(userType);
		Reporter.log("Native Users is Selected",true);
		Thread.sleep(5000);
		//Clicking on Choose File Button and uploading the file
		chooseFileBtn.sendKeys(prop.getProperty("BulkUserUploadWithoutEmail"));
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		//Click on Upload Users Button
		uploadUsersBtn.click();
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		//Again Clicking on Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		Thread.sleep(5000);
		webelements.AdvanceSearchField("userName", "eq", tName);
		js.executeScript("arguments[0].click();", addFilterBtn);
		addFilterBtn.click();
		Reporter.log("Add filter button is clicked successfully",true);
		js.executeScript("arguments[0].click();", searchBtn);
		searchBtn.click();
		Reporter.log("Search button is clicked",true);
		Reporter.log("Below validation is to validate new tenant record is visible in webtable",true);
		Thread.sleep(2000);		
		String actual_TenantName = driver.findElement(By.xpath("//table/tr/td/div[text()='" + tName + "']")).getText();
		String expected_TenantName = tName;
		System.out.println("Actual:"+actual_TenantName+"Expected:"+expected_TenantName);
		Assert.assertEquals(actual_TenantName, expected_TenantName, "Tenant not added in list");
		Reporter.log("New Tenant User is present in the table-Validated successfully",true);
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}
	public void validateBulkLDAPUserUpload(String userType,String tName) throws Exception {
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		//Click Dropdown Selector of Add New Button
		wait.until(ExpectedConditions.visibilityOf(dropdownSelector));
		dropdownSelector.click();
		Reporter.log("Dropdown Selector button is selected",true);
		Thread.sleep(5000);
		//Clicking on Upload Users from the Dropdown list
		wait.until(ExpectedConditions.visibilityOf(uploadUsers));
		js.executeScript("arguments[0].click();", uploadUsers);
		//Selecting the Native type users
		Select userType_dropDown=new Select(userTypeField);
		userType_dropDown.selectByValue(userType);
		Reporter.log("Native Users is Selected",true);
		Thread.sleep(5000);
		//Clicking on Choose File Button and uploading the file
		chooseFileBtn.sendKeys(prop.getProperty("BulkLDAPUserUpload"));
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		//Click on Upload Users Button
		uploadUsersBtn.click();
		Reporter.log("Bulk User file is uploaded",true);
		Thread.sleep(5000);
		//Again Clicking on Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		Thread.sleep(5000);
		webelements.AdvanceSearchField("userName", "eq", tName);
		js.executeScript("arguments[0].click();", addFilterBtn);
		addFilterBtn.click();
		Reporter.log("Add filter button is clicked successfully",true);
		js.executeScript("arguments[0].click();", searchBtn);
		searchBtn.click();
		Reporter.log("Search button is clicked",true);
		Reporter.log("Below validation is to validate new tenant record is visible in webtable",true);
		Thread.sleep(2000);		
		String actual_TenantName = driver.findElement(By.xpath("//table/tr/td/div[text()='" + tName + "']")).getText();
		String expected_TenantName = tName;
		System.out.println("Actual:"+actual_TenantName+"Expected:"+expected_TenantName);
		Assert.assertEquals(actual_TenantName, expected_TenantName, "Tenant not added in list");
		Reporter.log("New Tenant User is present in the table-Validated successfully",true);
		Thread.sleep(5000);
		informationpageta.validateSignOut();
	}

	public void validateBulkUserUploadWithEmailUA(String userType,String tName,String ft_password,String password) throws Exception
	{
		validateBulkUserUploadEmail(userType,tName);
		loginpageta.ValidateFirstTimeLogin(tName,ft_password,password);
		Thread.sleep(5000);
		loginpageta.login(tName,password);
		Thread.sleep(5000);
		String actual_successMsg = driver.findElement(By.xpath("//div/span[1][text()='"+tName+"']")).getText();	
		String expected_successMsg = tName;
		System.out.println("Actual Name of the Tenant User:-" +actual_successMsg);
		System.out.println("Expected Name of the Tenant User:-"+expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"Username does not match");
		informationpageta.validateSignOut();
	}
	public void validateBulkUserUploadWithoutEmailUA(String userType,String tName,String ft_password,String password) throws Exception{
		validateBulkUserUploadWithoutEmail(userType,tName);
		loginpageta.ValidateFirstTimeLogin(tName,ft_password,password);
		Thread.sleep(5000);
		loginpageta.login(tName,password);
		Thread.sleep(5000);
		String actual_successMsg = driver.findElement(By.xpath("//div/span[1][text()='"+tName+"']")).getText();	
		String expected_successMsg = tName;
		System.out.println("Actual Name of the Tenant User:-" +actual_successMsg);
		System.out.println("Expected Name of the Tenant User:-"+expected_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"Username does not match");
		informationpageta.validateSignOut();
	}
	public void validateBulkLdapUserUploadUA(String userType,String tName) throws Exception{
		validateBulkLDAPUserUpload(userType,tName);
		//Need to update the script because ldap configuration not done 
	}
	public void validateEditUserUA(String UserName,String UserMail,String RoleName,String Pswd) throws Exception{
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User Admin signed in successfully",true);
		Thread.sleep(5000);
		//Click Users Tab
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab is clicked",true);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab is clicked",true);
		WebElement editBtn=driver.findElement(By.xpath("//div[@class='table-responsive']/table/tr/td/div[@title='"+UserName+"']/../../td/span[@title='Edit User']"));
		editBtn.click();
		userMail.sendKeys(UserMail);
		Thread.sleep(3000);
		Select select = new Select(roledropdown);
		select.selectByVisibleText(RoleName);
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
		loginpageta.login(UserName,Pswd);
		Thread.sleep(2000);		
		if(workflowTab.isDisplayed() && catalogueTab.isDisplayed() && requestTab.isDisplayed()
				&& requestTab.isDisplayed() && settingsTab.isDisplayed() && processStudioTab.isDisplayed()){
			Assert.assertTrue(true);
			Reporter.log("User admin role is changed to Tenant user role successfully",true);
		}else {
			Assert.assertTrue(false);
			Reporter.log("User admin role is not changed to Tenant user role successfully",true);
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
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
			Assert.assertTrue(str_FirstName.contains(advSearchFor));

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
			//String lowercase_LastName = str_LastName.toLowerCase();
			System.out.println("actual_System User LastName present in table are: "+str_LastName);
			Assert.assertTrue(str_LastName.contains(advSearchFor));

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
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", tenantUsersTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate);
		Thread.sleep(2000);
	}
	public void validateHandleCalenderForLastUpdated(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
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
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
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
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
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
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
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
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
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

