  package IGPPack.Pages;

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
	
	@FindBy(name="q")
	public WebElement SearchBox;
	
	@FindBy(className="s-panel-icon")
	public WebElement SearchButton;
	
	@FindBy(id="user-menu")
	public WebElement Account;
	
	@FindBy(css="*[class^='click-listener']")
	public WebElement login;
	
	@FindBy(xpath="//*[text()='New User? Sign Up']")
	public WebElement SignUp;
	
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
		
	Account.click();
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	 
	SignUp = wait.until(ExpectedConditions.elementToBeClickable(SignUp));
	
	SignUp.click();
		
		
	}
	}
