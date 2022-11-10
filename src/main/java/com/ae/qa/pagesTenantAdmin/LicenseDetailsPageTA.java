package com.ae.qa.pagesTenantAdmin;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;

public class LicenseDetailsPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 250);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	
	@FindBy(xpath = "//span[text()='Home']")
	WebElement homeTab;
	@FindBy(xpath = "//a[text()='License Details']")
	WebElement licenseDetailsTab;
	@FindBy(xpath = "//div/span[@class='fa fa-angle-down']")
	WebElement showColumnDrpdown;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement selectAllCheckBox;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']/div")
	WebElement columnCount;
	@FindBy(xpath="//input[@id='oldpswd']")
	WebElement oldPswd;
	@FindBy(xpath="//input[@id='newpswd']")
	WebElement newPswd;
	@FindBy(xpath="//input[@id='confirmpswd']")
	WebElement newConfirmPswd;
	@FindBy(xpath="//button[text()='Change']")
	WebElement changeBtn;
	@FindBy(xpath="//div[@class='card-body']/h2")
	WebElement uploadLicense;
	@FindBy(xpath="//*[@id='uploadModal']/div/div/form/div[1]/fieldset/div/label")
	@CacheLookup
	WebElement chooseFile;
	@FindBy(xpath="//button[@name='upload']")
	WebElement uploadBtn;
	@FindBy(xpath="//*[@id='uploadModal']/div/div/form/div[1]/fieldset/div/label/input")
	WebElement chooseFileFromDesktop;
	@FindBy(xpath="//*[@id='step-license']/h4")
	WebElement licenseBox;
	@FindBy(xpath="//h4[@title='VALID']")
	WebElement validLicenseBox;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement successMsgBox;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public LicenseDetailsPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateUploadLicenseNewUser() throws Exception {
		//Sign in
		loginpageta.login(prop.getProperty("username_TA_new"), prop.getProperty("password_TA_new"));
		Reporter.log("User log in Successfully", true);
		Thread.sleep(20000);
		// Click on License upload box
		//wait.until(ExpectedConditions.visibilityOf(uploadLicense));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", uploadLicense);
		// wait til Choose file box
		//wait.until(ExpectedConditions.visibilityOf(chooseFile));
		Thread.sleep(2000);
		//give lic file 
		chooseFileFromDesktop.sendKeys(prop.getProperty("licenseFilePath"));
		// Runtime.getRuntime().exec("E:\\AutoIT\\LicenseUpload1.exe");
		//click on upload button
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", uploadBtn);
		//wait till success message comes
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		String Actual_LicenseUploadMsg = successMsgBox.getText();
		String Expected_LicenseUploadMsg = Messages.licenseUpload;
		System.out.println("Actual Success Message:"+Actual_LicenseUploadMsg);
		System.out.println("Expected Success Message:"+Expected_LicenseUploadMsg);
		Assert.assertEquals(Actual_LicenseUploadMsg, Expected_LicenseUploadMsg, "License upload Failed");
		Reporter.log("License Uploaded successfully", true);
		Thread.sleep(10000);
		informationpageta.validateSignOut();
		Reporter.log("User signed out successfully",true);
	}
	
	public void validateSelectAllColumns() throws Exception {
		// Click Users Tab
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		//wait.until(ExpectedConditions.visibilityOf(homeTab));
		Thread.sleep(5000);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", homeTab);
		//wait.until(ExpectedConditions.elementToBeClickable(licenseDetailsTab));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", licenseDetailsTab);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", showColumnDrpdown);
		Thread.sleep(5000);
		if (!selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All CheckBox");
		} else {
			System.out.println("Select All Checkbox is already selected");
		}
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
		List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th"));
		System.out.println("Total No of columns in table: " + TotalColumn.size());
		Assert.assertEquals(sizeOfColumnsInt, TotalColumn.size(), "All columns not selected");
		log.info("All Column got displayed in records after Checking select All checkbox.");
	}
	public void validateLicenseDetailsPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(homeTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", homeTab);
		js.executeScript("arguments[0].click();", licenseDetailsTab);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);		
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
						+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}

}
