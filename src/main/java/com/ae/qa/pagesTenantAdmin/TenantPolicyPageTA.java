package com.ae.qa.pagesTenantAdmin;

import java.util.ArrayList;
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
import com.ae.qa.pages.LoginPage;
import com.ae.qa.util.Messages;

public class TenantPolicyPageTA extends TestBase{
	public LoginPageTA loginpageta = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 600);
	public InformationPageTA informationpageta=new InformationPageTA();
	@FindBy(xpath = "//span[(text()='Settings')]")
	WebElement settingsTab;
	@FindBy(xpath = "//a[text()='Tenant Policy']")
	WebElement tenantPolicyTab;
	@FindBy(xpath = "//input[@id='attemptsInput']")
	WebElement noOfAttempts;
	@FindBy(xpath = "//button[@name='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//div/ul/li[1]/b")
	WebElement verifyAttempts;
	@FindBy(id = "popup-button-ok")
	WebElement okBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement PopUpMsg;
	@FindBy(id="login-username")
	WebElement userProfileTab;
	@FindBy(name = "sign-out")
	WebElement signOutBtn;
	@FindBy(id = "uname")
	WebElement username;
	@FindBy(id = "pswd")
	WebElement password;
	@FindBy(xpath = "//span[@class='fa fa-caret-right']")
	WebElement pswdPolicyDrpDwn;
	@FindBy(id = "passwordHistoryInput")
	WebElement passwordHistoryInput;
	@FindBy(xpath = "//div[@class='card-body']/ul/li[5]/b")
	WebElement verifyHistory;
	@FindBy(id = "change-pswd")
	WebElement changePswd;
	@FindBy(xpath = "//div[@id='login-username']")
	WebElement UserNameTab;
	@FindBy(id = "oldpswd")
	WebElement oldPswd;
	@FindBy(id = "newpswd")
	WebElement newPswd;
	@FindBy(id = "confirmpswd")
	WebElement newConfirmPswd;
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
	@FindBy(xpath = "//span[text()='Users']")
	WebElement usersTab;
	@FindBy(xpath = "//a[text()='Tenant Users']")
	WebElement tenantUsersTab;
	@FindBy(xpath="//select[@formcontrolname='action']")
	WebElement selectAction;
	@FindBy(xpath="//button[text()='Next']")
	WebElement nextBtn;
	@FindBy(xpath="//input[@id='pswd']")
	WebElement Unlock_newPswd;
	@FindBy(xpath="//input[@id='confirmPswd']")
	WebElement Unlock_cnfPswd;
	@FindBy(xpath="//button[@name='submit']")
	WebElement enableBtn;
	@FindBy(id = "change-pswd")
	WebElement changePswdTab;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;


	public TenantPolicyPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validatePswdComplexityTA(String invalidPswd) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		Reporter.log("Settings tab clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(tenantPolicyTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", tenantPolicyTab);
		Reporter.log("Tenant Policy tab clicked",true);
		Thread.sleep(2000);
		pswdPolicyDrpDwn.click();
		Thread.sleep(2000);
		//Minimum Length value = 6
		WebElement minLengthSlider = driver.findElement(By.xpath("//input[@id='minLength']"));
		for (int i = 1; i <= 0  ; i++) {
			minLengthSlider.sendKeys(Keys.ARROW_RIGHT);
		}
		String minLength = minLengthSlider.getAttribute("value");
		System.out.println("Min Length:-"+minLength);
		//Maximum Length value = 19
		WebElement maxLengthSlider = driver.findElement(By.xpath("//input[@id='maxLength']"));
		int resetSlider = Integer.parseInt(maxLengthSlider.getAttribute("value"));
		for (int i = 1; i <= resetSlider  ; i++) {
			maxLengthSlider.sendKeys(Keys.ARROW_LEFT);
		}
		Thread.sleep(2000);
		for (int j = 1; j <= 13 ; j++) {
			maxLengthSlider.sendKeys(Keys.ARROW_RIGHT);
        }
		String maxLength = maxLengthSlider.getAttribute("value");
		System.out.println("Max Length:-"+maxLength);
		//Minimum Uppercase value = 1
		WebElement minUpperCaseSlider = driver.findElement(By.xpath("//input[@id='uppercase']"));
		for (int i = 1; i < 0 ; i++) {
			minUpperCaseSlider.sendKeys(Keys.ARROW_RIGHT);
		}
		String upperCase = minUpperCaseSlider.getAttribute("value");
		System.out.println("UpperCase Length:-"+upperCase);
		//Minimum Lowercase value = 1
		WebElement minLowerCaseSlider = driver.findElement(By.xpath("//input[@id='lowercase']"));
		for (int i = 1; i < 0  ; i++) {
			minLowerCaseSlider.sendKeys(Keys.ARROW_RIGHT);
		}
		String lowerCase = minLowerCaseSlider.getAttribute("value");
		System.out.println("LowerCase Length:-"+lowerCase);
		//Minumum Special Character value = 1
		WebElement minSpecialCharSlider = driver.findElement(By.xpath("//input[@id='specialChar']"));
		for (int i = 1; i < 0 ; i++) {
			minSpecialCharSlider.sendKeys(Keys.ARROW_RIGHT);
		}
		String specialChar = minSpecialCharSlider.getAttribute("value");
		System.out.println("Special Character Length:-"+specialChar);
		//Minimun Digits value = 1
		WebElement minDigitsSlider = driver.findElement(By.xpath("//input[@id='digits']"));
		for (int i = 1; i < 0  ; i++) {
			minDigitsSlider.sendKeys(Keys.ARROW_RIGHT);
		}
		String digitsIp = minDigitsSlider.getAttribute("value");
		System.out.println("Digits Length:-"+digitsIp);
		Thread.sleep(2000);
		saveBtn.click();
		Reporter.log("Clicked save button now validate the password complexity at confirm policy popup",true);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card-body']/ul/ul/li"));
		ArrayList<String> Output_Attempts = new ArrayList<String>();
		for (WebElement element : elements) {
			String element_value = element.getText();
			Output_Attempts.add(element_value);
		}
		Reporter.log("Expected Arraylist is:" + Output_Attempts,true);
		okBtn.click();
		Thread.sleep(3000);
		String Actual_SuccessMsg = PopUpMsg.getText();
		String Expected_SuccessMsg = Messages.updatePasswordPolicy;
		System.out.println("Actual Message after password policy update:" + Actual_SuccessMsg);
		System.out.println("Expected Message after password policy update:" + Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Password policy not updated.");
		System.out.println(
				"Till now we set the criteria for password and now we are verifying the same while changing pwd");
		wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		js.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(2000);
		changePswd.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		oldPswd.sendKeys(prop.getProperty("password_TA1"));
		System.out.println(prop.getProperty("password_TA1"));
		Thread.sleep(3000);
		newPswd.sendKeys(invalidPswd);
		System.out.println(invalidPswd);
		Thread.sleep(3000);
		newConfirmPswd.click();
		List<WebElement> cp_elements = driver.findElements(By.xpath("//div[@class='error']/div/ul/li"));
		wait.until(ExpectedConditions.visibilityOfAllElements(cp_elements));
		ArrayList<String> error_Attempts = new ArrayList<String>();
		for (WebElement cp_element : cp_elements) {
			String cpelement_value = cp_element.getText();
			error_Attempts.add(cpelement_value);
			Thread.sleep(2000);
		}
		Reporter.log("Values in arrayList Before:" + error_Attempts,true);
		String pswd_criteria = "Password length should be between " + minLength + "-" + maxLength;
		error_Attempts.add(4, pswd_criteria);
		System.out.println("Values in arrayList After:" + error_Attempts);
		System.out.println(
				"Compare the arraylist in confirm policy popup with arraylist having error msg on change password");
		if (Output_Attempts.equals(error_Attempts)) {
			Assert.assertTrue(true);
			Reporter.log("Validation done as Password complexity match while changing password",true);
		} else {
			Assert.assertTrue(false, "Validation Fail as password complexity doesn't match while changing password");
		}
	}
	//password History
	public void validatePasswordHistory(String Username,String Password,String pswdHistory1) throws Exception {
		loginpageta.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		Reporter.log("Settings tab clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(tenantPolicyTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();",tenantPolicyTab);
		Reporter.log("Tenant Policy tab clicked",true);
		Thread.sleep(2000);
		pswdPolicyDrpDwn.click();
		//First Change
		int pswdHistory = Integer.parseInt(pswdHistory1);
		// wait.until(ExpectedConditions.visibilityOf(noOfAttempts));
		//Second Change For Password History Slider
		//value= 3
		WebElement passwordHistory = driver.findElement(By.xpath("//input[@id='passwordHistory']"));
		for (int i = 1; i < pswdHistory ; i++) {
			passwordHistory.sendKeys(Keys.ARROW_RIGHT);
		}
		Thread.sleep(2000);
		saveBtn.click();
		Reporter.log(
				"Below validation validates number of password to be checked is equal to what user set in confirm Policy pop-up",true);
		String confirmHistory = verifyHistory.getText();
		int cnfAtempt = Integer.parseInt(confirmHistory);
		System.out.println(
				"No.of wrong attempts actually set is:" + cnfAtempt + " No.of attempts set by user is:" + pswdHistory);
		if (cnfAtempt == pswdHistory) {
			System.out.println("No. of last password to be checked that actually set is:" + cnfAtempt
					+ " No.of attempts set by user is:" + pswdHistory);
			okBtn.click();
		} else {
			Assert.assertTrue(false,
					"No.of last pswd to be checked provided by user does not match with message in Confirm policy.");
		}
		String Actual_SuccessMsg = PopUpMsg.getText();
		String Expected_SuccessMsg = Messages.updatePasswordPolicy;
		System.out.println("Actual Message after password policy update:" + Actual_SuccessMsg);
		System.out.println("Expected Message after password policy update:" + Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Password policy not updated.");
		Reporter.log("Password policy updated",true);
		// different conditions
		// Click on usersTab and change Password
		for (int i = 1; i <= pswdHistory; i++) {

			wait.until(ExpectedConditions.visibilityOf(UserNameTab));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", UserNameTab);
			Thread.sleep(2000);
			changePswd.click();
			if (i == 1) {
				oldPswd.sendKeys(Password);// Pune@0
				System.out.println(Password);
				Thread.sleep(1000);
				newPswd.sendKeys(Password + i);// Pune@01
				System.out.println(Password + i);
				Thread.sleep(1000);
				newConfirmPswd.sendKeys(Password + i);// Pune@01
				System.out.println(Password+ i);
				Thread.sleep(1000);
				changeBtn.click();
				Thread.sleep(15000);
			} 
			else if (i < pswdHistory) {
				oldPswd.sendKeys(Password+ (i - 1));// i=2;Pune@01//i=3;Pune@02
				System.out.println(Password + (i - 1));
				Thread.sleep(1000);
				newPswd.sendKeys(Password+ i);// Pune@02//Pune@03
				System.out.println(Password + i);
				Thread.sleep(1000);
				newConfirmPswd.sendKeys(Password+ i);// Pune@02//Pune@03
				System.out.println(Password + i);
				Thread.sleep(1000);
				changeBtn.click();
				Thread.sleep(15000);
			} else if (i == pswdHistory) {// i=4;
				oldPswd.sendKeys(Password+ (i - 1));// i=4;Pune@03
				System.out.println(Password+ (i - 1));
				Thread.sleep(1000);
				newPswd.sendKeys(Password);// Pune@0
				System.out.println(Password);
				Thread.sleep(1000);
				newConfirmPswd.sendKeys(Password);// Pune@0
				System.out.println(Password);
				Thread.sleep(1000);
				changeBtn.click();
				Thread.sleep(10000);
				String Actual_successMsg1 = PopUpMsg.getText();
				System.out.println("Success Message after changing password in " + i + "time: " + Actual_successMsg1);
				String Expected_successMsg1 = "Your new password must be different from your previous [" + i
						+ "] passwords.";
				System.out.println("Expected Success Message:"+Expected_successMsg1);
				Assert.assertEquals(Actual_successMsg1, Expected_successMsg1);
			}
		}
		Reporter.log("Password History of sysadmin validated successfully");
	}
	//Below Test cases are respect to Sysadmin unlocking its Tenant
	public void validateNoOfAttempts(String Username,String Password,String invalidPwd,String noOfattempt) throws Exception {
		loginpageta.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		Reporter.log("Settings tab clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(tenantPolicyTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", tenantPolicyTab);
		Reporter.log("Tenant Policy tab clicked",true);
		Thread.sleep(2000);
		int NoOfAttempt=Integer.parseInt(noOfattempt);
		///Change made For No. of Attempts
		//value = 4
		WebElement noOfAttemptSlider = driver.findElement(By.xpath("//input[@id='attempts']"));
		for (int i = 1; i <= NoOfAttempt  ; i++) {
			noOfAttemptSlider.sendKeys(Keys.ARROW_RIGHT);
		}
		Thread.sleep(2000);
		saveBtn.click();
		Reporter.log("Save button clicked & Below validation validates no.of attempts for wrong password is equal to "
				+ "what user set in confirm Policy pop-up",true);
		String confirmAtempts = verifyAttempts.getText();
		int cnfAtempt = Integer.parseInt(confirmAtempts);
		Reporter.log("No.of wrong attempts actually set is:" + cnfAtempt + " No.of attempts set by user is:" + NoOfAttempt);
		if (cnfAtempt == NoOfAttempt) {
			Reporter.log("No.of wrong attempts actually set is:" + cnfAtempt + " No.of attempts set by user is:"
					+ NoOfAttempt,true);
			okBtn.click();
			Reporter.log("Ok button clicked in confirm policy popup",true);
		} else {
			Assert.assertTrue(false, "No.of attempts provided by user does not match with message in Confirm policy.");
		}
		String Actual_SuccessMsg = PopUpMsg.getText();
		String Expected_SuccessMsg = Messages.updatePasswordPolicy;
		Reporter.log("Actual Message after password policy update:" + Actual_SuccessMsg,true);
		Reporter.log("Expected Message after password policy update:" + Expected_SuccessMsg,true);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Password policy not updated.");
		informationpageta.validateSignOut();
		// For verifying attempts by logging in
		for (int i = 1; i <= NoOfAttempt; i++) {
			if (i < NoOfAttempt) {
				loginpageta.login(Username,invalidPwd);
				String Actual_Msg = PopUpMsg.getText();
				System.out.println("Actual_msg:" + Actual_Msg);
				if (Actual_Msg.contentEquals("You have made [" + i
						+ "] unsuccessful attempt(s). The maximum retry attempts allowed for login are [" + NoOfAttempt
						+ "]")) {
					Reporter.log(i + "th Unsuccessful attempt",true);
					// Assert.assertTrue(true);
				}
				for (int m = 0; m < 10; m++) {
					username.sendKeys(Keys.BACK_SPACE);
					password.sendKeys(Keys.BACK_SPACE);
					Thread.sleep(3000);
				}
			} else if (i == NoOfAttempt) {
				System.out.println(i + "th Unsuccessful attempt");
				loginpageta.login(Username,invalidPwd);
				String Actual_Fail = PopUpMsg.getText();
				Reporter.log("Actual_msg:" + Actual_Fail,true);
				String Expected_Fail = Messages.failPasswordPolicy;
				Reporter.log("Expected_msg:" + Expected_Fail,true);
				Assert.assertEquals(Actual_Fail, Expected_Fail);
			}
		}
		Reporter.log("No. of attempts is validated successfully",true);
	}
	public void UnlockUsers(String UserToUnlock,String NewPswd,String CnfPswd) throws Exception {
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Thread.sleep(5000);
		Reporter.log("Tenant Users tab clicked",true);
		Thread.sleep(2000);
		WebElement user_record=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserToUnlock+"']/../../td/button"));
		//table/tr/td/div[text()='TenantAdmin1']/../../td/span[text()='LOCKED']
		//5.6.0.-//table/tr/td/div[text()='Tenant_Abc10']/../../td/button
		//table/tr/td/div[text()='TenantAdmin9']/../../../td/button[text()='LOCKED']
		user_record.click();
		Thread.sleep(3000);
		Select selectAction_dropdwn=new Select(selectAction);
		selectAction_dropdwn.selectByVisibleText("Unlock User");
		Thread.sleep(2000);
		nextBtn.click();
		Thread.sleep(2000);
		Unlock_newPswd.sendKeys(NewPswd);
		Thread.sleep(2000);
		Unlock_cnfPswd.sendKeys(CnfPswd);
		Thread.sleep(2000);
		enableBtn.click();
		String Actual_SuccessMsg = PopUpMsg.getText();
		String Expected_SuccessMsg = Messages.unlock_TA;
		System.out.println("Actual Message after password policy update:" + Actual_SuccessMsg);
		System.out.println("Expected Message after password policy update:" + Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Tenant Admin account is not unlocked.");
		informationpageta.validateSignOut();
	}

	public void validateUnlockTenantBySysadminTA(String UserToUnlock,String NewPswd,String CnfPswd) throws Exception {
		loginpageta.login(prop.getProperty("username"), prop.getProperty("password"));
		UnlockUsers(UserToUnlock,NewPswd,CnfPswd);
		/*	wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab clicked",true);
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		Reporter.log("Tenant Users tab clicked",true);
		Thread.sleep(2000);
		WebElement user_record=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserToUnlock+"']/../../td/button"));
		//table/tr/td/div[text()='TenantAdmin1']/../../td/span[text()='LOCKED']
		//5.6.0.-//table/tr/td/div[text()='Tenant_Abc10']/../../td/button
		//table/tr/td/div[text()='TenantAdmin9']/../../../td/button[text()='LOCKED']
		user_record.click();
		Thread.sleep(3000);
		Select selectAction_dropdwn=new Select(selectAction);
		selectAction_dropdwn.selectByVisibleText("Unlock User");
		Thread.sleep(2000);
		nextBtn.click();
		Thread.sleep(2000);
		Unlock_newPswd.sendKeys(NewPswd);
		Thread.sleep(2000);
		Unlock_cnfPswd.sendKeys(CnfPswd);
		Thread.sleep(2000);
		enableBtn.click();
		String Actual_SuccessMsg = PopUpMsg.getText();
		String Expected_SuccessMsg = Messages.unlock_TA;
		System.out.println("Actual Message after password policy update:" + Actual_SuccessMsg);
		System.out.println("Expected Message after password policy update:" + Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Tenant Admin account is not unlocked.");
		informationpageta.validateSignOut();*/
	}
	//Below Test cases are respect to Tenant Admin unlocking its Tenant
	public void validateUnlockTenantUserRespectToTA(String noOfattempt,String UserToUnlock,String invalidPswd,String NewPswd,String CnfPswd) throws Exception {
		//Tenant Admin will set number of attempts and it will bevalid for Tenant User
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		Reporter.log("Settings tab clicked",true);
		wait.until(ExpectedConditions.visibilityOf(tenantPolicyTab));
		//js.executeScript("arguments[0].click();", tenantPolicyTab);
		Thread.sleep(3000);
		Reporter.log("Tenant Policy tab clicked",true);
		Thread.sleep(2000);
		int NoOfAttempt=Integer.parseInt(noOfattempt);
		//Changes for no of attempt
		//value = 3
		WebElement noOfAttemptSlider = driver.findElement(By.xpath("//input[@id='attempts']"));
		int resetSlider = Integer.parseInt(noOfAttemptSlider.getAttribute("value"));
		for (int i = 1; i <= resetSlider  ; i++) {
			noOfAttemptSlider.sendKeys(Keys.ARROW_LEFT);
		}
		Thread.sleep(2000);
		for (int j = 1; j <= NoOfAttempt  ; j++) {
			noOfAttemptSlider.sendKeys(Keys.ARROW_RIGHT);
		}
		Thread.sleep(2000);
		saveBtn.click();
		Reporter.log("Save button clicked & Below validation validates no.of attempts for wrong password is equal to "
				+ "what user set in confirm Policy pop-up",true);
		String confirmAtempts = verifyAttempts.getText();
		int cnfAtempt = Integer.parseInt(confirmAtempts);
		Reporter.log("No.of wrong attempts actually set is:" + cnfAtempt + " No.of attempts set by user is:" + NoOfAttempt);
		if (cnfAtempt == NoOfAttempt) {
			Reporter.log("No.of wrong attempts actually set is:" + cnfAtempt + " No.of attempts set by user is:"
					+ NoOfAttempt,true);
			okBtn.click();
			Reporter.log("Ok button clicked in confirm policy popup",true);
		} else {
			Assert.assertTrue(false, "No.of attempts provided by user does not match with message in Confirm policy.");
		}
		String Actual_SuccessMsg = PopUpMsg.getText();
		String Expected_SuccessMsg = Messages.updatePasswordPolicy;
		Reporter.log("Actual Message after password policy update:" + Actual_SuccessMsg,true);
		Reporter.log("Expected Message after password policy update:" + Expected_SuccessMsg,true);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Password policy not updated.");
		informationpageta.validateSignOut();
		// For verifying attempts by logging in
		for (int i = 1; i <= NoOfAttempt; i++) {
			if (i < NoOfAttempt) {
				loginpageta.login(UserToUnlock,invalidPswd);
				String Actual_Msg = PopUpMsg.getText();
				System.out.println("Actual_msg:" + Actual_Msg);
				if (Actual_Msg.contentEquals("You have made [" + i
						+ "] unsuccessful attempt(s). The maximum retry attempts allowed for login are [" + NoOfAttempt
						+ "]")) {
					Reporter.log(i + "th Unsuccessful attempt",true);
					// Assert.assertTrue(true);
				}
				for (int m = 0; m < 10; m++) {
					username.sendKeys(Keys.BACK_SPACE);
					password.sendKeys(Keys.BACK_SPACE);
					Thread.sleep(3000);
				}
			} else if (i == NoOfAttempt) {
				System.out.println(i + "th Unsuccessful attempt");
				loginpageta.login(UserToUnlock,invalidPswd);
				String Actual_Fail = PopUpMsg.getText();
				Reporter.log("Actual_msg:" + Actual_Fail,true);
				String Expected_Fail = Messages.failPasswordPolicy;
				Reporter.log("Expected_msg:" + Expected_Fail,true);
				Assert.assertEquals(Actual_Fail, Expected_Fail);
			}
		}
		Reporter.log("No. of attempts is validated successfully",true);
		//Unlock Tenant User by Tenant Admin
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		UnlockUsers(UserToUnlock,NewPswd,CnfPswd);
		//informationpageta.validateSignOut();
		/*	validateNoOfAttempts(String Username,String Password,String invalidPwd,String noOfattempt);
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		wait.until(ExpectedConditions.visibilityOf(usersTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		System.out.println("Users tab clicked");
		wait.until(ExpectedConditions.visibilityOf(tenantUsersTab));
		js.executeScript("arguments[0].click();", tenantUsersTab);
		System.out.println("Tenant Users tab clicked");
		Thread.sleep(2000);
		WebElement user_record=driver.findElement(By.xpath("//table/tr/td/div[text()='"+UserToUnlock+"']/../../td/button"));
		//WebElement user_record=driver.findElement(By.xpath("//table/tr/td/div[text()='"+prop.getProperty("username_respToTA")+"']/../../td/button"));
		//table/tr/td/div[text()='TenantAdmin1']/../../td/span[text()='LOCKED']
//5.6.0-->/table/tr/td/div[text()='TonyKakkar']/../../td/button
		wait.until(ExpectedConditions.elementToBeClickable(user_record));
		user_record.click();
		Thread.sleep(3000);
		Select selectAction_dropdwn=new Select(selectAction);
		selectAction_dropdwn.selectByVisibleText("Unlock User");
		Thread.sleep(2000);
		nextBtn.click();
		Thread.sleep(2000);
		Unlock_newPswd.sendKeys(newPswd);
		Thread.sleep(2000);
		Unlock_cnfPswd.sendKeys(cnfPswd);
		Thread.sleep(2000);
		enableBtn.click();
		String Actual_SuccessMsg = PopUpMsg.getText();
		String Expected_SuccessMsg = Messages.unlock_TA;
		System.out.println("Actual Message after password policy update:" + Actual_SuccessMsg);
		System.out.println("Expected Message after password policy update:" + Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Tenant Admin account is not unlocked.");*/
		//informationpageta.validateSignOut();
	}

	public void validateTenantLogin(String UnlockUser,String Pswd,String NewPswd,String cnfPswd) throws Exception {
		loginpageta.login(UnlockUser,Pswd);
		Thread.sleep(5000);
		oldPswd.sendKeys(Pswd);
		Thread.sleep(1000);
		newPswd.sendKeys(NewPswd);
		Thread.sleep(1000);
		newConfirmPswd.sendKeys(cnfPswd);
		changeBtn.click();
		Thread.sleep(30000);
		loginpageta.login(UnlockUser,cnfPswd);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		String actual_pageTitle = pageTitle.getText();
		System.out.println("User navigated to " + actual_pageTitle + "Tab");
		Assert.assertEquals(actual_pageTitle, "Home", "User is not navigated to tenants tab");
	}
	public void validateTenantPolicyPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",settingsTab);
		js.executeScript("arguments[0].click();",tenantPolicyTab);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Now validate page title is same as expected
		Thread.sleep(3000);
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}


}



