package com.ae.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ae.qa.base.TestBase;

public class WebElements extends TestBase {
	public WebDriverWait wait = new WebDriverWait(driver, 180);
	@FindBy(xpath = "//span[@class='fa fa-refresh']")
	WebElement refreshBtn;
	@FindBy(xpath = "//input[@class='form-control global-buttons custom-field ng-valid ng-dirty ng-touched']")
	WebElement searchBtn;
	@FindBy(xpath = "//b[text()=' Advanced Search']")
	WebElement advanceSearch;
	@FindBy(id = "column-selector")
	WebElement columnDropdown;
	@FindBy(id = "comparator")
	WebElement comparatorDropdown;
	@FindBy(id = "first-control")
	WebElement valueTxtbox;
	@FindBy(id = "add-filter")
	WebElement addFilterBtn;
	@FindBy(xpath = "//select[@id='pageSize'][1]")
	WebElement pageNumber;

	public WebElements() {
		PageFactory.initElements(driver, this);
	}

	public void clickrefreshBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(refreshBtn));
		// refreshBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", refreshBtn);
	}

	public void InputSearchField(String SearchingFor) {
		wait.until(ExpectedConditions.visibilityOf(searchBtn));
		searchBtn.sendKeys(SearchingFor);
	}

	public void AdvanceSearchField(String SColumn, String comOption, String tValue) throws InterruptedException {
		// do advance search
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", advanceSearch);
		// Select name from dropdown
		//wait.until(ExpectedConditions.elementToBeClickable(columnDropdown));
		Thread.sleep(3000);
		Select select = new Select(columnDropdown);
		select.selectByValue(SColumn);
		// COMAPRATOR
		wait.until(ExpectedConditions.elementToBeClickable(comparatorDropdown));
		System.out.println("Comparator1 for tenant name");
		Select select_compare = new Select(comparatorDropdown);
		select_compare.selectByValue(comOption);
		// Give tenant name and add filter
		valueTxtbox.sendKeys(tValue);
		wait.until(ExpectedConditions.elementToBeClickable(addFilterBtn));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click();", addFilterBtn);
	}

	public void ExtraAdvanceSearch(String SColumn2, String comOption2, String tValue2) throws Exception {
		// select "orgcode" from dropdown
		// do advance search
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click();", advanceSearch);
		Thread.sleep(3000);
		// wait.until(ExpectedConditions.elementToBeClickable(columnDropdown));
		Select select_orgcode = new Select(columnDropdown);
		select_orgcode.selectByValue(SColumn2);
		// COMAPRATOR
		Thread.sleep(1000);
		// wait.until(ExpectedConditions.elementToBeClickable(comparatorDropdown));
		System.out.println("Comparator2 for org code");
		Select select_compareOrgCode = new Select(comparatorDropdown);
		select_compareOrgCode.selectByValue(comOption2);
		// Give tenant name and add filter
		valueTxtbox.sendKeys(tValue2);
		wait.until(ExpectedConditions.elementToBeClickable(addFilterBtn));
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("arguments[0].click();", addFilterBtn);
	}

	public void selectPageSize(String size) {
		Select PageNumber = new Select(pageNumber);
		PageNumber.selectByValue(size);
	}

}
