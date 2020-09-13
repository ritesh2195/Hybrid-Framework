package IGPPack.managers;

import IGPPack.Pages.*;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private LaunchPage launchPage;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private SignUpPage signUpPage;
    private ValidationPage validationPage;
    private WebDriver driver;
    private ExtentTest test;

    public PageObjectManager(WebDriver driver, ExtentTest test){

        this.driver = driver;
        this.test = test;
    }

    public LaunchPage getLaunchPage(){

        return (launchPage==null) ? launchPage = new LaunchPage(driver,test) : launchPage;
    }

    public LoginPage getLoginPage(){

        return (loginPage==null) ? loginPage = new LoginPage(driver,test) : loginPage;
    }

    public SearchPage getSearchPage(){

        return (searchPage==null) ? searchPage = new SearchPage(driver,test) : searchPage;
    }

    public SignUpPage getSignUpPage(){

        return (signUpPage==null) ? signUpPage = new SignUpPage(driver,test) : signUpPage;
    }

    public ValidationPage getValidationPage(){

        return (validationPage==null) ? validationPage = new ValidationPage(driver) : validationPage;
    }
}
