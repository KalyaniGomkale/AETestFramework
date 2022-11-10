package com.ae.qa.pagesTenantAdmin;

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
import com.ae.qa.pages.InformationPage;
import com.ae.qa.pages.WebElements;
import com.ae.qa.util.CommonWebElements;
import com.ae.qa.util.Messages;

public class UserGroupsPageTA extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 200);
	public WebElements webelements = new WebElements();
	public LoginPageTA loginpageta = new LoginPageTA();
	public InformationPageTA informationpageta=new InformationPageTA();
	public CommonWebElements wb = new CommonWebElements();

	@FindBy(xpath = "//span[text()='Users']")
	WebElement usersTab;
	@FindBy(xpath = "//a[text()='User Groups']")
	WebElement userGroupsTab;
	@FindBy(xpath = "//button[@name='add-new']/span")
	WebElement addBtnUG;
	@FindBy(id = "gname")
	WebElement groupNameField;
	@FindBy(id = "description")
	WebElement descriptionField;
	@FindBy(xpath = "//*[@name='create']")
	WebElement createBtnUG;
	@FindBy(xpath = "//div/p[@class='alert-message-text']")
	WebElement actual_userGroupMsg;
	@FindBy(xpath="//button[@name='create']")
	WebElement updateBtn;
	@FindBy(xpath="//div/b[contains(text(),'All Users')]/../select")
	WebElement allUsers;
	@FindBy(xpath="//div/b[contains(text(),'Existing Members')]/../select")
	WebElement existingMembers;
	@FindBy(xpath="//button[@name='assign']")
	WebElement assignBtn;
	@FindBy(xpath="//button[@name='remove']")
	WebElement removeBtn;
	@FindBy(xpath="//div[@id='category-op']/div/button[@name='close']")
	WebElement closeBtn;
	@FindBy(id="popup-button-ok")
	WebElement deletePopupBtn;
	@FindBy(xpath="//div[@class='title-div']/h2")
	WebElement pageTitle;
	
	public UserGroupsPageTA() {
		PageFactory.initElements(driver, this);
	}

	public void createUserGroup(String groupName, String description) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click UserGroups Tab
		//wait.until(ExpectedConditions.visibilityOf(userGroupsTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", userGroupsTab);
		// click add new
		//wait.until(ExpectedConditions.visibilityOf(addBtnUG));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", addBtnUG);
		Reporter.log("started creating new User Group",true);
		groupNameField.sendKeys(groupName);
		Thread.sleep(3000);
		descriptionField.sendKeys(description);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", createBtnUG);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		String actual_userGroup = actual_userGroupMsg.getText();
		String expected_userGroup = Messages.userGroup;
		Reporter.log("Actual Username:" + actual_userGroup,true);
		Reporter.log("Expected Username:" + expected_userGroup,true);
		Assert.assertEquals(actual_userGroup, expected_userGroup, "New user group can not added in list");
		Reporter.log("New user group is created",true);
		informationpageta.validateSignOut();
	}
	public void editUserGroup(String groupName, String updateDescrp) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click UserGroups Tab
		//wait.until(ExpectedConditions.visibilityOf(userGroupsTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", userGroupsTab);
		Thread.sleep(3000);
		WebElement editBtn=driver.findElement(By.xpath("//table/tr/td/div[contains(text(),'"+groupName+"')]/../../td/span[1]"));
		editBtn.click();
		Reporter.log("Edit button is clicked",true);
		for(int i=0;i<100;i++) {
			descriptionField.sendKeys(Keys.BACK_SPACE);
		}
		descriptionField.sendKeys(updateDescrp);
		Reporter.log("Description of user group updated",true);
		updateBtn.click();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		String actual_userGroup = actual_userGroupMsg.getText();
		String expected_userGroup = Messages.editUserGroup;
		Reporter.log("Actual Username:" + actual_userGroup,true);
		Reporter.log("Expected Username:" + expected_userGroup,true);
		Assert.assertEquals(actual_userGroup, expected_userGroup, "User group not get edited");
		Reporter.log("User group got edited successfully",true);
		informationpageta.validateSignOut();
		
	}
	public void addUserToGroup(String groupName,String user1) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users Tab clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(userGroupsTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", userGroupsTab);
		Reporter.log("UsersGroup Tab clicked",true);
		Thread.sleep(5000);
		WebElement showMember_Btn=driver.findElement(By.xpath("//table/tr/td/div[contains(text(),'"+groupName+"')]/../../td/span[2]"));
		showMember_Btn.click();
		Thread.sleep(3000);
		Reporter.log("Show Member button is clicked",true);
		Reporter.log("assigning user1",true);
		Thread.sleep(5000);
		Select allUser_drpdown=new Select(allUsers);
		allUser_drpdown.selectByVisibleText(user1);
		System.out.println("User to add:"+user1);
		assignBtn.click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		String actual_userGroup = actual_userGroupMsg.getText();
		String expected_userGroup = Messages.assignUserToGroup;
		Reporter.log("Actual Username:" + actual_userGroup,true);
		Reporter.log("Expected Username:" + expected_userGroup,true);
		Assert.assertEquals(actual_userGroup, expected_userGroup, "User not assign to group");
		Reporter.log("User1 assigned and validated",true);
		Thread.sleep(3000);
		closeBtn.click();
		Thread.sleep(2000);
		informationpageta.validateSignOut();
	}

	public void removeUserFromGroup(String groupName,String user1) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(userGroupsTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", userGroupsTab);
		Reporter.log("Users group tab clicked",true);
		Thread.sleep(3000);
		WebElement showMember_Btn=driver.findElement(By.xpath("//table/tr/td/div[contains(text(),'"+groupName+"')]/../../td/span[2]"));
		showMember_Btn.click();
		Reporter.log("Show Member button is clicked",true);
		Thread.sleep(5000);
		Reporter.log("Removing user1",true);
		Select allUser_drpdown=new Select(existingMembers);
		allUser_drpdown.selectByVisibleText(user1);
		System.out.println("User to add:"+user1);
		removeBtn.click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		String actual_userGroup = actual_userGroupMsg.getText();
		String expected_userGroup = Messages.removeUserFromGroup;
		Reporter.log("Actual Username:" + actual_userGroup,true);
		Reporter.log("Expected Username:" + expected_userGroup,true);
		Assert.assertEquals(actual_userGroup, expected_userGroup, "User not assign to group");
		Reporter.log("User1 removed",true);
		Thread.sleep(3000);
		closeBtn.click();
		Thread.sleep(3000);
		informationpageta.validateSignOut();
	/*	Reporter.log("Removing user2",true);
		Select allUser_drpdown1=new Select(existingMembers);
		allUser_drpdown1.selectByVisibleText(user2);
		System.out.println("User to add:"+user2);
		removeBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String actual_userGroup1 = actual_userGroupMsg.getText();
		String expected_userGroup1= Messages.removeUserFromGroup;
		System.out.println("Actual Username:" + actual_userGroup1);
		System.out.println("Expected Username:" + expected_userGroup1);
		Assert.assertEquals(actual_userGroup1, expected_userGroup1, "User not assign to group");
		Thread.sleep(3000);
		Reporter.log("User2 removed",true);*/
		
	/*	Reporter.log("Validation of no.of users",true);
		WebElement size=driver.findElement(By.xpath("//table/tr/td/div[contains(text(),'"+groupName+"')]/../../td[3]/div"));
		String actual_size=size.getText();
		System.out.println("Actual member:"+actual_size);
		Assert.assertEquals(actual_size,"0","No.of members dont match");
		Reporter.log("After removing all members zero members in group",true);*/	
	}
	
	public void ValidateDuplicateUserGroup(String groupName) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		// Click UserGroups Tab
		//wait.until(ExpectedConditions.visibilityOf(userGroupsTab));
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", userGroupsTab);
		// click add new
		//wait.until(ExpectedConditions.visibilityOf(addBtnUG));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", addBtnUG);
		Reporter.log("started creating new User Group",true);
		groupNameField.sendKeys(groupName);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", createBtnUG);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		String actual_userGroup = actual_userGroupMsg.getText();
		String expected_userGroup = "Duplicate user group name ["+groupName+"]";
		Reporter.log("Actual Username:" + actual_userGroup,true);
		Reporter.log("Expected Username:" + expected_userGroup,true);
		Assert.assertEquals(actual_userGroup, expected_userGroup, "User group with duplicate naem created");
		Reporter.log("User group with duplicate name can not be created",true);
		informationpageta.validateSignOut();
	}
	public void deleteUserGroup(String groupName) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User logged in successfully",true);
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		Reporter.log("Users tab clicked",true);
		//wait.until(ExpectedConditions.visibilityOf(userGroupsTab));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", userGroupsTab);
		Reporter.log("Users group tab clicked",true);
		Thread.sleep(3000);
		WebElement delete_Btn=driver.findElement(By.xpath("//table/tr/td/div[contains(text(),'"+groupName+"')]/../../td/span[3]"));
	    delete_Btn.click();
	    Thread.sleep(3000);
		Reporter.log("Delete button is clicked",true);
		deletePopupBtn.click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		String actual_userGroup = actual_userGroupMsg.getText();
		String expected_userGroup = Messages.deleteUserGroup;
		Reporter.log("Actual Username:" + actual_userGroup,true);
		Reporter.log("Expected Username:" + expected_userGroup,true);
		Assert.assertEquals(actual_userGroup, expected_userGroup, "User group not deleted");
		//Reporter.log("User1 removed",true);
		Reporter.log("User group deleted",true);
		informationpageta.validateSignOut();
	}
	public void validateUserGroupsPageTA(String PageTitle) throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully",true);
		//First search for tab and click on it
		//wait.until(ExpectedConditions.visibilityOf(usersTab));
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", usersTab);
		js.executeScript("arguments[0].click();", userGroupsTab);
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
	public void validateAdvSearch() throws Exception {
		loginpageta.login(prop.getProperty("username_TA1"), prop.getProperty("password_TA1"));
		Reporter.log("User log in Successfully", true);
		JavascriptExecutor js_tenant = (JavascriptExecutor) driver;
		js_tenant.executeScript("arguments[0].click();", usersTab);
		js_tenant.executeScript("arguments[0].click();", userGroupsTab);
		wb.validateClickOnAdvanceSearch();
	}

	public void validateAdvSearchForGroupNameEqualTo(String SearchColumn,String SearchCriteria,
			String groupName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, groupName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Group Name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_GroupName=op.get(i).getText();
			System.out.println("actual_Group Name present in table are: "+actual_GroupName);
			Assert.assertTrue(actual_GroupName.equals(groupName));
		}
	}
	public void validateAdvSearchForGroupNameNotEqualTo(String SearchColumn,String SearchCriteria,
			String groupName,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria, groupName);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Group Name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_GroupName=op.get(i).getText();
			System.out.println("actual_Group Name present in table are: "+actual_GroupName);
			Assert.assertFalse(actual_GroupName.equals(groupName));
		}
	}
	public void validateAdvSearchForGroupNameIsLike(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Group Name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_GroupName=op.get(i).getText();
			System.out.println("actual_Group Name present in table are: "+actual_GroupName);
			Assert.assertTrue(actual_GroupName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForGroupNameBeginsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Group Name record present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_GroupName=op.get(i).getText();
			//String lowercase_GroupName = actual_GroupName.toLowerCase();
			System.out.println("actual_Group Name present in table are: "+actual_GroupName);
			Thread.sleep(3000);
			Assert.assertTrue(actual_GroupName.contains(advSearchFor));
		}
	}
	public void validateAdvSearchForGroupNameEndsWith(String SearchColumn,String SearchCriteria,
			String advSearchFor,String PageSize)throws Exception {
		validateAdvSearch();
		wb.validateAdvanceSearchField(SearchColumn,SearchCriteria,advSearchFor);
		Thread.sleep(2000);
		wb.changePageSize(PageSize);
		// Verify data in table now
		Reporter.log("Below validation is to validate new tenant record is visible in webtable", true);
		List<WebElement>op=driver.findElements(By.xpath("//div[@class='table-responsive']/table/tr/td[1]"));
		for(int i=0;i<op.size();i++) {
			System.out.println("Total Group Name present in table are :"+op.size());
			Thread.sleep(3000);
			String actual_GroupName=op.get(i).getText();
			System.out.println("actual_Group Name present in table are: "+actual_GroupName);
			Assert.assertTrue(actual_GroupName.contains(advSearchFor));
		}
	}
}



