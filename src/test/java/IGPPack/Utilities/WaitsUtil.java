package IGPPack.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsUtil {

    WebDriverWait wait;
    WebDriver driver;

    public WaitsUtil(WebDriver driver, int time){

        this.driver=driver;

        wait =new WebDriverWait(driver, time);

    }

    public void waitForVisibilityOfElement(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToClickable(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForInvisibilityOfElement(WebElement element){

        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
