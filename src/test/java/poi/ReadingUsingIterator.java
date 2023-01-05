package poi;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadingUsingIterator {
	File file;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Iterator<Row> rows;
	@Test
	public void m1() throws IOException {
		
		String filePath = System.getProperty("user.dir")+"\\files\\employees.xlsx";
		file = new File(filePath);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		
		sheet = workbook.getSheetAt(0);
		//sheet is having a method known as iterator method
		Iterator<Row> rows = sheet.iterator();
		
		while(rows.hasNext()) {
			// we need not know no.of rows and no.of columns directly we can get rows.
			Row row = rows.next(); 
			Iterator<Cell> cells = row.iterator();
			
			while(cells.hasNext()) {
				
				Cell cell = cells.next(); //will give you the cell
				
				CellType cellType = cell.getCellType();
				
				switch (cellType) {
				case STRING:
					
					System.out.print(cell.getStringCellValue());
					
					break;
				case NUMERIC:
					//converting decimal values into int
					System.out.print((int)cell.getNumericCellValue());
					
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
