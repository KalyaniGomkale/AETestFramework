package com.ae.qa.pagesTenantAdmin;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class IntegrationServicesPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver,60);
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();

	@FindBy(xpath = "//span[(text()='Integration')]")
	WebElement integrationTab;
	@FindBy(xpath = "//a[text()='Services']")
	WebElement servicesTab;
	@FindBy(xpath="//button[@name='new-req']/span")
	WebElement addBtn;
	@FindBy(id="name")
	WebElement Name;
	@FindBy(id="updateConfJobLowerLimitMinutes")
	WebElement ConfJobLowerLimit;
	@FindBy(id="updateResponseJobLowerLimitSeconds")
	WebElement ResponseJobLowerLimit ;
	@FindBy(id="1-machineName")
	WebElement machineName;
	@FindBy(id="1-userName")
	WebElement userName;
	@FindBy(id="1-clusterIP")
	WebElement hostName;
	@FindBy(id="1-clusterName")
	WebElement clusterPort;
	@FindBy(xpath="//button[@id='submitBtn']/span")
	WebElement createBtn;
	@FindBy(xpath="//span[text()='Update']")
	WebElement updateBtn;
	@FindBy(xpath="//button[@name='new-req'][1]")
	WebElement enableBtn;
	@FindBy(xpath="//button[@name='submit']")
	WebElement submitBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	
	public IntegrationServicesPageTA() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateAddIntegrationServices(String serviceName,String confjoblowerlimit ,String responsejoblowerlimit,String machinename,String username,
			String hostname,String clusterport) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		// click IntegrationTab Tab
		//wait.until(ExpectedConditions.visibilityOf(integrationTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", integrationTab);
		// click on services Tab
		js.executeScript("arguments[0].click();", servicesTab);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addBtn.click();
		Thread.sleep(3000);
		Name.sendKeys(serviceName);
		Thread.sleep(3000);
		ConfJobLowerLimit.clear();
		Thread.sleep(3000);
		ConfJobLowerLimit.sendKeys(confjoblowerlimit);
		Thread.sleep(3000);
		ResponseJobLowerLimit.clear();
		Thread.sleep(3000);
		ResponseJobLowerLimit.sendKeys(responsejoblowerlimit);
		Thread.sleep(3000);
		machineName.sendKeys(machinename);
		Thread.sleep(3000);
		userName.sendKeys(username);
		Thread.sleep(3000);
		hostName.sendKeys(hostname);
		Thread.sleep(3000);
		clusterPort.clear();
		Thread.sleep(3000);
		clusterPort.sendKeys(clusterport);
		Thread.sleep(5000);
		createBtn.click();
		Reporter.log("Create Button is clicked",true);
		//.createNode("Regression").pass("pass");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Now we have to validate whether the service is created or not in table 
	//Fetch actual values note:-give wait element clickable and try to click somewhere else in the form
		extentTest.createNode("To Verify creation of record in table").info("Started verification");
		ArrayList<String> actual_content = new ArrayList<String>();
		for(int i=2;i<6;i++) {
		WebElement Table_content = driver.findElement(By.xpath("//div[@class='table w-100 mul-options-list']/table/tr[3]/td[span='"+serviceName+"']/../td["+i+"]"));
		String element_value = Table_content.getText();
		Reporter.log("Actual values in Integration table: "+element_value,true);
		actual_content.add(element_value);
		Thread.sleep(2000);
		Reporter.log("Actual details of Integration service in table are :" +actual_content,true);
		}
		ArrayList <String> expected_Record= new ArrayList<String>();
		expected_Record.add(machinename);
		expected_Record.add(username);
		expected_Record.add(hostname);
		expected_Record.add(clusterport);
		Reporter.log("Expected details of Integration service in table are: "+expected_Record,true);
		if(actual_content.equals(expected_Record)) {
			Assert.assertTrue(true);
			Reporter.log("Integration service details verified in table",true);
			extentTest.createNode("Verification of record in table").pass("Record verified in table");
		}else {
			Assert.assertTrue(true);
			Reporter.log("Integration service details not verified in table",true);
			extentTest.createNode("Verification of record in table").fail("Record not verified in table");
		}
		informationpageta.validateSignOut();
	}

	public void validateEditIntegrationServicesTA(String serviceName,String newMachinename) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		// click IntegrationTab Tab
		//wait.until(ExpectedConditions.visibilityOf(integrationTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", integrationTab);
		// click on services Tab
		js.executeScript("arguments[0].click();", servicesTab);
		WebElement editBtn=driver.findElement(By.xpath("//div[@class='table w-100 mul-options-list']/table/tr[3]/td[span='"+serviceName+"']/../td/div/span[@class='fa fa-edit']"));
		editBtn.click();
		Reporter.log("Edit button clicked, Service with "+serviceName+ " name is editing",true);
		Thread.sleep(3000);
		machineName.clear();
		Thread.sleep(3000);
		machineName.sendKeys(newMachinename);
		Reporter.log("UserName is edited",true);
		Thread.sleep(3000);
		updateBtn.click();
		Reporter.log("Update Button is clicked, now validate the change in table",true);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement actual_machinename = driver.findElement(By.xpath("//div[@class='table w-100 mul-options-list']/table/tr[3]/td[span='"+serviceName+"']/../td[2]"));
		String actual_machineName=actual_machinename.getText();
		String expected_machineName= newMachinename;
		Reporter.log("Actual Machine Name in Integration table: "+actual_machineName+ " and Expected Machinename in Integration"
				+ "table: "+expected_machineName,true);
		Assert.assertEquals(actual_machineName,expected_machineName,"Edited machine name in Integration service didn't reflect");
		Reporter.log("Integration service edited successfully",true);	
		informationpageta.validateSignOut();
	}
	public void validateDownloadIntegrationServicesTA(String serviceName) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		// click IntegrationTab Tab
		//wait.until(ExpectedConditions.visibilityOf(integrationTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", integrationTab);
		// click on services Tab
		js.executeScript("arguments[0].click();", servicesTab);
		WebElement downloadBtn=driver.findElement(By.xpath("//div[@class='table w-100 mul-options-list']/table/tr[3]/td[span='"+serviceName+"']/../td/div/span[2]"));
		downloadBtn.click();
		Reporter.log("Download button clicked and downloading integrtration service started",true);
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void validateEnableIntForMultipleTA(String TenantOrg1,String TenantOrg2,String allowedNoOfConfig1,
			String allowedNoOfConfig2) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		// click IntegrationTab Tab
		//wait.until(ExpectedConditions.visibilityOf(integrationTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", integrationTab);
		// click on services Tab
		js.executeScript("arguments[0].click();", servicesTab);
		enableBtn.click();
		Reporter.log("Enable button is clicked",true);
		WebElement slider_Tenant1=driver.findElement(By.xpath("//input[@id='"+TenantOrg1+"']/../span"));
		slider_Tenant1.click();
		Thread.sleep(1000);
		WebElement allowedConfig_Tenant1=driver.findElement(By.xpath("//input[@id='"+TenantOrg1+"']/../../../td/input"));
		allowedConfig_Tenant1.sendKeys(allowedNoOfConfig1);
		Reporter.log("Integration service enable for Tenant1: "+TenantOrg1+ " and allowed number of configuration is: "
				+allowedNoOfConfig1,true);
		Thread.sleep(3000);
		WebElement slider_Tenant2=driver.findElement(By.xpath("//input[@id='"+TenantOrg2+"']/../span"));
		slider_Tenant2.click();
		Thread.sleep(1000);
		WebElement allowedConfig_Tenant2=driver.findElement(By.xpath("//input[@id='"+TenantOrg2+"']/../../../td/input"));
		allowedConfig_Tenant2.sendKeys(allowedNoOfConfig2);
		Reporter.log("Integration service enable for Tenant2: "+TenantOrg2+" and allowed number of configuration is: "
				+allowedNoOfConfig2,true);
		submitBtn.click();
		Reporter.log("Submit button is clicked",true);
		String actual_success_msg = alertMessage.getText();
		String expected_success_msg = Messages.enableIntegrationServices;
		System.out.println("actual success msg is: " + actual_success_msg);
		Assert.assertEquals(actual_success_msg, expected_success_msg, "Integration service not enabled for multiple Tenant.");
		Reporter.log("Integration service enabled for multiple tenant",true);
		informationpageta.validateSignOut();
		//Here we validate for one tenant,whether integration tab is displayed or not
		driver.navigate().to(prop.getProperty("url"));
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		wait.until(ExpectedConditions.visibilityOf(integrationTab));
		js.executeScript("arguments[0].click();", integrationTab);
		if(integrationTab.isDisplayed()) {
			Assert.assertTrue(true);
			Reporter.log("Integration tab is displayed for Tenant successfully",true);
		}else {
			Assert.assertTrue(false);
			Reporter.log("Integration tab is not displayed for Tenant",true);	
		}informationpageta.validateSignOut();
	}
	public void validateIntegrationServicesPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(integrationTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",integrationTab);
		js.executeScript("arguments[0].click();",servicesTab);
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
}
