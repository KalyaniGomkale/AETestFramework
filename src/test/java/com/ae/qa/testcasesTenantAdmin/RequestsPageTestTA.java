package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.AgentListPageTA;
import com.ae.qa.pagesTenantAdmin.CataloguePageTA;
import com.ae.qa.pagesTenantAdmin.ExternalAppsPageTA;
import com.ae.qa.pagesTenantAdmin.RequestsPageTA;
import com.ae.qa.util.ExcelHandler;

public class RequestsPageTestTA extends TestBase{
	RequestsPageTA requestspageta;

	public RequestsPageTestTA() {
		super();
	}

	@Test(priority=74)
	public void validateRequestStatusTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRequestStatusTest", "TC_082: Verify request status");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateRequestStatus();
		//  requestspageta.validateRequestStatus(TestDataInMap.get("wfName"));
		extentTest.log(extentTest.getStatus(), "Request status is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=91)
	public void validatecheckColumnsInRequests(Method method) throws Exception {
		extentTest = extent.createTest("validatecheckColumnsInRequests", "TC_341:To Verify - Show colum check all option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.checkColumnsInRequests();
		extentTest.log(extentTest.getStatus(), "Check All option on Requests validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=92)
	public void validatedeselectAllInRequests(Method method) throws Exception {
		extentTest = extent.createTest("validatedeselectAllInRequests", "TC_342:To Verify - Show colum Uncheck all option");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.deselectAllInRequests();
		extentTest.log(extentTest.getStatus(), "UnCheck All option on Requests validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=93)
	public void validateSpecificColumnInRequests(Method method) throws Exception {
		extentTest = extent.createTest("validateSpecificColumnInRequests", "TC_343:To Verify - Specific column get display");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.SpecificColumnInRequests();
		extentTest.log(extentTest.getStatus(), "Specific column get displayed successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=94)
	public void validateDownloadRequestTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDownloadRequestTest", "TC_345:To Verify download requests");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateDownloadRequest();
		extentTest.log(extentTest.getStatus(), "Requests downloaded successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=183)
	public void validateRequestsPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateRequestsPageTATest", "TC_Additional:Verify Clicking Requests tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateRequestsPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Requests Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	/*@Test(priority=183)
	public void validateAdvanceSearchRequestPageTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvanceSearchRequestPageTest", "TC_Additional:Verify Advance Search");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvanceSearchRequestPage("Id","eq","27");
		extentTest.log(extentTest.getStatus(), "Advanced search is verified successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	/*@Test(priority=713)
	public void validateRequestFailureReasonTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRequestFailureReasonWATest", "TC_67: Verify failure reason");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		//requestspageta.validateRequestFailureReason(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				//prop.getProperty("WFforRequestFail"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				//TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("ParamValue"));
		//extentTest.log(extentTest.getStatus(), "Request status is verified successfully");  
		requestspageta.validateRequestFailureReason("FailWF","WF for Failure Reason","Default",prop.getProperty("WFforRequestFail"),"High","15","20","3","15","Minutes","Hello");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}
	/*@Test(priority=714)
	public void validateRestartRequestTest(Method method) throws Exception {
		extentTest = extent.createTest("validateRestartRequestWATest", "TC_70:Verify Manual Restart of workflow");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateRestartRequest();
		extentTest.log(extentTest.getStatus(), "Request has been restarted successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());
	}
	@Test(priority=715)
	public void validateTerminateRequestTest(Method method) throws Exception {
		extentTest = extent.createTest("validateTerminateRequestWATest", "TC_71: Verify Terminate workflow");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("WAsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		//requestspageta.validateTerminateRequest(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				//prop.getProperty("WFforRequestTerminate"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				//TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("ParamValue"),
				//TestDataInMap.get("ParamValue2"),TestDataInMap.get("ParamValue3"),TestDataInMap.get("ParamValue4"));
		requestspageta.validateTerminateRequest("RequestTerminateWF","WF for Terminate Reason","Default",prop.getProperty("WFforRequestTerminate"),"High","15","20","3","15","Minutes",
				"123","123","123","123");
		extentTest.log(extentTest.getStatus(), "Workflow request is terminated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("WAsheetname"), "Pass", method.getName());	
	}*/
	//For ID
/*	@Test(priority = 3232)
	public void validateAdvSearchForIDEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDEqualToRequestPageTATest", "TC_355:Verify advance search for ID equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForIDEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3233)
	public void validateAdvSearchForIDNotEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDNotEqualToRequestPageTATest", "TC_355:Verify advance search for ID not equal to criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForIDNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with not equal to criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3234)
	public void validateAdvSearchForIDLessThanRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDLessThanRequestPageTATest", "TC_355:Verify advance search for ID less than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForIDLessThan(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with less than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	} 
	@Test(priority = 3235)
	public void validateAdvSearchForIDGreaterThanRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDGreaterThanRequestPageTATest", "TC_355:Verify advance search for ID greater than criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForIDGreaterThan(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with greater than criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	} 
	@Test(priority = 3236)
	public void validateAdvSearchForIDInRangeRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDInRangeRequestPageTATest", "TC_355:Verify advance search for ID in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForIDInRange(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),
				TestDataInMap.get("SearchData"),TestDataInMap.get("SearchData1"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3237)
	public void validateAdvSearchForIDNotInRangeRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForIDNotInRangeRequestPageTATest", "TC_355:Verify advance search for ID for not in range criteria on request page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForIDNotInRange(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),
				TestDataInMap.get("SearchData"),TestDataInMap.get("SearchData1"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for ID with not in range criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Workflow Name
	@Test(priority = 3238)
	public void validateAdvSearchForWFNameEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Workflow name with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForWFNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3239)
	public void validateAdvSearchForWFNameNotEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameNotEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Workflow name with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForWFNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3240)
	public void validateAdvSearchForWFNameIsLikeRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameIsLikeRequestPageTATest", "TC_009: To Verfiy Advance search for Workflow name with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForWFNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3241)
	public void validateAdvSearchForWFNameBeginsWithRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameBeginsWithRequestPageTATest", "TC_009: To Verfiy Advance search for Workflow name with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForWFNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3242)
	public void validateAdvSearchForWFNameEndsWithRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameEndsWithRequestPageTATest", "TC_009: To Verfiy Advance search for Workflow name with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForWFNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For priority
	@Test(priority = 3243)
	public void validatePriorityDropdownEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validatePriorityDropdownEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Priority with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validatePriorityDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Priority is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3244)
	public void validatePriorityDropdownNotEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validatePriorityDropdownNotEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Priority with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validatePriorityDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Priority is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Status
	@Test(priority = 3245)
	public void validateAdvSearchForStatusEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForStatusEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Status with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateStatusDropdownEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Status is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3246)
	public void validateAdvSearchForStatusNotEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForStatusNotEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Status with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateStatusDropdownNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Status is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Source
	@Test(priority = 3247)
	public void validateAdvSearchForSourceEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Source with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSourceEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3248)
	public void validateAdvSearchForSourceNotEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceNotEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Source with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSourceNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3249)
	public void validateAdvSearchForSourceIsLikeRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIsLikeRequestPageTATest", "TC_009: To Verfiy Advance search for Source with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSourceIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3250)
	public void validateAdvSearchForSourceBeginsWithRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceBeginsWithRequestPageTATest", "TC_009: To Verfiy Advance search for Source with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSourceBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3251)
	public void validateAdvSearchForSourceEndsWithRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceEndsWithRequestPageTATest", "TC_009: To Verfiy Advance search for Source with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSourceEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Source ID
	@Test(priority = 3252)
	public void validateAdvSearchForSourceIDEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIDEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Source ID with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSourceIDEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source ID is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3253)
	public void validateAdvSearchForSourceIDNotEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIDNotEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for Source ID with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSourceIDNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source ID is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3254)
	public void validateAdvSearchForSourceIDIsLikeRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIDIsLikeRequestPageTATest", "TC_009: To Verfiy Advance search for Source ID with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSourceIDIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source ID is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3255)
	public void validateAdvSearchForSourceIDBeginsWithRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIDBeginsWithRequestPageTATest", "TC_009: To Verfiy Advance search for Source ID with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSourceIDBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source ID is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3256)
	public void validateAdvSearchForSourceIDEndsWithRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSourceIDEndsWithRequestPageTATest", "TC_009: To Verfiy Advance search for Source ID with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSourceIDEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Source ID is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Agent Name
	@Test(priority = 3257)
	public void validateAdvSearchForAgentNameEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for AgentName with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForAgentNameEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3258)
	public void validateAdvSearchForAgentNameNotEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameNotEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for AgentName with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForAgentNameNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3259)
	public void validateAdvSearchForAgentNameIsLikeRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameIsLikeRequestPageTATest", "TC_009: To Verfiy Advance search for AgentName with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForAgentNameIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3260)
	public void validateAdvSearchForAgentNameBeginsWithRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameBeginsWithRequestPageTATest", "TC_009: To Verfiy Advance search for AgentName with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForAgentNameBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3261)
	public void validateAdvSearchForAgentNameEndsWithRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForAgentNameEndsWithRequestPageTATest", "TC_009: To Verfiy Advance search for AgentName with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForAgentNameEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for AgentName is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Submitted by
	@Test(priority = 3262)
	public void validateAdvSearchForSubmittedByEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSubmittedByEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for SubmittedBy with equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSubmittedByEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for SubmittedBy is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3263)
	public void validateAdvSearchForSubmittedByNotEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSubmittedByNotEqualToRequestPageTATest", "TC_009: To Verfiy Advance search for SubmittedBy with not equals criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSubmittedByNotEqualTo(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for SubmittedBy is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3264)
	public void validateAdvSearchForSubmittedByIsLikeRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSubmittedByIsLikeRequestPageTATest", "TC_009: To Verfiy Advance search for SubmittedBy with Is like criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSubmittedByIsLike(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for SubmittedBy is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3265)
	public void validateAdvSearchForSubmittedByBeginsWithRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSubmittedByBeginsWithRequestPageTATest", "TC_009: To Verfiy Advance search for SubmittedBy with begins with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSubmittedByBeginsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for SubmittedBy is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3266)
	public void validateAdvSearchForSubmittedByEndsWithRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForSubmittedByEndsWithRequestPageTATest", "TC_009: To Verfiy Advance search for SubmittedBy with ends with criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateAdvSearchForSubmittedByEndsWith(TestDataInMap.get("ColumnName"),TestDataInMap.get("Criterion"),TestDataInMap.get("SearchData"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for SubmittedBy is validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	//For Created
	@Test(priority = 3267)
	public void validateCreatedEqualToRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToRequestPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateCreatedEqualTo(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3268)
	public void validateCreatedBeforeRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedBeforeRequestPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateCreatedBefore(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3269)
	public void validateCreatedAfterRequestTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedAfterRequestPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateCreatedAfter(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3270)
	public void validateCreatedInBetweenRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedInBetweenRequestPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateCreatedInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}
	@Test(priority = 3271)
	public void validateCreatedNotInBetweenRequestPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedNotInBetweenRequestPageTATest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("AdvancedSearchsheetname"),method.getName());
		requestspageta = new RequestsPageTA(); 
		requestspageta.validateCreatedNotInBetween(TestDataInMap.get("Criterion"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
				TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"),TestDataInMap.get("PageSize"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("AdvancedSearchsheetname"), "Pass", method.getName());
	}*/
}
