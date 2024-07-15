package BasicMavenDemo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

public class MavenDemo2 {
	
		WebDriver driver= null;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\apoorvanayal\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}
	
	@Test
	public void formsubmit() {
		// TODO Auto-generated method stub
		driver.get("http://file:///C:/Users/apoorvanayal/Downloads/apoorva.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("name")).sendKeys("Apoorva");
		driver.findElement(By.id("place")).sendKeys("Bareilly");
		WebElement agelist= driver.findElement(By.name("age"));
		Select select=new Select(agelist);
		select.selectByIndex(1);
		driver.findElement(By.id("DOB")).sendKeys("23061995");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@AfterTest
    public void close()
    {
    	driver.close();
    	driver.quit();
    	System.out.println("Test completed successfully");
    }
	
}
