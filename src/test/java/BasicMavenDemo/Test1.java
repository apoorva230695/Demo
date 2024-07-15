package BasicMavenDemo;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

public class Test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\apoorvanayal\\Downloads\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void test1() throws Exception {
    driver.get("https://www.google.com/");
    driver.findElement(By.id("APjFqb")).clear();
    driver.findElement(By.id("APjFqb")).sendKeys("automation");
    driver.findElement(By.id("gws-output-pages-elements-homepage_additional_languages__als")).click();
    driver.findElement(By.xpath("//div[4]/center/input")).click();
    driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
    driver.get("https://www.isa.org/about-isa/what-is-automation#:~:text=The%20dictionary%20defines%20automation%20as,delivery%20of%20products%20and%20services.%E2%80%9D");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
