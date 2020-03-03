	package IGPPack.Base;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Date;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	import IGPPack.Utilities.MyXLSReader1;
	
	public class base {
		
	public Properties prop;
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	public MyXLSReader1 xls;
		
	public void readPropertyFile() {
		
	if(prop==null) {
		
	prop=new Properties();
	
	File file=new File("src//test//resources//Locators.properties");
	
	try {
	
	FileInputStream fis=new FileInputStream(file);
	
	prop.load(fis);
	
	}catch (Exception e) {
		
	e.printStackTrace();
	
	}
		
	}
		
	}
	
	public void openingBrowser(String browser) {
		
	if(browser.equalsIgnoreCase("chrome")) {
		
	System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
	
	options.addArguments("--disable-popup-blocking");
	
	options.addArguments("--disable-infobars");
	
	options.addArguments("--no-sandbox");
	
	driver=new ChromeDriver(options);
		
	}
	
	else if(browser.equalsIgnoreCase("firefox")) {
		
	System.setProperty("webdriver.gecko.driver", "drivers//geckodriver.exe");	
	
	driver=new FirefoxDriver();
		
	}
	
	driver.manage().window().maximize();
		
	}
	
	public void navigate(String url) {
		
	String URL=prop.getProperty(url);
	
	driver.get(URL);
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public boolean isElementPresent() {
		
	boolean status=driver.findElement(By.xpath("//*[text()='RM']")).isDisplayed();	
		
	if(status==true) {
		
	return true;
	
	}else {
		
		return false;
	}
		
	}
	
	public boolean isSearchPageElementPresent() {
		
	WebElement element=driver.findElement(By.xpath("//*[text()='Place Order']"));
	
	if(element.isDisplayed()) {
		
	return true;	
		
	} else {
		
		return false;
	}
		
		
	}
	
	public boolean verifyingSignUp() {
		
	WebElement element=driver.findElement(By.xpath("//*[text()='CP']"));
	
	if(element.isDisplayed()) {
		
	return true;	
		
	}else {
		
		return false;
	}
		
	}
	
	public void reportPass(String message) {
		
	test.log(LogStatus.PASS, message);	
		
	}
	
	public void reportFail(String message) {
		
	test.log(LogStatus.FAIL, message);	
	
	takeScreenshot();
	
	Assert.fail(message);
		
	}
	
	public void takeScreenshot() {
		
	Date d=new Date();
		
	String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	try {
			
	FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));
		
	} catch (IOException e) {
			
	e.printStackTrace();
		
	}
			
	test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
			
		}
	}
