package IGPPack.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    /*
     * Factory method for getting browsers
     */
    public static WebDriver getBrowser(String browserName) {

        WebDriver driver = null;

        switch (browserName) {

        case "Firefox":

        driver = drivers.get("Firefox");

        if (driver == null) {

        WebDriverManager.firefoxdriver().setup();

        driver = new FirefoxDriver();

        drivers.put("Firefox", driver);

        }

        break;

        case "IE":

         driver = drivers.get("IE");

         if (driver == null) {

         WebDriverManager.iedriver().setup();

         driver = new InternetExplorerDriver();

         drivers.put("IE", driver);
         }

         break;

         case "Chrome":

         driver = drivers.get("Chrome");

         if (driver == null) {

         WebDriverManager.chromedriver().setup();

         driver = new ChromeDriver();

         drivers.put("Chrome", driver);
         }

         break;

        }
        return driver;
    }

    public static void closeAllDriver() {

        for (String key : drivers.keySet()) {

        drivers.get(key).close();

        drivers.get(key).quit();
  }
}
}
