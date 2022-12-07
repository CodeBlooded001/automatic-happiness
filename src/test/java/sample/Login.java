package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	WebDriver driver;
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
	}
	@Test(priority=1)
	public void verifyUserLoginWithValidCredential() {
	
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("yaseswiniy@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("yashu12345!");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement x = driver.findElement(By.linkText("Edit your account information"));
		Assert.assertTrue(x.isDisplayed());
	}
	
	@Test(priority=2)
	public void verifyUserLoginWithInvalidUserNameAndValidPassword() {
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("aseswiniy@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("yashu12345!");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String y = driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", y);
	}
	@Test(priority=3)
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() {

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("yaseswiniy@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("ashu12345!");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String z = driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		Assert.assertEquals(z,"Warning: No match for E-Mail Address and/or Password.");
	}
	@Test(priority=4)
	public void verifyUserLoginWithInvalidCredentials() {

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("yasswiniy@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("ashu12345!");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String a = driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", a);
	}
	@Test(priority=5)
	public void verifyUserLoginWithoutGivingCredentials() {

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String a = driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]")).getText();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", a);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
