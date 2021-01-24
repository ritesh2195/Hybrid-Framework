package IGPPack.TestCases;

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

    ReadConfig config;
    public static WebDriver driver;
    public static ExtentTest test;
    public ExtentReports report;
    public MyXLSReader1 xls;

    private final String chromeProperty = "webdriver.chrome.driver";
    private final String firefoxProperty = "webdriver.gecko.driver";

    @BeforeClass
    public void setUp(){

        String url = FileReaderManager.getInstance().getConfigReader().getURL();

        String browserType = FileReaderManager.getInstance().getConfigReader().getBrowserType();

        if(browserType.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();

            driver = new  ChromeDriver();

        } else if (browserType.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.get(url);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public static String takeScreenshot() {

        Date d=new Date();

        String screenshotFile=System.getProperty("user.dir")+"/screenshots/"+d.toString().replace(":", "_").replace(" ", "_")+".png";

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File destination=new File(screenshotFile);

        try {

            FileUtils.copyFile(scrFile,destination);

           // FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));

        } catch (IOException e) {

            e.printStackTrace();

        }

        return screenshotFile;

        //test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));

    }


    public void reportPass(String message) {

        test.log(LogStatus.PASS, message);

        if (report!=null){

            report.endTest(test);

            report.flush();
        }

    }

    public void reportFail(String message) {

        test.log(LogStatus.FAIL, message);

        takeScreenshot();

        if (report!=null){

            report.endTest(test);

            report.flush();
        }

    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }

}
