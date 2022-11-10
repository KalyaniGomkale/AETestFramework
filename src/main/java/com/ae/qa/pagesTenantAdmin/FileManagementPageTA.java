package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class FileManagementPageTA extends TestBase{
	public LoginPageTA loginpage = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 300);
	public InformationPageTA informationpageta=new InformationPageTA();

	@FindBy(xpath="//span[text()='File Management']")
	WebElement fileManagementTab;
	@FindBy(xpath = "//button[@name='new-req']")
	WebElement uploadBtn;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']")
	WebElement wfDropdown;
	@FindBy(xpath = "//input[@formcontrolname='search']")
	WebElement searchBar;
	@FindBy(xpath = "//span[@class='mul-checkmark']")
	WebElement wfCheckbox;
	@FindBy(xpath = "//input[@formcontrolname='file']")
	WebElement chooseFile;
	@FindBy(xpath = "//span[text()='Submit']")
	WebElement submitBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement success_Message;
	@FindBy(id="popup-button-ok")
	WebElement confirmDeleteBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public FileManagementPageTA()
	{
		PageFactory.initElements(driver, this);
	}

	public void validateFileManagementPageTA(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(fileManagementTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",fileManagementTab);
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
	public void validateUploadWorkflowFiles(String wfName) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		// click File Management Tab
		//wait.until(ExpectedConditions.visibilityOf(fileManagementTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",fileManagementTab);
		Thread.sleep(3000);
		uploadBtn.click();
		Reporter.log("Upload Button is clicked",true);
		wfDropdown.click();
		Thread.sleep(3000);
		searchBar.sendKeys(wfName);
		Thread.sleep(3000);
		wfCheckbox.click();
		Reporter.log("Workflow Name is selected",true);
		Thread.sleep(3000);
		chooseFile.sendKeys(prop.getProperty("WFWithConfigParam"));
		Thread.sleep(3000);
		submitBtn.click();
		Reporter.log("Submit button is clicked",true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String Actual_successMsg = success_Message.getText();
		System.out.println("Actual Sucess Message" + Actual_successMsg);
		String Expected_successMsg = Messages.fileUpload;
		System.out.println("Expected Sucess Message" + Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow not uploaded");
		Reporter.log("Workflow is uploaded successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateEditWorkflowFiles(String fileName) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		// click File Management Tab
		//wait.until(ExpectedConditions.visibilityOf(fileManagementTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",fileManagementTab);
		Reporter.log("File Management tab is clicked successfully",true);
		Thread.sleep(3000);
		WebElement editBtn = driver.findElement(By.xpath("//table/tr/td[text()='"+fileName+"']/../td/span"));
		js.executeScript("arguments[0].click();",editBtn);
		Reporter.log("Edit button is clicked successfully",true);
		Thread.sleep(3000);
		chooseFile.sendKeys(prop.getProperty("WFWithConfigParam"));
		Thread.sleep(3000);
		submitBtn.click();
		Reporter.log("Submit button is clicked",true);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String Actual_successMsg = success_Message.getText();
		System.out.println("Actual Sucess Message" + Actual_successMsg);
		String Expected_successMsg = Messages.fileUpload;
		System.out.println("Expected Sucess Message" + Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow file is not edited successfully");
		Reporter.log("Workflow file is edited successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateDeleteUploadWorkflowFiles(String fileName) throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		// click File Management Tab
		//wait.until(ExpectedConditions.visibilityOf(fileManagementTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",fileManagementTab);
		Reporter.log("File Management tab is clicked successfully",true);
		Thread.sleep(3000);
		WebElement deleteBtn = driver.findElement(By.xpath("//table/tr/td[text()='"+fileName+"']/../td/span/../i"));
		js.executeScript("arguments[0].click();",deleteBtn);
		Reporter.log("Delete button is clicked successfully",true);
		Thread.sleep(3000);
		confirmDeleteBtn.click();
		Thread.sleep(2000);
		String Actual_successMsg = success_Message.getText();
		System.out.println("Actual Sucess Message" + Actual_successMsg);
		String Expected_successMsg = "Successfully deleted file: ["+fileName+"]";
		System.out.println("Expected Sucess Message" + Expected_successMsg);
		Assert.assertEquals(Actual_successMsg, Expected_successMsg, "Workflow file not deleted successfully");
		Reporter.log("Workflow file is deleted successfully",true);
		informationpageta.validateSignOut();
	}

}