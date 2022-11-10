package com.ae.qa.pages.WorkflowAdmin;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
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
import com.ae.qa.util.TestUtil;

public class AgentListPageWA extends TestBase{
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
	
	public AgentListPageWA() {
		PageFactory.initElements(driver, this);
	}

	public void validateAssistedAgentDownloadWA(String Username,String agentName) throws Exception{
		//firstly deleting the normal agent and then downloading the assisted agent
		agentlistpageta.validateDeleteAgent(agentName);;
		agentlistpageta.assignAssistedAgentToUser(Username);
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
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
		TestUtil.unzip(prop.getProperty("zipFilePathWA"),prop.getProperty("destDirWA"));
		Reporter.log("File unzipped properly",true);
		ProcessBuilder pb1 = new ProcessBuilder("cmd", "/c", "AssistedAgentRunWA.bat");
		File dir = new File(prop.getProperty("AgentRegBatFilePath"));
		pb1.directory(dir);
		Process p1 = pb1.start();
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	}
	public void validateCheckAgentStatusWA() throws Exception{
		loginpageta.login(prop.getProperty("username_WA"), prop.getProperty("password_WA"));
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
}
