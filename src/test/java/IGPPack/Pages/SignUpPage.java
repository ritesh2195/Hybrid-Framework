	package IGPPack.Pages;

	import IGPPack.Utilities.WaitsUtil;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;
	import IGPPack.Base.base;
	import org.openqa.selenium.support.ui.Select;

	public class SignUpPage extends base {
		
	WebDriver driver;
	//ExtentTest test;
		
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(xpath="/html[1]/body[1]/div[8]/div[1]/div[2]/div[1]/div[8]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]")
	private WebElement Password;
	
	@FindBy(name="cname")
	private WebElement Country;

	@FindBy(id = "mob")
	private WebElement Mobile;
	
	@FindBy(xpath="/html[1]/body[1]/div[8]/div[1]/div[2]/div[1]/div[8]/div[2]/div[1]/form[1]/div[6]/div[1]/button[1]")
	private WebElement Submit;
	
	@FindBy(name="fname")
	private WebElement firstName;
	
	@FindBy(name="lname")
	private WebElement lastName;
	
	@FindBy(name="dob")
	private WebElement DOB;
	
	@FindBy(xpath="//div[@aria-label='16-Sep-2001']")
	private WebElement date;

	@FindBy(xpath = "//*[@title='Select a year']")
	private WebElement dob_year;

	@FindBy(xpath = "//*[@title='Select a month']")
	private WebElement dob_month;
	
	@FindBy(xpath="//*[text()='Sign me up!']")
	private WebElement SignUp;

	WaitsUtil waitsUtil;
	
	public SignUpPage(WebDriver driver ) {
		
	this.driver=driver;

	PageFactory.initElements(driver, this);
		
	}
	
	public void setEmail(String email){

		waitsUtil = new WaitsUtil(driver,20);

		Email.clear();

		Email.sendKeys(email);

		//test.log(LogStatus.INFO, "enter email-id ");
	}

	public void setPassword(String password){

		waitsUtil.waitForVisibilityOfElement(Password);

		Password.clear();

		Password.sendKeys(password);

	}

	public void setCountry(String country){

		Country.clear();

		Country.sendKeys(country);

	}

	public void setMobileNo(String no){

		Mobile.clear();

		Mobile.sendKeys(no);

	}

	public void clickSubmit(){

		waitsUtil.waitForElementToClickable(Submit);

		Submit.click();
	}

	public void setFirstName(String fName){

		waitsUtil.waitForVisibilityOfElement(firstName);

		firstName.clear();

		firstName.sendKeys(fName);

	}

	public void setLastName(String lName){

		lastName.clear();

		lastName.sendKeys(lName);
	}

	public void setDOB(){

		DOB.click();

		waitsUtil.waitForElementToClickable(dob_year);

		Select select = new Select(dob_year);

		select.selectByVisibleText("2001");

		Select select1=new Select(dob_month);

		select1.selectByVisibleText("September");

		waitsUtil.waitForElementToClickable(date);

		date.click();

	}

	public void clickSignUp(){

		SignUp.click();
	}
		
	}
