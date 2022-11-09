package com.ae.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.HomePage;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.ExcelHandler;
import com.ae.qa.util.ReadExcel;
import com.ae.qa.util.TestDataHandler;
import com.ae.qa.util.TestUtil;

import com.aventstack.extentreports.gherkin.model.Scenario;


public class TenantsPageTest extends TestBase {
	LoginPage loginpage;
	TenantsPage tenantspage;
	TestDataHandler testdata=new TestDataHandler();

	//constructor is used to initialize object of class and super to call superclass objects and access the superclass methods and variables
	public TenantsPageTest() {
		super();
	}
	//Here we are eliminating hard-coded value and adopting data driven approach
	@Test(priority = 2)
	public void validateAddNewTenant(Method method) throws Exception {
		extentTest = extent.createTest("validateAddNewTenant", "TC_001: To Verfiy Add new Tenant");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		System.out.println("Values from excel:"+TestDataInMap.get("TenantName")+TestDataInMap.get("Description")+TestDataInMap.get("OrganizationCode"));
		tenantspage.addNewTenants(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"));
		extentTest.log(extentTest.getStatus(), "Tenant added successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 3)
	public void validateaddNewTenantsWithDuplicateOrgCode(Method method) throws Exception {
		extentTest = extent.createTest("validateAddNewTenantsWithDuplicateOrgCode","TC_006: To verify if user give duplicate org code");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		System.out.println("Values from excel:"+TestDataInMap.get("TenantName")+TestDataInMap.get("Description")+TestDataInMap.get("OrganizationCode"));
		tenantspage.addNewTenantsWithDuplicateOrgCode(TestDataInMap.get("TenantName"),TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"));
		extentTest.log(extentTest.getStatus(), "Tenant not created with duplicate org code");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	@Test(priority = 4)
	public void verifyLicenseInfoTest(Method method) throws Exception {
		extentTest = extent.createTest("verifyLicenseInfoTest", "TC_007: Verify License Information");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.verifyLicenseInfo();
		extentTest.log(extentTest.getStatus(), "It validates the license status of Sysadmin");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority=152)
	public void validateTenantsPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTenantsPageTest", "TC_Additional:Verify Clicking Tenants tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateTenantsPage(TestDataInMap.get("TabName"),TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Tenants page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//Need to add these test cases before normal agent get deleted
	/*@Test(priority = 472)
	public void validateDisableTenantTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDisableTenantTest", "TC_Additional: To verfiy able to disable any tenant");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateDisableTenant("KG");
		extentTest.log(extentTest.getStatus(), "Tenant is disabled successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 473 ,dependsOnMethods="validateDisableTenantTest")
	public void validateSubmitRequestDisabledTenantTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSubmitRequestDisabledTenantTest", "TC_Additional: To verify submit reqeust of disabled tenant");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateSubmitRequestDisabledTenant("Sanity1","KG01");
		extentTest.log(extentTest.getStatus(), "Submit request of disabled tenant is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 474)
	public void validateSubmitRequestEnableTenantTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSubmitRequestEnableTenantTest", "TC_Additional: Verify Can submit reqeust once enable tenant");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateSubmitRequestEnableTenant("KG","Sanity1");
		extentTest.log(extentTest.getStatus(), "Submit request of enabled tenant is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
	//Need to add these test cases after assisted agent gets register
	@Test(priority = 475)
	public void validateSubmitRequestDisableTenantAssistedAgentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSubmitRequestDisableTenantAssistedAgentTest", "TC_136: Verify  submit reqeust of assisted workflow of disabled tenant");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateSubmitRequestDisableTenantAssistedAgent("AssistedWF","Assisted WF for disable tenant","Default",prop.getProperty("WFToImportPath"),"High","5","10","1","1","Hours","KG","KG01");
		extentTest.log(extentTest.getStatus(), "submit reqeust of assisted workflow of disabled tenant is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test(priority = 476)
	public void validateSubmitRequestEnableTenantAssistedAgentTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSubmitRequestEnableTenantAssistedAgentTest", "TC_140: Verify  submit reqeust of assisted workflow of enabled tenant");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateSubmitRequestEnableTenantAssistedAgent("KG","AssistedWF");
		extentTest.log(extentTest.getStatus(), "submit reqeust of assisted workflow of enabled tenant is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//Test case for usage based license tenant
	@Test(priority=702)
	public void validateCreateAllotmentBasedTenantTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreateAllotmentBasedTenantTest", "TC_95: Verify create tenant with  sysadmin user with  licnese catgory - consumption based");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateCreateAllotmentBasedTenant("UBL01","Usage Based Licensing","UBL01","Consumption Based","Kalyani",
				"Rohil","1234567890","UBL01@gmail.com");
		extentTest.log(extentTest.getStatus(), "Tenant with license category-Consumption based is created successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//Test case for Verify allocate  consumption based
	@Test(priority=705)
	public void validateAllocateConsumptionBasedTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAllocateConsumptionBasedTest", "TC_99: Verify amend above T.admin license");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAllocateConsumptionBased("UBL01","2022","Oct","12","1","1","1","1");		
		extentTest.log(extentTest.getStatus(), "Tenant Admin license is admend successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//Test case for Amend License
	//Need to add tenant org code
	@Test(priority=706)
	public void validateAmendLicenseTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAmendLicenseTest", "TC_97: Verify allocate consumption based");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAmendLicense("UBL01","1","2","3","UBL01","AmendLicense","User","alu@abc.com","AmendLU1","Pune@123","Pune@123","Tenant Admin","Pune@1234");		
		extentTest.log(extentTest.getStatus(), "Consumption Based Allocation is verified successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
/*	//About orgcode
	/*@Test
	public void validateAdvSearchForOrgCodeEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForOrgCodeEqualToTest", "TC_003: To Verfiy Advance search for Org Code and created date with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAdvSearchForOrgCodeEqualTo("Org Code", "equal to",TestDataInMap.get("OrganizationCode"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Org Code and created date criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForOrgCodeNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForOrgCodeNotEqualToTest", "TC_003: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAdvSearchForOrgCodeNotEqualTo("Org Code", "not equal to","KG01","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Org Code and created date criteria validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForOrgCodeIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForOrgCodeIsLikeTest", "TC_003: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAdvSearchForOrgCodeIsLike("ICICI Bank","For Like op for org code","ICICI98","Org Code", "is like","CI","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Org Code and created date criteria validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchOrgBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchOrgEndsWithTest", "TC_003: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAdvSearchOrgBeginsWith("Org Code", "begins with","KG","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Org Code and created date criteria validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchOrgEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchOrgEndsWithTest", "TC_003: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAdvSearchOrgEndsWith("Org Code", "ends with","01","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Org Code and created date criteria validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	//About Name
	@Test
	public void validateAdvSearchForTNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForTNameEqualToTest", "TC_003: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAdvSearchForTNameEqualTo("Name", "equal to","KG","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Org Code and created date criteria validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchNameNotEqualTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchNameNotEqualTest", "TC_003: To Verfiy Advance search for Tenant name not equal to with criteria and Created After criteria");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAdvSearchNameNotEqual("ABC81","ABC xyz","ABC081","Name","not equal to","50");
		//tenantspage.validateAdvSearchNameNotEqual(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names not equals to and created after criteria validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchNameIsLikeTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAdvSearchNameIsLike("ABC811KG","A1BC xyz","ABC8KG1","Name","is like","AB","50");
		//	tenantspage.validateAdvSearchNameIsLike(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchNameBeginWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchNameBeginWithTest", "TC_003: To Verfiy Advance search for Tenant name begins with criteria and Created before criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAdvSearchNameBeginWith("HDFC110","ForHDFC Customer","HDFC110","Name","is like","HD","50");
		//	tenantspage.validateAdvSearchNameBeginWith(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//			TestDataInMap.get("AdvSearchFor"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names begins with and created before criteria validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	} 
    @Test
	public void validateAdvSearchNameEndWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchNameEndWithTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateAdvSearchNameEndWith("Name","ends with","KG","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	} 
	//About Calender
	@Test
	public void validateCreatedEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateCreatedEqualTo("exact date","2022","Aug","1","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateCreatedBeforeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedBeforeTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateCreatedBefore("before","2022","Jul","27","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateCreatedAfterTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedAfterTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateCreatedAfter("after","2022","Jul","21","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateCreatedInBetweenTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedInBetweenTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateCreatedInBetween("in between","2022","Jul","21","2022","Jul","28","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateCreatedNotInBetweenTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedNotInBetweenTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		tenantspage = new TenantsPage();
		tenantspage.validateCreatedNotInBetween("not in between","2022","Jul","23","2022","Jul","26","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/

}
