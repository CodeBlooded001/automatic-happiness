package cross_Browser;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MultiBrowser {
	
	public WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		driver.get("https://demoqa.com/");
	}
	@Test
	public void click_Carousel() throws InterruptedException {
		
		WebElement carousel = driver.findElement(By.xpath("//img[@class='banner-image']"));
		carousel.click();
		Thread.sleep(3000);
	}
	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
