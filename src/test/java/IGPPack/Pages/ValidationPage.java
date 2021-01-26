package IGPPack.Pages;

import IGPPack.Utilities.WaitsUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage extends BasePage {

    @FindBy(xpath = "//div[@class='icon-wrapper top-action-icons quick-menu']//p")
    private WebElement loginPageElement;

    @FindBy(xpath = "//div[@class='submit_msg has_error']")
    private WebElement failLogin;

    @FindBy(xpath = "//*[text()='Place Order']")
    private WebElement searchPageElement;

    @FindBy(className = "pdp-product-name")
    private WebElement textElement;

    @FindBy(xpath = "//*[text()='CP']")
    private WebElement singupPageElement;

    @FindBy(id = "user-menu")
    private WebElement Account;

    @FindBy(xpath = "//div[@class='user-details']//p[2]")
    private WebElement email;

    @FindBy(xpath = "//div[@class='user-details']//p[1]")
    private WebElement name;

    public ValidationPage(WebDriver driver){

        super(driver);

        PageFactory.initElements(driver, this);
    }

    public boolean verifySuccessLoginTest(){

        waitForElementVisible(loginPageElement);

        return loginPageElement.isDisplayed();
    }

    public boolean verifyFailedLoginTest(){

        waitForElementVisible(failLogin);

        return failLogin.isDisplayed();
    }

    public boolean verifySearchTest(){

        return searchPageElement.isDisplayed();
    }

    public String verifySignUpEmail(){

        waitForElementToClickable(Account);

        Account.click();

        waitForElementVisible(email);

        return email.getText();
    }

    public String verifySignName(){

        waitForElementVisible(name);

        return name.getText();
    }

    public String validateText(){

        waitForElementVisible(textElement);

        return textElement.getText();
    }
}
