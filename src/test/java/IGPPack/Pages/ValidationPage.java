package IGPPack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage {

    WebDriver driver;

    @FindBy(xpath = "//*[text()='RM']")
    private WebElement loginPageElement;

    @FindBy(xpath = "//*[text()='Place Order']")
    private WebElement searchPageElement;

    @FindBy(xpath = "//*[text()='CP']")
    private WebElement singupPageElement;

    public ValidationPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public boolean verifyLoginTest(){

        return loginPageElement.isDisplayed();
    }

    public boolean verifySearchTest(){

        return searchPageElement.isDisplayed();
    }

    public boolean verifySignUpTest(){

        return singupPageElement.isDisplayed();
    }
}
