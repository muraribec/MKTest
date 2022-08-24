package com.qa.facebook.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static Workbook book;
	public static Sheet sheet;
	public static String TEST_DATA_SHEET_PATH="D:\\workspace\\Webservice-Framework\\src\\main\\java\\com\\qa\\hubspot\\testdata\\HubSpotTestData.xlsx";
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(TEST_DATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
			
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];//[row][column]
		
		for(int i=0;i<sheet.getLastRowNum();i++){
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
				data[i][k] = sheet.getRow(i+1).getCell(k).toString(); 
			}
		}
		return data;
		
	}

}
