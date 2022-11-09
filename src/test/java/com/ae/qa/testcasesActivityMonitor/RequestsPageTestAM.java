package com.ae.qa.testcasesActivityMonitor;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.ActivityMonitor.RequestsPageAM;
import com.ae.qa.pages.WorkflowAdmin.RequestsPageWA;
import com.ae.qa.util.ExcelHandler;

public class RequestsPageTestAM extends TestBase{
	RequestsPageAM requestspageam;

	public RequestsPageTestAM() {
		super();
	}

	/*@Test(priority=34)
	public void validateCheckColumnInRequestAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCheckColumnInRequestAMTest", "TC_23:To Verify - Show colum check all option");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateCheckColumnInRequestAM();
		extentTest.log(extentTest.getStatus(), "Check All option on Requests validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=35)
	public void validateUncheckColumnInRequestAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUncheckColumnInRequestAMTest", "TC_24:To Verify - Show colum Uncheck all option");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateUncheckColumnInRequestAM();
		extentTest.log(extentTest.getStatus(), "UnCheck All option on Requests validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=36)
	public void validateSpecificColumnInRequestAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateSpecificColumnInRequestAMTest", "TC_25:To Verify - Specific column get display");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateSpecificColumnInRequestAM();
		extentTest.log(extentTest.getStatus(), "Specific column get displayed successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=37)
	public void validateDownloadRequestAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadRequestAMTest", "TC_26:Verify Download Requests");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateDownloadRequestAM();
		extentTest.log(extentTest.getStatus(), "Request are download successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=38)
	public void validateRequestStatusAMTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRequestStatusAMTest", "TC_27:Verify Requests in expanded mode");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateRequestStatusAM();
		extentTest.log(extentTest.getStatus(), "Request are verfied successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//For ID
	@Test
	public void validateAdvSearchForIDEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDEqualToTest", "TC_355:Verify advance search for ID equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchForIDEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForIDNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDNotEqualToTest", "TC_355:Verify advance search for ID not equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchForIDNotEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with not equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForIDLessThanTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDLessThanTest", "TC_355:Verify advance search for ID less than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchForIDLessThan(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with less than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test
	public void validateAdvSearchForIDGreaterThanTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDGreaterThanTest", "TC_355:Verify advance search for ID greater than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchForIDGreaterThan(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with greater than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test
	public void validateAdvSearchForIDInRangeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDInRangeTest", "TC_355:Verify advance search for ID in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchForIDInRange(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("AdvSearchFor2"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForIDNotInRangeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDNotInRangeTest", "TC_355:Verify advance search for ID for not in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchForIDNotInRange(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("AdvSearchFor2"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with not in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//For Workflow Name
	@Test
	public void validateAdvSearchWFNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchWFNameEqualToTest", "TC_356:Verify advance search for WFName for not equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchWFNameEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchWFNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchWFNameNotEqualToTest", "TC_356:Verify advance search for WFName for not equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchWFNameNotEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with not equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} 
	@Test
	public void validateAdvSearchWFNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchWFNameIsLikeTest", "TC_356:Verify advance search for WFName for Is Like criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchWFNameIsLike(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with Is Like criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchWFNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchWFNameBeginsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchWFNameBeginsWith(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchWFNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchWFNameEndsWithTest", "TC_356:Verify advance search for WFName for ends with criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchWFNameEndsWith(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
				TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with ends with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	} */
	// For Status
	@Test
	public void validateAdvSearchForStatusEqualTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForStatusEqualTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchForStatusEqual("Completed");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForStatusNotEqualTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForStatusNotEqualTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchForStatusNotEqual("Failure");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//		Submited By
	@Test
	public void validateAdvSearchSubmitByEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSubmitByEqualToTest", "TC_356:Verify advance search for Submited by for equal to criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSubmitByEqualTo("Submitted By","equal to","Madhu Rani1","50");
		//requestspageta.validateAdvSearchSubmitByEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Submited by with equal to criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSubmitNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSubmitNotEqualToTest", "TC_356:Verify advance search for Submited by for not equal to criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSubmitNotEqualTo("Submitted By","not equal to","Madhu Rani2","50");
		//requestspageta.validateAdvSearchSubmitByEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Submited by with not equal to criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSubmitIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSubmitIsLikeTest", "TC_356:Verify advance search for Submited by for is like criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSubmitByEqualTo("Submitted By","is like","Madhu","50");
		//requestspageta.validateAdvSearchSubmitByEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Submited by with is like criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSubmitByBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSubmitByBeginsWithTest", "TC_356:Verify advance search for Submited by for begins with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSubmitByBeginsWith("Submitted By","begins with","Madhu","50");
		//requestspageta.validateAdvSearchSubmitByEqualTo(TestDataInMap.get("SearchColumn"),TestDataInMap.get("SearchCriteria"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Submited by with begins with criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSubmitEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSubmitEndsWithTest", "TC_356:Verify advance search for Submited by for ends with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSubmitEndsWith("Submitted By","ends with","Rani1","50");
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
		requestspageam = new RequestsPageAM(); 
		requestspageam.validatePriorityEqualTo("Priority", "equal to","HIGH","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validatePriorityNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validatePriorityNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validatePriorityNotEqualTo("Priority", "not equal to","DEFAULT","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For Source
	@Test
	public void validateAdvSearchSourceEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSourceEqualTo("Source", "equal to","AutomationEdge HelpDesk","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceNotEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSourceNotEqualTo("Source", "not equal to","AutomationEdge HelpDesk123","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIsLikeTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSourceIsLike("Source", "is like","Edge","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceBeginsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSourceBeginsWith("Source", "begins with","Automation","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceEndsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSourceEndsWith("Source", "ends with","Desk","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	// For Source
	@Test
	public void validateAdvSearchSourceIDEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIDEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSourceIDEqualTo("Source Id", "equal to","SID_1660801543457_d8-aa0-219e-b6-0a018-bab8-a4","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceIDNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIDNotEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSourceIDNotEqualTo("Source Id", "not equal to","SID_1660801543457_d8-aa0-219e-b6-0a018-bab8-a4123","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceIDIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIDIsLikeTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSourceIDIsLike("Source Id", "is like","SID_1660801543457_d8","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceIDBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIDBeginsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSourceIDBeginsWith("Source Id", "begins with","SID_1660801543457","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchSourceIDEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchSourceIDEndsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchSourceIDEndsWith("Source Id", "ends with","a4","50");
		extentTest.log(extentTest.getStatus(), "Advance search for WFName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	// For Agent Name
	@Test
	public void validateAdvSearchAgentNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchAgentNameEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchAgentNameEqualTo("Agent Name", "equal to","DELL@DESKTOP-5VHKQUJ","50");
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchAgentNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchAgentNameNotEqualToTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchAgentNameNotEqualTo("Agent Name", "not equal to","DELL@DESKTOP-5VHKQUJ123","50");
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchAgentNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchAgentNameIsLikeTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchAgentNameIsLike("Agent Name", "is like","DESKTOP","50");
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchAgentNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchAgentNameBeginsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchAgentNameBeginsWith("Agent Name", "begins with","DELL","50");
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchAgentNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchAgentNameEndsWithTest", "TC_356:Verify advance search for WFName for starts with criteria on request page");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateAdvSearchAgentNameEndsWith("Agent Name", "ends with","5VHKQUJ","50");
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName with starts with criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//For Created [Calender]
	@Test
	public void validateCreatedEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateCreatedEqualTo("exact date","2022","Aug","11","50");
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
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateCreatedBefore("before","2022","Aug","19","50");
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
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateCreatedAfter("after","2022","Jul","6","50");
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
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateCreatedInBetween("in between","2022","Jul","6","2022","Aug","19","50");
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
		requestspageam = new RequestsPageAM(); 
		requestspageam.validateCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

}
