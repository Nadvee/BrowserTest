package JavaTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class BrowserTest {
	public WebDriver driver;
	public Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chromedriver", "‪G:\\EC\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();

	}

	@Test
	public void validLogin() throws InterruptedException {
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("btn-make-appointment")).click();
		driver.findElement(By.id("txt-username")).click();
		driver.findElement(By.id("txt-username")).sendKeys("John Doe");
		Thread.sleep(2000);
		driver.findElement(By.id("txt-password")).click();
		driver.findElement(By.id("txt-password")).click();
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		Thread.sleep(2000);
		driver.findElement(By.id("btn-login")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector(".fa-bars")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("h1")).click();
		driver.findElement(By.cssSelector("h1")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("h1")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
