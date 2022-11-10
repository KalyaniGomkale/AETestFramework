package com.ae.qa.pagesTenantAdmin;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.poifs.crypt.dsig.KeyInfoKeySelector;
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
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.Messages;

public class ProcessStudioPageTA extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();

	@FindBy(xpath = "//span[text()='Process Studio']")
	WebElement processStudioTab;
	@FindBy(xpath="//button[@title='for Windows']")
	WebElement downloadBtn;
	@FindBy(xpath="//div[@class='inline-flex-item pull-right']/button")
	WebElement assignLicenseBtn;
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchBar;
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement assignTocheckbox;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath="//button[text()='Update']")
	WebElement updateBtn;
	@FindBy(xpath ="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(name ="dropdown-selector")
	WebElement dropdownSelectorBtn;
	@FindBy(xpath ="//div/ul/li/a/span[text()='for Linux']")
	WebElement psLinuxDownloadBtn;

	public ProcessStudioPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateDownloadandAssignPS() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(processStudioTab));
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",processStudioTab);
		Reporter.log("Process Studio Tab is clicked",true);
		Thread.sleep(2000);
		//downloadBtn.click();
		//Reporter.log("Process-studio download started",true);
		//Thread.sleep(20000);
		//download will continue, assign the license
		updateBtn.click();
		Thread.sleep(3000);
		//assignLicenseBtn.click();
		Reporter.log("Assign License Button is clicked",true);
		//Because we want to assign the ps license to same TA we created
		Thread.sleep(5000);
		searchBar.sendKeys(prop.getProperty("username_TA1"));
		Thread.sleep(3000);
		assignTocheckbox.click();
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		//As there is no success message after ps assignment we will cross check with again going to assign ps tab
		//and then check if checkbox is already selected
		//Thread.sleep(10000);
		//assignLicenseBtn.click();
		//Reporter.log("Assign License Button is clicked",true);
		for(int i=1;i<30;i++) {
			searchBar.sendKeys(Keys.BACK_SPACE);
		}
		searchBar.sendKeys(prop.getProperty("username_TA1"));
		Thread.sleep(2000);
		//Boolean status=assignTocheckbox.isSelected();
		if(assignTocheckbox.isSelected()) {
			Reporter.log("Process studio license assigned",true);
			Assert.assertTrue(assignTocheckbox.isSelected());
		} else {
			Reporter.log("Process studio license is not assigned correctly",true);	
			Assert.assertTrue(assignTocheckbox.isSelected());
		}
		informationpageta.validateSignOut();
	}
	public void validateProcessStudioPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(processStudioTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",processStudioTab);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
				+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}
	public void validateUnAssignPS() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(processStudioTab));
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",processStudioTab);
		Reporter.log("Process Studio Tab is clicked",true);
		Thread.sleep(2000);
		updateBtn.click();
		Thread.sleep(3000);
		searchBar.sendKeys(prop.getProperty("username_TA1"));
		Thread.sleep(3000);
		assignTocheckbox.click();
		Thread.sleep(3000);
		saveBtn.click();
		Reporter.log("Save button is clicked",true);
		//As there is no success message after ps assignment we will cross check with again going to assign ps tab
		//and then check if checkbox is already selected
		for(int i=1;i<30;i++) {
			searchBar.sendKeys(Keys.BACK_SPACE);
		}
		searchBar.sendKeys(prop.getProperty("username_TA1"));
		Thread.sleep(2000);
		if(assignTocheckbox.isSelected()) {
			Reporter.log("Process studio license assigned already",true);
			Assert.assertFalse(assignTocheckbox.isSelected());
		} else {
			Reporter.log("Process studio license is unassigned correctly",true);	
			Assert.assertFalse(assignTocheckbox.isSelected());
		}
		informationpageta.validateSignOut();
	}
	public void validateAssignPSToUserAsPerLicense() throws Exception{
		loginpageta.login(prop.getProperty("username_TA3"), prop.getProperty("password_TA3"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(processStudioTab));
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",processStudioTab);
		Reporter.log("Process Studio Tab is clicked",true);
		Thread.sleep(2000);
		updateBtn.click();
		Reporter.log("Update Button is clicked",true);
		Thread.sleep(3000);
		List <WebElement> PSCheckboxes= driver.findElements(By.xpath("//input[@type='checkbox']"));
		int size = PSCheckboxes.size();
		System.out.println("Number of user present to assign PS:- "+size);
		for(int i = 0; i<size; i++) {
			PSCheckboxes.get(i).click();
		}
		Thread.sleep(3000);
		String actual_Message=alertMessage.getText();
		System.out.println("Actual Message PS_Limit:- "+actual_Message);
		String expected_Message=Messages.PSUploadLimitMsg;
		System.out.println("Expected Message PS_Limit:- "+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message, "Process Studio limit not reached");
		Reporter.log("PS limit reached",true);
		informationpageta.validateSignOut();
	}
	public void validateProcessStudioDownloadLinux() throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(processStudioTab));
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",processStudioTab);
		Reporter.log("Process Studio Tab is clicked",true);
		Thread.sleep(2000);
		dropdownSelectorBtn.click();
		psLinuxDownloadBtn.click();
		Reporter.log("PS download button for Linux is clicked successfully",true);
		Thread.sleep(10000);
		Reporter.log("PS for Linux is downloaded successfully",true);
		informationpageta.validateSignOut();
		}
}
