import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class RecommendedCourse {
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
  public void testRecommendedCourse() throws Exception {
    driver.manage().window().maximize();
    driver.get("http://ec2-3-95-26-219.compute-1.amazonaws.com:8000/");
	Thread.sleep(500);
    driver.findElement(By.linkText("Account")).click();
	Thread.sleep(500);
    driver.findElement(By.linkText("Login")).click();
	Thread.sleep(500);
    driver.findElement(By.id("username")).click();
	Thread.sleep(500);
    driver.findElement(By.id("username")).clear();
	Thread.sleep(500);
    driver.findElement(By.id("username")).sendKeys("Testing");
	Thread.sleep(500);
    driver.findElement(By.id("password")).clear();
	Thread.sleep(500);
    driver.findElement(By.id("password")).sendKeys("bIll#123");
	Thread.sleep(500);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(500);
    driver.findElement(By.linkText("Course Suggustion")).click();
	Thread.sleep(500);
    driver.findElement(By.id("id_suggestedCourse")).click();
	Thread.sleep(500);
    driver.findElement(By.id("id_suggestedCourse")).clear();
	Thread.sleep(1000);
    driver.findElement(By.id("id_suggestedCourse")).sendKeys("Game Design Course");
	Thread.sleep(2000);
    driver.findElement(By.id("id_suggestedCourseDescription")).click();
    driver.findElement(By.id("id_suggestedCourseDescription")).clear();
    driver.findElement(By.id("id_suggestedCourseDescription")).sendKeys("I want a course to talk about game development and game design and just a place to get cool ideas and advice on my game.");
	Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	Thread.sleep(2000);
    assertTrue(driver.getPageSource().contains("Add Post To Database"));
    driver.findElement(By.id("home")).click();
	Thread.sleep(1000);
    driver.findElement(By.linkText("Account")).click();
	Thread.sleep(1000);
    driver.findElement(By.linkText("Log Out")).click();
    Thread.sleep(2000);

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
