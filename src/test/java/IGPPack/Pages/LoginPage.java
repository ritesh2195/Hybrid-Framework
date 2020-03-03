	package IGPPack.Pages;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
	
	public class LoginPage {
		
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(id="com-e-m-field")
	public WebElement loginField;
	
	@FindBy(name="passwd")
	public WebElement Password;
	
	@FindBy(xpath="//*[text()='Login']")
	public WebElement loginButton;
	
	public LoginPage(WebDriver driver,ExtentTest test) {
		
	this.driver=driver;
		
	this.test=test;
		
	PageFactory.initElements(driver, this);
	
	}
	
	public void doLogin(String loginId, String password) {
		
	loginField.sendKeys(loginId);
	
	test.log(LogStatus.INFO, "Enter email on Email Id field");
	
	Password.sendKeys(password);
	
	test.log(LogStatus.INFO, "Enter passwor on Password Field");
	
	loginButton.click();
	
	test.log(LogStatus.INFO, "Clicked on Login");
		
	}
}