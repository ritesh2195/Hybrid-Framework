	package IGPPack.Pages;

	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
	
	public class SearchPage {
		
	WebDriver driver;
	ExtentTest test;
		
	@FindBy(name="q")
	public WebElement searchItem;
	
	@FindBy(css="*[class^='s-icon']")
	public WebElement searchBox;
	
	@FindBy(xpath="//*[text()='Black Forest Cake (Half Kg)']")
	public WebElement selectItem;
	
	@FindBy(id="location-input")
	public WebElement locationPincode;
	
	@FindBy(xpath="//*[text()='Pimpri-Chinchwad, Maharashtra 411033, India']")
	public WebElement location;
	
	@FindBy(css="*[class^='fixdate-amt']")
	public WebElement deliveryType;
	
	@FindBy(id="datepicker-fixed-date")
	public WebElement calender;
	
	@FindBy(xpath="//*[@id=\"datepicker-fixed-date_table\"]/tbody/tr[5]/td[6]/div")
	public WebElement datePicker;
	
	@FindBy(id="timepicker1")
	public WebElement selectTime;
	
	@FindBy(id="buy-now")
	public WebElement BuyNow;
	
	@FindBy(css="*[class^='c-btn-po']")
	public WebElement checkOut;
	
	@FindBy(xpath="//*[text()='Deliver Here']")
	public WebElement Delivery;
	
	public SearchPage(WebDriver driver,ExtentTest test) {
		
	this.driver=driver;
	
	this.test=test;
	
	PageFactory.initElements(driver, this);
		
	}
	
	public void searchingItem(String item, String pinCode)  {
		
	searchItem.clear();
		
	searchItem.sendKeys(item);
	
	test.log(LogStatus.INFO, "I search item");
	
	searchBox.click();
	
	test.log(LogStatus.INFO, "I click on search box");
	
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	
	selectItem.click();
	
	test.log(LogStatus.INFO, "I select item");
	
	locationPincode.clear();
	
	locationPincode.sendKeys(pinCode);
	
	test.log(LogStatus.INFO, "I enter pincode");
	
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
	
	location.click();
	
	test.log(LogStatus.INFO, "I chose address");
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
	deliveryType.click();
	
	test.log(LogStatus.INFO, "I chose delivery type");
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	
	calender.click();
	
	test.log(LogStatus.INFO, "I click on calender");
	
	datePicker.click();
	
	test.log(LogStatus.INFO, "I select date");
	
	Select select=new Select(selectTime);
	
	select.selectByVisibleText("9:00 hrs - 13:00 hrs");
	
	test.log(LogStatus.INFO, "I select timing");
	
	BuyNow.click();
	
	test.log(LogStatus.INFO, "I click on buy button");
	
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
	
	checkOut.click();
	
	test.log(LogStatus.INFO, "I checkOut");
	
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
	
	Delivery.click();
		
	}
	}
