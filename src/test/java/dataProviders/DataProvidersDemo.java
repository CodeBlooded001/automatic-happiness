package dataProviders;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvidersDemo {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
	}

	@Test(dataProvider = "getTestData", dataProviderClass = SampleProvider.class)
//	public void verifyLogin(String email, String password) throws InterruptedException {
		public void verifyLogin(String[] str) throws InterruptedException {
		
		  driver.findElement(By.id("input-email")).sendKeys(str[0]);
		  driver.findElement(By.id("input-password")).sendKeys(str[1]);
		 
		/*
		 * driver.findElement(By.id("input-email")).sendKeys("yaseswiniy@gmail.com");
		 * driver.findElement(By.id("input-password")).sendKeys("yashu12345!");
		 */
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(3000);
		System.out.println("Login Successful");
	}
	
	@Test(dataProvider = "supplierOne",dataProviderClass = SampleProvider.class)
	public void demoSupplyData(String[] str) {
		System.out.println(str[0] +" " +str[1]);
	}

	/*
	 * @DataProvider(name="getTestData") public String[][] dataSupplier() {
	 * String[][] data = {{"yaseswini@gmail.com","yashu12345!"},
	 * {"yashu@gmail.com","12345"}, {"yashu11@gmail.com","12345"}}; return data; }
	 */
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
