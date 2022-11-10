package com.ae.qa.testcasesTenantAdmin;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.Test;
import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.DataSourcesPageTA;
import com.ae.qa.pagesTenantAdmin.ExternalAppsPageTA;
import com.ae.qa.util.ExcelHandler;
public class DataSourcesPageTestTA extends TestBase{
	DataSourcesPageTA datasourcespageta;

	public DataSourcesPageTestTA()
	{
		super();
	}

	@Test(priority=116)
	public void validateCreateDataSourcePostgresTest(Method method) throws Exception
	{
		extentTest = extent.createTest("validateCreateDataSourcePostgresTest", "TC_421:Verify user is able to create datasource");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		datasourcespageta= new DataSourcesPageTA();
		datasourcespageta.validateCreateDataSourcePostgres(TestDataInMap.get("DBType"),TestDataInMap.get("DatasourceName"),
				TestDataInMap.get("ConnectionString"),TestDataInMap.get("DBUsername"),TestDataInMap.get("DBPswd"));
		extentTest.log(extentTest.getStatus(), "User set DataSource configuration successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
	@Test(priority=187)
	public void validateDatasourcesPageTATest(Method method) throws Exception {
		extentTest = extent.createTest("validateDatasourcesPageTATest", "TC_Additional:Verify Clicking Datasources tab and checking that appropiate page is loaded");
		Map<String,String> TestDataInMap=ExcelHandler.getTestDataInMap(prop.getProperty("TAsheetname"),method.getName());
		datasourcespageta= new DataSourcesPageTA();
		datasourcespageta.validateDatasourcesPageTA(TestDataInMap.get("PageTitle"));
		extentTest.log(extentTest.getStatus(), "Datasources Page loading validated successfully");
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("TAsheetname"), "Pass", method.getName());
	}
}
