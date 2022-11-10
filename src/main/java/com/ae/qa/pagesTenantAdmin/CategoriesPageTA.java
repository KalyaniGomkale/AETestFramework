package com.ae.qa.pagesTenantAdmin;

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
import com.ae.qa.util.Messages;

public class CategoriesPageTA extends TestBase {
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
      
    public CategoriesPageTA()
    {
  	  PageFactory.initElements(driver, this);
    }

    public void ValidateCreateCategory(String CategoryName)throws Exception
    {
  	  loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		  Reporter.log("User LogIn Succesfully",true);
		  //wait.until(ExpectedConditions.visibilityOf(workflowTab));
		  Thread.sleep(5000);
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", workflowTab);
		  System.out.println("workflowTab clicked");
		  //wait.until(ExpectedConditions.visibilityOf(categories));
		  Thread.sleep(5000);
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
		  Thread.sleep(3000);
		  //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  String Actual_SuccessMsg=successMsgBox.getText();
		  String Expected_SuccessMsg=Messages.Categories;
		  Reporter.log("Actual Category created message is :"+Actual_SuccessMsg,true);
		  Reporter.log("Expected Category created message is :"+Expected_SuccessMsg,true);
		  Assert.assertEquals(Actual_SuccessMsg,Expected_SuccessMsg,"Categories creation failed");
		  Thread.sleep(10000);
		  Reporter.log("Category created succesfully",true);
		  Info.validateSignOut();	  
    }
    public void ValidateEditCategory(String CategoryName,String CategoryDescrip)throws Exception
    {
  	  loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		  Reporter.log("User LogIn Succesfully",true);
		  Thread.sleep(5000);
		  // wait.until(ExpectedConditions.visibilityOf(workflowTab));
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", workflowTab);
		  System.out.println("workflowTab clicked");
		  //wait.until(ExpectedConditions.visibilityOf(categories));
		  Thread.sleep(3000);
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
		  Thread.sleep(3000);
		  //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  String Actual_SuccessMsg=successMsgBox.getText();
		  String Expected_SuccessMsg=Messages.editCategories;
		  Reporter.log("Actual Category edited message is :"+Actual_SuccessMsg,true);
		  Reporter.log("Expected Category edited message is :"+Expected_SuccessMsg,true);
		  Assert.assertEquals(Actual_SuccessMsg,Expected_SuccessMsg,"Categories editing failed");
		  Thread.sleep(10000);
		  Reporter.log("Category edited succesfully",true);
		  Info.validateSignOut();	  
    }
    public void ValidateAssignWFToCategory(String WFName, String CategoryName)throws Exception
    {
  	  loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		  Reporter.log("User LogIn Succesfully",true);
		  //wait.until(ExpectedConditions.visibilityOf(workflowTab));
		  Thread.sleep(5000);
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", workflowTab);
		  System.out.println("workflowTab clicked");
		  //wait.until(ExpectedConditions.visibilityOf(categories));
		  Thread.sleep(3000);
		  js.executeScript("arguments[0].click();", categories);
		  Reporter.log("Categories tab clicked",true);
		  Thread.sleep(2000);
		  WebElement assignWF_checkbox=driver.findElement(By.xpath("//a/input/../span[@title='"+WFName+"']/../input[@type='checkbox']"));
		  assignWF_checkbox.click();
		  Reporter.log("Workflow which needs to move is checked",true);
		  Thread.sleep(2000);
		 Select drpWorkflow = new Select(moveWFDropdwn);
		 drpWorkflow.selectByVisibleText(CategoryName);
		 Reporter.log("category in which wf needs to move is selected from dropdown",true);
		 moveBtn.click();
		// driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 Thread.sleep(3000);
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
    public void ValidateRemoveWFFromCategory(String WFName, String CategoryName)throws Exception
    {
  	  loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		  Reporter.log("User LogIn Succesfully",true);
		  //wait.until(ExpectedConditions.visibilityOf(workflowTab));
		  Thread.sleep(5000);
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", workflowTab);
		  System.out.println("workflowTab clicked");
		  //wait.until(ExpectedConditions.visibilityOf(categories));
		  Thread.sleep(3000);
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
		 //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 Thread.sleep(3000);
		 String Actual_SuccessMsg=successMsgBox.getText();
		 String Expected_SuccessMsg=Messages.removeWFFromCategories;
		 Reporter.log("Actual message is :"+Actual_SuccessMsg,true);
		 Reporter.log("Expected message is :"+Expected_SuccessMsg,true);
		 Assert.assertEquals(Actual_SuccessMsg,Expected_SuccessMsg,"Workflow removal from category is failed");
		 Thread.sleep(10000);
		 Reporter.log("Workflow removed from category succesfully",true);
		 Info.validateSignOut();	  
    }
    public void ValidateCreateDuplicateCategory(String CategoryName)throws Exception
    {
  	  loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		  Reporter.log("User LogIn Succesfully",true);
		  //wait.until(ExpectedConditions.visibilityOf(workflowTab));
		  Thread.sleep(5000);
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", workflowTab);
		  System.out.println("workflowTab clicked");
		  //wait.until(ExpectedConditions.visibilityOf(categories));
		  Thread.sleep(3000);
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
		  Thread.sleep(3000);
		  //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  String Actual_SuccessMsg=successMsgBox.getText();
		  String Expected_SuccessMsg="Duplicate category name ["+CategoryName+"]";
	//	  String Expected_SuccessMsg=Messages.Categories;
		  Reporter.log("Actual message is :"+Actual_SuccessMsg,true);
		  Reporter.log("Expected message is :"+Expected_SuccessMsg,true);
		  Assert.assertEquals(Actual_SuccessMsg,Expected_SuccessMsg,"Category with duplicate name created.");
		  Thread.sleep(10000);
		  Reporter.log("Category can't be created with duplicate name",true);
		  Info.validateSignOut();	  
    }
    
	  public void ValidateDeleteCategory(String CatName)throws Exception
	  {
		  loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		  Reporter.log("User LogIn Succesfully",true);
		  //wait.until(ExpectedConditions.visibilityOf(workflowTab));		  
		  Thread.sleep(5000);
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("arguments[0].click();", workflowTab);
		  System.out.println("workflowTab clicked");		  
		  //wait.until(ExpectedConditions.visibilityOf(categories));
		  Thread.sleep(3000);
		  JavascriptExecutor js1=(JavascriptExecutor)driver;
		  js1.executeScript("arguments[0].click();", categories);
		  Reporter.log("Category  tab clicked",true);
		  Thread.sleep(3000);
		  WebElement deleteCat=driver.findElement(By.xpath("//div/label[text()='"+CatName+"']/../div/span[@title='Delete Category']"));
		 // deleteCat.click();
		  js.executeScript("arguments[0].click();",deleteCat);
		  Thread.sleep(3000);
		  cnfrm.click();
		  //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  Thread.sleep(3000);
		  String Actual_testMsg=successMsgBox.getText();
		  String Expected_testMsg=Messages.deleteCategory;
		  Reporter.log("Actual Category deleted message is :"+Actual_testMsg,true);
		  Reporter.log("Expected Category deleted message is :"+Expected_testMsg,true);
		  Assert.assertEquals(Actual_testMsg,Expected_testMsg,"Categories deletion fail");
		  Thread.sleep(10000);
		  Reporter.log("Category Deleted succesfully",true);
		  Info.validateSignOut();
	  }
		public void validateCategoriesPageTA(String PageTitle) throws Exception {
			loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
			Reporter.log("User log in Successfully",true);
			//First search for tab and click on it
			//wait.until(ExpectedConditions.visibilityOf(workflowTab));
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", workflowTab);
			js.executeScript("arguments[0].click();", categories);
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
