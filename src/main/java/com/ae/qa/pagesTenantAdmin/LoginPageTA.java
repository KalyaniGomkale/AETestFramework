package com.ae.qa.pagesTenantAdmin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;

public class LoginPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	// PageFactory
	@FindBy(xpath = "//input[@id='uname']")
	WebElement username;
	@FindBy(xpath = "//input[@id='pswd']")
	WebElement password;
	@FindBy(xpath = "//button[@id='signin']")
	WebElement signInBtn;
	@FindBy(xpath = "//span[contains(text(),'Forgot')]")
	WebElement forgotPwsdLink;
	@FindBy(xpath = "//title")
	WebElement pageTitle;
	@FindBy(xpath="//input[@id='oldpswd']")
	WebElement oldPswd;
	@FindBy(xpath="//input[@id='newpswd']")
	WebElement newPswd;
	@FindBy(xpath="//input[@id='confirmpswd']")
	WebElement newConfirmPswd;
	@FindBy(xpath="//button[text()='Change']")
	WebElement changeBtn;

	// initialize all this Object Repository
	public LoginPageTA() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	// return type is object of TenantPage
	public void login(String un, String pswd) throws Exception {
		username.sendKeys(un);
		Thread.sleep(2000);
		password.sendKeys(pswd);
		wait.until(ExpectedConditions.visibilityOf(signInBtn));
		signInBtn.click();
	}
	
	public void ValidateFirstTimeLogin(String Username,String FT_password,String password) throws Exception {
		//TA user login with first time password
		login(Username,FT_password); 
		Thread.sleep(2000);
		//Change password with new password
		oldPswd.sendKeys(FT_password);
		Thread.sleep(2000);
		newPswd.sendKeys(password);
		Thread.sleep(2000);
		newConfirmPswd.sendKeys(password);
		Thread.sleep(2000);
		JavascriptExecutor js_change=(JavascriptExecutor)driver;
		js_change.executeScript("arguments[0].click();", changeBtn);
		Reporter.log("User changed first time password of User Successfully",true);
	}
}
