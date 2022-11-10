package com.ae.qa.pagesTenantAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.util.Messages;

public class WorkflowAssignmentPageTA extends TestBase {
	public LoginPageTA loginpageta = new LoginPageTA();
	public static WebDriverWait wait = new WebDriverWait(driver, 120);
	public InformationPageTA informationpageta=new InformationPageTA();
	
	@FindBy(xpath = "//span[(text()='Agents')]")
	WebElement agentsTab;
	@FindBy(xpath = "//a[contains(text(),'Workflow Assignment')]")
	WebElement wfAssignmentTab;
	@FindBy(id="edit")
	WebElement editBtn;
	@FindBy(xpath = "//div[@class='right-inner-addon']/input[@id='rightSearch']")
	WebElement rightSearchBar;
	@FindBy(xpath="//a/input[contains(@id,'desktop')]")
	WebElement selectWorkflow;
	@FindBy(id="save")
	WebElement saveBtn;
	@FindBy(id="popup-button-ok")
	WebElement okBtn;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement successMsgBox;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	@FindBy(id ="selectAll")
	WebElement selectAllWF;

	public WorkflowAssignmentPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void validateSingleWorkflowAssignment(String workflowName) throws Exception {
		//Here we are assigning single workflow to agent 
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(agentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", agentsTab);
		Reporter.log("Agents tab is clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(wfAssignmentTab));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", wfAssignmentTab);
		Reporter.log("Workflow Assignment tab is clicked",true);
		Thread.sleep(5000);
		editBtn.click();
		Reporter.log("Edit button is selected",true);
		Thread.sleep(5000);
		//First search the workflow you want to assign to agent
		rightSearchBar.sendKeys(workflowName);
		Reporter.log("Workflow is searched",true);
		if(!selectWorkflow.isSelected()) {
			selectWorkflow.click();
		} else {
			System.out.println("Required workflow checkbox is already selected");
		}
		Reporter.log("Required wf is selected",true);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();
		Reporter.log("Saved the operation",true);
		wait.until(ExpectedConditions.visibilityOf(okBtn));
		okBtn.click();
		Reporter.log("Assignment confirmed",true);
		wait.until(ExpectedConditions.visibilityOf(successMsgBox));
		String Actual_wfAssignmentMsg=successMsgBox.getText();
		String Expected_wfAssignmentMsg= Messages.wfAssignment;
		Reporter.log("Actual Wf Assignment Msg:" +Actual_wfAssignmentMsg,true);
		Reporter.log("Expected Wf Assignment Msg:" + Expected_wfAssignmentMsg,true);
		Assert.assertEquals(Actual_wfAssignmentMsg,Expected_wfAssignmentMsg, "Workflow is not assigned ");
		Reporter.log("Single workflow is successfully assigned to default agent",true);
		informationpageta.validateSignOut();	
	}
	public void validateWorkflowAssignmentPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(agentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", agentsTab);
		js.executeScript("arguments[0].click();", wfAssignmentTab);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(3000);	
		//Now validate page title is same as expected
		String actual_title=pageTitle.getText();
		String expected_title=PageTitle;
		Reporter.log("Actual page title displayed on screen is: "+actual_title+ " and Expected "
						+ "page title is: "+expected_title,true);
		Assert.assertEquals(actual_title, expected_title,"Appropriate page didn't loaded properly");
		Reporter.log("Respective Page is clicked and appropriate page is loaded properly",true);
		informationpageta.validateSignOut();
	}
	/*public void validateWorkflowAssignment(String workflowName1,String workflowName2,String workflowName3) throws Exception {
		//Here we are assigning single workflow to agent which is already selected
		loginpageta.login(prop.getProperty("username_TA"), prop.getProperty("password_TA"));
		Reporter.log("Tenant Admin signed in successfully",true);
		wait.until(ExpectedConditions.visibilityOf(agentsTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", agentsTab);
		Reporter.log("Agents tab clicked",true);
		wait.until(ExpectedConditions.visibilityOf(wfAssignmentTab));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", wfAssignmentTab);
		Reporter.log("Workflow Assignment tab clicked",true);
		Thread.sleep(5000);
		selectedAgent.click();
		Reporter.log("Default agent is selected",true);
		Thread.sleep(5000);
		//First uncheck select all workflow checkbox
		if(selectAllWfCheckbox.isSelected()) {
		selectAllWfCheckbox.click();
		Reporter.log("Select all workflow checkbox deselected",true);
		} else {
			for(int i=1;i<=2;i++) {
				selectAllWfCheckbox.click();
				Thread.sleep(2000);
			Reporter.log("Select all workflow checkbox is already deselected",true);
			}
		}
		Thread.sleep(4000);
	/*	for(int i=1;i<=3;i++) {
	//	WebElement wfToAssign=driver.findElement(By.xpath("//*[@title='workflowName"+i+"']"));
	//	String workflowName+=Integer.toString(i);
		String firstString="//*[@title='";
		String wf="workflowName"+i;
		String lastString="']";
		//WebElement wfToAssign=driver.findElement(By.xpath());
		System.out.println("Workflow name is:"+wf);
		WebElement wfToAssign=driver.findElement(By.xpath(firstString+wf+lastString));*/
	/*	String wfNames[]= new String[]{workflowName1,workflowName2,workflowName3};
		for(int i=0;i<wfNames.length;i++) {
			System.out.println(wfNames[i]);
		WebElement wfToAssign=driver.findElement(By.xpath("//*[@title='"+wfNames[i]+"']/input"));
		//*[@title='WebGui_79']/input
		System.out.println(driver.findElement(By.xpath("//*[@title='"+wfNames[i]+"']/input")));
	    wfToAssign.click();
		Reporter.log("Workflows which needs to assign the agent is selected",true);
		Thread.sleep(2000);
		}
		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();
		Reporter.log("Saved the operation",true);
		wait.until(ExpectedConditions.visibilityOf(okBtn));
		okBtn.click();
		Reporter.log("Assignment confirmed",true);
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		String Actual_wfAssignmentMsg=successMsgBox.getText();
		String Expected_wfAssignmentMsg= Messages.wfAssignment;
		System.out.println("Actual Wf Assignment Msg:" +Actual_wfAssignmentMsg);
		System.out.println("Expected Wf Assignment Msg:" + Expected_wfAssignmentMsg);
		Assert.assertEquals(Actual_wfAssignmentMsg,Expected_wfAssignmentMsg, "Workflow is not assigned ");
		Reporter.log("Single workflow is successfully assigned to selected agent",true);
		//validate count also
		String actual_count=driver.findElement(By.xpath("//span[text()='3']")).getText();
		int actual_wf=Integer.valueOf(actual_count);
		System.out.println("Actual count is:"+actual_wf+" expected count is:3");
	    Assert.assertEquals(actual_wf,3,"No.of wf assigned is not same");
		Reporter.log("No. of wf assigned to agent is Validated",true);
		informationpageta.validateSignOut();
	}*/
	public void validateMultipleWorkflowAssignment() throws Exception{
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("Tenant Admin signed in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(agentsTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", agentsTab);
		Reporter.log("Agents tab is clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(wfAssignmentTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", wfAssignmentTab);
		Reporter.log("Workflow Assignment tab is clicked",true);
		Thread.sleep(5000);
		editBtn.click();
		Reporter.log("Edit button is selected",true);
		Thread.sleep(2000);
		//Clicking on Workflows Checkbox so that all the WF are selected
		js.executeScript("arguments[0].click();", selectAllWF);
		Reporter.log("Workflows checkbox is clicked",true);
		if(!selectAllWF.isSelected()){
			{
				selectAllWF.click();
				Reporter.log("All workflow are selected",true);
			}
		}else {
			Reporter.log("All workflow are not selected",true);
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();
		Reporter.log("Saved the operation",true);
		wait.until(ExpectedConditions.visibilityOf(okBtn));
		okBtn.click();
		Reporter.log("Assignment confirmed",true);
		wait.until(ExpectedConditions.visibilityOf(successMsgBox));
		String Actual_wfAssignmentMsg=successMsgBox.getText();
		String Expected_wfAssignmentMsg= Messages.wfAssignment;
		Reporter.log("Actual Wf Assignment Msg:" +Actual_wfAssignmentMsg,true);
		Reporter.log("Expected Wf Assignment Msg:" + Expected_wfAssignmentMsg,true);
		Assert.assertEquals(Actual_wfAssignmentMsg,Expected_wfAssignmentMsg, "Muliple Workflow are not assigned ");
		informationpageta.validateSignOut();	
	}
}
