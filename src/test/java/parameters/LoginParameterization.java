package parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginParameterization {
	WebDriver driver;
	@BeforeMethod
	@Parameters("url")
	public void setUp(String URL) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
	}
	@Test
	@Parameters({"email","password"})
	public void LoginParams(String EMAIL, String PASSWORD) {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(EMAIL);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement x = driver.findElement(By.linkText("Edit your account information"));
		Assert.assertTrue(x.isDisplayed());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
