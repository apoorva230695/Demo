package BasicMavenDemo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

public class MavenDemo {
	
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
	public void googlesearch() {
		// TODO Auto-generated method stub
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		WebElement a= driver.findElement(By.xpath("//div/textarea[@title='Search']"));
		a.sendKeys("Selenium tutorial");
		driver.findElement(By.xpath("//img[contains(@src,'/googlelogo_color_272x92dp.png')]")).click();
		WebElement b= driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(b));
		b.click();
	}
	
	@AfterTest
    public void close()
    {
    	driver.close();
    	driver.quit();
    	System.out.println("Test completed successfully");
    }
	
}
