package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Sample {
	String excelfilePath;
	File excelFile;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	@Test
	public void m1() throws IOException {

		excelfilePath = System.getProperty("user.dir") + "\\files\\employees.xlsx";
		excelFile = new File(excelfilePath);
		/*
		 * Actual we must use try catch block but for now I'm handling Exception using
		 * FileNotFoundException
		 */
		fis = new FileInputStream(excelFile);

		workbook = new XSSFWorkbook(fis);

		// one way --->workbook.getSheetAt(0);
		// second way --->workbook.getSheet("One");

		sheet = workbook.getSheetAt(0);

		/*
		 * System.out.println(sheet.getLastRowNum());//prints 5
		 * System.out.println(sheet.getPhysicalNumberOfRows());//prints 6
		 */
		int rows = sheet.getPhysicalNumberOfRows();
		// System.out.println(sheet.getRow(0).getLastCellNum()); // prints 6
		int cols = sheet.getRow(0).getLastCellNum();
		
		for(int r=0;r<rows;r++) {
			row = sheet.getRow(r);
			
			for(int c=0;c<cols;c++) {
				cell = row.getCell(c);
				//to get the cell type
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
					
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
		
					break;
					
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
				
					break;
				
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
		workbook.close();
	}
}
