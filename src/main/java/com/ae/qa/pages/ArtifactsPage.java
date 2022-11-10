package com.ae.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.Messages;

public class ArtifactsPage extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver,100);
	public WebElements webelements = new WebElements();
	public LoginPage loginpage = new LoginPage();
	public InformationPage informationpage=new InformationPage();
	
	  @FindBy(xpath="//span[text()='Artifacts']")
	  WebElement ArtifactsTab;
	  @FindBy(xpath="//span[text()='Logs']")
	  WebElement LogsTab;
	  @FindBy(name="upload")
	  WebElement uploadBtn;
////button[@name='upload']
	 @FindBy(id="name")
	 WebElement artifactName;
	 @FindBy(id="version")
	 WebElement version;
	 @FindBy(xpath="//input[@id='fileName-input']")
	 WebElement artifactFile;
	 @FindBy(xpath="//button[@name='assign']")
	 WebElement uploadSubmitBtn;
	 @FindBy(xpath = "//p[@class='alert-message-text']")
	 WebElement alertMessage;
	 @FindBy(xpath="//table/tr/td[text()='Process Studio']/../td/span[1]")
	 WebElement editBtn;
	 @FindBy(xpath="//table/tr[2]/td[3]")
	 WebElement entity;
	 @FindBy(xpath="//table/tr[2]/td[4]")
	 WebElement operation;
	 @FindBy(xpath="//table/tr/td[text()='Process Studio']/../td/span[2]")
	 WebElement deleteBtn;
	 @FindBy(id="popup-button-ok")
	 WebElement confirmDelete;
	 @FindBy(xpath="//div[@class='title-div']/h2")
	 WebElement pageTitle;
	 
	  public ArtifactsPage()
	  {
		  PageFactory.initElements(driver, this);
	  }
	  //Here we are uploading PS in artifacts &covering negative scenario as when user give invalid input as Process studio or 
	  //process Studio than correct Process Studio
	  public void ValidateUploadPS(String InvalidPsName,String Version,String ValidPsName) throws Exception{
		  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		    Thread.sleep(5000);
		    //wait.until(ExpectedConditions.visibilityOf(ArtifactsTab));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ArtifactsTab);
			uploadBtn.click();
			Thread.sleep(3000);
			Reporter.log("Upload button is clicked",true);
			artifactName.sendKeys(InvalidPsName);
			Thread.sleep(2000);
			version.sendKeys(Version);
			Thread.sleep(2000);
			artifactFile.sendKeys(prop.getProperty("uploadPSFile"));
			Thread.sleep(2000);
			uploadSubmitBtn.click();
			Reporter.log("Upload PS button clicked",true);
			wait.until(ExpectedConditions.visibilityOf(alertMessage));
			String actual_FailureMsg = alertMessage.getText();
			Reporter.log("Failure message for Invalid Artifact name: " + actual_FailureMsg,true);
			String expected_failureMsg = Messages.invalidArtifactName;
			Assert.assertEquals(actual_FailureMsg, expected_failureMsg, "Check artifacts details again");
			Reporter.log("Please upload artifacts with valid name",true);
			Thread.sleep(13000);
			for(int i = 0; i < 50; i++) {
			artifactName.sendKeys(Keys.BACK_SPACE);
			}
			Thread.sleep(3000);
			artifactName.sendKeys(ValidPsName);
			Reporter.log("Artifact name has given correctly",true);
			uploadSubmitBtn.click();
			Reporter.log("Upload PS button clicked",true);
			Thread.sleep(2000);
			String actual_SuccessMsg = alertMessage.getText();
			Reporter.log("Success message for valid Artifact name: " + actual_SuccessMsg,true);
			String expected_SuccessMsg = Messages.validArtifactName;
			Assert.assertEquals(actual_SuccessMsg,expected_SuccessMsg, "Artifacts not uploaded");
			Reporter.log("Artifact uploaded successfully",true);
			Thread.sleep(3000);
			js.executeScript("arguments[0].click();", LogsTab);
			Thread.sleep(2000);			
			String actual_Entity=entity.getText();
			Thread.sleep(2000);	
			String actual_Operation=operation.getText();
			Reporter.log("Actual Entity after uploading PS Upload: "+actual_Entity,true);
			Reporter.log("Actual Operation after uploading PS Upload: "+actual_Operation,true);
			Assert.assertEquals(actual_Entity,"ARTIFACT","Entity is not showing correctly in Logs");
			Assert.assertEquals(actual_Operation,"UPLOAD","Operation is not showing correctly in Logs");
			Reporter.log("Entry and Operation in Logs after uploading PS is verified");
			Reporter.log("Entity after uploading PS is verified");
			informationpage.validateSignOut();
	  }
	  
	  public void ValidateUpdatePS() throws Exception{
		  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		  Thread.sleep(5000);
		  // wait.until(ExpectedConditions.visibilityOf(ArtifactsTab));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ArtifactsTab);
			editBtn.click();
			Thread.sleep(3000);
			Reporter.log("Edit button is clicked",true);
			artifactFile.sendKeys(prop.getProperty("uploadUpdatedPSFile"));
			Thread.sleep(2000);
			uploadSubmitBtn.click();
			Reporter.log("Upload PS button clicked",true);
			wait.until(ExpectedConditions.visibilityOf(alertMessage));
			String actual_Msg = alertMessage.getText();
			String expected_Msg=Messages.updateArtifact;
			Reporter.log(" Actual message after updating artifact: " + actual_Msg,true);
			Assert.assertEquals(actual_Msg, expected_Msg, "Artifact not updated");
			Reporter.log("Artifact updated successfully",true);
			informationpage.validateSignOut();
	  }
		public void validateArtifactsPage(String PageTitle) throws Exception {
			loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			Reporter.log("User log in Successfully",true);
			//First search for tab and click on it
			Thread.sleep(5000);
			//wait.until(ExpectedConditions.visibilityOf(ArtifactsTab));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",ArtifactsTab);
			Thread.sleep(5000);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					//Now validate page title is same as expected
			String actual_title=pageTitle.getText();
			String expected_title=PageTitle;
			Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
							+ "page title is: "+expected_title,true);
			Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
			Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
			informationpage.validateSignOut();
		}
	  
	  public void ValidateDeletePS() throws Exception{
		  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		  Thread.sleep(5000);
		  //wait.until(ExpectedConditions.visibilityOf(ArtifactsTab));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ArtifactsTab);
			deleteBtn.click();
			Reporter.log("Delete button is clicked",true);
			Thread.sleep(3000);
			confirmDelete.click();
			Reporter.log("Confirmed for deletion of Artifact",true);
			wait.until(ExpectedConditions.visibilityOf(alertMessage));
			String actual_Msg = alertMessage.getText();
			String expected_Msg=Messages.deleteArtifact;
			Reporter.log(" Actual message after deletion of artifact: " + actual_Msg,true);
			Assert.assertEquals(actual_Msg, expected_Msg, "Artifact not deleted");
			Reporter.log("Artifact deleted successfully",true);
			informationpage.validateSignOut();
	  }
	  

}
