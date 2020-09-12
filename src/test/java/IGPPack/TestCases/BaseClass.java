package IGPPack.TestCases;

import IGPPack.Utilities.MyXLSReader1;
import IGPPack.Utilities.ReadConfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
    public WebDriver driver;
    public ExtentTest test;
    public ExtentReports report;
    public MyXLSReader1 xls;

    private final String chromeProperty = "webdriver.chrome.driver";
    private final String firefoxProperty = "webdriver.gecko.driver";

    @BeforeClass
    public void setUp(){

        config = new ReadConfig();

        if(config.getBrowserType().equalsIgnoreCase("chrome")){

            System.setProperty(chromeProperty, config.getChromePath());

            driver = new  ChromeDriver();

        } else if (config.getBrowserType().equalsIgnoreCase("firefox")){

            System.setProperty(firefoxProperty, config.getFirefoxPath());

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.get(config.getURL());

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void takeScreenshot() {

        Date d=new Date();

        String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(scrFile, new File("screenshots//"+screenshotFile));

        } catch (IOException e) {

            e.printStackTrace();

        }

        test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));

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
