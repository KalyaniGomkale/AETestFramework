package com.ae.qa.pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class SystemUsersPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage=new InformationPage();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//span[text()='Users']")
	WebElement usersTab;
	@FindBy(xpath = "//a[text()='System Users']")
	WebElement systemUsersTab;
	@FindBy(xpath = "//span[(text()='Tenants')]")
	WebElement tenantsTab;
	@FindBy(id="btnConsumtionbased")
	WebElement allotmentBasedTab;
	@FindBy(name = "add-new")
	WebElement addBtn;
	@FindBy(id = "tenantOrgCode")
	WebElement tenantdrpdown;
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
	@FindBy(xpath = "//div[contains(text(),'Passwords Mismatch!')]")
	WebElement confirmationError;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement createBtn;
	@FindBy(xpath = "//span[@class='fa fa-refresh']")
	WebElement refreshBtn;
	@FindBy(xpath = "//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//div/p[contains(text(),'User updated successfully')]")
	WebElement editUserMsg;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(id = "role")
	WebElement roledropdown;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement tenantdrpdownlist;
	@FindBy(xpath="//*[@id='uploadModal']/div/div/form/div[1]/fieldset/div/label/input")
	WebElement chooseFileFromDesktop;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement successMsgBox;
	@FindBy(xpath="//button[@id='uploadBtn']")
	WebElement uploadBtn;
	

	public SystemUsersPage() {
		PageFactory.initElements(driver, this);
	}
	public void creation(String tenantOrgCode,String FName, String LName, String UserMail, String UserName, String Pswd,
			String ConfirmPswd, String RoleName) throws Exception {
		// Click Users Tab
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		//wait.until(ExpectedConditions.visibilityOf(systemUsersTab));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", systemUsersTab);
		// click add new
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(addBtn));
		js.executeScript("arguments[0].click();", addBtn);
		log.info("started creating new system admin");
		//Start form
		tenantdrpdownlist.click();
		Thread.sleep(3000);
		//Select select = new Select(tenantdrpdownlist);
		//select.selectByValue("SYSADMIN");
		WebElement select_tenant=driver.findElement(By.xpath("//div[@id='options-list']/li/label[contains(text(),'"+tenantOrgCode+"')]/span"));
		select_tenant.click();
		tenantdrpdownlist.click();
		Thread.sleep(2000);
		fName.sendKeys(FName);
		Thread.sleep(2000);
		lName.sendKeys(LName);
		Thread.sleep(2000);
		userMail.sendKeys(UserMail);
		Thread.sleep(2000);
		userName.sendKeys(UserName);
		Thread.sleep(2000);
		pswd.sendKeys(Pswd);
		Thread.sleep(2000);
		confirmPswd.sendKeys(ConfirmPswd);
		Thread.sleep(5000);
		Select select_role = new Select(roledropdown);
		select_role.selectByVisibleText(RoleName);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", createBtn);
		Thread.sleep(5000);
	}
	public void creatingSystemAdmin(String tenantOrgCode,String FName, String LName, String UserMail, String UserName, String Pswd,
			String ConfirmPswd, String RoleName) throws Exception {
		creation(tenantOrgCode,FName,LName,UserMail,UserName,Pswd,ConfirmPswd,RoleName);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_Msg=alertMessage.getText();
		String expected_Msg=Messages.creationOfUser;
		Assert.assertEquals(actual_Msg,expected_Msg,"User not created");
		Reporter.log("User is created successfully",true);
		Thread.sleep(15000);
		for (int i = 0; i <= 2; i++) {
			String actual_UserName = driver.findElement(By.xpath("//table/tr/td/label[@title='" + UserName + "']")).getText();
			String expected_UserName = UserName;
			System.out.println("Actual Username:" + actual_UserName);
			System.out.println("Expected Username:" + expected_UserName);
			Assert.assertEquals(actual_UserName, expected_UserName, "System Admin can not added in list");
			Reporter.log("System Admin is verified and present in the webtable",true);
			break;
		}
		informationpage.validateSignOut();
	}
	//Creating tenant license admin for usage based license
	public void creatingTenantLicenseAdmin(String tenantOrgCode,String FName, String LName, String UserMail, String UserName, String Pswd,
			String ConfirmPswd, String RoleName)throws Exception{
		creation(tenantOrgCode,FName,LName,UserMail,UserName,Pswd,ConfirmPswd,RoleName);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		//Thread.sleep(3000);
		String actual_Msg=alertMessage.getText();
		String expected_Msg=Messages.creationOfUser;
		Assert.assertEquals(actual_Msg,expected_Msg,"User not created");
		Reporter.log("User is created successfully",true);
		Thread.sleep(15000);
		String actual_UserName = driver.findElement(By.xpath("//table/tr/td/label[@title='" + UserName + "']")).getText();
		String expected_UserName = UserName;
		System.out.println("Actual Username:" + actual_UserName);
		System.out.println("Expected Username:" + expected_UserName);
		Assert.assertEquals(actual_UserName, expected_UserName, "Tenant License Admin can not added in list");
		Reporter.log("Tenant License Admin is verified and present in the webtable",true);
		informationpage.validateSignOut();
	}
	public void validateEditTenantLicenseAdmin(String UserName,String NewUserMail,String fPswd,String Password) throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(systemUsersTab));
		js.executeScript("arguments[0].click();", systemUsersTab);
		driver.findElement(By.xpath("//table/tr/td/label[@title='" + UserName + "']")).click();
		driver.findElement(By.xpath("//table/tr/td/span")).click();
		System.out.println("clicking on edit user & editing emailID");
		for (int i = 0; i < 30; i++) {
			userMail.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(4000);
		userMail.sendKeys(NewUserMail);
		saveBtn.click();
		String actual_EditUserMsg = editUserMsg.getText();
		String expected_EditUserMsg = Messages.editSystemUser;
		System.out.println("Actual Username:" + actual_EditUserMsg);
		System.out.println("Expected Username:" + expected_EditUserMsg);
		Assert.assertEquals(actual_EditUserMsg, expected_EditUserMsg, "Tenant License Admin details not edited successfully");
		Reporter.log("Tenant License Admin details got edited.",true);
		informationpage.validateSignOut();
		loginpage.ValidateFirstTimeLogin(UserName, fPswd, Password);
		loginpage.login(UserName, Password);
		informationpage.validateSignOut();
	}

	public void creatingSystemAdminWithWrongPswd(String tenantOrgCode,String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName) throws Exception {
		creation(tenantOrgCode,FName,LName,UserMail,UserName,Pswd,ConfirmPswd,RoleName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", createBtn);
		Thread.sleep(5000);
		String errorMsg = confirmationError.getText();
		Reporter.log("Actual message when user both passwords are not same: "+errorMsg,true);
		Assert.assertEquals(errorMsg, Messages.passwordMismatch, "Not getting correct result on password mismatch");
		Reporter.log("Got correct error when there is mismatch in password",true);
		informationpage.validateSignOut();	
	}

	public void EditSystemUsers(String tenantOrgCode,String FName, String LName, String UserMail, String UserName, String Pswd,
			String ConfirmPswd,String RoleName, String NewUserMail) throws Exception {
		creation(tenantOrgCode,FName,LName,UserMail,UserName,Pswd,ConfirmPswd,RoleName);
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_Msg=alertMessage.getText();
		String expected_Msg=Messages.creationOfUser;
		Assert.assertEquals(actual_Msg,expected_Msg,"User not created");
		Reporter.log("User is created successfully",true);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//table/tr/td/label[@title='" + UserName + "']")).click();
		driver.findElement(By.xpath("//table/tr/td/span")).click();
		System.out.println("clicking on edit user & editing emailID");
		for (int i = 0; i < 30; i++) {
			userMail.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(4000);
		userMail.sendKeys(NewUserMail);
		saveBtn.click();
		String actual_EditUserMsg = editUserMsg.getText();
		String expected_EditUserMsg = Messages.editSystemUser;
		System.out.println("Actual Username:" + actual_EditUserMsg);
		System.out.println("Expected Username:" + expected_EditUserMsg);
		Assert.assertEquals(actual_EditUserMsg, expected_EditUserMsg, "System User details not edited successfully");
		Reporter.log("System User details got edited.",true);
		informationpage.validateSignOut();

	}

	public void uploadLicenseForTenantLicenseAdmin(String tenantOrgCode,String FName, String LName, String UserMail, String UserName, String Pswd,
			String ConfirmPswd, String RoleName,String Password) throws Exception {
		creatingTenantLicenseAdmin(tenantOrgCode,FName,LName,UserMail,UserName,Pswd,ConfirmPswd,RoleName);
		//Uploading the license
		Thread.sleep(2000);
		WebElement uploadBtn = driver.findElement(By.xpath("//table/tr/td[text()='OKTA_OpenID']/../td/span[@title='Upload License']"));
		uploadBtn.click();
		Reporter.log("Upload License Button is clicked",true);
		chooseFileFromDesktop.sendKeys(prop.getProperty("licenseFilePath"));
		// Runtime.getRuntime().exec("E:\\AutoIT\\LicenseUpload1.exe");
		//click on upload button
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", uploadBtn);
		//uploadBtn.click();
		Reporter.log("Upload Button is clicked",true);
		Thread.sleep(5000);
		//wait till success message comes
		//driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		Thread.sleep(5000);
		String Actual_LicenseUploadMsg = successMsgBox.getText();
		String Expected_LicenseUploadMsg = Messages.licenseUpload;
		System.out.println("Actual Success Message:"+Actual_LicenseUploadMsg);
		System.out.println("Expected Success Message:"+Expected_LicenseUploadMsg);
		Assert.assertEquals(Actual_LicenseUploadMsg, Expected_LicenseUploadMsg, "License upload Failed");
		Reporter.log("License Uploaded successfully", true);
		Thread.sleep(10000);
		informationpage.validateSignOut();
		Reporter.log("User signed out successfully",true);

	}

	public void validateSystemUsersPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click System Users Tab
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOf(systemUsersTab));
		js.executeScript("arguments[0].click();", systemUsersTab);
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
		js_tenant.executeScript("arguments[0].click();", usersTab);
		js_tenant.executeScript("arguments[0].click();", systemUsersTab);
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
			System.out.println("actual_System User Name present in table are: "+actual_UserName);
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
			System.out.println("actual_System User Name present in table are: "+actual_UserName);
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
			System.out.println("actual_System User Name present in table are: "+actual_UserName);
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
			System.out.println("actual_System User Name present in table are: "+actual_UserName);
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
			System.out.println("actual_System User Name present in table are: "+actual_UserName);
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_FirstName=op.get(i).getText();
			String str_FirstName = actual_FirstName.split(" ")[0];
			String lowercase_FirstName = str_FirstName.toLowerCase();
			System.out.println("actual_System User FirstName present in table are: "+str_FirstName);
			Assert.assertTrue(lowercase_FirstName.contains(advSearchFor));

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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_FirstName=op.get(i).getText();
			String str_FirstName = actual_FirstName.split(" ")[0];
			System.out.println("actual_System User FirstName present in table are: "+str_FirstName);
			Assert.assertTrue(str_FirstName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForLastNameEqualTo(String tenantOrgCode,String FName,String LName,String UserMail,String UserName,
			String Pswd,String ConfirmPswd,String RoleName,String SearchColumn,String SearchCriteria,String PageSize)throws Exception {
		creatingSystemAdmin(tenantOrgCode, FName, LName, UserMail, UserName, Pswd,ConfirmPswd,RoleName);
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, LName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Tenant record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_LastName=op.get(i).getText();
			String str_LastName = actual_LastName.split(" ")[1];
			System.out.println("actual_System User LastName present in table are: "+str_LastName);
			Assert.assertTrue(str_LastName.equalsIgnoreCase(LName));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
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
		//creatingSystemAdmin(tenantOrgCode, FName, LName, UserMail, UserName, Pswd,ConfirmPswd,RoleName);
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
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[2]"));
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
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", systemUsersTab);
		wb.validateClickOnAdvanceSearch();
		Thread.sleep(2000);
		wb.validateAdvanceSearchForCalender("Created",CreatedCriteria,startYear,startMonth,startDate);
		Thread.sleep(2000);
	}
	public void validateHandleCalenderForLastUpdated(String CreatedCriteria,String startYear,String startMonth,String startDate) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", systemUsersTab);
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
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", systemUsersTab);
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
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", systemUsersTab);
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
			System.out.println("actual_date present in table are: "+actual_Date);
			System.out.println("After trimming actual date"+actual_Date.substring(0,11));
			String actual_date=actual_Date.substring(0,11);
			System.out.println("ACtual date:"+actual_date);
			SimpleDateFormat sdformat = new SimpleDateFormat("dd-MMM-yyyy");
			String expected_date=startDate+"-"+startMonth+"-"+startYear;
			System.out.println("Expected date:"+expected_date);
			Date d1 = sdformat.parse(actual_date);//27
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
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", systemUsersTab);
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
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", systemUsersTab);
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
}
