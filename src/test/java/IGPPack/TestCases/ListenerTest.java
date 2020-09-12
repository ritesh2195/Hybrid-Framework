package IGPPack.TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenerTest implements ITestListener {

    ExtentHtmlReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void onStart(ITestContext testContext) {

     String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

     String repName="Test-Report-"+timeStamp+".html";

     htmlReporter = new ExtentHtmlReporter( System.getProperty("user.dir")+"/ExtentReports/"+repName);

     htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");

     reports = new ExtentReports();

     reports.attachReporter(htmlReporter);

     reports.setSystemInfo("HostName","localhost");

     reports.setSystemInfo("Environment","QA");

     reports.setSystemInfo("User","Ritesh");

     htmlReporter.config().setDocumentTitle("IGP Test Report");

     htmlReporter.config().setReportName("Function Test");

     htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

     htmlReporter.config().setTheme(Theme.DARK);

    }

    public void onTestSuccess(ITestResult result){

      test = reports.createTest(result.getName());

      test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

    }

    public void onTestFailure(ITestResult result){

      test = reports.createTest(result.getName());

      test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));

      test.log(Status.FAIL,result.getThrowable());

      Date d=new Date();

      String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";

        try {

        test.addScreenCaptureFromPath(screenshotFile);

        } catch (IOException e) {

            e.printStackTrace();
        }

        String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";

      File file = new File(screenshotPath);

        if(file.exists())
        {
        try {

         test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));

         } catch (IOException e) {

         e.printStackTrace();

            }
        }


    }

    public void onTestSkipped(ITestResult result){

    test = reports.createTest(result.getName());

    test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));

    }

    public void onFinish(ITestContext testContext){

        reports.flush();

    }
}