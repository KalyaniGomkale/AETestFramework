package com.ae.qa.pagesTenantAdmin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;
import com.ae.qa.util.TestUtil;

public class AgentListPageTA extends TestBase{

	public LoginPageTA loginpage = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 300);
	public InformationPageTA informationpageta=new InformationPageTA();
	public CataloguePageTA catalogueta=new CataloguePageTA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath="//span[text()='Agents']")
	WebElement AgentsTab;
	@FindBy(xpath="//a[text()='Workflow Assignment']")
	WebElement WorkflowAssignmentTab;
	@FindBy(xpath="//div[@class='agent-assign-desktop']/div/div/label")
	WebElement agentNotReg;
	@FindBy(xpath="//a[text()='Agent List']")
	WebElement AgentListTab;
	@FindBy(id = "download-agent")
	WebElement downloadAgentBtn;
	@FindBy(xpath="//*[@name='delete-agent']/span")
	WebElement downloadBtn;
	@FindBy(xpath="//*[@id='177']/div/span[3]")
	WebElement successMsgBox;
	@FindBy(xpath="//button[@name='refresh-btn']")
	WebElement refreshTable;
	@FindBy(xpath="//table[@id='agentTable']/tr[3]/td[5]/span")
	WebElement status;
	@FindBy(xpath="//span[@class='mul-dorpdown-button']")
	WebElement showColumnDrpdown;
	@FindBy(xpath="//span[@class='mul-checkmark']")
	WebElement selectAllCheckBox;
	@FindBy(xpath = "//span[@class='mul-dorpdown-button']/div")
	WebElement columnCount;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(id ="btnAssisted")
	WebElement AssistedAgentTab;
	@FindBy(id ="assisted")
	WebElement assignToUserTab;
	@FindBy(xpath ="(//div/div/div/input)[2]")
	WebElement searchBar;
	@FindBy(xpath ="//button[text()='Save']")
	WebElement saveBtn;
	@FindBy(xpath ="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath ="//button[text()='Stop']")
	WebElement confirmStopBtn;
	@FindBy(xpath ="//button[text()='Delete']")
	WebElement confirmDeleteBtn;
	@FindBy(xpath = "//h2[text()='Assisted Agents']")
	WebElement assistedAgentPageTitle;
	@FindBy(xpath="//*[@id='menu-search']/input")
	WebElement searchMenu;
	@FindBy(xpath="//button[@title='Edit Agent']")
	WebElement editBtn;
	@FindBy(xpath="//input[@id='agentName']")
	WebElement agentName;
	@FindBy(xpath="//button[text()='Restart']")
	WebElement confirmRestartBtn;

	public AgentListPageTA()
	{
		PageFactory.initElements(driver, this);
	}

	public void downloadAgent() throws Exception
	{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		//Verify when user try to assign wf without registering agent
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", WorkflowAssignmentTab);	
		Reporter.log("User navigated to workflow assignment Tab",true);
		Thread.sleep(3000);
		String expected_agentNotRegError=agentNotReg.getText();
		Reporter.log("When Agent is not registered and user try to assign workflow to agent then get error message as: "+expected_agentNotRegError,true);
		String actual_agentNotRegError = "No agent registered";
		Assert.assertEquals(actual_agentNotRegError, expected_agentNotRegError,"Not getting correct error in Workflow assignment Tab");
		Reporter.log("Getting correct error when user didnt register agent & try to assign workflow");
		Thread.sleep(2000);
		Reporter.log("Now User needs to download agent first",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agent List Tab",true);
		downloadAgentBtn.click();
		Thread.sleep(3000);
		downloadBtn.click();
		Reporter.log("Agent download started",true);
		Thread.sleep(100000);
		TestUtil.unzip(prop.getProperty("zipFilePath"),prop.getProperty("destDir"));
		Reporter.log("File unzipped properly",true);
		//ProcessBuilder pb= new ProcessBuilder(prop.getProperty("AgentRegBatFile"));
		//Process process= pb.start();
		//BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
		//StringBuilder sb=new StringBuilder();
		//  String line;
		/*  while((line = reader.readLine()) != null) {
				  sb.append(line + "\n");
				  }*/
		//  System.out.println(sb);
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "AgentRun.bat");
		File dir = new File(prop.getProperty("AgentRegBatFilePath"));
		pb.directory(dir);
		Process p = pb.start();
		Thread.sleep(3000);
		informationpageta.validateSignOut();
		//  driver.quit();
	}

	public void checkStatusOfAgent() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(8000);
		for(int i=0;i<3;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Agent is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Running")) {
				Assert.assertEquals(AgentStatus,"Running","Agent is not in running mode");
				break;
			}
		}
		Reporter.log("Agent is in running mode",true);
		informationpageta.validateSignOut();
	}
	public void checkColumnsInAgentList() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to AgentList tab",true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (!selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			System.out.println("Clicked on Select All CheckBox");
		} else {
			System.out.println("Select All Checkbox is already selected");
		}
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
		Assert.assertEquals(sizeOfColumnsInt, 7, "All columns not selected");
		Reporter.log("All Column got displayed in records after Checking select All checkbox.",true);
		informationpageta.validateSignOut();
	}
	public void deselectAllInAgentListTA() throws Exception {
		// Click Logs Tab
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to AgentList tab",true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			Reporter.log("Clicked on Select All and resulted into deselected all columns.",true);
		} else {
			for (int i = 1; i <= 2; i++) {
				selectAllCheckBox.click();
			}
			Reporter.log("Select All Checkbox is not already selected, Hence selected twice to deselect it.",true);
		}
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);//3
		Reporter.log("Selected count of No. of colums " + sizeOfColumnsInt,true);//3
		List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th/span"));
		Reporter.log("Total No of columns in table: " + TotalColumn.size(),true);
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			Reporter.log("Field of Columns: " + TotalColumn.get(i).getText(),true);
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Agent Name") || value.contains("Status") || value.contains("Resource Utilization")) {
			Reporter.log("Column Value found",true);
			Assert.assertEquals(sizeOfColumnsInt, 3, "All columns are not deselected. ");
			Reporter.log("All Options got deselected except Agent Name,Status and Resource Utilization.",true);
		} else {
			Reporter.log("Column value not found",true);
			Assert.assertTrue(false);
		}
		informationpageta.validateSignOut();
	}
	public void SpecificColumnInAgentList() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to AgentList tab",true);
		Thread.sleep(2000);
		showColumnDrpdown.click();
		Thread.sleep(5000);
		if (selectAllCheckBox.isSelected()) {
			selectAllCheckBox.click();
			Reporter.log("Clicked on Select All and resulted into deselected all columns.",true);
		} else {
			for (int i = 1; i <= 2; i++) {
				selectAllCheckBox.click();
				Thread.sleep(3000);
			}
			Reporter.log("Select All Checkbox is not already selected, Hence selected twice to deselect it.",true);

		}
		// select 2 more columns
		driver.findElement(By.xpath("//a/span[text()='Execution Threads']")).click();
		driver.findElement(By.xpath("//a/span[text()='Executing Workflows']")).click();
		String sizeOfColumn = columnCount.getText();
		int sizeOfColumnsInt = Integer.valueOf(sizeOfColumn);
		System.out.println("Selected count of No. of colums " + sizeOfColumnsInt);
		List<WebElement> TotalColumn = driver.findElements(By.xpath("//tr[@class='header-caption-row bg-primary']/th/span"));
		System.out.println("Total No of columns in table: " + TotalColumn.size());
		List<String> value = new ArrayList<String>();
		for (int i = 0; i < TotalColumn.size(); i++) {
			// String Field=TotalColumn.get(i).getText();
			Reporter.log("Field of Columns: " + TotalColumn.get(i).getText(),true);
			value.add(TotalColumn.get(i).getText());
		}
		if (value.contains("Agent Name") && value.contains("Execution Threads") && value.contains("Resource Utilization")
				&& value.contains("Status") && value.contains("Executing Workflows")) {
			Reporter.log("Column Value found",true);
			Assert.assertTrue(true);
			Assert.assertEquals(sizeOfColumnsInt, TotalColumn.size(), "All columns selected not found in table.");
			Reporter.log("All columns selected found in table.",true);
		} else {
			Reporter.log("Column value not found",true);
			Assert.assertTrue(false);
		}
		informationpageta.validateSignOut();
	}
	public void downloadAssistedAgent() throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		//Verify when user try to assign wf without registering agent
		//js.executeScript("arguments[0].click();", WorkflowAssignmentTab);	
		Thread.sleep(3000);
		Reporter.log("User navigated to workflow assignment Tab",true);
		Thread.sleep(3000);
		String expected_agentNotRegError=agentNotReg.getText();
		Reporter.log("When Agent is not registered and user try to assign workflow to agent then get error message as: "+expected_agentNotRegError,true);
		String actual_agentNotRegError = "No agent registered";
		Assert.assertEquals(actual_agentNotRegError, expected_agentNotRegError,"Not getting correct error in Workflow assignment Tab");
		Reporter.log("Getting correct error when user didnt register agent & try to assign workflow");
		Thread.sleep(2000);
		Reporter.log("Now User needs to download agent first",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agent List Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agent Tab",true);
		downloadAgentBtn.click();
		Thread.sleep(3000);
		downloadBtn.click();
		Reporter.log("Assisted Agent download started",true);
		Thread.sleep(100000);
		TestUtil.unzip(prop.getProperty("zipFilePathA"),prop.getProperty("destDirA"));
		Reporter.log("File unzipped properly",true);
		ProcessBuilder pb= new ProcessBuilder("cmd", "/c", "AgentRunA.bat");
		File dir = new File(prop.getProperty("AssistedAgentRegBatFilePath"));
		pb.directory(dir);
		Process process = pb.start();
		Thread.sleep(5000);		
		informationpageta.validateSignOut();

	}
	public void checkStatusOfAssistedAgent() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agents Tab",true);
		Thread.sleep(8000);
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
	public void assignAssistedAgentToUser(String Username) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agents Tab",true);
		js.executeScript("arguments[0].click();",  assignToUserTab);
		Reporter.log("User navigated to Assign To User Tab",true);
		searchBar.sendKeys(Username);
		Thread.sleep(4000);
		WebElement assignToUser_Checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		if(!assignToUser_Checkbox.isSelected()){
			assignToUser_Checkbox.click();
		}else{
			Reporter.log("Assign to user checkbox is already selected",true);
		}
		Thread.sleep(4000);
		saveBtn.click();
		Thread.sleep(2000);
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.assignToUser;
		System.out.println("Actual Message:- "+actual_Message);
		System.out.println("Expected Message:- "+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"Assignment not updated successfully");
		informationpageta.validateSignOut();
	}
	public void validateDeleteAgent(String agentName) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(2000);
		for(int i=0;i<1;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Agent is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Running")) {
				Assert.assertEquals(AgentStatus,"Running","Agent is not in running mode");
				break;
			}
		}
		Reporter.log("Agent is in running mode",true);
		Thread.sleep(2000);
		//WebElement stop_btn = driver.findElement(By.xpath("//table/tr/td[contains(text(),'"+agentName+"')]/../button[@title='Stop Agent']"));
		WebElement stop_btn= driver.findElement(By.xpath("//button[@title='Stop Agent']"));
		stop_btn.click();
		Reporter.log("Stop Button is Clicked",true);
		Thread.sleep(2000);
		confirmStopBtn.click();
		Reporter.log("Confirm Stop Button is Clicked",true);
		Thread.sleep(10000);
		for(int i=0;i<2;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Agent is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Stopped")) {
				Assert.assertEquals(AgentStatus,"Stopped","Agent is not in Stopped mode");
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
		Assert.assertEquals(actual_Message, expected_Message,"Agent not deleted successfully");
		Reporter.log("Agent is deleted successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateDeleteAssistedAgent(String agentName) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agents Tab",true);
		Thread.sleep(2000);
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
		for(int i=0;i<2;i++) {
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
	public void unassignAssistedAgentToUser(String Username,String password,String tabName) throws Exception {
		assignAssistedAgentToUser(Username);
		loginpage.login(Username,password);
		searchMenu.sendKeys(tabName);
		Thread.sleep(5000);
		String actual_tabname=driver.findElement(By.xpath("//*[text()='"+tabName+"']")).getText();
		String expected_tabname=tabName;
		Thread.sleep(2000);
		AgentsTab.click();
		Reporter.log("User searched for functionality: "+tabName+" and Found is: "+actual_tabname,true);
		Assert.assertEquals(actual_tabname, expected_tabname,"Search functionality did'nt work properly");
		Reporter.log("Search Functionality working properly",true);
		Thread.sleep(2000);
		informationpageta.validateSignOut();
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agents Tab",true);
		js.executeScript("arguments[0].click();",  assignToUserTab);
		Reporter.log("User navigated to Assign To User Tab",true);
		searchBar.sendKeys(Username);
		Thread.sleep(4000);
		WebElement assignToUser_Checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		if(assignToUser_Checkbox.isSelected()){
			assignToUser_Checkbox.click();
		}else{
			Reporter.log("Assign to user checkbox is not checked",true);
		}
		Thread.sleep(4000);
		saveBtn.click();
		Thread.sleep(2000);
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.assignToUser;
		System.out.println("Actual Message:- "+actual_Message);
		System.out.println("Expected Message:- "+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"Assignment not updated successfully");
		informationpageta.validateSignOut();
		loginpage.login(Username,password);
		Thread.sleep(2000);
		searchMenu.sendKeys(tabName);
		Thread.sleep(2000);
		//boolean agentTabVisibility= AgentsTab.isDisplayed();
		//System.out.println(agentTabVisibility);
		Reporter.log("User is not assigned to Assisted agent so Agent tab is not visible", true);
		informationpageta.validateSignOut();
	}
	public void validateEditAssistedAgentName(String EditedAgentName) throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agentslist Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", AssistedAgentTab);
		Reporter.log("User navigated to Assisted Agents Tab",true);
		js.executeScript("arguments[0].click();", editBtn);
		Reporter.log("User clicked on Edit Btn",true);
		for(int i = 0; i < 50; i++) {
			agentName.sendKeys(Keys.BACK_SPACE);
		}
		agentName.sendKeys(EditedAgentName);
		Thread.sleep(2000);
		saveBtn.click();
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.editAgentSettingMsg;
		Reporter.log("Actual message displayed on screen is: "+actual_Message+ " and Expected "
				+ "message is: "+expected_Message,true);
		Assert.assertEquals(actual_Message, expected_Message,"Assisted Agent Name did not get changed");
		Reporter.log("Edit button is clicked and Assisted agent name is changed successfully",true);
		Thread.sleep(4000);
		String AgentName = driver.findElement(By.xpath("//table/tr/td/span[text()='" + EditedAgentName + "']")).getText();
		Reporter.log("Edited Assisted Agent Name:- "+AgentName);
		if(AgentName.contentEquals(EditedAgentName)){
			Assert.assertTrue(true);
			Reporter.log("Agent Name Changed successfully.",true);
		}else {
			Assert.assertTrue(false);
			Reporter.log("Agent Name not changed successfully.",true);
		}
		informationpageta.validateSignOut();
	}
	public void validateAgentRestart() throws Exception{
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User LogIn Succesfully",true);
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(8000);
		for(int i=0;i<0;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Agent Before Restart is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Running")) {
				Assert.assertEquals(AgentStatus,"Running","Agent is not in running mode");
				break;
			}
		}
		Reporter.log("Agent is in running mode",true);
		WebElement restart_btn= driver.findElement(By.xpath("//button[@title='Agent Restart']"));
		restart_btn.click();
		Reporter.log("Restart button is clicked",true);
		Thread.sleep(2000);
		confirmRestartBtn.click();
		Reporter.log("Confirm Restart Button is Clicked",true);
		String actual_Message=alertMessage.getText();
		System.out.println("Actual Message:- "+actual_Message);
		String expected_Message=Messages.stopAgent;
		System.out.println("Expected Message:- "+expected_Message);
		Assert.assertEquals(actual_Message, expected_Message,"Stopping agent is not in progress");
		Reporter.log("Restart button is clicked and agent is going in Stopped Status successfully",true);
		Thread.sleep(10000);
		for(int i=0;i<2;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Agent after pressing the Restart button is: "+AgentStatus);
			Thread.sleep(5000);
			if(AgentStatus.equals("Stopped")) {
				Assert.assertEquals(AgentStatus,"Stopped","Agent is not in Stopped mode");
				break;
			}
		}
		Reporter.log("Agent is in Stopped mode",true);
		Thread.sleep(10000);
		for(int i=0;i<2;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Agent after being Restart is: "+AgentStatus);
			Thread.sleep(3000);
			if(AgentStatus.equals("Running")) {
				Assert.assertEquals(AgentStatus,"Running","Agent is not in running mode");
				break;
			}
		}
		Reporter.log("Agent is in running mode after being restart",true);
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}
	public void validateAgentListPageTA(String PageTitle) throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		js.executeScript("arguments[0].click();", AgentListTab);
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
	public void validateAdvSearch() throws Exception {
		loginpage.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		js.executeScript("arguments[0].click();", AgentListTab);
		wb.validateClickOnAdvanceSearch();
	}

	public void validateAdvSearchForAgentNameEqualTo(String SearchColumn,String SearchCriteria,
			String agentName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,agentName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Thread.sleep(2000);
			Assert.assertTrue(actual_AgentName.contentEquals(agentName));
		}
	}
	public void validateAdvSearchForAgentNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String agentName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, agentName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Assert.assertFalse(actual_AgentName.equals(agentName));
		}
	}
	public void validateAdvSearchForAgentNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Assert.assertTrue(actual_AgentName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForAgentNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			//String lowercase_UserName = actual_UserName.toLowerCase();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Thread.sleep(3000);
			Assert.assertTrue(actual_AgentName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForAgentNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_AgentName=op.get(i).getText();
			System.out.println("actual_Agent Name present in table are: "+actual_AgentName);
			Assert.assertTrue(actual_AgentName.contains(advSearchFor));
		}
	}
	public void validateStatusDropdownEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize) throws Exception {
		validateAdvSearch();
		Thread.sleep(5000);
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[5]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Status=op.get(i).getText();
			System.out.println("actual_Status present in table are: "+actual_Status);
			Thread.sleep(2000);
			Assert.assertTrue(actual_Status.equalsIgnoreCase(searchValue));
		}
	}
	public void validateStatusDropdownNotEqualTo(String colunmValue,String comparatorType,String searchValue,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchDropDown(colunmValue,comparatorType,searchValue);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[5]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Agent record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_Status=op.get(i).getText();
			System.out.println("actual_Status present in table are: "+actual_Status);
			Thread.sleep(2000);
			Assert.assertFalse(actual_Status.equalsIgnoreCase(searchValue));
		}
	}
	public void HandleEnterFieldValue(String SearchColumn,String SearchCriteria,String SearchFor,String PageSize)
			throws Exception {
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,SearchFor);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
	}
	public void validateAdvSearchForExecutionThreadEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Execution Thread : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected ID is " + AdvSearchFor, true);
			Assert.assertEquals(actual_EThread, AdvSearchFor,
					"Mismatch in actual and expected ID of advance search of request page");
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForExecutionThreadNotEqualTo(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Execution Thread : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected ID is " + AdvSearchFor, true);
			Assert.assertFalse(actual_EThread.equals(AdvSearchFor));
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForExecutionThreadLessThan(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Execution Thread : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();
			int actualEThread= Integer. parseInt(actual_EThread);
			int expectedEThread= Integer. parseInt(AdvSearchFor);
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actualEThread < expectedEThread);
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForExecutionThreadGreaterThan(String SearchColumn, String SearchCriteria, String AdvSearchFor,
			String PageSize) throws Exception {
		validateAdvSearch();
		HandleEnterFieldValue(SearchColumn, SearchCriteria, AdvSearchFor, PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate Execution Thread : " + AdvSearchFor + " record for " + SearchCriteria
				+ " criteria is visible in webtable", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();
			int actualEThread= Integer. parseInt(actual_EThread);
			int expectedEThread= Integer. parseInt(AdvSearchFor);
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected ID is " + AdvSearchFor, true);
			Assert.assertTrue(actualEThread > expectedEThread);
		}
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForExecutionThreadInRange(String SearchColumn, String SearchCriteria, String SearchField1,
			String SearchField2,String PageSize) throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchFieldForRange(SearchColumn, SearchCriteria,SearchField1,SearchField2);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
		// Verify data in table now//2-4
		Reporter.log("Below validation is to validate Execution Thread : " + SearchCriteria
				+ " of "+SearchField1+"-"+SearchField2+" is visible in webtable or not", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();//2,3,4
			int actualEThread= Integer. parseInt(actual_EThread);
			int expected_SearchFiledEThread1= Integer. parseInt(SearchField1);
			int expected_SearchFiledEThread2= Integer. parseInt(SearchField2);
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected Execution Thread is in range of " + expected_SearchFiledEThread1+"-"+expected_SearchFiledEThread2, true);
			Assert.assertTrue(actualEThread >= expected_SearchFiledEThread1 && actualEThread <= expected_SearchFiledEThread2 );
		} 
		informationpageta.validateSignOut();
	}
	public void validateAdvSearchForExecutionThreadNotInRange(String SearchColumn, String SearchCriteria, String SearchField1,
			String SearchField2, String PageSize) throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchFieldForRange(SearchColumn, SearchCriteria,SearchField1,SearchField2);
		Thread.sleep(3000);
		wb.changePageSize(PageSize);
		System.out.println("Page size changed to 50");
		Thread.sleep(3000);
		// Verify data in table now//2-4
		Reporter.log("Below validation is to validate Execution Thread : " + SearchCriteria
				+ " of "+SearchField1+"-"+SearchField2+" is visible in webtable or not", true);
		List<WebElement> op = driver
				.findElements(By.xpath("//div[@class='table table-responsive']/table/tr/td[2]"));
		for (int i = 0; i < op.size(); i++) {
			System.out.println("Total Matching record present in table are :" + op.size());
			Thread.sleep(1000);
			String actual_EThread = op.get(i).getText();//1,5,6,7
			int actualEThread= Integer. parseInt(actual_EThread);
			int expected_SearchFiledEThread1= Integer. parseInt(SearchField1);
			int expected_SearchFiledEThread2= Integer. parseInt(SearchField2);
			Reporter.log("actual_Execution Thread present in table are: " + actual_EThread + " expected Execution Thread is in range of " + expected_SearchFiledEThread1+"-"+expected_SearchFiledEThread2, true);
			Assert.assertTrue(actualEThread < expected_SearchFiledEThread1 || actualEThread > expected_SearchFiledEThread2 );
		} 
		informationpageta.validateSignOut();
	}



}	 
















