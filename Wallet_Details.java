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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
public class Wallet_Details {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  private Map<String, Object> vars;
  public void BasePage(WebDriver driver) {
		this.driver = driver;
	}
  

  @Before
  public void setUp() throws Exception {
	  js = (JavascriptExecutor) driver;
	  vars = new HashMap<String, Object>();
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--remote-allow-origins=*");
	  options.addArguments("--disable-notifications");
	  driver = new ChromeDriver(options);
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	 
  }
  
  
  //Login-Add to cart 
  @Test
  public void Wallet_Balance() throws Exception {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
    driver.get("https://haris-7kav.yelo.red/en/");
    driver.manage().window().maximize();
    
    // wallet-balance and SS
    
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-user-o']"))).click(); //clicking in user image
    
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-location/div/app-header/div[2]/div/div/div/app-login/div/div/div/form[1]/div[1]/app-phone-email-hybrid/form/div/input"))).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-location/div/app-header/div[2]/div/div/div/app-login/div/div/div/form[1]/div[1]/app-phone-email-hybrid/form/div/input"))).sendKeys("random4576@yopmail.com");
    Thread.sleep(10);
    wait.until(ExpectedConditions.elementToBeClickable(By.id("siPassword"))).clear();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("siPassword"))).sendKeys("123456");
    wait.until(ExpectedConditions.elementToBeClickable(By.name("login"))).click();
    this.takeSnapShot(driver, "C:\\Users\\ansul\\Desktop\\Test\\2.png");
    Thread.sleep(3000);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-user ng-tns-c6-0 ng-star-inserted']"))).click();
    Thread.sleep(9000);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-location/div/app-header/div[1]/div/div[2]/ul/li[3]/ul/li[5]/a"))).click();

    
    this.takeSnapShot(driver, "C:\\Users\\ansul\\Desktop\\Test\\1.png");
    
    
    
    
    
    
    
    /*
    //Login-Logout-Add to Cart
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fetchLocation']/div/div/div/form/div/div/div[2]/button/span"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='listviewscroll']/div[3]/div/div/div/div[2]/div/p[2]"))).click();
    this.takeSnapShot(driver, "C:\\Users\\ansul\\Desktop\\Test\\3.png");
    Thread.sleep(10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mb-5 p-detail-sec pad-t-0 f-w-b']//div[3]"))); // Always try to follow this type of xpath written in the format 
    WebElement Ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mb-5 p-detail-sec pad-t-0 f-w-b']//div[3]")));
    jsClick(Ele);
    WebElement El2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Checkout']/ancestor::button")));
    jsClick(El2);
    Thread.sleep(20);
    this.takeSnapShot(driver, "C:\\Users\\ansul\\Desktop\\Test\\4.png");
   
    
    WebElement El4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-layout/div/div/app-checkout/div/div/div/div[2]/div[1]/form/div/div/div/div/div/app-delivery-address/div/div[2]/div[2]/fav-location-model/div/div[2]/div[2]/div[2]/button")));
    jsClick(El4);
    this.takeSnapShot(driver, "C:\\Users\\ansul\\Desktop\\Test\\3.png");
    
    */
   
    driver.close();
    
  }
   


  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
	//Convert web driver object to TakeScreenshot
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	//Call getScreenshotAs method to create image file
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	//Move image file to new destination
	File DestFile=new File(fileWithPath);
	//Copy file at destination
	FileUtils.copyFile(SrcFile, DestFile);
	}
  public void waitForElementToVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
  public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
  public void click(WebElement element) {
		waitForElementToClickable(element);
		element.click();
	}
  public void waitForElementToClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

  public void scrollDown() {
		js.executeScript("window.scrollBy(0,250)");
	}
  public void scrollToElement(WebElement element) throws InterruptedException {
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
  public  void clickWithJS(WebElement element) {
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	    js.executeScript("arguments[0].click();", element);
	}
}
