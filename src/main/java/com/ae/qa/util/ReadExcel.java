package com.ae.qa.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static List<List<String>> readExcel()
	{
		List<List<String>> ret = new ArrayList();
		String filePath="C:\\Users\\Kalyani\\eclipse-workspace\\AutomationEdgePortal_5.5.0\\src\\main\\java\\com\\ae\\qa\\testdata\\TestData_5.5.0.xlsx";
		String sheetName="TenantsDetails";
		if(filePath!=null && !"".equals(filePath.trim()) && sheetName!=null && !"".equals(sheetName.trim()))
		{
			try{
				/* First need to open the file. */
				FileInputStream fInputStream = new FileInputStream(filePath.trim());
	
				/* Create the workbook object. */
				Workbook excelWookBook = new XSSFWorkbook(fInputStream);
	
				/* Get the sheet by name. */
				Sheet TenantSheet = excelWookBook.getSheet(sheetName);
				
				int firstRowNum = TenantSheet.getFirstRowNum();
				int lastRowNum = TenantSheet.getLastRowNum();
				
				System.out.println("firstRowNum = " + firstRowNum);
				System.out.println("lastRowNum = " + lastRowNum);
				
				/* Because first row is header row, so we read data from second row. */
				for(int i=firstRowNum+1; i<lastRowNum+1; i++)
				{
					Row row = TenantSheet.getRow(i);//1,2,3
					
					int firstCellNum = row.getFirstCellNum();//0
					int lastCellNum = row.getLastCellNum();//4
					
					System.out.println("firstCellNum = " + firstCellNum);
					System.out.println("lastCellNum = " + lastCellNum);
					if((row.getCell(firstCellNum).getStringCellValue()).equals("ValidateAddTenantDetails")){
					
					List<String> rowDataList = new ArrayList<String>();
					for(int j = firstCellNum; j < lastCellNum; j++)//0,1,2,3
					{
						String cellValue = row.getCell(j).getStringCellValue();
						rowDataList.add(cellValue);
						//continue;
					}
					ret.add(rowDataList);
					System.out.println(ret);
					}
				}	
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return ret;
	}
	public static void main(String args[]) {
		ReadExcel.readExcel();
	}

}
