package com.ae.qa.testcasesTenantAdmin;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.CategoriesPageTA;
import com.ae.qa.pagesTenantAdmin.InformationPageTA;
import com.ae.qa.pagesTenantAdmin.TenantUsersPageTA;
import com.ae.qa.pagesTenantAdmin.WorkflowListPageTA;
import com.ae.qa.util.ExcelHandler;

public class WorkflowListPageTestTA extends TestBase {
	WorkflowListPageTA workflowlistpageta;
	//public InformationPageTA informationpageta=new InformationPageTA();

	public WorkflowListPageTestTA() {
		super();
	}

	@Test(priority=54)
	public void validateImportWorkflowTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowTest", "TC_082: Verify Import PS workflow w/o parameter & enable the workflow");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		//workflowlistpageta.validateImportWorkflow("Sanity3","Sanity","Default","C:\\Users\\kalyanig\\Downloads\\AE_Automation_UploadFiles\\Boolean.zip","High","20","60","3","30","Minutes");
		workflowlistpageta.validateImportWorkflow(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Workflow without parameters imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=55) 
	public void ValidateUploadInvalidIconTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateUploadIconTest","TC_152: Verify if user is able to upload wf icon more than 50KB");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateUploadInvalidIcon(TestDataInMap.get("wfName"),prop.getProperty("WFInavlidIcon"));
		extentTest.log(extentTest.getStatus(), "Workflow icon cant be updated as size is more than 50KB");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=56) 
	public void ValidateUploadIconTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateUploadIconTest","TC_151: Verify if user is able to upload wf icon upto 50KB");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateUploadIcon(TestDataInMap.get("wfName"),prop.getProperty("WFValidIcon"));
		extentTest.log(extentTest.getStatus(), "Workflow icon upto size 50KB uploaded successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=57) 
	public void ValidateEditManualExecutionTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateEditManualExecutionTest","TC_157: Verify if user can edit Manual execution time");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateEditManualExecution(TestDataInMap.get("wfName"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Manual execution time is edited successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}  


	@Test(priority=58) 
	public void ValidateExportWorkflowTest(Method method) throws Exception {
		extentTest=extent.createTest("ValidateExportWorkflowTest","TC_157: Verify if user can export wf from development env.");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.ValidateExportWorkflow(TestDataInMap.get("wfName"));
		extentTest.log(extentTest.getStatus(), "Workflow exported successfully from development environment");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=98)
	public void validateImportWorkflowWithConfigParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithConfigParamTest", "TC_083: Verify Import PS workflow with config parameter");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithConfigParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("ParamValue"));
		extentTest.log(extentTest.getStatus(), "Workflow with config parameter imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=99)
	public void validateImportWorkflowWithRuntimeParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithRuntimeParamTest", "TC_084: Verify Import PS workflow with runtime parameter without credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithRuntimeParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithRunTimeParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"));
		extentTest.log(extentTest.getStatus(), "Workflow with runtime parameters imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=100)
	public void validateImportWorkflowWithConfigRuntimeParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithConfigRuntimeParamTest", "TC_085: Verify Import PS workflow with configuration and runtime parameter without credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithConfigRuntimeParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithConfigRuntimeParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("ParamValue"));
		extentTest.log(extentTest.getStatus(), "Workflow with configuration & runtime parameters imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}

	@Test(priority=101)
	public void validateImportWorkflowWithCredConfigParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithCredConfigParamTest", "TC_086: Verify Import PS workflow with configuration with more than 1 credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithCredConfigParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithCredAsConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),
				TestDataInMap.get("CrdentailParam1"), TestDataInMap.get("CrdentailParam2"));
		extentTest.log(extentTest.getStatus(), "Workflow with configuration param as credentials imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=102)
	public void ValidateShowFileStructureTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateShowFileStructureTest", "TC_095: Verify show file structure while importing workflow");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.ValidateShowFileStructure(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFToImportPath"),TestDataInMap.get("ParamValue"));
		extentTest.log(extentTest.getStatus(), "Show File structure validated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=103)
	public void ValidateUpdateWFWithConfigWFTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateUpdateWFWithConfigWFTest", "TC_100: Validate update workflow without config parameter");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.ValidateUpdateWFWithConfigWF(TestDataInMap.get("wfName"),
				prop.getProperty("updateWFWithoutConfigParam"));
		extentTest.log(extentTest.getStatus(), "Workflow without config parameter updated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=173)
	public void validateWorkflowListPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateWorkflowListPageTATest", "TC_Additional:Verify Clicking Workflows List tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA();
		workflowlistpageta.validateWorkflowListPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Workflows List Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//Regression test case
	@Test(priority=305)
	public void validateImportWorkflowWithConfigParamCredAndCredpoolTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowWithConfigParamCredAndCredpoolTATest", "TC_087: Verify ImportPS workflow with Config parameter which uses individual credentials + credential pool");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowWithConfigParamCredAndCredpool(TestDataInMap.get("CredName"),TestDataInMap.get("CredDescp"),TestDataInMap.get("CredUserName"),TestDataInMap.get("CredPswd"),
				TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFWithCredAsConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("CrdentailParam1"),TestDataInMap.get("CrdentailParam2"));
		extentTest.log(extentTest.getStatus(), "Workflow without Config parameters using individual credentials and credentials pool imported successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	/*@Test(priority=312)
	public void validateImportWorkflowRegisteredAssistedAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowRegisteredAssistedAgent", "TC_087: Verify Import workflow for registered assisted agent");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowRegistredAssistedAgent("AssistedAgentWF05","For Assisted Agent","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\AssistedAgentWorkflow_v1.zip","Low","20","60","3","30","Minutes");
		// workflowlistpageta.validateImportWorkflowWithConfigParamCredAndCredpool(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
		//prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
		//TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"), "Suyash", "AECredentials" );
		extentTest.log(extentTest.getStatus(), "Workflow without Config parameters using individual credentials and credentials pool imported successfully"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=315)
	public void validateImportWorkflowUnRegisteredAssistedAgent(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowUnRegisteredAssistedAgent", "TC_087: Verify Import workflow for unregistered assisted agent");
		// Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWorkflowUnRegistredAssistedAgent("AssistedAgentWF06","For Assisted Agent","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\AssistedAgentWorkflow_v1.zip","Low","20","60","3","30","Minutes");
		// workflowlistpageta.validateImportWorkflowWithConfigParamCredAndCredpool(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
		//prop.getProperty("WFToImportPath"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
		//TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"), "Suyash", "AECredentials" );
		extentTest.log(extentTest.getStatus(), "Workflow without Config parameters using individual credentials and credentials pool imported successfully"); 
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}*/
	//Regression test case
	@Test(priority=306)
	public void ValidateExportMultipleWorkflowTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWorkflowTest", "TC_138: To verify can export multiple workflow at a time as verified");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.vaildateExportMutlipleWorkflow();
		extentTest.log(extentTest.getStatus(), "Multiple workflow at a time are selected and verified");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=318)
	public void ValidateShowFileStructureWorkflowTest(Method method) throws Exception {
		extentTest = extent.createTest("ValidateShowFileStructureWorkflowTest", "TC_60: Verify show file structure on workflow list page");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateShowFileStructureWorkflow(TestDataInMap.get("wfName"));
		extentTest.log(extentTest.getStatus(), "Show file Strcture of workflow is displayed appropriately");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());	
	}
	@Test(priority=318)
	public void validateImportWFRunParamCredTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWFRunParamCredTest", "TC_56: Verify Import PS workflow with Runtime parameter which uses credentials");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWFRunParamCred(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFWithRuntimeCredParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),TestDataInMap.get("CrdentailParam1"));
		extentTest.log(extentTest.getStatus(), "Verify Import PS workflow with Runtime parameter which uses credentials is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=340)
	public void validateUpdateConfigParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUpdateConfigParamTest", "TC_62: To verify update workflow which uses config parameters");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateUpdateConfigParam(TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),prop.getProperty("WFWithConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),
				TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),prop.getProperty("WFWithUpdatedConfigParam"),TestDataInMap.get("Param1"),TestDataInMap.get("Param2"),TestDataInMap.get("EncParam1"),TestDataInMap.get("EncParam2"));
		//workflowlistpageta.validateUpdateConfigParam("WFUpdateConfigParam","For update config parameter","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\WFWithConfigParam.zip","High","5",
		//"10","1","1","Hours","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\UpdatedConfigParam_v1.zip","Hello","World","Hello","World");
		extentTest.log(extentTest.getStatus(), "update workflow with config parameter is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=341)
	public void validateUpdateWFCredAndCredpoolTest(Method method) throws Exception {
		extentTest = extent.createTest("validateUpdateWFCredAndCredpoolTest", "TC_63: To verify update workflow uses config parameter as credentials and credential pool");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateUpdateWFCredAndCredpool(TestDataInMap.get("CredName"),TestDataInMap.get("CredDescp"),TestDataInMap.get("CredUserName"),TestDataInMap.get("CredPswd"),TestDataInMap.get("wfName"),TestDataInMap.get("wfDes"),TestDataInMap.get("wfCategory"),
				prop.getProperty("WFWithConfigParam"),TestDataInMap.get("priority"),TestDataInMap.get("expTime"),TestDataInMap.get("maxTime"),TestDataInMap.get("cleanUpHrs"),TestDataInMap.get("manExeTime"),TestDataInMap.get("tUnit"),prop.getProperty("WFWithUpdatedCredAndCredPoolParam"),
				TestDataInMap.get("ParamValue"),TestDataInMap.get("CrdentailParam1"),TestDataInMap.get("CrdentailParam2"));
		//workflowlistpageta.validateUpdateWFCredAndCredpool("KG_Private3","For Private Purpose","KG3","Pune@1234","WFUpdateConfigCredParam","For update config cred parameter","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\WFWithConfigParam.zip","High","5",
				//"10","1","1","Hours","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\UpdateCredandCredPoolParam_v1.zip","KG_Private3", "AE1","KG_Private2");
		extentTest.log(extentTest.getStatus(), "update workflow uses config parameter as credentials and credential pool is updated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//Regression Test case need to add these in closure activites
	/*@Test(priority=600)
	public void validateDeleteCredentialWFTest(Method method) throws Exception {
		extentTest = extent.createTest("validateDeleteCredentialWFTest", "TC_113: To verify delete pool credentials used in worfklow");
		//Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateDeleteCredentialWF("WFConfigParamCred","KG_Private2");
		extentTest.log(extentTest.getStatus(), "To verify delete pool credentials used in worfklow is verified successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	//Need to update the test case need a workflow for it.
	/*@Test(priority=342)
	public void validateImportWFConfigCredCredpoolandRunParamTest(Method method) throws Exception {
		extentTest = extent.createTest("validateImportWFConfigCredCredpoolandRunParamTest", "TC_57: Verify Publish PS workflow with config (Credential pool and indivisual credentials)+Run time parameter");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		workflowlistpageta = new WorkflowListPageTA(); 
		workflowlistpageta.validateImportWFConfigCredCredpoolandRunParam("WFConfigRunParameter","For config cred parameter and runtime parameter","Default","C:\\Users\\DELL\\Downloads\\AE_Automation_UploadFiles\\WFConfigCredRunParam_v1.zip","High","5",
				"10","1","1","Hours","KG_Private2", "AE1");
		extentTest.log(extentTest.getStatus(), "update workflow uses config parameter as credentials and credential pool is updated successfully");  
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
    /*	//For Workflow Name
	@Test
	public void validateAdvSearchForWFNameEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFNameEqualTo("Name","equal to","Sanity1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	/*@Test
	public void validateAdvSearchForWFNameNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFNameNotEqualTo("Name", "not equal to","Sanity1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFNameIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFNameIsLike("Name", "is like","Param","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFNameBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFNameBeginsWith("Name", "begins with","WF","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFNameEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFNameEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFNameEndsWith("Name", "ends with","Param","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	//For Workflow Category
	@Test
	public void validateAdvSearchForWFCategoryEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFCategoryEqualTo("Category","equal to","Default","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFCategoryNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFCategoryNotEqualTo("Category", "not equal to","Default1","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFCategoryIsLikeTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryIsLikeTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFCategoryIsLike("Category", "is like","fault","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFCategoryBeginsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryBeginsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFCategoryBeginsWith("Category", "begins with","De","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateAdvSearchForWFCategoryEndsWithTest(Method method) throws Exception {
		extentTest = extent.createTest("validateAdvSearchForWFCategoryEndsWithTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateAdvSearchForWFCategoryEndsWith("Category", "ends with","fault","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Workflow Category is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}

	//For Created [Calender]
	@Test
	public void validateCreatedEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateCreatedEqualToTest", "TC_003: To Verfiy Advance search for Tenant name with is like criteria and Created in between criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateCreatedEqualTo("exact date","2022","Jul","6","50");
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
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateCreatedBefore("before","2022","Jul","27","50");
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
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateCreatedAfter("after","2022","Jul","6","50");
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
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateCreatedInBetween("in between","2022","Jul","6","2022","Aug","1","50");
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
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateCreatedNotInBetween("not in between","2022","Jul","30","2022","Aug","1","50");
		//	tenantspage.validateAdvSearchOrgEndsWithCreatedNotBetween(TestDataInMap.get("TenantName"), TestDataInMap.get("Description"),TestDataInMap.get("OrganizationCode"),
		//	TestDataInMap.get("AdvSearchFor"),TestDataInMap.get("CreatedYear"),TestDataInMap.get("CreatedMonth"),TestDataInMap.get("CreatedDate"),
		//	TestDataInMap.get("CreatedEndYear"),TestDataInMap.get("CreatedEndMonth"),TestDataInMap.get("CreatedEndDate"));
		extentTest.log(extentTest.getStatus(), "Advance search for Tenant names is like and created in between criteria validated successfully");
		//ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	// For Workflow Status 
	@Test
	public void validateStatusDropdownEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateStatusDropdownEqualTo("Status", "equal to","Active","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}
	@Test
	public void validateStatusDropdownNotEqualToTest(Method method) throws Exception {
		extentTest = extent.createTest("validateStatusDropdownNotEqualToTest", "TC_009: To Verfiy Advance search for Org Code and created date with equals criteria");
		//	Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("sheetname"),method.getName());
		workflowlistpageta=new WorkflowListPageTA();
		workflowlistpageta.validateStatusDropdownNotEqualTo("Status", "not equal to","Active","50");
		extentTest.log(extentTest.getStatus(), "Advance search for Last Name is validated successfully");
		//	ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("sheetname"), "Pass", method.getName());
	}*/
}



