	package IGPPack.Pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class LoginPage {
		
	WebDriver driver;
	ExtentTest test;
	WebDriverWait wait;
	
	@FindBy(id="com-e-m-field")
	private WebElement loginField;
	
	@FindBy(name="passwd")
	private WebElement Password;
	
	@FindBy(xpath="//*[text()='Login']")
	private WebElement loginButton;

	@FindBy(xpath="//*[text()='RM']")
	private WebElement AccountButton;

	@FindBy(xpath = "//*[text()='logout']")
	private WebElement logout;

	@FindBy(xpath = "//span[@id='nav-close']//div[@class='icon-wrapper']")
	private WebElement homePage;

	@FindBy(id="user-menu")
	private WebElement Account;
	
	public LoginPage(WebDriver driver,ExtentTest test) {
		
	this.driver=driver;
		
	this.test=test;

	PageFactory.initElements(driver, this);
	
	}
	
	public void doLogin(String loginId, String password) {
		
	WebDriverWait wait=new WebDriverWait(driver, 20);
	
	wait.until(ExpectedConditions.visibilityOf(loginField));

	loginField.clear();
		
	loginField.sendKeys(loginId);

	Password.clear();
	
	Password.sendKeys(password);

	loginButton.click();

	}

	 public void doLogin() {

	 WebDriverWait wait=new WebDriverWait(driver, 20);

	 wait.until(ExpectedConditions.visibilityOf(loginField));

	 loginField.clear();

	 loginField.sendKeys("");

	 Password.clear();

	 Password.sendKeys("");

	 loginButton.click();

	}

	public void doLogin(String loginId) {

	WebDriverWait wait=new WebDriverWait(driver, 20);

	wait.until(ExpectedConditions.visibilityOf(loginField));

	loginField.clear();

	loginField.sendKeys(loginId);

	Password.clear();

	Password.sendKeys("");

	loginButton.click();

	}

	public void Logout(){

	wait = new WebDriverWait(driver,10);

	wait.until(ExpectedConditions.visibilityOf(AccountButton));

	AccountButton.click();

	wait.until(ExpectedConditions.visibilityOf(logout));

	logout.click();
	}

	public void navigateHomePage(){

	wait = new WebDriverWait(driver,10);

	//wait.until(ExpectedConditions.invisibilityOf(Account));

	wait.until(ExpectedConditions.elementToBeClickable(homePage));

	homePage.click();

	}
}
