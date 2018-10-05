package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class TestUtil {
	
	public final static int RESPONSE_CODE_200 = 200;

	static Workbook book;
	static Sheet sheet;
	
	public static String TESTDATAPATH = "C:/Users/AMMA/workspace/Learning/src/testdatapackage/LoginTest.xlsx";
	/**
	 * Initializes Data File
	 */
	protected void initialize()
	{
		
		try 
		{
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static Object [][] GetTestData(String SheetName) throws InvalidFormatException{
		FileInputStream file = null;
		try{
			file = new FileInputStream(TESTDATAPATH);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book = WorkbookFactory.create(file);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(SheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i =0; i< sheet.getLastRowNum();i++)
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
					data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				
		return data;
	}

	public static Object [][] arrayExcelData(String SheetName) throws InvalidFormatException{
		FileInputStream file = null;
		try{
			file = new FileInputStream(TESTDATAPATH);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book = WorkbookFactory.create(file);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(SheetName);
		Object[][] arrayExcelData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i =0; i< sheet.getLastRowNum();i++)
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
				
				arrayExcelData[i][k]=sheet.getRow(i+1).getCell(k).toString();
				
		 
		return arrayExcelData;
	}

/**
 * Reads excel sheet data, returns the value of the cell specified by row
 * number and column number in a sheet.
 * 
 * @param sheetName
 *            name of the sheet
 * @param rowNum
 *            row number
 * @param colNum
 *            column number
 * @return data string
 * @throws IOException 
 * @throws InvalidFormatException 
 */
public static String getExcelData(String sheetName, int rowNum, int colNum) throws InvalidFormatException, IOException
{
	String cellValue = null;
	FileInputStream file = null;
	file = new FileInputStream(TESTDATAPATH);
	book = WorkbookFactory.create(file);
	try 
	{
		
		if (book == null)
		{
			// initialize();
		}
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell column = row.getCell(colNum);
		cellValue = column.getStringCellValue();
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	return cellValue;
}
public static void writeToExcel(String sheetName, int rowNum, int colNum, String desc)
{
	FileInputStream fis = null;
	FileOutputStream fos = null;
	try
	{
		fis = new FileInputStream(TESTDATAPATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetName);
		Row r = s.getRow(rowNum);
		Cell c = r.createCell(colNum);
		c.setCellValue(desc);
		fos = new FileOutputStream(TESTDATAPATH);
		wb.write(fos);
		fos.close();
	} 
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
		try
		{
			fis.close();
			fos.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

}