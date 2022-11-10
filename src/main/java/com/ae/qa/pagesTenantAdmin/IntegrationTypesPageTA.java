package com.ae.qa.pagesTenantAdmin;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
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
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.ExcelHandler;

public class IntegrationTypesPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 100);
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();

	@FindBy(xpath = "//span[(text()='Integration')]")
	WebElement integrationTab;
	@FindBy(xpath = "//a[text()='Types']")
	WebElement typesTab;
	@FindBy(xpath="//button[@name='new-req']")
	WebElement addNewBtn;
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description;
	@FindBy(xpath="(//input[@type='file'])[2]")
	WebElement selectJar ;
	@FindBy(xpath="//button[@id='submitBtn']")
	WebElement submitBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	
	public IntegrationTypesPageTA() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateAddIntegrationTypesTA(String typeName,String typeDescp) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		// click IntegrationTab Tab
		//wait.until(ExpectedConditions.visibilityOf(integrationTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", integrationTab);
		// click on Types Tab
		js.executeScript("arguments[0].click();",typesTab);
		//wait.until(ExpectedConditions.visibilityOf(addNewBtn));
		Thread.sleep(3000);
		addNewBtn.click();
		Thread.sleep(3000);
		name.sendKeys(typeName);
		Thread.sleep(3000);
		description.sendKeys(typeDescp);
		Thread.sleep(3000);
		selectJar.sendKeys(prop.getProperty("integrationTypeJar"));
		Thread.sleep(3000);
		submitBtn.click();
		Reporter.log("Submit Button is clicked",true);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String actual_Msg=alertMessage.getText();
		String expected_Msg="Integration type ["+typeName+"] created successfully";
		Assert.assertEquals(actual_Msg,expected_Msg,"Integration type not created.");
		Reporter.log("Integration type created successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateEditIntegrationTypesTA(String typeName,String typeDescpUpdated) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		// click IntegrationTab Tab
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(integrationTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", integrationTab);
		// click on Types Tab
		js.executeScript("arguments[0].click();",typesTab);
		WebElement editBtn=driver.findElement(By.xpath("//div/table/tr/td/a[text()='"+typeName+"']/../../td/span[@class='fa fa-edit']"));
		editBtn.click();
		Thread.sleep(3000);
		Reporter.log("Edit button is clicked",true);
		description.clear();
		Thread.sleep(3000);
		description.sendKeys(typeDescpUpdated);
		Thread.sleep(3000);
		selectJar.sendKeys(prop.getProperty("integrationTypeJar"));
		Thread.sleep(3000);
		submitBtn.click();
		Reporter.log("Submit Button is clicked",true);
		String typename_lowerCase=typeName.toLowerCase();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String actual_Msg=alertMessage.getText();
		String expected_Msg="Integration type jar for ["+typename_lowerCase+"] updated successfully";
		Assert.assertEquals(actual_Msg,expected_Msg,"Integration type not updated.");
		Reporter.log("Integration type updated successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateIntegrationTypesPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(integrationTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",integrationTab);
		js.executeScript("arguments[0].click();",typesTab);
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
