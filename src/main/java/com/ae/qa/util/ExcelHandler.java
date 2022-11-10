package com.ae.qa.util;


import java.util.Map;
import java.util.TreeMap;

import com.ae.qa.base.TestBase;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


public class ExcelHandler extends TestBase
{
	public static void UpdateTestResultsToExcel(String sheetName,String tcStatus,String testCaseName)
	{
		Connection conn=null;
		Fillo fillo =new Fillo();
		try{
			conn=fillo.getConnection(prop.getProperty("testdatafilepath"));
			String query=String.format("UPDATE %s SET TestCaseStatus='%s' where TestCaseName='%s'", sheetName,tcStatus,testCaseName);
			conn.executeUpdate(query);
		} catch(FilloException e){
			e.printStackTrace();
		}		
	}
	public static Map<String,String> getTestDataInMap(String sheetName,String testCaseName) throws Exception
	{
		Map<String,String> TestDataInMap=new TreeMap<String,String>();		
		String query=null;
		query=String.format("SELECT * FROM %s WHERE Run='Yes' and TestCaseName='%s'",sheetName,testCaseName);
		//query="select *from TenantsDetails";
		Fillo fillo=new Fillo();
		Connection conn=null;
		Recordset recordset=null;
		try
		{
			conn=fillo.getConnection(prop.getProperty("testdatafilepath"));
			recordset=conn.executeQuery(query);
			while(recordset.next())
			{
				for(String field:recordset.getFieldNames())
				{
					TestDataInMap.put(field, recordset.getField(field));
					//System.out.println(recordset.getField("TenantName")+""+recordset.getField("Description")+""+recordset.getField("OrganizationCode"));
				}
			}
		}
		catch(FilloException e)
		{
			e.printStackTrace();
			throw new Exception("Test data cannot find . . .");			
		}
		recordset.close();
		conn.close();
		return TestDataInMap;		
	}
/*	public static void main(String args[]) throws Exception {
		getTestDataInMap("TenantsDetails","validateAddNewTenant");
	}*/
}
