package com.ae.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;



public class CommonWebElements extends TestBase{
	public WebDriverWait wait = new WebDriverWait(driver,100);

	@FindBy(xpath="//span[@class='fa fa-caret-right']")
	WebElement AdvancedSearch;
	@FindBy(id="column-selector")
	WebElement columnName;
	@FindBy(id="comparator")
	WebElement Comparator;
	@FindBy(id="add-filter")
	WebElement addFilterBtn;
	@FindBy(xpath="//button/i[@class='fa fa-search']")
	WebElement searchBtn;
	@FindBy(id="first-control")
	WebElement searchPhraseField;
	@FindBy(id="sec-control")
	WebElement searchPhraseField2;
	@FindBy(xpath="//select[@name='first-control']")
	WebElement selectValueDropdown;
	@FindBy(id="entity-en-select")
	WebElement entitySelect;
	@FindBy(id="source-en-select")
	WebElement sourceSelect;
	@FindBy(id="level-en-select")
	WebElement logLevelSelect;
	@FindBy(id="status-en-select")
	WebElement statusSelect;
	@FindBy(id="first-control-datepicker")
	WebElement dateSelect1;
	@FindBy(id="second-control-datepicker")
	WebElement dateSelect2;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement monthDrpdown;
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement yearDrpdown;
	@FindBy(xpath = "//span[contains(text(),'Logs')]")
	@CacheLookup
	WebElement logsTab;
	@FindBy(xpath="(//select[@id='pageSize2'])[1]")
	WebElement pageSize;

	public CommonWebElements() {
		PageFactory.initElements(driver, this);
	}
	
	public void changePageSize(String PageSize) {
		Select selectPageSize=new Select(pageSize);
		selectPageSize.selectByVisibleText(PageSize);
	}
	
	public void validateClickOnAdvanceSearch() throws InterruptedException {
		Thread.sleep(2000);
		AdvancedSearch.click();
		Thread.sleep(2000);
		Reporter.log("Advanced Search is clicked",true);
	}
	
	public void validateAdvanceSearchField(String colunmValue,String comparatorType,
			String searchValue) throws Exception{
   //This method do advance search when values of criteria needs to enter by user
		Select select_ColumnName1 = new Select(columnName);
		select_ColumnName1.selectByVisibleText(colunmValue);
		Reporter.log(colunmValue+" is selected",true);
		Thread.sleep(2000);
		Select select_Compartor1 = new Select(Comparator);
		select_Compartor1.selectByVisibleText(comparatorType);
		Reporter.log(comparatorType+" comparator is selected",true);
		Thread.sleep(2000);
		searchPhraseField.sendKeys(searchValue);
		addFilterBtn.click();
		Reporter.log("Add filter button is clicked successfully",true);
		searchBtn.click();
		Reporter.log("Search button is clicked",true);
	}
	public void validateAdvanceSearchFieldForRange(String colunmValue,String comparatorType,
			String searchValue,String searchValue2) throws Exception{
		Select select_ColumnName1 = new Select(columnName);
		select_ColumnName1.selectByVisibleText(colunmValue);
		Reporter.log(colunmValue+" is selected",true);
		Thread.sleep(2000);
		Select select_Compartor1 = new Select(Comparator);
		select_Compartor1.selectByVisibleText(comparatorType);
		Reporter.log(comparatorType+" comparator is selected",true);
		Thread.sleep(2000);
		searchPhraseField.sendKeys(searchValue);
		searchPhraseField2.sendKeys(searchValue2);
		addFilterBtn.click();
		Reporter.log("Add filter button is clicked successfully",true);
		searchBtn.click();
		Reporter.log("Search button is clicked",true);
		}
	
	public void validateAdvanceSearchForCalender(String colunmValue1,String comparatorType1,
			String startYear,String startMonth,String startdate) throws Exception{
		//This method do advance search when criteria is of date
		Select select_ColumnName1 = new Select(columnName);
		select_ColumnName1.selectByVisibleText(colunmValue1);
		Reporter.log(colunmValue1+" is selected",true);
		Thread.sleep(2000);
		Select select_Compartor1 = new Select(Comparator);
		select_Compartor1.selectByVisibleText(comparatorType1);
		Reporter.log(comparatorType1+" comparator is selected",true);
		Thread.sleep(2000);
		dateSelect1.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startdate+"']"));
		start_day_picker.click();
		Thread.sleep(2000);
		addFilterBtn.click();
		Reporter.log("Add filter button is clicked successfully",true);
		searchBtn.click();
		Reporter.log("Search button is clicked",true);
	}

	public void validateAdvanceSearchDropDown(String colunmValue,String comparatorType,String searchValue) throws Exception{
		//This method do advance search when criteria is of dropdown type
		Select select_ColumnName1 = new Select(columnName);
		select_ColumnName1.selectByVisibleText(colunmValue);
		Reporter.log(colunmValue+" is selected",true);
		Thread.sleep(2000);
		Select select_Compartor1 = new Select(Comparator);
		select_Compartor1.selectByVisibleText(comparatorType);
		Reporter.log(comparatorType+" comparator is selected",true);
		Thread.sleep(2000);
		//For Search Phase
		Select select_OrgCode = new Select(selectValueDropdown);
		select_OrgCode.selectByVisibleText(searchValue);
		Reporter.log(searchValue+" value to be searched",true);
		Thread.sleep(2000);
		addFilterBtn.click();
		Reporter.log("Add filter button is clicked successfully",true);
		searchBtn.click();
		Reporter.log("Search button is clicked",true);
	}
	public void validateExtraAdvanceSearchForCalender(String colunmValue1,String comparatorType1,
			String startYear,String startMonth,String startdate,String endYear, String endMonth,
			String enddate) throws Exception{
		//This method do advance search when criteria is of date
		Select select_ColumnName1 = new Select(columnName);
		select_ColumnName1.selectByVisibleText(colunmValue1);
		Reporter.log(colunmValue1+" is selected",true);
		Thread.sleep(2000);
		Select select_Compartor1 = new Select(Comparator);
		select_Compartor1.selectByVisibleText(comparatorType1);
		Reporter.log(comparatorType1+" comparator is selected",true);
		Thread.sleep(2000);
		dateSelect1.click();
		Thread.sleep(2000);
		Select start_year_picker=new Select(yearDrpdown);
		start_year_picker.selectByVisibleText(startYear);
		Select start_month_picker=new Select(monthDrpdown);
		start_month_picker.selectByVisibleText(startMonth);
		Thread.sleep(2000);
		WebElement start_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+startdate+"']"));
		start_day_picker.click();
		Thread.sleep(2000);
		dateSelect2.click();
		Thread.sleep(2000);
		Select end_year_picker=new Select(yearDrpdown);
		end_year_picker.selectByVisibleText(endYear);
		Select end_month_picker=new Select(monthDrpdown);
		end_month_picker.selectByVisibleText(endMonth);
		Thread.sleep(2000);
		WebElement end_day_picker=driver.findElement(By.xpath("//tbody/tr/td/a[text()='"+enddate+"']"));
		end_day_picker.click();
		addFilterBtn.click();
		Reporter.log("Add filter button is clicked successfully",true);
		searchBtn.click();
		Reporter.log("Search button is clicked",true);
	}
	
}



