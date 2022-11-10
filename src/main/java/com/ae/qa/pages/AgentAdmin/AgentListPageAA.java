package com.ae.qa.pages.AgentAdmin;

import java.io.File;
import java.util.List;

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
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;
import com.ae.qa.util.TestUtil;

public class AgentListPageAA extends TestBase{

	public LoginPageTA loginpage = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 300);
	public InformationPageTA informationpageta=new InformationPageTA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath="//span[text()='Agents']")
	WebElement AgentsTab;
	@FindBy(xpath="//a[text()='Agent List']")
	WebElement AgentListTab;
	@FindBy(id ="btnAssisted")
	WebElement AssistedAgentTab;
	@FindBy(xpath="//button[@title='Edit Agent']")
	WebElement editBtn;
	@FindBy(xpath="//input[@id='agentName']")
	WebElement agentName;
	@FindBy(xpath ="//button[text()='Save']")
	WebElement saveBtn;
	@FindBy(xpath ="//div/p[@class='alert-message-text']")
	WebElement alertMessage;
	@FindBy(xpath="//button[@name='refresh-btn']")
	WebElement refreshTable;
	@FindBy(xpath="//table[@id='agentTable']/tr[3]/td[5]/span")
	WebElement status;
	@FindBy(xpath ="//button[text()='Stop']")
	WebElement confirmStopBtn;
	@FindBy(xpath ="//button[text()='Delete']")
	WebElement confirmDeleteBtn;
	@FindBy(xpath="//a[text()='Workflow Assignment']")
	WebElement WorkflowAssignmentTab;
	@FindBy(xpath="//div[@class='agent-assign-desktop']/div/div/label")
	WebElement agentNotReg;
	@FindBy(id = "download-agent")
	WebElement downloadAgentBtn;
	@FindBy(xpath="//*[@name='delete-agent']/span")
	WebElement downloadBtn;
	@FindBy(id = "ipAddressToUse")
	WebElement ipAddress;

	public AgentListPageAA() {
		PageFactory.initElements(driver, this);
	}

	public void validateEditAssistedAgentNameAA(String ChangeAgentName) throws Exception{
		loginpage.login(prop.getProperty("username_AA"), prop.getProperty("password_AA"));
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
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
		agentName.sendKeys(ChangeAgentName);
		Thread.sleep(2000);
		saveBtn.click();
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.editAgentSettingMsg;
		Reporter.log("Actual message displayed on screen is: "+actual_Message+ " and Expected "
				+ "message is: "+expected_Message,true);
		Assert.assertEquals(actual_Message, expected_Message,"Assisted Agent Name did not get changed");
		Reporter.log("Edit button is clicked and Assisted agent name is changed successfully",true);
		Thread.sleep(4000);
		String AgentName = driver.findElement(By.xpath("//table/tr/td/span[text()='" + ChangeAgentName + "']")).getText();
		System.out.println("Changed Assisted Agent Name:- "+AgentName);
		if(AgentName.contentEquals(ChangeAgentName)){
			Assert.assertTrue(true);
			Reporter.log("Agent Name Changed successfully.",true);
		}else {
			Assert.assertTrue(false);
			Reporter.log("Agent Name not changed successfully.",true);
		}
		informationpageta.validateSignOut();
	}
	public void validateDeleteAssistedAgentAA(String agentName) throws Exception {
		loginpage.login(prop.getProperty("username_AA"), prop.getProperty("password_AA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
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
		for(int i=0;i<5;i++) {
			refreshTable.click();	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Assisted Agent is: "+AgentStatus);
			Thread.sleep(8000);
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
	public void downloadAgentAA() throws Exception
	{
		loginpage.login(prop.getProperty("username_AA"), prop.getProperty("password_AA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agent List Tab",true);
		downloadAgentBtn.click();
		Thread.sleep(3000);
		downloadBtn.click();
		Reporter.log("Agent download started",true);
		Thread.sleep(100000);
		TestUtil.unzip(prop.getProperty("zipFilePathAA"),prop.getProperty("destDirAA"));
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
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "AgentRunAA.bat");
		File dir = new File(prop.getProperty("AgentRegBatFilePath"));
		pb.directory(dir);
		Process p = pb.start();
		Thread.sleep(3000);
		informationpageta.validateSignOut();
		//  driver.quit();
	}

	public void checkStatusOfAgent() throws Exception {
		loginpage.login(prop.getProperty("username_AA"), prop.getProperty("password_AA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
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
	public void validateEditAgentNameAA(String ChangeAgentName) throws Exception{
		loginpage.login(prop.getProperty("username_AA"), prop.getProperty("password_AA"));
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agentslist Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", editBtn);
		Reporter.log("User clicked on Edit Btn",true);
		for(int i = 0; i < 50; i++) {
			agentName.sendKeys(Keys.BACK_SPACE);
		}
		agentName.sendKeys(ChangeAgentName);
		Thread.sleep(2000);
		saveBtn.click();
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.editAgentSettingMsg;
		Reporter.log("Actual message displayed on screen is: "+actual_Message+ " and Expected "
				+ "message is: "+expected_Message,true);
		Assert.assertEquals(actual_Message, expected_Message,"Assisted Agent Name did not get changed");
		Reporter.log("Edit button is clicked and Assisted agent name is changed successfully",true);
		Thread.sleep(4000);
		String AgentName = driver.findElement(By.xpath("//table/tr/td/span[text()='" + ChangeAgentName + "']")).getText();
		System.out.println("Changed Assisted Agent Name:- "+AgentName);
		if(AgentName.contentEquals(ChangeAgentName)){
			Assert.assertTrue(true);
			Reporter.log("Agent Name Changed successfully.",true);
		}else {
			Assert.assertTrue(false);
			Reporter.log("Agent Name not changed successfully.",true);
		}
		informationpageta.validateSignOut();
	}
	public void validateStopAgentAA() throws Exception{
		loginpage.login(prop.getProperty("username_AA"), prop.getProperty("password_AA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(2000);
		for(int i=0;i<1;i++){	
			String AgentStatus=status.getText();
			Reporter.log("Current status of Assisted Agent is: "+AgentStatus);
			Thread.sleep(8000);
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
			Thread.sleep(8000);
			if(AgentStatus.equals("Stopped")) {
				Assert.assertEquals(AgentStatus,"Stopped","Assisted Agent is not in Stopped mode");
				break;
			}
		}
		Reporter.log("Agent is in Stopped mode",true);
		Thread.sleep(2000);
		Reporter.log("Agent is stopped successfully",true);
		informationpageta.validateSignOut();
	}
	public void validateDeleteAgentAA() throws Exception{
		loginpage.login(prop.getProperty("username_AA"), prop.getProperty("password_AA"));
		Reporter.log("User LogIn Succesfully",true);
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		Thread.sleep(2000);
		for(int i=0;i<1;i++){	
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
	public void validateEditIPAddress(String ChangeIPAdress) throws Exception{
		loginpage.login(prop.getProperty("username_AA"), prop.getProperty("password_AA"));
		wait.until(ExpectedConditions.visibilityOf(AgentsTab));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", AgentsTab);
		Reporter.log("User navigated to Agents Tab",true);
		js.executeScript("arguments[0].click();", AgentListTab);
		Reporter.log("User navigated to Agentslist Tab",true);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", editBtn);
		Reporter.log("User clicked on Edit Btn",true);
		for(int i = 0; i < 50; i++) {
			ipAddress.sendKeys(Keys.BACK_SPACE);
		}
		ipAddress.sendKeys(ChangeIPAdress);
		Thread.sleep(2000);
		saveBtn.click();
		String actual_Message=alertMessage.getText();
		String expected_Message=Messages.editAgentSettingMsg;
		Reporter.log("Actual message displayed on screen is: "+actual_Message+ " and Expected "
				+ "message is: "+expected_Message,true);
		Assert.assertEquals(actual_Message, expected_Message,"IP Address did not get changed");
		Reporter.log("Edit button is clicked and IP Address is changed successfully",true);
		Thread.sleep(4000);
		informationpageta.validateSignOut();
	}
	public void validateAdvSearch() throws Exception {
		loginpage.login(prop.getProperty("username_AA"), prop.getProperty("password_AA"));
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
