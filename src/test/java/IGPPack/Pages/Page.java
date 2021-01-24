package IGPPack.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    public WebDriver driver;
    WebDriverWait wait;

    Page(WebDriver driver){

        this.driver = driver;
        wait = new  WebDriverWait(driver,20);

    }

    public abstract String getPageTitle();

    public abstract void waitForElementVisible(WebElement element);

    public abstract void waitForElementToClickable(WebElement element);

    public abstract void waitForPageTitle(String title);
}
