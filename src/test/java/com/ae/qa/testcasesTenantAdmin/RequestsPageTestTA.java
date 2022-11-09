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

	/*@Test(priority=74)
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
	@Test(priority=713)
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

}
