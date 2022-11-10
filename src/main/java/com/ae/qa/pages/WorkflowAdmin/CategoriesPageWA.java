package com.ae.qa.pages.WorkflowAdmin;

import java.util.concurrent.TimeUnit;

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
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.Messages;

public class CategoriesPageWA extends TestBase{
	public LoginPageTA loginpage = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 300);
	public InformationPageTA Info = new InformationPageTA();

	@FindBy(xpath="//span[text()='Workflows']")
	WebElement workflowTab;
	@FindBy(xpath="//a[text()='Categories']")
	WebElement categories;
	@FindBy(xpath="//button[text()=' Add New']")
	WebElement Add;
	@FindBy(id="categoryName")
	WebElement categoryName;
	@FindBy(id="categoryDescription")
	WebElement catDescp;
	@FindBy(id="new-cat-btn")
	WebElement CreateBtn;
	@FindBy(xpath="//*[@id='176']/div/span[3]")
	WebElement deleteButton;
	@FindBy(xpath="//*[@id='popup-button-ok']")
	WebElement cnfrm;
	@FindBy(xpath="//div/p[@class='alert-message-text']")
	WebElement successMsgBox;
	@FindBy(xpath="//div[@class='move-workflows']/select")
	WebElement moveWFDropdwn;
	@FindBy(xpath="//button[@name='move' and @class='btn btn-primary']")
	WebElement moveBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;

	public CategoriesPageWA()
	{
		PageFactory.initElements(driver, this);
	}

	public void ValidateCreateCategoryWA(String CategoryName)throws Exception
	{
		loginpage.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(categories));
		js.executeScript("arguments[0].click();", categories);
		Reporter.log("Categories tab clicked",true);
		Thread.sleep(4000);
		Add.click();
		Thread.sleep(2000);
		categoryName.sendKeys(CategoryName);
		Thread.sleep(1000);
		Reporter.log("Category name is entered which is only mandatory field",true);
		Thread.sleep(2000);
		CreateBtn.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String Actual_SuccessMsg=successMsgBox.getText();
		String Expected_SuccessMsg=Messages.Categories;
		Reporter.log("Actual Category created message is :"+Actual_SuccessMsg,true);
		Reporter.log("Expected Category created message is :"+Expected_SuccessMsg,true);
		Assert.assertEquals(Actual_SuccessMsg,Expected_SuccessMsg,"Categories creation failed");
		Thread.sleep(10000);
		Reporter.log("Category created succesfully",true);
		Info.validateSignOut();	  
	}
	public void ValidateEditCategoryWA(String CategoryName,String CategoryDescrip)throws Exception
	{
		loginpage.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(categories));
		js.executeScript("arguments[0].click();", categories);
		Reporter.log("Categories tab clicked",true);
		Thread.sleep(4000);
		WebElement editBtn=driver.findElement(By.xpath("//label[text()='"+CategoryName+"']/../div/span[@title='Edit Category']"));
		editBtn.click();
		Reporter.log("Edit Button corresponding to required category is clicked",true);
		Thread.sleep(2000);
		for(int i=0;i<50;i++) {
			catDescp.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(3000);
		catDescp.sendKeys(CategoryDescrip);
		Thread.sleep(1000);
		Reporter.log("Category Description is entered",true);
		Thread.sleep(2000);
		CreateBtn.click();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String Actual_SuccessMsg=successMsgBox.getText();
		String Expected_SuccessMsg=Messages.editCategories;
		Reporter.log("Actual Category edited message is :"+Actual_SuccessMsg,true);
		Reporter.log("Expected Category edited message is :"+Expected_SuccessMsg,true);
		Assert.assertEquals(Actual_SuccessMsg,Expected_SuccessMsg,"Categories editing failed");
		Thread.sleep(10000);
		Reporter.log("Category edited succesfully",true);
		Info.validateSignOut();	  
	}
	public void ValidateAssignWFToCategoryWA(String WFName, String CategoryName)throws Exception
	{
		loginpage.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(categories));
		js.executeScript("arguments[0].click();", categories);
		Reporter.log("Categories tab clicked",true);
		Thread.sleep(4000);
		WebElement assignWF_checkbox=driver.findElement(By.xpath("(//a/span[@title='"+WFName+"']/../../input[@type='checkbox'])[1]"));
		js.executeScript("arguments[0].click();", assignWF_checkbox);
		Reporter.log("Workflow which needs to move is checked",true);
		Thread.sleep(2000);
		Select drpWorkflow = new Select(moveWFDropdwn);
		drpWorkflow.selectByVisibleText(CategoryName);
		Reporter.log("category in which wf needs to move is selected from dropdown",true);
		moveBtn.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String Actual_SuccessMsg=successMsgBox.getText();
		String Expected_SuccessMsg=Messages.assignWFToCategories;
		Reporter.log("Actual message is :"+Actual_SuccessMsg,true);
		Reporter.log("Expected message is :"+Expected_SuccessMsg,true);
		Assert.assertEquals(Actual_SuccessMsg,Expected_SuccessMsg,"Workflow assignment to category failed");
		Thread.sleep(10000);
		Reporter.log("Workflow assigned to category succesfully",true);
		Info.validateSignOut();	  
	}
	//
	public void ValidateRemoveWFFromCategoryWA(String WFName, String CategoryName)throws Exception
	{
		loginpage.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(workflowTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", workflowTab);
		System.out.println("workflowTab clicked");
		wait.until(ExpectedConditions.visibilityOf(categories));
		js.executeScript("arguments[0].click();", categories);
		Reporter.log("Categories tab clicked",true);
		Thread.sleep(4000);
		WebElement select_catName=driver.findElement(By.xpath("//div/label[text()='"+CategoryName+"']"));
		select_catName.click();
		Reporter.log("Category from which wf needs to remove is selected",true);
		Thread.sleep(2000);
		WebElement select_WFName=driver.findElement(By.xpath("//a/span[@title='"+WFName+"']/../../div/span[@title='Remove workflow']"));
		select_WFName.click();
		Reporter.log("Workflow assigned to category is removed",true);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String Actual_SuccessMsg=successMsgBox.getText();
		String Expected_SuccessMsg=Messages.removeWFFromCategories;
		Reporter.log("Actual message is :"+Actual_SuccessMsg,true);
		Reporter.log("Expected message is :"+Expected_SuccessMsg,true);
		Assert.assertEquals(Actual_SuccessMsg,Expected_SuccessMsg,"Workflow removal from category is failed");
		Thread.sleep(10000);
		Reporter.log("Workflow removed from category succesfully",true);
		Info.validateSignOut();	  
	}

}



