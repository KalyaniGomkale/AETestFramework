package com.ae.qa.testcases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.ArtifactsPage;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.TenantUsersPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.TestDataHandler;

public class ArtifactsPageTest extends TestBase {
	
	LoginPage loginpage;
	ArtifactsPage artifactspage;
	TestDataHandler testdata=new TestDataHandler();
	
	//constructor is used to initialize object of class and super to call superclass objects and access the superclass methods and variables
	public ArtifactsPageTest() {
		super();
	}
	//reusable data change version after 7.0.0 release
	@Test(priority = 14)
	public void validateUploadPSTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUploadPSTest", "TC_xx & TC_XX: To Verfiy uploading PS artifacts with invalid name,"
				+ "Then with correct name and validate entry in audit logs");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		artifactspage = new ArtifactsPage();
		artifactspage.ValidateUploadPS(TestDataInMap.get("InvalidArtifactName"),TestDataInMap.get("Version"),TestDataInMap.get("ValidArtifactName"));
		extentTest.log(extentTest.getStatus(), "Artifacts uploaded successfully and entry verified in audit logs");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 135)
	public void ValidateUpdatePSTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateUpdatePSTest", "TC_XXX: To Verfiy uploading PS artifacts");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		artifactspage = new ArtifactsPage();
		artifactspage.ValidateUpdatePS();
		extentTest.log(extentTest.getStatus(), "Artifacts uploaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=157)
	public void validateArtifactsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateArtifactsPageTest", "TC_Additional:Verify Clicking Artifacts tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		artifactspage = new ArtifactsPage();
		artifactspage.validateArtifactsPage(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Artifacts page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	
	@Test(priority=557)
	public void ValidateDeletePSTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateDeletePSTest", "TC_XXX: To Verfiy deletion of  PS artifacts");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		artifactspage = new ArtifactsPage();
		artifactspage.ValidateDeletePS();
		extentTest.log(extentTest.getStatus(), "Artifacts deleted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
}
