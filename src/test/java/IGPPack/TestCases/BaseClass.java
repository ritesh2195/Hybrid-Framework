package IGPPack.TestCases;

import IGPPack.Utilities.BrowserFactory;
import IGPPack.Utilities.MyXLSReader1;
import IGPPack.Utilities.ReadConfig;
import IGPPack.managers.FileReaderManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public MyXLSReader1 xls;

    private final String chromeProperty = "webdriver.chrome.driver";
    private final String firefoxProperty = "webdriver.gecko.driver";

    @BeforeMethod
    public void setUp(){

        String url = FileReaderManager.getInstance().getConfigReader().getURL();

        String browserType = FileReaderManager.getInstance().getConfigReader().getBrowserType();

        //driver =BrowserFactory.getBrowser(browserType);

        if(browserType.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();

            driver = new  ChromeDriver();

        } else if (browserType.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.get(url);
    }

    public static String takeScreenshot() {

        Date d=new Date();

        String screenshotFile=System.getProperty("user.dir")+"/screenshots/"+d.toString().replace(":", "_").replace(" ", "_")+".png";

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File destination=new File(screenshotFile);

        try {

            FileUtils.copyFile(scrFile,destination);


        } catch (IOException e) {

            e.printStackTrace();

        }

        return screenshotFile;

    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
