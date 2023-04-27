package com.tutorialninja.qa.testData;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.DataProvider;

public class SupplyTestData {
	
	public static FileInputStream ip;
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;

	@DataProvider(name = "TutorialNinjaDataProviderSupply")
	
	public static Object[][] dataSupplyFrom2DimensionalArray() {
		
		Object[][] data = {{"nshaheen973@gmail.com", "Selenium@123"},
				           {"jamestravor23@gmail.com", "James@123"},
				           {"smita23@gmail.com", "Smita@123"},
				           {"seleniumpanda@gmail.com", "Selenium@123"}};
		
		return data;
		    
		}
	@DataProvider(name = "NinjaTutorialExcelDataWithDataProvider")
	
	public static Object[][] excelSheetDataSupply() throws Exception {
		Object[][] data = SupplyTestData.getNinjaTutorialTestDataFromExcelSheet("Login");
		return data;
	}
	
	public static Object[][] getNinjaTutorialTestDataFromExcelSheet(String sheetName) throws Exception {
		//Ste1 - create the object of FileInputStream
		
		 ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\testData\\TutorialNinjaTestData.xls");
		
		//Step 2 - Create object of XSSFWorkbook
		
		 workbook = new HSSFWorkbook(ip);
		
		// Step 3- Create XSSFSheet
		 sheet = workbook.getSheet(sheetName);
		
		//Step 4 - Determine number of rows and columns
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int i=0 ; i<rows ; i++) {
			HSSFRow row = sheet.getRow(i+1);
			
			for(int j=0; j<cols ; j++) {
				HSSFCell cell = row.getCell(j);
				CellType celltype = cell.getCellType();
				
				switch(celltype) {
				
				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC: 
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();
					break;
				
				}
			}
		}
		
		return data;
	}
	
}
