	package IGPPack.Pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;

	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;

	public class SignUpPage extends BasePage {

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

	@FindBy(id = "user-menu")
	private WebElement UserMenu;

	@FindAll(@FindBy(xpath = "//div[@class='user-details']//p"))
	private List<WebElement> UserDetails;

	public SignUpPage(WebDriver driver ) {

		super(driver);

		PageFactory.initElements(driver, this);
		
	}
	
	public void setEmail(String email){

		Email.clear();

		Email.sendKeys(email);
	}

	public void setPassword(String password){

		waitForElementVisible(Password);

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

		waitForElementVisible(Submit);

		Submit.click();
	}

	public void setFirstName(String fName){

		waitForElementVisible(firstName);

		firstName.clear();

		firstName.sendKeys(fName);

	}

	public void setLastName(String lName){

		lastName.clear();

		lastName.sendKeys(lName);
	}

	public void setDOB(){

		DOB.click();

		waitForElementVisible(dob_year);

		Select select = new Select(dob_year);

		select.selectByVisibleText("2001");

		Select select1=new Select(dob_month);

		select1.selectByVisibleText("September");

		waitForElementToClickable(date);

		date.click();

	}

	public void clickSignUp(){

		SignUp.click();
	}

	public List<String> verifySignUpTest(){

		waitForElementToClickable(UserMenu);

		UserMenu.click();

		List<String> list = new ArrayList<>();

		Iterator<WebElement> iterator = UserDetails.iterator();

		while (iterator.hasNext()){

			WebElement element = iterator.next();

			waitForElementVisible(element);

			list.add(element.getText());
		}

		return list;

	}
		
	}
