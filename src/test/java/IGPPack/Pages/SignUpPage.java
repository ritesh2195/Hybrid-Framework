	package IGPPack.Pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	import IGPPack.Base.base;
	
	public class SignUpPage extends base {
		
	WebDriver driver;
	ExtentTest test;
		
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(name="cname")
	private WebElement country;
	
	@FindBy(xpath="//*[text()='Submit']")
	private WebElement submit;
	
	@FindBy(name="fname")
	private WebElement firstName;
	
	@FindBy(name="lname")
	private WebElement lasttName;
	
	@FindBy(name="dob")
	private WebElement DOB;
	
	@FindBy(xpath="//*[@id=\"P974976583_table\"]/tbody/tr[4]/td[6]/div")
	private WebElement date;
	
	@FindBy(xpath="//*[text()='Sign me up!']")
	private WebElement SignUp;
	
	public SignUpPage(WebDriver driver,ExtentTest test ) {
		
	this.driver=driver;
	
	this.test=test;
	
	PageFactory.initElements(driver, this);
		
	}
	
	public void doSignUp() {
		
	readPropertyFile();
		
	Email.sendKeys(prop.getProperty("email-id"));
	
	test.log(LogStatus.INFO, "enter email-id ");
	
	password.sendKeys(prop.getProperty("Password"));
	
	test.log(LogStatus.INFO, "enter password");
	
	country.sendKeys(prop.getProperty("Country"));
	
	test.log(LogStatus.INFO, "enter country name");
	
	submit.click();
	
	test.log(LogStatus.INFO, "click on submit button");
	
	firstName.sendKeys(prop.getProperty("First-Name"));
	
	test.log(LogStatus.INFO, "enter first name");
	
	lasttName.sendKeys(prop.getProperty("Last-Name"));
	
	test.log(LogStatus.INFO, "enter last name");
	
	DOB.click();
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	date.click();
	
	test.log(LogStatus.INFO, "enter date of birth");

	SignUp.click();
	
	test.log(LogStatus.INFO, "click on SignUp ");
		
	}
		
	}
