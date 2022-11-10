package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;
import com.ae.qa.pagesTenantAdmin.ProxySettingsPageTA;
import com.ae.qa.pagesTenantAdmin.SingleSignOnPageTA;
import com.ae.qa.util.ExcelHandler;

public class SingleSignOnPageTestTA extends TestBase {
	SingleSignOnPageTA singlesignonpageta;

	public SingleSignOnPageTestTA() {
		super();
	}
	 @Test(priority=204)
		public void validateSingleSignOnPageTATest(Method method) throws Exception {
			extentTest = extent.createTest("validateSingleSignOnPageTATest", "TC_Additional:Verify Clicking Single Sign-On tab and checking that appropiate page is loaded");
			Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
			singlesignonpageta = new SingleSignOnPageTA();
			singlesignonpageta.validateSingleSignOnPageTA(TestDataInMap.get("PageTitle"));
			extentTest.log(extentTest.getStatus(), "Single Sign-On Page loading validated successfully");
			ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
		}
}
