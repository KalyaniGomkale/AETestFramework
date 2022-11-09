package com.ae.qa.pages;

import java.util.ArrayList;
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
import org.testng.asserts.SoftAssert;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class HomePage extends TestBase {
	public LoginPage loginpage = new LoginPage();
	public WebDriverWait wait = new WebDriverWait(driver, 60);
	public InformationPage informationpage=new InformationPage();


	@FindBy(xpath="//span[text()='Home']")
	WebElement HomeTab;
	@FindBy(xpath="//div[@class='card-body']/h2")
	WebElement uploadLicense;
	@FindBy(xpath="//*[@id='uploadModal']/div/div/form/div[1]/fieldset/div/label")
	@CacheLookup
	WebElement chooseFile;
	@FindBy(id="uploadBtn")
	WebElement uploadBtn;
	@FindBy(xpath="//*[@id='uploadModal']/div/div/form/div[1]/fieldset/div/label/input")
	WebElement chooseFileFromDesktop;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement successMsgBox;
	@FindBy(xpath="//*[@id='menu-search']/input")
	WebElement searchMenu;
	@FindBy(xpath = "//span[(text()='Settings')]")
	WebElement settingsTab;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void validateSearchFunctionality(String TabName) throws Exception {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		Thread.sleep(3000);
		searchMenu.sendKeys(TabName);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actual_tabname=driver.findElement(By.xpath("//*[text()='"+TabName+"']")).getText();
		String expected_tabname=TabName;
		Reporter.log("User searched for functionality: "+TabName+" and Found is: "+actual_tabname,true);
		Assert.assertEquals(actual_tabname, expected_tabname,"Search functionality did'nt work properly");
		Reporter.log("Search Functionality working properly",true);
		informationpage.validateSignOut();
	}
	public void validateHomePageForConsumptionTab() throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully",true);
		Thread.sleep(3000);
		if(HomeTab.isDisplayed()){
			Reporter.log("Home Page is displayed because consumption tab is enabled",true);
			Assert.assertTrue(HomeTab.isDisplayed());
		} else{
			Reporter.log("Home Page is not displayed because consumption tab is not enabled",true);
			Assert.assertTrue(HomeTab.isDisplayed());
		}
		informationpage.validateSignOut();
	}
	//For uploading Usage Based License
	public void validateUploadLicense() throws Exception{
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		Reporter.log("User log in Successfully", true);
		Thread.sleep(5000);
		// Click on License upload box
		//wait.until(ExpectedConditions.visibilityOf(uploadLicense));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", uploadLicense);
		// wait til Choose file box
		wait.until(ExpectedConditions.visibilityOf(chooseFile));
		//give lic file 
		chooseFileFromDesktop.sendKeys(prop.getProperty("UsageBasedLicensePath"));
		//click on upload button
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		js.executeScript("arguments[0].click();", uploadBtn);
		//wait till success message comes
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		String Actual_LicenseUploadMsg = successMsgBox.getText();
		String Expected_LicenseUploadMsg = Messages.licenseUpload;
		Reporter.log("Actual Success Message:"+Actual_LicenseUploadMsg);
		Reporter.log("Expected Success Message:"+Expected_LicenseUploadMsg);
		Assert.assertEquals(Actual_LicenseUploadMsg, Expected_LicenseUploadMsg, "License upload Failed");
		Reporter.log("License Uploaded successfully", true);
		Thread.sleep(10000);
		String actual_LicenseName = driver.findElement(By.xpath("//div/span[text()='License Overview']/../h4")).getText();
		Reporter.log("Actual License Name:-"+actual_LicenseName);
		List<WebElement> Table_content = driver.findElements(By.xpath("//div/span/../label/b"));
		Thread.sleep(2000);
		ArrayList<String> actual_content = new ArrayList<String>();
		for (WebElement element : Table_content) {
			String element_value = element.getText();
			Reporter.log(element_value);
			actual_content.add(element_value);
			Thread.sleep(4000);
		}
		Reporter.log("Actual License details :-" +actual_content);
		ArrayList<String> Expected_content = new ArrayList<String>();
		Expected_content.add("50");
		Expected_content.add("10000");
		Expected_content.add("10000");
		Expected_content.add("100");
		Reporter.log("Expected license details :"+Expected_content);
		
		if(actual_content.equals(Expected_content)) {
			Assert.assertTrue(true);
			Reporter.log("License consumption details are validated successfully",true);
		} else {
			Assert.assertTrue(false);
			Reporter.log("License consumption details not valiated",true);
		} 
		informationpage.validateSignOut();
		Reporter.log("User signed out successfully",true);
	}
}

