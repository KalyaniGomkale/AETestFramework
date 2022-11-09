package com.ae.qa.pages.UserAdmin;

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
import com.ae.qa.util.Messages;


public class CategoriesPageUA extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
    public InformationPageTA informationpageta = new InformationPageTA();
    
    @FindBy(xpath="//span[text()='Workflows']")
	WebElement workflowTab;
    @FindBy(xpath="//div/ul/li/a[text()='Permissions']")
   	WebElement permissionsTab;
    @FindBy(id="selectType")
	WebElement selectTypeDropdown;
    @FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement memberTypeDropdown;
	@FindBy(xpath="//input[@name='search']")
	WebElement searchBar;
	@FindBy(xpath="//span[@class='mul-checkmark']")
	WebElement inputCheckbox;
	@FindBy(xpath="//button[@name='save']")
	WebElement saveBtn1;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement alert_msg;

	public CategoriesPageUA() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateReadPermissionUser(String CategoryName,String TypeName,String MemberName) throws Exception{
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab clicked",true);
		Thread.sleep(4000);
		WebElement assignPerBtn=driver.findElement(By.xpath("//label[text()='"+CategoryName+"']/../div/span[@title='Assign Permissions']"));
		assignPerBtn.click();
		Thread.sleep(3000);		
		Reporter.log("Assign Permission button corresponding to required category is clicked",true);
		Select typeDropdown = new Select(selectTypeDropdown);
		typeDropdown.selectByVisibleText(TypeName);
		Thread.sleep(3000);
		Reporter.log("Users Type is selected successfully",true);
		memberTypeDropdown.click();
		Thread.sleep(3000);
		searchBar.sendKeys(MemberName);
		Thread.sleep(3000);
		inputCheckbox.click();
		Thread.sleep(3000);
		Reporter.log("Member name is selected successfully",true);
		Thread.sleep(2000);
		WebElement readPermission = driver.findElement(By.xpath("(//table/tr/td[text()='"+MemberName+"']/../td/input)[1]"));
		js.executeScript("arguments[0].click();", readPermission);
		if(readPermission.isSelected()) {
			Assert.assertTrue(readPermission.isSelected());
			Reporter.log("Read permission is selected successfully",true);
		}else{
			Assert.assertTrue(readPermission.isSelected());
			Reporter.log("Read permission is not selected successfully",true);
		}
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", saveBtn1);
		Reporter.log("Save Button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab is clicked",true);
		String actual_Msg=alert_msg.getText();
		System.out.println("Actual Message:-"+actual_Msg);
		String expected_Msg=Messages.categorySuccessMsg;
		System.out.println("Expected Message:-"+expected_Msg);
		Assert.assertEquals(actual_Msg, expected_Msg, "Read Permission not assigned successfully");
		Reporter.log("Read Permission is assigned successfully to the category",true);
		informationpageta.validateSignOut();
	}
	public void validateWritePermissionUser(String CategoryName,String TypeName,String MemberName) throws Exception{
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab clicked",true);
		Thread.sleep(4000);
		WebElement assignPerBtn=driver.findElement(By.xpath("//label[text()='"+CategoryName+"']/../div/span[@title='Assign Permissions']"));
		assignPerBtn.click();
		Thread.sleep(3000);		
		Reporter.log("Assign Permission button corresponding to required category is clicked",true);
		Select typeDropdown = new Select(selectTypeDropdown);
		typeDropdown.selectByVisibleText(TypeName);
		Thread.sleep(3000);
		Reporter.log("Users Type is selected successfully",true);
		memberTypeDropdown.click();
		Thread.sleep(3000);
		searchBar.sendKeys(MemberName);
		Thread.sleep(3000);
		inputCheckbox.click();
		Thread.sleep(3000);
		Reporter.log("Member name is selected successfully",true);
		Thread.sleep(2000);
		WebElement writePermission = driver.findElement(By.xpath("(//table/tr/td[text()='"+MemberName+"']/../td/input)[3]"));
		js.executeScript("arguments[0].click();", writePermission);
		Reporter.log("Write permission checkbox is selected successfully",true);
		if(writePermission.isSelected()) {
			Assert.assertTrue(writePermission.isSelected());
			Reporter.log("Write permission is selected successfully",true);
		}else{
			Assert.assertTrue(writePermission.isSelected());
			Reporter.log("Write permission is not selected successfully",true);
		}
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", saveBtn1);
		Reporter.log("Save Button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab is clicked",true);
		String actual_Msg=alert_msg.getText();
		System.out.println("Actual Message:-"+actual_Msg);
		String expected_Msg=Messages.categorySuccessMsg;
		System.out.println("Expected Message:-"+expected_Msg);
		Assert.assertEquals(actual_Msg, expected_Msg, "Write Permission not assigned successfully");
		Reporter.log("Write Permission is assigned successfully to the category",true);
		informationpageta.validateSignOut();
	}
	public void validateExecutePermissionUser(String CategoryName,String TypeName,String MemberName) throws Exception{
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab clicked",true);
		Thread.sleep(4000);
		WebElement assignPerBtn=driver.findElement(By.xpath("//label[text()='"+CategoryName+"']/../div/span[@title='Assign Permissions']"));
		assignPerBtn.click();
		Thread.sleep(3000);		
		Reporter.log("Assign Permission button corresponding to required category is clicked",true);
		Select typeDropdown = new Select(selectTypeDropdown);
		typeDropdown.selectByVisibleText(TypeName);
		Thread.sleep(3000);
		Reporter.log("Users Type is selected successfully",true);
		memberTypeDropdown.click();
		Thread.sleep(3000);
		searchBar.sendKeys(MemberName);
		Thread.sleep(3000);
		inputCheckbox.click();
		Thread.sleep(3000);
		Reporter.log("Member name is selected successfully",true);
		Thread.sleep(2000);
		WebElement executePermission = driver.findElement(By.xpath("(//table/tr/td[text()='"+MemberName+"']/../td/input)[2]"));
		js.executeScript("arguments[0].click();", executePermission);
		Reporter.log("Execute permission checkbox is selected successfully",true);
		if(executePermission.isSelected()) {
			Assert.assertTrue(executePermission.isSelected());
			Reporter.log("Execute permission is selected successfully",true);
		}else{
			Assert.assertTrue(executePermission.isSelected());
			Reporter.log("Execute permission is not selected successfully",true);
		}
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", saveBtn1);
		Reporter.log("Save Button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab is clicked",true);
		String actual_Msg=alert_msg.getText();
		System.out.println("Actual Message:-"+actual_Msg);
		String expected_Msg=Messages.categorySuccessMsg;
		System.out.println("Expected Message:-"+expected_Msg);
		Assert.assertEquals(actual_Msg, expected_Msg, "Execute Permission not assigned successfully");
		Reporter.log("Execute Permission is assigned successfully to the category",true);
		informationpageta.validateSignOut();
	}
	public void validateExecutePermissionGroup(String CategoryName,String TypeName,String GroupName) throws Exception{
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab clicked",true);
		Thread.sleep(4000);
		WebElement assignPerBtn=driver.findElement(By.xpath("//label[text()='"+CategoryName+"']/../div/span[@title='Assign Permissions']"));
		assignPerBtn.click();
		Thread.sleep(3000);		
		Reporter.log("Assign Permission button corresponding to required category of group is clicked",true);
		Select typeDropdown = new Select(selectTypeDropdown);
		typeDropdown.selectByVisibleText(TypeName);
		Thread.sleep(3000);
		Reporter.log("Groups Type is selected successfully",true);
		memberTypeDropdown.click();
		Thread.sleep(3000);
		searchBar.sendKeys(GroupName);
		Thread.sleep(3000);
		inputCheckbox.click();
		Thread.sleep(3000);
		Reporter.log("Group name is selected successfully",true);
		Thread.sleep(2000);
		WebElement executePermission = driver.findElement(By.xpath("(//table/tr/td[text()='"+GroupName+"']/../td/input)[2]"));
		js.executeScript("arguments[0].click();", executePermission);
		Reporter.log("Execute permission checkbox is selected successfully",true);
		if(executePermission.isSelected()) {
			Assert.assertTrue(executePermission.isSelected());
			Reporter.log("Execute permission is selected successfully",true);
		}else{
			Assert.assertTrue(executePermission.isSelected());
			Reporter.log("Execute permission is not selected successfully",true);
		}
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", saveBtn1);
		Reporter.log("Save Button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab is clicked",true);
		String actual_Msg=alert_msg.getText();
		System.out.println("Actual Message:-"+actual_Msg);
		String expected_Msg=Messages.categorySuccessMsg;
		System.out.println("Expected Message:-"+expected_Msg);
		Assert.assertEquals(actual_Msg, expected_Msg, "Execute Permission not assigned successfully");
		Reporter.log("Execute Permission is assigned successfully to the category of group",true);
		informationpageta.validateSignOut();
	}
	public void validateEditPermissionToWrite(String CategoryName,String TypeName,String MemberName) throws Exception{
		validateExecutePermissionUser(CategoryName, TypeName, MemberName);
		loginpageta.login(prop.getProperty("username_UA"), prop.getProperty("password_UA"));
		Reporter.log("User log in Successfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab clicked",true);
		Thread.sleep(4000);
		WebElement assignPerBtn=driver.findElement(By.xpath("//label[text()='"+CategoryName+"']/../div/span[@title='Assign Permissions']"));
		assignPerBtn.click();
		Thread.sleep(3000);		
		Reporter.log("Assign Permission button corresponding to required category is clicked",true);
		Select typeDropdown = new Select(selectTypeDropdown);
		typeDropdown.selectByVisibleText(TypeName);
		Thread.sleep(3000);
		Reporter.log("Users Type is selected successfully",true);
		memberTypeDropdown.click();
		Thread.sleep(3000);
		searchBar.sendKeys(MemberName);
		Thread.sleep(3000);
		inputCheckbox.click();
		Thread.sleep(3000);
		Reporter.log("Member name is selected successfully",true);
		Thread.sleep(2000);
		WebElement executePermission = driver.findElement(By.xpath("(//table/tr/td[text()='"+MemberName+"']/../td/input)[2]"));
		js.executeScript("arguments[0].click();", executePermission);
		Reporter.log("Execute permission is unassigned successfully",true);
		Thread.sleep(2000);
		WebElement writePermission = driver.findElement(By.xpath("(//table/tr/td[text()='"+MemberName+"']/../td/input)[3]"));
		js.executeScript("arguments[0].click();", writePermission);
		Reporter.log("Execute to Write permission is edited successfully",true);
		if(writePermission.isSelected()) {
			Assert.assertTrue(writePermission.isSelected());
			Reporter.log("Write permission is selected successfully",true);
		}else{
			Assert.assertTrue(writePermission.isSelected());
			Reporter.log("Write permission is not selected successfully",true);
		}
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", saveBtn1);
		Reporter.log("Save Button is clicked",true);
		wait.until(ExpectedConditions.visibilityOf(permissionsTab));
		js.executeScript("arguments[0].click();", permissionsTab);
		Reporter.log("Permissions tab is clicked",true);
		String actual_Msg=alert_msg.getText();
		System.out.println("Actual Message:-"+actual_Msg);
		String expected_Msg=Messages.categorySuccessMsg;
		System.out.println("Expected Message:-"+expected_Msg);
		Assert.assertEquals(actual_Msg, expected_Msg, "Execute to Write Permission not assigned successfully");
		Reporter.log("Execute to Write Permission is assigned successfully to the category",true);
		informationpageta.validateSignOut();
	}
}
