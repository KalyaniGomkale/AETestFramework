package com.ae.qa.pages.ActivityMonitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.WebElements;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;

public class InformationPageAM extends TestBase{

	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public TenantUsersPageTA tenantuserspageta = new TenantUsersPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();

	@FindBy(xpath = "//div[@id='login-username']")
	WebElement UserNameTab;
	@FindBy(xpath = "//a[contains(text(),'Last Login : ')]")
	WebElement lastLogin;
	@FindBy(xpath = "//a[@class='dropdown-item simple-text'][2]")
	WebElement lastLoginTime;
	@FindBy(xpath = "//span[contains(text(),'View Profile')]")
	WebElement profileTab;
	@FindBy(xpath="//button[@name='cancel']/span[1]")
	WebElement cancelBtn;
	@FindBy(xpath = "//span[contains(text(),'About')]")
	WebElement aboutTab;
	@FindBy(xpath="//button[@name='close']/span[1]")
	WebElement closeBtn;
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
	@FindBy(xpath="//*[@id='menu-search']/input")
	WebElement searchMenu;

	public InformationPageAM() {
		PageFactory.initElements(driver, this);
	}

	public void validateLastLoginAM(String userType, String FName, String LName, String UserMail, String UserName,
			String Pswd, String ConfirmPswd, String RoleName,String Newpassword) throws Exception{
		tenantuserspageta.valiateCreatingTenantUser(userType, FName, LName, UserMail, UserName, Pswd, ConfirmPswd, RoleName);
		loginpageta.ValidateFirstTimeLogin(UserName, Pswd, Newpassword);
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		// UserNameTab.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(2000);
		if (lastLogin.isDisplayed()) {
			String actual_title = lastLogin.getText();
			Assert.assertEquals(actual_title, "Last Login :", "Last Login is not visible");
			System.out.println(actual_title + " is visible");
			String actual_LoginTime = lastLoginTime.getText();
			System.out.println(actual_LoginTime);
			if (actual_LoginTime != null) {
				Assert.assertTrue(true);
				Reporter.log("Last login time displayed successfully",true);
			} else {
				Assert.assertTrue(false);
				Reporter.log("Last login time not displayed",true);
			}
		}
		informationpageta.validateSignOut();
	}
	public void validateViewProfileAM() throws Exception{
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User logged in successfully",true);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click();", profileTab);
		List<WebElement> Table_content = driver.findElements(By.xpath("//table[@class='profile-table']/tbody/tr/td[1]"));
		wait.until(ExpectedConditions.visibilityOfAllElements(Table_content));
		//List<WebElement> Table_content = driver.findElements(By.xpath("//table[@class='profile-table']/tbody/tr/td[1]"));
		ArrayList<String> actual_content = new ArrayList<String>();
		for (WebElement element : Table_content) {
			String element_value = element.getText();
			System.out.println(element_value);
			actual_content.add(element_value);
			//System.out.println(actual_content);
			Thread.sleep(4000);
		}
		System.out.println("Actual content in the table is :" +actual_content);
		// //table[@class='version-container']/tr/td[1]
		ArrayList<String> Expected_content = new ArrayList<String>();
		Expected_content.add("Name");
		Expected_content.add("Email Id");
		Expected_content.add("Username");
		Expected_content.add("Role");
		Expected_content.add("Organization Code");
		Expected_content.add("Language");
		System.out.println("Expected content in the table is :"+Expected_content);

		if(actual_content.equals(Expected_content)) {
			cancelBtn.click();
			Assert.assertTrue(true);
			Reporter.log("Profile details validation successfully.",true);
		} else {
			Assert.assertTrue(false);
			Reporter.log("Profile details validation failed.",true);
		} 
		informationpageta.validateSignOut();
	}
	public void validateAboutTabAM() throws Exception{
		loginpageta.login(prop.getProperty("username_AM"), prop.getProperty("password_AM"));
		Reporter.log("User log in successfully",true);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(2000);
		aboutTab.click();
		Thread.sleep(3000);
		String actual_UIVersion=driver.findElement(By.xpath("//table/tr/td[text()='UI Version']/../td/b")).getText();
		String expected_UIVersion=prop.getProperty("UIVersion");
		String actual_ServerVersion=driver.findElement(By.xpath("//table/tr/td[text()='Server Version']/../td/b")).getText();
		String expected_ServerVersion=prop.getProperty("ServerVersion");
		System.out.println("Actual_UIVersion:- "+actual_UIVersion);
		System.out.println("Actual_ServerVersion:-"+actual_ServerVersion);
		Thread.sleep(3000);
		SoftAssert s=new SoftAssert();
		s.assertEquals(actual_UIVersion, expected_UIVersion,"UIVersion does not match");
		s.assertEquals(actual_ServerVersion, expected_ServerVersion,"Server Version does not match");
		s.assertAll();
		closeBtn.click();
		informationpageta.validateSignOut();
	}
	public void validateChangePasswordAM(String AMUser,String OldPswd,String NewPswd,String CnfPswd) throws Exception{
		loginpageta.login(AMUser,OldPswd);
		Reporter.log("User log in successfully",true);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(5000);
		changePswdTab.click();
		oldPswd.sendKeys(OldPswd);
		Thread.sleep(1000);
		newPswd.sendKeys(NewPswd);
		Thread.sleep(1000);
		newConfirmPswd.sendKeys(CnfPswd);
		wait.until(ExpectedConditions.elementToBeClickable(changeBtn));
		changeBtn.click();
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
}
