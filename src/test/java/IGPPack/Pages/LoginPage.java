	package IGPPack.Pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class LoginPage extends BasePage {

	@FindBy(id="com-e-m-field")
	private WebElement loginField;
	
	@FindBy(name="passwd")
	private WebElement Password;
	
	@FindBy(xpath="//*[text()='Login']")
	private WebElement loginButton;

	@FindBy(xpath="//div[@class='icon-wrapper top-action-icons quick-menu']//p")
	private WebElement AccountButton;

	@FindBy(xpath = "//div[@class='user-details']//p[2]")
	private WebElement Email;

	@FindBy(xpath = "//*[text()='logout']")
	private WebElement logout;

	@FindBy(xpath = "//span[@id='nav-close']//div[@class='icon-wrapper']")
	private WebElement homePage;

	@FindBy(id="user-menu")
	private WebElement Account;
	
	public LoginPage(WebDriver driver,ExtentTest test) {

		super(driver);

		PageFactory.initElements(driver, this);
	
	}
	
	public void doLogin(String loginId, String password) {

	waitForElementToClickable(loginField);

	loginField.clear();
		
	loginField.sendKeys(loginId);

	Password.clear();
	
	Password.sendKeys(password);

	waitForElementToClickable(loginButton);

	loginButton.click();

	}

	 public void doLogin() {

	 waitForElementToClickable(loginField);

	 loginField.clear();

	 loginField.sendKeys("");

	 Password.clear();

	 Password.sendKeys("");

	 loginButton.click();

	}

	public void doLogin(String loginId) {

	waitForElementToClickable(loginField);

	loginField.clear();

	loginField.sendKeys(loginId);

	Password.clear();

	Password.sendKeys("");

	loginButton.click();

	}

	public String getEmail(){

	waitForElementToClickable(AccountButton);

	AccountButton.click();

	waitForElementVisible(Email);

	return Email.getText();

	}

	public void navigateHomePage(){

	waitForElementToClickable(homePage);

	homePage.click();

	}
}
