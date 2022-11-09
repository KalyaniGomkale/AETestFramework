package com.ae.qa.pages.TenantUser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.pagesTenantAdmin.RequestsPageTA;
import com.ae.qa.util.Messages;

public class CataloguePageTU extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public RequestsPageTA requestspageta=new RequestsPageTA();
	
	@FindBy(xpath = "//span[text()='Catalogue']")
	WebElement catalogueTab;
	@FindBy(xpath="//button[@name='submit']")
	WebElement submitRequestBtn;
	@FindBy(id="popup-button-ok")
	WebElement okBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(id="category")
	WebElement categoryDropdown;
	@FindBy(xpath = "//span[text()='Requests']")
	WebElement requestsTab;
	@FindBy(xpath = "//*[@id='main-component']/ng-component/div[3]/div[3]/div[2]/table/tbody[1]/tr/td[3]/span[1]")
	WebElement requestStatus;
	@FindBy(name = "refresh-btn")
	WebElement refershTableBtn;
	@FindBy(xpath = "//span[contains(@id,'trow-true')]")
	WebElement reqStatus;
	@FindBy(xpath = "//table[@class='ae-table table table-bordered table-hover']/tbody/tr[2]/td/div/span[1]")
	WebElement execMessage;
	@FindBy(xpath = "//table[@id='agentTable']/tr[3]/td[5]/span")
	WebElement status;
	
	
	public CataloguePageTU() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateRequestStatus() throws Exception {
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User logged in successfully", true);
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOf(requestsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", requestsTab);
		Reporter.log("Requests Tab is clicked", true);
		refershTableBtn.click();
		Thread.sleep(10000);
		String wfStatus = requestStatus.getText();
		Boolean flag = false;
		if (wfStatus.equals("New")) {
			Thread.sleep(10000);
			Reporter.log("Workflow status is:" + wfStatus, true);
			refershTableBtn.click();
			Assert.assertTrue(!flag);
		} else if (wfStatus.equals("ExecutionStarted")) {
			Reporter.log("Execution of workflow just started", true);
			Thread.sleep(10000);
			refershTableBtn.click();
			Thread.sleep(3000);
			reqStatus.click();
			Reporter.log("Workflow status is:" + wfStatus, true);
			Assert.assertTrue(!flag);
		} else if (wfStatus.equals("Complete")) {
			reqStatus.click();
			Reporter.log("Additional status details is clicked", true);
			String actual_message = execMessage.getText();
			Reporter.log("Message after execution of wf:" + actual_message, true);
			String expected_message = Messages.executionMessage;
			Reporter.log("Workflow status is:" + wfStatus, true);
			Assert.assertEquals(actual_message, expected_message, "Execution is not successful");
		} else if (wfStatus.equals("Failure")) {
			Reporter.log("Workflow status is:" + wfStatus, true);
			Assert.assertTrue(!flag);
		} else {
			Reporter.log("Workflow status is neither completed nor Failure, but other than that: " + wfStatus, true);
			Assert.assertTrue(flag);
		}
		//informationpageta.validateSignOut();
	}
	
	public void validateSubmitReqDefaultCategory(String WfName,String CategoryName) throws Exception{
		loginpageta.login(prop.getProperty("username_TU2"), prop.getProperty("password_TU2"));
		Reporter.log("User logged in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(catalogueTab));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",catalogueTab);
		Reporter.log("Catalogue Tab is clicked",true);
		Thread.sleep(2000);
		Select select_Category=new Select(categoryDropdown);
	    select_Category.selectByVisibleText(CategoryName);
	    System.out.println(CategoryName+" Category is been selected");
	    Thread.sleep(2000);		
	    WebElement wfNameToSendRequest=driver.findElement(By.xpath("//h6[text()='"+WfName+"']"));
		wfNameToSendRequest.click();
		Reporter.log("Workflow whose request needs to be send is selected",true);
		Thread.sleep(2000);
		submitRequestBtn.click();
		Reporter.log("Submit request button is clicked");
		Thread.sleep(2000);
		okBtn.click();
		Reporter.log("OK button is clicked");
		Thread.sleep(2000);
		Reporter.log("Request is submitted successfully",true);
		//informationpageta.validateSignOut();
		//validateRequestStatus();
		informationpageta.validateSignOut();
	}
	public void validateSubmitReqCustomCategory(String WfName,String CategoryName) throws Exception{
		
		validateSubmitReqDefaultCategory(WfName,CategoryName);
	}

}
