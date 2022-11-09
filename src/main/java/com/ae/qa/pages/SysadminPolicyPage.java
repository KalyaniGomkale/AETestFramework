package com.ae.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class SysadminPolicyPage extends TestBase {
	public LoginPage loginpage = new LoginPage();
	public static WebDriverWait wait = new WebDriverWait(driver, 60);
	public InformationPage informationpage=new InformationPage();
	public SecurityQuestionsPage securityquestionpage=new SecurityQuestionsPage();
	@FindBy(xpath = "//span[(text()='Settings')]")
	WebElement settingsTab;
	@FindBy(xpath = "//a[text()='Sysadmin Policy']")
	WebElement sysadminPolicyTab;
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
	@FindBy(xpath = "//div[@class='card-body']/ul/li[3]/b")
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
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public SysadminPolicyPage() {
		// this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void validatePswdComplexity(String Username,String Password,String invalidPswd) throws Exception {
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(sysadminPolicyTab));
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
		//Maximum Length value = 19
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
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card-body']/ul/ul/li"));
		ArrayList<String> Output_Attempts = new ArrayList<String>();
		for (WebElement element : elements) {
			String element_value = element.getText();
			// System.out.println(element_value);
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
		wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(2000);
		changePswd.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		oldPswd.sendKeys(Password);
		Thread.sleep(3000);
		newPswd.sendKeys(invalidPswd);
		Thread.sleep(3000);
		newConfirmPswd.click();
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
		// WebElement cp_psw =
		// driver.findElement(By.xpath("//div[@class='error']/div"));
		// String pswd_criteria = cp_psw.getText();
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
	//Updated Test cases
	public void validatePasswordHistory(String Username,String FT_password,String Password,String pswdHistory1) throws Exception {
		loginpage.ValidateFirstTimeLogin(Username,FT_password,Password);
		driver.navigate().to(prop.getProperty("url"));
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		//wait.until(ExpectedConditions.visibilityOf(sysadminPolicyTab));
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", sysadminPolicyTab);
		System.out.println("Sysadmin Policy tab clicked");
		Thread.sleep(2000);
		pswdPolicyDrpDwn.click();
		//First Change
		int pswdHistory = Integer.parseInt(pswdHistory1);
		// wait.until(ExpectedConditions.visibilityOf(noOfAttempts));
		//Second Change For Password History Slider 
		//Value = 4
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
		//	informationpage.validateSignOut();
	}
	public void validateNoOfAttempts(String Username,String Password,String invalidPwd,String noOfattempt) throws Exception {
		securityquestionpage.validateSecurityQues(Username, Password);
		Thread.sleep(3000);
		driver.navigate().to(prop.getProperty("url"));
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(sysadminPolicyTab));
		js.executeScript("arguments[0].click();", sysadminPolicyTab);
		Reporter.log("Sysadmin Policy tab clicked",true);
		Thread.sleep(2000);
		int NoOfAttempt=Integer.parseInt(noOfattempt);
		///Change made For No. of Attempts
		// value = 4
		WebElement noOfAttemptSlider = driver.findElement(By.xpath("//input[@id='attempts']"));
		for (int i = 1; i <= NoOfAttempt  ; i++) {
			noOfAttemptSlider.sendKeys(Keys.ARROW_RIGHT);
		}
		saveBtn.click();
		Reporter.log(
				"Below validation validates no.of attempts for wrong password is equal to what user set in confirm Policy pop-up");
		String confirmAtempts = verifyAttempts.getText();
		int cnfAtempt = Integer.parseInt(confirmAtempts);
		System.out.println(
				"No.of wrong attempts actually set is:" + cnfAtempt + " No.of attempts set by user is:" + NoOfAttempt);
		if (cnfAtempt == NoOfAttempt) {
			System.out.println("No.of wrong attempts actually set is:" + cnfAtempt + " No.of attempts set by user is:"
					+ NoOfAttempt);
			okBtn.click();
		} else {
			Assert.assertTrue(false, "No.of attempts provided by user does not match with message in Confirm policy.");
		}
		String Actual_SuccessMsg = PopUpMsg.getText();
		String Expected_SuccessMsg = Messages.updatePasswordPolicy;
		System.out.println("Actual Message after password policy update:" + Actual_SuccessMsg);
		System.out.println("Expected Message after password policy update:" + Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Password policy not updated.");
		informationpage.validateSignOut();
		// For verifying attempts by logging in
		for (int i = 1; i <= NoOfAttempt; i++) {
			if (i < NoOfAttempt) {
				loginpage.login(Username,invalidPwd);
				String Actual_Msg = PopUpMsg.getText();
				System.out.println("Actual_msg:" + Actual_Msg);
				if (Actual_Msg.contentEquals("You have made [" + i
						+ "] unsuccessful attempt(s). The maximum retry attempts allowed for login are [" + NoOfAttempt
						+ "]")) {
					System.out.println(i + "th Unsuccessful attempt");
					// Assert.assertTrue(true);
				}
				for (int m = 0; m < 10; m++) {
					username.sendKeys(Keys.BACK_SPACE);
					password.sendKeys(Keys.BACK_SPACE);
					Thread.sleep(3000);
				}
			} else if (i == NoOfAttempt) {
				System.out.println(i + "th Unsuccessful attempt");
				loginpage.login(Username,invalidPwd);
				String Actual_Fail = PopUpMsg.getText();
				System.out.println("Actual_msg:" + Actual_Fail);
				String Expected_Fail = Messages.failPasswordPolicy;
				System.out.println("Expected_msg:" + Expected_Fail);
				Assert.assertEquals(Actual_Fail, Expected_Fail);
			}
		}
		Reporter.log("No. of attempts is validated successfully",true);
	}
	public void validateSysadminPolicyPage(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(sysadminPolicyTab));
		js.executeScript("arguments[0].click();", sysadminPolicyTab);
		Thread.sleep(2000);
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
	/*	public void validateNoOfAttempts(String Username,String Password,String invalidPwd,String noOfattempt) throws Exception {
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		wait.until(ExpectedConditions.visibilityOf(sysadminPolicyTab));
		js.executeScript("arguments[0].click();", sysadminPolicyTab);
		Reporter.log("Sysadmin Policy tab clicked",true);
		Thread.sleep(2000);
	    int NoOfAttempt=Integer.parseInt(noOfattempt);
		for (int i = 1; i <= 2; i++) {
			noOfAttempts.sendKeys(Keys.BACK_SPACE);
		}
		noOfAttempts.sendKeys("" + NoOfAttempt);
		Thread.sleep(2000);
		saveBtn.click();
		Reporter.log(
				"Below validation validates no.of attempts for wrong password is equal to what user set in confirm Policy pop-up");
		String confirmAtempts = verifyAttempts.getText();
		int cnfAtempt = Integer.parseInt(confirmAtempts);
		System.out.println(
				"No.of wrong attempts actually set is:" + cnfAtempt + " No.of attempts set by user is:" + NoOfAttempt);
		if (cnfAtempt == NoOfAttempt) {
			System.out.println("No.of wrong attempts actually set is:" + cnfAtempt + " No.of attempts set by user is:"
					+ NoOfAttempt);
			okBtn.click();
		} else {
			Assert.assertTrue(false, "No.of attempts provided by user does not match with message in Confirm policy.");
		}
		String Actual_SuccessMsg = PopUpMsg.getText();
		String Expected_SuccessMsg = Messages.updatePasswordPolicy;
		System.out.println("Actual Message after password policy update:" + Actual_SuccessMsg);
		System.out.println("Expected Message after password policy update:" + Expected_SuccessMsg);
		Assert.assertEquals(Actual_SuccessMsg, Expected_SuccessMsg, "Password policy not updated.");
		informationpage.validateSignOut();
		// For verifying attempts by logging in
		for (int i = 1; i <= NoOfAttempt; i++) {
			if (i < NoOfAttempt) {
				loginpage.login(Username,invalidPwd);
				String Actual_Msg = PopUpMsg.getText();
				System.out.println("Actual_msg:" + Actual_Msg);
				if (Actual_Msg.contentEquals("You have made [" + i
						+ "] unsuccessful attempt(s). The maximum retry attempts allowed for login are [" + NoOfAttempt
						+ "]")) {
					System.out.println(i + "th Unsuccessful attempt");
					// Assert.assertTrue(true);
				}
				for (int m = 0; m < 10; m++) {
					username.sendKeys(Keys.BACK_SPACE);
					password.sendKeys(Keys.BACK_SPACE);
					Thread.sleep(3000);
				}
			} else if (i == NoOfAttempt) {
				System.out.println(i + "th Unsuccessful attempt");
				loginpage.login(Username,invalidPwd);
				String Actual_Fail = PopUpMsg.getText();
				System.out.println("Actual_msg:" + Actual_Fail);
				String Expected_Fail = Messages.failPasswordPolicy;
				System.out.println("Expected_msg:" + Expected_Fail);
				Assert.assertEquals(Actual_Fail, Expected_Fail);
			}
		}
		Reporter.log("No. of attempts is validated successfully",true);
	}

	 */
	public void dragAndDrop(String Username, String Password,String invalidPswd) throws Exception {
		loginpage.login(Username,Password);
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(settingsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", settingsTab);
		System.out.println("Settings tab clicked");
		wait.until(ExpectedConditions.visibilityOf(sysadminPolicyTab));
		js.executeScript("arguments[0].click();", sysadminPolicyTab);
		System.out.println("Sysadmin Policy tab clicked");
		Thread.sleep(2000);
		pswdPolicyDrpDwn.click();
		WebElement maxLength = driver.findElement(By.xpath("//input[@id='uppercase']"));
		String mLength = maxLength.getAttribute("value");
		System.out.println("Max Length:-"+mLength);
		Thread.sleep(2000);
		/*//Minimum Length
		WebElement minLength = driver.findElement(By.xpath("//div/input[@id='minLength']"));
		for (int i = 1; i <= 0  ; i++) {
			minLength.sendKeys(Keys.ARROW_RIGHT);
        }
		Thread.sleep(2000);		
		//Maximum Length
		Thread.sleep(2000);
		WebElement maxLength = driver.findElement(By.xpath("//div/input[@id='maxLength']"));
		for (int i = 1; i <= 1 ; i++) {
			maxLength.sendKeys(Keys.ARROW_LEFT);
        }
		Thread.sleep(2000);
		//Minimum Uppercase
		WebElement minUpperCase = driver.findElement(By.xpath("//input[@id='uppercase']"));
		for (int i = 1; i < 0 ; i++) {
			minUpperCase.sendKeys(Keys.ARROW_RIGHT);
        }
		Thread.sleep(2000);
		//Minimum Lowercase
		WebElement minLowerCase = driver.findElement(By.xpath("//input[@id='lowercase']"));
		for (int i = 1; i < 0  ; i++) {
			minLowerCase.sendKeys(Keys.ARROW_RIGHT);
        }
		Thread.sleep(2000);
		//Minumum Special Character
		WebElement minSpecialChar = driver.findElement(By.xpath("//input[@id='specialChar']"));
		for (int i = 1; i < 0 ; i++) {
			minSpecialChar.sendKeys(Keys.ARROW_RIGHT);
        }
		Thread.sleep(2000);
		//Minimun Digits
		WebElement minDigits = driver.findElement(By.xpath("//input[@id='digits']"));
		for (int i = 1; i < 0  ; i++) {
			minDigits.sendKeys(Keys.ARROW_RIGHT);
        }
		Thread.sleep(2000);
		//For Password History

		/*saveBtn.click();
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card-body']/ul/ul/li"));
		ArrayList<String> Output_Attempts = new ArrayList<String>();
		for (WebElement element : elements) {
			String element_value = element.getText();
			// System.out.println(element_value);
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
		wait.until(ExpectedConditions.visibilityOf(UserNameTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", UserNameTab);
		Thread.sleep(2000);
		changePswd.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		oldPswd.sendKeys(Password);
		Thread.sleep(3000);
		newPswd.sendKeys(invalidPswd);
		Thread.sleep(3000);
		newConfirmPswd.click();
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
		// WebElement cp_psw =
		// driver.findElement(By.xpath("//div[@class='error']/div"));
		// String pswd_criteria = cp_psw.getText();
		String pswd_criteria = "Password length should be between " + minLength + "-" + maxLength;
		error_Attempts.add(4, pswd_criteria);
		System.out.println("Values in arrayList After:" + error_Attempts);
		System.out.println(
				"Compare thye arraylist in confirm policy popup with arraylist having error msg on change password");
		if (Output_Attempts.equals(error_Attempts)) {
			Assert.assertTrue(true, "Validation done");
		} else {
			Assert.assertTrue(false, "Validation Fail");
		}*/

	}
}
