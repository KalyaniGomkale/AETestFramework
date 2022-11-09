package com.ae.qa.base;

import org.testng.Assert;

import org.testng.ITestContext;
import java.io.File;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Capabilities;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = LogManager.getLogger(TestBase.class);
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static String workingDir=System.getProperty("user.dir");

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip=new FileInputStream(".\\src\\main\\resources\\config\\config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public static ExtentReports setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/AEExtentReport.html");
		htmlReporter.config().setEncoding("uft-8");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("AE Extent Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK); // Dark Theme
		System.out.println("Extent Report location initialized . . .");
		htmlReporter.start();
		extent = new ExtentReports();
	

		// htmlReporter.loadXMLConfig("C:\Users\Kalyani\eclipse-workspace\AutomationEdgePortal_5.5.0\src\main\resources\ExtentReportListener\extent-config.xml");
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Author", prop.getProperty("author"));
		extent.setSystemInfo("Product Version", prop.getProperty("ProdVersion"));
		extent.setSystemInfo("Organization Name", prop.getProperty("OrgName"));
		extent.setSystemInfo("Environment", prop.getProperty("env"));
		System.out.println("System Info. set in Extent Report");
		return extent;
	}

	// This method is to capture the screenshot and return the path of the
	// screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + "{" + dateName + "}"+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


	@BeforeMethod
	public void initialization() {
		log.debug("Execution started");
	/*	ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model*/
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Chrome")) {
		//	System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.contentEquals("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", prop.getProperty("ffDriverPath"));
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}  else if (browserName.contentEquals("IE")) {
			//System.setProperty("webdriver.ie.driver",prop.getProperty("IEDriverPath"));
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		} 
		else {
			System.out.println("Current framework support chrome or Firefox or IE browser. Please select any one of them.");
		}
		log.info("Browser started successfully");
		
		// Below code is because we wanted platform,OS,Browser to change automatically and not hardcoded
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String bName = caps.getBrowserName().toLowerCase();
		String os = caps.getPlatform().toString();
		String ver = caps.getVersion().toString();
		extent.setSystemInfo("Browser", bName);
		extent.setSystemInfo("OS", os);
		extent.setSystemInfo("Version", ver);
		// Settings
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// Launch the URL
		driver.get(prop.getProperty("url"));
		log.info("User is navigated to AE portal");
	}

	/*
	 * public WebDriver getdriver() { return driver; }
	 */
	@AfterMethod
	public void getResult(ITestResult result1) throws Exception {
		if (result1.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			extentTest.log(Status.FAIL,
					MarkupHelper.createLabel(result1.getName() + " - Test Case Failed", ExtentColor.RED));
			extentTest.log(Status.FAIL,
					MarkupHelper.createLabel(result1.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			extentTest.log(Status.FAIL,
					"<a href='C:\\Program Files\\AutomationEdge\\tools\\apache-tomcat-9.0.36\\logs\\automationedge.log'> ViewAutomationEdgeLogs </a>");
			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.
			String screenshotPath = getScreenShot(driver, result1.getName());
			// To add it in the extent report
			// Assert.fail("Test Case Failed Snapshot is below " +
			// extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.addScreenCaptureFromPath(screenshotPath);
		}

		else if (result1.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP,
					MarkupHelper.createLabel(result1.getName() + " - Test Case Skipped", ExtentColor.CYAN));
			extentTest.skip(result1.getThrowable());
		}

		else if (result1.getStatus() == ITestResult.SUCCESS) {

			extentTest.log(Status.PASS,
					MarkupHelper.createLabel(result1.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		driver.close();
	}

	@AfterTest
	public void endReport() {
		// used to erase any previous data on the report and create a new report
		extent.flush();

	}
	


}
