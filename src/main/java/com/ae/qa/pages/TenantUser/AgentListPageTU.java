package com.ae.qa.pages.TenantUser;

import java.io.File;

import org.openqa.selenium.By;
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
import com.ae.qa.pages.WebElements;
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.Messages;
import com.ae.qa.util.TestUtil;


public class AgentListPageTU extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver, 150);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta = new InformationPageTA();
	public AgentListPageTA agentlistpageta = new AgentListPageTA();

    @FindBy(xpath="//span[text()='Agents']")
	WebElement AgentsTab;
    @FindBy(xpath="//a[text()='Agent List']")
	WebElement AgentListTab;
	@FindBy(id = "download-agent")
	WebElement downloadAgentBtn;
	@FindBy(xpath="//*[@name='delete-agent']/span")
	WebElement downloadBtn;
	@FindBy(xpath="//button[@name='refresh-btn']")
	WebElement refreshTable;
	@FindBy(xpath="//table[@id='agentTable']/tr[3]/td[4]")
	WebElement status;
	@FindBy(xpath="//button[@title='Edit Agent']")
	WebElement editBtn;
	@FindBy(xpath="//input[@id='agentName']")
	WebElement agentName;
	@FindBy(xpath ="//button[text()='Save']")
	WebElement saveBtn;
	@FindBy(xpath ="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath ="//button[text()='Stop']")
	WebElement confirmStopBtn;
	@FindBy(xpath ="//button[text()='Delete']")
	WebElement confirmDeleteBtn;
	
	public AgentListPageTU() {
		PageFactory.initElements(driver, this);
	}
	public void validateAssistedAgentDownloadTU(String Username) throws Exception{
		agentlistpageta.assignAssistedAgentToUser(Username);
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agent List Tab",true);
		downloadAgentBtn.click();
		Thread.sleep(3000);
		downloadBtn.click();
		Reporter.log("Agent download started",true);
		Thread.sleep(100000);
		TestUtil.unzip(prop.getProperty("zipFilePathTU"),prop.getProperty("destDirTU"));
		Reporter.log("File unzipped properly",true);
		ProcessBuilder pb1 = new ProcessBuilder("cmd", "/c", "AssistedAgentRunTU.bat");
		File dir = new File(prop.getProperty("AgentRegBatFilePath"));
		pb1.directory(dir);
		Process p1 = pb1.start();
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void validateCheckAgentStatusTU() throws Exception{
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agent List Tab",true);
		Thread.sleep(2000);
		for(int i=0;i<4;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Assisted Agent is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Running")) {
				Assert.assertEquals(AgentStatus,"Running","Assisted Agent is not in running mode");
				break;
			}
		}
		Reporter.log("Assisted Agent is in running mode",true);
		informationpageta.validateSignOut();
	}
	public void validateEditAssistedAgentNameTU(String ChangeAgentName) throws Exception{
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agentslist Tab",true);
		js.executeScript("arguments[0].click();", editBtn);
		Reporter.log("User clicked on Edit Btn",true);
		for(int i = 0; i < 50; i++) {
		agentName.sendKeys(Keys.BACK_SPACE);
		}
		agentName.sendKeys(ChangeAgentName);
		Thread.sleep(2000);
		saveBtn.click();
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.editAgentNameFailureMsg;
		Reporter.log("Actual message displayed on screen is: "+actual_Message+ " and Expected "
				+ "message is: "+expected_Message,true);	
		Assert.assertEquals(actual_Message, expected_Message,"Assisted Agent Name did not get changed");
		Reporter.log("Edit button is clicked and Assisted agent name is not changed successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateAssistedAgentDeleteTU() throws Exception{
		loginpageta.login(prop.getProperty("username_TU1"), prop.getProperty("password_TU1"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agentslist Tab",true);
		Thread.sleep(4000);
		for(int i=0;i<1;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Assisted Agent is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Running")) {
				Assert.assertEquals(AgentStatus,"Running","Assisted Agent is not in running mode");
				break;
			}
		}
		Reporter.log("Assisted Agent is in running mode",true);
		Thread.sleep(2000);
		//WebElement stop_btn = driver.findElement(By.xpath("//table/tr/td[contains(text(),'"+agentName+"')]/../button[@title='Stop Agent']"));
		WebElement stop_btn= driver.findElement(By.xpath("//button[@title='Stop Agent']"));
		stop_btn.click();
		Reporter.log("Stop Button is Clicked",true);
		Thread.sleep(2000);
		confirmStopBtn.click();
		Reporter.log("Confirm Stop Button is Clicked",true);
		Thread.sleep(10000);
		for(int i=0;i<1;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Assisted Agent is: "+AgentStatus);
			Thread.sleep(5000);
			if(AgentStatus.equals("Stopped")) {
				Assert.assertEquals(AgentStatus,"Stopped","Assisted Agent is not in Stopped mode");
				break;
			}
		}
		Reporter.log("Agent is in Stopped mode",true);
		Thread.sleep(2000);
		//WebElement delete_btn = driver.findElement(By.xpath("//table/tr/td[contains(text(),'"+agentName+"')]/../button[@title='Delete Agent']"));
		WebElement delete_btn= driver.findElement(By.xpath("//button[@title='Delete Agent']"));
		delete_btn.click();
		Reporter.log("Delete Button is Clicked",true);
		Thread.sleep(2000);
		confirmDeleteBtn.click();
		Reporter.log("Confirm Delete Button is Clicked",true);
		Thread.sleep(4000);
		String actual_Message=alertMessage.getText();
		System.out.println("Actual_Message:-"+actual_Message);
		String expected_Message=Messages.deleteAgent;
		System.out.println("Expected Message:- "+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"Assisted Agent not deleted successfully");
		Reporter.log("Assisted Agent is deleted successfully",true);
		informationpageta.validateSignOut();
	}
}
