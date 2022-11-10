package com.ae.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;


public class LoginPage extends TestBase {
	public static WebDriverWait wait = new WebDriverWait(driver, 120);

	// PageFactory
	@FindBy(id = "uname")
	WebElement username;
	@FindBy(id = "pswd")
	WebElement password;
	@FindBy(id = "signin")
	WebElement signInBtn;
	@FindBy(xpath = "//title")
	WebElement pageTitle;
	@FindBy(xpath = "//span[contains(text(),'Forgot Password')]")
	WebElement forgotpswdLink;
	@FindBy(id = "userName")
	WebElement resetUname;
	@FindBy(id = "signin")
	WebElement submitBtn;
	@FindBy(id = "pswd")
	WebElement newPswd;
	@FindBy(id = "confirmPswd")
	WebElement cnfPswd;
	@FindBy(xpath = "//button[@id='reset']")
	WebElement resetBtn;
	@FindBy(xpath = "//p")
	WebElement successMsg;
	@FindBy(xpath = "//h2")
	WebElement titlePage;
	@FindBy(xpath = "//span[(text()='Settings')]")
	WebElement settingsTab;
	@FindBy(xpath = "//a[text()='Sysadmin Policy']")
	WebElement sysadminPolicyTab;
	@FindBy(xpath = "//span[@class='fa fa-caret-right']")
	WebElement pswdPolicyDrpDwn;
	@FindBy(id = "passwordHistoryInput")
	WebElement passwordHistoryInput;
	@FindBy(xpath = "//div[@class='card-body']/ul/li[3]/b")
	WebElement verifyHistory;
	@FindBy(id = "change-pswd")
	WebElement changePswd;
	@FindBy(xpath = "//div[@id='login-username']")
	WebElement UserNameTab;
	@FindBy(xpath = "//button[text()='Change']")
	WebElement changeBtn;
	@FindBy(id = "minLengthInput")
	WebElement minLengthInput;
	@FindBy(id = "maxLengthInput")
	WebElement maxLengthInput;
	@FindBy(id = "uppercaseInput")
	WebElement uppercaseInput;
	@FindBy(id = "lowercaseInput")
	WebElement lowercaseInput;
	@FindBy(id = "specialCharInput")
	WebElement specialCharInput;
	@FindBy(id = "digitsInput")
	WebElement digitsInput;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement saveBtn;
	@FindBy(id = "popup-button-ok")
	WebElement okBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement PopUpMsg;
	@FindBy(xpath="//input[@id='oldpswd']")
	WebElement oldPswd;
	@FindBy(xpath="//input[@id='newpswd']")
	WebElement newPswd1;
	@FindBy(xpath="//input[@id='confirmpswd']")
	WebElement newConfirmPswd;
	@FindBy(xpath = "//div/h2[contains(text(),'Home')]")
	WebElement homePageTitle;
	
	
	// initialize all this Object Repository
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public void login(String un, String pswd) throws Exception {
		username.sendKeys(un);
		password.sendKeys(pswd);
	//	wait.until(ExpectedConditions.visibilityOf(signInBtn));
		Thread.sleep(3000);
		signInBtn.click();
	}
	
	public void ValidateFirstTimeLogin(String Username,String FT_password,String password) throws Exception {
		//sysadmin user login with first time password
		login(Username,FT_password); 
		Thread.sleep(2000);
		//Change password with new password
		oldPswd.sendKeys(FT_password);
		Thread.sleep(2000);
		newPswd1.sendKeys(password);
		Thread.sleep(2000);
		newConfirmPswd.sendKeys(password);
		Thread.sleep(2000);
		JavascriptExecutor js_change=(JavascriptExecutor)driver;
		js_change.executeScript("arguments[0].click();", changeBtn);
		Reporter.log("User changed first time password of sysadmin Successfully",true);
	}

	public boolean ValidateForgotPswdLink() throws Exception {
		boolean flag = false;
		if (forgotpswdLink.isDisplayed()) {
			String Actual_field = forgotpswdLink.getText();
			System.out.println(Actual_field);

			if (Actual_field.contentEquals("Forgot Password")) {
				flag = true;
			} else {
				flag = false;
			}
		}
	//	InformationPage informationpage=new InformationPage();
	//	informationpage.validateSignOut();
		return flag;
	}
		
	public void ValidateResetPswd(String Username,String resetPswd,String resetCnfPswd) throws Exception {
		Thread.sleep(5000);
		forgotpswdLink.click();
		Reporter.log("Forgot password link clicked",true);
		resetUname.sendKeys(Username);
		Reporter.log("Username entered",true);
		Thread.sleep(8000);
		//wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
		Reporter.log("submitted",true);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		for (int i = 1; i <= 3; i++) {
			WebElement Ques = driver.findElement(By.xpath("//fieldset[" + i + "]/label"));
			String verify_Ques = Ques.getText();
			// select.selectByVisibleText(prop.getProperty("IQue"+i));
			if (verify_Ques.equalsIgnoreCase(prop.getProperty("IQue" + i))) {
				Thread.sleep(2000);
				WebElement select_Ans = driver.findElement(By.id("ans" + i + ""));
				select_Ans.sendKeys(prop.getProperty("IAns" + i));
				Thread.sleep(2000);
			}
		}
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
		Reporter.log("security questions submitted",true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		newPswd.sendKeys(resetPswd);
		Thread.sleep(1000);
		cnfPswd.sendKeys(resetCnfPswd);
		// wait.until(ExpectedConditions.elementToBeClickable(resetBtn));
		resetBtn.click();
	//	JavascriptExecutor js2 = (JavascriptExecutor) driver;
		//js2.executeScript("arguments[0].click();", resetBtn);
		Reporter.log("Set new password successfully",true);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actual_msg = successMsg.getText();
		String expected_msg = Messages.resetPassword;
		Thread.sleep(11000);
		//wait.until(ExpectedConditions.visibilityOf(successMsg));
		System.out.println("Actual Message after resetting password:" + actual_msg);
		Assert.assertEquals(actual_msg, expected_msg);
		Reporter.log("Password set successfully",true);
		//InformationPage informationpage=new InformationPage();
		//informationpage.validateSignOut();
	}

	public void ValidateLoginWithResetPswd(String Username,String Password) throws Exception {
		LoginPage loginpage = new LoginPage();
		loginpage.login(Username,Password);
		String PageTitle = homePageTitle.getText();
		System.out.println("User is Login with new paswword and navigated to " + PageTitle + " page.");
		Assert.assertEquals(PageTitle, "Home", "User is not navigated to tenants page");
		InformationPage informationpage=new InformationPage();
		informationpage.validateSignOut();	
	}
	
	public void ValidateForgotPswdWithoutSecQues(String Username) throws Exception {
		forgotpswdLink.click();
		Reporter.log("Forgot password link clicked",true);
		resetUname.sendKeys(Username);
		Reporter.log("Username entered",true);
		Thread.sleep(8000);
		submitBtn.click();
		Reporter.log("submitted",true);
		Thread.sleep(8000);
		String actual_msg = successMsg.getText();
		String expected_msg = Messages.PwSetNotSecurityQuestion;
		Thread.sleep(11000);
		//wait.until(ExpectedConditions.visibilityOf(successMsg));
		System.out.println("Actual Message after resetting password:" + actual_msg);
		Assert.assertEquals(actual_msg, expected_msg);
		Reporter.log("Password set successfully",true);
	}
	
	public void ValidateSettingPwdWOComplexity(String Username,String Password,String ResetPswd,String ResetCnfPswd) throws Exception {
		LoginPage loginpage = new LoginPage();
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		//wait.until(ExpectedConditions.visibilityOf(sysadminPolicyTab));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", sysadminPolicyTab);
		System.out.println("Sysadmin Policy tab clicked");
		Thread.sleep(2000);
		pswdPolicyDrpDwn.click();
		 //Minimum Length value = 6
		WebElement minLengthSlider = driver.findElement(By.xpath("//input[@id='minLength']"));
		for (int i = 1; i <= 0  ; i++) {
			minLengthSlider.sendKeys(Keys.ARROW_RIGHT);
        }
		String minLength = minLengthSlider.getAttribute("value");
		System.out.println("Min Length:-"+minLength);
		//Maximum Length value = 13
		WebElement maxLengthSlider = driver.findElement(By.xpath("//input[@id='maxLength']"));
		int resetSlider = Integer.parseInt(maxLengthSlider.getAttribute("value"));
		for (int i = 1; i <= resetSlider  ; i++) {
			maxLengthSlider.sendKeys(Keys.ARROW_LEFT);
		}
		Thread.sleep(2000);
		for (int j = 1; j <= 7 ; j++) {
			maxLengthSlider.sendKeys(Keys.ARROW_RIGHT);
        }
		String maxLength = maxLengthSlider.getAttribute("value");
		System.out.println("Max Length:-"+maxLength);
		saveBtn.click();
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card-body']/ul/ul/li"));
		ArrayList<String> Output_Attempts = new ArrayList<String>();
		for (WebElement element : elements) {
			String element_value = element.getText();
			Output_Attempts.add(element_value);
		}
		System.out.println("Expected Arraylist is:" + Output_Attempts);
		okBtn.click();
		Thread.sleep(3000);
		String Actual_SuccessMsg = PopUpMsg.getText();
		String Expected_SuccessMsg = Messages.updatePasswordPolicy;
		System.out.println("Actual Message after password policy update:" + Actual_SuccessMsg);
		System.out.println("Expected Message after password policy update:" + Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Password policy not updated.");
		System.out.println(
				"Till now we set the criteria for password and now we are verifying the same while changing pwd");
		InformationPage informationpage=new InformationPage();
		informationpage.validateSignOut();	
//Log out and verify after entering sec questions check complexity of password 
		forgotpswdLink.click();
		Reporter.log("Forgot password link clicked",true);
		resetUname.sendKeys(Username);
		Reporter.log("Username entered",true);
		Thread.sleep(8000);
		submitBtn.click();
		Reporter.log("submitted",true);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		for (int i = 1; i <= 3; i++) {
			WebElement Ques = driver.findElement(By.xpath("//fieldset[" + i + "]/label"));
			String verify_Ques = Ques.getText();
			if (verify_Ques.equalsIgnoreCase(prop.getProperty("IQue" + i))) {
				Thread.sleep(2000);
				WebElement select_Ans = driver.findElement(By.id("ans" + i + ""));
				select_Ans.sendKeys(prop.getProperty("IAns" + i));
				Thread.sleep(2000);
			}
		}
		Thread.sleep(5000);
		submitBtn.click();
		Reporter.log("security questions submitted",true);
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		newPswd.sendKeys(ResetPswd);
		Thread.sleep(1000);
		cnfPswd.sendKeys(ResetCnfPswd);
		// wait.until(ExpectedConditions.elementToBeClickable(resetBtn));
		resetBtn.click();
		List<WebElement> cp_elements = driver.findElements(By.xpath("//div[@class='error']/div/ul/li"));
		wait.until(ExpectedConditions.visibilityOfAllElements(cp_elements));
		ArrayList<String> error_Attempts = new ArrayList<String>();
		for (WebElement cp_element : cp_elements) {
			String cpelement_value = cp_element.getText();
			// System.out.println(cpelement_value);
			error_Attempts.add(cpelement_value);
			Thread.sleep(2000);
		}
		System.out.println("Values in arrayList Before:" + error_Attempts);
		String pswd_criteria = "Password length should be between " + minLength + "-" + maxLength;
		error_Attempts.add(4, pswd_criteria);
		System.out.println("Values in arrayList After:" + error_Attempts);
		System.out.println(
				"Compare thye arraylist in confirm policy popup with arraylist having error msg on change password");
		if (Output_Attempts.equals(error_Attempts)) {
			Assert.assertTrue(true, "Validation done");
		} else {
			Assert.assertTrue(false, "Validation Fail");
		}
	}
	 public void validateUnlockUserWithSecQueAndResetPswd(String Username,String resetPswd,String resetCnfPswd) throws Exception {
		 LoginPage loginpage = new LoginPage();
		 loginpage.ValidateResetPswd(Username, resetPswd, resetCnfPswd);
		// loginpage.ValidateLoginWithResetPswd(Username,resetPswd);
	 }
}
