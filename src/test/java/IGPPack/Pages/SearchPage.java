	package IGPPack.Pages;

	import java.util.concurrent.TimeUnit;

	import IGPPack.Utilities.WaitsUtil;
	import org.openqa.selenium.Keys;
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
	WaitsUtil waitsUtil;
		
	@FindBy(name="q")
	private WebElement searchItem;
	
	@FindBy(xpath="//*[@class='s-icon s-panel-icon']")
	private WebElement searchBox;
	
	@FindBy(xpath="//*[text()='Black Forest Cake (Half Kg)']")
	private WebElement selectItem;
	
	@FindBy(id="location-input")
	private WebElement locationPincode;

	@FindBy(id = "pinCheck")
	private WebElement pinCodeCheck;
	
	@FindBy(xpath="//*[text()='Pimpri-Chinchwad, Maharashtra 411033, India']")
	private WebElement location;

	@FindBy(xpath = "//label[@class='sameday-amt delivery-type-text']")
	private WebElement deliveryDate;
	
	@FindBy(css="*[class^='fixdate-amt']")
	private WebElement deliveryType;
	
	@FindBy(id="datepicker-fixed-date")
	private WebElement calender;
	
	@FindBy(xpath="//*[@id=\"datepicker-fixed-date_table\"]/tbody/tr[5]/td[6]/div")
	private WebElement datePicker;
	
	@FindBy(id="timepicker_sdd")
	private WebElement selectTime;
	
	@FindBy(id="buy-now")
	private WebElement BuyNow;
	
	@FindBy(css="#enabled-button")
	private WebElement checkOut;
	
	@FindBy(css="#deliver-btn-2587230")
	private WebElement Delivery;
	
	public SearchPage(WebDriver driver) {
		
	this.driver=driver;

	PageFactory.initElements(driver, this);

	waitsUtil= new WaitsUtil(driver,10);
		
	}

	public void searchItem(String item){

	searchItem.clear();

	searchItem.sendKeys(item);

	waitsUtil.waitForElementToClickable(searchBox);

	searchBox.click();

	}

	public void selectProduct(){

	waitsUtil.waitForElementToClickable(selectItem);

	selectItem.click();

	}

	public void setDeliveryDetails(String pincode){

		//locationPincode.sendKeys(pincode);

		locationPincode.sendKeys(Keys.ENTER);

		locationPincode.sendKeys(pincode);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//pinCodeCheck.click();

		deliveryDate.click();

		waitsUtil.waitForVisibilityOfElement(selectTime);

		Select select=new Select(selectTime);

		select.selectByVisibleText("13:00 hrs - 17:00 hrs");

		BuyNow.click();

	}

	public void checkOutProduct(){

		waitsUtil.waitForVisibilityOfElement(checkOut);

		checkOut.click();
	}

	public void setDelivery(){

		waitsUtil.waitForVisibilityOfElement(Delivery);

		Delivery.click();
	}

	public String getText(){

		return selectItem.getText();
	}

	}
