package com.ae.qa.pages;

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
import com.ae.qa.util.Messages;
import com.aventstack.extentreports.Status;

public class InformationPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	public WebElements webelements = new WebElements();
	public LoginPage loginpage = new LoginPage();
	//public InformationPage informationpage=new InformationPage();
	@FindBy(id="login-username")
	WebElement UserNameTab;
	@FindBy(xpath = "//a[contains(text(),'Last Login : ')]")
	WebElement lastLogin;
	@FindBy(xpath = "//a[@class='dropdown-item simple-text'][2]")
	WebElement lastLoginTime;
	@FindBy(xpath = "//span[contains(text(),'View Profile')]")
	WebElement profileTab;
	@FindBy(xpath = "//span[contains(text(),'About')]")
	WebElement aboutTab;
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
	@FindBy(xpath = "//div/p[contains(text(),'Password updated successfully')]")
	WebElement success_msg;
	@FindBy(name="sign-out")
	WebElement signOutBtn;
	@FindBy(xpath="//button[@name='close']/span[1]")
	WebElement closeBtn;
	@FindBy(xpath="//button[@name='cancel']/span[1]")
	WebElement cancelBtn;

	public InformationPage() {
		PageFactory.initElements(driver, this);
	}

	public void validateLastLogin() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		Thread.sleep(5000);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(UserNameTab));
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
			Thread.sleep(3000);
		}
		validateSignOut();
	}

	public void validateViewProfile() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User logged in successfully",true);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", profileTab);
		//Thread.sleep(3000);
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
		validateSignOut();
	}

	public void validateAbout() throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(2000);
		aboutTab.click();
		Reporter.log("About tab is clicked",true);
		List<WebElement> Table_content = driver.findElements(By.xpath("//table[@class='version-container']/tr/td[1]"));
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
		Expected_content.add("UI Version");
		Expected_content.add("Server Version");
    	//Expected_content.add("Process Studio Framework Version");
		Expected_content.add("Supported Process Studio Framework Versions");
		System.out.println("Expected content in the table is :"+Expected_content);
		
		if(actual_content.equals(Expected_content)) {
			//closeBtn.click();
			Assert.assertTrue(true);
			Reporter.log("Profile details validation successfully.",true);
		} else {
			//closeBtn.click();
			Assert.assertTrue(false);
			Reporter.log("Profile details validation failed.",true);
		} 
		//cancelBtn.click();
		//validateSignOut();
	}
		
	/*	// ArrayList<String> Table_content=new ArrayList<String>();
		// //table[@class='version-container']/tr/td[1]
		ArrayList<String> Expected_content = new ArrayList<String>();
		Expected_content.add("UI Version");
		Expected_content.add("Server Version");
		Expected_content.add("Process Studio Framework Version");
		Expected_content.add("Supported Process Studio Framework Versions");
		System.out.println(Expected_content);
		Thread.sleep(3000);
		int a = 0, b = 0;
		for (int j = 0; j < Table_content.size(); j++) {
			if (Expected_content.contains(Table_content.get(j).getText())) {
				System.out.println("Exist:" + Table_content.get(j).getText());
				a = 1;
			} else {
				System.out.println("Not Exist:" + Table_content.get(j).getText());
				b = 1;
			}
		}
		if (a == 1 && b == 0) {
			extentTest.log(Status.PASS, "All details in About tab exist");
		} else if (b == 1) {
			extentTest.log(Status.FAIL, "All details in About tab not exist");
		} else {
			extentTest.log(Status.FAIL, "All details in About not exist");
		}
		validateSignOut();
	}*/

	public void validateChangePassword(String Username, String Password, String newpassword,String newCnfPaswd) throws Exception {
		// loginpage.login("System_Abc22","Pune@1234");
		loginpage.login(Username,Password);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(2000);
		changePswdTab.click();
		oldPswd.sendKeys(Password);
		Thread.sleep(1000);
		newPswd.sendKeys(newpassword);
		Thread.sleep(1000);
		newConfirmPswd.sendKeys(newCnfPaswd);
		changeBtn.click();
		Thread.sleep(6000);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//String Actual_successMsg = success_msg.getText();
	//	System.out.println("Success Message after changing password: " + Actual_successMsg);
	//	String Expected_successMsg = Messages.changePassword;
	//	Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Password not changed");
		validateSignOut();
	}
	
	public void validateSignOut() throws InterruptedException {
		//loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(5000);
		js1.executeScript("arguments[0].click();", signOutBtn);
		System.out.println("User signed out successfully");
		
	}
	public void aboutTab() throws Exception
	{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in successfully",true);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(UserNameTab));
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
		validateSignOut();

	}

}
