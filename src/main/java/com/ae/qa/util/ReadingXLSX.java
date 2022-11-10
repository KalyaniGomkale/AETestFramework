package com.ae.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingXLSX {
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	//public static int columnName(String a) throws Exception {
public static void main(String args[]) throws Exception {
	    int coefficient = 0;
	    File src= new File ("C:\\Users\\Kalyani\\eclipse-workspace\\AutomationEdgePortal_5.5.0\\src\\main\\java\\com\\ae\\qa\\testdata\\TestData_5.5.0.xlsx"); // or specify the path directly
	    FileInputStream fis = new FileInputStream(src);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet sh = wb.getSheet("TenantsDetails");
	    XSSFRow row = sh.getRow(3);
	    int rows=sh.getLastRowNum();
	   System.out.println(rows);
	    
	//    System.out.println(Column);
	    for (int i = 1; i <=rows; i++) {
	    	int Column = sh.getRow(i).getLastCellNum();
	  if ((row.getCell(0).getStringCellValue()).equals("validateAddTenantDetails")) {
	      coefficient = i;
	           
	            for (int j = 0; j <Column; j++) {  
	            	System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
	        }
	    }
	}
	/*
public static void main(String args[]) throws Exception {
	ReadingXLSX.columnName("validateAddNewTenant");
}*/
}
}
