package com.ae.qa.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.ae.qa.base.TestBase;
import com.ae.qa.pagesTenantAdmin.LoginPageTA;

public class TestUtil extends TestBase {
	public LoginPageTA loginpageta = new LoginPageTA();
//	public WebDriverWait wait = new WebDriverWait(driver,70);
	public static long IMPLICIT_WAIT = 1200;
	public static long PAGE_LOAD_TIMEOUT = 1260;
	public static final int BUFFER_SIZE = 4096;

	@FindBy(id = "change-pswd")
	WebElement changePswdTab;
	@FindBy(id = "oldpswd")
	WebElement oldPswd;
	@FindBy(id = "newpswd")
	WebElement newPswd;
	@FindBy(id = "confirmpswd")
	WebElement newConfirmPswd;
	@FindBy(xpath = "//button[text()='Change']")
	WebElement changeBtn;
	
	public void switchToFrame() {
		driver.switchTo().frame("xyz");
	}

	public void ChangePasswordAfterLogin(String TAUser,String OldPswd,String NewPswd,String CnfPswd) throws Exception {
		loginpageta.login(TAUser,OldPswd);
		Reporter.log("User log in successfully",true);
		Thread.sleep(5000);
		oldPswd.sendKeys(OldPswd);
		Thread.sleep(1000);
		newPswd.sendKeys(NewPswd);
		Thread.sleep(1000);
		newConfirmPswd.sendKeys(CnfPswd);
	//	wait.until(ExpectedConditions.elementToBeClickable(changeBtn));
		Thread.sleep(4000);
		changeBtn.click();
		Thread.sleep(3000);
	}
	  public static void unzip(String zipFilePath, String destDirectory) throws IOException {
	        File destDir = new File(destDirectory);
	        if (!destDir.exists()) {
	            destDir.mkdir();
	        }
	        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
	        ZipEntry entry = zipIn.getNextEntry();
	        // iterates over entries in the zip file
	        while (entry != null) {
	            String filePath = destDirectory + File.separator + entry.getName();
	            if (!entry.isDirectory()) {
	                // if the entry is a file, extracts it
	                extractFile(zipIn, filePath);
	            } else {
	                // if the entry is a directory, make the directory
	                File dir = new File(filePath);
	                dir.mkdirs();
	            }
	            zipIn.closeEntry();
	            entry = zipIn.getNextEntry();
	        }
	        zipIn.close();
	    }
	    /**
	     * Extracts a zip entry (file entry)
	     * @param zipIn
	     * @param filePath
	     * @throws IOException
	     */
	    public static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
	        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
	        byte[] bytesIn = new byte[BUFFER_SIZE];
	        int read = 0;
	        while ((read = zipIn.read(bytesIn)) != -1) {
	            bos.write(bytesIn, 0, read);
	        }
	        bos.close();
	    }
	    
	    public static String getTextFromTextFile() {
		      //FilePath
	String sFilePath = "C:\\Users\\kalyanig\\Downloads\\AE_Automation_UploadFiles\\oauth-authorization-server.json";
		      //Creating FileReader object
	FileReader fr = null;
		      //Creating BufferedReader object
	BufferedReader txtReader  = null;
		      //Handling Exception using Try-Catch
		      String sCurrentLine = null;
		      StringBuilder sb=new StringBuilder();
		      try {

		         fr =  new FileReader(sFilePath);
		         txtReader = new BufferedReader(fr);
		         //Reading file until file is null
		         while ((sCurrentLine = txtReader.readLine()) != null) {
		           System.out.println(sCurrentLine); 
		           sb.append(sCurrentLine);
		           }
		         return sb.toString();
		         
		      } catch (IOException e) {
		             e.printStackTrace();
		        } finally {
		         try {
		          if (txtReader != null)txtReader.close();
		         } catch (IOException ex) {
		          ex.printStackTrace();
		         }   }
		       return sCurrentLine;
		       }	
}
	

	   
	//public static String TESTDATA_SHEET_PATH = "C:\\Users\\Kalyani\\eclipse-workspace\\AutomationEdgePortal_5.5.0\\src\\main\\java\\com\\ae\\qa\\testdata\\TestData_5.5.0.xlsx";

	//static Workbook book;
	//static Sheet sheet;

	/*public static Object[][] getTestData(String sheetName, String methodName) {
		List<String> ret = new ArrayList();
		List<String> rowDataList = new ArrayList<String>();
		FileInputStream file = null;
		System.out.println(methodName);
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		int firstRowNum = sheet.getFirstRowNum();
		int lastRowNum = sheet.getLastRowNum();
		System.out.println("firstRowNum:" + firstRowNum);
		System.out.println("lastRowNum:" + lastRowNum);
	//	Object[] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = firstRowNum + 1; i <= lastRowNum; i++) {
			Row row = sheet.getRow(i);
			int firstCellNum = row.getFirstCellNum();
			int lastCellNum = row.getLastCellNum();
			System.out.println("firstCellNum:" + firstCellNum);
			System.out.println("lastCellNum:" + lastCellNum);
			if ((row.getCell(firstCellNum).getStringCellValue()).equals(methodName)) {
				System.out.println("Matched");
				for (int j = firstCellNum; j < lastCellNum; j++) {
					String cellvalue = row.getCell(j).getStringCellValue();
					rowDataList.add(cellvalue);
				}
				System.out.println(ret);
			}
		}
		Object[] itemsArray = new String[rowDataList.size()];
		itemsArray = rowDataList.toArray(itemsArray);
		for (Object s : itemsArray)
			System.out.println("Data:" + s);
		Object[] itemsArray2=Arrays.copyOfRange(itemsArray, 1, 4);
		for (Object sc : itemsArray2) {
			System.out.println("Data Excract:" + sc);
		}
		return itemsArray2;
	}*/
 /*  public static Object[][] getTestData(String filePath, String sheetName) {
			FileInputStream file=null;
					try {
						file=new FileInputStream(filePath);
					} catch(FileNotFoundException e) {
					e.printStackTrace();
		             } 
					try {
					book= WorkbookFactory.create(file);
					}catch(InvalidFormatException e) {
				        e.printStackTrace();
		            }
					catch(IOException e) {
				        e.printStackTrace();
		            }
					sheet=book.getSheet(sheetName);
					Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
					for(int i=0;i<sheet.getLastRowNum();i++) {
						Row row = sheet.getRow(i);
						int firstCellNum = row.getFirstCellNum();//0
						int lastCellNum = row.getLastCellNum();//4
						System.out.println("firstCellNum = " + firstCellNum);
						System.out.println("lastCellNum = " + lastCellNum);
						for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
							data[i][j]=sheet.getRow(i+1).getCell(j).toString();
							//data[i][j]=sheet.getRow(i+1).getCell(j);
							}
					}
					return data;
	 }*/
	/* public static ExcelApiTest eat = null;
	 public Object[][] testData(String xlFilePath, String sheetName) throws Exception
	   
	 {
	        Object[][] excelData = null;
	        eat = new ExcelApiTest(xlFilePath);
	        int rows = sheet.getRowCount(sheetName);
	        int columns = sheet.getColumnCount(sheetName);
	                
	        excelData = new Object[rows-1][columns];
	        
	        for(int i=1; i<rows; i++)
	        {
	            for(int j=0; j<columns; j++)
	            {
	                excelData[i-1][j] = sheet.getCellData(sheetName, j, i);
	            }
	            
	        }
	        return excelData;
	    }
*/
/*	public static XSSFWorkbook excelWorkbook = null;
	public static  XSSFSheet excelSheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	public static WebDriver driver = null;
   public static Object[][] getTestData(String fileName,String sheetName) throws IOException 
	{
		FileInputStream fis = new FileInputStream(fileName); // Your .xlsx file name along with path
		excelWorkbook = new XSSFWorkbook(fis);
		// Read sheet inside the workbook by its name
		excelSheet = excelWorkbook.getSheet(sheetName); //Your sheet name
		// Find number of rows in excel file
		System.out.println("First Row Number/index:"+ excelSheet.getFirstRowNum() + " *** Last Row Number/index:"
				+ excelSheet.getLastRowNum());
		int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum()+1;
		int colCount = excelSheet.getRow(0).getLastCellNum();
		System.out.println("Row Count is: " + rowCount
				+ " *** Column count is: " + colCount);
		Object data[][] = new Object[rowCount-1][colCount];
		for (int rNum = 2; rNum <= rowCount; rNum++) 
		{
			for (int cNum = 0; cNum < colCount; cNum++) 
			{
				System.out.print(getCellData(sheetName, cNum, rNum) + " "); // Your sheet name
				data[rNum - 2][cNum] = getCellData(sheetName, cNum, rNum); //Your sheet name
			}
			System.out.println();
		}
		return data;
	}
   public static String getCellData(String sheetName, int colNum, int rowNum) 
	{
		try
		{
			if (rowNum <= 0)
				return "";
			int index = excelWorkbook.getSheetIndex(sheetName);
			if (index == -1)
				return "";
			excelSheet = excelWorkbook.getSheetAt(index);
			row = excelSheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| cell.getCellType() == Cell.CELL_TYPE_FORMULA)
			{
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e)
		{
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum
					+ " does not exist in xls";
		}
	}
}*/
