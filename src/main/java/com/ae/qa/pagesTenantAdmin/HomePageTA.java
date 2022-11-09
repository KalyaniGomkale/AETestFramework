package com.ae.qa.pagesTenantAdmin;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.InformationPage;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.util.Messages;
import com.aventstack.extentreports.Status;

public class HomePageTA extends TestBase{
	public LoginPageTA loginpage = new LoginPageTA();
	public WebDriverWait wait=new WebDriverWait(driver,60);
	public InformationPageTA informationpageta=new InformationPageTA();

	@FindBy(xpath="//input[@id='oldpswd']")
	WebElement oldPswd;
	@FindBy(xpath="//input[@id='newpswd']")
	WebElement newPswd;
	@FindBy(xpath="//input[@id='confirmpswd']")
	WebElement newConfirmPswd;
	@FindBy(xpath="//button[text()='Change']")
	WebElement changeBtn;
	@FindBy(xpath="//h2[text()='Activate']")
	WebElement uploadLicense;
	@FindBy(id="licenseFileControl")
	//@CacheLookup
	WebElement chooseFile;
	@FindBy(xpath="//button[@name='upload']")
	WebElement uploadBtn;
	@FindBy(xpath="//*[@id='step-license']/h4")
	WebElement licenseBox;
	@FindBy(xpath="//h4[@title='VALID']")
	WebElement validLicenseBox;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath = "//span[text()='Workflows']")
	WebElement workflowsTab;
	@FindBy(xpath = "//a[text()='Workflow List']")
	WebElement workflowListTab;
	@FindBy(xpath = "//button[@name='add-new']/span")
	WebElement importTab;
	@FindBy(id = "workflow_name")
	WebElement workflowName;
	@FindBy(id = "description")
	WebElement wfDescription;
	@FindBy(id = "category_name")
	WebElement wfCategory;
	@FindBy(xpath="//fieldset[@class='workflow-fieldset']/div/label//input")
	WebElement ChooseWFToImport;
	@FindBy(name = "submit")
	WebElement createBtn;
	@FindBy(xpath="//span[text()='Home']")
	WebElement homeTab;
	@FindBy(xpath="//div[@id='menu-search']/input")
	WebElement SearchMenu;
	@FindBy(xpath="//*[@id='menu-search']/input")
	WebElement searchMenu;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(xpath="//div[@id='home-submenu']/ul/li/a[text()='License Details']")
	WebElement licenseDetailTab;

	public HomePageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateUploadLicenseNewUser(String wfName,String wfdes,String category) throws Exception {
		//UNverified TA user login with new changed password
		loginpage.login(prop.getProperty("username_TA1"),prop.getProperty("password_TA1")); 
		//Negative scenario -Verify without uploading license whether user can import wf (user will get error)
		//wait.until(ExpectedConditions.visibilityOf(workflowsTab));
		Thread.sleep(5000);
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", workflowsTab);
		Reporter.log("Workflows Tab is clicked",true);
		Thread.sleep(2000);
		importTab.click();
		Reporter.log("Import button clicked",true);
		workflowName.sendKeys(wfName);
		Thread.sleep(3000);
		wfDescription.sendKeys(wfdes);
		Thread.sleep(3000);
		Select wfCategory_drpdown = new Select(wfCategory);
		wfCategory_drpdown.selectByVisibleText(category);
		Thread.sleep(3000);
		ChooseWFToImport.sendKeys(prop.getProperty("WFToImportPath"));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click();", createBtn);
		Reporter.log("Create Button is clicked",true);
		//check failure message
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg = alertMessage.getText();
		System.out.println("Success message: " + actual_successMsg);
		String expected_successMsg = Messages.ImportWOLicense;
		Assert.assertEquals(actual_successMsg, expected_successMsg, "Without license import is still successful");
		Reporter.log("Import is not possible w/o License ",true);
		//Now navigate to home tab to upload license
		//wait.until(ExpectedConditions.visibilityOf(homeTab));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", homeTab);
		Reporter.log("HomeTab is clicked",true);
		//Click on License upload box
		//wait.until(ExpectedConditions.visibilityOf(uploadLicense));
		Thread.sleep(2000);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", uploadLicense);
		Reporter.log("Upload Licens ebox is clicked",true);
		//Choose license file to upload
		chooseFile.sendKeys(prop.getProperty("licenseFilePath"));
		Reporter.log("License file submitted",true); 
		//Upload the license by clicking upload button
		//wait.until(ExpectedConditions.elementToBeClickable(uploadBtn));
		Thread.sleep(2000);
		uploadBtn.click();
		Reporter.log("Upload button is clicked",true);
		//check success message comes or not
		wait.until(ExpectedConditions.visibilityOf(alertMessage));
		String actual_successMsg1 = alertMessage.getText();
		System.out.println("Success message: " + actual_successMsg);
		String expected_successMsg1 = Messages.licenseUpload;
		Assert.assertEquals(actual_successMsg1, expected_successMsg1, "License not uploaded successfully");
		Reporter.log("License Uploaded successfully for Tenant",true);
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}

	public void validateSearchFunctionalityTA(String TabName) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		Thread.sleep(3000);
		searchMenu.sendKeys(TabName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actual_tabname=driver.findElement(By.xpath("//*[text()='"+TabName+"']")).getText();
		String expected_tabname=TabName;
		Reporter.log("User searched for functionality: "+TabName+" and Found is: "+actual_tabname,true);
		Assert.assertEquals(actual_tabname, expected_tabname,"Search functionality did'nt work properly");
		Reporter.log("Search Functionality working properly",true);
		informationpageta.validateSignOut();
	}

	public void validateHomePageTA(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(homeTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", homeTab);
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
	public void validateLicenseDetailHomepage() throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		Thread.sleep(3000);
		//For Agent Thread
		String agent_Thread = driver.findElement(By.xpath("//div/span[contains(text(),'Agent Threads')]/../h4")).getText();
		String actual_AgentThread = agent_Thread.split("/")[1];
		Reporter.log("Actual Agent Thread count:-"+actual_AgentThread);
		//For Consumed Steps Unit
		String step_Units = driver.findElement(By.xpath("//div/span[contains(text(),'Step Units')]/../h4")).getText();
		String actual_StepUnits = step_Units.split("/")[1];
		Reporter.log("Actual Step Units count:-"+actual_StepUnits);
		//For Expiry date
		String expiry_Date = driver.findElement(By.xpath("//div/span[text()='License Overview']/../label")).getText();
		String actual_ExpiryDate = expiry_Date.split(" - ")[1];
		Reporter.log("Actual Expiry Date:-"+actual_ExpiryDate);
		ArrayList<String> actual_content = new ArrayList<String>();
		actual_content.add(actual_AgentThread);
		actual_content.add(actual_StepUnits);
		actual_content.add(actual_ExpiryDate);
		//Expected Content
		ArrayList<String> expected_content = new ArrayList<String>();
		expected_content.add("20");
		expected_content.add("100000");
		expected_content.add("3-Aug-2023");
		if(actual_content.equals(expected_content)) {
			Assert.assertTrue(true);
			Reporter.log("License details on Homepage are validated successfully",true);
		} else {
			Assert.assertTrue(false);
			Reporter.log("License details on Homepgae are not valiated",true);
		} 
		informationpageta.validateSignOut();
	}
	public void validateLicenseDetailTab() throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(homeTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", homeTab);
		Reporter.log("Home Tab is clicked",true);
		js.executeScript("arguments[0].click();", licenseDetailTab);
		Reporter.log("License Details Tab is clicked",true);
		List<WebElement> license_details = driver.findElements(By.xpath("//table[@class='ae-table table table-hover table-bordered table-striped']/tr/td"));
		Thread.sleep(2000);
		ArrayList<String> actual_LicenseDetails = new ArrayList<String>();
		for (WebElement element : license_details) {
			String element_value = element.getText();
			Reporter.log(element_value);
			actual_LicenseDetails.add(element_value);
			Thread.sleep(4000);
		}
		Reporter.log("Actual License details :-" +actual_LicenseDetails);
		ArrayList<String> expected_LicenseDetails = new ArrayList<String>();
		expected_LicenseDetails.add("DEVELOPMENT");
		expected_LicenseDetails.add("10");
		expected_LicenseDetails.add("20");
		expected_LicenseDetails.add("20");
		expected_LicenseDetails.add("100000");
		expected_LicenseDetails.add("10");
		expected_LicenseDetails.add("4-Aug-2022");
		expected_LicenseDetails.add("3-Aug-2023");
		Reporter.log("Expected License details :-" +expected_LicenseDetails);
		if(actual_LicenseDetails.equals(expected_LicenseDetails)) {
			Assert.assertTrue(true);
			Reporter.log("License details are validated successfully",true);
		} else {
			Assert.assertTrue(false);
			Reporter.log("License details are not valiated",true);
		} 
		informationpageta.validateSignOut();
	}
}


