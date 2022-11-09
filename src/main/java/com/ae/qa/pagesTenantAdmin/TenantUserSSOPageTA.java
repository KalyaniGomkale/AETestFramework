package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

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
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;
import com.ae.qa.util.TestUtil;

public class TenantUserSSOPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public TenantsPage tenantspage=new TenantsPage();
	public TenantUsersPage tenantuserspage= new TenantUsersPage();
	public TestUtil testutil=new TestUtil();
	
	@FindBy(xpath="//span[text()='Settings']")
	WebElement settingsTab;
	@FindBy(xpath="//a[text()='Single Sign-On']")
	WebElement singleSignOnTab;
	@FindBy(name="import")
	WebElement ImportBtn;
	@FindBy(xpath="//textarea[@id='url']")
	WebElement endpointsJSON;
	@FindBy(xpath="//button[@name='assign']")
	WebElement nextBtn;
	@FindBy(id="provider")
	WebElement identityProvider;
	@FindBy(id="protocol")
	WebElement protocol;
	@FindBy(id="redirectUrl")
	WebElement redirectURL;
	@FindBy(id="clientId")
	WebElement clientId;
	@FindBy(xpath="//button[@name='save' and @type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//span[text()='Users']")
	WebElement usersTab;
	@FindBy(xpath = "//a[text()='Tenant Users']")
	WebElement tenantUsersTab;
	@FindBy(xpath = "//button[@name='add-cred']/span")
	WebElement addBtn;
	@FindBy(id = "authType")
	WebElement userTypedropdown;
	@FindBy(id="username")
	WebElement Username;
	@FindBy(id="idpUsername")
	WebElement IDPUsername;
	@FindBy(id="role")
	WebElement role;
	@FindBy(xpath="//button[@name='submit']")
	WebElement submitBtn;
	@FindBy(xpath="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//a[@id='custom-domain']/span")
	WebElement ssoLink;
	@FindBy(id="orgCode")
	WebElement OrgCode;
	@FindBy(xpath="//button[@name='submit']")
	WebElement continueBtn;
	@FindBy(id="okta-signin-username")
	WebElement oktaUsername;
	@FindBy(id="okta-signin-password")
	WebElement oktaPswd;
	@FindBy(id="okta-signin-submit")
	WebElement signINbtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement homePage;
	@FindBy(xpath="//button[@name='add-new']")
	WebElement configureBtn;
	
	public TenantUserSSOPageTA() {
		PageFactory.initElements(driver, this);
	}
	//loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
	public void ValidateConfigureOKTAwidOpenID(String tName, String tDescription, String orgCode,String FName,String LName,
			String UserMail,String UserName,String Pswd,String ConfirmPswd,
			String RoleName,String newpassword,String IdentityProvider,String Protocol,String RedirectURL,
			String ClientID,
			String SSOuserType,String OKTAUsername,String IDPUserName,String OKTAUserName,String OKTAPassword
			) throws Exception {
		// Login with sysadmin and create Tenant and then Tenant admin so that we can do different configurations 
		extentTest.createNode("To create Tenant").info("Create new Tenant for SSO OKTA+OpenID");
		tenantspage.addNewTenants(tName, tDescription, orgCode);
		extentTest.createNode("Tenant Created successfully").pass("Success");
		extentTest.createNode("To create Tenant Admin with above created Tenant").info("Create Tenant Admin for SSO OKTA+OpenID");
		tenantuserspage.creatingTenantUser(orgCode, FName, LName, UserMail, UserName, Pswd, ConfirmPswd, RoleName);
		extentTest.createNode("Tenant Admin Created successfully").pass("Success");
		Thread.sleep(3000);
		//Now login as Tenant admin which is created above and create new sso user
		extentTest.createNode("To Login with above created TA and do SSO configuration").info("Do SSO configuration for OKTA with Open ID");
		driver.navigate().to(prop.getProperty("url"));
		loginpageta.ValidateFirstTimeLogin(UserName,Pswd, newpassword);
		Thread.sleep(3000);
		driver.navigate().to(prop.getProperty("url"));
		loginpageta.login(UserName,newpassword);
		Reporter.log("User log in Successfully",true);
		//before creating user sso configuration is necessary
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		// Click Single-sign on Tab
		//wait.until(ExpectedConditions.visibilityOf(singleSignOnTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();",singleSignOnTab);
		Reporter.log("Single Sign-on Tab is clicked",true);
		ImportBtn.click();
		Thread.sleep(3000);
	//	testutil.getTextFromTextFile();
		String ip=testutil.getTextFromTextFile();
		System.out.println("Input text is:"+ip);
		endpointsJSON.sendKeys(ip);
		Thread.sleep(10000);
		nextBtn.click();
		Thread.sleep(3000);
		Select idProvider_dropdown= new Select(identityProvider);
		idProvider_dropdown.selectByValue(IdentityProvider);
		Reporter.log(IdentityProvider+" Identity Provider selected from dropdown",true);
		Thread.sleep(3000);
		Select Protocol_dropdown= new Select(protocol);
		Protocol_dropdown.selectByVisibleText(Protocol);
		Reporter.log(Protocol+" Protocol selected from dropdown",true);
		redirectURL.sendKeys(RedirectURL);
		Thread.sleep(3000);
		clientId.sendKeys(ClientID);
		Thread.sleep(3000);
		saveBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_Msg = alertMessage.getText();
		String expected_Msg = Messages.SSOConfiguration;
		Reporter.log("Actual message:" + actual_Msg,true);
		Assert.assertEquals(actual_Msg, expected_Msg,"SSO Configuration failed.");
		extentTest.createNode("SSO Configuration done for OKTA with Open ID protocol").pass("Success");
		//below code is to create sso user 
		extentTest.createNode("To Login with above created TA and create new SSO user").info("Create SSO user with role TA");
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		js.executeScript("arguments[0].click();", usersTab);
		// Click TenantUsers Tab
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		// click add new
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		js.executeScript("arguments[0].click();", addBtn);
		Reporter.log("started creating new " +RoleName,true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Select user_type = new Select(userTypedropdown);
		user_type.selectByVisibleText(SSOuserType);//SSO Users
		Username.sendKeys(OKTAUsername);
		Thread.sleep(2000);
		IDPUsername.sendKeys(IDPUserName);
		Thread.sleep(2000);
		Select role_dropdown=new Select(role);
		role_dropdown.selectByVisibleText(RoleName);
		Thread.sleep(2000);
		submitBtn.click();
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		String expected_successMsg = Messages.createUser;
		System.out.println("Actual message:" + actual_successMsg);
		Assert.assertEquals(actual_successMsg, expected_successMsg,"User not created.");
		Reporter.log(RoleName + " created successfully",true);
		informationpageta.validateSignOut();
		extentTest.createNode("SSO user created").pass("Success");
		Thread.sleep(2000);
		extentTest.createNode("Sign in with sso User").info("Sign in started");
		ssoLink.click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		OrgCode.sendKeys(orgCode);
		Thread.sleep(20000);
		continueBtn.click();
	    wait.until(ExpectedConditions.visibilityOf(oktaUsername));
	    Reporter.log("User redirected to OKTA successfully",true);
	    extentTest.createNode("Okta Login started").info("Login started");
		oktaUsername.sendKeys(OKTAUserName);
		Thread.sleep(2000);
		oktaPswd.sendKeys(OKTAPassword);
		Thread.sleep(2000);
		signINbtn.click();
		extentTest.createNode("Okta Login successfully").pass("Success");
		wait.until(ExpectedConditions.visibilityOf(homePage));
		String actual_redirectedTab=homePage.getText();
		Assert.assertEquals(actual_redirectedTab,"Home","SSO user not correctly directed to AE Portal.");
		Reporter.log("SSO user correctly directed to AE home page",true);
		extentTest.createNode("Okta Login successfully").pass("Success");
	}

}
