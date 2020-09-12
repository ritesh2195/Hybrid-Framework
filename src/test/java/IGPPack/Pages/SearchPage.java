	package IGPPack.Pages;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class SearchPage {
		
	WebDriver driver;
	ExtentTest test;
		
	@FindBy(name="q")
	private WebElement searchItem;
	
	@FindBy(css="*[class^='s-icon']")
	private WebElement searchBox;
	
	@FindBy(xpath="//*[text()='Black Forest Cake (Half Kg)']")
	private WebElement selectItem;
	
	@FindBy(id="location-input")
	private WebElement locationPincode;
	
	@FindBy(xpath="//*[text()='Pimpri-Chinchwad, Maharashtra 411033, India']")
	private WebElement location;
	
	@FindBy(css="*[class^='fixdate-amt']")
	private WebElement deliveryType;
	
	@FindBy(id="datepicker-fixed-date")
	private WebElement calender;
	
	@FindBy(xpath="//*[@id=\"datepicker-fixed-date_table\"]/tbody/tr[5]/td[6]/div")
	private WebElement datePicker;
	
	@FindBy(id="timepicker1")
	private WebElement selectTime;
	
	@FindBy(id="buy-now")
	private WebElement BuyNow;
	
	@FindBy(css="*[class^='c-btn-po']")
	private WebElement checkOut;
	
	@FindBy(xpath="//*[text()='Deliver Here']")
	private WebElement Delivery;
	
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
	
	WebDriverWait wait=new WebDriverWait(driver, 30);
    
   	wait.until(ExpectedConditions.elementToBeClickable(selectItem));
	
	selectItem.click();
	
	test.log(LogStatus.INFO, "I select item");
	
	locationPincode.clear();
	
	locationPincode.sendKeys(pinCode);
	
	test.log(LogStatus.INFO, "I enter pincode");
	
	wait.until(ExpectedConditions.elementToBeClickable(location));
	
	location.click();
	
	test.log(LogStatus.INFO, "I chose address");
	
	wait.until(ExpectedConditions.elementToBeClickable(deliveryType));
		
	deliveryType.click();
	
	test.log(LogStatus.INFO, "I chose delivery type");
	
	wait.until(ExpectedConditions.elementToBeClickable(calender));
	
	calender.click();
	
	test.log(LogStatus.INFO, "I click on calender");
	
	datePicker.click();
	
	test.log(LogStatus.INFO, "I select date");
	
	Select select=new Select(selectTime);
	
	select.selectByVisibleText("9:00 hrs - 13:00 hrs");
	
	test.log(LogStatus.INFO, "I select timing");
	
	BuyNow.click();
	
	test.log(LogStatus.INFO, "I click on buy button");
	
	wait.until(ExpectedConditions.elementToBeClickable(checkOut));
	
	checkOut.click();
	
	test.log(LogStatus.INFO, "I checkOut");
	
	wait.until(ExpectedConditions.elementToBeClickable(Delivery));
	
	Delivery.click();
		
	}
	}
