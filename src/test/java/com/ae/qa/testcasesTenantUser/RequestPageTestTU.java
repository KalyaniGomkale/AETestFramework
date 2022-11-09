package com.ae.qa.testcasesTenantUser;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.ActivityMonitor.RequestsPageAM;
import com.ae.qa.pages.TenantUser.RequestPageTU;
import com.ae.qa.pagesTenantAdmin.RequestsPageTA;
import com.ae.qa.util.ExcelHandler;

public class RequestPageTestTU extends TestBase{
	RequestPageTU requestpagetu;

	public RequestPageTestTU() {
		super();
	}

	@Test(priority=47)
	public void validateCheckColumnInRequestTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCheckColumnInRequestTUTest", "TC_11: To verify Check All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateCheckColumnInRequestTU(TestDataInMap.get("UserName"),TestDataInMap.get("wfName"));
		extentTest.log(extentTest.getStatus(), "Check all Column in Request is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());	
	}
	@Test(priority=48)
	public void validateUncheckColumnInRequestTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUncheckColumnInRequestTUTest", "TC_12: To verify UnCheck All option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateUncheckColumnInRequestTU();
		extentTest.log(extentTest.getStatus(), "UnCheck all Column in Request is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());	
	}
	@Test(priority=49)
	public void validateSpecificColumnInRequestTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSpecificColumnInRequestTUTest", "TC_13: To verify specific column get display");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateSpecificColumnInRequestTU();
		extentTest.log(extentTest.getStatus(), "Specific column in request is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());	
	}
	@Test(priority=50)
	public void validateDownloadRequestTUTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadRequestTUTest", "TC_15: To verify download request");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TUsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateDownloadRequestTU();
		extentTest.log(extentTest.getStatus(), "Download request is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TUsheetname"), "Pass", method.getName());	
	}
	//For ID
	@Test
	public void validateAdvSearchForIDEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDEqualToTest", "TC_355:Verify advance search for ID equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchForIDEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForIDNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDNotEqualToTest", "TC_355:Verify advance search for ID not equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchForIDNotEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with not equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForIDLessThanTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDLessThanTest", "TC_355:Verify advance search for ID less than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchForIDLessThan(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with less than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test
	public void validateAdvSearchForIDGreaterThanTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDGreaterThanTest", "TC_355:Verify advance search for ID greater than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchForIDGreaterThan(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with greater than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test
	public void validateAdvSearchForIDInRangeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDInRangeTest", "TC_355:Verify advance search for ID in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchForIDInRange(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("AdvSearchFor2"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForIDNotInRangeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDNotInRangeTest", "TC_355:Verify advance search for ID for not in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchForIDNotInRange(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("AdvSearchFor2"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with not in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//For Workflow Name
	@Test
	public void validateAdvSearchWFNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchWFNameEqualToTest", "TC_356:Verify advance search for WFName for not equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchWFNameEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchWFNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchWFNameNotEqualToTest", "TC_356:Verify advance search for WFName for not equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchWFNameNotEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with not equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test
	public void validateAdvSearchWFNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchWFNameIsLikeTest", "TC_356:Verify advance search for WFName for Is Like criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchWFNameIsLike(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with Is Like criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchWFNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchWFNameBeginsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchWFNameBeginsWith(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchWFNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchWFNameEndsWithTest", "TC_356:Verify advance search for WFName for ends with criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchWFNameEndsWith(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with ends with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	// For Status
	@Test
	public void validateAdvSearchForStatusEqualTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForStatusEqualTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchForStatusEqual("Completed");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForStatusNotEqualTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForStatusNotEqualTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchForStatusNotEqual("Failure");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//		Submited By
	@Test
	public void validateAdvSearchSubmitByEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSubmitByEqualToTest", "TC_356:Verify advance search for Submited by for equal to criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSubmitByEqualTo("Submitted By","equal to","Madhu Rani1","50");
		//requestspageta.validateAdvSearchSubmitByEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Submited by with equal to criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSubmitNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSubmitNotEqualToTest", "TC_356:Verify advance search for Submited by for not equal to criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSubmitNotEqualTo("Submitted By","not equal to","Madhu Rani2","50");
		//requestspageta.validateAdvSearchSubmitByEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Submited by with not equal to criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSubmitIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSubmitIsLikeTest", "TC_356:Verify advance search for Submited by for is like criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSubmitByEqualTo("Submitted By","is like","Madhu","50");
		//requestspageta.validateAdvSearchSubmitByEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Submited by with is like criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSubmitByBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSubmitByBeginsWithTest", "TC_356:Verify advance search for Submited by for begins with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSubmitByBeginsWith("Submitted By","begins with","Madhu","50");
		//requestspageta.validateAdvSearchSubmitByEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Submited by with begins with criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSubmitEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSubmitEndsWithTest", "TC_356:Verify advance search for Submited by for ends with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSubmitEndsWith("Submitted By","ends with","Rani1","50");
		//requestspageta.validateAdvSearchSubmitByEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Submited by with ends with criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	// For priority 
	@Test
	public void validatePriorityEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePriorityEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validatePriorityEqualTo("Priority", "equal to","HIGH","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validatePriorityNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePriorityNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validatePriorityNotEqualTo("Priority", "not equal to","DEFAULT","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For Source
	@Test
	public void validateAdvSearchSourceEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSourceEqualTo("Source", "equal to","AutomationEdge HelpDesk","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceNotEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSourceNotEqualTo("Source", "not equal to","AutomationEdge HelpDesk123","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIsLikeTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSourceIsLike("Source", "is like","Edge","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceBeginsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSourceBeginsWith("Source", "begins with","Automation","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceEndsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSourceEndsWith("Source", "ends with","Desk","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	// For Source
	@Test
	public void validateAdvSearchSourceIDEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIDEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSourceIDEqualTo("Source Id", "equal to","SID_1660801543457_d8-aa0-219e-b6-0a018-bab8-a4","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceIDNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIDNotEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSourceIDNotEqualTo("Source Id", "not equal to","SID_1660801543457_d8-aa0-219e-b6-0a018-bab8-a4123","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceIDIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIDIsLikeTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSourceIDIsLike("Source Id", "is like","SID_1660801543457_d8","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceIDBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIDBeginsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSourceIDBeginsWith("Source Id", "begins with","SID_1660801543457","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceIDEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIDEndsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchSourceIDEndsWith("Source Id", "ends with","a4","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	// For Agent Name
	@Test
	public void validateAdvSearchAgentNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchAgentNameEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchAgentNameEqualTo("Agent Name", "equal to","DELL@DESKTOP-5VHKQUJ","50");
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchAgentNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchAgentNameNotEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchAgentNameNotEqualTo("Agent Name", "not equal to","DELL@DESKTOP-5VHKQUJ123","50");
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchAgentNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchAgentNameIsLikeTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchAgentNameIsLike("Agent Name", "is like","DESKTOP","50");
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchAgentNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchAgentNameBeginsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchAgentNameBeginsWith("Agent Name", "begins with","DELL","50");
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchAgentNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchAgentNameEndsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateAdvSearchAgentNameEndsWith("Agent Name", "ends with","5VHKQUJ","50");
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//For Created [Calender]
	@Test
	public void validateCreatedEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateCreatedEqualTo("exact date","2022","Aug","11","50");
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
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateCreatedBefore("before","2022","Aug","19","50");
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
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateCreatedAfter("after","2022","Jul","6","50");
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
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateCreatedInBetween("in between","2022","Jul","6","2022","Aug","19","50");
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
		requestpagetu = new RequestPageTU(); 
		requestpagetu.validateCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
}
