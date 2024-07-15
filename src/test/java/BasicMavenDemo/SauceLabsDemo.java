package BasicMavenDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * Example of running a TestNG test without using Sauce Bindings.
 */
public class SauceLabsDemo {
    protected RemoteWebDriver driver;

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username","oauth-apoorvanayal5-0709b");
        sauceOptions.setCapability("access_key","c897da31-50a8-4dd0-8f94-9517f2d14a2f");
        sauceOptions.setCapability("name", "test1");
        sauceOptions.setCapability("build", "Build 1.0");
        sauceOptions.setCapability("browserVersion", "latest");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("sauce:options", sauceOptions);
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com/wd/hub");

        driver = new RemoteWebDriver(url, options);
    }

    @Test
	public void googlesearch() {
		// TODO Auto-generated method stub
    	System.out.println("Test started");
		driver.get("http://www.google.com");
		WebElement a= driver.findElement(By.xpath("//div/textarea[@title='Search']"));
		a.sendKeys("Selenium tutorial");
		driver.findElement(By.xpath("//img[contains(@src,'/googlelogo_color_272x92dp.png')]")).click();
		WebElement b= driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(b));
		b.click();
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
    public void close()
    {
    	driver.close();
    	driver.quit();
    	System.out.println("Test completed successfully");
    }
}