package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellType;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviders_POI {
	FileInputStream fis;
	XSSFWorkbook workbook;

	@Test(dataProvider = "LoginData")
	public void login(String un, String pwd) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys(un);
		driver.findElement(By.id("input-password")).sendKeys(String.valueOf(pwd));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		Thread.sleep(3000);
//		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	}

	@DataProvider(name = "LoginData")
	public Object[][] loginDataSupply() {
		String excelPath = System.getProperty("user.dir") + "\\files\\TutorialsNinja.xlsx";
		File file = new File(excelPath);
		try {
			fis = new FileInputStream(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("Login");
		Iterator<Row> rows = sheet.iterator();

		int rowsCount = sheet.getPhysicalNumberOfRows(); // 4
		int colsCount = sheet.getRow(0).getLastCellNum(); // 2

		/*
		 Row count is actually 4 but we must take only 3
		 or it will consider headers also. rowsCount-1
		  */
		Object[][] data = new Object[rowsCount-1][colsCount]; // 3 2 

		// we must take first row not the zeroth row.
		// in zeroth row we have headings.
		for (int r = 0; r <rowsCount-1; r++) { // 3 4

			XSSFRow row = sheet.getRow(r+1); //skipping the heading and copying
			//remaining three rows

			for (int c = 0; c <colsCount; c++) {

				XSSFCell cell = row.getCell(c);

				CellType celltype = cell.getCellType();

				switch (celltype) {

				case STRING:
					data[r][c] = cell.getStringCellValue();
					System.out.println(data[r][c]);
					break;
				case NUMERIC:
					data[r][c] = (int) cell.getNumericCellValue();
					System.out.println(data[r][c]);
					break;
				case BOOLEAN:
					data[r][c] = cell.getBooleanCellValue();
					System.out.println(data[r][c]);
					break;
				default:
					break;
				}
			}
			
		}

		return data;
		
	}
	
}
