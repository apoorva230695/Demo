package BasicMavenDemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class GoogleSearchDemo {

	private static WebDriver driver= null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter("extent.html");
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
        
		System.setProperty("webdriver.chrome.driver","C:\\Users\\apoorvanayal\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		
		ExtentTest test1= extent.createTest("Google search","This is to check google search functionality");
		test1.log(Status.INFO, "Starting test case-1");
		driver.get("http://www.google.com");
		test1.pass("Navigated to Google.com");
		driver.manage().window().maximize();
		WebElement a= driver.findElement(By.xpath("//div/textarea[@title='Search']"));
		a.sendKeys("Selenium tutorial");
		test1.pass("Entered text in searchbox");
		driver.findElement(By.xpath("//img[contains(@src,'/googlelogo_color_272x92dp.png')]")).click();
		WebElement b= driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(b));
		b.click();
		test1.pass("Clicked on Search button");
		test1.info("Test-1 completed");
		
		ExtentTest test2= extent.createTest("Google search","This is to check google search functionality");
		test2.log(Status.INFO, "Starting test case-2");
		
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		driver.findElement(By.xpath("//div[@id='rso']")).click();
		WebElement elm= driver.findElement(By.xpath("//a[@href='https://www.tutorialspoint.com/selenium/index.htm']"));
		test2.pass("Opened the Selenium tutorial link");
		jse.executeScript("arguments[0].scrollIntoView(true);", elm);
		jse.executeScript("window.scrollBy(0,-80)");
		elm.click();
		test2.pass("Clicked on the link");
	
		driver.close();
		driver.quit();
		test2.info("Test-2 completed");
		
		extent.flush();
	}

}
