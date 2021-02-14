package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	// Constructor will get automatically called after object creation, 
	//we don't have to load the excel again
	
	
	public ExcelDataProvider() throws FileNotFoundException{
		File src = new File("./TestData/Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		 try {
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file"+e.getMessage());		
		}		 
	}
	
	// if we want to provide sheet index. Method overloading on getStringData 
	public String getStringData(int Sheetindex, int row, int column) {
		// we override with the parameter name
		return wb.getSheetAt(Sheetindex).getRow(row).getCell(column).getStringCellValue();
	}
		
	public String getStringData(String sheetname, int row, int column) {
		// we override with the parameter name
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	public double getNumericData(String sheetname, int row, int column) {
		// we override with the parameter name
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	
}}
