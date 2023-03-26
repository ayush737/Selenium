package qwert.inte;

import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

public class Qw {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  private Map<String, Object> vars;
  @Before
  public void setUp() throws Exception {
	  js = (JavascriptExecutor) driver;
	  vars = new HashMap<String, Object>();
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  options.addArguments("--disable-notifications");
	  options.
	  driver = new ChromeDriver(options);
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	 
  }

  @Test
  public void testUntitledTestCase() throws Exception {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("https://hsajd.yelo.red/en/");
    driver.manage().window().maximize();
    FileInputStream fs = new FileInputStream("C:\\Users\\ansul\\Desktop\\book2.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fs);
    //Signup
    /*
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-user-o']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='col-xs-6 text-left'] a[class='pointer']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sFname"))).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form[id='signViaOtp'] input[placeholder='Phone Number']"))).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sEmail1"))).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sPassword"))).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sFname"))).sendKeys("Test");
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form[id='signViaOtp'] input[placeholder='Phone Number']"))).sendKeys("987654322");
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sEmail1"))).sendKeys("random2@yopmail.com");
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sPassword"))).sendKeys("123456789");
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[name='Register']"))).click();
    Thread.sleep(50);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-user ng-tns-c6-0 ng-star-inserted']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fetchLocation']/div/div/div/form/div/div/div[2]/button/span"))).click();
    
    */
    
    
    
    
    
    //Login-Logout-Add to Cart
   
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-user-o']"))).click(); //clicking in user image
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']"))).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']"))).sendKeys("random@yopmail.com");
    Thread.sleep(10);
    wait.until(ExpectedConditions.elementToBeClickable(By.id("siPassword"))).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("siPassword"))).sendKeys("12345678");
    wait.until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();
    Thread.sleep(30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-user ng-tns-c6-0 ng-star-inserted']"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fetchLocation']/div/div/div/form/div/div/div[2]/button/span"))).click();
    Thread.sleep(10);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='listviewscroll']/div[3]/div/div/div/div[2]/div/p[2]"))).click();
    WebElement element = driver.findElement(By.xpath("//*[local-name()='svg']"));
    
    //wait.until(ExpectedConditions.elementToBeClickable()).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cart-fix']/div/button"))).click();
    
    
     /*
    //Login via Google 
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-user-o']"))).click(); //clicking in user image
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']"))).clear();
    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='fbSignin']"))).click();
    String originalWindow = driver.getWindowHandle();
    assert driver.getWindowHandles().size() == 1;
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='fbSignin']"))).click();
    for (String windowHandle : driver.getWindowHandles()) {
        if(!originalWindow.contentEquals(windowHandle)) {
            driver.switchTo().window(windowHandle);
            break;
        }
    }
    // window handles iterate
    System.out.println("Page title of popup: "+ driver.getTitle());
    // switching pop up tab
    driver.close();
    Thread.sleep(60);
    driver.switchTo().window(originalWindow);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']"))).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']"))).sendKeys("random@yopmail.com");
    Thread.sleep(10);
    wait.until(ExpectedConditions.elementToBeClickable(By.id("siPassword"))).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("siPassword"))).sendKeys("12345678");
    wait.until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();
    Thread.sleep(600);
    
    */
    
    
    
    /*Writting output in sheets
    XSSFSheet sheet = workbook.getSheetAt(0);
    Row row = sheet.getRow(0);
    Cell cell = row.getCell(0);
    System.out.println(sheet.getRow(0).getCell(0));
    Row row1 = sheet.getRow(1);
    Cell cell1 = row1.getCell(1);
    System.out.println(sheet.getRow(0).getCell(1));
    Row row2 = sheet.getRow(1);
    Cell cell2 = row2.getCell(1);
    System.out.println(sheet.getRow(1).getCell(0));
    Row row3 = sheet.getRow(1);
    Cell cell3 = row3.getCell(1);
    System.out.println(sheet.getRow(1).getCell(1));
    */
    
    driver.close();
    
    
    
    
    
    
    
    
    
    
    
    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']"))).click();
    //wait.until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();
    //wait.until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();
    
  }

  @After
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
  public  void clickWithJS(WebElement element) {
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
}
