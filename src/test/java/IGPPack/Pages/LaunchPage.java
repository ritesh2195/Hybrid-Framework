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
	
	public class LaunchPage extends BasePage {

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
	
	public LaunchPage(WebDriver driver) {

		super(driver);

	    PageFactory.initElements(driver, this);
		
	}
	
	public void goLogin() {
	
	Account.click();

	waitForElementToClickable(login);

	login.click();

	}
	
	public void goSignUp() {

	waitForElementToClickable(Account);

	Account.click();

	waitForElementToClickable(SignUp);

	SignUp.click();
		
		
	}
	}
