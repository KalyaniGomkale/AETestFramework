package com.ae.qa.pagesTenantAdmin;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
import com.ae.qa.util.Messages;

public class IntegrationTypeConfigPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver,60);
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();

	@FindBy(xpath = "//span[(text()='Integration')]")
	WebElement integrationTab;
	@FindBy(xpath = "//a[text()='Type Configurations']")
	WebElement typeConfigurationsTab;
	@FindBy(xpath="//button[@name='add-btn']")
	WebElement addBtn;
	@FindBy(xpath="//input[@name='name']")
	WebElement Name;
	@FindBy(xpath="//textarea[@id='description']")
	WebElement Description;
	@FindBy(id="intgTypeId")
	WebElement Types ;
	@FindBy(id="intgServiceRegistrationId")
	WebElement Service;
	@FindBy(id="updateResponseViaService")
	WebElement updateResponse;
	@FindBy(xpath="(//*[@class='text-primary hand-cursor'])[1]")
	WebElement pollingCursor;
	@FindBy(xpath="(//*[@class='text-primary hand-cursor'])[2]")
	WebElement configParamCursor;
	@FindBy(id="timeZone")
	WebElement timeZone;
	@FindBy(id="startDate-datepicker")
	WebElement startDate;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement monthDrpdown;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement yearDrpdown;
	@FindBy(id="endDate-datepicker")
	WebElement endDate;
	@FindBy(id="interval")
	WebElement RepeatAfter;
	@FindBy(id="intervalUnit")
	WebElement repeatIntervalUnit;
	@FindBy(id="startTime-hours")
	WebElement startHR;
	@FindBy(id="startTime-minutes")
	WebElement startMin;
	@FindBy(id="endTime-hours")
	WebElement endHR;
	@FindBy(id="endTime-minutes")
	WebElement endMin;
	@FindBy(id="prop-edit-div")
	WebElement addParam;
	@FindBy(xpath="//select[@id='1-type']")
	WebElement typedropdown;
	@FindBy(id="1-paramName")
	WebElement paramName;
	@FindBy(id="1-value")
	WebElement paramValue;
	@FindBy(xpath="//button[@name='test-smtp']")
	WebElement testBtn;
	@FindBy(name="submit")
	WebElement submitBtn;
	@FindBy(xpath = "//p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	
	public IntegrationTypeConfigPageTA() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateTypeConfBothTA(String configName,String configDescp,String typeName,String serviceName,
			String timezone,String startdate,String startMonth,String startYear,String enddate,String endMonth,
			String endYear,String repeatAfter,String repeatInterval,
			String startHour,String startMinutes,String endHour, String endMinutes,String configParamType,
			String configParamName,String configParamValue) throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		// click IntegrationTab Tab
		//wait.until(ExpectedConditions.visibilityOf(integrationTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", integrationTab);
		// click on services Tab
		js.executeScript("arguments[0].click();",typeConfigurationsTab);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addBtn.click();
		Thread.sleep(3000);
		Name.sendKeys(configName);
		Thread.sleep(3000);
		Description.sendKeys(configDescp);
		Thread.sleep(3000);
		Select types_dropdown=new Select(Types);
		types_dropdown.selectByVisibleText(typeName);
		Reporter.log("Type selected from dropdown",true);
		Thread.sleep(3000);
		Select service_dropdown=new Select(Service);
		service_dropdown.selectByVisibleText(serviceName);
		Reporter.log("Service selected from dropdown",true);
		if(!updateResponse.isSelected()) {
		updateResponse.click();	
		Reporter.log("Update response via service checkbox is not already selcted, so selecting now",true);
		}else {
			Reporter.log("Update response via service checkbox is already selected",true);
		}
		extentTest.createNode("Polling schedule started").info("Started scheduling");
		pollingCursor.click();
		Select time_dropdown=new Select(timeZone);
		time_dropdown.selectByVisibleText(timezone);
		Reporter.log("Timezone selected",true);
		startDate.click();
		Thread.sleep(2000);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startdate+"']"));
		start_day_picker.click();
		//Thread.sleep(5000);
		//doneBtn.click();
		Thread.sleep(10000);
		endDate.click();
		Thread.sleep(2000);
		Select end_month_picker=new Select(monthDrpdown);
		end_month_picker.selectByVisibleText(endMonth);
		Select end_year_picker=new Select(yearDrpdown);
		end_year_picker.selectByVisibleText(endYear);
		Thread.sleep(2000);
		WebElement end_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+enddate+"']"));
		end_day_picker.click();
		Thread.sleep(5000);
		RepeatAfter.sendKeys(repeatAfter);
		Thread.sleep(1000);
		Select repeatPeriod_dropdown=new Select(repeatIntervalUnit);
		repeatPeriod_dropdown.selectByVisibleText(repeatInterval);
		startHR.sendKeys(startHour);
		startMin.sendKeys(startMinutes);
		endHR.sendKeys(endHour);
		endMin.sendKeys(endMinutes);
		Reporter.log("Polling schedule is set",true);
		extentTest.createNode("Polling schedule done").info("Done");
		extentTest.createNode("To set config param").info("Started setting config param");
		configParamCursor.click();
		addParam.click();
		Thread.sleep(3000);
		Select type_dropdown=new Select(typedropdown);
		type_dropdown.selectByVisibleText(configParamType);
		Thread.sleep(2000);
		paramName.sendKeys(configParamName);
		Thread.sleep(2000);
		paramValue.sendKeys(configParamValue);
		Thread.sleep(2000);
		testBtn.click();
		Reporter.log("Test button is clicked",true);
		Thread.sleep(2000);
		submitBtn.click();
		Reporter.log("Submit button is clicked",true);
		extentTest.createNode("config param set").info("Done");
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  String Actual_Msg=alertMessage.getText();
		  String Expected_Msg="Integration configuration ["+configName+"] created";
		  Reporter.log("Actual message is :"+Actual_Msg,true);
		  Reporter.log("Expected message is :"+Expected_Msg,true);
		  Assert.assertEquals(Actual_Msg,Expected_Msg,"Integration Type configuration fail");
		  Reporter.log("Integration configuration created successfully",true);
	}
	public void validateIntegrationTypeConfigurationsTabPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(integrationTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",integrationTab);
		js.executeScript("arguments[0].click();",typeConfigurationsTab);
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
