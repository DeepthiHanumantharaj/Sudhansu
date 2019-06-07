package com.Com_Cast.vtiger.genericLib;
/**
 * provides generic method to fetch data from properties file and excel sheet
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	/**
	 * Get the data from properties file 
	 * @throws Throwable 
	 */
public String getPropertyKeyValue(String key) throws Throwable {
	/**
	 * pass the key in argument and Read the data
	 * Returns value based on key
	 */
	
FileInputStream fis = new FileInputStream(".//Data//Data.properties");
Properties pObj = new Properties();
         pObj.load(fis);
 String value = pObj.getProperty(key);	
	return value;
}

public String getExcelSheetData(String sheetname, int rownum, int cellnum) throws Throwable {
	/**
	 * pass sheetname, Rownum ,cell numb in argument
	 * returns the value from specific cell
	 */
	FileInputStream fis = new FileInputStream(".//Data//Testdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet( sheetname);
	 Row rw = sh.getRow(rownum);
	 Cell cel = rw.getCell(cellnum);
	 String data = cel.getStringCellValue();
	 wb.close();
	return data;		
}


public void setExcelSheetData(String sheetname,int rownum,int cellnum,String data) throws Throwable {
	/**
	 * pass sheetname,row num,cell num in arguement
	 * writes the data to the cell
	 */
	FileInputStream fis = new FileInputStream(".//Data//Testdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet( sheetname);
	 Row rw = sh.getRow(rownum);
	 Cell cel = rw.createCell(cellnum);
	 cel.setCellValue(data);
	FileOutputStream fos = new FileOutputStream(".//Data//Testdata.xlsx");
	wb.write(fos);
	wb.close();
}


}
