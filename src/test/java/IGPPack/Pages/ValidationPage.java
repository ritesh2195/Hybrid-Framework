package IGPPack.Pages;

import IGPPack.Utilities.WaitsUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationPage {

    WaitsUtil waitsUtil;

    WebDriver driver;

    @FindBy(xpath = "//*[text()='RM']")
    private WebElement loginPageElement;

    @FindBy(xpath = "//*[text()='Place Order']")
    private WebElement searchPageElement;

    @FindBy(xpath = "//*[text()='CP']")
    private WebElement singupPageElement;

    @FindBy(id = "user-menu")
    private WebElement Account;

    @FindBy(xpath = "//div[@class='user-details']//p[2]")
    private WebElement email;

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

    public String verifySignUpTest(){

//        waitsUtil=new WaitsUtil(driver,20);
//
//        waitsUtil.waitForElementToClickable(Account);

        Account.click();

        return email.getText();
    }
}
