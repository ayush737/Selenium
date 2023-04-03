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
  public void BasePage(WebDriver driver) {
		this.driver = driver;
	}
  
  @FindBy(xpath = "//h4")
	WebElement storeName;

	@FindBy(xpath = "//div[@class='p-detail-main-div']/div[2]/div[2]/div//div[3]")
	WebElement plusIcon;

	@FindBy(xpath = "//span[text()='Checkout']/ancestor::button")
	WebElement checkoutBtn;
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
  
//Signup
  @Test
  public void Signup() throws Exception
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    driver.get("https://hsajd.yelo.red/en/");
	    driver.manage().window().maximize();
	    FileInputStream fs = new FileInputStream("C:\\Users\\ansul\\Desktop\\book2.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fs);
	    
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-user-o']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-location/div/app-header/div[2]/div/div/div/app-login/div/div/div/form[1]/div[5]/div/div[1]/p/a"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sFname"))).clear();
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form[id='signViaOtp'] input[placeholder='Phone Number']"))).clear();
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sEmail1"))).clear();
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sPassword"))).clear();
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sFname"))).sendKeys("Test");
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form[id='signViaOtp'] input[placeholder='Phone Number']"))).sendKeys("987654323");
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sEmail1"))).sendKeys("random5@yopmail.com");
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sPassword"))).sendKeys("123456789");
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[name='Register']"))).click();
	    Thread.sleep(50);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-user ng-tns-c6-0 ng-star-inserted']"))).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='fetchLocation']/div/div/div/form/div/div/div[2]/button/span"))).click();
	    
  }
  
  //Login-Add to cart 
  @Test
  public void Login() throws Exception {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get("https://hsajd.yelo.red/en/");
    driver.manage().window().maximize();
    FileInputStream fs = new FileInputStream("C:\\Users\\ansul\\Desktop\\book2.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fs); 
    
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
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='listviewscroll']/div[3]/div/div/div/div[2]/div/p[2]"))).click();
    Thread.sleep(10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='p-detail-main-div']/div[2]/div[2]/div//div[3]")));
    WebElement Ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='p-detail-main-div']/div[2]/div[2]/div//div[3]")));
    jsClick(Ele);
    WebElement El2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Checkout']/ancestor::button")));
    jsClick(El2);
    
    WebElement El4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-layout/div/div/app-checkout/div/div/div/div[2]/div[1]/form/div/div/div/div/div/app-delivery-address/div/div[2]/div[2]/fav-location-model/div/div[2]/div[2]/div[2]/button")));
    jsClick(El4);
    
    Thread.sleep(30);
    
    WebElement El3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-layout/div/div/app-checkout/div/div/div/div[2]/div[3]/div[1]/button")));
    jsClick(El3);
    
    WebElement El5 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-layout/div/div/app-payment-new/app-payment/div[1]/div/div[2]/button")));
    jsClick(El5);
    
    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-layout/div/div/app-payment-new/app-payment/div[1]/div/div[2]/button"))).click();
    
    
    
    
    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='listviewscroll']/div[3]/div/div/div/div[2]/div/p[2]"))).click();
    //WebElement element = driver.findElement(By.xpath("//*[local-name()='svg']"));
    
    //wait.until(ExpectedConditions.elementToBeClickable()).click();
    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='cart-fix']/div/button"))).click();
    
    
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
  @Test
  public void clickOnPlus() throws InterruptedException {
	  driver.get("https://hsajd.yelo.red/en/store/hsajd/1482743");
		scrollDown();
		scrollToElement(plusIcon);
		jsClick(plusIcon);
	}


  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
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
