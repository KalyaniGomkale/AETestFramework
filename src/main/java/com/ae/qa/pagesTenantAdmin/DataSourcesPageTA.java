package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.openqa.selenium.support.ui.Select;
import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;
//import com.codoid.products.fillo.Select;

public class DataSourcesPageTA extends TestBase {
	public LoginPageTA loginpageta = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 300);
	public InformationPageTA Info = new InformationPageTA();
	@FindBy(xpath = "//span[text()='Reports']")
	WebElement reportsTab;
	@FindBy(xpath = "//a[text()='Datasource']")
	WebElement datasourcesTab;
	@FindBy(name = "datasource-form")
	WebElement addBtn;
	@FindBy(id ="databaseType")
	WebElement database_drpdown;
	@FindBy(xpath = "//*[@id='name']")
	WebElement datasourceName;
	@FindBy(xpath = "//*[@id='connectionString']")
	WebElement ConnectionString;
	@FindBy(xpath = "//*[@id='username']")
	WebElement username;
	@FindBy(xpath = "//*[@id='password']")
	WebElement Password;
	@FindBy(xpath = "//button[text()='Test']")
	WebElement button;
	@FindBy(xpath = "//button[@class='btn btn-primary' and @name='submit']/span")
	WebElement Create;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement successMsgBox;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public DataSourcesPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateCreateDataSourcePostgres(String dbType, String datasourcename, String connectionString, 
			String userName, String password)
			throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully", true);
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", reportsTab);
		Reporter.log("Report tab clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(datasourcesTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", datasourcesTab);
		Reporter.log("DataSource  tab clicked", true);
		Thread.sleep(4000);
		addBtn.click();
		Thread.sleep(3000);
		Reporter.log("Data-Source Form opened",true);
		Select database_Type=new Select(database_drpdown);
		database_Type.selectByVisibleText(dbType);
		Thread.sleep(3000);
		datasourceName.sendKeys(datasourcename);
		Thread.sleep(3000);
		ConnectionString.sendKeys(connectionString);
		Thread.sleep(3000);
		username.sendKeys(userName);
		Thread.sleep(3000);
		Password.sendKeys(password);
		Thread.sleep(3000);
		button.click();
		Reporter.log("Button Clicked",true);
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Actual_testMsg = successMsgBox.getText();
		String Expected_testMsg = Messages.tstdataSource1;
		System.out.println("Actual datsource-Test message is :" + Actual_testMsg);
		System.out.println("Expected datasource-test message is :" + Expected_testMsg);
		Assert.assertEquals(Actual_testMsg, Expected_testMsg, "Test Connection failed");
		Thread.sleep(10000);
		Create.click();
		Thread.sleep(2000);
		Reporter.log("Create button is clicked.", true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String Actual_CreateMsg = successMsgBox.getText();
		String Expected_CreateMsg = Messages.tstdataSource;
		System.out.println("Actual created message is :" + Actual_CreateMsg);
		System.out.println("Expected Created message is :"+ Expected_CreateMsg);
		Assert.assertEquals(Actual_CreateMsg, Expected_CreateMsg, "Datasource configuration failed");
		Reporter.log("Datsource created succesfully", true);
		Info.validateSignOut();
	}
	public void validateDatasourcesPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(reportsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", reportsTab);
		js.executeScript("arguments[0].click();", datasourcesTab);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);	
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
						+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		Info.validateSignOut();
	}
}
