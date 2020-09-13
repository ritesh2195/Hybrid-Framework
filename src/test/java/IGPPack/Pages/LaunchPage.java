  package IGPPack.Pages;

	import IGPPack.Utilities.WaitsUtil;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	
	public class LaunchPage {
		
	WebDriver driver;
	ExtentTest test;
	WaitsUtil waitsUtil;
	
	@FindBy(name="q")
	private WebElement SearchBox;
	
	@FindBy(className="s-panel-icon")
	private WebElement SearchButton;
	
	@FindBy(id="user-menu")
	private WebElement Account;
	
	@FindBy(css="*[class^='click-listener']")
	private WebElement login;
	
	@FindBy(xpath="//*[text()='New User? Sign Up']")
	private WebElement SignUp;
	
	public LaunchPage(WebDriver driver,ExtentTest test) {
		
	this.driver=driver;
	
	this.test=test;
	
	PageFactory.initElements(driver, this);
		
	}
	
	public void goLogin() {
	
	Account.click();
	
	test.log(LogStatus.INFO, "Clicked on Account BUtton");
	
 	WebDriverWait wait=new WebDriverWait(driver, 20);
    
    wait.until(ExpectedConditions.elementToBeClickable(login));
	
	login.click();
	
	test.log(LogStatus.INFO, "Clicked on Login Button");
			
	}
	
	public void goSignUp() {

	waitsUtil =new WaitsUtil(driver,10);
		
	Account.click();

	waitsUtil.waitForElementToClickable(SignUp);
	
	//WebDriverWait wait = new WebDriverWait(driver, 10);
	 
	//SignUp = wait.until(ExpectedConditions.elementToBeClickable(SignUp));
	
	SignUp.click();
		
		
	}
	}
