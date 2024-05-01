import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class DownloadedDocuments {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "/Users/camdenawright/4830/workspace4830/workspace4830-Wright/Testing/project_webapp_testing1/lib/mac/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testDownloadedDocuments() throws Exception {
    driver.manage().window().maximize();
    driver.get("http://ec2-3-95-26-219.compute-1.amazonaws.com:8000/");
	Thread.sleep(1000);
    driver.findElement(By.id("navbarDropdown")).click();
	Thread.sleep(1000);
    driver.findElement(By.linkText("All Subjects")).click();
	Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Subjects'])[2]/following::a[1]")).click();
	Thread.sleep(1000);
    driver.findElement(By.linkText("Algebra")).click();
	Thread.sleep(1000);
    driver.findElement(By.linkText("LinearAlgebraHW3_Schaap_Fh8N7Ul.pdf")).click();
	Thread.sleep(5000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  @SuppressWarnings("unused")
  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  @SuppressWarnings("unused")
  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @SuppressWarnings("unused")
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
